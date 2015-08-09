package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDewback extends ModelBase
{
	// fields
	ModelRenderer Tail1;
	ModelRenderer FootFrontL;
	ModelRenderer FootFrontR;
	ModelRenderer FootBackL;
	ModelRenderer FootBackR;
	ModelRenderer UpperLegFrontL;
	ModelRenderer UpperLegBackL;
	ModelRenderer UpperLegBackR;
	ModelRenderer UpperLegFrontR;
	ModelRenderer Head;
	ModelRenderer Tail2;
	ModelRenderer Tail3;
	ModelRenderer Tail4;
	ModelRenderer Tail5;
	ModelRenderer Tail6;
	ModelRenderer Tail7;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	float animScale = 0.8F;

	public ModelDewback()
	{
		textureWidth = 128;
		textureHeight = 128;

		Tail1 = new ModelRenderer(this, 0, 0);
		Tail1.addBox(0F, 0F, 0F, 7, 7, 2);
		Tail1.setRotationPoint(-3.5F, 10.5F, 13F);
		Tail1.setTextureSize(64, 32);
		Tail1.mirror = true;
		setRotation(Tail1, -0.1396263F, 0F, 0F);
		FootFrontL = new ModelRenderer(this, 0, 10);
		FootFrontL.addBox(-1.5F, 10F, -2F, 2, 1, 3);
		FootFrontL.setRotationPoint(4F, 13F, -4.5F);
		FootFrontL.setTextureSize(64, 32);
		FootFrontL.mirror = true;
		setRotation(FootFrontL, 0F, 0F, 0F);
		FootFrontR = new ModelRenderer(this, 0, 25);
		FootFrontR.addBox(0F, 10F, -2F, 2, 1, 3);
		FootFrontR.setRotationPoint(-4.5F, 13F, -4.5F);
		FootFrontR.setTextureSize(64, 32);
		FootFrontR.mirror = true;
		setRotation(FootFrontR, 0F, 0F, 0F);
		FootBackL = new ModelRenderer(this, 0, 30);
		FootBackL.addBox(-2F, 10F, -2F, 2, 1, 3);
		FootBackL.setRotationPoint(4.5F, 13F, 10.5F);
		FootBackL.setTextureSize(64, 32);
		FootBackL.mirror = true;
		setRotation(FootBackL, 0F, 0F, 0F);
		FootBackR = new ModelRenderer(this, 0, 35);
		FootBackR.addBox(0F, 10F, -2F, 2, 1, 3);
		FootBackR.setRotationPoint(-4.5F, 13F, 10.5F);
		FootBackR.setTextureSize(64, 32);
		FootBackR.mirror = true;
		setRotation(FootBackR, 0F, 0F, 0F);
		UpperLegFrontL = new ModelRenderer(this, 0, 40);
		UpperLegFrontL.addBox(-1.5F, 0F, -1.5F, 2, 6, 3);
		UpperLegFrontL.setRotationPoint(4F, 13F, -4.5F);
		UpperLegFrontL.setTextureSize(64, 32);
		UpperLegFrontL.mirror = true;
		setRotation(UpperLegFrontL, 0F, 0F, 0F);
		UpperLegBackL = new ModelRenderer(this, 0, 50);
		UpperLegBackL.addBox(-2F, 0F, -1.5F, 2, 6, 3);
		UpperLegBackL.setRotationPoint(4.5F, 13F, 10.5F);
		UpperLegBackL.setTextureSize(64, 32);
		UpperLegBackL.mirror = true;
		setRotation(UpperLegBackL, 0F, 0F, 0F);
		UpperLegBackR = new ModelRenderer(this, 0, 60);
		UpperLegBackR.addBox(0F, 0F, -1.5F, 2, 6, 3);
		UpperLegBackR.setRotationPoint(-4.5F, 13F, 10.5F);
		UpperLegBackR.setTextureSize(64, 32);
		UpperLegBackR.mirror = true;
		setRotation(UpperLegBackR, 0F, 0F, 0F);
		UpperLegFrontR = new ModelRenderer(this, 0, 70);
		UpperLegFrontR.addBox(0F, 0F, -1.5F, 2, 6, 3);
		UpperLegFrontR.setRotationPoint(-4.5F, 13F, -4.5F);
		UpperLegFrontR.setTextureSize(64, 32);
		UpperLegFrontR.mirror = true;
		setRotation(UpperLegFrontR, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 12, 56);
		Head.addBox(-3.5F, -3.5F, -8F, 7, 7, 8);
		Head.setRotationPoint(0F, 14F, -7F);
		Head.setTextureSize(64, 32);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		Tail2 = new ModelRenderer(this, 0, 90);
		Tail2.addBox(0F, 0F, 0F, 6, 6, 2);
		Tail2.setRotationPoint(-3F, 11F, 15F);
		Tail2.setTextureSize(64, 32);
		Tail2.mirror = true;
		setRotation(Tail2, -0.2094395F, 0F, 0F);
		Tail3 = new ModelRenderer(this, 12, 29);
		Tail3.addBox(0F, 0F, 0F, 5, 5, 2);
		Tail3.setRotationPoint(-2.5F, 12F, 17F);
		Tail3.setTextureSize(64, 32);
		Tail3.mirror = true;
		setRotation(Tail3, -0.2792527F, 0F, 0F);
		Tail4 = new ModelRenderer(this, 12, 37);
		Tail4.addBox(0F, 0F, 0F, 4, 4, 2);
		Tail4.setRotationPoint(-2F, 13F, 19F);
		Tail4.setTextureSize(64, 32);
		Tail4.mirror = true;
		setRotation(Tail4, -0.4014257F, 0F, 0F);
		Tail5 = new ModelRenderer(this, 13, 44);
		Tail5.addBox(0F, 0F, 0F, 3, 3, 2);
		Tail5.setRotationPoint(-1.5F, 14.5F, 20.8F);
		Tail5.setTextureSize(64, 32);
		Tail5.mirror = true;
		setRotation(Tail5, -0.5235988F, 0F, 0F);
		Tail6 = new ModelRenderer(this, 13, 50);
		Tail6.addBox(0F, 0F, 0F, 2, 2, 2);
		Tail6.setRotationPoint(-1F, 16F, 21.8F);
		Tail6.setTextureSize(64, 32);
		Tail6.mirror = true;
		setRotation(Tail6, -0.1570796F, 0F, 0F);
		Tail7 = new ModelRenderer(this, 13, 25);
		Tail7.addBox(0F, 0F, 0F, 1, 1, 1);
		Tail7.setRotationPoint(-0.5F, 17F, 23.5F);
		Tail7.setTextureSize(64, 32);
		Tail7.mirror = true;
		setRotation(Tail7, 0.296706F, 0F, 0F);
		body = new ModelRenderer(this, 20, 0);
		body.addBox(-4F, -10F, -7F, 8, 20, 8);
		body.setRotationPoint(0F, 11F, 3F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 1.570796F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 108);
		leg1.addBox(0F, 4F, -1F, 1, 6, 2);
		leg1.setRotationPoint(-4F, 13F, 10.5F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 117);
		leg2.addBox(-1F, 4F, -1F, 1, 6, 2);
		leg2.setRotationPoint(4F, 13F, 10.5F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 8, 16);
		leg3.addBox(0F, 4F, -1F, 1, 6, 2);
		leg3.setRotationPoint(-4F, 13F, -4.5F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-1F, 4F, -1.5F, 1, 6, 2);
		leg4.setRotationPoint(4F, 13F, -4F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Tail1.render(f5);
		FootFrontL.render(f5);
		FootFrontR.render(f5);
		FootBackL.render(f5);
		FootBackR.render(f5);
		UpperLegFrontL.render(f5);
		UpperLegBackL.render(f5);
		UpperLegBackR.render(f5);
		UpperLegFrontR.render(f5);
		Head.render(f5);
		Tail2.render(f5);
		Tail3.render(f5);
		Tail4.render(f5);
		Tail5.render(f5);
		Tail6.render(f5);
		Tail7.render(f5);
		body.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
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
		Head.rotateAngleY = f3 / (180F / (float)Math.PI) * 0.4F;
		Head.rotateAngleX = f4 / (180F / (float)Math.PI) * 0.4F;

		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		leg1.rotateAngleZ = 0.0F;
		leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		leg2.rotateAngleZ = 0.0F;
		leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		leg3.rotateAngleZ = 0.0F;
		leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		leg4.rotateAngleZ = 0.0F;
		UpperLegBackR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		UpperLegBackR.rotateAngleZ = 0.0F;
		UpperLegBackL.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		UpperLegBackL.rotateAngleZ = 0.0F;
		UpperLegFrontR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		UpperLegFrontR.rotateAngleZ = 0.0F;
		UpperLegFrontL.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		UpperLegFrontL.rotateAngleZ = 0.0F;
		FootBackR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		FootBackR.rotateAngleZ = 0.0F;
		FootBackL.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		FootBackL.rotateAngleZ = 0.0F;
		FootFrontR.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * animScale * f1 * 0.5F;
		FootFrontR.rotateAngleZ = 0.0F;
		FootFrontL.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		FootFrontL.rotateAngleZ = 0.0F;
	}

}
