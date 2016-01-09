package com.parzi.starwarsmod.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTauntaun extends ModelBase
{
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer Snout;
	ModelRenderer Nose;
	ModelRenderer ArmL;
	ModelRenderer ArmR;
	ModelRenderer HornBaseR;
	ModelRenderer HornBaseL;
	ModelRenderer HornSectionR;
	ModelRenderer HornSectionL;
	ModelRenderer SmallHornSectionR;
	ModelRenderer SmallHornSectionL;
	ModelRenderer TailBase;
	ModelRenderer TailSection1;
	ModelRenderer TailSection2;
	ModelRenderer TailSection3;
	ModelRenderer TailSection4;
	ModelRenderer TailSection5;
	float animScale = 1.0F;

	public ModelTauntaun()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.head = new ModelRenderer(this, 16, 25);
		this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 5);
		this.head.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.head.setTextureSize(64, 64);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 20, 0);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 10, 18, 7);
		this.body.setRotationPoint(1.0F, 3.0F, 4.0F);
		this.body.setTextureSize(64, 64);
		this.body.mirror = true;
		this.setRotation(this.body, 0.7004588F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 13);
		this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 14, 4);
		this.leg1.setRotationPoint(-3.0F, 10.0F, 7.0F);
		this.leg1.setTextureSize(64, 64);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 31);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 14, 4);
		this.leg2.setRotationPoint(3.0F, 10.0F, 7.0F);
		this.leg2.setTextureSize(64, 64);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 0);
		this.Snout.addBox(-3.0F, -3.0F, -10.0F, 6, 6, 4);
		this.Snout.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.Snout.setTextureSize(64, 64);
		this.Snout.mirror = true;
		this.setRotation(this.Snout, 0.0F, 0.0F, 0.0F);
		this.Nose = new ModelRenderer(this, 0, 10);
		this.Nose.addBox(-1.0F, 0.0F, -11.0F, 2, 2, 1);
		this.Nose.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.Nose.setTextureSize(64, 64);
		this.Nose.mirror = true;
		this.setRotation(this.Nose, 0.0F, 0.0F, 0.0F);
		this.ArmL = new ModelRenderer(this, 30, 38);
		this.ArmL.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3);
		this.ArmL.setRotationPoint(2.0F, 2.0F, -5.0F);
		this.ArmL.setTextureSize(64, 64);
		this.ArmL.mirror = true;
		this.setRotation(this.ArmL, -87.26646F, 0.0F, 0.0F);
		this.ArmR = new ModelRenderer(this, 24, 52);
		this.ArmR.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3);
		this.ArmR.setRotationPoint(-4.0F, 2.0F, -5.0F);
		this.ArmR.setTextureSize(64, 64);
		this.ArmR.mirror = true;
		this.setRotation(this.ArmR, -87.26646F, 0.0F, 0.0F);
		this.HornBaseR = new ModelRenderer(this, 16, 38);
		this.HornBaseR.addBox(-7.0F, -1.0F, -6.0F, 3, 3, 4);
		this.HornBaseR.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.HornBaseR.setTextureSize(64, 64);
		this.HornBaseR.mirror = true;
		this.setRotation(this.HornBaseR, 0.0F, 0.0F, 0.0F);
		this.HornBaseL = new ModelRenderer(this, 16, 45);
		this.HornBaseL.addBox(4.0F, -1.0F, -6.0F, 3, 3, 4);
		this.HornBaseL.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.HornBaseL.setTextureSize(64, 64);
		this.HornBaseL.mirror = true;
		this.setRotation(this.HornBaseL, 0.0F, 0.0F, 0.0F);
		this.HornSectionR = new ModelRenderer(this, 0, 53);
		this.HornSectionR.addBox(-6.0F, 0.0F, -9.0F, 2, 2, 4);
		this.HornSectionR.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.HornSectionR.setTextureSize(64, 64);
		this.HornSectionR.mirror = true;
		this.setRotation(this.HornSectionR, 0.0F, -0.122173F, 0.0F);
		this.HornSectionL = new ModelRenderer(this, 12, 52);
		this.HornSectionL.addBox(4.0F, 0.0F, -9.0F, 2, 2, 4);
		this.HornSectionL.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.HornSectionL.setTextureSize(64, 64);
		this.HornSectionL.mirror = true;
		this.setRotation(this.HornSectionL, 0.0F, 0.122173F, 0.0F);
		this.SmallHornSectionR = new ModelRenderer(this, 0, 49);
		this.SmallHornSectionR.addBox(-5.0F, 1.0F, -12.0F, 1, 1, 3);
		this.SmallHornSectionR.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.SmallHornSectionR.setTextureSize(64, 64);
		this.SmallHornSectionR.mirror = true;
		this.setRotation(this.SmallHornSectionR, 0.0F, -0.2443461F, 0.0F);
		this.SmallHornSectionL = new ModelRenderer(this, -1, 59);
		this.SmallHornSectionL.addBox(4.0F, 1.0F, -12.0F, 1, 1, 3);
		this.SmallHornSectionL.setRotationPoint(0.0F, -6.0F, -1.0F);
		this.SmallHornSectionL.setTextureSize(64, 64);
		this.SmallHornSectionL.mirror = true;
		this.setRotation(this.SmallHornSectionL, 0.0F, 0.2443461F, 0.0F);
		this.TailBase = new ModelRenderer(this, 34, 47);
		this.TailBase.addBox(0.0F, 0.0F, 0.0F, 6, 6, 5);
		this.TailBase.setRotationPoint(-3.0F, 6.0F, 7.0F);
		this.TailBase.setTextureSize(64, 64);
		this.TailBase.mirror = true;
		this.setRotation(this.TailBase, -0.3717861F, 0.0F, 0.0F);
		this.TailSection1 = new ModelRenderer(this, 40, 38);
		this.TailSection1.addBox(0.0F, 0.0F, 0.0F, 5, 5, 4);
		this.TailSection1.setRotationPoint(-2.5F, 8.0F, 12.0F);
		this.TailSection1.setTextureSize(64, 64);
		this.TailSection1.mirror = true;
		this.setRotation(this.TailSection1, -0.5205006F, 0.0F, 0.0F);
		this.TailSection2 = new ModelRenderer(this, 42, 31);
		this.TailSection2.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3);
		this.TailSection2.setRotationPoint(-2.0F, 10.5F, 15.5F);
		this.TailSection2.setTextureSize(64, 64);
		this.TailSection2.mirror = true;
		this.setRotation(this.TailSection2, -0.669215F, 0.0F, 0.0F);
		this.TailSection3 = new ModelRenderer(this, 7, 59);
		this.TailSection3.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2);
		this.TailSection3.setRotationPoint(-1.5F, 13.0F, 17.25F);
		this.TailSection3.setTextureSize(64, 64);
		this.TailSection3.mirror = true;
		this.setRotation(this.TailSection3, -0.5205006F, 0.0F, 0.0F);
		this.TailSection4 = new ModelRenderer(this, 42, 26);
		this.TailSection4.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.TailSection4.setRotationPoint(-1.0F, 14.5F, 18.5F);
		this.TailSection4.setTextureSize(64, 64);
		this.TailSection4.mirror = true;
		this.setRotation(this.TailSection4, -0.3346075F, 0.0F, 0.0F);
		this.TailSection5 = new ModelRenderer(this, 17, 58);
		this.TailSection5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
		this.TailSection5.setRotationPoint(-0.5F, 15.0F, 20.0F);
		this.TailSection5.setTextureSize(64, 64);
		this.TailSection5.mirror = true;
		this.setRotation(this.TailSection5, 0.1115358F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.head.render(f5);
		this.body.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.Snout.render(f5);
		this.Nose.render(f5);
		this.ArmL.render(f5);
		this.ArmR.render(f5);
		this.HornBaseR.render(f5);
		this.HornBaseL.render(f5);
		this.HornSectionR.render(f5);
		this.HornSectionL.render(f5);
		this.SmallHornSectionR.render(f5);
		this.SmallHornSectionL.render(f5);
		this.TailBase.render(f5);
		this.TailSection1.render(f5);
		this.TailSection2.render(f5);
		this.TailSection3.render(f5);
		this.TailSection4.render(f5);
		this.TailSection5.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
		this.head.rotateAngleY = f3 / 57.295776F;
		this.Snout.rotateAngleY = f3 / 57.295776F;
		this.Nose.rotateAngleY = f3 / 57.295776F;
		this.HornBaseL.rotateAngleY = f3 / 57.295776F;
		this.HornBaseR.rotateAngleY = f3 / 57.295776F;
		this.HornSectionL.rotateAngleY = f3 / 57.295776F + 0.12F;
		this.HornSectionR.rotateAngleY = f3 / 57.295776F - 0.12F;
		this.SmallHornSectionL.rotateAngleY = f3 / 57.295776F + 0.24F;
		this.SmallHornSectionR.rotateAngleY = f3 / 57.295776F - 0.24F;
		this.head.rotateAngleX = f4 / 57.295776F;
		this.Snout.rotateAngleX = f4 / 57.295776F;
		this.Nose.rotateAngleX = f4 / 57.295776F;
		this.HornBaseL.rotateAngleX = f4 / 57.295776F;
		this.HornBaseR.rotateAngleX = f4 / 57.295776F;
		this.HornSectionL.rotateAngleX = f4 / 57.295776F;
		this.HornSectionR.rotateAngleX = f4 / 57.295776F;
		this.SmallHornSectionL.rotateAngleX = f4 / 57.295776F;
		this.SmallHornSectionR.rotateAngleX = f4 / 57.295776F;
		this.ArmR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.ArmL.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.ArmL.rotateAngleZ = 0.0F;
		this.ArmR.rotateAngleZ = 0.0F;
		this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.leg1.rotateAngleY = 0.0F;
		this.leg2.rotateAngleY = 0.0F;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\mobs\ModelTauntaun.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */