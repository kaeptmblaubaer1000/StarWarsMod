package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelJR4Swoop;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderJR4Swoop extends RenderStarship
{
	public RenderJR4Swoop(RenderManager manager)
	{
		super(manager, new ModelJR4Swoop(), new ResourceLocation(Resources.MODID, "textures/models/jr4.png"));
		this.zOffset = -1.25f;
		this.disableFirst = false;
		this.zOffset = -0.7f;
		this.scale = 1;
	}
}