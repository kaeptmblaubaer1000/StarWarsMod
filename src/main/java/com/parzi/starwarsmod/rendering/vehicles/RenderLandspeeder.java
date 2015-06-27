package com.parzi.starwarsmod.rendering.vehicles;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelLandspeeder;

public class RenderLandspeeder extends RenderLiving
{
	public RenderLandspeeder(ModelLandspeeder modelLandspeeder, float par2)
	{
		super(modelLandspeeder, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/landspeeder.png");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(2.4F, 2.4F, 2.4F);
	}
}