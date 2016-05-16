package com.parzivail.pswm.rendering.vehicles;

import com.parzivail.util.vehicle.VehicleLandBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderLandBase extends RenderLiving
{
	ModelBase model;
	float scale = 1;

	public RenderLandBase(ModelBase model, float shadowSize)
	{
		super(model, shadowSize);
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
}
