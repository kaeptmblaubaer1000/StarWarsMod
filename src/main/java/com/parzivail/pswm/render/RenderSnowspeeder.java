package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelSnowspeeder;
import com.parzivail.util.driven.Pilotable;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderSnowspeeder extends RenderStarship
{
	public RenderSnowspeeder(RenderManager manager)
	{
		super(manager, new ModelSnowspeeder(), new ResourceLocation(Resources.MODID, "textures/models/snowspeeder.png"));
	}

	@Override
	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		this.zOffset = -0.13f;
		this.scale = 1.7f;
		super.render(pilotable, d, d1, d2, f, f1);
	}
}