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
        public static void Export(ExportOptions options, Schematic schematic, int chunkX, int chunkZ)
        {
            if (!File.Exists("template.java"))
            {
                Console.WriteLine("Unable to locate template.java");
                Console.ReadKey();
                Environment.Exit(0);
            }

            Console.ForegroundColor = ConsoleColor.White;
            Console.Write(string.Format("{0}{1}", Utils.UpperFirst(string.Format(options.ClassName, string.Format("_x{0}_z{1}", chunkX, chunkZ))), File.Exists("output/" + options.FileName) ? "*" : "").PadRight(40));

            // Load the java template
            var template = File.ReadAllText("template.java");
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
            var tag = 0;
            foreach (var nbtTag in schematic.GetTileEntities().Where(nbtTag => ((NbtCompound)nbtTag)["x"].IntValue >= chunkX && ((NbtCompound)nbtTag)["x"].IntValue < chunkX + 16 && ((NbtCompound)nbtTag)["z"].IntValue >= chunkZ && ((NbtCompound)nbtTag)["z"].IntValue < chunkZ + 16))
            {
                var t = (NbtCompound)nbtTag;
                var x = t["x"].IntValue;
                var y = t["y"].IntValue;
                var z = t["z"].IntValue;

                if (t["id"].StringValue != "Chest") continue;

                tiles.Append(JavaBuilder.MakeChest(ref schematic, ref lImports, tag, x, y, z, "\t\t"));
                tag++;
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
                        if (schematic.GetFlagAt(x, y, z) || (schematic.GetBlockAt(x, y, z).GetName() == "air" && Program.IgnoreAirBlocks))
                            continue;

                        gen.Append(JavaBuilder.MakeSetBlockLine(schematic, ref lImports, x, y, z));
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
            template = template.Replace("{{PACKAGE}}", options.Package);
            template = template.Replace("{{CLASS}}", Utils.UpperFirst(string.Format(options.ClassName, string.Format("_x{0}_z{1}", chunkX, chunkZ))));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write((currentGen * Exporter.MaxBlocksPerGen + numStatements).ToString().PadRight(10));
            Console.Write(tag.ToString().PadRight(10));
            Console.Write((currentGen + 1).ToString().PadRight(10));
            swIterate.Restart();

            // Write data to file
            using (var w = new StreamWriter("output/" + string.Format(options.FileName, string.Format("_x{0}_z{1}", chunkX, chunkZ))))
                w.WriteLine(template);

            swIterate.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.MillisToHrd(swIterate.ElapsedMilliseconds).PadRight(10));

            swOverall.Stop();
            Console.Write(Utils.MillisToHrd(swOverall.ElapsedMilliseconds).PadRight(10));

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(Utils.SizeSuffix(File.ReadAllBytes("output/" + string.Format(options.FileName, string.Format("_x{0}_z{1}", chunkX, chunkZ))).Length).PadRight(10));

            Console.WriteLine();
        }
    }
}
