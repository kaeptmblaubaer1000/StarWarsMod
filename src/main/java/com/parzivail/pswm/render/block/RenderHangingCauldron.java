package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelHangingCauldron;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderHangingCauldron extends RenderPTile
{
	public RenderHangingCauldron()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/hangingcauldron.png"), new ModelHangingCauldron());
	}
}
