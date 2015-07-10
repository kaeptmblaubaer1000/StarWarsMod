package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMV extends ModelBase
{
	ModelRenderer mainBody;
	ModelRenderer base;
	ModelRenderer bodyPart1;
	ModelRenderer controlRod1;
	ModelRenderer controlRod2;
	ModelRenderer controlRod3;
	ModelRenderer controlRod4;
	ModelRenderer bodyRod1;
	public ModelRenderer windVaneRod1;
	public ModelRenderer windVane1;
	public ModelRenderer windVaneRod2;
	public ModelRenderer windVane2;
	ModelRenderer bodyRodHolder1;
	ModelRenderer bodyRodHolder2;
	ModelRenderer bodyRodHolder3;
	ModelRenderer bodyRodHolder4;
	ModelRenderer bodyPart2;
	ModelRenderer bodyRodHolder5;
	ModelRenderer bodyRodHolder6;
	ModelRenderer bodyRodHolder7;
	ModelRenderer bodyRodHolder8;
	ModelRenderer bodyBase;
	ModelRenderer bodyPart3;
	ModelRenderer bodyPart4;
	ModelRenderer top1;
	ModelRenderer top2;
	ModelRenderer top3;

	public ModelMV()
	{
		textureWidth = 64;
		textureHeight = 128;

		mainBody = new ModelRenderer(this, 0, 0);
		mainBody.addBox(0F, 0F, 0F, 6, 28, 6);
		mainBody.setRotationPoint(-3F, -5F, -3F);
		mainBody.setTextureSize(64, 32);
		mainBody.mirror = true;
		setRotation(mainBody, 0F, 0F, 0F);
		base = new ModelRenderer(this, 0, 43);
		base.addBox(0F, 0F, 0F, 16, 2, 16);
		base.setRotationPoint(-8F, 22F, -8F);
		base.setTextureSize(64, 32);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		bodyPart1 = new ModelRenderer(this, 0, 61);
		bodyPart1.addBox(0F, 0F, 0F, 10, 4, 10);
		bodyPart1.setRotationPoint(-5F, -4F, -5F);
		bodyPart1.setTextureSize(64, 32);
		bodyPart1.mirror = true;
		setRotation(bodyPart1, 0F, 0F, 0F);
		controlRod1 = new ModelRenderer(this, 32, 0);
		controlRod1.addBox(0F, 0F, 0F, 2, 34, 2);
		controlRod1.setRotationPoint(6F, -14F, -8F);
		controlRod1.setTextureSize(64, 32);
		controlRod1.mirror = true;
		setRotation(controlRod1, 0F, 0F, 0F);
		controlRod2 = new ModelRenderer(this, 40, 0);
		controlRod2.addBox(0F, 0F, 0F, 2, 34, 2);
		controlRod2.setRotationPoint(-8F, -14F, -8F);
		controlRod2.setTextureSize(64, 32);
		controlRod2.mirror = true;
		setRotation(controlRod2, 0F, 0F, 0F);
		controlRod3 = new ModelRenderer(this, 48, 0);
		controlRod3.addBox(0F, 0F, 0F, 2, 34, 2);
		controlRod3.setRotationPoint(6F, -14F, 6F);
		controlRod3.setTextureSize(64, 32);
		controlRod3.mirror = true;
		setRotation(controlRod3, 0F, 0F, 0F);
		controlRod4 = new ModelRenderer(this, 56, 0);
		controlRod4.addBox(0F, 0F, 0F, 2, 34, 2);
		controlRod4.setRotationPoint(-8F, -14F, 6F);
		controlRod4.setTextureSize(64, 32);
		controlRod4.mirror = true;
		setRotation(controlRod4, 0F, 0F, 0F);
		bodyRod1 = new ModelRenderer(this, 0, 87);
		bodyRod1.addBox(0F, 0F, 0F, 2, 39, 2);
		bodyRod1.setRotationPoint(-1F, -44F, -1F);
		bodyRod1.setTextureSize(64, 32);
		bodyRod1.mirror = true;
		setRotation(bodyRod1, 0F, 0F, 0F);
		windVaneRod1 = new ModelRenderer(this, 32, 39);
		windVaneRod1.addBox(1F, 0F, 0F, 1, 1, 1);
		windVaneRod1.setRotationPoint(0F, -44F, 0F);
		windVaneRod1.setTextureSize(64, 32);
		windVaneRod1.mirror = true;
		setRotation(windVaneRod1, 0F, 0F, 0F);
		windVane1 = new ModelRenderer(this, 36, 39);
		windVane1.addBox(2F, -1F, 0F, 3, 3, 1);
		windVane1.setRotationPoint(0F, -44F, 0F);
		windVane1.setTextureSize(64, 32);
		windVane1.mirror = true;
		setRotation(windVane1, 0F, 0F, 0F);
		windVaneRod2 = new ModelRenderer(this, 32, 41);
		windVaneRod2.addBox(-2F, 0F, -1F, 1, 1, 1);
		windVaneRod2.setRotationPoint(0F, -44F, 0F);
		windVaneRod2.setTextureSize(64, 32);
		windVaneRod2.mirror = true;
		setRotation(windVaneRod2, 0F, 0F, 0F);
		windVane2 = new ModelRenderer(this, 44, 39);
		windVane2.addBox(-5F, -1F, -1F, 3, 3, 1);
		windVane2.setRotationPoint(0F, -44F, 0F);
		windVane2.setTextureSize(64, 32);
		windVane2.mirror = true;
		setRotation(windVane2, 0F, 0F, 0F);
		bodyRodHolder1 = new ModelRenderer(this, 8, 89);
		bodyRodHolder1.addBox(1F, 0F, 1F, 2, 2, 2);
		bodyRodHolder1.setRotationPoint(-7F, -3F, -7F);
		bodyRodHolder1.setTextureSize(64, 32);
		bodyRodHolder1.mirror = true;
		setRotation(bodyRodHolder1, 0F, 0F, 0F);
		bodyRodHolder2 = new ModelRenderer(this, 8, 93);
		bodyRodHolder2.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder2.setRotationPoint(4F, -3F, -6F);
		bodyRodHolder2.setTextureSize(64, 32);
		bodyRodHolder2.mirror = true;
		setRotation(bodyRodHolder2, 0F, 0F, 0F);
		bodyRodHolder3 = new ModelRenderer(this, 8, 97);
		bodyRodHolder3.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder3.setRotationPoint(4F, -3F, 4F);
		bodyRodHolder3.setTextureSize(64, 32);
		bodyRodHolder3.mirror = true;
		setRotation(bodyRodHolder3, 0F, 0F, 0F);
		bodyRodHolder4 = new ModelRenderer(this, 8, 101);
		bodyRodHolder4.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder4.setRotationPoint(-6F, -3F, 4F);
		bodyRodHolder4.setTextureSize(64, 32);
		bodyRodHolder4.mirror = true;
		setRotation(bodyRodHolder4, 0F, 0F, 0F);
		bodyPart2 = new ModelRenderer(this, 0, 61);
		bodyPart2.addBox(0F, 0F, 0F, 10, 4, 10);
		bodyPart2.setRotationPoint(-5F, 14F, -5F);
		bodyPart2.setTextureSize(64, 32);
		bodyPart2.mirror = true;
		setRotation(bodyPart2, 0F, 0F, 0F);
		bodyRodHolder5 = new ModelRenderer(this, 41, 62);
		bodyRodHolder5.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder5.setRotationPoint(4F, 15F, -6F);
		bodyRodHolder5.setTextureSize(64, 32);
		bodyRodHolder5.mirror = true;
		setRotation(bodyRodHolder5, 0F, 0F, 0F);
		bodyRodHolder6 = new ModelRenderer(this, 50, 62);
		bodyRodHolder6.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder6.setRotationPoint(-6F, 15F, -6F);
		bodyRodHolder6.setTextureSize(64, 32);
		bodyRodHolder6.mirror = true;
		setRotation(bodyRodHolder6, 0F, 0F, 0F);
		bodyRodHolder7 = new ModelRenderer(this, 41, 67);
		bodyRodHolder7.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder7.setRotationPoint(4F, 15F, 4F);
		bodyRodHolder7.setTextureSize(64, 32);
		bodyRodHolder7.mirror = true;
		setRotation(bodyRodHolder7, 0F, 0F, 0F);
		bodyRodHolder8 = new ModelRenderer(this, 50, 67);
		bodyRodHolder8.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder8.setRotationPoint(-6F, 15F, 4F);
		bodyRodHolder8.setTextureSize(64, 32);
		bodyRodHolder8.mirror = true;
		setRotation(bodyRodHolder8, 0F, 0F, 0F);
		bodyBase = new ModelRenderer(this, 0, 75);
		bodyBase.addBox(0F, 0F, 0F, 8, 4, 8);
		bodyBase.setRotationPoint(-4F, 19F, -4F);
		bodyBase.setTextureSize(64, 32);
		bodyBase.mirror = true;
		setRotation(bodyBase, 0F, 0F, 0F);
		bodyPart3 = new ModelRenderer(this, 8, 105);
		bodyPart3.addBox(0F, 0F, 0F, 8, 8, 8);
		bodyPart3.setRotationPoint(-4F, 5F, -4F);
		bodyPart3.setTextureSize(64, 32);
		bodyPart3.mirror = true;
		setRotation(bodyPart3, 0F, 0F, 0F);
		bodyPart4 = new ModelRenderer(this, 17, 89);
		bodyPart4.addBox(0F, 0F, 0F, 8, 3, 8);
		bodyPart4.setRotationPoint(-4F, 1F, -4F);
		bodyPart4.setTextureSize(64, 32);
		bodyPart4.mirror = true;
		setRotation(bodyPart4, 0F, 0F, 0F);
		top1 = new ModelRenderer(this, 0, 35);
		top1.addBox(0F, 0F, 0F, 4, 3, 4);
		top1.setRotationPoint(-2F, -9F, -2F);
		top1.setTextureSize(64, 32);
		top1.mirror = true;
		setRotation(top1, 0F, 0F, 0F);
		top2 = new ModelRenderer(this, 41, 72);
		top2.addBox(0F, 0F, 0F, 4, 3, 4);
		top2.setRotationPoint(-2F, -13F, -2F);
		top2.setTextureSize(64, 32);
		top2.mirror = true;
		setRotation(top2, 0F, 0F, 0F);
		top3 = new ModelRenderer(this, 41, 101);
		top3.addBox(0F, 0F, 0F, 4, 7, 4);
		top3.setRotationPoint(-2F, -21F, -2F);
		top3.setTextureSize(64, 32);
		top3.mirror = true;
		setRotation(top3, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		mainBody.render(f5);
		base.render(f5);
		bodyPart1.render(f5);
		controlRod1.render(f5);
		controlRod2.render(f5);
		controlRod3.render(f5);
		controlRod4.render(f5);
		bodyRod1.render(f5);
		windVaneRod1.render(f5);
		windVane1.render(f5);
		windVaneRod2.render(f5);
		windVane2.render(f5);
		bodyRodHolder1.render(f5);
		bodyRodHolder2.render(f5);
		bodyRodHolder3.render(f5);
		bodyRodHolder4.render(f5);
		bodyPart2.render(f5);
		bodyRodHolder5.render(f5);
		bodyRodHolder6.render(f5);
		bodyRodHolder7.render(f5);
		bodyRodHolder8.render(f5);
		bodyBase.render(f5);
		bodyPart3.render(f5);
		bodyPart4.render(f5);
		top1.render(f5);
		top2.render(f5);
		top3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles()
	{
	}

}