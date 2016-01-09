package com.parzi.starwarsmod.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDroidProtocol extends ModelBase
{
	ModelRenderer BackThing;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer LeftArm1;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer LeftArm2;
	ModelRenderer RightArm1;
	ModelRenderer RightArm2;
	float animScale = 0.5F;

	public ModelDroidProtocol()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.BackThing = new ModelRenderer(this, 0, 115);
		this.BackThing.addBox(0.0F, 0.0F, 0.0F, 6, 4, 1);
		this.BackThing.setRotationPoint(-3.0F, 2.5F, 2.0F);
		this.BackThing.setTextureSize(64, 32);
		this.BackThing.mirror = true;
		this.setRotation(this.BackThing, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -7.0F, -3.0F, 6, 7, 6);
		this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 14);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
		this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
		this.LeftArm1 = new ModelRenderer(this, 0, 31);
		this.LeftArm1.addBox(-1.0F, -1.0F, -2.0F, 3, 6, 4);
		this.LeftArm1.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.LeftArm1.setTextureSize(64, 32);
		this.LeftArm1.mirror = true;
		this.setRotation(this.LeftArm1, -0.2094395F, 0.0F, -0.6283185F);
		this.rightleg = new ModelRenderer(this, 0, 42);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
		this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 0, 59);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
		this.LeftArm2 = new ModelRenderer(this, 0, 76);
		this.LeftArm2.addBox(2.0F, 1.5F, -2.0F, 3, 9, 4);
		this.LeftArm2.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.LeftArm2.setTextureSize(64, 32);
		this.LeftArm2.mirror = true;
		this.setRotation(this.LeftArm2, -0.2094395F, 0.0F, 0.3141593F);
		this.RightArm1 = new ModelRenderer(this, 0, 90);
		this.RightArm1.addBox(-2.0F, -1.0F, -2.0F, 3, 6, 4);
		this.RightArm1.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.RightArm1.setTextureSize(64, 32);
		this.RightArm1.mirror = true;
		this.setRotation(this.RightArm1, -0.2094395F, 0.0F, 0.6283185F);
		this.RightArm2 = new ModelRenderer(this, 0, 101);
		this.RightArm2.addBox(-5.0F, 1.4F, -2.0F, 3, 9, 4);
		this.RightArm2.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.RightArm2.setTextureSize(64, 32);
		this.RightArm2.mirror = true;
		this.setRotation(this.RightArm2, -0.2094395F, 0.0F, -0.3141593F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BackThing.render(f5);
		this.head.render(f5);
		this.body.render(f5);
		this.LeftArm1.render(f5);
		this.rightleg.render(f5);
		this.leftleg.render(f5);
		this.LeftArm2.render(f5);
		this.RightArm1.render(f5);
		this.RightArm2.render(f5);
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
		this.RightArm1.rotateAngleX = MathHelper.cos(f + 62.6228F + 3.1415927F) * this.animScale * f1 * 0.5F - 0.2094395F;
		this.LeftArm1.rotateAngleX = MathHelper.cos(f + 62.6228F) * this.animScale * f1 * 0.5F - 0.2094395F;
		this.RightArm2.rotateAngleX = MathHelper.cos(f + 62.6228F + 3.1415927F) * this.animScale * f1 * 0.5F - 0.2094395F;
		this.LeftArm2.rotateAngleX = MathHelper.cos(f + 62.6228F) * this.animScale * f1 * 0.5F - 0.2094395F;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\mobs\ModelDroidProtocol.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */