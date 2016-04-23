package com.parzivail.util;

import java.util.List;
import java.util.Random;

public class MathUtils
{
	static Random _rand;

	static
	{
		_rand = new Random();
	}

	public static String getRandomElement(String[] array)
	{
		return array[_rand.nextInt(array.length)];
	}

	public static float lerp(float start, float end, float percent)
	{
		return start + percent * (end - start);
	}

	public static int randomRange(int min, int max)
	{
		return _rand.nextInt(max - min + 1) + min;
	}

	public static boolean oneIn(int n)
	{
		return _rand.nextInt(n) == 0;
	}

	public static void shuffleArray(char[] ar)
	{
		for (int i = ar.length - 1; i > 0; i--)
		{
			int index = _rand.nextInt(i + 1);
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