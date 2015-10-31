package com.parzi.starwarsmod.achievement;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

import com.parzi.starwarsmod.StarWarsMod;

public class StarWarsAchievement extends Achievement
{
	public static List<Achievement> achievements = new ArrayList();

	public StarWarsAchievement(String name, int x, int y, Item icon, Achievement parent)
	{
		this(name, x, y, new ItemStack(icon), parent);
	}

	public StarWarsAchievement(String name, int x, int y, ItemStack icon, Achievement parent)
	{
		super("achievement.starwarsmod." + name, StarWarsMod.MODID + "." + name, x, y, icon, parent);
		achievements.add(this);
		this.registerStat();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\achievement\StarWarsAchievement.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */