package com.parzivail.util.world;

import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;

public class WorldUtils
{
	public static String getBiomeName(int x, int z)
	{
		return Minecraft.getMinecraft().theWorld.getBiomeGenForCoords(x, z).biomeName;
	}

	public static Block getBlockAt(int x, int y, int z)
	{
		return Minecraft.getMinecraft().theWorld.getBlock(x, y, z);
	}

	public static void registerDimension(int dimId)
	{
		DimensionManager.registerDimension(dimId, dimId);
		FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("World registered for " + WorldProvider.getProviderForDimension(dimId).getDimensionName());
	}

	public static void registerDimension(int dimId, Class<? extends WorldProvider> class1)
	{
		DimensionManager.registerProviderType(dimId, class1, true);
		DimensionManager.registerDimension(dimId, dimId);
		// WorldServer s =
		// FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("Provider and World registered for " + dimId);
	}

	public static void unregisterDimension(int dimId)
	{
		DimensionManager.unregisterDimension(dimId);
		Lumberjack.log("Provider and World unregistered for " + dimId);
	}
	
	/**
     * Sets the block ID and metadata at a given location. Args: X, Y, Z, new block ID, new metadata, flags. Flag 1 will
     * cause a block update. Flag 2 will send the change to clients (you almost always want this). Flag 4 prevents the
     * block from being re-rendered, if this is a client world. Flags can be added together.
     */
	public static boolean setBlock(World world, int x, int y, int z, Block block, int metadata, int flags)
	{
		if (x >= -30000000 && z >= -30000000 && x < 30000000 && z < 30000000)
		{
			if (y < 0)
			{
				return false;
			}
			else if (y >= 256)
			{
				return false;
			}
			else
			{
				Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
				Block block1 = null;
				net.minecraftforge.common.util.BlockSnapshot blockSnapshot = null;

				if ((flags & 1) != 0)
				{
					block1 = chunk.getBlock(x & 15, y, z & 15);
				}

				if (world.captureBlockSnapshots && !world.isRemote)
				{
					blockSnapshot = net.minecraftforge.common.util.BlockSnapshot.getBlockSnapshot(world, x, y, z, flags);
					world.capturedBlockSnapshots.add(blockSnapshot);
				}

				boolean flag = chunk.func_150807_a(x & 15, y, z & 15, block, metadata);

				if (!flag && blockSnapshot != null)
				{
					world.capturedBlockSnapshots.remove(blockSnapshot);
					blockSnapshot = null;
				}

				if (flag && blockSnapshot == null)
				{
					// Modularize client and physic updates
					world.markAndNotifyBlock(x, y, z, chunk, block1, block, flags);
				}

				return flag;
			}
		}
		else
		{
			return false;
		}
	}
}