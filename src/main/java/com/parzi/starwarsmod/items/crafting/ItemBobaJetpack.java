package com.parzi.starwarsmod.items.crafting;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemBobaJetpack extends Item
{
	private String name = "bobaJetpack";

	public ItemBobaJetpack()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
		maxStackSize = 1;
	}
}
