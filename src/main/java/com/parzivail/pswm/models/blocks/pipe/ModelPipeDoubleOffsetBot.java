package com.parzivail.pswm.models.blocks.pipe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * PipeTripleStanTop - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelPipeDoubleOffsetBot extends ModelBase
{
	public ModelRenderer shape2;
	public ModelRenderer shape2_1;

	public ModelPipeDoubleOffsetBot()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape2_1 = new ModelRenderer(this, 0, 18);
		this.shape2_1.setRotationPoint(0.0F, 9.5F, 0.0F);
		this.shape2_1.addBox(-8.0F, -6.5F, -1.5F, 16, 3, 3, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 0);
		this.shape2.setRotationPoint(0.0F, 11.5F, 6.5F);
		this.shape2.addBox(-8.0F, 8.0F, -0.5F, 16, 2, 2, 0.0F);
		this.shape2.addChild(this.shape2_1);
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
