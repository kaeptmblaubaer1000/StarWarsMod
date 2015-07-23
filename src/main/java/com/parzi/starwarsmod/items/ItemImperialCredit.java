package com.parzi.starwarsmod.items;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemImperialCredit extends Item
{
	private String name = "imperialCredit";

	public ItemImperialCredit()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
