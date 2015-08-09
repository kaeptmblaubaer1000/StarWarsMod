package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTauntaun extends ModelBase
{
	// fields
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
	float animScale = 1f;

	public ModelTauntaun()
	{
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 16, 25);
		head.addBox(-4F, -4F, -6F, 8, 8, 5);
		head.setRotationPoint(0F, -6F, -1F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 20, 0);
		body.addBox(-6F, -10F, -7F, 10, 18, 7);
		body.setRotationPoint(1F, 3F, 4F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0.7004588F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 13);
		leg1.addBox(-3F, 0F, -2F, 4, 14, 4);
		leg1.setRotationPoint(-3F, 10F, 7F);
		leg1.setTextureSize(64, 64);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 31);
		leg2.addBox(-1F, 0F, -2F, 4, 14, 4);
		leg2.setRotationPoint(3F, 10F, 7F);
		leg2.setTextureSize(64, 64);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		Snout = new ModelRenderer(this, 0, 0);
		Snout.addBox(-3F, -3F, -10F, 6, 6, 4);
		Snout.setRotationPoint(0F, -6F, -1F);
		Snout.setTextureSize(64, 64);
		Snout.mirror = true;
		setRotation(Snout, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 10);
		Nose.addBox(-1F, 0F, -11F, 2, 2, 1);
		Nose.setRotationPoint(0F, -6F, -1F);
		Nose.setTextureSize(64, 64);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
		ArmL = new ModelRenderer(this, 30, 38);
		ArmL.addBox(0F, 0F, 0F, 2, 6, 3);
		ArmL.setRotationPoint(2F, 2F, -5F);
		ArmL.setTextureSize(64, 64);
		ArmL.mirror = true;
		setRotation(ArmL, -87.26646F, 0F, 0F);
		ArmR = new ModelRenderer(this, 24, 52);
		ArmR.addBox(0F, 0F, 0F, 2, 6, 3);
		ArmR.setRotationPoint(-4F, 2F, -5F);
		ArmR.setTextureSize(64, 64);
		ArmR.mirror = true;
		setRotation(ArmR, -87.26646F, 0F, 0F);
		HornBaseR = new ModelRenderer(this, 16, 38);
		HornBaseR.addBox(-7F, -1F, -6F, 3, 3, 4);
		HornBaseR.setRotationPoint(0F, -6F, -1F);
		HornBaseR.setTextureSize(64, 64);
		HornBaseR.mirror = true;
		setRotation(HornBaseR, 0F, 0F, 0F);
		HornBaseL = new ModelRenderer(this, 16, 45);
		HornBaseL.addBox(4F, -1F, -6F, 3, 3, 4);
		HornBaseL.setRotationPoint(0F, -6F, -1F);
		HornBaseL.setTextureSize(64, 64);
		HornBaseL.mirror = true;
		setRotation(HornBaseL, 0F, 0F, 0F);
		HornSectionR = new ModelRenderer(this, 0, 53);
		HornSectionR.addBox(-6F, 0F, -9F, 2, 2, 4);
		HornSectionR.setRotationPoint(0F, -6F, -1F);
		HornSectionR.setTextureSize(64, 64);
		HornSectionR.mirror = true;
		setRotation(HornSectionR, 0F, -0.122173F, 0F);
		HornSectionL = new ModelRenderer(this, 12, 52);
		HornSectionL.addBox(4F, 0F, -9F, 2, 2, 4);
		HornSectionL.setRotationPoint(0F, -6F, -1F);
		HornSectionL.setTextureSize(64, 64);
		HornSectionL.mirror = true;
		setRotation(HornSectionL, 0F, 0.122173F, 0F);
		SmallHornSectionR = new ModelRenderer(this, 0, 49);
		SmallHornSectionR.addBox(-5F, 1F, -12F, 1, 1, 3);
		SmallHornSectionR.setRotationPoint(0F, -6F, -1F);
		SmallHornSectionR.setTextureSize(64, 64);
		SmallHornSectionR.mirror = true;
		setRotation(SmallHornSectionR, 0F, -0.2443461F, 0F);
		SmallHornSectionL = new ModelRenderer(this, -1, 59);
		SmallHornSectionL.addBox(4F, 1F, -12F, 1, 1, 3);
		SmallHornSectionL.setRotationPoint(0F, -6F, -1F);
		SmallHornSectionL.setTextureSize(64, 64);
		SmallHornSectionL.mirror = true;
		setRotation(SmallHornSectionL, 0F, 0.2443461F, 0F);
		TailBase = new ModelRenderer(this, 34, 47);
		TailBase.addBox(0F, 0F, 0F, 6, 6, 5);
		TailBase.setRotationPoint(-3F, 6F, 7F);
		TailBase.setTextureSize(64, 64);
		TailBase.mirror = true;
		setRotation(TailBase, -0.3717861F, 0F, 0F);
		TailSection1 = new ModelRenderer(this, 40, 38);
		TailSection1.addBox(0F, 0F, 0F, 5, 5, 4);
		TailSection1.setRotationPoint(-2.5F, 8F, 12F);
		TailSection1.setTextureSize(64, 64);
		TailSection1.mirror = true;
		setRotation(TailSection1, -0.5205006F, 0F, 0F);
		TailSection2 = new ModelRenderer(this, 42, 31);
		TailSection2.addBox(0F, 0F, 0F, 4, 4, 3);
		TailSection2.setRotationPoint(-2F, 10.5F, 15.5F);
		TailSection2.setTextureSize(64, 64);
		TailSection2.mirror = true;
		setRotation(TailSection2, -0.669215F, 0F, 0F);
		TailSection3 = new ModelRenderer(this, 7, 59);
		TailSection3.addBox(0F, 0F, 0F, 3, 3, 2);
		TailSection3.setRotationPoint(-1.5F, 13F, 17.25F);
		TailSection3.setTextureSize(64, 64);
		TailSection3.mirror = true;
		setRotation(TailSection3, -0.5205006F, 0F, 0F);
		TailSection4 = new ModelRenderer(this, 42, 26);
		TailSection4.addBox(0F, 0F, 0F, 2, 2, 2);
		TailSection4.setRotationPoint(-1F, 14.5F, 18.5F);
		TailSection4.setTextureSize(64, 64);
		TailSection4.mirror = true;
		setRotation(TailSection4, -0.3346075F, 0F, 0F);
		TailSection5 = new ModelRenderer(this, 17, 58);
		TailSection5.addBox(0F, 0F, 0F, 1, 2, 2);
		TailSection5.setRotationPoint(-0.5F, 15F, 20F);
		TailSection5.setTextureSize(64, 64);
		TailSection5.mirror = true;
		setRotation(TailSection5, 0.1115358F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		Snout.render(f5);
		Nose.render(f5);
		ArmL.render(f5);
		ArmR.render(f5);
		HornBaseR.render(f5);
		HornBaseL.render(f5);
		HornSectionR.render(f5);
		HornSectionL.render(f5);
		SmallHornSectionR.render(f5);
		SmallHornSectionL.render(f5);
		TailBase.render(f5);
		TailSection1.render(f5);
		TailSection2.render(f5);
		TailSection3.render(f5);
		TailSection4.render(f5);
		TailSection5.render(f5);
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
		head.rotateAngleY = f3 / (180F / (float)Math.PI);
		Snout.rotateAngleY = f3 / (180F / (float)Math.PI);
		Nose.rotateAngleY = f3 / (180F / (float)Math.PI);
		HornBaseL.rotateAngleY = f3 / (180F / (float)Math.PI);
		HornBaseR.rotateAngleY = f3 / (180F / (float)Math.PI);
		HornSectionL.rotateAngleY = f3 / (180F / (float)Math.PI) + 0.12F;
		HornSectionR.rotateAngleY = f3 / (180F / (float)Math.PI) - 0.12F;
		SmallHornSectionL.rotateAngleY = f3 / (180F / (float)Math.PI) + 0.24F;
		SmallHornSectionR.rotateAngleY = f3 / (180F / (float)Math.PI) - 0.24F;

		head.rotateAngleX = f4 / (180F / (float)Math.PI);
		Snout.rotateAngleX = f4 / (180F / (float)Math.PI);
		Nose.rotateAngleX = f4 / (180F / (float)Math.PI);
		HornBaseL.rotateAngleX = f4 / (180F / (float)Math.PI);
		HornBaseR.rotateAngleX = f4 / (180F / (float)Math.PI);
		HornSectionL.rotateAngleX = f4 / (180F / (float)Math.PI);
		HornSectionR.rotateAngleX = f4 / (180F / (float)Math.PI);
		SmallHornSectionL.rotateAngleX = f4 / (180F / (float)Math.PI);
		SmallHornSectionR.rotateAngleX = f4 / (180F / (float)Math.PI);

		ArmR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		ArmL.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		ArmL.rotateAngleZ = 0.0F;
		ArmR.rotateAngleZ = 0.0F;

		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1;
		leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1;
		leg1.rotateAngleY = 0.0F;
		leg2.rotateAngleY = 0.0F;
	}
}