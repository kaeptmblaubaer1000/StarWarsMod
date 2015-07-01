package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroidAstromech extends ModelBase
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer FootR;
	ModelRenderer FootL;
	ModelRenderer LegM;
	ModelRenderer FootM;

	public ModelDroidAstromech()
	{
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 7F, 1F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, -0.1570796F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-4F, 0F, -2F, 8, 14, 8);
		body.setRotationPoint(0F, 7F, -1F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, -0.1570796F, 0F, 0F);
		rightarm = new ModelRenderer(this, 0, 38);
		rightarm.addBox(-3F, -2F, -2F, 2, 16, 4);
		rightarm.setRotationPoint(-3F, 9F, 0.5F);
		rightarm.setTextureSize(64, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 32, 0);
		leftarm.addBox(-1F, -2F, -2F, 2, 16, 4);
		leftarm.setRotationPoint(5F, 9F, 0.5F);
		leftarm.setTextureSize(64, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		FootR = new ModelRenderer(this, 12, 38);
		FootR.addBox(0F, 0F, 0F, 4, 1, 6);
		FootR.setRotationPoint(-7F, 23F, -2.5F);
		FootR.setTextureSize(64, 64);
		FootR.mirror = true;
		setRotation(FootR, 0F, 0F, 0F);
		FootL = new ModelRenderer(this, 12, 52);
		FootL.addBox(0F, 0F, 0F, 4, 1, 6);
		FootL.setRotationPoint(3F, 23F, -2.5F);
		FootL.setTextureSize(64, 64);
		FootL.mirror = true;
		setRotation(FootL, 0F, 0F, 0F);
		LegM = new ModelRenderer(this, 32, 20);
		LegM.addBox(0F, 0F, 0F, 2, 8, 2);
		LegM.setRotationPoint(-1F, 17F, -1F);
		LegM.setTextureSize(64, 64);
		LegM.mirror = true;
		setRotation(LegM, -0.8726646F, 0F, 0F);
		FootM = new ModelRenderer(this, 12, 45);
		FootM.addBox(0F, 0F, 0F, 4, 1, 6);
		FootM.setRotationPoint(-2F, 23F, -9F);
		FootM.setTextureSize(64, 64);
		FootM.mirror = true;
		setRotation(FootM, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		FootR.render(f5);
		FootL.render(f5);
		FootM.render(f5);
		LegM.render(f5);
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
	}

}