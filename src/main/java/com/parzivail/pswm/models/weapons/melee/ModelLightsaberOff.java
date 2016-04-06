package com.parzivail.pswm.models.weapons.melee;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightsaberOff extends ModelBase
{
	ModelRenderer hilt1;
	ModelRenderer hilt2;
	ModelRenderer hilt3;
	ModelRenderer hilt4;
	ModelRenderer blade1;

	public ModelLightsaberOff()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.hilt1 = new ModelRenderer(this, 0, 0);
		this.hilt1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 2);
		this.hilt1.setRotationPoint(-1.0F, 18.0F, -1.0F);
		this.hilt1.setTextureSize(64, 32);
		this.hilt1.mirror = true;
		this.setRotation(this.hilt1, 0.0F, 0.0F, 0.0F);
		this.hilt2 = new ModelRenderer(this, 8, 0);
		this.hilt2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
		this.hilt2.setRotationPoint(-1.0F, 16.0F, -1.0F);
		this.hilt2.setTextureSize(64, 32);
		this.hilt2.mirror = true;
		this.setRotation(this.hilt2, 0.0F, 0.0F, 0.0F);
		this.hilt3 = new ModelRenderer(this, 16, 0);
		this.hilt3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
		this.hilt3.setRotationPoint(-1.0F, 14.0F, -1.0F);
		this.hilt3.setTextureSize(64, 32);
		this.hilt3.mirror = true;
		this.setRotation(this.hilt3, 0.0F, 0.0F, 0.0F);
		this.hilt4 = new ModelRenderer(this, 24, 0);
		this.hilt4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
		this.hilt4.setRotationPoint(-0.5F, 18.4F, -1.183333F);
		this.hilt4.setTextureSize(64, 32);
		this.hilt4.mirror = true;
		this.setRotation(this.hilt4, 0.0F, 0.0F, 0.0F);
		this.blade1 = new ModelRenderer(this, 35, 0);
		this.blade1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
		this.blade1.setRotationPoint(-0.5F, 15.0F, -0.5F);
		this.blade1.setTextureSize(64, 32);
		this.blade1.mirror = true;
		this.setRotation(this.blade1, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.hilt1.render(f5);
		this.hilt2.render(f5);
		this.hilt3.render(f5);
		this.hilt4.render(f5);
		this.blade1.render(f5);
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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\ModelLightsaberOff.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */