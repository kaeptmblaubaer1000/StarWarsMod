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
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderHuman.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */