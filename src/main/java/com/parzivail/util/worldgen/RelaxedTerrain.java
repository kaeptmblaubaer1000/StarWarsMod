package com.parzivail.util.worldgen;

/**
 * Created by colby on 5/9/2017.
 */
public class RelaxedTerrain implements ITerrainHeightmap
{
	private final ITerrainHeightmap terrain;
	private final int relaxation;

	public RelaxedTerrain(ITerrainHeightmap terrain, int relaxation)
	{

		this.terrain = terrain;
		this.relaxation = relaxation;
	}

	public int blur(int sx, int sy, int r)
	{
		double total = 0;
		int pxls = 0;
		int resolution = (2 * r / 5);
		for (int rx = -r; rx <= r; rx += resolution)
			for (int ry = -r; ry <= r; ry += resolution)
			{
				total += terrain.getHeightAt(sx + rx + 1, sy + ry + 1);
				pxls++;
			}
		return (int)Math.floor(total / pxls - 1);
	}

	@Override
	public double getHeightAt(int x, int z)
	{
		return blur(x, z, this.relaxation);
	}

	@Override
	public double getBiomeLerpAmount(int x, int z)
	{
		return 0;
	}

	@Override
	public double[] getBiomeWeightsAt(int x, int z)
	{
		return new double[0];
	}
}
