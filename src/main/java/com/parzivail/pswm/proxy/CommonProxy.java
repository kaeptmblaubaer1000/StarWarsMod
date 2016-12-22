package com.parzivail.pswm.proxy;

import com.parzivail.pswm.registry.BlockRegister;
import com.parzivail.pswm.registry.CreativeTabRegister;
import net.minecraft.item.Item;

/**
 * Created by colby on 12/18/2016.
 */
public class CommonProxy
{
	public void preinit()
	{
		CreativeTabRegister.register();
		BlockRegister.register();
	}

	public void registerItemRenderer(Item item, int meta, String id)
	{
	}
}
