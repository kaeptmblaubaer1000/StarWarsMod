using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Diagnostics;
using fNbt;

namespace SchematicExporter
{
    class Exporter
    {
        public const int MAX_BLOCKS_PER_GEN = 500;
        /*
         * public boolean generate(World world, Random rand, int i, int j, int k)
	     * {
		 *      this.setBlock(world, i + 0, j + 0, k + 0, Blocks.air, 0);
         * }
         * 
		 * world.setBlockMetadataWithNotify(i + 12, j + 5, k + 4, 1, 2); // x, y, z, metadata, flag
         */

        public static void export(ExportOptions options, Schematic schematic)
        {
            String template = File.ReadAllText("template.java");
            Console.ForegroundColor = ConsoleColor.Green;

            StringBuilder gen = new StringBuilder();
            StringBuilder tiles = new StringBuilder();
            StringBuilder imports = new StringBuilder();
            List<String> lImports = new List<String>();
            //com.parzivail.pswm.mobs

            int numStatements = 0;
            int currentGen = 0;

            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();

            /*
            TAG_Compound: 4 entries {
                TAG_String("id"): "teBasket"
                TAG_Int("x"): 3
                TAG_Int("y"): 0
                TAG_Int("z"): 6
            }
             */

            int tag = 0;
            foreach (NbtCompound t in schematic.getTileEntities())
            {
                int x = t["x"].IntValue;
                int y = t["y"].IntValue;
                int z = t["z"].IntValue;
                if (t["id"].StringValue == "Chest")
                {
                    tiles.AppendLine(JavaBuilder.makeChest(ref schematic, ref lImports, tag, x, y, z, "\t\t"));
                    tag++;
                }
            }

            foreach (String s in lImports)
                imports.AppendLine(String.Format("import {0};", s));

            gen.AppendLine(JavaBuilder.makeGen(currentGen));
            gen.AppendLine("\t{");
            for (int x = 0; x < schematic.width; x++)
            {
                for (int y = 0; y < schematic.height; y++)
                {
                    for (int z = 0; z < schematic.length; z++)
                    {
                        if (schematic.getFlagAt(x, y, z))
                            continue;
                        gen.Append(JavaBuilder.makeSetBlockLine(schematic, x, y, z));
                        numStatements++;
                        //Console.WriteLine(schematic.getBlockIdAt(x, y, z));

                        if (numStatements > MAX_BLOCKS_PER_GEN)
                        {
                            numStatements = 0;
                            currentGen++;
                            gen.AppendLine(JavaBuilder.makeCallGen(currentGen));
                            gen.AppendLine("\t\treturn true;");
                            gen.AppendLine("\t}");
                            gen.AppendLine();
                            gen.AppendLine(JavaBuilder.makeGen(currentGen));
                            gen.AppendLine("\t{");
                        }
                    }
                }
            }

            Console.ForegroundColor = ConsoleColor.Blue;
            stopwatch.Stop();
            Console.Write(Utils.millisToHRD(stopwatch.ElapsedMilliseconds).PadRight(10));

            gen.Append(tiles.ToString());

            gen.AppendLine("\t\treturn true;");
            gen.AppendLine("\t}");

            template = template.Replace("{{PACKAGE}}", options.package);
            template = template.Replace("{{CLASS}}", upperFirst(options.className));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());
            template = template.Replace("{{IMPORTS}}", imports.ToString());

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(((currentGen * MAX_BLOCKS_PER_GEN) + numStatements).ToString().PadRight(10));
            Console.Write(tag.ToString().PadRight(10));
            Console.Write((currentGen + 1).ToString().PadRight(10));
            stopwatch.Restart();

            using (StreamWriter w = new StreamWriter("output/" + options.fileName))
                w.WriteLine(template);

            stopwatch.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.millisToHRD(stopwatch.ElapsedMilliseconds).PadRight(10));
        }

        private static string upperFirst(string s)
        {
            return char.ToUpper(s[0]) + s.Substring(1);
        }
    }
}
