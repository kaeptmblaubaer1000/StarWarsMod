package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIEInterceptor;
import com.parzivail.util.driven.Pilotable;
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
	}

	@Override
	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		this.zOffset = -0.65f;
		this.scale = 2.1f;
		super.render(pilotable, d, d1, d2, f, f1);
	}
}