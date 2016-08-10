package com.parzivail.pswm.rendering;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.ModelNpcYoda;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNpcYoda extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/npcYoda.png");

	public RenderNpcYoda()
	{
		super(new ModelNpcYoda(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
