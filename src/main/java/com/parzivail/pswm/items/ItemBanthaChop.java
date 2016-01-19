package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

import net.minecraft.item.ItemFood;

public class ItemBanthaChop extends ItemFood
{
	public String name = "banthaChop";

	public ItemBanthaChop()
	{
		super(5, 0.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\ItemBanthaChop.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */