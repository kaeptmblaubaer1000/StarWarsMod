package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelTIE;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTIE extends RenderStarship
{
	public static ResourceLocation texture;

	public RenderTIE()
	{
		model = new ModelTIE();
		texture = new ResourceLocation(Resources.MODID, "textures/models/tie.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
