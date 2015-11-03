package com.parzi.starwarsmod.items;

import net.minecraft.item.ItemFood;

import com.parzi.starwarsmod.StarWarsMod;

public class ItemBanthaPlatter extends ItemFood
{
	private String name = "banthaPlatter";

	public ItemBanthaPlatter()
	{
		super(12, 7.0F, false);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + this.name);
		this.setTextureName(StarWarsMod.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemBanthaPlatter.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */