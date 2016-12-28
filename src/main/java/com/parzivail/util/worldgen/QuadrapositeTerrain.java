package com.parzivail.util.worldgen;

import net.minecraft.util.math.MathHelper;

/**
 * Created by colby on 12/28/2016.
 */
public class QuadrapositeTerrain
{
	private final CompositeTerrain[] terrains = new CompositeTerrain[4];
	private final TerrainLayer lerpNoise;

	public QuadrapositeTerrain(CompositeTerrain terrain0, CompositeTerrain terrain1, CompositeTerrain terrain2, CompositeTerrain terrain3, TerrainLayer lerpNoise)
	{
		this.lerpNoise = lerpNoise;
		terrains[0] = terrain0;
		terrains[1] = terrain1;
		terrains[2] = terrain2;
		terrains[3] = terrain3;
	}

	public double getHeightAt(int x, int z)
	{
		double l = MathHelper.clamp(lerpNoise.GetValue(x, z), 0, 1);
		double y = 0;
		if (0 <= l && l <= 1 / 3f)
			y += (1 - 3 * l) * terrains[0].getHeightAt(x, z);
		if (0 <= l && l <= 2 / 3f)
			y += (-Math.abs(3 * l - 1) + 1) * terrains[1].getHeightAt(x, z);
		if (1 / 3f <= l && l <= 1)
			y += (-Math.abs(3 * l - 2) + 1) * terrains[2].getHeightAt(x, z);
		if (2 / 3f <= l && l <= 1)
			y += ((3 * l - 2)) * terrains[3].getHeightAt(x, z);
		return y;
	}
}
