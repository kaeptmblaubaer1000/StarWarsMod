package com.parzivail.pswm.proxy;

import com.parzivail.util.Util;
import com.parzivail.util.block.Variants;
import com.parzivail.util.common.Lumberjack;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by colby on 12/18/2016.
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void preinit()
	{
		super.preinit();
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Util.identifier(id), Variants.INVENTORY));
		Lumberjack.debug("Registered renderer for item %s@%s", Util.identifier(id), Variants.INVENTORY);
	}
}
