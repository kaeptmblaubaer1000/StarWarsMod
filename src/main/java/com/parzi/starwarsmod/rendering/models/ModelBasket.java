package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBasket extends ModelBase
{
	public ModelRenderer BasketMain;
	public ModelRenderer Basket1;
	public ModelRenderer Basket2;
	public ModelRenderer Basket3;
	public ModelRenderer Basket4;
	public ModelRenderer Basket5;
	public ModelRenderer Basket6;
	public ModelRenderer Basket7;
	public ModelRenderer BasketFood1;
	public ModelRenderer BasketFood2;
	public ModelRenderer BasketFood3;
	public ModelRenderer BasketFood4;
	public ModelRenderer BasketFood5;

	public ModelBasket()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.BasketFood4 = new ModelRenderer(this, 0, 115);
		this.BasketFood4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BasketFood4.addBox(1.0F, -3.5F, -4.8F, 2, 4, 2, 0.0F);
		this.setRotateAngle(this.BasketFood4, 0.0F, 0.20943951023931953F, 0.0F);
		this.Basket7 = new ModelRenderer(this, 0, 98);
		this.Basket7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket7.addBox(-6.0F, -7.0F, -1.0F, 11, 2, 2, 0.0F);
		this.BasketFood1 = new ModelRenderer(this, 0, 74);
		this.BasketFood1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BasketFood1.addBox(0.5F, -3.5F, 2.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(this.BasketFood1, 0.0F, -0.41887902047863906F, 0.0F);
		this.BasketMain = new ModelRenderer(this, 0, 0);
		this.BasketMain.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BasketMain.addBox(-6.0F, -3.0F, -9.0F, 2, 5, 18, 0.0F);
		this.Basket4 = new ModelRenderer(this, 0, 75);
		this.Basket4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket4.addBox(-6.0F, 0.0F, -9.0F, 11, 2, 18, 0.0F);
		this.BasketFood2 = new ModelRenderer(this, 0, 83);
		this.BasketFood2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BasketFood2.addBox(-1.5F, -3.5F, -6.5F, 3, 4, 3, 0.0F);
		this.setRotateAngle(this.BasketFood2, 0.0F, 0.41887902047863906F, 0.0F);
		this.Basket1 = new ModelRenderer(this, 0, 27);
		this.Basket1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket1.addBox(3.0F, -3.0F, -9.0F, 2, 5, 18, 0.0F);
		this.Basket5 = new ModelRenderer(this, 0, 26);
		this.Basket5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket5.addBox(3.0F, -6.5F, -1.0F, 2, 5, 2, 0.0F);
		this.BasketFood3 = new ModelRenderer(this, 0, 105);
		this.BasketFood3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BasketFood3.addBox(-1.5F, -3.5F, -2.0F, 3, 4, 3, 0.0F);
		this.setRotateAngle(this.BasketFood3, 0.0F, 0.20943951023931953F, 0.0F);
		this.Basket2 = new ModelRenderer(this, 0, 54);
		this.Basket2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket2.addBox(-6.0F, -3.0F, -9.0F, 11, 5, 2, 0.0F);
		this.BasketFood5 = new ModelRenderer(this, 0, 4);
		this.BasketFood5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BasketFood5.addBox(-3.1F, -3.5F, 2.0F, 2, 4, 2, 0.0F);
		this.setRotateAngle(this.BasketFood5, 0.0F, -0.20943951023931953F, 0.0F);
		this.Basket6 = new ModelRenderer(this, 0, 36);
		this.Basket6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket6.addBox(-6.0F, -6.5F, -1.0F, 2, 5, 2, 0.0F);
		this.Basket3 = new ModelRenderer(this, 0, 64);
		this.Basket3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Basket3.addBox(-6.0F, -3.0F, 7.0F, 11, 5, 2, 0.0F);
		this.BasketMain.addChild(this.BasketFood4);
		this.BasketMain.addChild(this.Basket7);
		this.BasketMain.addChild(this.BasketFood1);
		this.BasketMain.addChild(this.Basket4);
		this.BasketMain.addChild(this.BasketFood2);
		this.BasketMain.addChild(this.Basket1);
		this.BasketMain.addChild(this.Basket5);
		this.BasketMain.addChild(this.BasketFood3);
		this.BasketMain.addChild(this.Basket2);
		this.BasketMain.addChild(this.BasketFood5);
		this.BasketMain.addChild(this.Basket6);
		this.BasketMain.addChild(this.Basket3);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.BasketMain.render(f5);
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
