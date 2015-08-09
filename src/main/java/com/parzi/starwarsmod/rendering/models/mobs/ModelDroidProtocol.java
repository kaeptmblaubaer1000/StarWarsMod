package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDroidProtocol extends ModelBase
{
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer LeftArm1;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer LeftArm2;
	ModelRenderer RightArm1;
	ModelRenderer RightArm2;
	float animScale = 0.6F;

	public ModelDroidProtocol()
	{
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -7F, -3F, 6, 7, 6);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 14);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		LeftArm1 = new ModelRenderer(this, 0, 31);
		LeftArm1.addBox(-1F, -1F, -2F, 3, 6, 4);
		LeftArm1.setRotationPoint(5F, 2F, 0F);
		LeftArm1.setTextureSize(64, 32);
		LeftArm1.mirror = true;
		setRotation(LeftArm1, -0.2094395F, 0F, -0.6283185F);
		rightleg = new ModelRenderer(this, 0, 42);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 59);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		LeftArm2 = new ModelRenderer(this, 0, 76);
		LeftArm2.addBox(2F, 1.5F, -2F, 3, 9, 4);
		LeftArm2.setRotationPoint(5F, 2F, 0F);
		LeftArm2.setTextureSize(64, 32);
		LeftArm2.mirror = true;
		setRotation(LeftArm2, -0.2094395F, 0F, 0.3141593F);
		RightArm1 = new ModelRenderer(this, 0, 90);
		RightArm1.addBox(-2F, -1F, -2F, 3, 6, 4);
		RightArm1.setRotationPoint(-5F, 2F, 0F);
		RightArm1.setTextureSize(64, 32);
		RightArm1.mirror = true;
		setRotation(RightArm1, -0.2094395F, 0F, 0.6283185F);
		RightArm2 = new ModelRenderer(this, 0, 101);
		RightArm2.addBox(-5F, 1.4F, -2F, 3, 9, 4);
		RightArm2.setRotationPoint(-5F, 2F, 0F);
		RightArm2.setTextureSize(64, 32);
		RightArm2.mirror = true;
		setRotation(RightArm2, -0.2094395F, 0F, -0.3141593F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		body.render(f5);
		LeftArm1.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		LeftArm2.render(f5);
		RightArm1.render(f5);
		RightArm2.render(f5);
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

		RightArm1.rotateAngleX = MathHelper.cos(f + 94 * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F - 0.2094395F;
		LeftArm1.rotateAngleX = MathHelper.cos(f + 94 * 0.6662F) * animScale * f1 * 0.5F - 0.2094395F;

		RightArm2.rotateAngleX = MathHelper.cos(f + 94 * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F - 0.2094395F;
		LeftArm2.rotateAngleX = MathHelper.cos(f + 94 * 0.6662F) * animScale * f1 * 0.5F - 0.2094395F;

		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1;
	}

}