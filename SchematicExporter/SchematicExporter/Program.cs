using System;
using System.Diagnostics;
using System.IO;

namespace SchematicExporter
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.White;
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
            Console.WriteLine("{0}{1}{2}{3}{4}{5}{6}{7}", "File".PadRight(40), "Iterate".PadRight(10), "Blocks".PadRight(10), "Tiles".PadRight(10), "Methods".PadRight(10), "Write".PadRight(10), "Total".PadRight(10), "Filesize".PadRight(10));
            Console.WriteLine("".PadRight(110, '='));
            var totalElapse = new Stopwatch();
            totalElapse.Start();
            var files = 0;
            foreach (var rFile in Directory.GetFiles("input/", "*.schematic"))
            {

                var fileElapse = new Stopwatch();
                var s = new Schematic(rFile);

                var options = new ExportOptions("WorldGen" + Path.GetFileNameWithoutExtension(rFile) + ".java", "com.parzivail.test", "WorldGen" + Path.GetFileNameWithoutExtension(rFile));
                Console.ForegroundColor = ConsoleColor.White;
                Console.Write(options.ClassName.PadRight(40));

                fileElapse.Start();
                Exporter.Export(options, s);
                fileElapse.Stop();
                Console.ForegroundColor = ConsoleColor.Blue;
                Console.Write(Utils.MillisToHrd(fileElapse.ElapsedMilliseconds).PadRight(10));

                Console.ForegroundColor = ConsoleColor.DarkCyan;
                long fsLength = new FileInfo("output/" + options.FileName).Length;
                Console.Write(Utils.SizeSuffix(fsLength).PadRight(10));

                Console.WriteLine();

                files++;
            }
            totalElapse.Stop();
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("\nDone exporting {0} files in {1}", files, Utils.MillisToHrd(totalElapse.ElapsedMilliseconds));
            Console.Read();
        }
    }
}
