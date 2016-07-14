package com.parzivail.util.schematic;

/**
 * @author Colby
 */

import com.parzivail.pswm.Resources;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.io.InputStream;

public class Schematic
{
	public NBTTagList tileentities;
	public int width;
	public int height;
	public int length;
	public int[] blocks;
	public Block[] classBlocks;
	public int[] metadata;
	public byte[] addId;

	public Schematic(String schematic)
	{
		try
		{
			Lumberjack.log("Loading schematic " + schematic);
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/schematics/" + schematic);
			NBTTagCompound nbtdata = CompressedStreamTools.readCompressed(is);
			width = nbtdata.getShort("Width");
			height = nbtdata.getShort("Height");
			length = nbtdata.getShort("Length");

			byte[] _blocks = nbtdata.getByteArray("Blocks");
			blocks = new int[_blocks.length];
			for (int i = 0; i < _blocks.length; i++)
				blocks[i] = _blocks[i];

			byte[] _metadata = nbtdata.getByteArray("Data");
			metadata = new int[_metadata.length];
			for (int i = 0; i < _metadata.length; i++)
				metadata[i] = _metadata[i];

			addId = nbtdata.getByteArray("AddBlocks");

			classBlocks = new Block[_blocks.length];

			for (int index = 0; index < blocks.length; index++)
			{
				if (index >> 1 < addId.length)
					if ((index & 1) == 0)
						blocks[index] = ((addId[index >> 1] & 0x0F) << 8) + blocks[index];
					else
						blocks[index] = ((addId[index >> 1] & 0xF0) << 4) + blocks[index];

				classBlocks[index] = PBlockMap.idToBlock(blocks[index]);
			}

			tileentities = nbtdata.getTagList("TileEntities", 10);
			is.close();
		}
		catch (Exception e)
		{
			Lumberjack.log("Loading FAILED");
			e.printStackTrace();
		}
	}

	public int GetBlockMetadataAt(int x, int y, int z)
	{
		return metadata[(y * length + z) * width + x];
	}

	public NBTTagList GetTileEntities()
	{
		return tileentities;
	}

	public Block GetBlockAt(int x, int y, int z)
	{
		return classBlocks[(y * length + z) * width + x];
	}

	public int Size()
	{
		return blocks.length;
	}
}