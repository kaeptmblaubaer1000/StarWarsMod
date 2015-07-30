package com.parzi.starwarsmod.items;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemWaterDroplet extends Item
{
	private String name = "waterDroplet";

	public ItemWaterDroplet()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
