package com.parzivail.pswm.items.ingot;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.item.Item;

public class ItemDiatiumIngot extends Item
{
	public String name = "diatiumIngot";

	public ItemDiatiumIngot()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
