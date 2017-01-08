package com.parzivail.pswm.worldgen;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorEndorTree
{
	private IBlockState log;
	private IBlockState leaves;
	private int minHeight;
	private int maxHeight;

	public GeneratorEndorTree(IBlockState log, IBlockState leaves, int minHeight, int maxHeight)
	{
		this.log = log;
		this.leaves = leaves;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}

	public void generateTrunk(World world, Random random, BlockPos pos, int trunkHeight)
	{
		for (int i = 0; i < trunkHeight; i++)
		{
			this.setLog(world, pos);
			this.setLog(world, pos.north());
			this.setLog(world, pos.east());
			this.setLog(world, pos.south());
			this.setLog(world, pos.west());
			pos = pos.up();
		}
	}

	private void setLog(World world, BlockPos pos)
	{
		setLog(world, pos, null);
	}

	public boolean setLog(World world, BlockPos pos, EnumFacing.Axis axis)
	{
		IBlockState directedLog = (axis != null) ? this.log.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(axis)) : this.log;
		world.setBlockState(pos, directedLog, 2);
		return true;
	}

	public boolean setLeaves(World world, BlockPos pos)
	{
		world.setBlockState(pos, this.leaves, 2);
		return true;
	}

	public void generateLeafLayer(World world, Random rand, BlockPos pos, int leafLayerNum)
	{
		//Repeat in intervals of 6, 2 small radius, 4 large
		int index = leafLayerNum % 5;
		int leavesRadius;

		//Alternate between a smaller radius and a larger radius
		//		if (index < 2)
		//			leavesRadius = 3;
		//		else
		//			leavesRadius = 5;
		leavesRadius = index + 2;

		//This may break for larger radii however it will do for this purpose
		double increment = 0.1D;

		for (int radius = leavesRadius; radius >= 0; radius--)
		{
			for (double angle = 0.0F; angle <= Math.PI * 2; angle += increment)
			{
				BlockPos leavesPos = pos.add(Math.round(radius * MathHelper.cos((float)angle)), 0, Math.round(radius * MathHelper.sin((float)angle)));

				if (radius < leavesRadius && !MathUtils.oneIn(2))
					this.setLeaves(world, leavesPos);
			}
		}
	}

	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP))
			return false;

		// Choose heights
		int height = MathUtils.randomRange(this.minHeight, this.maxHeight);

		// Move up to space above ground
		pos = pos.up();

		BlockPos trunkTop = pos;
		//Move upwards until the block above this is air
		for (; !world.isAirBlock(trunkTop.up()); trunkTop = trunkTop.up())
		{
			if (trunkTop.getY() >= 255)
			{
				return false;
			}
		}

		int baseHeight = trunkTop.getY() - pos.getY();
		int trunkHeight = height - baseHeight;

		//Generate the trunk to 1 block below the height
		this.generateTrunk(world, random, pos, height - 1);

		//Generate the layers of leaves
		int max = (int)(trunkHeight * 0.75);
		for (int i = 0; i < max; i++)
		{
			this.generateLeafLayer(world, random, pos.up(height - i), i);
		}

		return true;
	}
}