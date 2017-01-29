package com.parzivail.pswm.render.block;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.block.ModelLightsaberForge;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/29/2017.
 */
public class RenderLightsaberForge extends RenderPTile
{
	public RenderLightsaberForge()
	{
		super(new ResourceLocation(Resources.MODID, "textures/models/block/lightsaberforge.png"), new ModelLightsaberForge());
	}
}
