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

	public static <T> T getRandomElement(T[] array)
	{
		return array[_rand.nextInt(array.length)];
	}

	public static float lerp(float start, float end, float percent)
	{
		return start + percent * (end - start);
	}

	public static float map(float x, float in_min, float in_max, float out_min, float out_max)
	{
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	public static float distance(float x1, float y1, float x2, float y2)
	{
		return (float)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
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