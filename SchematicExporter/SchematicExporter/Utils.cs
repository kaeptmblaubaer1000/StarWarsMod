using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace SchematicExporter
{
    internal static class Utils
    {
        /// <summary>
        /// Milliseconds to Human Readable Date
        /// </summary>
        /// <param name="millis">Milliseconds</param>
        /// <returns>Human Readable Date</returns>
        public static string MillisToHrd(long millis)
        {
            var ts = TimeSpan.FromMilliseconds(millis);
            var parts = string
                            .Format("{0:D2}d:{1:D2}h:{2:D2}m:{3:D2}s:{4:D3}ms",
                                ts.Days, ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds)
                            .Split(':')
                            .SkipWhile(s => Regex.Match(s, @"00\w").Success) // skip zero-valued components
                            .ToArray();
            var ret = parts.Length == 0 ? "0ms" : parts[0]; // String.Join(" ", parts); // combine the result
            return Regex.Replace(ret, @"(0+)(\d+)", @"$2");
        }

        /// <summary>
        /// Populates an array with a value
        /// </summary>
        /// <typeparam name="T">The array type</typeparam>
        /// <param name="arr">The array</param>
        /// <param name="value">The value to populate with</param>
        public static void Populate<T>(this T[] arr, T value)
        {
            for (var i = 0; i < arr.Length; i++)
                arr[i] = value;
        }

        /// <summary>
        /// Puts an item in a list if it isn't present
        /// </summary>
        /// <typeparam name="T">The list type</typeparam>
        /// <param name="list">The list</param>
        /// <param name="value">The value to add, if necessary</param>
        public static void Require<T>(this List<T> list, T value)
        {
            if (!list.Contains(value))
                list.Add(value);
        }
    }
}
