package com.parzivail.pswm.rendering.vehicles;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.models.vehicles.ModelSnowspeeder;
import com.parzivail.pswm.vehicles.VehicSnowspeeder;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderSnowspeeder extends RenderVehicAirBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/snowspeeder.png");

	public RenderSnowspeeder(ModelSnowspeeder model, float par2)
	{
		super(model, par2);
	}

	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		super.doRender(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		super.preRenderCallback(entity, f);
		GL11.glScalef(0.8f, 0.8f, 0.8f);
		GL11.glTranslatef(0, 0.3f, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelSnowspeeder && entity instanceof VehicSnowspeeder)
		{
			VehicSnowspeeder speeder = (VehicSnowspeeder)entity;
			ModelSnowspeeder model = (ModelSnowspeeder)modelBase;

			if (speeder.tilt < 0)
			{
				model.FlapL.rotateAngleX = -0.8f * -(speeder.tilt / speeder.tiltMax);
			}
			else
			{
				model.FlapR.rotateAngleX = -0.8f * (speeder.tilt / speeder.tiltMax);
			}

			return model;
		}
		return modelBase;
	}
}