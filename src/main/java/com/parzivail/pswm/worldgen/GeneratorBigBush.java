package com.parzivail.pswm.worldgen;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorBigBush
{
	private IBlockState leaves;
	private int minWidth;
	private int maxWidth;

	public GeneratorBigBush(IBlockState leaves, int minWidth, int maxWidth)
	{
		this.leaves = leaves;
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
	}

	public boolean setLeaves(World world, BlockPos pos)
	{
		world.setBlockState(pos, this.leaves, 2);
		return true;
	}

	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP))
			return false;

		// Choose heights
		int width = MathUtils.randomRange(this.minWidth, this.maxWidth);

		for (double angle = 0; angle < MathUtils.TWO_PI; angle += MathUtils.TWO_PI_OVER_TWENTY)
		{
			for (int radius = 0; radius < width; radius++)
			{
				BlockPos leavesPos = pos.add(Math.round(radius * MathHelper.cos((float)angle)), 0, Math.round(radius * MathHelper.sin((float)angle)));
				this.setLeaves(world, leavesPos);
			}

			for (int radius = 0; radius < width / 2f; radius++)
			{
				if (!MathUtils.oneIn(3))
				{
					BlockPos leavesPos = pos.add(Math.round(radius * MathHelper.cos((float)angle)), 1, Math.round(radius * MathHelper.sin((float)angle)));
					this.setLeaves(world, leavesPos);
				}
			}
		}

		return true;
	}
}