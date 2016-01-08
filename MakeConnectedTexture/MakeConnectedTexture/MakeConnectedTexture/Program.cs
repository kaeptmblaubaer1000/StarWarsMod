using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MakeConnectedTexture
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            List<string> files = new List<string>();

            Console.Write("Block Name > ");
            string name = Console.ReadLine();

            foreach (String fileName in Directory.GetFiles("connected\\base\\"))
            {
                if (!Directory.Exists("connected\\" + name))
                    Directory.CreateDirectory("connected\\" + name);
                File.Copy(fileName, fileName.Replace("base", name));
                Console.WriteLine("Created {0} (from {1})", fileName.Replace("base", name), fileName, fileName.Replace("base", name));
            }

            Console.WriteLine("Done!");
            Console.ReadKey();
        }
    }
}