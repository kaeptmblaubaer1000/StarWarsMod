package com.parzivail.pswm.models.weapons;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * BlasterPack - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelBlasterPack extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;

	public ModelBlasterPack()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.shape2 = new ModelRenderer(this, 0, 25);
		this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape2.addBox(-3.7F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 42);
		this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape3.addBox(1.7F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.shape1.addBox(-5.0F, -0.5F, -3.0F, 10, 2, 6, 0.0F);
		this.shape4 = new ModelRenderer(this, 0, 59);
		this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape4.addBox(-1.0F, 1.0F, -2.5F, 2, 10, 5, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 10);
		this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape5.addBox(-4.5F, 1.5F, -2.0F, 9, 9, 4, 0.0F);
		this.shape1.addChild(this.shape2);
		this.shape1.addChild(this.shape3);
		this.shape1.addChild(this.shape4);
		this.shape1.addChild(this.shape5);
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
