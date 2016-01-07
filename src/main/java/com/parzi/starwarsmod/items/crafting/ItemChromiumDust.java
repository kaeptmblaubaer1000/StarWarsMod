package com.parzi.starwarsmod.items.crafting;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

public class ItemChromiumDust extends Item
{
	public String name = "chromiumDust";

	public ItemChromiumDust()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\crafting\ItemChromiumDust.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */