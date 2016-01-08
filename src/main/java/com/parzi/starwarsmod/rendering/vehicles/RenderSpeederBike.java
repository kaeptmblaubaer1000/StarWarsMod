package com.parzi.starwarsmod.rendering.vehicles;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderSpeederBike extends RenderLandBase
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/speederbike.png");
	public static ResourceLocation hothTexture = new ResourceLocation(Resources.MODID, "textures/models/hothSpeederbike.png");

	public RenderSpeederBike(ModelSpeederBike modelSpeederBike, float par2)
	{
		super(modelSpeederBike, par2);
		this.scale = 1.75f;
		this.model = modelSpeederBike;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if (entity instanceof VehicHothSpeederBike)
			return hothTexture;
		return texture;
	}

	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelSpeederBike)
		{
			EntityLivingBase bike = entity;
			ModelSpeederBike model = (ModelSpeederBike)modelBase;

			model.Flap_L.rotateAngleZ = bike.moveForward * 35f;
			model.Flap_R.rotateAngleZ = bike.moveForward * 35f;

			model.Handle_L_3.rotateAngleZ = bike.moveForward * -35f;
			model.Handle_L_2.rotateAngleZ = bike.moveForward * -35f;
			model.Handle_L_1.rotateAngleZ = bike.moveForward * -35f;

			model.Handle_R_3.rotateAngleZ = bike.moveForward * -35f;
			model.Handle_R_2.rotateAngleZ = bike.moveForward * -35f;
			model.Handle_R_1.rotateAngleZ = bike.moveForward * -35f;

			return model;
		}
		return modelBase;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */