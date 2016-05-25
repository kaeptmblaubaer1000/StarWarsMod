using System.IO;
using System.Text;

namespace SchematicExporter
{
    internal class Exporter
    {
        /// <summary>
        /// Maximum blocks/lines per generation statement
        /// </summary>
        public const int MaxBlocksPerGen = 500;

        /// <summary>
        /// Exports the given schematic following the given export options
        /// </summary>
        /// <param name="options">The export options</param>
        /// <param name="schematic">The schematic to export</param>
        public static void Export(ExportOptions options, Schematic schematic)
        {
            var gen = new StringBuilder();
            var first = true;

            gen.AppendLine("this.locY = (int)MathUtils.map(this.rootHeight, -2, 2, 0, 128);\n");

            for (var x = 0; x < schematic.Width; x += 16)
                for (var z = 0; z < schematic.Length; z += 16)
                {
                    ChunkExport.Export(options, schematic, x, z);

                    var classTitle =
                        Utils.UpperFirst(string.Format(options.ClassName,
                            string.Format("_x{0}_z{1}", x, z)));

                    gen.AppendLine(string.Format("{0}if (chunkX == {1} && chunkZ == {2})", first ? "" : "else ", x, z));

                    gen.AppendLine(
                        string.Format("\tnew {0}().generate(par1World, par2Random, chunkX, this.locY, chunkZ);",
                            classTitle));

                    first = false;
                }

            using (var w = new StreamWriter("output/" + string.Format(options.FileName, "Generator")))
                w.WriteLine(gen);
        }
    }
}
