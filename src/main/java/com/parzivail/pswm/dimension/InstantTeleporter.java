package com.parzivail.pswm.dimension;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

/**
 * Created by colby on 12/22/2016.
 */
public class InstantTeleporter extends Teleporter
{
	private final WorldServer world;

	public InstantTeleporter(WorldServer world)
	{
		super(world);
		this.world = world;
	}

	@Override
	public void placeInPortal(Entity entity, float yaw)
	{
	}

	@Override
	public boolean placeInExistingPortal(Entity entity, float f)
	{
		return true;
	}

	@Override
	public boolean makePortal(Entity entity)
	{
		return true;
	}

	public int getTerrainHeightAt(int x, int z)
	{
		for (int y = 250; y > 0; y--)
		{
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			if (block != Blocks.AIR)
				return y;
		}
		return 0;
	}

	@Override
	public void removeStalePortalLocations(long par1)
	{
	}
}