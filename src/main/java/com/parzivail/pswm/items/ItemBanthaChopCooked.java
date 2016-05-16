package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.item.ItemFood;

public class ItemBanthaChopCooked extends ItemFood
{
	public String name = "banthaChopCooked";

	public ItemBanthaChopCooked()
	{
		super(10, 5.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
