package com.parzivail.pswm.render.ship;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelJakkuSpeeder;
import com.parzivail.util.driven.RenderStarship;
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
		this.disableFirst = false;
		this.zOffset = -0.7f;
		this.scale = 2;
	}
}