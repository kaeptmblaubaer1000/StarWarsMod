package com.parzivail.util;

import java.util.Random;

import com.parzivail.pswm.StarWarsMod;

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

	public static void shuffleArray(char[] ar)
	{
		Random rnd = StarWarsMod.rngGeneral;
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			char a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
}