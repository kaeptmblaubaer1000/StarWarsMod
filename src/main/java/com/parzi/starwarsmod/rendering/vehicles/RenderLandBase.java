package com.parzi.starwarsmod.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import com.parzi.util.vehicle.VehicleLandBase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderLandBase extends RenderLiving
{
	ModelBase model;
	float scale = 1;

	public RenderLandBase(ModelBase model, float par2)
	{
		super(model, par2);
		this.model = model;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		this.mainModel = this.setRotations(this.model, entity, f);
		GL11.glScalef(this.scale, this.scale, this.scale);
		if (entity instanceof VehicleLandBase)
		{
			VehicleLandBase vehic = (VehicleLandBase)entity;
			float tx = (float)Math.sin(vehic.frame) * 0.005F;
			float ty = (float)Math.cos(vehic.frame * 1.25F) * 0.005F;
			GL11.glTranslatef(tx, ty, tx * ty);
			GL11.glRotatef(-vehic.tilt, 0.0F, 0.0F, 1.0F);
		}
	}

	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		return modelBase;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */