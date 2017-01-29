package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelLadderTop;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderLadderTop extends RenderPTile
{
	public RenderLadderTop()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/laddertop.png"), new ModelLadderTop());
	}
}
