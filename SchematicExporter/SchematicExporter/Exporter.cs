using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Text;
using fNbt;

namespace SchematicExporter
{
    internal class Exporter
    {
        /// <summary>
        /// Maximum blocks/lines per generation statement
        /// </summary>
        public const int MaxBlocksPerGen = 500;

        /// <summary>
        /// Exports the given schematic following the given export options
        /// </summary>
        /// <param name="options">The export options</param>
        /// <param name="schematic">The schematic to export</param>
        public static void Export(ExportOptions options, Schematic schematic)
        {
            // Check if the template exists
            if (!File.Exists("template.java"))
            {
                Console.WriteLine("Unable to locate template.java");
                Console.ReadKey();
                Environment.Exit(0);
            }
            
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

            // Start an iterate timer
            var swIterate = new Stopwatch();
            swIterate.Start();

            // Iterate over tile entities
            var tag = 0;
            foreach (var nbtTag in schematic.GetTileEntities())
            {
                var t = (NbtCompound)nbtTag;
                var x = t["x"].IntValue;
                var y = t["y"].IntValue;
                var z = t["z"].IntValue;
                if (t["id"].StringValue == "Chest")
                {
                    tiles.AppendLine(JavaBuilder.MakeChest(ref schematic, ref lImports, tag, x, y, z, "\t\t"));
                    tag++;
                }
            }

            // Iterate over blocks
            gen.AppendLine(JavaBuilder.MakeGen(currentGen));
            gen.AppendLine("\t{");
            for (var x = 0; x < schematic.Width; x++)
                for (var y = 0; y < schematic.Height; y++)
                    for (var z = 0; z < schematic.Length; z++)
                    {
                        if (schematic.GetFlagAt(x, y, z) || (schematic.GetBlockAt(x, y, z).GetName() == "air" && Program.IgnoreAirBlocks))
                            continue;
                        gen.Append(JavaBuilder.MakeSetBlockLine(schematic, ref lImports, x, y, z));
                        numStatements++;
                        //Console.WriteLine(schematic.getBlockIdAt(x, y, z));

                        if (numStatements > MaxBlocksPerGen)
                        {
                            numStatements = 0;
                            currentGen++;
                            gen.AppendLine(JavaBuilder.MakeCallGen(currentGen));
                            gen.AppendLine("\t\treturn true;");
                            gen.AppendLine("\t}");
                            gen.AppendLine();
                            gen.AppendLine(JavaBuilder.MakeGen(currentGen));
                            gen.AppendLine("\t{");
                        }
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
            template = template.Replace("{{CLASS}}", UpperFirst(options.ClassName));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write((currentGen * MaxBlocksPerGen + numStatements).ToString().PadRight(10));
            Console.Write(tag.ToString().PadRight(10));
            Console.Write((currentGen + 1).ToString().PadRight(10));
            swIterate.Restart();

            // Write data to file
            using (var w = new StreamWriter("output/" + options.FileName))
                w.WriteLine(template);

            swIterate.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.MillisToHrd(swIterate.ElapsedMilliseconds).PadRight(10));
        }

        /// <summary>
        /// Uppercase the first letter of a string
        /// </summary>
        /// <param name="s">The string to work on</param>
        /// <returns>The string with the first character uppercased</returns>
        private static string UpperFirst(string s)
        {
            return char.ToUpper(s[0]) + s.Substring(1);
        }
    }
}
