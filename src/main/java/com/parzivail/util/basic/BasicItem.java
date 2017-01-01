package com.parzivail.util.basic;

import com.parzivail.pswm.Resources;
import com.parzivail.util.Util;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by colby on 1/1/2017.
 */
public class BasicItem extends Item
{
	public BasicItem(String name)
	{
		this.setUnlocalizedName(Util.moddot(name));
		this.setRegistryName(Resources.MODID, name);
		GameRegistry.register(this);
	}
}
