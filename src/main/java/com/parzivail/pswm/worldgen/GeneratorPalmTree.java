package com.parzivail.pswm.worldgen;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorPalmTree
{
	private IBlockState log;
	private IBlockState leaves;
	private int minHeight;
	private int maxHeight;

	public GeneratorPalmTree(IBlockState log, IBlockState leaves, int minHeight, int maxHeight)
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
			if (MathUtils.oneIn(3))
			{
				switch (random.nextInt(4))
				{
					case 0:
						pos = pos.north();
						break;
					case 1:
						pos = pos.south();
						break;
					case 2:
						pos = pos.east();
						break;
					case 3:
						pos = pos.west();
						break;
				}
			}
			this.setLog(world, pos);
			pos = pos.up();
		}
		generateFronds(world, random, pos);
	}

	private void generateFronds(World world, Random random, BlockPos pos)
	{
		int radiusMax = MathUtils.randomRange(4, 6);
		for (double angle = 0; angle < MathUtils.TWO_PI; angle += MathUtils.TWO_PI_OVER_EIGHT)
		{
			for (int radius = 0; radius < radiusMax; radius++)
			{
				BlockPos leavesPos = pos.add(Math.round(radius * MathHelper.cos((float)angle)), -Math.round(radius / 2), Math.round(radius * MathHelper.sin((float)angle)));
				this.setLeaves(world, leavesPos);
			}
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

	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP))
			return false;

		// Choose heights
		int height = MathUtils.randomRange(this.minHeight, this.maxHeight);

		//Generate the trunk to 1 block below the height
		this.generateTrunk(world, random, pos, height - 1);

		return true;
	}
}