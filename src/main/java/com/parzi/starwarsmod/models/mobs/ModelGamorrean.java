package com.parzi.starwarsmod.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGamorrean extends ModelBase
{
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
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		this.head.setRotationPoint(0.0F, 0.0F, 1.5F);
		this.head.setTextureSize(128, 64);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 12, 14, 7);
		this.body.setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.body.setTextureSize(128, 64);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 0, 37);
		this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 5);
		this.rightarm.setRotationPoint(-7.0F, 2.0F, 1.0F);
		this.rightarm.setTextureSize(128, 64);
		this.rightarm.mirror = true;
		this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 18, 37);
		this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 5);
		this.leftarm.setRotationPoint(7.0F, 2.0F, 1.0F);
		this.leftarm.setTextureSize(128, 64);
		this.leftarm.mirror = true;
		this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 32, 0);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 5, 10, 5);
		this.rightleg.setRotationPoint(-4.0F, 14.0F, 1.0F);
		this.rightleg.setTextureSize(128, 64);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 38, 15);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 5, 10, 5);
		this.leftleg.setRotationPoint(3.0F, 14.0F, 1.0F);
		this.leftleg.setTextureSize(128, 64);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
		this.Snout = new ModelRenderer(this, 0, 54);
		this.Snout.addBox(-2.0F, -4.0F, -6.0F, 4, 3, 2);
		this.Snout.setRotationPoint(0.0F, 0.0F, 1.5F);
		this.Snout.setTextureSize(64, 32);
		this.Snout.mirror = true;
		this.setRotation(this.Snout, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.head.render(f5);
		this.body.render(f5);
		this.rightarm.render(f5);
		this.leftarm.render(f5);
		this.rightleg.render(f5);
		this.leftleg.render(f5);
		this.Snout.render(f5);
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
		this.Snout.rotateAngleY = f3 / 57.295776F;
		this.Snout.rotateAngleX = f4 / 57.295776F;
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
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\mobs\ModelGamorrean.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */