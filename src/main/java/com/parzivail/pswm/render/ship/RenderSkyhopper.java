package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelSkyhopper;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderSkyhopper extends RenderStarship
{
	public RenderSkyhopper(RenderManager manager)
	{
		super(manager, new ModelSkyhopper(), new ResourceLocation(Resources.MODID, "textures/models/skyhopper.png"));
		this.zOffset = -0.13f;
		this.scale = 1.7f;
	}
}