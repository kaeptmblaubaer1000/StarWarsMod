package com.parzivail.util.schematic;

/**
 * @author Colby
 */

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.blocks.BlockGunRack;
import com.parzivail.pswm.blocks.BlockMV;
import com.parzivail.pswm.items.ItemSpawnAstromech;
import com.parzivail.pswm.items.ItemSpawnProtocol;
import com.parzivail.pswm.items.weapons.ItemGaffiStick;
import com.parzivail.pswm.mobs.MobDroidAstromech;
import com.parzivail.pswm.mobs.MobDroidProtocol;
import com.parzivail.pswm.utils.LootGenUtils;
import com.parzivail.pswm.world.NbtBlockMap;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.world.ItemUtils;
import com.parzivail.util.world.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schematic
{
	public int width;
	public int height;
	public int length;

	public short[] blocks;
	public byte[] metadatas;

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

		blocks = new short[b_lower.length];
		metadatas = tag.getByteArray("Data");

		short n;
		for (int index = 0; index < b_lower.length; index++)
		{
			if (index >> 1 >= addBlocks.length)
				n = (short)(b_lower[index] & 0xFF);
			else if ((index & 1) == 0)
				n = (short)(((addBlocks[index >> 1] & 0x0F) << 8) + (b_lower[index] & 0xFF));
			else
				n = (short)(((addBlocks[index >> 1] & 0xF0) << 4) + (b_lower[index] & 0xFF));
			blocks[index] = n;
		}
	}

	public List<NBTTagCompound> getTileEntities()
	{
		return tileEntities;
	}

	public short getBlockAt(int x, int y, int z)
	{
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return blocks[(y * length + z) * width + x];
	}

	public byte getMetadataAt(int x, int y, int z)
	{
		//int i = (y * length + z) * width + x;
		//return (i >= size()) ? null : blocks[i];
		return metadatas[(y * length + z) * width + x];
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
		return blocks.length;
	}

	public void genComposite(World world, int chunkX, int spawnY, int chunkZ, int posChunkX, int posChunkZ)
	{
		int pX = posChunkX * 16;
		int pZ = posChunkZ * 16;
		int fCX = (chunkX - pX);
		int fCZ = (chunkZ - pZ);
		HashMap<Vec3, BlockInfo> torches = new HashMap<>();
		if (fCX >= 0 && fCX < width && fCZ >= 0 && fCZ < length)
		{
			int nX = Math.min(fCX + 16, width - 1);
			int nZ = Math.min(fCZ + 16, length - 1);

			for (int x = fCX; x < nX; x++)
				for (int z = fCZ; z < nZ; z++)
					for (int y = 0; y < height; y++)
					{
						gen(world, spawnY, pX, pZ, torches, x, z, y);
					}
		}

		genSecondPass(world, torches);
	}

	public void genFull(World world, int posChunkX, int spawnY, int posChunkZ)
	{
		HashMap<Vec3, BlockInfo> secondPass = new HashMap<>();

		for (int x = 0; x < width; x++)
			for (int z = 0; z < length; z++)
				for (int y = 0; y < height; y++)
				{
					gen(world, spawnY, posChunkX, posChunkZ, secondPass, x, z, y);
				}

		genSecondPass(world, secondPass);
	}

	private void genSecondPass(World world, HashMap<Vec3, BlockInfo> secondPass)
	{
		for (Vec3 p : secondPass.keySet())
		{
			int x = (int)p.xCoord;
			int y = (int)p.yCoord;
			int z = (int)p.zCoord;
			BlockInfo bi = secondPass.get(p);
			Block b = pack.blockMap.get((int)bi.block);
			WorldUtils.b(world, x, y, z, b, bi.metadata);
			WorldUtils.m(world, x, y, z, bi.metadata);
		}
	}

	private void gen(World world, int spawnY, int pX, int pZ, HashMap<Vec3, BlockInfo> secondPass, int x, int z, int y)
	{
		short block = getBlockAt(x, y, z);
		byte metadata = getMetadataAt(x, y, z);

		Block b = pack.blockMap.get((int)block);
		if (b != null)
		{
			if (b == Blocks.torch || b == Blocks.bed || b == Blocks.wall_sign)
			{
				secondPass.put(Vec3.createVectorHelper(pX + x, y + spawnY, pZ + z), new BlockInfo(block, metadata));
				return;
			}
			else if (b == Blocks.snow)
				b = StarWarsMod.blockHardpackSnow;
			WorldUtils.b(world, pX + x, y + spawnY, pZ + z, b, metadata);
			WorldUtils.m(world, pX + x, y + spawnY, pZ + z, metadata);

			if (b instanceof ITileEntityProvider)
			{
				NBTTagCompound compound = getTileNbtAt(x, y, z);
				if (compound != null)
				{
					NBTTagCompound newTile = (NBTTagCompound)compound.copy();
					TileEntity t = world.getTileEntity(pX + x, y + spawnY, pZ + z);
					if (t != null)
					{
						newTile.setInteger("x", pX + x);
						newTile.setInteger("y", y + spawnY);
						newTile.setInteger("z", pZ + z);

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

				if (world.provider.dimensionId == Resources.ConfigOptions.dimYavin4Id && pX + x == 190 && y + spawnY == 54 && pZ + z == 135)
				{
					WorldUtils.b(world, pX + x, y + spawnY, pZ + z, StarWarsMod.blockStaticNpcRebelDreis, 0);
					WorldUtils.m(world, pX + x, y + spawnY, pZ + z, 0);
				}

				if (b == Blocks.chest)
				{
					TileEntityChest t = (TileEntityChest)world.getTileEntity(pX + x, y + spawnY, pZ + z);
					if (world.provider.dimensionId == Resources.ConfigOptions.dimYavin4Id)
					{
						if (pX + x == 189 && y + spawnY == 110 && pZ + z == 145)
							for (int i = 0; i < 27; i++)
								t.setInventorySlotContents(i, new ItemStack(StarWarsItems.xwingSchematics, 1));
					}
					else if (world.provider.dimensionId == Resources.ConfigOptions.dimEndorId && pX + x == 480 && y + spawnY == 63 && pZ + z == 129)
					{
						for (int i = 0; i < 27; i++)
							t.setInventorySlotContents(i, new ItemStack(StarWarsItems.tieSchematics, 1));
					}
					else if (ItemUtils.isChestEmpty(t))
					{
						LootGenUtils.fillLootChest(world.provider.dimensionId, world.rand, t);
					}
					else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemSpawnProtocol)
					{
						WorldUtils.b(world, pX + x, y + spawnY, pZ + z, Blocks.air, 0);
						WorldUtils.m(world, pX + x, y + spawnY, pZ + z, 0);

						MobDroidProtocol p = new MobDroidProtocol(world);
						p.setPositionAndUpdate(pX + x, y + spawnY, pZ + z);
						world.spawnEntityInWorld(p);
					}
					else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemSpawnAstromech)
					{
						WorldUtils.b(world, pX + x, y + spawnY, pZ + z, Blocks.air, 0);
						WorldUtils.m(world, pX + x, y + spawnY, pZ + z, 0);

						MobDroidAstromech p = new MobDroidAstromech(world);
						p.setPositionAndUpdate(pX + x, y + spawnY, pZ + z);
						world.spawnEntityInWorld(p);
					}
					else if (t.getStackInSlot(1) != null && t.getStackInSlot(1).getItem() instanceof ItemGaffiStick)
					{
						WorldUtils.b(world, pX + x, y + spawnY, pZ + z, Blocks.air, 0);
						WorldUtils.m(world, pX + x, y + spawnY, pZ + z, 0);
					}
				}
			}
			b = null;
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