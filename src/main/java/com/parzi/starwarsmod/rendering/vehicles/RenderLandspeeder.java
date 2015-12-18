package com.parzi.starwarsmod.rendering.vehicles;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelLandspeeder;
import com.parzi.starwarsmod.vehicles.VehicleLandBase;

public class RenderLandspeeder extends RenderLandBase
{
	public static ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/models/landspeeder.png");

	public RenderLandspeeder(ModelLandspeeder modelLandspeeder, float par2)
	{
		super(modelLandspeeder, par2);
		this.scale = 2.4f;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\vehicles\RenderLandspeeder.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */