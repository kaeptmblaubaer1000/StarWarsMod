using System;
using System.Diagnostics;
using System.IO;
using System.Text.RegularExpressions;

namespace SchematicExporter
{
    internal class Program
    {
        public static bool EmptyChestNotRandom = false;
        public static bool IgnoreAirBlocks = false;
        public static bool IgnoreChestToEntity = false;

        private static void Main(string[] args)
        {
            if (args.Length > 0)
            {
                var p = string.Join(" ", args);

                var match = Regex.Match(p, @"--ignore (?:(.+?)(?: |$))+");

                if (match.Success)
                {
                    foreach (Capture c in match.Groups[0].Captures)
                    {
                        switch (c.Value)
                        {
                            case "chestempty":
                                EmptyChestNotRandom = true;
                                break;
                            case "air":
                                IgnoreAirBlocks = true;
                                break;
                            case "chententity":
                                IgnoreChestToEntity = true;
                                break;
                            default:
                                Console.WriteLine("Invalid argument: \"{0}\"", c.Value);
                                break;
                        }
                    }
                }
            }

            Console.ForegroundColor = ConsoleColor.White;
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
            var overwriteFlag = false;
            foreach (var rFile in Directory.GetFiles("input/", "*.schematic"))
            {
                //load the schematic
                var s = new Schematic(rFile);

                // Set how you want to export
                var options = new ExportOptions("WorldGen" + Path.GetFileNameWithoutExtension(rFile) + ".java", "com.parzivail.test", "WorldGen" + Path.GetFileNameWithoutExtension(rFile));

                if (File.Exists("output/" + options.FileName))
                    overwriteFlag = true;

                Console.ForegroundColor = ConsoleColor.White;
                Console.Write(string.Format("{0}{1}", options.ClassName, File.Exists("output/" + options.FileName) ? "*" : "").PadRight(40));

                // Start a stopwatch to time the current export
                var fileElapse = new Stopwatch();
                fileElapse.Start();

                // Actually export the schematic
                Exporter.Export(options, s);

                fileElapse.Stop();

                Console.ForegroundColor = ConsoleColor.Blue;
                Console.Write(Utils.MillisToHrd(fileElapse.ElapsedMilliseconds).PadRight(10));

                Console.ForegroundColor = ConsoleColor.DarkCyan;

                // Calculate filesize of the output
                long fsLength = new FileInfo("output/" + options.FileName).Length;
                Console.Write(Utils.SizeSuffix(fsLength).PadRight(10));

                Console.WriteLine();

                files++;
            }
            totalElapse.Stop();
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine();
            if (overwriteFlag)
                Console.WriteLine("* Overwrote previous version");
            Console.WriteLine("Done exporting {0} files in {1}", files, Utils.MillisToHrd(totalElapse.ElapsedMilliseconds, false));
            Console.Read();
        }
    }
}
