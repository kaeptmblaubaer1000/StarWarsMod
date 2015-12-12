package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroidBb8 extends ModelBase
{
	// fields
	public ModelRenderer Body_1;
	public ModelRenderer Body_2;
	public ModelRenderer Body_3;
	public ModelRenderer Body_4;
	public ModelRenderer Body_5;
	public ModelRenderer Body_6;
	public ModelRenderer Body_7;
	public ModelRenderer Body_8;

	public ModelDroidBb8()
	{
		textureWidth = 128;
		textureHeight = 128;

		Body_1 = new ModelRenderer(this, 0, 0);
		Body_1.addBox(-3.5F, -4F, -3.5F, 7, 7, 7);
		Body_1.setRotationPoint(0F, 20.5F, 0F);
		Body_1.setTextureSize(64, 32);
		Body_1.mirror = true;
		setRotation(Body_1, 0F, 0F, 0F);
		Body_2 = new ModelRenderer(this, 0, 19);
		Body_2.addBox(-3F, -4.5F, -3F, 6, 8, 6);
		Body_2.setRotationPoint(0F, 20.5F, 0F);
		Body_2.setTextureSize(64, 32);
		Body_2.mirror = true;
		setRotation(Body_2, 0F, 0F, 0F);
		Body_3 = new ModelRenderer(this, 0, 38);
		Body_3.addBox(-3F, -3.5F, -4F, 6, 6, 8);
		Body_3.setRotationPoint(0F, 20.5F, 0F);
		Body_3.setTextureSize(64, 32);
		Body_3.mirror = true;
		setRotation(Body_3, 0F, 0F, 0F);
		Body_4 = new ModelRenderer(this, 0, 57);
		Body_4.addBox(-4F, -3.5F, -3F, 8, 6, 6);
		Body_4.setRotationPoint(0F, 20.5F, 0F);
		Body_4.setTextureSize(64, 32);
		Body_4.mirror = true;
		setRotation(Body_4, 0F, 0F, 0F);
		Body_5 = new ModelRenderer(this, 0, 74);
		Body_5.addBox(-2.5F, -8.3F, -2.5F, 5, 2, 5);
		Body_5.setRotationPoint(0F, 20.5F, 0F);
		Body_5.setTextureSize(64, 32);
		Body_5.mirror = true;
		setRotation(Body_5, 0F, 0F, 0F);
		Body_6 = new ModelRenderer(this, 0, 84);
		Body_6.addBox(-3F, -6.8F, -3F, 6, 2, 6);
		Body_6.setRotationPoint(0F, 20.5F, 0F);
		Body_6.setTextureSize(64, 32);
		Body_6.mirror = true;
		setRotation(Body_6, 0F, 0F, 0F);
		Body_7 = new ModelRenderer(this, 0, 95);
		Body_7.addBox(-1.3F, -7.8F, -3.3F, 2, 2, 2);
		Body_7.setRotationPoint(0F, 20.5F, 0F);
		Body_7.setTextureSize(64, 32);
		Body_7.mirror = true;
		setRotation(Body_7, 0F, 0F, 0F);
		Body_8 = new ModelRenderer(this, 0, 102);
		Body_8.addBox(0F, -10F, 0F, 1, 2, 1);
		Body_8.setRotationPoint(0F, 20.5F, 0F);
		Body_8.setTextureSize(64, 32);
		Body_8.mirror = true;
		setRotation(Body_8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body_1.render(f5);
		Body_2.render(f5);
		Body_3.render(f5);
		Body_4.render(f5);
		Body_5.render(f5);
		Body_6.render(f5);
		Body_7.render(f5);
		Body_8.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		/*
		 * this.Body_1.rotateAngleX += entity.motionX; this.Body_1.rotateAngleY
		 * += entity.motionY; this.Body_1.rotateAngleZ += entity.motionZ;
		 *
		 * this.Body_2.rotateAngleX += entity.motionX; this.Body_2.rotateAngleY
		 * += entity.motionY; this.Body_2.rotateAngleZ += entity.motionZ;
		 *
		 * this.Body_3.rotateAngleX += entity.motionX; this.Body_3.rotateAngleY
		 * += entity.motionY; this.Body_3.rotateAngleZ += entity.motionZ;
		 *
		 * this.Body_4.rotateAngleX += entity.motionX; this.Body_4.rotateAngleY
		 * += entity.motionY; this.Body_4.rotateAngleZ += entity.motionZ;
		 */

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
