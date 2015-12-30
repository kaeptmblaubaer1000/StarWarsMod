package com.parzi.starwarsmod.utils;

public class ForceUtils
{
	public static String[] getAllPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "healing", "naturalAwareness", "slow", "drainKnowledge", "lightning", "destruction" };
	}

	public static String[] getJediPowers()
	{
		return new String[] { "naturalAwareness" };
	}

	public static String[] getSithPowers()
	{
		return new String[] { "slow", "drainKnowledge", "lightning", "destruction" };
	}

	public static String[] getBasicPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "healing" };
	}
}