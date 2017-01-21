package com.parzivail.pswm.models.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * DoorHoth - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelDoorHoth extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer DoorParent;
	public ModelRenderer DoorChild1;
	public ModelRenderer DoorChild2;
	public ModelRenderer DoorChild3;
	public ModelRenderer DoorChild4;
	public ModelRenderer DoorChild5;
	public ModelRenderer DoorChild6;

	public ModelDoorHoth()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.DoorChild6 = new ModelRenderer(this, 146, 20);
		this.DoorChild6.setRotationPoint(63.0F, 0.0F, 0.0F);
		this.DoorChild6.addBox(-22.0F, -21.3F, -6.0F, 5, 43, 12, 0.0F);
		this.DoorParent = new ModelRenderer(this, 0, 20);
		this.DoorParent.setRotationPoint(24.0F, 0.0F, 0.0F);
		this.DoorParent.addBox(-22.0F, -26.3F, -5.0F, 44, 53, 10, 0.0F);
		this.DoorChild3 = new ModelRenderer(this, 244, 0);
		this.DoorChild3.setRotationPoint(24.0F, 0.0F, 0.0F);
		this.DoorChild3.addBox(-22.0F, -26.3F, -6.0F, 44, 5, 12, 0.0F);
		this.DoorChild4 = new ModelRenderer(this, 358, 0);
		this.DoorChild4.setRotationPoint(24.0F, 0.0F, 0.0F);
		this.DoorChild4.addBox(-22.0F, 21.7F, -6.0F, 44, 5, 12, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 85);
		this.shape1.setRotationPoint(-24.0F, -4.0F, 0.0F);
		this.shape1.addBox(0.0F, -28.0F, -8.0F, 2, 56, 16, 0.0F);
		this.shape4 = new ModelRenderer(this, 122, 0);
		this.shape4.setRotationPoint(2.0F, 54.0F, 0.0F);
		this.shape4.addBox(0.0F, -28.0F, -8.0F, 44, 2, 16, 0.0F);
		this.DoorChild2 = new ModelRenderer(this, 0, 302);
		this.DoorChild2.setRotationPoint(24.4F, 0.0F, 0.0F);
		this.DoorChild2.addBox(-2.0F, -28.0F, -5.5F, 3, 56, 11, 0.0F);
		this.setRotateAngle(DoorChild2, 0.0F, 0.0F, 0.6829473363053812F);
		this.DoorChild5 = new ModelRenderer(this, 110, 20);
		this.DoorChild5.setRotationPoint(24.0F, 0.0F, 0.0F);
		this.DoorChild5.addBox(-22.0F, -21.3F, -6.0F, 5, 43, 12, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 159);
		this.shape2.setRotationPoint(46.0F, 0.0F, 0.0F);
		this.shape2.addBox(0.0F, -28.0F, -8.0F, 2, 56, 16, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 0);
		this.shape3.setRotationPoint(2.0F, 0.0F, 0.0F);
		this.shape3.addBox(0.0F, -28.0F, -8.0F, 44, 2, 16, 0.0F);
		this.DoorChild1 = new ModelRenderer(this, 0, 233);
		this.DoorChild1.setRotationPoint(24.0F, 0.0F, 0.0F);
		this.DoorChild1.addBox(-1.4F, -27.7F, -5.5F, 3, 56, 11, 0.0F);
		this.setRotateAngle(DoorChild1, 0.0F, 0.0F, -0.6829473363053812F);
		this.shape1.addChild(this.DoorChild6);
		this.shape1.addChild(this.DoorParent);
		this.shape1.addChild(this.DoorChild3);
		this.shape1.addChild(this.DoorChild4);
		this.shape1.addChild(this.shape4);
		this.shape1.addChild(this.DoorChild2);
		this.shape1.addChild(this.DoorChild5);
		this.shape1.addChild(this.shape2);
		this.shape1.addChild(this.shape3);
		this.shape1.addChild(this.DoorChild1);
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
