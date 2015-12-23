package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightsaberKylo extends ModelBase
{
	// fields
	ModelRenderer hilt1;
	ModelRenderer hilt3;
	ModelRenderer hilt4;
	ModelRenderer blade1;
	ModelRenderer hilt5;
	ModelRenderer hilt6;
	ModelRenderer hilt7;
	ModelRenderer hilt8;
	ModelRenderer baby_blade;
	ModelRenderer crossguard;

	public ModelLightsaberKylo()
	{
		textureWidth = 64;
		textureHeight = 32;

		hilt1 = new ModelRenderer(this, 0, 0);
		hilt1.addBox(0F, 0F, 0F, 2, 7, 2);
		hilt1.setRotationPoint(-1F, 17F, -1F);
		hilt1.setTextureSize(64, 32);
		hilt1.mirror = true;
		setRotation(hilt1, 0F, 0F, 0F);
		hilt3 = new ModelRenderer(this, 9, 0);
		hilt3.addBox(0F, -0.8F, 0F, 2, 1, 2);
		hilt3.setRotationPoint(-1F, 16F, -1F);
		hilt3.setTextureSize(64, 32);
		hilt3.mirror = true;
		setRotation(hilt3, 0F, 0F, 0F);
		hilt4 = new ModelRenderer(this, 18, 0);
		hilt4.addBox(0F, 0F, 0F, 1, 1, 1);
		hilt4.setRotationPoint(-0.5F, 18.4F, -1.183333F);
		hilt4.setTextureSize(64, 32);
		hilt4.mirror = true;
		setRotation(hilt4, 0F, 0F, 0F);
		blade1 = new ModelRenderer(this, 23, 0);
		blade1.addBox(0F, 0F, 0F, 1, 23, 1);
		blade1.setRotationPoint(-0.5F, -6F, -0.5F);
		blade1.setTextureSize(64, 32);
		blade1.mirror = true;
		setRotation(blade1, 0F, 0F, 0F);
		hilt5 = new ModelRenderer(this, 0, 10);
		hilt5.addBox(0F, 0F, 0F, 1, 3, 1);
		hilt5.setRotationPoint(-0.5F, 20F, -1.2F);
		hilt5.setTextureSize(64, 32);
		hilt5.mirror = true;
		setRotation(hilt5, 0F, 0F, 0F);
		hilt6 = new ModelRenderer(this, 0, 15);
		hilt6.addBox(0F, 0F, 0F, 1, 5, 1);
		hilt6.setRotationPoint(0.2F, 18F, -0.5F);
		hilt6.setTextureSize(64, 32);
		hilt6.mirror = true;
		setRotation(hilt6, 0F, 0F, 0F);
		hilt7 = new ModelRenderer(this, 0, 22);
		hilt7.addBox(0F, 0F, 0F, 1, 5, 1);
		hilt7.setRotationPoint(-0.5F, 18F, 0.2F);
		hilt7.setTextureSize(64, 32);
		hilt7.mirror = true;
		setRotation(hilt7, 0F, 0F, 0F);
		hilt8 = new ModelRenderer(this, 5, 10);
		hilt8.addBox(0F, 0F, 0F, 1, 5, 1);
		hilt8.setRotationPoint(-1.2F, 18F, -0.5F);
		hilt8.setTextureSize(64, 32);
		hilt8.mirror = true;
		setRotation(hilt8, 0F, 0F, 0F);
		baby_blade = new ModelRenderer(this, 31, 0);
		baby_blade.addBox(-1F, 0F, 0F, 11, 1, 1);
		baby_blade.setRotationPoint(-4.5F, 16.5F, -0.5F);
		baby_blade.setTextureSize(64, 32);
		baby_blade.mirror = true;
		setRotation(baby_blade, 0F, 0F, 0F);
		crossguard = new ModelRenderer(this, 31, 4);
		crossguard.addBox(0F, 0F, 0F, 5, 2, 2);
		crossguard.setRotationPoint(-2.5F, 16F, -1F);
		crossguard.setTextureSize(64, 32);
		crossguard.mirror = true;
		setRotation(crossguard, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		hilt1.render(f5);
		hilt3.render(f5);
		hilt4.render(f5);
		blade1.render(f5);
		hilt5.render(f5);
		hilt6.render(f5);
		hilt7.render(f5);
		hilt8.render(f5);
		baby_blade.render(f5);
		crossguard.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
