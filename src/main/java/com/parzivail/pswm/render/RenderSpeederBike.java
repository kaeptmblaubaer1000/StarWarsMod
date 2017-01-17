package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelSpeederBike;
import com.parzivail.util.driven.Pilotable;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderSpeederBike extends RenderStarship
{
	public RenderSpeederBike(RenderManager manager)
	{
		super(manager, new ModelSpeederBike(), new ResourceLocation(Resources.MODID, "textures/models/speederbike.png"));
	}

	@Override
	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		this.disableFirst = false;
		this.zOffset = -0.5f;
		this.scale = 1.7f;
		super.render(pilotable, d, d1, d2, f, f1);
	}
}