package com.parzi.starwarsmod.items;

import net.minecraft.item.Item;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

public class ItemDroidHacker extends Item
{
	public String name = "droidHacker";

	public ItemDroidHacker()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}