package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightsaberKyloBlade extends ModelBase
{
	ModelRenderer Shape40;
	ModelRenderer Shape48;

	public ModelLightsaberKyloBlade()
	{
		textureWidth = 256;
		textureHeight = 128;

		Shape40 = new ModelRenderer(this, 0, 10);
		Shape40.addBox(0F, 0F, 0F, 3, 3, 44);
		Shape40.setRotationPoint(1F, 1.5F, -19F);
		Shape40.setTextureSize(64, 32);
		Shape40.mirror = true;
		setRotation(Shape40, 0F, 0F, 0F);
		Shape48 = new ModelRenderer(this, 0, 0);
		Shape48.addBox(0F, 0F, 0F, 124, 4, 4);
		Shape48.setRotationPoint(-100F, 1F, 1F);
		Shape48.setTextureSize(64, 32);
		Shape48.mirror = true;
		setRotation(Shape48, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape40.render(f5);
		Shape48.render(f5);
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
