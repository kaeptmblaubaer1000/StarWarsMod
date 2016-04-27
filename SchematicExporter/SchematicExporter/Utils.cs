using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace SchematicExporter
{
    static class Utils
    {
        public static String millisToHRD(long millis)
        {
            TimeSpan ts = TimeSpan.FromMilliseconds(millis);
            String[] parts = String
                            .Format("{0:D2}d:{1:D2}h:{2:D2}m:{3:D2}s:{4:D3}ms",
                                ts.Days, ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds)
                            .Split(':')
                            .SkipWhile(s => Regex.Match(s, @"00\w").Success) // skip zero-valued components
                            .ToArray();
            String ret = String.Join(" ", parts); // combine the result
            if (String.IsNullOrWhiteSpace(ret))
                return "0ms";
            return Regex.Replace(ret, @"(0+)(\d+)", @"$2");
        }

        public static void Populate<T>(this T[] arr, T value)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                arr[i] = value;
            }
        }
    }
}
