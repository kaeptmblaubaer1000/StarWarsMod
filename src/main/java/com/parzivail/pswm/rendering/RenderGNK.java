package com.parzivail.pswm.rendering;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.mobs.ModelGNK;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGNK extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/gnk.png");

	public RenderGNK(ModelGNK modelGNK, float par2)
	{
		super(modelGNK, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(0.75F, 0.75F, 0.75F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderGNK.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */