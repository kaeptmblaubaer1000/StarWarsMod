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
            lImports.Require("net.minecraft.block.Block");
            lImports.Require("net.minecraft.world.World");
            lImports.Require("com.parzivail.util.world.WorldUtils");

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
            foreach (var nbtTag in schematic.GetTileEntities().Where(nbtTag => ((NbtCompound)nbtTag)["x"].IntValue >= chunkX && ((NbtCompound)nbtTag)["x"].IntValue < chunkX + 16 && ((NbtCompound)nbtTag)["z"].IntValue >= chunkZ && ((NbtCompound)nbtTag)["z"].IntValue < chunkZ + 16))
            {
                var t = (NbtCompound)nbtTag;
                var x = t["x"].IntValue;
                var y = t["y"].IntValue;
                var z = t["z"].IntValue;

                if (t["id"].StringValue != "Chest") continue;

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
                        if (schematic.GetFlagAt(x, y, z) || (schematic.GetBlockAt(x, y, z).GetName() == "air" && Arguments.IgnoreAirBlocks))
                            continue;

                        gen.Append(JavaBuilder.MakeSetBlockLine(schematic, ref lImports, x, y, z, chunkX, chunkZ));
                        numStatements++;
                        //Console.WriteLine(schematic.getBlockIdAt(x, y, z));

                        if (numStatements <= Exporter.MaxBlocksPerGen) continue;

                        numStatements = 0;
                        currentGen++;
                        gen.AppendLine(JavaBuilder.MakeCallGen(currentGen));
                        gen.AppendLine("\t\treturn true;");
                        gen.AppendLine("\t}");
                        gen.AppendLine();
                        gen.AppendLine(JavaBuilder.MakeGen(currentGen));
                        gen.AppendLine("\t{");
                    }

            // Sort imports
            lImports.Sort();
            foreach (var s in lImports)
                imports.AppendLine(string.Format("import {0};", s));

            Console.ForegroundColor = ConsoleColor.Blue;
            swIterate.Stop();
            Console.Write(Utils.MillisToHrd(swIterate.ElapsedMilliseconds).PadRight(10));

            gen.Append(tiles);

            gen.AppendLine("\t\treturn true;");
            gen.AppendLine("\t}");

            // Replace template placeholders with true data
            template = template.Replace("{{CLASS_COMMENT}}", Exporter.HeaderComment());
            template = template.Replace("{{PACKAGE}}", options.Package);
            template = template.Replace("{{CLASS}}", string.Format(options.ClassName, string.Format("_x{0}_z{1}", chunkX, chunkZ)));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            var blocks = currentGen*Exporter.MaxBlocksPerGen + numStatements;

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(string.Format("{0:n0}", blocks).PadRight(10));
            Console.Write(string.Format("{0:n0}", totalTiles).PadRight(10));
            Console.Write(string.Format("{0:n0}", (currentGen + 1)).PadRight(10));
            swIterate.Restart();

            Metrics.TotalBlocks += blocks;
            Metrics.TotalTiles += totalTiles;

            // Write data to file
            if (!Directory.Exists("output/" + options.Path))
                Directory.CreateDirectory("output/" + options.Path);
            using (var w = new StreamWriter("output/" + options.Path + "/" + string.Format(options.FileName, string.Format("_x{0}_z{1}", chunkX, chunkZ))))
                w.WriteLine(template);

            swIterate.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.MillisToHrd(swIterate.ElapsedMilliseconds).PadRight(10));

            swOverall.Stop();
            Console.Write(Utils.MillisToHrd(swOverall.ElapsedMilliseconds).PadRight(10));

            var isize = File.ReadAllBytes("output/" + options.Path + "/" +
                                          string.Format(options.FileName, string.Format("_x{0}_z{1}", chunkX, chunkZ)))
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
