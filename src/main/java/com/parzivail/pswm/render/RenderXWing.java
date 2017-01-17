package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelXWing;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderXWing extends RenderStarship
{
	public RenderXWing(RenderManager manager)
	{
		super(manager, new ModelXWing(), new ResourceLocation(Resources.MODID, "textures/models/xwingnew.png"));
	}
}