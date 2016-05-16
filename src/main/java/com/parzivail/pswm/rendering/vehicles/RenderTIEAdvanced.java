package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIEAdvanced;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIEAdvanced extends RenderVehicBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tieAdvanced.png");

	public RenderTIEAdvanced()
	{
		super(new ModelTIEAdvanced(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
