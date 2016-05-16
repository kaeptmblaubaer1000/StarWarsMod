package com.parzivail.pswm.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWookiee extends ModelBase
{
	private static float animScale = 1.0F;
	ModelRenderer BandolierBaseF;
	ModelRenderer BandolierF1;
	ModelRenderer BandolierF2;
	ModelRenderer BandolierF3;
	ModelRenderer BandolierF4;
	ModelRenderer BandolierBaseB;
	ModelRenderer BandolierB1;
	ModelRenderer BandolierB2;
	ModelRenderer BandolierB3;
	ModelRenderer BandolierB4;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public ModelWookiee()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.BandolierBaseF = new ModelRenderer(this, 0, 61);
		this.BandolierBaseF.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.BandolierBaseF.setRotationPoint(-5.0F, 6.2F, -3.7F);
		this.BandolierBaseF.setTextureSize(64, 64);
		this.BandolierBaseF.mirror = true;
		this.setRotation(this.BandolierBaseF, 0.0F, 0.0F, -0.7853982F);
		this.BandolierF1 = new ModelRenderer(this, 42, 38);
		this.BandolierF1.addBox(-0.5F, 1.5F, 0.0F, 2, 2, 1);
		this.BandolierF1.setRotationPoint(4.6F, -3.4F, -4.0F);
		this.BandolierF1.setTextureSize(64, 64);
		this.BandolierF1.mirror = true;
		this.setRotation(this.BandolierF1, 0.0F, 0.0F, 0.7853982F);
		this.BandolierF2 = new ModelRenderer(this, 42, 42);
		this.BandolierF2.addBox(-0.5F, 0.5F, 0.0F, 2, 2, 1);
		this.BandolierF2.setRotationPoint(-0.4F, 1.6F, -4.0F);
		this.BandolierF2.setTextureSize(64, 64);
		this.BandolierF2.mirror = true;
		this.setRotation(this.BandolierF2, 0.0F, 0.0F, 0.7853982F);
		this.BandolierF3 = new ModelRenderer(this, 42, 46);
		this.BandolierF3.addBox(-0.5F, 0.5F, 0.0F, 2, 2, 1);
		this.BandolierF3.setRotationPoint(1.6F, -0.4F, -4.0F);
		this.BandolierF3.setTextureSize(64, 64);
		this.BandolierF3.mirror = true;
		this.setRotation(this.BandolierF3, 0.0F, 0.0F, 0.7853982F);
		this.BandolierF4 = new ModelRenderer(this, 42, 50);
		this.BandolierF4.addBox(-0.5F, 0.5F, 0.0F, 2, 2, 1);
		this.BandolierF4.setRotationPoint(-2.6F, 3.7F, -4.0F);
		this.BandolierF4.setTextureSize(64, 64);
		this.BandolierF4.mirror = true;
		this.setRotation(this.BandolierF4, 0.0F, 0.0F, 0.7853982F);
		this.BandolierBaseB = new ModelRenderer(this, 29, 61);
		this.BandolierBaseB.addBox(0.0F, 0.0F, 0.0F, 13, 1, 1);
		this.BandolierBaseB.setRotationPoint(-5.0F, 6.2F, 2.7F);
		this.BandolierBaseB.setTextureSize(64, 64);
		this.BandolierBaseB.mirror = true;
		this.setRotation(this.BandolierBaseB, 0.0F, 0.0F, -0.7853982F);
		this.BandolierB1 = new ModelRenderer(this, 42, 54);
		this.BandolierB1.addBox(-0.5F, 0.5F, 0.0F, 2, 2, 1);
		this.BandolierB1.setRotationPoint(3.8F, -2.5F, 3.0F);
		this.BandolierB1.setTextureSize(64, 64);
		this.BandolierB1.mirror = true;
		this.setRotation(this.BandolierB1, 0.0F, 0.0F, 0.7853982F);
		this.BandolierB2 = new ModelRenderer(this, 49, 38);
		this.BandolierB2.addBox(1.5F, 1.5F, 0.0F, 2, 2, 1);
		this.BandolierB2.setRotationPoint(-1.1F, -0.5F, 3.0F);
		this.BandolierB2.setTextureSize(64, 64);
		this.BandolierB2.mirror = true;
		this.setRotation(this.BandolierB2, 0.0F, 0.0F, 0.7853982F);
		this.BandolierB3 = new ModelRenderer(this, 49, 42);
		this.BandolierB3.addBox(-1.5F, -1.4F, 0.0F, 2, 2, 1);
		this.BandolierB3.setRotationPoint(1.1F, 1.6F, 3.0F);
		this.BandolierB3.setTextureSize(64, 64);
		this.BandolierB3.mirror = true;
		this.setRotation(this.BandolierB3, 0.0F, 0.0F, 0.7853982F);
		this.BandolierB4 = new ModelRenderer(this, 49, 46);
		this.BandolierB4.addBox(-4.5F, 4.5F, 0.0F, 2, 2, 1);
		this.BandolierB4.setRotationPoint(3.2F, 3.7F, 3.0F);
		this.BandolierB4.setTextureSize(64, 64);
		this.BandolierB4.mirror = true;
		this.setRotation(this.BandolierB4, 0.0F, 0.0F, 0.7853982F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 9, 8);
		this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.head.setTextureSize(64, 64);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 19);
		this.body.addBox(-5.0F, 0.0F, -2.0F, 10, 14, 6);
		this.body.setRotationPoint(0.0F, -3.0F, -1.0F);
		this.body.setTextureSize(64, 64);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 0, 40);
		this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 14, 6);
		this.rightarm.setRotationPoint(-6.0F, -1.0F, -1.0F);
		this.rightarm.setTextureSize(64, 64);
		this.rightarm.mirror = true;
		this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 21, 40);
		this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 14, 6);
		this.leftarm.setRotationPoint(6.0F, -1.0F, -1.0F);
		this.leftarm.setTextureSize(64, 64);
		this.leftarm.mirror = true;
		this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 33, 0);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 5, 13, 5);
		this.rightleg.setRotationPoint(-3.0F, 11.0F, -0.5F);
		this.rightleg.setTextureSize(64, 64);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 33, 19);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 5, 13, 5);
		this.leftleg.setRotationPoint(2.0F, 11.0F, -0.5F);
		this.leftleg.setTextureSize(64, 64);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BandolierBaseF.render(f5);
		this.BandolierF1.render(f5);
		this.BandolierF2.render(f5);
		this.BandolierF3.render(f5);
		this.BandolierF4.render(f5);
		this.BandolierBaseB.render(f5);
		this.BandolierB1.render(f5);
		this.BandolierB2.render(f5);
		this.BandolierB3.render(f5);
		this.BandolierB4.render(f5);
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
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
		this.head.rotateAngleY = f3 / 57.295776F;
		this.head.rotateAngleX = f4 / 57.295776F;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * animScale * f1 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1 * 0.5F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * animScale * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * animScale * f1;
		this.rightleg.rotateAngleY = 0.0F;
		this.leftleg.rotateAngleY = 0.0F;
	}
}
