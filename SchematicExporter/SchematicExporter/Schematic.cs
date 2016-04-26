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

        private int[] blocks;
        private byte[] addId = new byte[0];

        public Schematic(string fileName)
        {
            nFile = new NbtFile(fileName);
            //Console.WriteLine(nFile.RootTag);
            length = nFile.RootTag["Length"].IntValue;
            width = nFile.RootTag["Width"].IntValue;
            height = nFile.RootTag["Height"].IntValue;

            blocks = nFile.RootTag["Blocks"].ByteArrayValue.Select(x => (int)x).ToArray();

            if (nFile.RootTag["AddBlocks"].HasValue)
                addId = nFile.RootTag["AddBlocks"].ByteArrayValue;

            for (int index = 0; index < blocks.Length; index++)
                if ((index >> 1) < addId.Length)
                    if ((index & 1) == 0)
                        blocks[index] = (((addId[index >> 1] & 0x0F) << 8) + blocks[index]);
                    else
                        blocks[index] = (((addId[index >> 1] & 0xF0) << 4) + blocks[index]);
        }

        public int getBlockIdAt(int x, int y, int z)
        {
            return blocks[(y * length + z) * width + x];
        }

        public int getBlockMetadataAt(int x, int y, int z)
        {
            return nFile.RootTag["Data"].ByteArrayValue[(y * length + z) * width + x];
        }

        public NbtList getTileEntities()
        {
            return (NbtList)nFile.RootTag["TileEntities"];
        }

        public Block getBlockAt(int x, int y, int z)
        {
            int id = getBlockIdAt(x, y, z);
            int meta = getBlockMetadataAt(x, y, z);
            return BlockMapper.instance.getBlockFromId(id, meta);
        }
    }
}
