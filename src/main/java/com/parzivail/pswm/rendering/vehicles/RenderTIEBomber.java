package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIEBomber;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIEBomber extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tieBomber.png");

	public RenderTIEBomber()
	{
		super(new ModelTIEBomber(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
