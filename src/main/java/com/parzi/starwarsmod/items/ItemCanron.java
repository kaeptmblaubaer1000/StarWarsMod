package com.parzi.starwarsmod.items;

import net.minecraft.item.ItemFood;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

public class ItemCanron extends ItemFood
{
	public String name = "canron";

	public ItemCanron()
	{
		super(5, 0.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemCanron.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */