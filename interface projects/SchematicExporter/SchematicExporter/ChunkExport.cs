using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using fNbt;

namespace SchematicExporter
{
    class ChunkExport
    {
        /// <summary>
        /// Exports a single chunk
        /// </summary>
        /// <param name="options">The export options</param>
        /// <param name="schematic">The schematic to export</param>
        /// <param name="chunkX">The chunk X to export</param>
        /// <param name="chunkZ">The chunk Y to export</param>
        public static void Export(ExportOptions options, Schematic schematic, int chunkX, int chunkZ)
        {
            if (!Directory.Exists("template/"))
                Directory.CreateDirectory("template/");

            Console.ForegroundColor = ConsoleColor.White;
            string clazz = string.Format(options.ClassName, string.Format("_x{0}_z{1}", chunkX, chunkZ));
            Console.Write((clazz.Length <= 38 ? clazz : "..." + clazz.Substring(clazz.Length - 35, 35)).PadRight(40));

            // Load the java template
            var template = Utils.RequireFile(string.Format("template/{0}", Arguments.UseTemplate)).ReadToEnd();
            Console.ForegroundColor = ConsoleColor.Green;

            var gen = new StringBuilder();
            var tiles = new StringBuilder();
            var imports = new StringBuilder();
            var lImports = new List<string>();

            // Load primary imports
            lImports.Require("net.minecraft.world.World");
            lImports.Require("static com.parzivail.util.world.WorldUtils.b");
            lImports.Require("static com.parzivail.util.world.WorldUtils.m");

            var numStatements = 0;
            var currentGen = 0;

            // Start an overall timer
            var swOverall = new Stopwatch();
            swOverall.Start();

            // Start an iterate timer
            var swIterate = new Stopwatch();
            swIterate.Start();

            // Iterate over tile entities
            var totalTiles = 0;
            var l = schematic.GetTileEntities();
            for (var i = 0; i < l.Count; i++)
            {
                var t = (NbtCompound)l[i];
                var x = t["x"].IntValue;
                var y = t["y"].IntValue;
                var z = t["z"].IntValue;

                if (t["id"].StringValue != "Chest" || !(x >= chunkX &&
                                                        x < chunkX + 16 &&
                                                        z >= chunkZ &&
                                                        z < chunkZ + 16)) continue;

                tiles.Append(JavaBuilder.MakeChest(ref schematic, ref lImports, totalTiles, x, y, z, "\t\t"));
                totalTiles++;
            }

            // Iterate over blocks
            gen.AppendLine(JavaBuilder.MakeGen(currentGen));
            gen.AppendLine("\t{");
            for (var x = chunkX; x < chunkX + 16; x++)
                for (var y = 0; y < schematic.Height; y++)
                    for (var z = chunkZ; z < chunkZ + 16; z++)
                    {
                        if (x >= schematic.Width || z >= schematic.Length)
                            continue;

                        var b = schematic.GetBlockAt(x, y, z);

                        if (schematic.GetFlagAt(x, y, z) ||
                            (b.GetName() == "air" && Arguments.IgnoreAirBlocks))
                            continue;

                        lImports.Require("static " + b.CreateJavaVariable());
                        gen.Append(JavaBuilder.MakeSetBlockLine(schematic, ref lImports, x, y, z, chunkX, chunkZ));
                        numStatements++;
                        //Console.WriteLine(schematic.getBlockIdAt(x, y, z));

                        if (numStatements <= Exporter.MaxBlocksPerGen) continue;

                        numStatements = 0;
                        currentGen++;
                        gen.AppendLine(JavaBuilder.MakeCallGen(currentGen));
                        gen.AppendLine("\t}");
                        gen.AppendLine(JavaBuilder.MakeGen(currentGen));
                        gen.AppendLine("\t{");
                    }

            // Sort imports
            lImports.Sort();
            for (var i = 0; i < lImports.Count; i++)
                imports.AppendFormat("import {0};\r\n", lImports[i]);

            swIterate.Stop();
            var iterateElapsed = swIterate.ElapsedMilliseconds;

            gen.Append(tiles);

            gen.AppendLine("\t}");

            // Replace template placeholders with true data
            template = template.Replace("{{CLASS_COMMENT}}", Exporter.HeaderComment());
            template = template.Replace("{{PACKAGE}}", options.Package);
            template = template.Replace("{{CLASS}}",
                new StringBuilder().AppendFormat(options.ClassName, new StringBuilder().AppendFormat("_x{0}_z{1}", chunkX, chunkZ)).ToString());
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            var blocks = currentGen*Exporter.MaxBlocksPerGen + numStatements;

            swIterate.Restart();

            Metrics.TotalBlocks += blocks;
            Metrics.TotalTiles += totalTiles;

            // Write data to file
            using (
                var w =
                    new StreamWriter("output/" + options.Path + "/" +
                                     new StringBuilder().AppendFormat(options.FileName, new StringBuilder().AppendFormat("_x{0}_z{1}", chunkX, chunkZ))))
                w.WriteLine(template);

            swIterate.Stop();
            swOverall.Stop();

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.MillisToHrd(iterateElapsed).PadRight(10));

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write("{0}{1}{2}", new StringBuilder().AppendFormat("{0:n0}", blocks).ToString().PadRight(10),
                new StringBuilder().AppendFormat("{0:n0}", totalTiles).ToString().PadRight(10), new StringBuilder().AppendFormat("{0:n0}", currentGen + 1).ToString().PadRight(10));

            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write("{0}{1}", Utils.MillisToHrd(swIterate.ElapsedMilliseconds).PadRight(10),
                Utils.MillisToHrd(swOverall.ElapsedMilliseconds).PadRight(10));

            var isize = File.ReadAllBytes("output/" + options.Path + "/" +
                                          new StringBuilder().AppendFormat(options.FileName, new StringBuilder().AppendFormat("_x{0}_z{1}", chunkX, chunkZ)))
                .Length;

            Metrics.TotalFilesize += isize;

            var size =
                Utils.SizeSuffix(
                    isize);
            if (size.Contains("MB"))
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Metrics.FilesOverOneMeg++;
            }
            else
                Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(size.PadRight(10));

            Console.WriteLine();
        }
    }
}
