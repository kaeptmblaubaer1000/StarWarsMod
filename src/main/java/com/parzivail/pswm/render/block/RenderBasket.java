package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelBasket;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderBasket extends RenderPTile
{
	public RenderBasket()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/basket.png"), new ModelBasket());
	}
}
