package com.parzi.starwarsmod.rendering;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.mobs.MobTusken;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTusken extends RenderBiped
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tusken.png");

	public RenderTusken(ModelBiped par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	protected void renderCarrying(MobTusken par1MobTusken, float par2)
	{
		super.renderEquippedItems(par1MobTusken, par2);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderTusken.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */