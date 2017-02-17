package com.parzivail.util.schematic;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.blocks.BlockGunRack;
import com.parzivail.pswm.blocks.BlockMV;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Colby on 2/9/2017.
 */
public class ChunkSchematic
{
	private int x;
	private int y;
	private int z;
	public int width;
	public int height;
	public int length;

	public short[] blocks;
	public byte[] metadatas;

	private EmbeddedNbtBlockMap pack;

	private List<NBTTagCompound> tileEntities = new ArrayList<>();
	private List<NBTTagCompound> entities = new ArrayList<>();

	public boolean loaded = false;

	public ChunkSchematic(String schematic)
	{
		Lumberjack.log("Loading schematic " + schematic + "...");
		try
		{
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/" + Resources.MODID + "/schematics/" + schematic + ".schematic");
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);

			width = tag.getShort("Width");
			height = tag.getShort("Height");
			length = tag.getShort("Length");

			this.x = tag.getInteger("WEOriginX");
			this.y = tag.getInteger("WEOriginY");
			this.z = tag.getInteger("WEOriginZ");

			// read in block data; Vanilla lower byte array
			loadBlocks(tag);

			// load tileEntities
			loadTiles(tag);

			loadEntities(tag);

			is.close();

			this.pack = new EmbeddedNbtBlockMap(tag);

			loaded = true;

			Lumberjack.log("Loaded schematic " + schematic);
		}
		catch (Exception e)
		{
			Lumberjack.err("Loading " + schematic + " FAILED");
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
		int[] temp = tag.getIntArray("FullBlocks");
		blocks = new short[temp.length * 2];

		for (int i = 0; i < temp.length; i++)
		{
			// Two shorts are saved in one int to transfer two block IDs
			// Here we extract those shorts.
			blocks[i * 2] = (short)((temp[i] & 0xFFFF0000) >> Short.SIZE);
			blocks[i * 2 + 1] = (short)(temp[i] & 0xFFFF);
		}

		metadatas = tag.getByteArray("Data");

		//		byte[] b_lower = tag.getByteArray("Blocks");
		//
		//		byte[] addBlocks = new byte[0];
		//		// Check and load Additional blocks array
		//		if (tag.hasKey("AddBlocks"))
		//		{
		//			addBlocks = tag.getByteArray("AddBlocks");
		//		}
		//
		//		short n;
		//		for (int index = 0; index < b_lower.length; index++)
		//		{
		//			if (index >> 1 >= addBlocks.length)
		//				n = (short)(b_lower[index] & 0xFF);
		//			else if ((index & 1) == 0)
		//				n = (short)(((addBlocks[index >> 1] & 0x0F) << 8) + (b_lower[index] & 0xFF));
		//			else
		//				n = (short)(((addBlocks[index >> 1] & 0xF0) << 4) + (b_lower[index] & 0xFF));
		//			blocks[index] = n;
		//		}
	}

	public List<NBTTagCompound> getTileEntities()
	{
		return tileEntities;
	}

	public short getBlockAt(int x, int y, int z)
	{
		int idx = getBlockIndex(x, y, z);
		if (!loaded || idx >= blocks.length)
			return 0;
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return blocks[idx];
	}

	private int getBlockIndex(int x, int y, int z)
	{
		return (y * length + z) * width + x;
	}

	public byte getMetadataAt(int x, int y, int z)
	{
		int idx = getBlockIndex(x, y, z);
		if (!loaded || idx >= metadatas.length)
			return 0;
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return metadatas[idx];
	}

	public NBTTagCompound getTileNbtAt(int x, int y, int z)
	{
		if (!loaded)
			return null;
		for (NBTTagCompound tileEntity : tileEntities)
			if (tileEntity.getInteger("x") == x && tileEntity.getInteger("y") == y && tileEntity.getInteger("z") == z)
				return tileEntity;
		return null;
	}

	public int size()
	{
		if (!loaded)
			return 0;
		return blocks.length;
	}

	public boolean tryGen(ChunkPrimer primer, int chunkX, int chunkZ, int bX, int bY, int bZ)
	{
		if (!loaded)
			return false;
		int relativeChunkX = chunkX * 16 - this.x;
		int relativeChunkZ = chunkZ * 16 - this.z;
		int relativeY = bY - this.y;

		if (relativeChunkX >= 0 && relativeChunkX < this.width && relativeChunkZ >= 0 && relativeChunkZ < this.length && relativeY >= 0 && relativeY < this.height)
		{
			genBlocks(primer, relativeChunkX, relativeY, relativeChunkZ, bX, bY, bZ);
			return true;
		}
		return false;
	}

	private void genBlocks(ChunkPrimer primer, int relativeChunkX, int relativeChunkY, int relativeChunkZ, int localX, int localY, int localZ)
	{
		if (!loaded)
			return;
		try
		{
			short block = getBlockAt(localX + relativeChunkX, relativeChunkY, localZ + relativeChunkZ);
			byte metadata = getMetadataAt(localX + relativeChunkX, relativeChunkY, localZ + relativeChunkZ);

			Block b = pack.blockMap.get((int)block);
			if (b != null)
				primer.setBlockState(localX, localY, localZ, b.getStateFromMeta(metadata));
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	private void genTiles(World world, int chunkX, int chunkZ, int relativeX, int relativeY, int relativeZ)
	{
		if (!loaded)
			return;
		short block = getBlockAt(relativeX, relativeY, relativeZ);
		Block b = pack.blockMap.get((int)block);
		if (b != null)
		{
			if (b instanceof ITileEntityProvider)
			{
				NBTTagCompound compound = getTileNbtAt(relativeX, relativeY, relativeZ);
				if (compound != null)
				{
					NBTTagCompound newTile = compound.copy();
					TileEntity t = world.getTileEntity(new BlockPos(chunkX + relativeX, relativeY, chunkZ + relativeZ));
					if (t != null)
					{
						newTile.setInteger("relativeX", chunkX + relativeX);
						newTile.setInteger("relativeY", relativeY);
						newTile.setInteger("relativeZ", chunkZ + relativeZ);

						// reverse-id-lookup all things that have itemstacks saved to NBT (gunracks, chests)
						if (b instanceof BlockGunRack)
						{
							NBTTagList nbttaglist = newTile.getTagList("guns", 10);
							NBTTagList newList = fixItemStacks(nbttaglist);
							newTile.setTag("guns", newList);
						}
						else if (b instanceof BlockChest)
						{
							NBTTagList nbttaglist = newTile.getTagList("Items", 10);
							NBTTagList newList = fixItemStacks(nbttaglist);
							newTile.setTag("Items", newList);
						}
						else if (b instanceof BlockMV)
						{
							newTile.setTag("droplets", new NBTTagCompound());
						}
						t.readFromNBT(newTile);
					}
				}

				// TODO: this is the stuff that fixes little things here and there
				//				if (world.provider.dimensionId == Resources.ConfigOptions.dimYavin4Id && chunkX + relativeX == 190 && relativeY + spawnY == 54 && chunkZ + relativeZ == 135)
				//				{
				//					WorldUtils.b(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, StarWarsMod.blockStaticNpcRebelDreis, 0);
				//					WorldUtils.m(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, 0);
				//				}

				//				if (b == Blocks.chest)
				//				{
				//					TileEntityChest t = (TileEntityChest)world.getTileEntity(chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ);
				//					if (t != null)
				//					{
				//						if (world.provider.dimensionId == Resources.ConfigOptions.dimYavin4Id)
				//						{
				//							if (chunkX + relativeX == 189 && relativeY + spawnY == 110 && chunkZ + relativeZ == 145)
				//								for (int i = 0; i < 27; i++)
				//									t.setInventorySlotContents(i, new ItemStack(StarWarsItems.xwingSchematics, 1));
				//						}
				//						else if (world.provider.dimensionId == Resources.ConfigOptions.dimEndorId && chunkX + relativeX == 480 && relativeY + spawnY == 63 && chunkZ + relativeZ == 129)
				//						{
				//							for (int i = 0; i < 27; i++)
				//								t.setInventorySlotContents(i, new ItemStack(StarWarsItems.tieSchematics, 1));
				//						}
				//						else if (ItemUtils.isChestEmpty(t))
				//						{
				//							LootGenUtils.fillLootChest(world.provider.dimensionId, world.rand, t);
				//						}
				//						else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemSpawnProtocol)
				//						{
				//							WorldUtils.b(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, Blocks.air, 0);
				//							WorldUtils.m(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, 0);
				//
				//							MobDroidProtocol p = new MobDroidProtocol(world);
				//							p.setPositionAndUpdate(chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ);
				//							world.spawnEntityInWorld(p);
				//						}
				//						else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemSpawnAstromech)
				//						{
				//							WorldUtils.b(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, Blocks.air, 0);
				//							WorldUtils.m(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, 0);
				//
				//							MobDroidAstromech p = new MobDroidAstromech(world);
				//							p.setPositionAndUpdate(chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ);
				//							world.spawnEntityInWorld(p);
				//						}
				//						else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemGaffiStick)
				//						{
				//							WorldUtils.b(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, Blocks.air, 0);
				//							WorldUtils.m(world, chunkX + relativeX, relativeY + spawnY, chunkZ + relativeZ, 0);
				//						}
				//					}
				//				}
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
			int newId = pack.translateItemId(oldId);
			item.setInteger("id", newId);
			newList.appendTag(item);
		}
		return newList;
	}
}