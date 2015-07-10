package com.parzi.starwarsmod.items;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemDroidCaller extends Item
{
	private String name = "droidCaller";

	public ItemDroidCaller()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
