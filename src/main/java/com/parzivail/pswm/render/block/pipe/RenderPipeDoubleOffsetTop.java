package com.parzivail.pswm.render.block.pipe;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.pipe.ModelPipeDoubleOffsetTop;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderPipeDoubleOffsetTop extends RenderPTile
{
	public RenderPipeDoubleOffsetTop()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/pipedoubleoffsettop.png"), new ModelPipeDoubleOffsetTop());
	}
}
