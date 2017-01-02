package com.parzivail.util.math;

import com.parzivail.util.lwjgl.Vector3f;
import net.minecraft.util.math.Vec3d;

import java.util.List;
import java.util.Random;

public class MathUtils
{
	static Random _rand;

	static
	{
		_rand = new Random();
	}

	/**
	 * Gets a random value from an array
	 *
	 * @param array The array to pull items from
	 * @param <T>   The inferred type of value to operate with
	 * @return A random element of the supplied array
	 */
	public static <T> T getRandomElement(T[] array)
	{
		return array[_rand.nextInt(array.length)];
	}

	/**
	 * Gets a random primitive int value from an array
	 *
	 * @param array The array to pull items from
	 * @return A random element of the supplied array
	 */
	public static int getRandomElement(int[] array)
	{
		return array[_rand.nextInt(array.length)];
	}

	/**
	 * Check if a List contains any object of type.
	 *
	 * @param list The list to check
	 * @return If the List contains
	 */
	public static boolean isAnyOfType(List list, Class c)
	{
		for (Object o : list)
			if (c.isInstance(o))
				return true;
		return false;
	}

	/**
	 * Check to see how many of a type is in a List
	 *
	 * @param list The list to check
	 * @return How many the List contains
	 */
	public static int howManyOfType(List list, Class c)
	{
		int i = 0;
		for (Object o : list)
			if (c.isInstance(o))
				i++;
		return i;
	}

	/**
	 * Linear Interpolation
	 *
	 * @param start   The start value
	 * @param end     The end value
	 * @param percent The percent position between the two
	 * @return The interpolated value
	 */
	public static float lerp(float start, float end, float percent)
	{
		return start + percent * (end - start);
	}

	/**
	 * Re-maps a value from one range to another
	 *
	 * @param n       The value to reset-map
	 * @param in_min  The min for the first range
	 * @param in_max  The max for the first range
	 * @param out_min The min for the second range
	 * @param out_max The max for the second range
	 * @return The reset-mapped value
	 */
	public static float map(float n, float in_min, float in_max, float out_min, float out_max)
	{
		return (n - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	/**
	 * Gets the distance between two points
	 *
	 * @param x1 The first point's X
	 * @param y1 The first point's Y
	 * @param x2 The second point's X
	 * @param y2 The second point's X
	 * @return The distance between the two points
	 */
	public static float distance(float x1, float y1, float x2, float y2)
	{
		return (float)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	/**
	 * Gets a random value within a given range
	 *
	 * @param min The range minimum (inclusive)
	 * @param max The range maximum (exclusive)
	 * @return The random value
	 */
	public static int randomRange(int min, int max)
	{
		return _rand.nextInt(max - min + 1) + min;
	}

	/**
	 * Returns a random boolean with a one-in-n chance of being true
	 *
	 * @param n The chance
	 * @return The random boolean
	 */
	public static boolean oneIn(int n)
	{
		return _rand.nextInt(n) == 0;
	}

	/**
	 * Shuffles a char array in-place
	 *
	 * @param ar The array to shuffle
	 */
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

	/**
	 * Converts a List<Integer> into an int[]
	 *
	 * @param list The list to convert
	 * @return The new int array
	 */
	public static Integer[] toIntArray(List<Integer> list)
	{
		Integer[] ret = new Integer[list.size()];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list.get(i);
		return ret;
	}

	public static float roundToNearest(float f, float nearest)
	{
		return nearest * (Math.round(f / nearest));
	}

	public static float floorToNearest(float f, float nearest)
	{
		return (float)(nearest * (Math.floor(f / nearest)));
	}

	public static float ceilToNearest(float f, float nearest)
	{
		return (float)(nearest * (Math.ceil(f / nearest)));
	}

	public static Vec3d multiply(Vec3d base, Vec3d multiplier)
	{
		return new Vec3d(base.xCoord * multiplier.xCoord, base.yCoord * multiplier.yCoord, base.zCoord * multiplier.zCoord);
	}

	public static Vec3d multiply(Vec3d base, float multiplier)
	{
		return new Vec3d(base.xCoord * multiplier, base.yCoord * multiplier, base.zCoord * multiplier);
	}

	public static float getAngleBetweenVectors(Vec3d v1, Vector3f v2)
	{
		return Math.abs((float)Math.toDegrees(Vector3f.angle(new Vector3f(v1), v2)));
	}
}