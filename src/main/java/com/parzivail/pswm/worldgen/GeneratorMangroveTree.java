package com.parzivail.pswm.worldgen;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockVine;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorMangroveTree
{
	private IBlockState log;
	private IBlockState leaves;
	private int minHeight;
	private int maxHeight;

	public GeneratorMangroveTree(IBlockState log, IBlockState leaves, int minHeight, int maxHeight)
	{
		this.log = log;
		this.leaves = leaves;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}

	public void generateTrunk(World world, BlockPos pos, int trunkHeight)
	{
		for (int i = 0; i < trunkHeight; i++)
		{
			this.setLog(world, pos);
			if (i < trunkHeight * 0.25f)
			{
				this.setLog(world, pos.north());
				this.setLog(world, pos.south());
				this.setLog(world, pos.east());
				this.setLog(world, pos.west());
			}
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
		int index = leafLayerNum % 5;
		int leavesRadius;

		leavesRadius = index;

		//This may break for larger radii however it will do for this purpose
		double increment = 0.1D;

		for (int radius = leavesRadius; radius >= 0; radius--)
		{
			for (double angle = 0.0F; angle <= Math.PI * 2; angle += increment)
			{
				BlockPos leavesPos = pos.add(Math.round(radius * MathHelper.cos((float)angle)), 0, Math.round(radius * MathHelper.sin((float)angle)));

				if (radius < leavesRadius && !MathUtils.oneIn(2))
				{
					this.setLeaves(world, leavesPos);

					BlockPos blockpos2 = leavesPos.west();
					BlockPos blockpos3 = leavesPos.east();
					BlockPos blockpos4 = leavesPos.north();
					BlockPos blockpos1 = leavesPos.south();

					if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos2))
					{
						this.addHangingVine(world, blockpos2, BlockVine.EAST);
					}

					if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos3))
					{
						this.addHangingVine(world, blockpos3, BlockVine.WEST);
					}

					if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos4))
					{
						this.addHangingVine(world, blockpos4, BlockVine.SOUTH);
					}

					if (rand.nextInt(4) == 0 && world.isAirBlock(blockpos1))
					{
						this.addHangingVine(world, blockpos1, BlockVine.NORTH);
					}

				}
			}
		}
	}

	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP))
			return false;

		// Choose heights
		int height = MathUtils.randomRange(this.minHeight, this.maxHeight);

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
		this.generateTrunk(world, pos, height - 1);

		//Generate the layers of leaves
		int max = (int)(trunkHeight * 0.75);
		for (int i = 0; i < 4; i++)
		{
			this.generateLeafLayer(world, random, pos.up(height - i), i);
		}

		return true;
	}

	private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop)
	{
		this.addVine(worldIn, pos, prop);
		int i = 4;

		for (pos = pos.down(); worldIn.isAirBlock(pos) && i > 0; --i)
		{
			this.addVine(worldIn, pos, prop);
			pos = pos.down();
		}
	}

	private void addVine(World worldIn, BlockPos pos, PropertyBool prop)
	{
		worldIn.setBlockState(pos, Blocks.VINE.getDefaultState().withProperty(prop, true), 3);
	}
}