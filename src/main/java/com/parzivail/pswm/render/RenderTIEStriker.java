package com.parzivail.pswm.render;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ship.ModelTIEStriker;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by colby on 1/1/2017.
 */
public class RenderTIEStriker extends RenderStarship
{
	public RenderTIEStriker(RenderManager manager)
	{
		super(manager, new ModelTIEStriker(), new ResourceLocation(Resources.MODID, "textures/models/striker.png"));
	}
}