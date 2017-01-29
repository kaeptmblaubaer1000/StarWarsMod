package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelHolotableMass;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHolotableMass extends RenderPTile
{
	public RenderHolotableMass()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/holotablemass.png"), new ModelHolotableMass());
	}
}
