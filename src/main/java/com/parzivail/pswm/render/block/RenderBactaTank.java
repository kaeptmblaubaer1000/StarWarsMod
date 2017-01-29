package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelBactaTank;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderBactaTank extends RenderPTile
{
	public RenderBactaTank()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/bactatank.png"), new ModelBactaTank());
	}
}
