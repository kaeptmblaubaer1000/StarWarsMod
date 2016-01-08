package com.parzi.starwarsmod.items;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.item.Item;

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