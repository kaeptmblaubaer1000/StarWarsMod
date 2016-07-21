package com.parzivail.pswm.rendering;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHuman extends RenderBiped
{
	public static ResourceLocation texture = new ResourceLocation("textures/entity/steve.png");
	public ResourceLocation overrideTexture = null;

	public RenderHuman(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	public RenderHuman(ModelBiped par1ModelBase, float par2, ResourceLocation overrideTexture)
	{
		super(par1ModelBase, par2);
		this.overrideTexture = overrideTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (overrideTexture != null)
			return overrideTexture;
		return RenderStaticNpc.texture;
	}
}
