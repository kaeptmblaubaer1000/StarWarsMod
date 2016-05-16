package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBinocularsHoth extends ModelBase
{
	ModelRenderer Thing1;
	ModelRenderer Body;
	ModelRenderer Thing2;
	ModelRenderer Lens;
	ModelRenderer Thing3;
	ModelRenderer Thing4;
	ModelRenderer Thing5;
	ModelRenderer Viewfinder;

	public ModelBinocularsHoth()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.Thing1 = new ModelRenderer(this, 0, 23);
		this.Thing1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Thing1.setRotationPoint(-3.3F, 21.7F, -5.5F);
		this.Thing1.setTextureSize(64, 64);
		this.Thing1.mirror = true;
		this.setRotation(this.Thing1, 0.0F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 3, 9);
		this.Body.setRotationPoint(-4.0F, 21.0F, -5.0F);
		this.Body.setTextureSize(64, 64);
		this.Body.mirror = true;
		this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
		this.Thing2 = new ModelRenderer(this, 0, 27);
		this.Thing2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Thing2.setRotationPoint(1.4F, 21.7F, -5.7F);
		this.Thing2.setTextureSize(64, 64);
		this.Thing2.mirror = true;
		this.setRotation(this.Thing2, 0.0F, 0.0F, 0.0F);
		this.Lens = new ModelRenderer(this, 0, 18);
		this.Lens.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2);
		this.Lens.setRotationPoint(-1.6F, 21.5F, -6.0F);
		this.Lens.setTextureSize(64, 64);
		this.Lens.mirror = true;
		this.setRotation(this.Lens, 0.0F, 0.0F, 0.0F);
		this.Thing3 = new ModelRenderer(this, 0, 31);
		this.Thing3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Thing3.setRotationPoint(1.4F, 22.2F, -5.7F);
		this.Thing3.setTextureSize(64, 64);
		this.Thing3.mirror = true;
		this.setRotation(this.Thing3, 0.0F, 0.0F, 0.0F);
		this.Thing4 = new ModelRenderer(this, 0, 35);
		this.Thing4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Thing4.setRotationPoint(1.7F, 22.2F, -5.7F);
		this.Thing4.setTextureSize(64, 64);
		this.Thing4.mirror = true;
		this.setRotation(this.Thing4, 0.0F, 0.0F, 0.0F);
		this.Thing5 = new ModelRenderer(this, 0, 39);
		this.Thing5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
		this.Thing5.setRotationPoint(1.7F, 21.7F, -5.7F);
		this.Thing5.setTextureSize(64, 64);
		this.Thing5.mirror = true;
		this.setRotation(this.Thing5, 0.0F, 0.0F, 0.0F);
		this.Viewfinder = new ModelRenderer(this, 0, 13);
		this.Viewfinder.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
		this.Viewfinder.setRotationPoint(-2.0F, 20.5F, 2.5F);
		this.Viewfinder.setTextureSize(64, 64);
		this.Viewfinder.mirror = true;
		this.setRotation(this.Viewfinder, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Thing1.render(f5);
		this.Body.render(f5);
		this.Thing2.render(f5);
		this.Lens.render(f5);
		this.Thing3.render(f5);
		this.Thing4.render(f5);
		this.Thing5.render(f5);
		this.Viewfinder.render(f5);
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
