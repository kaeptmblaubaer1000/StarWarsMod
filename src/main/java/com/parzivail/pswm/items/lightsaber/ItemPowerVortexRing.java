package com.parzivail.pswm.items.lightsaber;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.item.Item;

public class ItemPowerVortexRing extends Item
{
	public String name = "powerVortexRing";

	public ItemPowerVortexRing()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
