package com.parzivail.pswm.models.block.pipe;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Pipes - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelPipesClampedMass extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape1_2;

	public ModelPipesClampedMass()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 16.0F, 6.5F);
		this.shape1.addBox(-8.0F, -1.5F, -1.5F, 16, 3, 3, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 47);
		this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1_1.addBox(-5.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
		this.shape1_2 = new ModelRenderer(this, 0, 85);
		this.shape1_2.setRotationPoint(9.0F, 0.0F, 0.0F);
		this.shape1_2.addBox(-5.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F);
		this.shape1.addChild(this.shape1_1);
		this.shape1_1.addChild(this.shape1_2);
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
