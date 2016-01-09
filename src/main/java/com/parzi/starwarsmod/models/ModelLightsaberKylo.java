package com.parzi.starwarsmod.models;

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
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.hilt1 = new ModelRenderer(this, 0, 0);
		this.hilt1.addBox(0F, 0F, 0F, 2, 7, 2);
		this.hilt1.setRotationPoint(-1F, 17F, -1F);
		this.hilt1.setTextureSize(64, 32);
		this.hilt1.mirror = true;
		this.setRotation(this.hilt1, 0F, 0F, 0F);
		this.hilt3 = new ModelRenderer(this, 9, 0);
		this.hilt3.addBox(0F, -0.8F, 0F, 2, 1, 2);
		this.hilt3.setRotationPoint(-1F, 16F, -1F);
		this.hilt3.setTextureSize(64, 32);
		this.hilt3.mirror = true;
		this.setRotation(this.hilt3, 0F, 0F, 0F);
		this.hilt4 = new ModelRenderer(this, 18, 0);
		this.hilt4.addBox(0F, 0F, 0F, 1, 1, 1);
		this.hilt4.setRotationPoint(-0.5F, 18.4F, -1.183333F);
		this.hilt4.setTextureSize(64, 32);
		this.hilt4.mirror = true;
		this.setRotation(this.hilt4, 0F, 0F, 0F);
		this.blade1 = new ModelRenderer(this, 23, 0);
		this.blade1.addBox(0F, 0F, 0F, 1, 23, 1);
		this.blade1.setRotationPoint(-0.5F, -6F, -0.5F);
		this.blade1.setTextureSize(64, 32);
		this.blade1.mirror = true;
		this.setRotation(this.blade1, 0F, 0F, 0F);
		this.hilt5 = new ModelRenderer(this, 0, 10);
		this.hilt5.addBox(0F, 0F, 0F, 1, 3, 1);
		this.hilt5.setRotationPoint(-0.5F, 20F, -1.2F);
		this.hilt5.setTextureSize(64, 32);
		this.hilt5.mirror = true;
		this.setRotation(this.hilt5, 0F, 0F, 0F);
		this.hilt6 = new ModelRenderer(this, 0, 15);
		this.hilt6.addBox(0F, 0F, 0F, 1, 5, 1);
		this.hilt6.setRotationPoint(0.2F, 18F, -0.5F);
		this.hilt6.setTextureSize(64, 32);
		this.hilt6.mirror = true;
		this.setRotation(this.hilt6, 0F, 0F, 0F);
		this.hilt7 = new ModelRenderer(this, 0, 22);
		this.hilt7.addBox(0F, 0F, 0F, 1, 5, 1);
		this.hilt7.setRotationPoint(-0.5F, 18F, 0.2F);
		this.hilt7.setTextureSize(64, 32);
		this.hilt7.mirror = true;
		this.setRotation(this.hilt7, 0F, 0F, 0F);
		this.hilt8 = new ModelRenderer(this, 5, 10);
		this.hilt8.addBox(0F, 0F, 0F, 1, 5, 1);
		this.hilt8.setRotationPoint(-1.2F, 18F, -0.5F);
		this.hilt8.setTextureSize(64, 32);
		this.hilt8.mirror = true;
		this.setRotation(this.hilt8, 0F, 0F, 0F);
		this.baby_blade = new ModelRenderer(this, 31, 0);
		this.baby_blade.addBox(-1F, 0F, 0F, 11, 1, 1);
		this.baby_blade.setRotationPoint(-4.5F, 16.5F, -0.5F);
		this.baby_blade.setTextureSize(64, 32);
		this.baby_blade.mirror = true;
		this.setRotation(this.baby_blade, 0F, 0F, 0F);
		this.crossguard = new ModelRenderer(this, 31, 4);
		this.crossguard.addBox(0F, 0F, 0F, 5, 2, 2);
		this.crossguard.setRotationPoint(-2.5F, 16F, -1F);
		this.crossguard.setTextureSize(64, 32);
		this.crossguard.mirror = true;
		this.setRotation(this.crossguard, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.hilt1.render(f5);
		this.hilt3.render(f5);
		this.hilt4.render(f5);
		this.blade1.render(f5);
		this.hilt5.render(f5);
		this.hilt6.render(f5);
		this.hilt7.render(f5);
		this.hilt8.render(f5);
		this.baby_blade.render(f5);
		this.crossguard.render(f5);
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
