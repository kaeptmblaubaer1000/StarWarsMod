package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelMV2;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderMV2 extends RenderPTile
{
	public RenderMV2()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/mv2.png"), new ModelMV2());
	}
}
