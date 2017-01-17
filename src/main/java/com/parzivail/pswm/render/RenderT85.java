package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelT85;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/17/2017.
 */
public class RenderT85 extends RenderStarship
{
	public RenderT85(RenderManager manager)
	{
		super(manager, new ModelT85(), new ResourceLocation(Resources.MODID, "textures/models/t85.png"));
	}
}