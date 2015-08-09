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
		super("achievement" + "." + StarWarsMod.MODID + "." + name, StarWarsMod.MODID + "." + name, x, y, icon, parent);
		achievements.add(this);
		registerStat();
	}
}
