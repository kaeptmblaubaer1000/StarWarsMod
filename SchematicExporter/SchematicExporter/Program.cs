using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using fNbt;
using System.IO;
using System.Diagnostics;

namespace SchematicExporter
{
    class Program
    {
        static void Main(string[] args)
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
            Console.WriteLine("{0}{1}{2}{3}{4}{5}{6}", "File".PadRight(40), "Iterate".PadRight(10), "Blocks".PadRight(10), "Tiles".PadRight(10), "Methods".PadRight(10), "Write".PadRight(10), "Total");
            Console.WriteLine("===============================================================================================");
            Stopwatch totalElapse = new Stopwatch();
            totalElapse.Start();
            int files = 0;
            foreach (String rFile in Directory.GetFiles("input/", "*.schematic"))
            {
                Console.ForegroundColor = ConsoleColor.White;
                Console.Write(Path.GetFileNameWithoutExtension(rFile).PadRight(40));

                Stopwatch fileElapse = new Stopwatch();
                fileElapse.Start();
                Schematic s = new Schematic(rFile);

                ExportOptions options = new ExportOptions("WorldGen" + Path.GetFileNameWithoutExtension(rFile) + ".java", "com.parzivail.test", "WorldGen" + Path.GetFileNameWithoutExtension(rFile));

                Exporter.export(options, s);
                fileElapse.Stop();
                Console.ForegroundColor = ConsoleColor.Blue;
                Console.WriteLine(Utils.millisToHRD(fileElapse.ElapsedMilliseconds));

                files++;
            }
            totalElapse.Stop();
            Console.ForegroundColor = ConsoleColor.White;
            Console.WriteLine("\nDone exporting {0} files in {1}", files, Utils.millisToHRD(totalElapse.ElapsedMilliseconds));
            Console.Read();
        }
    }
}
