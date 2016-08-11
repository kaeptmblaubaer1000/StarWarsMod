package com.parzivail.util.schematic;

/**
 * @author Colby
 */

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.blocks.BlockGunRack;
import com.parzivail.pswm.world.NbtBlockMap;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
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

	private NbtBlockMap pack;

	private List<NBTTagCompound> tileEntities = new ArrayList<>();
	private List<NBTTagCompound> entities = new ArrayList<>();

	public Schematic(String schematic, NbtBlockMap pack)
	{
		Lumberjack.log("Loading schematic " + schematic + "...");
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

	public void genComposite(World world, int chunkX, int spawnY, int chunkZ, int posChunkX, int posChunkZ)
	{
		int pX = posChunkX * 16;
		int pZ = posChunkZ * 16;
		int fCX = (chunkX - pX);
		int fCZ = (chunkZ - pZ);
		if (fCX >= 0 && fCX < width && fCZ >= 0 && fCZ < length)
		{
			int nX = Math.min(fCX + 16, width - 1);
			int nZ = Math.min(fCZ + 16, length - 1);

			for (int x = fCX; x < nX; x++)
				for (int z = fCZ; z < nZ; z++)
					for (int y = 0; y < height; y++)
					{
						BlockInfo bi = getBlockAt(x, y, z);
						if (bi != null)
						{
							Block b = pack.blockMap.get((int)bi.block);
							if (b != null)
							{
								WorldUtils.b(world, pX + x, y + spawnY, pZ + z, b, bi.metadata);
								WorldUtils.m(world, pX + x, y + spawnY, pZ + z, bi.metadata);

								// TODO: lever-chest spawns

								// TODO: make list of torches and go back and place them in a 2nd pass so they don't fall off

								if (b instanceof ITileEntityProvider)
								{
									NBTTagCompound compound = getTileNbtAt(x, y, z);
									if (compound != null)
									{
										TileEntity t = world.getTileEntity(pX + x, y + spawnY, pZ + z);
										if (t != null)
										{
											compound.setInteger("x", pX + x);
											compound.setInteger("y", y + spawnY);
											compound.setInteger("z", pZ + z);

											// reverse-id-lookup all things that have itemstacks saved to NBT (gunracks, chests)
											if (b instanceof BlockGunRack)
											{
												NBTTagList nbttaglist = compound.getTagList("guns", 10);
												NBTTagList newList = fixItemStacks(nbttaglist);
												compound.setTag("guns", newList);
											}
											else if (b instanceof BlockChest)
											{
												NBTTagList nbttaglist = compound.getTagList("Items", 10);
												NBTTagList newList = fixItemStacks(nbttaglist);
												compound.setTag("Items", newList);
											}

											t.readFromNBT(compound);
										}
									}
								}
							}
						}
					}
		}
	}

	private NBTTagList fixItemStacks(NBTTagList nbttaglist)
	{
		NBTTagList newList = new NBTTagList();
		for (int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound item = nbttaglist.getCompoundTagAt(i);
			int oldId = item.getInteger("id");
			int newId = pack.translateId(oldId);
			item.setInteger("id", newId);
			newList.appendTag(item);
		}
		return newList;
	}
}