package com.parzivail.pswm.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeiaBuns extends ModelBiped
{
	public ModelRenderer BunR;
	public ModelRenderer BunL;

	public ModelLeiaBuns()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.BunR = new ModelRenderer(this, 0, 0);
		this.BunR.addBox(-5.5F, -6.5F, -2.5F, 2, 5, 5);
		this.BunR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BunR.setTextureSize(64, 32);
		this.BunR.mirror = true;
		this.setRotation(this.BunR, 0.0F, 0.0F, 0.0F);
		this.BunL = new ModelRenderer(this, 0, 10);
		this.BunL.addBox(3.5F, -6.5F, -2.5F, 2, 5, 5);
		this.BunL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BunL.setTextureSize(64, 32);
		this.BunL.mirror = true;
		this.setRotation(this.BunL, 0.0F, 0.0F, 0.0F);

		this.bipedHead.isHidden = true;
		this.bipedHeadwear.isHidden = true;
		this.bipedBody.isHidden = true;
		this.bipedRightArm.isHidden = true;
		this.bipedLeftArm.isHidden = true;
		this.bipedRightLeg.isHidden = true;
		this.bipedLeftLeg.isHidden = true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BunR.render(f5);
		this.BunL.render(f5);
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
		this.BunL.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.BunL.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.BunR.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.BunR.rotateAngleX = f4 / (180F / (float)Math.PI);

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\armor\ModelLeiaBuns.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */