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

            int numStatements = 0;
            int currentGen = 0;

            Stopwatch s = new Stopwatch();
            s.Start();

            /*
            TAG_Compound: 4 entries {
                TAG_String("id"): "teBasket"
                TAG_Int("x"): 3
                TAG_Int("y"): 0
                TAG_Int("z"): 6
            }
             */

            gen.AppendLine(makeGen(currentGen));
            gen.AppendLine("\t{");
            for (int x = 0; x < schematic.width; x++)
            {
                for (int y = 0; y < schematic.height; y++)
                {
                    for (int z = 0; z < schematic.length; z++)
                    {
                        gen.Append(makeSetBlockLine(schematic, x, y, z));
                        numStatements++;
                        //Console.WriteLine(schematic.getBlockIdAt(x, y, z));

                        if (numStatements > MAX_BLOCKS_PER_GEN)
                        {
                            numStatements = 0;
                            currentGen++;
                            gen.AppendLine(makeCallGen(currentGen));
                            gen.AppendLine("\t\treturn true;");
                            gen.AppendLine("\t}");
                            gen.AppendLine();
                            gen.AppendLine(makeGen(currentGen));
                            gen.AppendLine("\t{");
                        }
                    }
                }
            }

            Console.ForegroundColor = ConsoleColor.Blue;
            s.Stop();
            Console.Write(Utils.millisToHRD(s.ElapsedMilliseconds).PadRight(10));

            int tag = 0;
            foreach (NbtCompound t in schematic.getTileEntities())
            {
                int x = t["x"].IntValue;
                int y = t["y"].IntValue;
                int z = t["z"].IntValue;
                if (t["id"].StringValue == "Chest")
                {
                    gen.AppendLine(JavaBuilder.makeChest(schematic, tag, x, y, z, "\t\t"));
                    tag++;
                }
            }

            gen.AppendLine("\t\treturn true;");
            gen.AppendLine("\t}");

            template = template.Replace("{{PACKAGE}}", options.package);
            template = template.Replace("{{CLASS}}", upperFirst(options.className));
            template = template.Replace("{{GEN_METHODS}}", gen.ToString());

            Console.ForegroundColor = ConsoleColor.DarkGreen;
            Console.Write(((currentGen * MAX_BLOCKS_PER_GEN) + numStatements).ToString().PadRight(10));
            Console.Write(tag.ToString().PadRight(10));
            Console.Write((currentGen + 1).ToString().PadRight(10));
            s.Restart();

            using (StreamWriter w = new StreamWriter("output/" + options.fileName))
                w.WriteLine(template);

            s.Stop();
            Console.ForegroundColor = ConsoleColor.Blue;
            Console.Write(Utils.millisToHRD(s.ElapsedMilliseconds).PadRight(10));
        }

        private static String makeSetBlockLine(Schematic s, int x, int y, int z)
        {
            Block b = s.getBlockAt(x, y, z);
            StringBuilder sb = new StringBuilder();
            sb.AppendLine(String.Format("\t\tthis.setBlock(world, i + {0}, j + {1}, k + {2}, {3}, 0);", x, y, z, b.createJavaVariable()));
            if (s.getBlockMetadataAt(x, y, z) != 0)
                sb.AppendLine(String.Format("\t\tworld.setBlockMetadataWithNotify(i + {0}, j + {1}, k + {2}, {3}, 2);", x, y, z, s.getBlockMetadataAt(x, y, z)));
            return sb.ToString();
        }

        private static String makeGen(int genId)
        {
            return String.Format("\tpublic boolean generate{0}(World world, Random rand, int i, int j, int k)", genId == 0 ? "" : ("_" + genId.ToString()));
        }

        private static String makeCallGen(int genId)
        {
            return String.Format("\t\tgenerate_{0}(world, rand, i, j, k);", genId);
        }

        private static string upperFirst(string s)
        {
            return char.ToUpper(s[0]) + s.Substring(1);
        }
    }
}
