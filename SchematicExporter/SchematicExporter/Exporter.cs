using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Diagnostics;
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
            if (!File.Exists("template.java"))
            {
                Console.WriteLine("Unable to locate template.java");
                Console.ReadKey();
                Environment.Exit(0);
            }
            var template = File.ReadAllText("template.java");
            Console.ForegroundColor = ConsoleColor.Green;

            var gen = new StringBuilder();
            var tiles = new StringBuilder();
            var imports = new StringBuilder();
            var lImports = new List<string>();

            lImports.Require("net.minecraft.block.Block");
            lImports.Require("net.minecraft.world.World");
            lImports.Require("com.parzivail.util.world.WorldUtils");

            var numStatements = 0;
            var currentGen = 0;

            var stopwatch = new Stopwatch();
            stopwatch.Start();

            /*
            TAG_Compound: 4 entries {
                TAG_String("id"): "teBasket"
                TAG_Int("x"): 3
                TAG_Int("y"): 0
                TAG_Int("z"): 6
            }
             */

            var tag = 0;
            foreach (NbtCompound t in schematic.GetTileEntities())
            {
                var x = t["x"].IntValue;
                var y = t["y"].IntValue;
                var z = t["z"].IntValue;
                if (t["id"].StringValue == "Chest")
                {
                    tiles.AppendLine(JavaBuilder.MakeChest(ref schematic, ref lImports, tag, x, y, z, "\t\t"));
                    tag++;
                }
            }

            gen.AppendLine(JavaBuilder.MakeGen(currentGen));
            gen.AppendLine("\t{");
            for (var x = 0; x < schematic.Width; x++)
            {
                for (var y = 0; y < schematic.Height; y++)
                {
                    for (var z = 0; z < schematic.Length; z++)
                    {
                        if (schematic.GetFlagAt(x, y, z))
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
                }
            }

            lImports.Sort();
            foreach (var s in lImports)
                imports.AppendLine(string.Format("import {0};", s));

            Console.ForegroundColor = ConsoleColor.Blue;
            stopwatch.Stop();
            Console.Write(Utils.MillisToHrd(stopwatch.ElapsedMilliseconds).PadRight(10));

            gen.Append(tiles.ToString());

            gen.AppendLine("\t\treturn true;");
            gen.AppendLine("\t}");

            template = template.Replace("{{PACKAGE}}", options.Package);
            template = template.Replace("{{CLASS}}", UpperFirst(options.ClassName));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(((currentGen * MaxBlocksPerGen) + numStatements).ToString().PadRight(10));
            Console.Write(tag.ToString().PadRight(10));
            Console.Write((currentGen + 1).ToString().PadRight(10));
            stopwatch.Restart();

            using (var w = new StreamWriter("output/" + options.FileName))
                w.WriteLine(template);

            stopwatch.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.MillisToHrd(stopwatch.ElapsedMilliseconds).PadRight(10));
        }

        private static string UpperFirst(string s)
        {
            return char.ToUpper(s[0]) + s.Substring(1);
        }
    }
}
