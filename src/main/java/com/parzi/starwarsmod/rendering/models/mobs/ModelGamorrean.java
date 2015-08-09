package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGamorrean extends ModelBase
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer Snout;
	float animScale = 0.8F;

	public ModelGamorrean()
	{
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 1.5F);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-4F, 0F, -2F, 12, 14, 7);
		body.setRotationPoint(-2F, 0F, 0F);
		body.setTextureSize(128, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 0, 37);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 5);
		rightarm.setRotationPoint(-7F, 2F, 1F);
		rightarm.setTextureSize(128, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 18, 37);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 5);
		leftarm.setRotationPoint(7F, 2F, 1F);
		leftarm.setTextureSize(128, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 32, 0);
		rightleg.addBox(-2F, 0F, -2F, 5, 10, 5);
		rightleg.setRotationPoint(-4F, 14F, 1F);
		rightleg.setTextureSize(128, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 38, 15);
		leftleg.addBox(-2F, 0F, -2F, 5, 10, 5);
		leftleg.setRotationPoint(3F, 14F, 1F);
		leftleg.setTextureSize(128, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		Snout = new ModelRenderer(this, 0, 54);
		Snout.addBox(-2F, -4F, -6F, 4, 3, 2);
		Snout.setRotationPoint(0F, 0F, 1.5F);
		Snout.setTextureSize(64, 32);
		Snout.mirror = true;
		setRotation(Snout, 0F, 0F, 0F);
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
		rightleg.render(f5);
		leftleg.render(f5);
		Snout.render(f5);
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
		head.rotateAngleY = f3 / (180F / (float)Math.PI);
		head.rotateAngleX = f4 / (180F / (float)Math.PI);
		Snout.rotateAngleY = f3 / (180F / (float)Math.PI);
		Snout.rotateAngleX = f4 / (180F / (float)Math.PI);

		rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;
	}
}
