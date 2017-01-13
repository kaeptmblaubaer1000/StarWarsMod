package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIE;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderTIE extends RenderStarship
{
	public RenderTIE(RenderManager manager)
	{
		super(manager, new ModelTIE(), new ResourceLocation(Resources.MODID, "textures/models/tie.png"));
	}
}