using System.IO;
using System.Linq;
using fNbt;

namespace SchematicExporter
{
    internal class Schematic
    {
        private readonly NbtFile _nFile;

        /// <summary>
        /// Length of the schematic, in blocks
        /// </summary>
        public readonly int Length;
        /// <summary>
        /// Width of the schematic, in blocks
        /// </summary>
        public readonly int Width;
        /// <summary>
        /// Height of the schematic, in blocks
        /// </summary>
        public readonly int Height;

        private readonly int[] _blocks;
        private readonly bool[] _blockFlags;
        private readonly byte[] _addId = new byte[0];

        /// <summary>
        /// Creates a new Schematic from the given file
        /// </summary>
        /// <param name="fileName">The filename of the schematic</param>
        public Schematic(string fileName)
        {
            if (!File.Exists(fileName))
                throw new FileNotFoundException("Schematic file not found!", fileName);
            _nFile = new NbtFile(fileName);
            //Console.WriteLine(nFile.RootTag);
            Length = _nFile.RootTag["Length"].IntValue;
            Width = _nFile.RootTag["Width"].IntValue;
            Height = _nFile.RootTag["Height"].IntValue;

            _blocks = _nFile.RootTag["Blocks"].ByteArrayValue.Select(x => (int)x).ToArray();

            _blockFlags = new bool[_blocks.Length];
            _blockFlags.Populate(false);

            if (_nFile.RootTag["AddBlocks"] != null)
                _addId = _nFile.RootTag["AddBlocks"].ByteArrayValue;

            //Console.WriteLine(getTileEntities());

            for (var index = 0; index < _blocks.Length; index++)
                if (index >> 1 < _addId.Length)
                    if ((index & 1) == 0)
                        _blocks[index] = ((_addId[index >> 1] & 0x0F) << 8) + _blocks[index];
                    else
                        _blocks[index] = ((_addId[index >> 1] & 0xF0) << 4) + _blocks[index];
        }

        /// <summary>
        /// Gets the block ID at the position
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <returns>The block ID at XYZ</returns>
        private int GetBlockIdAt(int x, int y, int z)
        {
            return _blocks[(y * Length + z) * Width + x];
        }

        /// <summary>
        /// Gets the block metadata at the position
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <returns>The block metadata at XYZ</returns>
        public int GetBlockMetadataAt(int x, int y, int z)
        {
            return _nFile.RootTag["Data"].ByteArrayValue[(y * Length + z) * Width + x];
        }

        /// <summary>
        /// Gets the tile entities
        /// </summary>
        /// <returns>A NbtList of tile entities</returns>
        public NbtList GetTileEntities()
        {
            return (NbtList)_nFile.RootTag["TileEntities"];
        }

        /// <summary>
        /// Gets the tile entity at the position
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <returns>A NbtCompound that represents the tile entity</returns>
        public NbtCompound GetTileEntityAt(int x, int y, int z)
        {
            return GetTileEntities().Cast<NbtCompound>().FirstOrDefault(c => c["x"].IntValue == x && c["y"].IntValue == y && c["z"].IntValue == z);
        }

        /// <summary>
        /// Gets the block at the position
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <returns>The block at the position</returns>
        public Block GetBlockAt(int x, int y, int z)
        {
            var id = GetBlockIdAt(x, y, z);
            return IdMapper.Instance.GetBlockFromId(id);
        }

        /// <summary>
        /// Sets the block flag at the position
        /// A true flag indicates that the block will not be included in the generation output
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <param name="flag">Block flag</param>
        public void SetFlagAt(int x, int y, int z, bool flag)
        {
            _blockFlags[(y * Length + z) * Width + x] = flag;
        }

        /// <summary>
        /// Gets the block flag at the position
        /// A true flag indicates that the block will not be included in the generation output
        /// </summary>
        /// <param name="x">X</param>
        /// <param name="y">Y</param>
        /// <param name="z">Z</param>
        /// <returns>The block flag</returns>
        public bool GetFlagAt(int x, int y, int z)
        {
            return _blockFlags[(y * Length + z) * Width + x];
        }

        public int Size()
        {
            return _blocks.Length;
        }
    }
}
