package com.parzivail.pswm.models.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Forge - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelLightsaberForge extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape1_2;
	public ModelRenderer shape1_3;
	public ModelRenderer shape1_4;
	public ModelRenderer shape1_5;
	public ModelRenderer shape1_6;
	public ModelRenderer shape1_7;
	public ModelRenderer shape1_8;
	public ModelRenderer shape1_9;
	public ModelRenderer shape1_10;
	public ModelRenderer shape1_11;
	public ModelRenderer shape1_12;
	public ModelRenderer shape1_13;
	public ModelRenderer shape1_14;

	public ModelLightsaberForge()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1_11 = new ModelRenderer(this, 0, 280);
		this.shape1_11.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_11.addBox(-9.0F, -9.0F, -7.0F, 2, 12, 14, 0.0F);
		this.shape1_9 = new ModelRenderer(this, 0, 240);
		this.shape1_9.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_9.addBox(21.0F, 1.0F, -7.0F, 2, 2, 14, 0.0F);
		this.shape1_10 = new ModelRenderer(this, 0, 264);
		this.shape1_10.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_10.addBox(21.0F, -7.0F, 5.0F, 2, 8, 2, 0.0F);
		this.shape1_3 = new ModelRenderer(this, 0, 113);
		this.shape1_3.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_3.addBox(-23.0F, 1.0F, -7.0F, 2, 2, 14, 0.0F);
		this.shape1_13 = new ModelRenderer(this, 0, 348);
		this.shape1_13.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_13.addBox(-21.0F, 1.0F, -7.0F, 42, 2, 14, 0.0F);
		this.shape1_2 = new ModelRenderer(this, 0, 84);
		this.shape1_2.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_2.addBox(-21.0F, 1.0F, -5.0F, 42, 12, 10, 0.0F);
		this.shape1_5 = new ModelRenderer(this, 0, 163);
		this.shape1_5.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_5.addBox(-23.0F, -7.0F, -7.0F, 2, 8, 2, 0.0F);
		this.shape1_4 = new ModelRenderer(this, 0, 136);
		this.shape1_4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_4.addBox(-23.0F, 1.0F, -7.0F, 2, 2, 14, 0.0F);
		this.shape1_7 = new ModelRenderer(this, 0, 200);
		this.shape1_7.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_7.addBox(21.0F, 1.0F, -7.0F, 2, 2, 14, 0.0F);
		this.shape1_8 = new ModelRenderer(this, 0, 226);
		this.shape1_8.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_8.addBox(21.0F, -7.0F, -7.0F, 2, 8, 2, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 33);
		this.shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.shape1.addBox(-24.0F, -1.0F, -8.0F, 48, 2, 16, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 59);
		this.shape1_1.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_1.addBox(-24.0F, -1.0F, -8.0F, 48, 2, 16, 0.0F);
		this.shape1_12 = new ModelRenderer(this, 0, 312);
		this.shape1_12.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_12.addBox(7.0F, -9.0F, -7.0F, 2, 12, 14, 0.0F);
		this.shape1_14 = new ModelRenderer(this, 0, 374);
		this.shape1_14.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_14.addBox(-21.0F, 11.0F, -7.0F, 42, 2, 14, 0.0F);
		this.shape1_6 = new ModelRenderer(this, 0, 184);
		this.shape1_6.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_6.addBox(-23.0F, -7.0F, 5.0F, 2, 8, 2, 0.0F);
		this.shape1.addChild(this.shape1_11);
		this.shape1.addChild(this.shape1_9);
		this.shape1.addChild(this.shape1_10);
		this.shape1.addChild(this.shape1_3);
		this.shape1.addChild(this.shape1_13);
		this.shape1.addChild(this.shape1_2);
		this.shape1.addChild(this.shape1_5);
		this.shape1.addChild(this.shape1_4);
		this.shape1.addChild(this.shape1_7);
		this.shape1.addChild(this.shape1_8);
		this.shape1.addChild(this.shape1_1);
		this.shape1.addChild(this.shape1_12);
		this.shape1.addChild(this.shape1_14);
		this.shape1.addChild(this.shape1_6);
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
