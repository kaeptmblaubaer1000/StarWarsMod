package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockTable extends ModelBase
{
	// fields
	ModelRenderer tabletop;
	ModelRenderer pedastal;

	public ModelBlockTable()
	{
		textureWidth = 64;
		textureHeight = 32;

		tabletop = new ModelRenderer(this, 0, 0);
		tabletop.addBox(0F, 0F, 0F, 16, 8, 16);
		tabletop.setRotationPoint(-8F, 8F, -8F);
		tabletop.setTextureSize(64, 32);
		tabletop.mirror = true;
		setRotation(tabletop, 0F, 0F, 0F);
		pedastal = new ModelRenderer(this, 16, 8);
		pedastal.addBox(0F, 0F, 0F, 8, 8, 8);
		pedastal.setRotationPoint(-4F, 16F, -4F);
		pedastal.setTextureSize(64, 32);
		pedastal.mirror = true;
		setRotation(pedastal, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		tabletop.render(f5);
		pedastal.render(f5);
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
