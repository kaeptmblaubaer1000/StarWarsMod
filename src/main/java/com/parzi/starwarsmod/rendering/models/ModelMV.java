package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMV extends ModelBase {
	ModelRenderer mainBody;
	ModelRenderer base;
	ModelRenderer bodyPart1;
	ModelRenderer controlRod1;
	ModelRenderer controlRod2;
	ModelRenderer controlRod3;
	ModelRenderer controlRod4;
	ModelRenderer bodyRod1;
	ModelRenderer windVaneRod1;
	ModelRenderer windVane1;
	ModelRenderer windVaneRod2;
	ModelRenderer windVane2;
	ModelRenderer bodyRodHolder1;
	ModelRenderer bodyRodHolder2;
	ModelRenderer bodyRodHolder3;
	ModelRenderer bodyRodHolder4;

	public ModelMV() {
		textureWidth = 64;
		textureHeight = 128;

		mainBody = new ModelRenderer(this, 0, 0);
		mainBody.addBox(0F, 0F, 0F, 8, 35, 8);
		mainBody.setRotationPoint(-4F, -12F, -4F);
		mainBody.setTextureSize(64, 128);
		mainBody.mirror = true;
		setRotation(mainBody, 0F, 0F, 0F);
		base = new ModelRenderer(this, 0, 43);
		base.addBox(0F, 0F, 0F, 16, 1, 16);
		base.setRotationPoint(-8F, 23F, -8F);
		base.setTextureSize(64, 128);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		bodyPart1 = new ModelRenderer(this, 0, 60);
		bodyPart1.addBox(0F, 0F, 0F, 10, 19, 10);
		bodyPart1.setRotationPoint(-5F, -4F, -5F);
		bodyPart1.setTextureSize(64, 128);
		bodyPart1.mirror = true;
		setRotation(bodyPart1, 0F, 0F, 0F);
		controlRod1 = new ModelRenderer(this, 32, 0);
		controlRod1.addBox(0F, 0F, 0F, 2, 37, 2);
		controlRod1.setRotationPoint(6F, -14F, -8F);
		controlRod1.setTextureSize(64, 128);
		controlRod1.mirror = true;
		setRotation(controlRod1, 0F, 0F, 0F);
		controlRod2 = new ModelRenderer(this, 40, 0);
		controlRod2.addBox(0F, 0F, 0F, 2, 37, 2);
		controlRod2.setRotationPoint(-8F, -14F, -8F);
		controlRod2.setTextureSize(64, 128);
		controlRod2.mirror = true;
		setRotation(controlRod2, 0F, 0F, 0F);
		controlRod3 = new ModelRenderer(this, 48, 0);
		controlRod3.addBox(0F, 0F, 0F, 2, 37, 2);
		controlRod3.setRotationPoint(6F, -14F, 6F);
		controlRod3.setTextureSize(64, 128);
		controlRod3.mirror = true;
		setRotation(controlRod3, 0F, 0F, 0F);
		controlRod4 = new ModelRenderer(this, 56, 0);
		controlRod4.addBox(0F, 0F, 0F, 2, 37, 2);
		controlRod4.setRotationPoint(-8F, -14F, 6F);
		controlRod4.setTextureSize(64, 128);
		controlRod4.mirror = true;
		setRotation(controlRod4, 0F, 0F, 0F);
		bodyRod1 = new ModelRenderer(this, 0, 89);
		bodyRod1.addBox(0F, 0F, 0F, 2, 32, 2);
		bodyRod1.setRotationPoint(-1F, -44F, -1F);
		bodyRod1.setTextureSize(64, 128);
		bodyRod1.mirror = true;
		setRotation(bodyRod1, 0F, 0F, 0F);
		windVaneRod1 = new ModelRenderer(this, 32, 39);
		windVaneRod1.addBox(1F, 0F, 0F, 1, 1, 1);
		windVaneRod1.setRotationPoint(0F, -44F, 0F);
		windVaneRod1.setTextureSize(64, 128);
		windVaneRod1.mirror = true;
		setRotation(windVaneRod1, 0F, 0F, 0F);
		windVane1 = new ModelRenderer(this, 36, 39);
		windVane1.addBox(2F, -1F, 0F, 3, 3, 1);
		windVane1.setRotationPoint(0F, -44F, 0F);
		windVane1.setTextureSize(64, 128);
		windVane1.mirror = true;
		setRotation(windVane1, 0F, 0F, 0F);
		windVaneRod2 = new ModelRenderer(this, 32, 41);
		windVaneRod2.addBox(-2F, 0F, -1F, 1, 1, 1);
		windVaneRod2.setRotationPoint(0F, -44F, 0F);
		windVaneRod2.setTextureSize(64, 128);
		windVaneRod2.mirror = true;
		setRotation(windVaneRod2, 0F, 0F, 0F);
		windVane2 = new ModelRenderer(this, 44, 39);
		windVane2.addBox(-5F, -1F, -1F, 3, 3, 1);
		windVane2.setRotationPoint(0F, -44F, 0F);
		windVane2.setTextureSize(64, 128);
		windVane2.mirror = true;
		setRotation(windVane2, 0F, 0F, 0F);
		bodyRodHolder1 = new ModelRenderer(this, 8, 89);
		bodyRodHolder1.addBox(1F, 0F, 1F, 2, 2, 2);
		bodyRodHolder1.setRotationPoint(-7F, -3F, -7F);
		bodyRodHolder1.setTextureSize(64, 128);
		bodyRodHolder1.mirror = true;
		setRotation(bodyRodHolder1, 0F, 0F, 0F);
		bodyRodHolder2 = new ModelRenderer(this, 8, 93);
		bodyRodHolder2.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder2.setRotationPoint(4F, -3F, -6F);
		bodyRodHolder2.setTextureSize(64, 128);
		bodyRodHolder2.mirror = true;
		setRotation(bodyRodHolder2, 0F, 0F, 0F);
		bodyRodHolder3 = new ModelRenderer(this, 8, 97);
		bodyRodHolder3.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder3.setRotationPoint(4F, -3F, 4F);
		bodyRodHolder3.setTextureSize(64, 128);
		bodyRodHolder3.mirror = true;
		setRotation(bodyRodHolder3, 0F, 0F, 0F);
		bodyRodHolder4 = new ModelRenderer(this, 8, 101);
		bodyRodHolder4.addBox(0F, 0F, 0F, 2, 2, 2);
		bodyRodHolder4.setRotationPoint(-6F, -3F, 4F);
		bodyRodHolder4.setTextureSize(64, 128);
		bodyRodHolder4.mirror = true;
		setRotation(bodyRodHolder4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles();
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
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles() {
	}

}