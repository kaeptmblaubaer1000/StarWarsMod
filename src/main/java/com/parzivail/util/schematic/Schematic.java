package com.parzivail.util.schematic;

/**
 * @author Colby
 */

import com.parzivail.pswm.Resources;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.io.InputStream;

public class Schematic
{
	public NBTTagList tileentities;
	public int width;
	public int height;
	public int length;
	public BlockInfo[] blocks;

	public Schematic(String schematic)
	{
		try
		{
			Lumberjack.log("Loading schematic " + schematic);
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/schematics/" + schematic + ".schematic");
			NBTTagCompound nbtdata = CompressedStreamTools.readCompressed(is);
			width = nbtdata.getShort("Width");
			height = nbtdata.getShort("Height");
			length = nbtdata.getShort("Length");

			byte[] _blocks = nbtdata.getByteArray("Blocks");

			byte[] metadata = nbtdata.getByteArray("Data");

			byte[] addId = nbtdata.getByteArray("AddBlocks");

			blocks = new BlockInfo[_blocks.length];

			for (int index = 0; index < _blocks.length; index++)
			{
				int n = _blocks[index];
				if (index >> 1 < addId.length)
				{
					if ((index & 1) == 0)
						n = (((addId[index >> 1] & 0x0F) << 8) + _blocks[index]);
					else
						n = (((addId[index >> 1] & 0xF0) << 4) + _blocks[index]);
				}
				blocks[index] = new BlockInfo(n, metadata[index]);
			}

			tileentities = nbtdata.getTagList("TileEntities", 10);
			is.close();
			Lumberjack.log("Loading SUCCESSFUL");
		}
		catch (Exception e)
		{
			Lumberjack.log("Loading FAILED");
			e.printStackTrace();
		}
	}

	public NBTTagList getTileEntities()
	{
		return tileentities;
	}

	public BlockInfo getBlockAt(int x, int y, int z)
	{
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return blocks[(y * length + z) * width + x];
	}

	public NBTTagCompound getTileNbtAt(int x, int y, int z)
	{
		for (int i = 0; i < tileentities.tagCount(); i++)
		{
			NBTTagCompound tileEntity = tileentities.getCompoundTagAt(i);
			if (tileEntity.getInteger("x") == x && tileEntity.getInteger("y") == y && tileEntity.getInteger("z") == z)
				return tileEntity;
		}
		return null;
	}

	public int size()
	{
		return blocks.length;
	}

	public void spawn(World world, int chunkX, int spawnY, int chunkZ)
	{
		if (chunkX >= 0 && chunkX < width && chunkZ >= 0 && chunkZ < length)
		{
			int nX = Math.min(chunkX + 16, width - 1);
			int nZ = Math.min(chunkZ + 16, length - 1);

			for (int x = chunkX; x < nX; x++)
				for (int z = chunkZ; z < nZ; z++)
					for (int y = 0; y < height; y++)
					{
						BlockInfo bi = getBlockAt(x, y, z);

						Block b = PBlockMap.idToBlock(bi.block);
						world.setBlock(x, y + spawnY, z, b, bi.metadata, 2);
						world.setBlockMetadataWithNotify(x, y + spawnY, z, bi.metadata, 2);

						// TODO: tile entities and entity spawns

						if (b instanceof ITileEntityProvider)
						{
							NBTTagCompound compound = getTileNbtAt(x, y, z);
							if (compound != null)
							{
								TileEntity t = world.getTileEntity(x, y + spawnY, z);
								compound.setInteger("x", x);
								compound.setInteger("y", y + spawnY);
								compound.setInteger("z", z);
								if (t != null)
								{
									t.readFromNBT(compound);
								}
							}
						}
					}
		}
	}
}