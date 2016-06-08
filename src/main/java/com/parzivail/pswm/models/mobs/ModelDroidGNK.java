package com.parzivail.pswm.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDroidGNK extends ModelBase
{
	ModelRenderer FootL;
	ModelRenderer TopBody;
	ModelRenderer Middle;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer TopBodyLower;
	ModelRenderer BottomBodyLower;
	ModelRenderer GNKPowerAss;
	ModelRenderer FootR;
	float animScale = 0.5F;

	public ModelDroidGNK()
	{
		this.textureWidth = 64;
		this.textureHeight = 128;
		this.FootL = new ModelRenderer(this, 0, 92);
		this.FootL.addBox(-1.5F, 5.0F, -3.5F, 3, 2, 5);
		this.FootL.setRotationPoint(1.7F, 17.0F, 0.0F);
		this.FootL.setTextureSize(64, 32);
		this.FootL.mirror = true;
		this.setRotation(this.FootL, 0.0F, 0.0F, 0.0F);
		this.FootR = new ModelRenderer(this, 0, 99);
		this.FootR.addBox(-1.5F, 5.0F, -3.5F, 3, 2, 5);
		this.FootR.setRotationPoint(-1.7F, 17.0F, 0.0F);
		this.FootR.setTextureSize(64, 32);
		this.FootR.mirror = true;
		this.setRotation(this.FootR, 0.0F, 0.0F, 0.0F);
		this.TopBody = new ModelRenderer(this, 0, 62);
		this.TopBody.addBox(-4.0F, -8.0F, -4.0F, 9, 5, 9);
		this.TopBody.setRotationPoint(-0.5F, 5.0F, -0.5F);
		this.TopBody.setTextureSize(64, 32);
		this.TopBody.mirror = true;
		this.setRotation(this.TopBody, 0.0F, 0.0F, 0.0F);
		this.Middle = new ModelRenderer(this, 0, 46);
		this.Middle.addBox(-4.0F, 0.0F, -2.0F, 14, 2, 14);
		this.Middle.setRotationPoint(-3.0F, 6.0F, -5.0F);
		this.Middle.setTextureSize(64, 32);
		this.Middle.mirror = true;
		this.setRotation(this.Middle, 0.0F, 0.0F, 0.0F);
		this.rightleg = new ModelRenderer(this, 0, 76);
		this.rightleg.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
		this.rightleg.setRotationPoint(-1.7F, 17.0F, 0.0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
		this.leftleg = new ModelRenderer(this, 0, 84);
		this.leftleg.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3);
		this.leftleg.setRotationPoint(1.7F, 17.0F, 0.0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
		this.TopBodyLower = new ModelRenderer(this, 0, 30);
		this.TopBodyLower.addBox(0.0F, 0.0F, 0.0F, 12, 4, 12);
		this.TopBodyLower.setRotationPoint(-6.0F, 2.0F, -6.0F);
		this.TopBodyLower.setTextureSize(64, 32);
		this.TopBodyLower.mirror = true;
		this.setRotation(this.TopBodyLower, 0.0F, 0.0F, 0.0F);
		this.BottomBodyLower = new ModelRenderer(this, 0, 14);
		this.BottomBodyLower.addBox(0.0F, 0.0F, 0.0F, 12, 4, 12);
		this.BottomBodyLower.setRotationPoint(-6.0F, 8.0F, -6.0F);
		this.BottomBodyLower.setTextureSize(64, 32);
		this.BottomBodyLower.mirror = true;
		this.setRotation(this.BottomBodyLower, 0.0F, 0.0F, 0.0F);
		this.GNKPowerAss = new ModelRenderer(this, 0, 0);
		this.GNKPowerAss.addBox(0.0F, 0.0F, 0.0F, 9, 5, 9);
		this.GNKPowerAss.setRotationPoint(-4.5F, 12.0F, -4.5F);
		this.GNKPowerAss.setTextureSize(64, 32);
		this.GNKPowerAss.mirror = true;
		this.setRotation(this.GNKPowerAss, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.FootL.render(f5);
		this.TopBody.render(f5);
		this.Middle.render(f5);
		this.rightleg.render(f5);
		this.leftleg.render(f5);
		this.TopBodyLower.render(f5);
		this.BottomBodyLower.render(f5);
		this.GNKPowerAss.render(f5);
		this.FootR.render(f5);
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
		f *= 2.75F;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
		this.FootR.rotateAngleX = MathHelper.cos(f * 0.6662F) * this.animScale * f1;
		this.FootL.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.1415927F) * this.animScale * f1;
	}
}
