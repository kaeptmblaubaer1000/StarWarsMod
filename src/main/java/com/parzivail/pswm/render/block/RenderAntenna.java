package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelAntenna;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderAntenna extends RenderPTile
{
	public RenderAntenna()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/antenna.png"), new ModelAntenna());
	}
}
