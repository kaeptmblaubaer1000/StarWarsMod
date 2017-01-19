package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelScootEmAround;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderScootEmAround extends RenderStarship
{
	public RenderScootEmAround(RenderManager manager)
	{
		super(manager, new ModelScootEmAround(), new ResourceLocation(Resources.MODID, "textures/models/scootemaround.png"));
		this.disableFirst = false;
		this.zOffset = -0.65f;
		this.scale = 1.2f;
	}

	@Override
	public float getTilt(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		return 0;
	}
}