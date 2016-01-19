package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

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