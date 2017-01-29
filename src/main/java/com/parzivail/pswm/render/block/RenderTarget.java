package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelTarget;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderTarget extends RenderPTile
{
	public RenderTarget()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/target.png"), new ModelTarget());
	}
}
