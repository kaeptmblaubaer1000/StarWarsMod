package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIEInterceptor;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderTIEInterceptor extends RenderStarship
{
	public RenderTIEInterceptor(RenderManager manager)
	{
		super(manager, new ModelTIEInterceptor(), new ResourceLocation(Resources.MODID, "textures/models/tieinterceptor.png"));
		this.zOffset = -0.65f;
		this.scale = 2.1f;
	}
}