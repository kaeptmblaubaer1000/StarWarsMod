package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlasterBolt extends ModelBase
{
	// fields
	ModelRenderer bolt;

	public ModelBlasterBolt()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.bolt = new ModelRenderer(this, 0, 0);
		this.bolt.addBox(-0.5F, -0.5F, -8F, 1, 1, 16);
		this.bolt.setRotationPoint(0F, 0F, 0F);
		this.bolt.setTextureSize(64, 32);
		this.bolt.mirror = true;
		this.setRotation(this.bolt, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.bolt.render(f5);
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
