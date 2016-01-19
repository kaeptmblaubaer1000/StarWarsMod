package com.parzivail.pswm.rendering;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderTauntaun extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/tauntaun.png");

	public RenderTauntaun(ModelBase par1ModelBase, float par2)
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
			GL11.glScalef(1.5F, 1.5F, 1.5F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderTauntaun.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */