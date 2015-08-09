package com.parzi.starwarsmod.rendering.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeiaBuns extends ModelBiped
{
	// fields
	public ModelRenderer BunR;
	public ModelRenderer BunL;

	public ModelLeiaBuns()
	{
		textureWidth = 64;
		textureHeight = 32;

		BunR = new ModelRenderer(this, 0, 0);
		BunR.addBox(-5.5F, -6.5F, -2.5F, 2, 5, 5);
		BunR.setRotationPoint(0F, 0F, 0F);
		BunR.setTextureSize(64, 32);
		BunR.mirror = true;
		setRotation(BunR, 0F, 0F, 0F);
		BunL = new ModelRenderer(this, 0, 10);
		BunL.addBox(3.5F, -6.5F, -2.5F, 2, 5, 5);
		BunL.setRotationPoint(0F, 0F, 0F);
		BunL.setTextureSize(64, 32);
		BunL.mirror = true;
		setRotation(BunL, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BunR.render(f5);
		BunL.render(f5);
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
