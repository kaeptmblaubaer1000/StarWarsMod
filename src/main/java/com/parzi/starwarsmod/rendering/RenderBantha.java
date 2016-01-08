package com.parzi.starwarsmod.rendering;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.rendering.models.mobs.ModelBantha;

import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderBantha extends RenderCow
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/bantha.png");

	public RenderBantha(ModelBantha par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		if (entity.isChild())
			GL11.glScalef(0.8F, 0.8F, 0.8F);
		else
			GL11.glScalef(1.8F, 1.8F, 1.8F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderBantha.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */