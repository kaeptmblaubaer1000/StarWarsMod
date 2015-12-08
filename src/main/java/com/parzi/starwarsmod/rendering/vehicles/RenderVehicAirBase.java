package com.parzi.starwarsmod.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelXWing;
import com.parzi.starwarsmod.utils.MathUtils;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderVehicAirBase extends RenderLiving
{
	ModelBase model;

	public RenderVehicAirBase(ModelBase model, float par2)
	{
		super(model, par2);
		this.model = model;
	}

	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		return modelBase;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		model = this.setRotations(model, entity, f);
		GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof VehicleAirBase)
		{
			VehicleAirBase vehicle = (VehicleAirBase)entity;
			GL11.glTranslatef(0, -1F, 0);
			float pitch = MathUtils.lerp(vehicle.renderPitchLast, vehicle.rotationPitch, f);
			float roll = MathUtils.lerp(vehicle.renderRollLast, -vehicle.mouseDX, f);
			if (f > 0.5F)
			{
				vehicle.renderPitchLast = vehicle.rotationPitch;
				vehicle.renderRollLast = -vehicle.mouseDX;
			}
			GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0, 1F, 0);
			GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
			// Lumberjack.log(vehicle.rotationLast - vehicle.rotationYaw);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return null;
	}
}
