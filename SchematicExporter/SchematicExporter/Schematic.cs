using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using fNbt;

namespace SchematicExporter
{
    class Schematic
    {
        NbtFile nFile;

        public int length;
        public int width;
        public int height;

        public Schematic(string fileName)
        {
            nFile = new NbtFile(fileName);
            length = nFile.RootTag["Length"].IntValue;
            width = nFile.RootTag["Width"].IntValue;
            height = nFile.RootTag["Height"].IntValue;
        }

        public int getBlockIdAt(int x, int y, int z)
        {
            return nFile.RootTag["Blocks"].ByteArrayValue[(y * length + z) * width + x];
        }

        public int getBlockMetadataAt(int x, int y, int z)
        {
            return nFile.RootTag["Data"].ByteArrayValue[(y * length + z) * width + x];
        }

        public Block getBlockAt(int x, int y, int z)
        {
            int id = getBlockIdAt(x, y, z);
            int meta = getBlockMetadataAt(x, y, z);
            return BlockMapper.instance.getBlockFromId(id, meta);
        }
    }
}
