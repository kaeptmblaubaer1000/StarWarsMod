using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GradleBuild
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            Console.Write("v > ");
            string str = Console.ReadLine();
            stopwatch.Start();
            Console.WriteLine("Building Gradle...");
            Process process = new Process();
            process.StartInfo = new ProcessStartInfo("gradlew.bat", "build");
            process.StartInfo.UseShellExecute = false;
            process.StartInfo.RedirectStandardError = true;
            process.StartInfo.RedirectStandardInput = true;
            process.StartInfo.RedirectStandardOutput = true;
            process.Start();
            process.WaitForExit();
            Console.WriteLine(process.StandardOutput.ReadToEnd());
            string fname = "releases/Parzi's Star Wars Mod v" + str + "-dev{0}.jar";
            int dev = 1;
            while (File.Exists(string.Format(fname, dev)))
                dev++;
            fname = string.Format(fname, dev);
            Console.WriteLine("Creating jar: {0}", fname);
            if (File.Exists("build/libs/starwarsmod-1.0.jar"))
                File.Move("build/libs/starwarsmod-1.0.jar", fname);
            stopwatch.Stop();
            Console.WriteLine("Finished packing in " + ((float)stopwatch.ElapsedMilliseconds / 1000f).ToString() + "s");
            Console.ReadKey();
        }
    }
}
