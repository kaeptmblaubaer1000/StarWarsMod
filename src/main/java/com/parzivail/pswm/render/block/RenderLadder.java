package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelLadder;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderLadder extends RenderPTile
{
	public RenderLadder()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/ladder.png"), new ModelLadder());
	}
}
