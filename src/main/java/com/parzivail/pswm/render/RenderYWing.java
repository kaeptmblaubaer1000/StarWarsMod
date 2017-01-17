package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelYWing;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderYWing extends RenderStarship
{
	public RenderYWing(RenderManager manager)
	{
		super(manager, new ModelYWing(), new ResourceLocation(Resources.MODID, "textures/models/ywing.png"));
		this.zOffset = -0.65f;
	}
}