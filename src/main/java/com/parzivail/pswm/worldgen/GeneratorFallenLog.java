package com.parzivail.pswm.worldgen;

import com.parzivail.util.math.MathUtils;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class GeneratorFallenLog
{
	private IBlockState log;

	public GeneratorFallenLog(IBlockState log)
	{
		this.log = log;
	}

	public boolean setLog(World world, BlockPos pos, EnumFacing.Axis axis)
	{
		IBlockState directedLog = (axis != null) ? this.log.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(axis)) : this.log;
		world.setBlockState(pos, directedLog, 2);
		world.setBlockState(pos.east(), directedLog, 2);
		world.setBlockState(pos.west(), directedLog, 2);
		world.setBlockState(pos.north(), directedLog, 2);
		world.setBlockState(pos.south(), directedLog, 2);
		world.setBlockState(pos.up(), directedLog, 2);
		world.setBlockState(pos.down(), directedLog, 2);
		return true;
	}

	public boolean generate(World world, Random random, BlockPos start, BlockPos end)
	{
		for (; !world.getBlockState(start.down()).isSideSolid(world, start.down(), EnumFacing.UP); start = start.down())
			;
		for (; !world.getBlockState(end.down()).isSideSolid(world, end.down(), EnumFacing.UP); end = end.down())
			;

		traverse(world, start, end);

		return true;
	}

	private void traverse(World world, BlockPos start, BlockPos end)
	{
		double angle = Math.atan2(end.getZ() - start.getZ(), end.getX() - start.getX()) * 180 / Math.PI;
		EnumFacing ordinal = EnumFacing.getHorizontal(MathHelper.floor(angle * 4.0F / 360.0F + 0.5D) & 3).rotateY();

		int gx0 = start.getX();
		int gy0 = start.getY();
		int gz0 = start.getZ();

		int gx1 = end.getX();
		int gy1 = end.getY();
		int gz1 = end.getZ();

		int sx = gx1 > gx0 ? 1 : gx1 < gx0 ? -1 : 0;
		int sy = gy1 > gy0 ? 1 : gy1 < gy0 ? -1 : 0;
		int sz = gz1 > gz0 ? 1 : gz1 < gz0 ? -1 : 0;

		int gx = gx0;
		int gy = gy0;
		int gz = gz0;

		//Planes for each axis that we will next cross
		int gxp = gx0 + (gx1 > gx0 ? 1 : 0);
		int gyp = gy0 + (gy1 > gy0 ? 1 : 0);
		int gzp = gz0 + (gz1 > gz0 ? 1 : 0);

		//Only used for multiplying up the error margins
		int vx = gx1 == gx0 ? 1 : gx1 - gx0;
		int vy = gy1 == gy0 ? 1 : gy1 - gy0;
		int vz = gz1 == gz0 ? 1 : gz1 - gz0;

		//Error is normalized to vx * vy * vz so we only have to multiply up
		double vxvy = vx * vy;
		double vxvz = vx * vz;
		double vyvz = vy * vz;

		//Error from the next plane accumulators, scaled up by vx*vy*vz
		double errx = (gxp - gx0) * vyvz;
		double erry = (gyp - gy0) * vxvz;
		double errz = (gzp - gz0) * vxvy;

		double derrx = sx * vyvz;
		double derry = sy * vxvz;
		double derrz = sz * vxvy;

		double testEscape = MathUtils.randomRange(3, 50);
		do
		{
			setLog(world, new BlockPos(gx, gy, gz), ordinal.getAxis());

			//Which plane do we cross first?
			double xr = Math.abs(errx);
			double yr = Math.abs(erry);
			double zr = Math.abs(errz);

			if (sx != 0 && (sy == 0 || xr < yr) && (sz == 0 || xr < zr))
			{
				gx += sx;
				errx += derrx;
			}
			else if (sy != 0 && (sz == 0 || yr < zr))
			{
				gy += sy;
				erry += derry;
			}
			else if (sz != 0)
			{
				gz += sz;
				errz += derrz;
			}
		}
		while (testEscape-- > 0);
	}
}