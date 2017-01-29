package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelHyperdriveBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHyperdriveBlock extends RenderPTile
{
	public RenderHyperdriveBlock()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hyperdriveblock.png"), new ModelHyperdriveBlock());
	}
}
