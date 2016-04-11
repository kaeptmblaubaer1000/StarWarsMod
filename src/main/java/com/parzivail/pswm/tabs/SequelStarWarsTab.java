package com.parzivail.pswm.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemLightsaber;

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
		return StarWarsMod.lightsaberNew[10];
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsTab.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */