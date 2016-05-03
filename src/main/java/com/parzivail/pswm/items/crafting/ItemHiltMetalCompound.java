package com.parzivail.pswm.items.crafting;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.item.Item;

public class ItemHiltMetalCompound extends Item
{
	public String name = "hiltMetalCompound";

	public ItemHiltMetalCompound()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\items\crafting\ItemHiltMetalCompound.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */