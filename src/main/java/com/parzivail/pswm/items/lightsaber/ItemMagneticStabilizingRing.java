package com.parzivail.pswm.items.lightsaber;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.item.Item;

public class ItemMagneticStabilizingRing extends Item
{
	public String name = "magneticStabilizingRing";

	public ItemMagneticStabilizingRing()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}
}
