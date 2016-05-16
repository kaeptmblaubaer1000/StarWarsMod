package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIE;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIE extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tie.png");

	public RenderTIE()
	{
		super(new ModelTIE(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
