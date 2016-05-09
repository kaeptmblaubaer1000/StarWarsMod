using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace GradleBuild
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            Console.Write("Parsing build.gradle... ");
            if (File.Exists("build.gradle"))
            {
                using (StreamReader r = new StreamReader("build.gradle"))
                {
                    Match m = new Regex("version.+\"((?:\\d\\.?)+)\"").Match(r.ReadToEnd());
                    if (m.Success)
                    {
                        string ver = m.Groups[1].Value;

                        string fname = "releases/Parzi's Star Wars Mod v" + ver + "-dev{0}.jar";
                        int dev = 1;
                        while (File.Exists(string.Format(fname, dev)))
                            dev++;

                        Console.WriteLine("Done!");

                        stopwatch.Start();
                        Console.WriteLine("Compiling version {0}-dev{1}...", ver, dev);
                        if (File.Exists("gradlew.bat"))
                        {
                            Process process = new Process();
                            process.StartInfo = new ProcessStartInfo("gradlew.bat", "build");
                            process.StartInfo.UseShellExecute = false;
                            process.StartInfo.RedirectStandardError = true;
                            process.StartInfo.RedirectStandardInput = true;
                            process.StartInfo.RedirectStandardOutput = true;
                            process.Start();
                            process.WaitForExit();
                            Console.WriteLine(process.StandardOutput.ReadToEnd());
                            fname = string.Format(fname, dev);
                            Console.WriteLine("Moving jar: {0}", fname);
                            if (File.Exists("build/libs/starwarsmod-" + ver + ".jar"))
                                File.Move("build/libs/starwarsmod-" + ver + ".jar", fname);
                            else
                                Console.WriteLine("Unable to locate compiled jar!");
                            stopwatch.Stop();
                            Console.WriteLine("Finished in " + ((float)stopwatch.ElapsedMilliseconds / 1000f).ToString() + "s");
                        }
                        else
                        {
                            Console.WriteLine("Unable to locate gradlew.bat!");
                        }
                        Console.ReadKey();
                    }
                    else
                    {
                        Console.WriteLine("Unable to parse build.gradle!");
                    }
                }
            }
            else
            {
                Console.WriteLine("Unable to locate build.gradle!");
            }
        }
    }
}