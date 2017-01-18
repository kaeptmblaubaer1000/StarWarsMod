package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelUWing;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderUWing extends RenderStarship
{
	public RenderUWing(RenderManager manager)
	{
		super(manager, new ModelUWing(), new ResourceLocation(Resources.MODID, "textures/models/uwing.png"));
		this.zOffset = -0.65f;
		this.scale = 2.1f;
	}
}