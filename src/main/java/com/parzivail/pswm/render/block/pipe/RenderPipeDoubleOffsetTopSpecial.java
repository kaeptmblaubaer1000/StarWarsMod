package com.parzivail.pswm.render.block.pipe;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.pipe.ModelPipeDoubleOffsetTopSpecial;
import com.parzivail.pswm.render.block.RenderPTile;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderPipeDoubleOffsetTopSpecial extends RenderPTile
{
	public RenderPipeDoubleOffsetTopSpecial()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/pipedoubleoffsettopspecial.png"), new ModelPipeDoubleOffsetTopSpecial());
	}
}
