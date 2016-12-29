package com.parzivail.util.worldgen;

import net.minecraft.util.math.MathHelper;

/**
 * Created by colby on 12/28/2016.
 */
public class MultiCompositeTerrain implements ITerrainHeightmap
{
	private final CompositeTerrain[] terrains;
	private final float n;
	private final TerrainLayer lerpNoise;

	public MultiCompositeTerrain(long seed, int noiseScale, CompositeTerrain... terrains)
	{
		this.lerpNoise = new TerrainLayer(seed, TerrainLayer.Method.Add, noiseScale, 1);
		this.terrains = terrains;
		this.n = terrains.length - 1;
	}

	public double getHeightAt(int x, int z)
	{
		double l = getBiomeLerpAmount(x, z);
		double y = 0;
		for (int i = 0; i < terrains.length; i++)
		{
			if ((i - 1f) / n <= l && l <= (i + 1f) / n)
				y += (-Math.abs(n * l - i) + 1) * terrains[i].getHeightAt(x, z);
		}
		return y;
	}

	@Override
	public double getBiomeLerpAmount(int x, int z)
	{
		return MathHelper.clamp(lerpNoise.GetValue(x, z), 0, 1);
	}

	@Override
	public double[] getBiomeWeightsAt(int x, int z)
	{
		// Use this in the future to determine mob spawns, etc.
		// Say, if the mountian biome [length - a], which *should* be the tallest, has a lerp
		// value > 0.8, meaning the current position is > 80% that biome, spawn some mountian-faring
		// billy goats. If the biome [0] > 0.8, it's > 80% "flatlands" per se, so spawn some sheep or something.
		double[] r = new double[terrains.length];
		double l = getBiomeLerpAmount(x, z);
		for (int i = 0; i < terrains.length; i++)
		{
			if ((i - 1f) / n <= l && l <= (i + 1f) / n)
				r[i] = (-Math.abs(n * l - i) + 1);
		}
		return r;
	}
}
