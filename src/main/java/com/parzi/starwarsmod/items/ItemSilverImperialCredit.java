package com.parzi.starwarsmod.items;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.item.Item;

public class ItemSilverImperialCredit extends Item
{
	public String name = "silverImperialCredit";

	public ItemSilverImperialCredit()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemImperialCredit.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */