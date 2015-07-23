package com.parzi.starwarsmod.items;

import net.minecraft.item.ItemFood;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemBanthaChop extends ItemFood
{
	private String name = "banthaChop";

	public ItemBanthaChop()
	{
		super(8, 0, false);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
