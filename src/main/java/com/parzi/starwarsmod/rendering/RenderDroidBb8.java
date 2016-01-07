package com.parzi.starwarsmod.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.mobs.MobDroidAstromechBb8;
import com.parzi.starwarsmod.rendering.models.mobs.ModelDroidBb8;

public class RenderDroidBb8 extends RenderLiving
{
	public static ResourceLocation texture = new ResourceLocation(Resources.MODID, "textures/models/astromechBb8.png");
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
		this.mainModel = this.setRotations(this.model, entity, f);
	}

	public ModelBase setRotations(ModelBase modelBase, EntityLivingBase entity, float partialTicks)
	{
		if (modelBase instanceof ModelDroidBb8 && entity instanceof MobDroidAstromechBb8)
		{
			MobDroidAstromechBb8 droid = (MobDroidAstromechBb8)entity;
			ModelDroidBb8 model = (ModelDroidBb8)modelBase;

			model.Body_1.rotateAngleX = (float)droid.posZ * 10;
			model.Body_1.rotateAngleY = (float)droid.posX * 10;
			model.Body_1.rotateAngleZ = (float)droid.posY * 10;

			model.Body_2.rotateAngleX = (float)droid.posZ * 10;
			model.Body_2.rotateAngleY = (float)droid.posX * 10;
			model.Body_2.rotateAngleZ = (float)droid.posY * 10;

			model.Body_3.rotateAngleX = (float)droid.posZ * 10;
			model.Body_3.rotateAngleY = (float)droid.posX * 10;
			model.Body_3.rotateAngleZ = (float)droid.posY * 10;

			model.Body_4.rotateAngleX = (float)droid.posZ * 10;
			model.Body_4.rotateAngleY = (float)droid.posX * 10;
			model.Body_4.rotateAngleZ = (float)droid.posY * 10;

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