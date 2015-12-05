package com.parzi.starwarsmod.utils;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;

public class MathUtils
{
	public static String getRandomElement(Random rand, String[] array)
	{
		return array[rand.nextInt(array.length)];
	}

	public static float lerp(float start, float end, float percent)
	{
		return start + percent * (end - start);
	}

	public static int randomRange(int min, int max)
	{
		return StarWarsMod.rngGeneral.nextInt(max - min + 1) + min;
	}
}