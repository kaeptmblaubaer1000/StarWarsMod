package com.parzivail.util.worldgen;

import com.parzivail.util.common.OpenSimplexNoise;

/**
 * Created by colby on 12/27/2016.
 */
public class TerrainLayer
{
	public Method method = TerrainLayer.Method.Add;
	public float scale = 200;
	public float range = 20;
	public boolean normalize = true;
	private OpenSimplexNoise noise;

	public TerrainLayer(long seed)
	{
		noise = new OpenSimplexNoise(seed);
	}

	public double GetValue(double x, double y)
	{
		double noiseVal = noise.eval(x / scale, y / scale);
		if (normalize)
			noiseVal += 0.5f;
		noiseVal *= range;
		return noiseVal;
	}

	public enum Method
	{
		Add, Multiply, Subtract
	}
}
