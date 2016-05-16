package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelLandspeeder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderLandspeeder extends RenderLandBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/landspeeder.png");

	public RenderLandspeeder()
	{
		super(new ModelLandspeeder(), 0.5f);
		this.scale = 2.4f;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
