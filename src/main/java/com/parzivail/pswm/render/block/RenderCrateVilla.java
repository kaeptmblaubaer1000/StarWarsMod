package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelCrateVilla;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderCrateVilla extends RenderPTile
{
	public RenderCrateVilla()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/cratevilla.png"), new ModelCrateVilla());
	}
}
