package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * BlasterPack - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelBlasterPack extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape1_2;
	public ModelRenderer shape1_3;
	public ModelRenderer shape1_4;

	public ModelBlasterPack()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1_1 = new ModelRenderer(this, 0, 31);
		this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_1.addBox(-3.7F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape1_4 = new ModelRenderer(this, 58, 0);
		this.shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_4.addBox(-4.5F, 1.5F, -2.0F, 9, 9, 4, 0.0F);
		this.shape1_2 = new ModelRenderer(this, 0, 65);
		this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_2.addBox(1.7F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.shape1.addBox(-5.0F, -0.5F, -3.0F, 10, 2, 6, 0.0F);
		this.shape1_3 = new ModelRenderer(this, 0, 100);
		this.shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_3.addBox(-1.0F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape1.addChild(this.shape1_1);
		this.shape1.addChild(this.shape1_4);
		this.shape1.addChild(this.shape1_2);
		this.shape1.addChild(this.shape1_3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
