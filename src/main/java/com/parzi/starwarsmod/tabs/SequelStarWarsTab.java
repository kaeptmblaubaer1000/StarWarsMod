package com.parzi.starwarsmod.tabs;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SequelStarWarsTab extends CreativeTabs
{
	public SequelStarWarsTab()
	{
		super("tabStarWarsSequel");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return StarWarsMod.sequelLightsaber;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsTab.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */