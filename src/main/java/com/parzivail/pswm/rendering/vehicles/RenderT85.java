package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelT85;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderT85 extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/t85.png");

	public RenderT85()
	{
		super(new ModelT85(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}