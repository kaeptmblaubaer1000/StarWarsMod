using System;
using System.Diagnostics;
using System.IO;
using System.Text.RegularExpressions;

namespace SchematicExporter
{
    internal static class Program
    {
        private static StreamWriter _logWriter;

        private static void Main(string[] args)
        {
            Arguments.EmptyChestRandom = false;
            Arguments.IgnoreAirBlocks = false;
            Arguments.IgnoreChestToEntity = false;
            Arguments.UseTemplate = "default.java";
            Arguments.UsePackage = "your.mod.pkg";
            Arguments.UseBlocks = "blocks.txt";
            Arguments.UseItems = "items.txt";

            Console.ForegroundColor = ConsoleColor.White;

            Console.Title = "SchematicExporter - Ready";

            if (!Directory.Exists("logs/"))
                Directory.CreateDirectory("logs/");
            _logWriter = new StreamWriter(string.Format("logs/log-{0}.log", DateTime.Now.Ticks));

            _logWriter.WriteLine("Running with args: {0}\n\n", string.Join(", ", args));

            if (args.Length > 0)
            {
                foreach (var s in args)
                {
                    switch (s)
                    {
                        case "-emptyloot":
                            Arguments.EmptyChestRandom = true;
                            Console.WriteLine("Custom Setting: empty chests will be filled with random loot");
                            break;
                        case "-ignoreair":
                            Arguments.IgnoreAirBlocks = true;
                            Console.WriteLine("Custom Setting: air blocks will not be exported");
                            break;
                        case "-r":
                            Arguments.SearchRecursive = true;
                            Console.WriteLine("Custom Setting: input directory searched recursively");
                            break;
                        case "-nochestentity":
                            Arguments.IgnoreChestToEntity = true;
                            Console.WriteLine(
                                "Custom Setting: chests with entity selectors inside will not export as entities");
                            break;
                        case "-help":
                            Console.WriteLine("Available arguments:");
                            Console.WriteLine(
                                "-emptyloot\n\tEmpty chests (instead of blaze rod in top left corner) will be filled with random loot");
                            Console.WriteLine(
                                "-template:<template file>\n\tOutout will be generated based off of template/<template file>" +
                                "\n\tPlaceholders:" +
                                "\n\t\t{{CLASS_COMMENT}}" +
                                "\n\t\t{{PACKAGE}}" +
                                "\n\t\t{{CLASS}}" +
                                "\n\t\t{{GEN_METHODS}}" +
                                "\n\t\t{{IMPORTS}}");
                            Console.WriteLine("-package:<package>\n\tThe package for the file to be exported for");
                            Console.WriteLine("-blocks:<blocks>\n\tThe dictionary file to pull blocks from");
                            Console.WriteLine("-items:<items>\n\tThe dictionary file to pull items from");
                            Console.WriteLine("-ignoreair\n\tAir blocks will not be exported");
                            Console.WriteLine("-r\n\tInput directory will be searched recursively");
                            Console.WriteLine(
                                "-nochestentity\n\tChests with entity selectors inside will not export as entities");
                            Console.WriteLine("Press any key to exit...");
                            Console.ReadKey();
                            Environment.Exit(0);
                            break;
                        default:
                            if (new Regex("-template:(\\S+)").IsMatch(s))
                            {
                                Arguments.UseTemplate = s.Split(':')[1];
                                Console.WriteLine("Custom Setting: using template/{0}", Arguments.UseTemplate);
                            }
                            else if (new Regex("-package:(\\S+)").IsMatch(s))
                            {
                                Arguments.UsePackage = s.Split(':')[1];
                                Console.WriteLine("Custom Setting: using package {0}", Arguments.UsePackage);
                            }
                            else if (new Regex("-blocks:(\\S+)").IsMatch(s))
                            {
                                Arguments.UseBlocks = s.Split(':')[1];
                                Console.WriteLine("Custom Setting: using block dictionary data/{0}", Arguments.UseBlocks);
                            }
                            else if (new Regex("-items:(\\S+)").IsMatch(s))
                            {
                                Arguments.UseItems = s.Split(':')[1];
                                Console.WriteLine("Custom Setting: using item dictionary data/{0}", Arguments.UseItems);
                            }
                            else
                            {
                                Console.WriteLine("Invalid argument: \"{0}\"", s);
                                Console.WriteLine("Use \"-help\" for a list of available arguments");
                            }
                            break;
                    }
                }
                Console.WriteLine();
            }

            // Check I/O directories
            if (!Directory.Exists("input/"))
            {
                Directory.CreateDirectory("input/");
                Console.WriteLine("Created input directory");
                _logWriter.WriteLine("Input directory not found, created one.");
            }
            if (!Directory.Exists("output/"))
            {
                Directory.CreateDirectory("output/");
                Console.WriteLine("Created output directory");
                _logWriter.WriteLine("Output directory not found, created one.");
            }
            // Draw the header
            Console.WriteLine("{0}{1}{2}{3}{4}{5}{6}{7}", "File".PadRight(40), "Iterate".PadRight(10),
                "Blocks".PadRight(10), "Tiles".PadRight(10), "Methods".PadRight(10), "Write".PadRight(10),
                "Total".PadRight(10), "Filesize".PadRight(10));
            Console.WriteLine("".PadRight(110, '='));

            // Start a stopwatch to time the exports
            var totalElapse = new Stopwatch();
            totalElapse.Start();

            // File counter
            var files = 0;
            foreach (var rFile in Utils.GetFiles("input", "*.schematic", Arguments.SearchRecursive))
            {
                //load the schematic
                var s = new Schematic(rFile);
                _logWriter.WriteLine("Loaded schematic {0}, found {1} blocks", rFile, s.Size());

                var upperFirstName = Utils.UpperFirst(Path.GetFileNameWithoutExtension(rFile));
                // Set how you want to export
                var options = new ExportOptions("WorldGen" + upperFirstName + "{0}.java", Arguments.UsePackage,
                    "WorldGen" + upperFirstName + "{0}", Path.GetDirectoryName(rFile).Substring(5));

                _logWriter.WriteLine("Exporting with options: className={0}, package={1}", string.Format(options.ClassName, ""), options.Package);

                // Actually export the schematic
                var oldChunks = Metrics.TotalChunks;
                _logWriter.Write("Exporting chunks... ");
                try
                {
                    Metrics.TotalChunks += Exporter.Export(options, s);
                    _logWriter.WriteLine("Exported {0} chunks", Metrics.TotalChunks - oldChunks);
                }
                catch (Exception exception)
                {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("\nError while exporting, check log for details!\n");
                    _logWriter.WriteLine("Error while exporting {0}: {1}\n{2}", rFile, exception.Message, exception.StackTrace);
                }

                _logWriter.WriteLine();

                Console.ForegroundColor = ConsoleColor.DarkCyan;

                files++;
            }
            totalElapse.Stop();
            Console.Title = "SchematicExporter - Done";
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine();
            Console.WriteLine("Done exporting {0:n0} file{3} ({2:n0} chunk{4}) in {1}", files,
                Utils.MillisToHrd(totalElapse.ElapsedMilliseconds), Metrics.TotalChunks, files == 1 ? "" : "s", Metrics.TotalChunks == 1 ? "" : "s");
            if (Metrics.TotalChunks > 0)
            {
                Console.WriteLine("\tAverage Time\t\t{0}",
                    Utils.MillisToHrd(totalElapse.ElapsedMilliseconds / Metrics.TotalChunks));
                Console.WriteLine("\tAverage Files/Second\t{0:n0}", 1000 / ((float)totalElapse.ElapsedMilliseconds / Metrics.TotalChunks));
                Console.WriteLine("\tBlocks (incl. air)\t{0:n0}", Metrics.TotalBlocks);
                Console.WriteLine("\tTiles\t\t\t{0:n0}", Metrics.TotalTiles);
                Console.WriteLine("\tTotal Filesize\t\t{0}", Utils.SizeSuffix(Metrics.TotalFilesize));
                Console.WriteLine("\tChunks over 1 MB\t{0:n0} ({1}%)", Metrics.FilesOverOneMeg, 100 * Metrics.FilesOverOneMeg / Metrics.TotalChunks);
            }

            _logWriter.Close();

            Console.Read();
        }
    }
}
