package com.parzi.starwarsmod.rendering.vehicles;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelJakkuSpeeder;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicleLandBase;

public class RenderJakkuSpeeder extends RenderLiving
{
	public RenderJakkuSpeeder(ModelJakkuSpeeder modelSpeederBike, float par2)
	{
		super(modelSpeederBike, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/jakkuSpeeder.png");
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof VehicleLandBase)
		{
			VehicleLandBase vehic = (VehicleLandBase)entity;
			float tx = (float)Math.sin(vehic.frame) * 0.005F;
			float ty = (float)Math.cos(vehic.frame * 1.25F) * 0.005F;
			GL11.glTranslatef(tx, ty, tx * ty);
			GL11.glRotatef(VehicleLandBase.mouseDX * -2.0F, 0.0F, 0.0F, 1.0F);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */