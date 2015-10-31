package com.parzi.starwarsmod.rendering.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWampa extends ModelBase
{
	ModelRenderer HornL1;
	ModelRenderer HornL3;
	ModelRenderer HornL2;
	ModelRenderer HornL4;
	ModelRenderer HornR1;
	ModelRenderer HornR2;
	ModelRenderer HornR3;
	ModelRenderer HornR4;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	private float animScale = 1.0F;

	public ModelWampa()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.HornR1 = new ModelRenderer(this, 0, 95);
		this.HornR1.addBox(4.0F, -3.5F, -2.5F, 2, 2, 6);
		this.HornR1.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornR1.setTextureSize(64, 32);
		this.HornR1.mirror = true;
		this.setRotation(this.HornR1, 0.0F, 0.0F, 0.0F);
		this.HornR3 = new ModelRenderer(this, 0, 104);
		this.HornR3.addBox(5.0F, -3.5F, -3.0F, 2, 2, 2);
		this.HornR3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornR3.setTextureSize(64, 32);
		this.HornR3.mirror = true;
		this.setRotation(this.HornR3, 0.0F, 0.3141593F, 0.0F);
		this.HornR2 = new ModelRenderer(this, 0, 109);
		this.HornR2.addBox(4.5F, -3.5F, -2.0F, 2, 2, 2);
		this.HornR2.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornR2.setTextureSize(64, 32);
		this.HornR2.mirror = true;
		this.setRotation(this.HornR2, 0.0F, 0.1570796F, 0.0F);
		this.HornR4 = new ModelRenderer(this, 0, 114);
		this.HornR4.addBox(5.5F, -3.5F, -4.0F, 2, 2, 2);
		this.HornR4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornR4.setTextureSize(64, 32);
		this.HornR4.mirror = true;
		this.setRotation(this.HornR4, 0.0F, 0.4712389F, 0.0F);
		this.HornL1 = new ModelRenderer(this, 0, 119);
		this.HornL1.addBox(-6.0F, -3.5F, -2.5F, 2, 2, 6);
		this.HornL1.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornL1.setTextureSize(64, 32);
		this.HornL1.mirror = true;
		this.setRotation(this.HornL1, 0.0F, 0.0F, 0.0F);
		this.HornL2 = new ModelRenderer(this, 9, 104);
		this.HornL2.addBox(-6.5F, -3.5F, -2.0F, 2, 2, 2);
		this.HornL2.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornL2.setTextureSize(64, 32);
		this.HornL2.mirror = true;
		this.setRotation(this.HornL2, 0.0F, -0.1570796F, 0.0F);
		this.HornL3 = new ModelRenderer(this, 9, 109);
		this.HornL3.addBox(-7.0F, -3.5F, -3.0F, 2, 2, 2);
		this.HornL3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornL3.setTextureSize(64, 32);
		this.HornL3.mirror = true;
		this.setRotation(this.HornL3, 0.0F, -0.3141593F, 0.0F);
		this.HornL4 = new ModelRenderer(this, 9, 114);
		this.HornL4.addBox(-7.5F, -3.5F, -4.0F, 2, 2, 2);
		this.HornL4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.HornL4.setTextureSize(64, 32);
		this.HornL4.mirror = true;
		this.setRotation(this.HornL4, 0.0F, -0.4712389F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -6.0F, -4.0F, 8, 6, 8);
		this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 11, 16, 6);
		this.body.setRotationPoint(-1.5F, -4.0F, -1.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 0, 39);
		this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 15, 4);
		this.rightarm.setRotationPoint(-6.5F, -2.0F, 0.0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 17, 39);
		this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 15, 4);
		this.leftarm.setRotationPoint(6.5F, -2.0F, 0.0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 0, 59);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 5, 12, 5);
		this.rightleg.setRotationPoint(-3.5F, 12.0F, -0.5F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 0, 77);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 5, 12, 5);
		this.leftleg.setRotationPoint(2.5F, 12.0F, -0.5F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.HornL1.render(f5);
		this.HornL3.render(f5);
		this.HornL2.render(f5);
		this.HornL4.render(f5);
		this.HornR1.render(f5);
		this.HornR2.render(f5);
		this.HornR3.render(f5);
		this.HornR4.render(f5);
		this.head.render(f5);
		this.body.render(f5);
		this.rightarm.render(f5);
		this.leftarm.render(f5);
		this.rightleg.render(f5);
		this.leftleg.render(f5);
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
		this.head.rotateAngleY = f3 / 57.295776F;
		this.head.rotateAngleX = f4 / 57.295776F;
		this.HornL1.rotateAngleY = f3 / 57.295776F;
		this.HornL1.rotateAngleX = f4 / 57.295776F;
		this.HornL2.rotateAngleY = f3 / 57.295776F;
		this.HornL2.rotateAngleX = f4 / 57.295776F;
		this.HornL3.rotateAngleY = f3 / 57.295776F;
		this.HornL3.rotateAngleX = f4 / 57.295776F;
		this.HornL4.rotateAngleY = f3 / 57.295776F;
		this.HornL4.rotateAngleX = f4 / 57.295776F;
		this.HornR1.rotateAngleY = f3 / 57.295776F;
		this.HornR1.rotateAngleX = f4 / 57.295776F;
		this.HornR2.rotateAngleY = f3 / 57.295776F;
		this.HornR2.rotateAngleX = f4 / 57.295776F;
		this.HornR3.rotateAngleY = f3 / 57.295776F;
		this.HornR3.rotateAngleX = f4 / 57.295776F;
		this.HornR4.rotateAngleY = f3 / 57.295776F;
		this.HornR4.rotateAngleX = f4 / 57.295776F;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1 * 0.5F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.rightleg.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\models\mobs\ModelWampa.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */