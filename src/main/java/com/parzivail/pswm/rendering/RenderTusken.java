package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTusken extends RenderHuman
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tusken.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
