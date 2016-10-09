package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelXWingNew;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderXWing extends RenderStarship
{
	public static ResourceLocation texture;

	public RenderXWing()
	{
		model = new ModelXWingNew();
		texture = new ResourceLocation(Resources.MODID, "textures/models/xwingNew.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}