using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace SchematicExporter
{
    internal static class Utils
    {
        private static readonly string[] SizeSuffixes = { "bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB" };

        /// <summary>
        /// Milliseconds to Human Readable Date
        /// </summary>
        /// <param name="millis">Milliseconds</param>
        /// <param name="onlyMajorUnit">True if you only want the major time unit (i.e. "2s" vs "2s 134ms")</param>
        /// <returns>Human Readable Date</returns>
        public static string MillisToHrd(long millis, bool onlyMajorUnit)
        {
            var ts = TimeSpan.FromMilliseconds(millis);
            var parts = string.Format("{0:D2}d:{1:D2}h:{2:D2}m:{3:D2}s:{4:D3}ms",
                                ts.Days, ts.Hours, ts.Minutes, ts.Seconds, ts.Milliseconds)
                            .Split(':')
                            .SkipWhile(s => Regex.Match(s, @"00\w").Success) // skip zero-valued components
                            .ToArray();
            var ret = onlyMajorUnit ? parts.Length == 0 ? "0ms" : parts[0] : string.Join(" ", parts); // combine the result
            return Regex.Replace(ret, @"(0+)(\d+)", @"$2");
        }

        /// <summary>
        /// Milliseconds to Human Readable Date
        /// </summary>
        /// <param name="millis">Milliseconds</param>
        /// <returns>Human Readable Date</returns>
        public static string MillisToHrd(long millis)
        {
            return MillisToHrd(millis, true);
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

        /// <summary>
        /// Formats a long byte to the nearest data size format
        /// </summary>
        /// <param name="value">The filesize in bytes (long)</param>
        /// <returns>The string-formatted filesize</returns>
        public static string SizeSuffix(long value)
        {
            if (value < 0) { return "-" + SizeSuffix(-value); }

            var i = 0;
            float dValue = value;
            while (Math.Round(dValue / 1024) >= 1)
            {
                dValue /= 1024;
                i++;
            }

            return string.Format("{0:n1} {1}", dValue, SizeSuffixes[i]);
        }

        /// <summary>
        /// Uppercase the first letter of a string
        /// </summary>
        /// <param name="s">The string to work on</param>
        /// <returns>The string with the first character uppercased</returns>
        public static string UpperFirst(string s)
        {
            return char.ToUpper(s[0]) + s.Substring(1);
        }

        public static void RequireFile(string file)
        {
            if (File.Exists(file)) return;
            Console.WriteLine("Unable to locate required file {0}", file);
            Console.WriteLine("Please re-download or create it.");
            Console.WriteLine("Press any key to exit...");
            Console.ReadKey();
            Environment.Exit(0);
        }
    }
}
