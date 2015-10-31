package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlasterBolt extends ModelBase
{
	ModelRenderer Shape1;

	public ModelBlasterBolt()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Shape1 = new ModelRenderer(this, 0, 0);
		this.Shape1.addBox(-0.5F, 0.0F, -3.5F, 1, 1, 7);
		this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Shape1.setTextureSize(64, 32);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\ModelBlasterBolt.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */