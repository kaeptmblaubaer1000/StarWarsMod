package com.parzivail.pswm.achievement;

import com.parzivail.pswm.Resources;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

import java.util.ArrayList;
import java.util.List;

public class StarWarsAchievement extends Achievement
{
	public static List<Achievement> achievements = new ArrayList();

	public StarWarsAchievement(String name, int x, int y, Item icon, Achievement parent)
	{
		this(name, x, y, new ItemStack(icon), parent);
	}

	public StarWarsAchievement(String name, int x, int y, ItemStack icon, Achievement parent)
	{
		super("achievement.starwarsmod." + name, Resources.MODID + "." + name, x, y, icon, parent);
		achievements.add(this);
		this.registerStat();
	}
}
