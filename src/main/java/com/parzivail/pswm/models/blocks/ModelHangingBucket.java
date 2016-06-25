package com.parzivail.pswm.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHangingBucket extends ModelBase
{
	public ModelRenderer Main;
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer Body5;
	public ModelRenderer Body6;
	public ModelRenderer Body7;
	public ModelRenderer Body8;
	public ModelRenderer Body9;
	public ModelRenderer Body10;
	public ModelRenderer Body11;
	public ModelRenderer Body12;

	public ModelHangingBucket()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Body5 = new ModelRenderer(this, 0, 60);
		this.Body5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body5.addBox(-12.0F, -12.0F, -2.0F, 4, 4, 1, 0.0F);
		this.Body11 = new ModelRenderer(this, 0, 108);
		this.Body11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body11.addBox(-12.0F, -14.0F, -0.5F, 1, 2, 1, 0.0F);
		this.Body3 = new ModelRenderer(this, 0, 44);
		this.Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body3.addBox(-11.0F, -22.0F, -1.0F, 2, 4, 2, 0.0F);
		this.Body9 = new ModelRenderer(this, 0, 96);
		this.Body9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body9.addBox(-12.0F, -8.0F, -2.0F, 4, 1, 4, 0.0F);
		this.Body10 = new ModelRenderer(this, 0, 103);
		this.Body10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body10.addBox(-12.0F, -14.0F, -0.5F, 4, 1, 1, 0.0F);
		this.Body6 = new ModelRenderer(this, 0, 68);
		this.Body6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body6.addBox(-12.0F, -12.0F, -2.0F, 1, 4, 4, 0.0F);
		this.Body7 = new ModelRenderer(this, 0, 78);
		this.Body7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body7.addBox(-12.0F, -12.0F, 1.0F, 4, 4, 1, 0.0F);
		this.Body4 = new ModelRenderer(this, 0, 52);
		this.Body4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body4.addBox(-10.5F, -19.0F, -0.5F, 1, 5, 1, 0.0F);
		this.Main = new ModelRenderer(this, 0, 0);
		this.Main.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.Main.addBox(-4.0F, -1.0F, -4.0F, 8, 2, 8, 0.0F);
		this.Body1 = new ModelRenderer(this, 0, 13);
		this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body1.addBox(-1.0F, -23.0F, -1.0F, 2, 22, 2, 0.0F);
		this.Body2 = new ModelRenderer(this, 0, 38);
		this.Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body2.addBox(-11.0F, -24.0F, -1.0F, 12, 2, 2, 0.0F);
		this.Body8 = new ModelRenderer(this, 0, 86);
		this.Body8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body8.addBox(-9.0F, -12.0F, -2.0F, 1, 4, 4, 0.0F);
		this.Body12 = new ModelRenderer(this, 0, 114);
		this.Body12.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body12.addBox(-9.0F, -14.0F, -0.5F, 1, 2, 1, 0.0F);
		this.Main.addChild(this.Body5);
		this.Main.addChild(this.Body11);
		this.Main.addChild(this.Body3);
		this.Main.addChild(this.Body9);
		this.Main.addChild(this.Body10);
		this.Main.addChild(this.Body6);
		this.Main.addChild(this.Body7);
		this.Main.addChild(this.Body4);
		this.Main.addChild(this.Body1);
		this.Main.addChild(this.Body2);
		this.Main.addChild(this.Body8);
		this.Main.addChild(this.Body12);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Main.render(f5);
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
