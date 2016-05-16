package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIEInterceptor;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIEInterceptor extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tieInterceptor.png");

	public RenderTIEInterceptor()
	{
		super(new ModelTIEInterceptor(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
