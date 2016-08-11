package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderVehicBase extends RenderLiving
{
	ModelBase model;

	public RenderVehicBase(ModelBase model, float par2)
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
		GL11.glScalef(3.0F, 3.0F, 3.0F);
		if (entity instanceof VehicleAirBase)
		{
			VehicleAirBase vehicle = (VehicleAirBase)entity;
			GL11.glTranslatef(0, -1F, 0);
			float pitch = vehicle.getRealPitch();
			float roll = -vehicle.tilt;
			if (f > 0.5F)
			{
				vehicle.rotationPitch = vehicle.getRealPitch();
			}
			GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0, 1F, 0);
			GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
		}
	}
}
