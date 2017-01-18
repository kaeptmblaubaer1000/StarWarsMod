package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIEStriker;
import com.parzivail.util.driven.RenderStarship;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderTIEStriker extends RenderStarship
{
	public RenderTIEStriker(RenderManager manager)
	{
		super(manager, new ModelTIEStriker(), new ResourceLocation(Resources.MODID, "textures/models/tiestriker.png"));
		this.zOffset = -0.1f;
		this.scale = 2.1f;
	}
}