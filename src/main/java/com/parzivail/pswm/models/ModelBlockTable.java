package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockTable extends ModelBase
{
	ModelRenderer tabletop;
	ModelRenderer pedastal;

	public ModelBlockTable()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.tabletop = new ModelRenderer(this, 0, 0);
		this.tabletop.addBox(0.0F, 0.0F, 0.0F, 16, 8, 16);
		this.tabletop.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.tabletop.setTextureSize(64, 32);
		this.tabletop.mirror = true;
		this.setRotation(this.tabletop, 0.0F, 0.0F, 0.0F);
		this.pedastal = new ModelRenderer(this, 16, 8);
		this.pedastal.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
		this.pedastal.setRotationPoint(-4.0F, 16.0F, -4.0F);
		this.pedastal.setTextureSize(64, 32);
		this.pedastal.mirror = true;
		this.setRotation(this.pedastal, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.tabletop.render(f5);
		this.pedastal.render(f5);
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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\models\ModelBlockTable.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */