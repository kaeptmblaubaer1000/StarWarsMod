package com.parzi.starwarsmod.items.weapons;

import net.minecraft.item.ItemSword;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemEwokSpear extends ItemSword
{
	public String name = "ewokSpear";

	public ItemEwokSpear()
	{
		super(StarWarsMod.materialEwok);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemEwokSpear.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */