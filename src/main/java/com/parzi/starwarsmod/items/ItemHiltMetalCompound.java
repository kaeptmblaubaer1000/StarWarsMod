package com.parzi.starwarsmod.items;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemHiltMetalCompound extends Item
{
	private String name = "hiltMetalCompound";

	public ItemHiltMetalCompound()
	{
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemHiltMetalCompound.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */