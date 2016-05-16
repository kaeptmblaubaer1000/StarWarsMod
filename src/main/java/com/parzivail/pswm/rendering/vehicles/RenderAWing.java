package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelAWing;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderAWing extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/awing.png");

	public RenderAWing()
	{
		super(new ModelAWing(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
