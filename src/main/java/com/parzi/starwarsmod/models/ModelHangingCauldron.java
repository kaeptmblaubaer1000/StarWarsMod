package com.parzi.starwarsmod.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHangingCauldron extends ModelBase
{
	public ModelRenderer ChainParent;
	public ModelRenderer Post4;
	public ModelRenderer Fire1;
	public ModelRenderer Fire2;
	public ModelRenderer Fire3;
	public ModelRenderer Fire4;
	public ModelRenderer ChainChild;
	public ModelRenderer CauldronHandle1;
	public ModelRenderer CauldronHandle2;
	public ModelRenderer CauldronHandle3;
	public ModelRenderer CauldronFill;
	public ModelRenderer CauldronSide1;
	public ModelRenderer CauldronSide2;
	public ModelRenderer CauldronSide3;
	public ModelRenderer CauldronBottom;
	public ModelRenderer CauldronSide4;
	public ModelRenderer Log1;
	public ModelRenderer Log2;
	public ModelRenderer Log3;
	public ModelRenderer Log4;
	public ModelRenderer Log5;
	public ModelRenderer Log6;
	public ModelRenderer Post1;
	public ModelRenderer Post2;
	public ModelRenderer Post3;

	public ModelHangingCauldron()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Fire1 = new ModelRenderer(this, 0, 8);
		this.Fire1.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.Fire1.addBox(0.0F, 8.1F, -5.0F, 0, 6, 10, 0.0F);
		this.CauldronFill = new ModelRenderer(this, 0, 71);
		this.CauldronFill.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronFill.addBox(-6.0F, 21.0F, -6.0F, 12, 8, 12, 0.0F);
		this.ChainParent = new ModelRenderer(this, 46, 0);
		this.ChainParent.setRotationPoint(0.0F, -15.0F, 0.0F);
		this.ChainParent.addBox(-0.5F, -1.0F, 0.0F, 1, 16, 0, 0.0F);
		this.CauldronSide2 = new ModelRenderer(this, 0, 92);
		this.CauldronSide2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronSide2.addBox(5.0F, 20.0F, -7.0F, 2, 10, 14, 0.0F);
		this.Fire4 = new ModelRenderer(this, 21, 8);
		this.Fire4.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.Fire4.addBox(0.0F, 8.1F, -5.0F, 0, 6, 10, 0.0F);
		this.setRotateAngle(this.Fire4, 0.0F, -0.7853981633974483F, 0.0F);
		this.CauldronSide3 = new ModelRenderer(this, 33, 58);
		this.CauldronSide3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronSide3.addBox(-7.0F, 20.0F, 5.0F, 14, 10, 2, 0.0F);
		this.Log3 = new ModelRenderer(this, 49, 75);
		this.Log3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log3.addBox(-2.0F, 12.0F, -7.0F, 3, 2, 14, 0.0F);
		this.setRotateAngle(this.Log3, 0.0F, 1.4114477660878142F, 0.0F);
		this.Log6 = new ModelRenderer(this, 43, 94);
		this.Log6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log6.addBox(-1.0F, 10.0F, 3.0F, 3, 2, 6, 0.0F);
		this.setRotateAngle(this.Log6, -0.6373942428283291F, -1.9123572614101867F, -0.136659280431156F);
		this.CauldronHandle2 = new ModelRenderer(this, 0, 66);
		this.CauldronHandle2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronHandle2.addBox(-7.0F, 16.0F, -1.0F, 2, 4, 2, 0.0F);
		this.CauldronHandle1 = new ModelRenderer(this, 0, 60);
		this.CauldronHandle1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronHandle1.addBox(-7.0F, 15.0F, -1.0F, 14, 2, 2, 0.0F);
		this.Log1 = new ModelRenderer(this, 49, 75);
		this.Log1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log1.addBox(-2.0F, 12.0F, -7.0F, 3, 2, 14, 0.0F);
		this.setRotateAngle(this.Log1, 0.0F, 0.5462880558742251F, 0.0F);
		this.Log2 = new ModelRenderer(this, 49, 75);
		this.Log2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log2.addBox(-2.0F, 12.0F, -7.0F, 3, 2, 14, 0.0F);
		this.setRotateAngle(this.Log2, 0.0F, -0.7285004297824331F, 0.0F);
		this.ChainChild = new ModelRenderer(this, 0, 25);
		this.ChainChild.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.ChainChild.addBox(0.0F, -1.0F, -0.5F, 0, 16, 1, 0.0F);
		this.Post2 = new ModelRenderer(this, 119, 0);
		this.Post2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Post2.addBox(14.0F, -23.1F, -1.0F, 2, 53, 2, 0.0F);
		this.setRotateAngle(this.Post2, 0.0F, 0.0F, -0.6373942428283291F);
		this.Post4 = new ModelRenderer(this, 0, -1);
		this.Post4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Post4.addBox(-1.0F, -11.1F, -40.0F, 2, 2, 55, 0.0F);
		this.setRotateAngle(this.Post4, 0.9009389598794728F, 0.0F, 0.0F);
		this.CauldronSide1 = new ModelRenderer(this, 0, 92);
		this.CauldronSide1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronSide1.addBox(-7.0F, 20.0F, -7.0F, 2, 10, 14, 0.0F);
		this.CauldronBottom = new ModelRenderer(this, 53, 58);
		this.CauldronBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronBottom.addBox(-7.0F, 29.0F, -7.0F, 14, 2, 14, 0.0F);
		this.Post1 = new ModelRenderer(this, 119, 0);
		this.Post1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Post1.addBox(-16.0F, -24.1F, -1.0F, 2, 53, 2, 0.0F);
		this.setRotateAngle(this.Post1, 0.0F, 0.0F, 0.6373942428283291F);
		this.Fire3 = new ModelRenderer(this, 21, 0);
		this.Fire3.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.Fire3.addBox(0.0F, 8.1F, -5.0F, 0, 6, 10, 0.0F);
		this.setRotateAngle(this.Fire3, 0.0F, 1.5707963267948966F, 0.0F);
		this.Fire2 = new ModelRenderer(this, 0, 0);
		this.Fire2.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.Fire2.addBox(0.0F, 8.1F, -5.0F, 0, 6, 10, 0.0F);
		this.setRotateAngle(this.Fire2, 0.0F, 0.7853981633974483F, 0.0F);
		this.CauldronHandle3 = new ModelRenderer(this, 0, 74);
		this.CauldronHandle3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.CauldronHandle3.addBox(5.0F, 16.0F, -1.0F, 2, 4, 2, 0.0F);
		this.Log4 = new ModelRenderer(this, 19, 92);
		this.Log4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log4.addBox(-4.0F, 11.0F, 0.0F, 3, 2, 8, 0.0F);
		this.setRotateAngle(this.Log4, -0.6373942428283291F, 1.4114477660878142F, -0.13962634015954636F);
		this.CauldronSide4 = new ModelRenderer(this, 33, 58);
		this.CauldronSide4.setRotationPoint(0.0F, 25.0F, 0.0F);
		this.CauldronSide4.addBox(-7.0F, -5.0F, -7.0F, 14, 10, 2, 0.0F);
		this.Log5 = new ModelRenderer(this, 43, 94);
		this.Log5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Log5.addBox(-4.0F, 11.0F, 1.0F, 3, 2, 6, 0.0F);
		this.setRotateAngle(this.Log5, -0.6373942428283291F, -0.045553093477052F, -0.136659280431156F);
		this.Post3 = new ModelRenderer(this, 0, 0);
		this.Post3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Post3.addBox(-1.0F, -16.1F, -22.0F, 2, 2, 54, 0.0F);
		this.setRotateAngle(this.Post3, -0.9009389598794728F, 0.0F, 0.0F);
		this.CauldronHandle3.addChild(this.CauldronFill);
		this.CauldronSide1.addChild(this.CauldronSide2);
		this.CauldronSide2.addChild(this.CauldronSide3);
		this.CauldronSide4.addChild(this.Log3);
		this.CauldronSide4.addChild(this.Log6);
		this.CauldronHandle1.addChild(this.CauldronHandle2);
		this.ChainChild.addChild(this.CauldronHandle1);
		this.CauldronSide4.addChild(this.Log1);
		this.CauldronSide4.addChild(this.Log2);
		this.ChainParent.addChild(this.ChainChild);
		this.CauldronSide4.addChild(this.Post2);
		this.CauldronFill.addChild(this.CauldronSide1);
		this.CauldronSide3.addChild(this.CauldronBottom);
		this.CauldronSide4.addChild(this.Post1);
		this.CauldronHandle2.addChild(this.CauldronHandle3);
		this.CauldronSide4.addChild(this.Log4);
		this.CauldronBottom.addChild(this.CauldronSide4);
		this.CauldronSide4.addChild(this.Log5);
		this.CauldronSide4.addChild(this.Post3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Fire1.render(f5);
		this.ChainParent.render(f5);
		this.Fire4.render(f5);
		this.Post4.render(f5);
		this.Fire3.render(f5);
		this.Fire2.render(f5);
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