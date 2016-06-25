package com.parzivail.pswm.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Hyperdrive Block - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelHyperdriveBlock extends ModelBase
{
	public ModelRenderer p;
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape1_2;
	public ModelRenderer shape1_3;
	public ModelRenderer shape1_4;
	public ModelRenderer shape1_5;
	public ModelRenderer shape1_6;
	public ModelRenderer shape1_7;
	public ModelRenderer shape1_8;

	public ModelHyperdriveBlock()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1_4 = new ModelRenderer(this, 110, 0);
		this.shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_4.addBox(1.0F, -2.0F, -10.0F, 1, 3, 2, 0.0F);
		this.shape1_6 = new ModelRenderer(this, 148, 0);
		this.shape1_6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_6.addBox(5.0F, -2.0F, -10.0F, 1, 3, 2, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 71);
		this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_1.addBox(-6.0F, 2.0F, -10.0F, 12, 4, 2, 0.0F);
		this.shape1_7 = new ModelRenderer(this, 174, 0);
		this.shape1_7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_7.addBox(-4.0F, -9.0F, -4.0F, 8, 2, 8, 0.0F);
		this.shape1_3 = new ModelRenderer(this, 77, 0);
		this.shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_3.addBox(1.0F, -6.0F, -10.0F, 5, 3, 2, 0.0F);
		this.shape1_5 = new ModelRenderer(this, 129, 0);
		this.shape1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_5.addBox(3.0F, -2.0F, -10.0F, 1, 3, 2, 0.0F);
		this.shape1_2 = new ModelRenderer(this, 0, 90);
		this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_2.addBox(-6.0F, -6.0F, -10.0F, 6, 7, 2, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 43);
		this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1.addBox(-7.0F, -7.0F, -9.0F, 14, 14, 2, 0.0F);
		this.shape1_8 = new ModelRenderer(this, 0, 108);
		this.shape1_8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_8.addBox(-6.0F, -8.5F, -6.0F, 12, 2, 12, 0.0F);
		this.p = new ModelRenderer(this, 0, 0);
		this.p.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.p.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
		this.shape1_3.addChild(this.shape1_4);
		this.shape1_5.addChild(this.shape1_6);
		this.shape1.addChild(this.shape1_1);
		this.shape1_6.addChild(this.shape1_7);
		this.shape1_2.addChild(this.shape1_3);
		this.shape1_4.addChild(this.shape1_5);
		this.shape1_1.addChild(this.shape1_2);
		this.p.addChild(this.shape1);
		this.shape1_7.addChild(this.shape1_8);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.p.render(f5);
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
