package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelScootEmAround;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderScootemaround extends RenderLandBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/yavinScoot.png");

	public RenderScootemaround()
	{
		super(new ModelScootEmAround(), 0.5f);

		this.scale = 1.25f;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
