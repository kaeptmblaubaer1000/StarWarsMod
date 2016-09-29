package com.parzivail.util.world;

import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.BlockSnapshot;

public class WorldUtils
{
	/**
	 * Registers a dimension with FML
	 *
	 * @param dimId The Dimension ID
	 */
	public static void registerDimension(int dimId)
	{
		DimensionManager.registerDimension(dimId, dimId);
		FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("World registered for " + WorldProvider.getProviderForDimension(dimId).getDimensionName());
	}

	/**
	 * Registers a dimension with FML
	 *
	 * @param dimId  The Dimension ID
	 * @param class1 The world provider for the dimension
	 */
	public static void registerDimension(int dimId, Class<? extends WorldProvider> class1)
	{
		DimensionManager.registerProviderType(dimId, class1, true);
		DimensionManager.registerDimension(dimId, dimId);
		// WorldServer s =
		// FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("Provider and World registered for " + dimId);
	}

	/**
	 * Sets the block ID and metadata at a given location. Args: X, Y, Z, new block ID, new metadata, flags. Flag 1 will
	 * cause a block update. Flag 2 will send the change to clients (you almost always want this). Flag 4 prevents the
	 * block from being re-rendered, if this is a client world. Flags can be added together.
	 */
	public static boolean setBlock(World world, int x, int y, int z, Block block, int metadata, int flags)
	{
		if (x < -30000000 || z < -30000000 || x >= 30000000 || z >= 30000000 || y < 0 || y >= 256)
			return false;

		Chunk chunk = world.getChunkFromChunkCoords(x >> 4, z >> 4);
		Block block1 = null;
		BlockSnapshot blockSnapshot = null;

		if ((flags & 1) != 0)
		{
			block1 = chunk.getBlock(x & 15, y, z & 15);
		}

		if (world.captureBlockSnapshots && !world.isRemote)
		{
			blockSnapshot = BlockSnapshot.getBlockSnapshot(world, x, y, z, flags);
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

	public static void b(World world, int x, int y, int z, Block block, int metadata)
	{
		setBlock(world, x, y, z, block, metadata, 1);
	}

	public static void m(World world, int x, int y, int z, int metadata)
	{
		world.setBlockMetadataWithNotify(x, y, z, metadata, 1);
	}
}