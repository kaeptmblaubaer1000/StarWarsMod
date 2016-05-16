package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBinoculars extends ModelBase
{
	ModelRenderer Body;
	ModelRenderer LensR;
	ModelRenderer LensL;
	ModelRenderer Viewfinder;
	ModelRenderer LeftThingy;
	ModelRenderer ButtonThingy;

	public ModelBinoculars()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.addBox(-3.0F, -3.0F, -4.0F, 6, 3, 6);
		this.Body.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Body.setTextureSize(64, 32);
		this.Body.mirror = true;
		this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
		this.LensR = new ModelRenderer(this, 0, 10);
		this.LensR.addBox(-2.5F, -2.5F, -6.5F, 2, 2, 3);
		this.LensR.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.LensR.setTextureSize(64, 32);
		this.LensR.mirror = true;
		this.setRotation(this.LensR, 0.0F, 0.0F, 0.0F);
		this.LensL = new ModelRenderer(this, 0, 16);
		this.LensL.addBox(0.5F, -2.5F, -6.5F, 2, 2, 3);
		this.LensL.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.LensL.setTextureSize(64, 32);
		this.LensL.mirror = true;
		this.setRotation(this.LensL, 0.0F, 0.0F, 0.0F);
		this.Viewfinder = new ModelRenderer(this, 0, 22);
		this.Viewfinder.addBox(-2.5F, -3.5F, 0.5F, 5, 2, 2);
		this.Viewfinder.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Viewfinder.setTextureSize(64, 32);
		this.Viewfinder.mirror = true;
		this.setRotation(this.Viewfinder, 0.0F, 0.0F, 0.0F);
		this.LeftThingy = new ModelRenderer(this, 11, 10);
		this.LeftThingy.addBox(0.5F, -3.5F, -3.0F, 3, 2, 3);
		this.LeftThingy.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.LeftThingy.setTextureSize(64, 32);
		this.LeftThingy.mirror = true;
		this.setRotation(this.LeftThingy, 0.0F, 0.0F, 0.0F);
		this.ButtonThingy = new ModelRenderer(this, 11, 16);
		this.ButtonThingy.addBox(-2.5F, -3.3F, -2.5F, 2, 1, 2);
		this.ButtonThingy.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.ButtonThingy.setTextureSize(64, 32);
		this.ButtonThingy.mirror = true;
		this.setRotation(this.ButtonThingy, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Body.render(f5);
		this.LensR.render(f5);
		this.LensL.render(f5);
		this.Viewfinder.render(f5);
		this.LeftThingy.render(f5);
		this.ButtonThingy.render(f5);
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
	}
}
