package com.parzivail.pswm.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDewback extends ModelBase
{
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
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Tail1 = new ModelRenderer(this, 0, 0);
		this.Tail1.addBox(0.0F, 0.0F, 0.0F, 7, 7, 2);
		this.Tail1.setRotationPoint(-3.5F, 10.5F, 13.0F);
		this.Tail1.setTextureSize(64, 32);
		this.Tail1.mirror = true;
		this.setRotation(this.Tail1, -0.1396263F, 0.0F, 0.0F);
		this.FootFrontL = new ModelRenderer(this, 0, 10);
		this.FootFrontL.addBox(-1.5F, 10.0F, -2.0F, 2, 1, 3);
		this.FootFrontL.setRotationPoint(4.0F, 13.0F, -4.5F);
		this.FootFrontL.setTextureSize(64, 32);
		this.FootFrontL.mirror = true;
		this.setRotation(this.FootFrontL, 0.0F, 0.0F, 0.0F);
		this.FootFrontR = new ModelRenderer(this, 0, 25);
		this.FootFrontR.addBox(0.0F, 10.0F, -2.0F, 2, 1, 3);
		this.FootFrontR.setRotationPoint(-4.5F, 13.0F, -4.5F);
		this.FootFrontR.setTextureSize(64, 32);
		this.FootFrontR.mirror = true;
		this.setRotation(this.FootFrontR, 0.0F, 0.0F, 0.0F);
		this.FootBackL = new ModelRenderer(this, 0, 30);
		this.FootBackL.addBox(-2.0F, 10.0F, -2.0F, 2, 1, 3);
		this.FootBackL.setRotationPoint(4.5F, 13.0F, 10.5F);
		this.FootBackL.setTextureSize(64, 32);
		this.FootBackL.mirror = true;
		this.setRotation(this.FootBackL, 0.0F, 0.0F, 0.0F);
		this.FootBackR = new ModelRenderer(this, 0, 35);
		this.FootBackR.addBox(0.0F, 10.0F, -2.0F, 2, 1, 3);
		this.FootBackR.setRotationPoint(-4.5F, 13.0F, 10.5F);
		this.FootBackR.setTextureSize(64, 32);
		this.FootBackR.mirror = true;
		this.setRotation(this.FootBackR, 0.0F, 0.0F, 0.0F);
		this.UpperLegFrontL = new ModelRenderer(this, 0, 40);
		this.UpperLegFrontL.addBox(-1.5F, 0.0F, -1.5F, 2, 6, 3);
		this.UpperLegFrontL.setRotationPoint(4.0F, 13.0F, -4.5F);
		this.UpperLegFrontL.setTextureSize(64, 32);
		this.UpperLegFrontL.mirror = true;
		this.setRotation(this.UpperLegFrontL, 0.0F, 0.0F, 0.0F);
		this.UpperLegBackL = new ModelRenderer(this, 0, 50);
		this.UpperLegBackL.addBox(-2.0F, 0.0F, -1.5F, 2, 6, 3);
		this.UpperLegBackL.setRotationPoint(4.5F, 13.0F, 10.5F);
		this.UpperLegBackL.setTextureSize(64, 32);
		this.UpperLegBackL.mirror = true;
		this.setRotation(this.UpperLegBackL, 0.0F, 0.0F, 0.0F);
		this.UpperLegBackR = new ModelRenderer(this, 0, 60);
		this.UpperLegBackR.addBox(0.0F, 0.0F, -1.5F, 2, 6, 3);
		this.UpperLegBackR.setRotationPoint(-4.5F, 13.0F, 10.5F);
		this.UpperLegBackR.setTextureSize(64, 32);
		this.UpperLegBackR.mirror = true;
		this.setRotation(this.UpperLegBackR, 0.0F, 0.0F, 0.0F);
		this.UpperLegFrontR = new ModelRenderer(this, 0, 70);
		this.UpperLegFrontR.addBox(0.0F, 0.0F, -1.5F, 2, 6, 3);
		this.UpperLegFrontR.setRotationPoint(-4.5F, 13.0F, -4.5F);
		this.UpperLegFrontR.setTextureSize(64, 32);
		this.UpperLegFrontR.mirror = true;
		this.setRotation(this.UpperLegFrontR, 0.0F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 12, 56);
		this.Head.addBox(-3.5F, -3.5F, -8.0F, 7, 7, 8);
		this.Head.setRotationPoint(0.0F, 14.0F, -7.0F);
		this.Head.setTextureSize(64, 32);
		this.Head.mirror = true;
		this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 0, 90);
		this.Tail2.addBox(0.0F, 0.0F, 0.0F, 6, 6, 2);
		this.Tail2.setRotationPoint(-3.0F, 11.0F, 15.0F);
		this.Tail2.setTextureSize(64, 32);
		this.Tail2.mirror = true;
		this.setRotation(this.Tail2, -0.2094395F, 0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 12, 29);
		this.Tail3.addBox(0.0F, 0.0F, 0.0F, 5, 5, 2);
		this.Tail3.setRotationPoint(-2.5F, 12.0F, 17.0F);
		this.Tail3.setTextureSize(64, 32);
		this.Tail3.mirror = true;
		this.setRotation(this.Tail3, -0.2792527F, 0.0F, 0.0F);
		this.Tail4 = new ModelRenderer(this, 12, 37);
		this.Tail4.addBox(0.0F, 0.0F, 0.0F, 4, 4, 2);
		this.Tail4.setRotationPoint(-2.0F, 13.0F, 19.0F);
		this.Tail4.setTextureSize(64, 32);
		this.Tail4.mirror = true;
		this.setRotation(this.Tail4, -0.4014257F, 0.0F, 0.0F);
		this.Tail5 = new ModelRenderer(this, 13, 44);
		this.Tail5.addBox(0.0F, 0.0F, 0.0F, 3, 3, 2);
		this.Tail5.setRotationPoint(-1.5F, 14.5F, 20.8F);
		this.Tail5.setTextureSize(64, 32);
		this.Tail5.mirror = true;
		this.setRotation(this.Tail5, -0.5235988F, 0.0F, 0.0F);
		this.Tail6 = new ModelRenderer(this, 13, 50);
		this.Tail6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.Tail6.setRotationPoint(-1.0F, 16.0F, 21.8F);
		this.Tail6.setTextureSize(64, 32);
		this.Tail6.mirror = true;
		this.setRotation(this.Tail6, -0.1570796F, 0.0F, 0.0F);
		this.Tail7 = new ModelRenderer(this, 13, 25);
		this.Tail7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
		this.Tail7.setRotationPoint(-0.5F, 17.0F, 23.5F);
		this.Tail7.setTextureSize(64, 32);
		this.Tail7.mirror = true;
		this.setRotation(this.Tail7, 0.296706F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 20, 0);
		this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 20, 8);
		this.body.setRotationPoint(0.0F, 11.0F, 3.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 1.570796F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 108);
		this.leg1.addBox(0.0F, 4.0F, -1.0F, 1, 6, 2);
		this.leg1.setRotationPoint(-4.0F, 13.0F, 10.5F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 117);
		this.leg2.addBox(-1.0F, 4.0F, -1.0F, 1, 6, 2);
		this.leg2.setRotationPoint(4.0F, 13.0F, 10.5F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg3 = new ModelRenderer(this, 8, 16);
		this.leg3.addBox(0.0F, 4.0F, -1.0F, 1, 6, 2);
		this.leg3.setRotationPoint(-4.0F, 13.0F, -4.5F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.addBox(-1.0F, 4.0F, -1.5F, 1, 6, 2);
		this.leg4.setRotationPoint(4.0F, 13.0F, -4.0F);
		this.leg4.setTextureSize(64, 32);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Tail1.render(f5);
		this.FootFrontL.render(f5);
		this.FootFrontR.render(f5);
		this.FootBackL.render(f5);
		this.FootBackR.render(f5);
		this.UpperLegFrontL.render(f5);
		this.UpperLegBackL.render(f5);
		this.UpperLegBackR.render(f5);
		this.UpperLegFrontR.render(f5);
		this.Head.render(f5);
		this.Tail2.render(f5);
		this.Tail3.render(f5);
		this.Tail4.render(f5);
		this.Tail5.render(f5);
		this.Tail6.render(f5);
		this.Tail7.render(f5);
		this.body.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
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
		this.Head.rotateAngleY = f3 / 57.295776F * 0.4F;
		this.Head.rotateAngleX = f4 / 57.295776F * 0.4F;
		this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.leg1.rotateAngleZ = 0.0F;
		this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.leg2.rotateAngleZ = 0.0F;
		this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.leg3.rotateAngleZ = 0.0F;
		this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.leg4.rotateAngleZ = 0.0F;
		this.UpperLegBackR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.UpperLegBackR.rotateAngleZ = 0.0F;
		this.UpperLegBackL.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.UpperLegBackL.rotateAngleZ = 0.0F;
		this.UpperLegFrontR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.UpperLegFrontR.rotateAngleZ = 0.0F;
		this.UpperLegFrontL.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.UpperLegFrontL.rotateAngleZ = 0.0F;
		this.FootBackR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.FootBackR.rotateAngleZ = 0.0F;
		this.FootBackL.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.FootBackL.rotateAngleZ = 0.0F;
		this.FootFrontR.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.FootFrontR.rotateAngleZ = 0.0F;
		this.FootFrontL.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.FootFrontL.rotateAngleZ = 0.0F;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\mobs\ModelDewback.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */