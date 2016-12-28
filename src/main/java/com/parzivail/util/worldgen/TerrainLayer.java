package com.parzivail.util.worldgen;

import com.parzivail.util.common.OpenSimplexNoise;

/**
 * Created by colby on 12/27/2016.
 */
public class TerrainLayer
{
	public Method method = TerrainLayer.Method.Add;
	public double scale = 200;
	public double range = 20;
	public boolean normalize = true;
	private OpenSimplexNoise noise;

	public TerrainLayer(long seed, Method method, double scale, double range)
	{
		this.method = method;
		this.scale = scale;
		this.range = range;
		noise = new OpenSimplexNoise(seed);
	}

	public double GetValue(double x, double y)
	{
		double noiseVal = noise.eval(x / scale, y / scale) + 0.5f;
		noiseVal *= range;
		return noiseVal;
	}

	public enum Method
	{
		Add, Multiply, Subtract
	}
}
