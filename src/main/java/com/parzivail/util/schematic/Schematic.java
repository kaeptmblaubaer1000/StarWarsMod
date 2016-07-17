package com.parzivail.util.schematic;

/**
 * @author Colby
 */

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.world.NbtPack;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Schematic
{
	public int width;
	public int height;
	public int length;
	public BlockInfo[] blockInfos;

	private NbtPack pack;

	private List<NBTTagCompound> tileEntities = new ArrayList<>();
	private List<NBTTagCompound> entities = new ArrayList<>();

	public Schematic(String schematic, NbtPack pack)
	{
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/schematics/" + schematic + ".schematic");
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);

			width = tag.getShort("Width");
			height = tag.getShort("Height");
			length = tag.getShort("Length");

			// read in block data; Vanilla lower byte array
			loadBlocks(tag);

			// load tileEntities
			loadTiles(tag);

			loadEntities(tag);

			is.close();
			Lumberjack.log("Loaded schematic " + schematic);

			this.pack = pack;
		}
		catch (Exception e)
		{
			Lumberjack.log("Loading " + schematic + " FAILED");
			e.printStackTrace();
		}
	}

	private void loadEntities(NBTTagCompound tag)
	{
		NBTTagList entityTag = (NBTTagList)tag.getTag("Entities");

		for (int i = 0; i < entityTag.tagCount(); i++)
		{
			entities.add(entityTag.getCompoundTagAt(i));
		}
	}

	private void loadTiles(NBTTagCompound tag)
	{
		NBTTagList tileEntityTag = (NBTTagList)tag.getTag("TileEntities");

		for (int i = 0; i < tileEntityTag.tagCount(); i++)
		{
			tileEntities.add(tileEntityTag.getCompoundTagAt(i));
		}
	}

	private void loadBlocks(NBTTagCompound tag)
	{
		byte[] b_lower = tag.getByteArray("Blocks");

		byte[] addBlocks = new byte[0];
		// Check and load Additional blocks array
		if (tag.hasKey("AddBlocks"))
		{
			addBlocks = tag.getByteArray("AddBlocks");
		}

		blockInfos = new BlockInfo[b_lower.length];

		byte[] blockData = tag.getByteArray("Data");
		short n;
		for (int index = 0; index < b_lower.length; index++)
		{
			if (index >> 1 >= addBlocks.length)
				n = (short)(b_lower[index] & 0xFF);
			else if ((index & 1) == 0)
				n = (short)(((addBlocks[index >> 1] & 0x0F) << 8) + (b_lower[index] & 0xFF));
			else
				n = (short)(((addBlocks[index >> 1] & 0xF0) << 4) + (b_lower[index] & 0xFF));
			blockInfos[index] = new BlockInfo(n, blockData[index]);
		}
	}

	public List<NBTTagCompound> getTileEntities()
	{
		return tileEntities;
	}

	public BlockInfo getBlockAt(int x, int y, int z)
	{
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return blockInfos[(y * length + z) * width + x];
	}

	public NBTTagCompound getTileNbtAt(int x, int y, int z)
	{
		for (NBTTagCompound tileEntity : tileEntities)
			if (tileEntity.getInteger("x") == x && tileEntity.getInteger("y") == y && tileEntity.getInteger("z") == z)
				return tileEntity;
		return null;
	}

	public int size()
	{
		return blockInfos.length;
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

						Block b = pack.blockMap.get((int)bi.block);
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