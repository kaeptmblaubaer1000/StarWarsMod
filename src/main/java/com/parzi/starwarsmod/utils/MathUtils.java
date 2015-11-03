package com.parzi.starwarsmod.utils;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;

public class MathUtils
{
	public static int randomRange(int min, int max)
	{
		return StarWarsMod.rngGeneral.nextInt(max - min + 1) + min;
	}
}