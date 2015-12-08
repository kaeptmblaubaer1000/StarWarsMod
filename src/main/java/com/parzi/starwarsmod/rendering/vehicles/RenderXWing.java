package com.parzi.starwarsmod.rendering.vehicles;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelXWing;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderXWing extends RenderVehicAirBase
{
	public RenderXWing(ModelXWing model, float par2)
	{
		super(model, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(StarWarsMod.MODID, "textures/models/xwing.png");
	}
	
	@Override
	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelXWing)
		{
			ModelXWing model = (ModelXWing)modelBase;
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