package com.parzi.starwarsmod.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDroidSurgical extends ModelBase
{
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightShoulder;
	ModelRenderer leftShoulder;
	ModelRenderer rightlegupper;
	ModelRenderer leftlegupper;
	ModelRenderer mouth;
	ModelRenderer leftlegpin;
	ModelRenderer rightlegpin;
	ModelRenderer leftlegsmall;
	ModelRenderer rightlegsmall;
	ModelRenderer leftlegbottom;
	ModelRenderer rightlegbottom;
	ModelRenderer leftarmhandthing;
	ModelRenderer leftarmupper;
	ModelRenderer leftarmpin;
	ModelRenderer leftarmlower;
	ModelRenderer rightarmupper;
	ModelRenderer rightarmpin;
	ModelRenderer rightarmlower;
	float animScale = 0.8F;

	public ModelDroidSurgical()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-2.5F, -6.0F, -2.0F, 5, 6, 4);
		this.head.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.head.setTextureSize(128, 128);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 12);
		this.body.addBox(-4.0F, 0.0F, -1.5F, 8, 12, 3);
		this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.body.setTextureSize(128, 128);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.rightShoulder = new ModelRenderer(this, 0, 28);
		this.rightShoulder.addBox(-1.0F, -1.0F, -1.5F, 3, 2, 3);
		this.rightShoulder.setRotationPoint(-5.0F, -1.0F, 0.0F);
		this.rightShoulder.setTextureSize(128, 128);
		this.rightShoulder.mirror = true;
		this.setRotation(this.rightShoulder, 0.0F, 0.0F, 0.0F);
		this.leftShoulder = new ModelRenderer(this, 0, 35);
		this.leftShoulder.addBox(-2.0F, -1.0F, -1.5F, 3, 2, 3);
		this.leftShoulder.setRotationPoint(5.0F, -1.0F, 0.0F);
		this.leftShoulder.setTextureSize(128, 128);
		this.leftShoulder.mirror = true;
		this.setRotation(this.leftShoulder, 0.0F, 0.0F, 0.0F);
		this.rightlegupper = new ModelRenderer(this, 0, 41);
		this.rightlegupper.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
		this.rightlegupper.setRotationPoint(-2.0F, 10.0F, 0.0F);
		this.rightlegupper.setTextureSize(128, 128);
		this.rightlegupper.mirror = true;
		this.setRotation(this.rightlegupper, 0.0F, 0.0F, 0.0F);
		this.leftlegupper = new ModelRenderer(this, 0, 50);
		this.leftlegupper.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
		this.leftlegupper.setRotationPoint(2.0F, 10.0F, 0.0F);
		this.leftlegupper.setTextureSize(128, 128);
		this.leftlegupper.mirror = true;
		this.setRotation(this.leftlegupper, 0.0F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 0, 59);
		this.mouth.addBox(-1.0F, -3.0F, -3.5F, 2, 3, 2);
		this.mouth.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.mouth.setTextureSize(128, 128);
		this.mouth.mirror = true;
		this.setRotation(this.mouth, 0.0F, 0.0F, 0.0F);
		this.leftlegpin = new ModelRenderer(this, 0, 66);
		this.leftlegpin.addBox(-1.5F, 3.5F, -0.5F, 3, 1, 1);
		this.leftlegpin.setRotationPoint(2.0F, 10.0F, 0.0F);
		this.leftlegpin.setTextureSize(128, 128);
		this.leftlegpin.mirror = true;
		this.setRotation(this.leftlegpin, 0.0F, 0.0F, 0.0F);
		this.rightlegpin = new ModelRenderer(this, 0, 70);
		this.rightlegpin.addBox(-1.5F, 3.5F, -0.5F, 3, 1, 1);
		this.rightlegpin.setRotationPoint(-2.0F, 10.0F, 0.0F);
		this.rightlegpin.setTextureSize(128, 128);
		this.rightlegpin.mirror = true;
		this.setRotation(this.rightlegpin, 0.0F, 0.0F, 0.0F);
		this.leftlegsmall = new ModelRenderer(this, 0, 74);
		this.leftlegsmall.addBox(-0.5F, 5.0F, -0.5F, 1, 4, 1);
		this.leftlegsmall.setRotationPoint(2.0F, 10.0F, 0.0F);
		this.leftlegsmall.setTextureSize(128, 128);
		this.leftlegsmall.mirror = true;
		this.setRotation(this.leftlegsmall, 0.0F, 0.0F, 0.0F);
		this.rightlegsmall = new ModelRenderer(this, 0, 81);
		this.rightlegsmall.addBox(-0.5F, 5.0F, -0.5F, 1, 4, 1);
		this.rightlegsmall.setRotationPoint(-2.0F, 10.0F, 0.0F);
		this.rightlegsmall.setTextureSize(128, 128);
		this.rightlegsmall.mirror = true;
		this.setRotation(this.rightlegsmall, 0.0F, 0.0F, 0.0F);
		this.leftlegbottom = new ModelRenderer(this, 0, 88);
		this.leftlegbottom.addBox(-1.5F, 9.0F, -1.5F, 3, 5, 3);
		this.leftlegbottom.setRotationPoint(2.0F, 10.0F, 0.0F);
		this.leftlegbottom.setTextureSize(128, 128);
		this.leftlegbottom.mirror = true;
		this.setRotation(this.leftlegbottom, 0.0F, 0.0F, 0.0F);
		this.rightlegbottom = new ModelRenderer(this, 0, 98);
		this.rightlegbottom.addBox(-1.5F, 9.0F, -1.5F, 3, 5, 3);
		this.rightlegbottom.setRotationPoint(-2.0F, 10.0F, 0.0F);
		this.rightlegbottom.setTextureSize(128, 128);
		this.rightlegbottom.mirror = true;
		this.setRotation(this.rightlegbottom, 0.0F, 0.0F, 0.0F);
		this.leftarmhandthing = new ModelRenderer(this, 0, 108);
		this.leftarmhandthing.addBox(-1.0F, 7.0F, -0.3F, 2, 4, 2);
		this.leftarmhandthing.setRotationPoint(5.0F, -1.0F, 0.0F);
		this.leftarmhandthing.setTextureSize(128, 128);
		this.leftarmhandthing.mirror = true;
		this.setRotation(this.leftarmhandthing, -0.3141593F, -0.2443461F, 0.0F);
		this.leftarmupper = new ModelRenderer(this, 0, 116);
		this.leftarmupper.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
		this.leftarmupper.setRotationPoint(5.0F, -1.0F, 0.0F);
		this.leftarmupper.setTextureSize(128, 128);
		this.leftarmupper.mirror = true;
		this.setRotation(this.leftarmupper, -0.1396263F, -0.2443461F, 0.0F);
		this.leftarmpin = new ModelRenderer(this, 0, 123);
		this.leftarmpin.addBox(-1.0F, 3.0F, -0.5F, 2, 1, 1);
		this.leftarmpin.setRotationPoint(5.0F, -1.0F, 0.0F);
		this.leftarmpin.setTextureSize(128, 128);
		this.leftarmpin.mirror = true;
		this.setRotation(this.leftarmpin, -0.1396263F, -0.2443461F, 0.0F);
		this.leftarmlower = new ModelRenderer(this, 6, 116);
		this.leftarmlower.addBox(-0.5F, 3.8F, 0.2F, 1, 4, 1);
		this.leftarmlower.setRotationPoint(5.0F, -1.0F, 0.0F);
		this.leftarmlower.setTextureSize(128, 128);
		this.leftarmlower.mirror = true;
		this.setRotation(this.leftarmlower, -0.3141593F, -0.2443461F, 0.0F);
		this.rightarmupper = new ModelRenderer(this, 12, 116);
		this.rightarmupper.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
		this.rightarmupper.setRotationPoint(-5.0F, -1.0F, 0.0F);
		this.rightarmupper.setTextureSize(128, 128);
		this.rightarmupper.mirror = true;
		this.setRotation(this.rightarmupper, -0.1396263F, 0.2443461F, 0.0F);
		this.rightarmpin = new ModelRenderer(this, 8, 123);
		this.rightarmpin.addBox(-1.0F, 3.0F, -0.5F, 2, 1, 1);
		this.rightarmpin.setRotationPoint(-5.0F, -1.0F, 0.0F);
		this.rightarmpin.setTextureSize(128, 128);
		this.rightarmpin.mirror = true;
		this.setRotation(this.rightarmpin, -0.1396263F, 0.2443461F, 0.0F);
		this.rightarmlower = new ModelRenderer(this, 10, 108);
		this.rightarmlower.addBox(-0.5F, 3.8F, 0.1F, 1, 6, 1);
		this.rightarmlower.setRotationPoint(-5.0F, -1.0F, 0.0F);
		this.rightarmlower.setTextureSize(128, 128);
		this.rightarmlower.mirror = true;
		this.setRotation(this.rightarmlower, -0.3141593F, 0.2443461F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.head.render(f5);
		this.body.render(f5);
		this.rightShoulder.render(f5);
		this.leftShoulder.render(f5);
		this.rightlegupper.render(f5);
		this.leftlegupper.render(f5);
		this.mouth.render(f5);
		this.leftlegpin.render(f5);
		this.rightlegpin.render(f5);
		this.leftlegsmall.render(f5);
		this.rightlegsmall.render(f5);
		this.leftlegbottom.render(f5);
		this.rightlegbottom.render(f5);
		this.leftarmhandthing.render(f5);
		this.leftarmupper.render(f5);
		this.leftarmpin.render(f5);
		this.leftarmlower.render(f5);
		this.rightarmupper.render(f5);
		this.rightarmpin.render(f5);
		this.rightarmlower.render(f5);
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
		this.head.rotateAngleY = f3 / 57.295776F;
		this.head.rotateAngleX = f4 / 57.295776F;
		this.mouth.rotateAngleY = f3 / 57.295776F;
		this.mouth.rotateAngleX = f4 / 57.295776F;
		this.rightarmlower.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F - 0.3141593F;
		this.rightarmpin.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F - 0.1396263F;
		this.rightarmupper.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F - 0.1396263F;
		this.leftarmhandthing.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F - 0.3141593F;
		this.leftarmlower.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F - 0.3141593F;
		this.leftarmpin.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F - 0.1396263F;
		this.leftarmupper.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F - 0.1396263F;
		this.rightlegbottom.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.rightlegsmall.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.rightlegpin.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.rightlegupper.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.leftlegbottom.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.leftlegsmall.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.leftlegpin.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.leftlegupper.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\mobs\ModelDroidSurgical.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */