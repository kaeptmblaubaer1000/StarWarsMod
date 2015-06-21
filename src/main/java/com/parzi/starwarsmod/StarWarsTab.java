package com.parzi.starwarsmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarWarsTab extends CreativeTabs
{
	public StarWarsTab()
	{
		super("tabStarWars");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return StarWarsMod.gaffiStick;
	}
}
