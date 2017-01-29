package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelMV;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderMV extends RenderPTile
{
	public RenderMV()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/mv.png"), new ModelMV());
	}
}
