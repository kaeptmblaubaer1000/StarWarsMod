package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobDroidAstromechBb8;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidBb8;
import com.parzi.starwarsmod.rendering.models.vehicles.ModelXWing;
import com.parzi.starwarsmod.vehicles.VehicXWing;

public class RenderDroidBb8 extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(StarWarsMod.MODID, "textures/models/astromechBb8.png");
	ModelBase model;

	public RenderDroidBb8(ModelBase par1ModelBase, float par2)
	{
		super(par1ModelBase, par2);
		this.model = par1ModelBase;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return texture;
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float f)
	{
		this.mainModel = this.setRotations(model, entity, f);
	}

	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelDroidBb8 && entity instanceof MobDroidAstromechBb8)
		{
			MobDroidAstromechBb8 droid = (MobDroidAstromechBb8)entity;
			ModelDroidBb8 model = (ModelDroidBb8)modelBase;
			
			model.Body_1.rotateAngleX = (float)droid.posZ;
			model.Body_1.rotateAngleY = (float)droid.posX;
			model.Body_1.rotateAngleZ = (float)droid.posY;
			
			model.Body_2.rotateAngleX = (float)droid.posZ;
			model.Body_2.rotateAngleY = (float)droid.posX;
			model.Body_2.rotateAngleZ = (float)droid.posY;
			
			model.Body_3.rotateAngleX = (float)droid.posZ;
			model.Body_3.rotateAngleY = (float)droid.posX;
			model.Body_3.rotateAngleZ = (float)droid.posY;
			
			model.Body_4.rotateAngleX = (float)droid.posZ;
			model.Body_4.rotateAngleY = (float)droid.posX;
			model.Body_4.rotateAngleZ = (float)droid.posY;

			return model;
		}
		return modelBase;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderDroidAstromech.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */