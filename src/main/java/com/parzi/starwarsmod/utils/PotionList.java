package com.parzi.starwarsmod.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;

public class PotionList
{
	public static int SPEED = 1;
	public static int SLOWNESS = 2;
	public static int HASTE = 3;
	public static int MINING_FATIGUE = 4;
	public static int STRENGTH = 5;
	public static int INSTANT_HEALTH = 6;
	public static int INSTANT_DAMAGE = 7;
	public static int JUMP_BOOST = 8;
	public static int NAUSEA = 9;
	public static int REGENERATION = 10;
	public static int RESISTANCE = 11;
	public static int FIRE_RESISTANCE = 12;
	public static int WATER_BREATHING = 13;
	public static int INVISIBILITY = 14;
	public static int BLINDNESS = 15;
	public static int NIGHT_VISION = 16;
	public static int HUNGER = 17;
	public static int WEAKNESS = 18;
	public static int POISON = 19;
	public static int WITHER = 20;
	public static int HEALTH_BOOST = 21;
	public static int ABSORPTION = 22;
	public static int SATURATION = 23;

	public static void addAmbientEffect(EntityPlayer player, int effect, int power, float seconds)
	{
		player.addPotionEffect(new PotionEffect(effect, (int)(seconds * 20.0F), power, true));
	}

	public static void addEffect(EntityPlayer player, int effect, int power, float seconds)
	{
		player.addPotionEffect(new PotionEffect(effect, (int)(seconds * 20.0F), power, false));
	}
}