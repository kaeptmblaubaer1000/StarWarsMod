package com.parzi.starwarsmod.utils;

import java.util.Random;

public class MathHelper
{
	public static String getRandomElement(Random rand, String[] blades)
	{
		return blades[rand.nextInt(blades.length)];
	}
}
