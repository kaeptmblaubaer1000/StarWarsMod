package com.parzi.starwarsmod.items.crafting;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemTitaniumChromiumIngot extends Item
{
	private String name = "titaniumChromiumIngot";

	public ItemTitaniumChromiumIngot()
	{
		setUnlocalizedName(StarWarsMod.MODID + "." + name);
		setTextureName(StarWarsMod.MODID + ":" + name);
		setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
