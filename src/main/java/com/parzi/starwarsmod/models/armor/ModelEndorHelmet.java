package com.parzi.starwarsmod.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEndorHelmet extends ModelBiped
{
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;

	public ModelEndorHelmet()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;

		this.Shape1 = new ModelRenderer(this, 0, 26);
		this.Shape1.addBox(-5F, -6F, -2F, 2, 4, 4);
		this.Shape1.setRotationPoint(0F, 0F, 0F);
		this.Shape1.setTextureSize(64, 64);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape2 = new ModelRenderer(this, 0, 14);
		this.Shape2.addBox(-4F, -10F, -4F, 8, 3, 8);
		this.Shape2.setRotationPoint(0F, 0F, 0F);
		this.Shape2.setTextureSize(64, 64);
		this.Shape2.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape3 = new ModelRenderer(this, 0, 0);
		this.Shape3.addBox(-5F, -9F, -5F, 10, 3, 10);
		this.Shape3.setRotationPoint(0F, 0F, 0F);
		this.Shape3.setTextureSize(64, 64);
		this.Shape3.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape4 = new ModelRenderer(this, 0, 35);
		this.Shape4.addBox(3F, -6F, -2F, 2, 4, 4);
		this.Shape4.setRotationPoint(0F, 0F, 0F);
		this.Shape4.setTextureSize(64, 64);
		this.Shape4.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);

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
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape4.render(f5);
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
		this.Shape1.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape1.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.Shape2.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape2.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.Shape3.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape3.rotateAngleX = f4 / (180F / (float)Math.PI);

		this.Shape4.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape4.rotateAngleX = f4 / (180F / (float)Math.PI);

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
