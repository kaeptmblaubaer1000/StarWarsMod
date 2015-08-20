package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightsaberOff extends ModelBase
{
	// fields
	ModelRenderer hilt1;
	ModelRenderer hilt2;
	ModelRenderer hilt3;
	ModelRenderer hilt4;
	ModelRenderer blade1;

	public ModelLightsaberOff()
	{
		textureWidth = 64;
		textureHeight = 32;

		hilt1 = new ModelRenderer(this, 0, 0);
		hilt1.addBox(0F, 0F, 0F, 2, 6, 2);
		hilt1.setRotationPoint(-1F, 18F, -1F);
		hilt1.setTextureSize(64, 32);
		hilt1.mirror = true;
		setRotation(hilt1, 0F, 0F, 0F);
		hilt2 = new ModelRenderer(this, 8, 0);
		hilt2.addBox(0F, 0F, 0F, 2, 1, 2);
		hilt2.setRotationPoint(-1F, 16F, -1F);
		hilt2.setTextureSize(64, 32);
		hilt2.mirror = true;
		setRotation(hilt2, 0F, 0F, 0F);
		hilt3 = new ModelRenderer(this, 16, 0);
		hilt3.addBox(0F, 0F, 0F, 2, 1, 2);
		hilt3.setRotationPoint(-1F, 14F, -1F);
		hilt3.setTextureSize(64, 32);
		hilt3.mirror = true;
		setRotation(hilt3, 0F, 0F, 0F);
		hilt4 = new ModelRenderer(this, 24, 0);
		hilt4.addBox(0F, 0F, 0F, 1, 2, 1);
		hilt4.setRotationPoint(-0.5F, 18.4F, -1.183333F);
		hilt4.setTextureSize(64, 32);
		hilt4.mirror = true;
		setRotation(hilt4, 0F, 0F, 0F);
		blade1 = new ModelRenderer(this, 35, 0);
		blade1.addBox(0F, 0F, 0F, 1, 3, 1);
		blade1.setRotationPoint(-0.5F, 15F, -0.5F);
		blade1.setTextureSize(64, 32);
		blade1.mirror = true;
		setRotation(blade1, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		hilt1.render(f5);
		hilt2.render(f5);
		hilt3.render(f5);
		hilt4.render(f5);
		blade1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
