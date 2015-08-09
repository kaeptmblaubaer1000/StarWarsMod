package com.parzi.starwarsmod.utils;

import java.util.Random;

public class ItemUtils
{
	public static int randomRange(int min, int max)
	{
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}
}
