package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIEAdvanced;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderTIEAdvanced extends RenderStarship
{
	public RenderTIEAdvanced(RenderManager manager)
	{
		super(manager, new ModelTIEAdvanced(), new ResourceLocation(Resources.MODID, "textures/models/tieadvanced.png"));
	}
}