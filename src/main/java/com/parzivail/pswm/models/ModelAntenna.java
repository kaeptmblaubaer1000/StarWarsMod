package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Antenna - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelAntenna extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape8;
	public ModelRenderer shape9;
	public ModelRenderer shape10;
	public ModelRenderer shape11;
	public ModelRenderer shape12;
	public ModelRenderer shape13;
	public ModelRenderer shape14;
	public ModelRenderer shape15;
	public ModelRenderer screen;
	public ModelRenderer keyboard;
	public ModelRenderer dishbase;
	public ModelRenderer dishmiddle;
	public ModelRenderer flap1;
	public ModelRenderer flap2;
	public ModelRenderer dishpoint;
	public ModelRenderer flap3;
	public ModelRenderer flap4;
	public ModelRenderer dishtip;

	public ModelAntenna()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape13 = new ModelRenderer(this, 0, 214);
		this.shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape13.addBox(15.0F, -20.0F, -0.5F, 1, 8, 1, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 52);
		this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape3.addBox(-6.0F, -3.7F, -6.0F, 12, 3, 12, 0.0F);
		this.flap3 = new ModelRenderer(this, 134, 0);
		this.flap3.setRotationPoint(0.0F, -2.5F, -1.5F);
		this.flap3.addBox(-3.0F, -2.92F, -0.5F, 6, 3, 1, 0.0F);
		this.setRotateAngle(flap3, 0.13962634015954636F, 0.0F, 0.0F);
		this.dishmiddle = new ModelRenderer(this, 66, 0);
		this.dishmiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dishmiddle.addBox(-3.0F, -2.5F, -2.0F, 6, 6, 1, 0.0F);
		this.keyboard = new ModelRenderer(this, 198, 0);
		this.keyboard.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.keyboard.addBox(-3.0F, -5.4F, -3.5F, 6, 1, 3, 0.0F);
		this.shape9 = new ModelRenderer(this, 0, 150);
		this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape9.addBox(15.0F, -1.0F, 0.67F, 1, 9, 1, 0.0F);
		this.setRotateAngle(shape9, 0.5235987755982988F, 0.0F, 0.0F);
		this.flap2 = new ModelRenderer(this, 105, 0);
		this.flap2.setRotationPoint(-3.0F, 0.53F, -1.08F);
		this.flap2.addBox(-3.0F, -3.03F, -0.92F, 3, 6, 1, 0.0F);
		this.setRotateAngle(flap2, 0.0F, -0.13962634015954636F, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.shape1.addBox(-5.0F, -5.0F, -5.0F, 10, 10, 10, 0.0F);
		this.flap4 = new ModelRenderer(this, 154, 0);
		this.flap4.setRotationPoint(3.0F, 0.53F, -1.08F);
		this.flap4.addBox(0.0F, -3.03F, -0.92F, 3, 6, 1, 0.0F);
		this.setRotateAngle(flap4, 0.0F, 0.13962634015954636F, 0.0F);
		this.shape5 = new ModelRenderer(this, 0, 89);
		this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape5.addBox(-0.1F, 4.0F, 11.0F, 12, 1, 1, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 134);
		this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape8.addBox(15.0F, -1.0F, -1.63F, 1, 9, 1, 0.0F);
		this.setRotateAngle(shape8, -0.5235987755982988F, 0.0F, 0.0F);
		this.dishpoint = new ModelRenderer(this, 120, 0);
		this.dishpoint.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dishpoint.addBox(-0.5F, 0.0F, -4.0F, 1, 1, 3, 0.0F);
		this.shape14 = new ModelRenderer(this, 0, 228);
		this.shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape14.addBox(11.0F, 4.0F, 2.0F, 5, 1, 1, 0.0F);
		this.shape12 = new ModelRenderer(this, 0, 200);
		this.shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape12.addBox(15.0F, -2.0F, -0.5F, 1, 7, 1, 0.0F);
		this.shape4 = new ModelRenderer(this, 0, 73);
		this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape4.addBox(-0.5F, 4.0F, 5.0F, 1, 1, 7, 0.0F);
		this.shape10 = new ModelRenderer(this, 0, 168);
		this.shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape10.addBox(-0.5F, -9.1F, -12.73F, 1, 10, 1, 0.0F);
		this.setRotateAngle(shape10, 0.5235987755982988F, -1.5707963267948966F, 0.0F);
		this.shape6 = new ModelRenderer(this, 0, 96);
		this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape6.addBox(11.0F, 4.0F, 2.0F, 1, 1, 10, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 28);
		this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape2.addBox(-6.0F, 0.7F, -6.0F, 12, 3, 12, 0.0F);
		this.screen = new ModelRenderer(this, 178, 0);
		this.screen.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.screen.addBox(-3.0F, -9.4F, -1.5F, 6, 5, 1, 0.0F);
		this.setRotateAngle(screen, -0.3141592653589793F, 0.0F, 0.0F);
		this.dishtip = new ModelRenderer(this, 166, 0);
		this.dishtip.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.dishtip.addBox(-0.5F, 0.0F, -5.0F, 1, 1, 1, 0.0F);
		this.shape7 = new ModelRenderer(this, 0, 114);
		this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape7.addBox(14.5F, -14.0F, -1.0F, 2, 13, 2, 0.0F);
		this.shape11 = new ModelRenderer(this, 0, 184);
		this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape11.addBox(-0.5F, 5.9F, -15.03F, 1, 10, 1, 0.0F);
		this.setRotateAngle(shape11, -0.5235987755982988F, -1.5707963267948966F, 0.0F);
		this.flap1 = new ModelRenderer(this, 86, 0);
		this.flap1.setRotationPoint(0.0F, 3.5F, -1.5F);
		this.flap1.addBox(-3.0F, -0.1F, -0.5F, 6, 3, 1, 0.0F);
		this.setRotateAngle(flap1, -0.13962634015954636F, 0.0F, 0.0F);
		this.dishbase = new ModelRenderer(this, 48, 0);
		this.dishbase.setRotationPoint(15.5F, -20.0F, 0.0F);
		this.dishbase.addBox(-2.0F, -1.5F, -1.5F, 4, 4, 2, 0.0F);
		this.setRotateAngle(dishbase, -0.296705972839036F, 0.0F, 0.0F);
		this.shape15 = new ModelRenderer(this, 0, 238);
		this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape15.addBox(15.0F, 4.0F, 0.0F, 1, 1, 3, 0.0F);
		this.shape1.addChild(this.shape13);
		this.shape1.addChild(this.shape3);
		this.dishmiddle.addChild(this.flap3);
		this.dishbase.addChild(this.dishmiddle);
		this.shape1.addChild(this.keyboard);
		this.shape1.addChild(this.shape9);
		this.dishmiddle.addChild(this.flap2);
		this.dishmiddle.addChild(this.flap4);
		this.shape1.addChild(this.shape5);
		this.shape1.addChild(this.shape8);
		this.dishmiddle.addChild(this.dishpoint);
		this.shape1.addChild(this.shape14);
		this.shape1.addChild(this.shape12);
		this.shape1.addChild(this.shape4);
		this.shape1.addChild(this.shape10);
		this.shape1.addChild(this.shape6);
		this.shape1.addChild(this.shape2);
		this.shape1.addChild(this.screen);
		this.dishmiddle.addChild(this.dishtip);
		this.shape1.addChild(this.shape7);
		this.shape1.addChild(this.shape11);
		this.dishmiddle.addChild(this.flap1);
		this.shape13.addChild(this.dishbase);
		this.shape1.addChild(this.shape15);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		if (f == 1)
		{
			if (f1 == 1)
			{
				flap1.rotateAngleX = -0.13962634015954636F;
				flap2.rotateAngleY = -0.13962634015954636F;
				flap3.rotateAngleX = 0.13962634015954636F;
				flap4.rotateAngleY = 0.13962634015954636F;
				dishbase.rotateAngleX = -0.296705972839036F;
				dishbase.rotateAngleY = (float)(Math.PI * 2 * ((System.currentTimeMillis() % 5000) / 5000f));
			}
			else
			{
				flap1.rotateAngleX = -0.13962634015954636F;
				flap2.rotateAngleY = -0.13962634015954636F;
				flap3.rotateAngleX = 0.13962634015954636F;
				flap4.rotateAngleY = 0.13962634015954636F;
				dishbase.rotateAngleX = -0.296705972839036F;
				dishbase.rotateAngleY = 0;
			}
		}
		else
		{
			flap1.rotateAngleX = (float)-Math.PI / 2;
			flap2.rotateAngleY = (float)-Math.PI / 2;
			flap3.rotateAngleX = (float)Math.PI / 2;
			flap4.rotateAngleY = (float)Math.PI / 2;
			dishbase.rotateAngleX = 0.4f;
			dishbase.rotateAngleY = 0;
		}
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
