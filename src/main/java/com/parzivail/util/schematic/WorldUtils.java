package com.parzivail.util.schematic;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Colby on 2/9/2017.
 */
public class WorldUtils
{
	public static void b(World world, int x, int i1, int i2, Block b, byte metadata)
	{
		world.setBlockState(new BlockPos(x, i1, i2), b.getStateFromMeta(metadata));
	}

	@Deprecated
	public static void m(World world, int i, int i1, int i2, byte metadata)
	{
		// Do nothing.
	}
}
