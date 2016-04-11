package com.parzivail.util;

import java.util.List;

import com.parzivail.pswm.StarWarsMod;

public class MathUtils
{
	public static String getRandomElement(String[] array)
	{
		return array[StarWarsMod.rngGeneral.nextInt(array.length)];
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
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = StarWarsMod.rngGeneral.nextInt(i + 1);
			char a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}

	public static int[] toIntArray(List<Integer> list)
	{
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}
}