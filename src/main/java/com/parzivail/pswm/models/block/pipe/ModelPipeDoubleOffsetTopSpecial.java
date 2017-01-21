package com.parzivail.pswm.models.block.pipe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * PipeTripleStanTop - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelPipeDoubleOffsetTopSpecial extends ModelBase
{
	public ModelRenderer shape2;
	public ModelRenderer shape2_1;
	public ModelRenderer shape2_2;
	public ModelRenderer shape2_3;

	public ModelPipeDoubleOffsetTopSpecial()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape2_1 = new ModelRenderer(this, 0, 18);
		this.shape2_1.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.shape2_1.addBox(-8.0F, -6.5F, -1.5F, 16, 3, 3, 0.0F);
		this.shape2_3 = new ModelRenderer(this, 0, 57);
		this.shape2_3.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.shape2_3.addBox(-1.0F, -11.0F, -1.0F, 6, 3, 3, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 0);
		this.shape2.setRotationPoint(0.0F, 11.5F, 6.5F);
		this.shape2.addBox(-8.0F, -1.0F, -0.5F, 16, 2, 2, 0.0F);
		this.shape2_2 = new ModelRenderer(this, 0, 36);
		this.shape2_2.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.shape2_2.addBox(-5.0F, -7.0F, -2.0F, 1, 4, 4, 0.0F);
		this.shape2.addChild(this.shape2_1);
		this.shape2.addChild(this.shape2_3);
		this.shape2.addChild(this.shape2_2);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape2.render(f5);
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
