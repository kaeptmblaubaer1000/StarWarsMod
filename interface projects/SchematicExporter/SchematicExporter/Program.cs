using System;
using System.Diagnostics;
using System.IO;
using System.Text.RegularExpressions;

namespace SchematicExporter
{
    internal class Program
    {
        public static bool EmptyChestRandom;
        public static bool IgnoreAirBlocks;
        public static bool IgnoreChestToEntity;
        public static string UseTemplate;
        public static string UsePackage;
        public static string UseBlocks;
        public static string UseItems;

        public static StreamWriter LogWriter;

        private static void Main(string[] args)
        {
            EmptyChestRandom = false;
            IgnoreAirBlocks = false;
            IgnoreChestToEntity = false;
            UseTemplate = "default.java";
            UsePackage = "your.mod.pkg";
            UseBlocks = "blocks.txt";
            UseItems = "items.txt";

            Console.ForegroundColor = ConsoleColor.White;

            LogWriter = new StreamWriter(string.Format("log-{0}.log", DateTime.Now.Ticks));

            LogWriter.WriteLine("Running with args: {0}", string.Join(", ", args));

            if (args.Length > 0)
            {
                foreach (var s in args)
                {
                    if (s == "--emptyloot")
                    {
                        EmptyChestRandom = true;
                        Console.WriteLine("Custom Setting: empty chests will be filled with random loot");
                    }
                    else if (s == "--ignoreair")
                    {
                        IgnoreAirBlocks = true;
                        Console.WriteLine("Custom Setting: air blocks will not be exported");
                    }
                    else if (s == "--nochestentity")
                    {
                        IgnoreChestToEntity = true;
                        Console.WriteLine(
                            "Custom Setting: chests with entity selectors inside will not export as entities");
                    }
                    else if (s == "--help")
                    {
                        Console.WriteLine("Available arguments:");
                        Console.WriteLine(
                            "--emptyloot\n\tEmpty chests (instead of blaze rod in top left corner) will be filled with random loot");
                        Console.WriteLine(
                            "--template:<template file>\n\tOutout will be generated based off of template/<template file>" +
                            "\n\tPlaceholders:" +
                            "\n\t\t{{CLASS_COMMENT}}" +
                            "\n\t\t{{PACKAGE}}" +
                            "\n\t\t{{CLASS}}" +
                            "\n\t\t{{GEN_METHODS}}" +
                            "\n\t\t{{IMPORTS}}");
                        Console.WriteLine("--package:<package>\n\tThe package for the file to be exported for");
                        Console.WriteLine("--blocks:<blocks>\n\tThe dictionary file to pull blocks from");
                        Console.WriteLine("--items:<items>\n\tThe dictionary file to pull items from");
                        Console.WriteLine("--ignoreair\n\tAir blocks will not be exported");
                        Console.WriteLine(
                            "--nochestentity\n\tChests with entity selectors inside will not export as entities");
                        Console.WriteLine("Press any key to exit...");
                        Console.ReadKey();
                        Environment.Exit(0);
                    }
                    else if (new Regex("--template:(\\S+)").IsMatch(s))
                    {
                        UseTemplate = s.Split(':')[1];
                        Console.WriteLine("Custom Setting: using template/{0}", UseTemplate);
                    }
                    else if (new Regex("--package:(\\S+)").IsMatch(s))
                    {
                        UsePackage = s.Split(':')[1];
                        Console.WriteLine("Custom Setting: using package {0}", UsePackage);
                    }
                    else if (new Regex("--blocks:(\\S+)").IsMatch(s))
                    {
                        UseBlocks = s.Split(':')[1];
                        Console.WriteLine("Custom Setting: using block dictionary data/{0}", UseBlocks);
                    }
                    else if (new Regex("--items:(\\S+)").IsMatch(s))
                    {
                        UseItems = s.Split(':')[1];
                        Console.WriteLine("Custom Setting: using item dictionary data/{0}", UseItems);
                    }
                    else
                    {
                        Console.WriteLine("Invalid argument: \"{0}\"", s);
                        Console.WriteLine("Use \"--help\" for a list of available arguments");
                    }
                }
                Console.WriteLine();
            }

            // Check I/O directories
            if (!Directory.Exists("input/"))
            {
                Directory.CreateDirectory("input/");
                Console.WriteLine("Created input directory");
                LogWriter.WriteLine("Input directory not found, created one.");
            }
            if (!Directory.Exists("output/"))
            {
                Directory.CreateDirectory("output/");
                Console.WriteLine("Created output directory");
                LogWriter.WriteLine("Output directory nor found, created one.");
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
            var chunks = 0;
            var blocks = 0;
            foreach (var rFile in Directory.GetFiles("input/", "*.schematic"))
            {
                //TODO: make recursive searching an option

                //load the schematic
                var s = new Schematic(rFile);
                LogWriter.WriteLine("Loaded schematic {0}", rFile);

                blocks += s.Size();
                LogWriter.WriteLine("Found {0} blocks", s.Size());

                var upperFirstName = Utils.UpperFirst(Path.GetFileNameWithoutExtension(rFile));
                // Set how you want to export
                var options = new ExportOptions("WorldGen" + upperFirstName + "{0}.java", UsePackage,
                    "WorldGen" + upperFirstName + "{0}");

                LogWriter.WriteLine("Exporting with options: className={0}, package={1}", string.Format(options.ClassName, ""), options.Package);

                // Actually export the schematic
                var oldChunks = chunks;
                LogWriter.Write("Exporting chunks... ");
                try
                {
                    chunks += Exporter.Export(options, s);
                    LogWriter.WriteLine("Exported {0} chunks", chunks - oldChunks);
                }
                catch (Exception exception)
                {
                    Console.ForegroundColor = ConsoleColor.Yellow;
                    Console.WriteLine("\nError while exporting, check log for details!\n");
                    LogWriter.WriteLine("Error while exporting {0}: {1} at {2}\n{3}", rFile, exception.Message, exception.TargetSite, exception.StackTrace);
                }

                LogWriter.WriteLine();

                Console.ForegroundColor = ConsoleColor.DarkCyan;

                files++;
            }
            totalElapse.Stop();
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine();
            Console.WriteLine("Done exporting {0} file{3} ({2} chunks) in {1}", files,
                Utils.MillisToHrd(totalElapse.ElapsedMilliseconds), chunks, files == 1 ? "" : "s");
            if (chunks > 0)
            {
                Console.WriteLine("\nAverage Time\t\t{0}",
                    Utils.MillisToHrd(totalElapse.ElapsedMilliseconds/chunks));
                Console.WriteLine("Average Files/Second\t{0}", 1000/((float) totalElapse.ElapsedMilliseconds/chunks));
                Console.WriteLine("Blocks (incl. air)\t{0}", blocks);
            }

            LogWriter.Close();

            Console.Read();
        }
    }
}
