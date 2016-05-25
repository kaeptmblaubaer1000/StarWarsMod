using System;
using System.Diagnostics;
using System.IO;

namespace SchematicExporter
{
    internal class Program
    {
        public static bool EmptyChestRandom;
        public static bool IgnoreAirBlocks;
        public static bool IgnoreChestToEntity;

        private static void Main(string[] args)
        {
            EmptyChestRandom = false;
            IgnoreAirBlocks = false;
            IgnoreChestToEntity = false;

            Console.ForegroundColor = ConsoleColor.White;

            if (args.Length > 0)
            {
                foreach (var s in args)
                {
                    switch (s)
                    {
                        case "--emptyloot":
                            EmptyChestRandom = true;
                            Console.WriteLine("Custom Setting: empty chests will be filled with random loot");
                            Console.WriteLine();
                            break;
                        case "--ignoreair":
                            IgnoreAirBlocks = true;
                            Console.WriteLine("Custom Setting: air blocks will not be exported");
                            Console.WriteLine();
                            break;
                        case "--nochestentity":
                            IgnoreChestToEntity = true;
                            Console.WriteLine(
                                "Custom Setting: chests with entity selectors inside will not export as entities");
                            Console.WriteLine();
                            break;
                        case "--help":
                            Console.WriteLine("Available arguments:");
                            Console.WriteLine("~ --emptyloot\tempty chests will be filled with random loot");
                            Console.WriteLine("~ --ignoreair\tCustom Setting: air blocks will not be exported");
                            Console.WriteLine("~ --nochestentity\tchests with entity selectors inside will not export as entities");
                            Environment.Exit(0);
                            break;
                        default:
                            Console.WriteLine("Invalid argument: \"{0}\"", s);
                            Console.WriteLine("Use \"--help\" for a list of available arguments");
                            Console.WriteLine();
                            break;
                    }
                }
            }
            /*
             * Check I/O directories
             */
            if (!Directory.Exists("input/"))
            {
                Directory.CreateDirectory("input/");
                Console.WriteLine("Created input directory");
            }
            if (!Directory.Exists("output/"))
            {
                Directory.CreateDirectory("output/");
                Console.WriteLine("Created output directory");
            }
            // Draw the header
            Console.WriteLine("{0}{1}{2}{3}{4}{5}{6}{7}", "File".PadRight(40), "Iterate".PadRight(10), "Blocks".PadRight(10), "Tiles".PadRight(10), "Methods".PadRight(10), "Write".PadRight(10), "Total".PadRight(10), "Filesize".PadRight(10));
            Console.WriteLine("".PadRight(110, '='));

            // Start a stopwatch to time the exports
            var totalElapse = new Stopwatch();
            totalElapse.Start();

            // File counter
            var files = 0;
            foreach (var rFile in Directory.GetFiles("input/", "*.schematic"))
            {
                //load the schematic
                var s = new Schematic(rFile);

                // Set how you want to export
                var options = new ExportOptions("WorldGen" + Path.GetFileNameWithoutExtension(rFile) + "{0}.java", "com.parzivail.test", "WorldGen" + Path.GetFileNameWithoutExtension(rFile) + "{0}");

                // Actually export the schematic
                Exporter.Export(options, s);

                Console.ForegroundColor = ConsoleColor.DarkCyan;

                // Calculate filesize of the output
                //long fsLength = new FileInfo("output/" + options.FileName).Length;
                //Console.Write(Utils.SizeSuffix(fsLength).PadRight(10));

                files++;
            }
            totalElapse.Stop();
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine();
            Console.WriteLine("Done exporting {0} files in {1}", files, Utils.MillisToHrd(totalElapse.ElapsedMilliseconds, false));
            Console.Read();
        }
    }
}
