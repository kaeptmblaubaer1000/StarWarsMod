package com.parzi.starwarsmod.rendering.models.vehicles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTIE extends ModelBase
{
	// fields
	ModelRenderer Cockpit;
	ModelRenderer Wing_Section_1;
	ModelRenderer Wing_Section_2;
	ModelRenderer Body_Panel_1;
	ModelRenderer Body_Panel_2;
	ModelRenderer Body_Panel_3;
	ModelRenderer Wing_Section_3;
	ModelRenderer Wing_Section_4;
	ModelRenderer Wing_Section_5;
	ModelRenderer Wing_Section_6;
	ModelRenderer Wing_Section_7;
	ModelRenderer Wing_Section_8;
	ModelRenderer Wing_Section_9;
	ModelRenderer Wing_Section_10;
	ModelRenderer Wing_Section_11;
	ModelRenderer Wing_Section_12;
	ModelRenderer Body_Panel_4;
	ModelRenderer Laser_1;
	ModelRenderer Laser_2;
	ModelRenderer Body_Panel_5;
	ModelRenderer Body_Panel_6;
	ModelRenderer Body_Panel_7;
	ModelRenderer Body_Panel_8;
	ModelRenderer Body_Panel_9;

	public ModelTIE()
	{
		textureWidth = 512;
		textureHeight = 512;

		Cockpit = new ModelRenderer(this, 42, 42);
		Cockpit.addBox(-6F, -22F, -6F, 12, 12, 12);
		Cockpit.setRotationPoint(0F, 22F, 0F);
		Cockpit.setTextureSize(64, 32);
		Cockpit.mirror = true;
		setRotation(Cockpit, 0F, 0F, 0F);
		Wing_Section_1 = new ModelRenderer(this, 0, 33);
		Wing_Section_1.addBox(18F, -34F, -8F, 1, 36, 16);
		Wing_Section_1.setRotationPoint(0F, 22F, 0F);
		Wing_Section_1.setTextureSize(64, 32);
		Wing_Section_1.mirror = true;
		setRotation(Wing_Section_1, 0F, 0F, 0F);
		Wing_Section_2 = new ModelRenderer(this, 0, 92);
		Wing_Section_2.addBox(-19F, -34F, -8F, 1, 36, 16);
		Wing_Section_2.setRotationPoint(0F, 22F, 0F);
		Wing_Section_2.setTextureSize(64, 32);
		Wing_Section_2.mirror = true;
		setRotation(Wing_Section_2, 0F, 0F, 0F);
		Body_Panel_1 = new ModelRenderer(this, 0, 151);
		Body_Panel_1.addBox(-12F, -20F, -1.5F, 24, 8, 3);
		Body_Panel_1.setRotationPoint(0F, 22F, 0F);
		Body_Panel_1.setTextureSize(64, 32);
		Body_Panel_1.mirror = true;
		setRotation(Body_Panel_1, 0F, 0F, 0F);
		Body_Panel_2 = new ModelRenderer(this, 0, 168);
		Body_Panel_2.addBox(-10.5F, -18.5F, -2.5F, 21, 5, 5);
		Body_Panel_2.setRotationPoint(0F, 22F, 0F);
		Body_Panel_2.setTextureSize(64, 32);
		Body_Panel_2.mirror = true;
		setRotation(Body_Panel_2, 0F, 0F, 0F);
		Body_Panel_3 = new ModelRenderer(this, 0, 185);
		Body_Panel_3.addBox(-20F, -17.5F, -2F, 40, 3, 4);
		Body_Panel_3.setRotationPoint(0F, 22F, 0F);
		Body_Panel_3.setTextureSize(64, 32);
		Body_Panel_3.mirror = true;
		setRotation(Body_Panel_3, 0F, 0F, 0F);
		Wing_Section_3 = new ModelRenderer(this, 0, 199);
		Wing_Section_3.addBox(18F, -32F, -13.75F, 1, 18, 16);
		Wing_Section_3.setRotationPoint(0F, 22F, 0F);
		Wing_Section_3.setTextureSize(64, 32);
		Wing_Section_3.mirror = true;
		setRotation(Wing_Section_3, -0.1745329F, 0F, 0F);
		Wing_Section_4 = new ModelRenderer(this, 0, 241);
		Wing_Section_4.addBox(18F, -18F, -8.1F, 1, 18, 16);
		Wing_Section_4.setRotationPoint(0F, 22F, 0F);
		Wing_Section_4.setTextureSize(64, 32);
		Wing_Section_4.mirror = true;
		setRotation(Wing_Section_4, 0.1745329F, 0F, 0F);
		Wing_Section_5 = new ModelRenderer(this, 0, 283);
		Wing_Section_5.addBox(18F, -32F, -2.25F, 1, 18, 16);
		Wing_Section_5.setRotationPoint(0F, 22F, 0F);
		Wing_Section_5.setTextureSize(64, 32);
		Wing_Section_5.mirror = true;
		setRotation(Wing_Section_5, 0.1745329F, 0F, 0F);
		Wing_Section_6 = new ModelRenderer(this, 0, 326);
		Wing_Section_6.addBox(18F, -18F, -7.9F, 1, 18, 16);
		Wing_Section_6.setRotationPoint(0F, 22F, 0F);
		Wing_Section_6.setTextureSize(64, 32);
		Wing_Section_6.mirror = true;
		setRotation(Wing_Section_6, -0.1745329F, 0F, 0F);
		Wing_Section_7 = new ModelRenderer(this, 0, 367);
		Wing_Section_7.addBox(-19F, -32F, -13.8F, 1, 18, 16);
		Wing_Section_7.setRotationPoint(0F, 22F, 0F);
		Wing_Section_7.setTextureSize(64, 32);
		Wing_Section_7.mirror = true;
		setRotation(Wing_Section_7, -0.1745329F, 0F, 0F);
		Wing_Section_8 = new ModelRenderer(this, 0, 409);
		Wing_Section_8.addBox(-19F, -18F, -8.2F, 1, 18, 16);
		Wing_Section_8.setRotationPoint(0F, 22F, 0F);
		Wing_Section_8.setTextureSize(64, 32);
		Wing_Section_8.mirror = true;
		setRotation(Wing_Section_8, 0.1745329F, 0F, 0F);
		Wing_Section_9 = new ModelRenderer(this, 0, 451);
		Wing_Section_9.addBox(-19F, -32F, -2.1F, 1, 18, 16);
		Wing_Section_9.setRotationPoint(0F, 22F, 0F);
		Wing_Section_9.setTextureSize(64, 32);
		Wing_Section_9.mirror = true;
		setRotation(Wing_Section_9, 0.1745329F, 0F, 0F);
		Wing_Section_10 = new ModelRenderer(this, 42, 0);
		Wing_Section_10.addBox(-19F, -18F, -7.8F, 1, 18, 16);
		Wing_Section_10.setRotationPoint(0F, 22F, 0F);
		Wing_Section_10.setTextureSize(64, 32);
		Wing_Section_10.mirror = true;
		setRotation(Wing_Section_10, -0.1745329F, 0F, 0F);
		Wing_Section_11 = new ModelRenderer(this, 85, 0);
		Wing_Section_11.addBox(17F, -20F, -4F, 3, 8, 8);
		Wing_Section_11.setRotationPoint(0F, 22F, 0F);
		Wing_Section_11.setTextureSize(64, 32);
		Wing_Section_11.mirror = true;
		setRotation(Wing_Section_11, 0F, 0F, 0F);
		Wing_Section_12 = new ModelRenderer(this, 116, 0);
		Wing_Section_12.addBox(-20F, -20F, -4F, 3, 8, 8);
		Wing_Section_12.setRotationPoint(0F, 22F, 0F);
		Wing_Section_12.setTextureSize(64, 32);
		Wing_Section_12.mirror = true;
		setRotation(Wing_Section_12, 0F, 0F, 0F);
		Body_Panel_4 = new ModelRenderer(this, 147, 0);
		Body_Panel_4.addBox(-14F, -19F, -1F, 28, 6, 2);
		Body_Panel_4.setRotationPoint(0F, 22F, 0F);
		Body_Panel_4.setTextureSize(64, 32);
		Body_Panel_4.mirror = true;
		setRotation(Body_Panel_4, 0F, 0F, 0F);
		Laser_1 = new ModelRenderer(this, 216, 0);
		Laser_1.addBox(1.5F, -12F, -6.5F, 1, 1, 3);
		Laser_1.setRotationPoint(0F, 22F, 0F);
		Laser_1.setTextureSize(64, 32);
		Laser_1.mirror = true;
		setRotation(Laser_1, 0F, 0F, 0F);
		Laser_2 = new ModelRenderer(this, 234, 0);
		Laser_2.addBox(-2.5F, -12F, -6.5F, 1, 1, 3);
		Laser_2.setRotationPoint(0F, 22F, 0F);
		Laser_2.setTextureSize(64, 32);
		Laser_2.mirror = true;
		setRotation(Laser_2, 0F, 0F, 0F);
		Body_Panel_5 = new ModelRenderer(this, 42, 98);
		Body_Panel_5.addBox(5F, -21F, -5F, 2, 10, 10);
		Body_Panel_5.setRotationPoint(0F, 22F, 0F);
		Body_Panel_5.setTextureSize(64, 32);
		Body_Panel_5.mirror = true;
		setRotation(Body_Panel_5, 0F, 0F, 0F);
		Body_Panel_6 = new ModelRenderer(this, 42, 72);
		Body_Panel_6.addBox(-7F, -21F, -5F, 2, 10, 10);
		Body_Panel_6.setRotationPoint(0F, 22F, 0F);
		Body_Panel_6.setTextureSize(64, 32);
		Body_Panel_6.mirror = true;
		setRotation(Body_Panel_6, 0F, 0F, 0F);
		Body_Panel_7 = new ModelRenderer(this, 42, 126);
		Body_Panel_7.addBox(-5F, -23F, -5F, 10, 2, 10);
		Body_Panel_7.setRotationPoint(0F, 22F, 0F);
		Body_Panel_7.setTextureSize(64, 32);
		Body_Panel_7.mirror = true;
		setRotation(Body_Panel_7, 0F, 0F, 0F);
		Body_Panel_8 = new ModelRenderer(this, 100, 43);
		Body_Panel_8.addBox(-5F, -11F, -5F, 10, 2, 10);
		Body_Panel_8.setRotationPoint(0F, 22F, 0F);
		Body_Panel_8.setTextureSize(64, 32);
		Body_Panel_8.mirror = true;
		setRotation(Body_Panel_8, 0F, 0F, 0F);
		Body_Panel_9 = new ModelRenderer(this, 102, 63);
		Body_Panel_9.addBox(-5F, -21F, 5F, 10, 10, 2);
		Body_Panel_9.setRotationPoint(0F, 22F, 0F);
		Body_Panel_9.setTextureSize(64, 32);
		Body_Panel_9.mirror = true;
		setRotation(Body_Panel_9, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Cockpit.render(f5);
		Wing_Section_1.render(f5);
		Wing_Section_2.render(f5);
		Body_Panel_1.render(f5);
		Body_Panel_2.render(f5);
		Body_Panel_3.render(f5);
		Wing_Section_3.render(f5);
		Wing_Section_4.render(f5);
		Wing_Section_5.render(f5);
		Wing_Section_6.render(f5);
		Wing_Section_7.render(f5);
		Wing_Section_8.render(f5);
		Wing_Section_9.render(f5);
		Wing_Section_10.render(f5);
		Wing_Section_11.render(f5);
		Wing_Section_12.render(f5);
		Body_Panel_4.render(f5);
		Laser_1.render(f5);
		Laser_2.render(f5);
		Body_Panel_5.render(f5);
		Body_Panel_6.render(f5);
		Body_Panel_7.render(f5);
		Body_Panel_8.render(f5);
		Body_Panel_9.render(f5);
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