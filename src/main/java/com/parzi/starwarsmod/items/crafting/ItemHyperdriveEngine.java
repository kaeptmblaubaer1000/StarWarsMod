package com.parzi.starwarsmod.items.crafting;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemHyperdriveEngine extends Item
{
	private String name = "hyperdriveEngine";

	public ItemHyperdriveEngine()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		maxStackSize = 1;
	}
}
