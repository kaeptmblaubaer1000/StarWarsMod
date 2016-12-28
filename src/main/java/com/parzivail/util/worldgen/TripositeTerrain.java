package com.parzivail.util.worldgen;

import net.minecraft.util.math.MathHelper;

/**
 * Created by colby on 12/28/2016.
 */
public class TripositeTerrain
{
	private final CompositeTerrain[] terrains = new CompositeTerrain[3];
	private final TerrainLayer lerpNoise;

	public TripositeTerrain(CompositeTerrain terrain0, CompositeTerrain terrain1, CompositeTerrain terrain2, TerrainLayer lerpNoise)
	{
		this.lerpNoise = lerpNoise;
		terrains[0] = terrain0;
		terrains[1] = terrain1;
		terrains[2] = terrain2;
	}

	public double getHeightAt(int x, int z)
	{
		double l = MathHelper.clamp(lerpNoise.GetValue(x, z), 0, 1);
		double y = 0;
		if (0 <= l && l <= 1 / 2f)
			y += (1 - 2 * l) * terrains[0].getHeightAt(x, z);
		if (0 <= l && l <= 1)
			y += (-Math.abs(2 * l - 1) + 1) * terrains[1].getHeightAt(x, z);
		if (1 / 2f <= l && l <= 1)
			y += (-Math.abs(2 * l - 1)) * terrains[2].getHeightAt(x, z);
		return y;
	}
}
