package com.parzi.starwarsmod.items.weapons;

import net.minecraft.item.ItemSword;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemEwokSpear extends ItemSword
{
	public String name = "ewokSpear";

	public ItemEwokSpear()
	{
		super(StarWarsMod.ewokMat);
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
