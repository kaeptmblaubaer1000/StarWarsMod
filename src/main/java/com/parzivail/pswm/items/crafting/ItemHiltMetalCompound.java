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
