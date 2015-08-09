package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGNK extends ModelBase
{
	// fields
	ModelRenderer FootL;
	ModelRenderer TopBody;
	ModelRenderer Middle;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer TopBodyLower;
	ModelRenderer BottomBodyLower;
	ModelRenderer GNKPowerAss;
	ModelRenderer FootR;
	float animScale = 0.1F;

	public ModelGNK()
	{
		textureWidth = 64;
		textureHeight = 128;

		FootL = new ModelRenderer(this, 0, 92);
		FootL.addBox(0F, 0F, 0F, 3, 2, 5);
		FootL.setRotationPoint(0.2F, 22F, -3.5F);
		FootL.setTextureSize(64, 128);
		FootL.mirror = true;
		setRotation(FootL, 0F, 0F, 0F);
		TopBody = new ModelRenderer(this, 0, 62);
		TopBody.addBox(-4F, -8F, -4F, 9, 5, 9);
		TopBody.setRotationPoint(-0.5F, 5F, -0.5F);
		TopBody.setTextureSize(64, 128);
		TopBody.mirror = true;
		setRotation(TopBody, 0F, 0F, 0F);
		Middle = new ModelRenderer(this, 0, 46);
		Middle.addBox(-4F, 0F, -2F, 14, 2, 14);
		Middle.setRotationPoint(-3F, 6F, -5F);
		Middle.setTextureSize(64, 128);
		Middle.mirror = true;
		setRotation(Middle, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 76);
		rightleg.addBox(-2F, 0F, -2F, 3, 5, 3);
		rightleg.setRotationPoint(-1.2F, 17F, 0.5F);
		rightleg.setTextureSize(64, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 84);
		leftleg.addBox(-2F, 0F, -2F, 3, 5, 3);
		leftleg.setRotationPoint(2.2F, 17F, 0.5F);
		leftleg.setTextureSize(64, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		TopBodyLower = new ModelRenderer(this, 0, 30);
		TopBodyLower.addBox(0F, 0F, 0F, 12, 4, 12);
		TopBodyLower.setRotationPoint(-6F, 2F, -6F);
		TopBodyLower.setTextureSize(64, 128);
		TopBodyLower.mirror = true;
		setRotation(TopBodyLower, 0F, 0F, 0F);
		BottomBodyLower = new ModelRenderer(this, 0, 14);
		BottomBodyLower.addBox(0F, 0F, 0F, 12, 4, 12);
		BottomBodyLower.setRotationPoint(-6F, 8F, -6F);
		BottomBodyLower.setTextureSize(64, 128);
		BottomBodyLower.mirror = true;
		setRotation(BottomBodyLower, 0F, 0F, 0F);
		GNKPowerAss = new ModelRenderer(this, 0, 0);
		GNKPowerAss.addBox(0F, 0F, 0F, 9, 5, 9);
		GNKPowerAss.setRotationPoint(-4.5F, 12F, -4.5F);
		GNKPowerAss.setTextureSize(64, 128);
		GNKPowerAss.mirror = true;
		setRotation(GNKPowerAss, 0F, 0F, 0F);
		FootR = new ModelRenderer(this, 0, 99);
		FootR.addBox(0F, 0F, 0F, 3, 2, 5);
		FootR.setRotationPoint(-3.2F, 22F, -3.5F);
		FootR.setTextureSize(64, 128);
		FootR.mirror = true;
		setRotation(FootR, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		FootL.render(f5);
		TopBody.render(f5);
		Middle.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		TopBodyLower.render(f5);
		BottomBodyLower.render(f5);
		GNKPowerAss.render(f5);
		FootR.render(f5);
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

		rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1;
		leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;
	}

}
