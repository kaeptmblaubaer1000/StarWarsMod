package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroidTreadwell extends ModelBase
{
	ModelRenderer Base;
	ModelRenderer BaseTop;
	ModelRenderer Wheel1;
	ModelRenderer Wheel2;
	ModelRenderer Wheel3;
	ModelRenderer Wheel4;
	ModelRenderer Wheel5;
	ModelRenderer Wheel6;
	ModelRenderer Wheel7;
	ModelRenderer Wheel8;
	ModelRenderer Wheel9;
	ModelRenderer Wheel10;
	ModelRenderer SkidPlate;
	ModelRenderer BaseTopTop;
	ModelRenderer MiddleRod;
	ModelRenderer Eyes1;
	ModelRenderer Eyes2;
	ModelRenderer Eyes3;
	ModelRenderer Eyes4;
	ModelRenderer Eyes5;
	ModelRenderer ArmB1;
	ModelRenderer ArmB2;
	ModelRenderer ArmB3;
	ModelRenderer ArmB4;
	ModelRenderer ArmB5;
	ModelRenderer ArmB6;
	ModelRenderer ArmT1;
	ModelRenderer ArmT2;
	ModelRenderer ArmT3;
	ModelRenderer ArmT4;
	ModelRenderer ArmT5;
	ModelRenderer ArmT6;

	public ModelDroidTreadwell()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(0.0F, 0.0F, 0.0F, 12, 1, 14);
		this.Base.setRotationPoint(-6.0F, 22.0F, -7.0F);
		this.Base.setTextureSize(64, 32);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
		this.BaseTop = new ModelRenderer(this, 0, 17);
		this.BaseTop.addBox(0.0F, 0.0F, 0.0F, 10, 1, 12);
		this.BaseTop.setRotationPoint(-5.0F, 21.5F, -6.0F);
		this.BaseTop.setTextureSize(64, 32);
		this.BaseTop.mirror = true;
		this.setRotation(this.BaseTop, 0.0F, 0.0F, 0.0F);
		this.Wheel1 = new ModelRenderer(this, 0, 33);
		this.Wheel1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel1.setRotationPoint(-6.0F, 22.0F, 5.0F);
		this.Wheel1.setTextureSize(64, 32);
		this.Wheel1.mirror = true;
		this.setRotation(this.Wheel1, 0.0F, 0.0F, 0.0F);
		this.Wheel2 = new ModelRenderer(this, 9, 33);
		this.Wheel2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel2.setRotationPoint(-6.0F, 22.0F, 2.0F);
		this.Wheel2.setTextureSize(64, 32);
		this.Wheel2.mirror = true;
		this.setRotation(this.Wheel2, 0.0F, 0.0F, 0.0F);
		this.Wheel3 = new ModelRenderer(this, 18, 33);
		this.Wheel3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel3.setRotationPoint(-6.0F, 22.0F, -1.0F);
		this.Wheel3.setTextureSize(64, 32);
		this.Wheel3.mirror = true;
		this.setRotation(this.Wheel3, 0.0F, 0.0F, 0.0F);
		this.Wheel4 = new ModelRenderer(this, 27, 33);
		this.Wheel4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel4.setRotationPoint(-6.0F, 22.0F, -4.0F);
		this.Wheel4.setTextureSize(64, 32);
		this.Wheel4.mirror = true;
		this.setRotation(this.Wheel4, 0.0F, 0.0F, 0.0F);
		this.Wheel5 = new ModelRenderer(this, 36, 33);
		this.Wheel5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel5.setRotationPoint(-6.0F, 22.0F, -7.0F);
		this.Wheel5.setTextureSize(64, 32);
		this.Wheel5.mirror = true;
		this.setRotation(this.Wheel5, 0.0F, 0.0F, 0.0F);
		this.Wheel6 = new ModelRenderer(this, 0, 40);
		this.Wheel6.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel6.setRotationPoint(5.0F, 22.0F, 5.0F);
		this.Wheel6.setTextureSize(64, 32);
		this.Wheel6.mirror = true;
		this.setRotation(this.Wheel6, 0.0F, 0.0F, 0.0F);
		this.Wheel7 = new ModelRenderer(this, 9, 40);
		this.Wheel7.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel7.setRotationPoint(5.0F, 22.0F, 2.0F);
		this.Wheel7.setTextureSize(64, 32);
		this.Wheel7.mirror = true;
		this.setRotation(this.Wheel7, 0.0F, 0.0F, 0.0F);
		this.Wheel8 = new ModelRenderer(this, 18, 40);
		this.Wheel8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel8.setRotationPoint(5.0F, 22.0F, -1.0F);
		this.Wheel8.setTextureSize(64, 32);
		this.Wheel8.mirror = true;
		this.setRotation(this.Wheel8, 0.0F, 0.0F, 0.0F);
		this.Wheel9 = new ModelRenderer(this, 27, 40);
		this.Wheel9.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel9.setRotationPoint(5.0F, 22.0F, -4.0F);
		this.Wheel9.setTextureSize(64, 32);
		this.Wheel9.mirror = true;
		this.setRotation(this.Wheel9, 0.0F, 0.0F, 0.0F);
		this.Wheel10 = new ModelRenderer(this, 36, 40);
		this.Wheel10.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.Wheel10.setRotationPoint(5.0F, 22.0F, -7.0F);
		this.Wheel10.setTextureSize(64, 32);
		this.Wheel10.mirror = true;
		this.setRotation(this.Wheel10, 0.0F, 0.0F, 0.0F);
		this.SkidPlate = new ModelRenderer(this, 0, 47);
		this.SkidPlate.addBox(0.0F, 0.0F, 0.0F, 10, 1, 14);
		this.SkidPlate.setRotationPoint(-5.0F, 22.3F, -7.0F);
		this.SkidPlate.setTextureSize(64, 32);
		this.SkidPlate.mirror = true;
		this.setRotation(this.SkidPlate, 0.0F, 0.0F, 0.0F);
		this.BaseTopTop = new ModelRenderer(this, 0, 65);
		this.BaseTopTop.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8);
		this.BaseTopTop.setRotationPoint(-4.0F, 20.5F, -4.0F);
		this.BaseTopTop.setTextureSize(64, 32);
		this.BaseTopTop.mirror = true;
		this.setRotation(this.BaseTopTop, 0.0F, 0.0F, 0.0F);
		this.MiddleRod = new ModelRenderer(this, 47, 17);
		this.MiddleRod.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
		this.MiddleRod.setRotationPoint(-0.5F, 6.5F, -0.5F);
		this.MiddleRod.setTextureSize(64, 32);
		this.MiddleRod.mirror = true;
		this.setRotation(this.MiddleRod, 0.0F, 0.0F, 0.0F);
		this.Eyes1 = new ModelRenderer(this, 0, 76);
		this.Eyes1.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2);
		this.Eyes1.setRotationPoint(-2.0F, 9.8F, -1.0F);
		this.Eyes1.setTextureSize(64, 32);
		this.Eyes1.mirror = true;
		this.setRotation(this.Eyes1, 0.0F, 0.0F, 0.0F);
		this.Eyes2 = new ModelRenderer(this, 0, 82);
		this.Eyes2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Eyes2.setRotationPoint(-1.3F, 10.5F, -1.0F);
		this.Eyes2.setTextureSize(64, 32);
		this.Eyes2.mirror = true;
		this.setRotation(this.Eyes2, 0.0F, 0.0F, 0.0F);
		this.Eyes3 = new ModelRenderer(this, 0, 88);
		this.Eyes3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Eyes3.setRotationPoint(-2.0F, 10.5F, -1.0F);
		this.Eyes3.setTextureSize(64, 32);
		this.Eyes3.mirror = true;
		this.setRotation(this.Eyes3, 0.0F, 0.0F, 0.0F);
		this.Eyes4 = new ModelRenderer(this, 0, 94);
		this.Eyes4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Eyes4.setRotationPoint(1.0F, 10.5F, -1.0F);
		this.Eyes4.setTextureSize(64, 32);
		this.Eyes4.mirror = true;
		this.setRotation(this.Eyes4, 0.0F, 0.0F, 0.0F);
		this.Eyes5 = new ModelRenderer(this, 0, 101);
		this.Eyes5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Eyes5.setRotationPoint(0.3F, 10.5F, -1.0F);
		this.Eyes5.setTextureSize(64, 32);
		this.Eyes5.mirror = true;
		this.setRotation(this.Eyes5, 0.0F, 0.0F, 0.0F);
		this.ArmB1 = new ModelRenderer(this, 0, 108);
		this.ArmB1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB1.setRotationPoint(-4.0F, 13.3F, -5.0F);
		this.ArmB1.setTextureSize(64, 32);
		this.ArmB1.mirror = true;
		this.setRotation(this.ArmB1, 0.0F, -0.7853982F, -0.2792527F);
		this.ArmB2 = new ModelRenderer(this, 7, 108);
		this.ArmB2.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB2.setRotationPoint(4.2F, 13.3F, 3.5F);
		this.ArmB2.setTextureSize(64, 32);
		this.ArmB2.mirror = true;
		this.setRotation(this.ArmB2, 0.0F, -0.7853982F, 0.2792527F);
		this.ArmB3 = new ModelRenderer(this, 14, 108);
		this.ArmB3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB3.setRotationPoint(-5.0F, 13.3F, -0.5F);
		this.ArmB3.setTextureSize(64, 32);
		this.ArmB3.mirror = true;
		this.setRotation(this.ArmB3, 0.0F, 0.0F, -0.2792527F);
		this.ArmB4 = new ModelRenderer(this, 21, 108);
		this.ArmB4.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB4.setRotationPoint(3.5F, 13.3F, -4.3F);
		this.ArmB4.setTextureSize(64, 32);
		this.ArmB4.mirror = true;
		this.setRotation(this.ArmB4, 0.0F, 0.7853982F, 0.2792527F);
		this.ArmB5 = new ModelRenderer(this, 28, 108);
		this.ArmB5.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB5.setRotationPoint(4.5F, 13.3F, -0.5F);
		this.ArmB5.setTextureSize(64, 32);
		this.ArmB5.mirror = true;
		this.setRotation(this.ArmB5, 0.0F, 0.0F, 0.2792527F);
		this.ArmB6 = new ModelRenderer(this, 35, 108);
		this.ArmB6.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.ArmB6.setRotationPoint(-5.0F, 13.3F, 4.3F);
		this.ArmB6.setTextureSize(64, 32);
		this.ArmB6.mirror = true;
		this.setRotation(this.ArmB6, 0.0F, 0.7853982F, -0.2792527F);
		this.ArmT1 = new ModelRenderer(this, 0, 120);
		this.ArmT1.addBox(0.0F, 10.3F, -0.2F, 1, 7, 1);
		this.ArmT1.setRotationPoint(0.0F, 5.7F, -0.4F);
		this.ArmT1.setTextureSize(64, 32);
		this.ArmT1.mirror = true;
		this.setRotation(this.ArmT1, 0.0F, -0.7853982F, -0.6108652F);
		this.ArmT2 = new ModelRenderer(this, 7, 120);
		this.ArmT2.addBox(0.0F, 3.4F, 0.0F, 1, 7, 1);
		this.ArmT2.setRotationPoint(-3.0F, 10.5F, -0.5F);
		this.ArmT2.setTextureSize(64, 32);
		this.ArmT2.mirror = true;
		this.setRotation(this.ArmT2, 0.0F, 0.0F, 0.6108652F);
		this.ArmT3 = new ModelRenderer(this, 14, 120);
		this.ArmT3.addBox(0.0F, 4.9F, 0.0F, 1, 7, 1);
		this.ArmT3.setRotationPoint(-3.0F, 9.3F, 2.3F);
		this.ArmT3.setTextureSize(64, 32);
		this.ArmT3.mirror = true;
		this.setRotation(this.ArmT3, 0.0F, 0.7853982F, 0.6108652F);
		this.ArmT4 = new ModelRenderer(this, 0, 132);
		this.ArmT4.addBox(0.0F, 2.5F, 0.0F, 1, 7, 1);
		this.ArmT4.setRotationPoint(-3.0F, 11.3F, -4.0F);
		this.ArmT4.setTextureSize(64, 32);
		this.ArmT4.mirror = true;
		this.setRotation(this.ArmT4, 0.0F, -0.7853982F, 0.6108652F);
		this.ArmT5 = new ModelRenderer(this, 7, 132);
		this.ArmT5.addBox(0.0F, 4.5F, -0.1F, 1, 7, 1);
		this.ArmT5.setRotationPoint(1.8F, 10.5F, -2.5F);
		this.ArmT5.setTextureSize(64, 32);
		this.ArmT5.mirror = true;
		this.setRotation(this.ArmT5, 0.0F, 0.7853982F, -0.6283185F);
		this.ArmT6 = new ModelRenderer(this, 14, 132);
		this.ArmT6.addBox(0.0F, 5.0F, -0.1F, 1, 7, 1);
		this.ArmT6.setRotationPoint(1.8F, 10.1F, -0.4F);
		this.ArmT6.setTextureSize(64, 32);
		this.ArmT6.mirror = true;
		this.setRotation(this.ArmT6, 0.0F, 0.0F, -0.6108652F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Base.render(f5);
		this.BaseTop.render(f5);
		this.Wheel1.render(f5);
		this.Wheel2.render(f5);
		this.Wheel3.render(f5);
		this.Wheel4.render(f5);
		this.Wheel5.render(f5);
		this.Wheel6.render(f5);
		this.Wheel7.render(f5);
		this.Wheel8.render(f5);
		this.Wheel9.render(f5);
		this.Wheel10.render(f5);
		this.SkidPlate.render(f5);
		this.BaseTopTop.render(f5);
		this.MiddleRod.render(f5);
		this.Eyes1.render(f5);
		this.Eyes2.render(f5);
		this.Eyes3.render(f5);
		this.Eyes4.render(f5);
		this.Eyes5.render(f5);
		this.ArmB1.render(f5);
		this.ArmB2.render(f5);
		this.ArmB3.render(f5);
		this.ArmB4.render(f5);
		this.ArmB5.render(f5);
		this.ArmB6.render(f5);
		this.ArmT1.render(f5);
		this.ArmT2.render(f5);
		this.ArmT3.render(f5);
		this.ArmT4.render(f5);
		this.ArmT5.render(f5);
		this.ArmT6.render(f5);
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
 * parzi\starwarsmod\rendering\models\mobs\ModelDroidTreadwell.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */