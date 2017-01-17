package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelJakkuSpeeder;
import com.parzivail.util.driven.Pilotable;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderJakkuSpeeder extends RenderStarship
{
	public RenderJakkuSpeeder(RenderManager manager)
	{
		super(manager, new ModelJakkuSpeeder(), new ResourceLocation(Resources.MODID, "textures/models/jakkuspeeder.png"));
	}

	@Override
	public void render(Pilotable pilotable, double d, double d1, double d2, float f, float f1)
	{
		this.disableFirst = false;
		this.zOffset = -0.7f;
		this.scale = 2;
		super.render(pilotable, d, d1, d2, f, f1);
	}
}