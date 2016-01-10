package com.parzi.starwarsmod.utils;

import java.util.ArrayList;

import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.jedirobes.powers.PowerDefend;
import com.parzi.starwarsmod.jedirobes.powers.PowerDeflect;
import com.parzi.starwarsmod.jedirobes.powers.PowerDestruction;
import com.parzi.starwarsmod.jedirobes.powers.PowerJump;
import com.parzi.starwarsmod.jedirobes.powers.PowerLightning;
import com.parzi.starwarsmod.jedirobes.powers.PowerNaturalAwareness;
import com.parzi.starwarsmod.jedirobes.powers.PowerPull;
import com.parzi.starwarsmod.jedirobes.powers.PowerPush;

public class ForceUtils
{
	public static Power activePower = null;
	public static boolean isUsingDuration = false;
	public static boolean isRunning = false;
	public static int health = 0;
	public static ArrayList<Power> coolingPowers = new ArrayList<Power>();
	public static ArrayList<Power> queueToRemove = new ArrayList<Power>();

	public static Power powerJump = new PowerJump(0);
	public static Power powerPush = new PowerPush(0);
	public static Power powerPull = new PowerPull(0);
	public static Power powerLightning = new PowerLightning(0);
	public static Power powerDestruction = new PowerDestruction(0);
	public static Power powerDefend = new PowerDefend(0);
	public static Power powerDeflect = new PowerDeflect(0);
	public static Power powerNaturalAwareness = new PowerNaturalAwareness(0);

	public static String[] getAllPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "healing", "naturalAwareness", "slow", "drainKnowledge", "lightning", "destruction" };
	}

	public static String[] getBasicPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab" };
	}

	public static String[] getJediPowers()
	{
		return new String[] { "healing", "naturalAwareness" };
	}

	public static String[] getSithPowers()
	{
		return new String[] { "slow", "drainKnowledge", "lightning", "destruction" };
	}
}