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

	public TerrainLayer(long seed, Method method, double scale, double range, boolean normalize)
	{
		this.method = method;
		this.scale = scale;
		this.range = range;
		this.normalize = normalize;
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
