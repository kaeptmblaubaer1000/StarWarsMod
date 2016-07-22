package com.parzivail.pswm.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Jedi Robes - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelTarget extends ModelBase
{
	public ModelRenderer MainParent;
	public ModelRenderer Base;
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer Body5;
	public ModelRenderer BaseBrace;

	public ModelTarget()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.BaseBrace = new ModelRenderer(this, 68, 0);
		this.BaseBrace.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.BaseBrace.addBox(-2.0F, -5.0F, -4.0F, 4, 2, 7, 0.0F);
		this.setRotateAngle(BaseBrace, -0.6829473363053812F, 0.0F, 0.0F);
		this.Body4 = new ModelRenderer(this, 0, 48);
		this.Body4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body4.addBox(4.0F, -24.0F, -2.0F, 4, 12, 2, 0.0F);
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Base.addBox(-4.0F, 22.0F, -4.0F, 8, 2, 12, 0.0F);
		this.MainParent = new ModelRenderer(this, 92, 0);
		this.MainParent.setRotationPoint(0.0F, 24.0F, -4.0F);
		this.MainParent.addBox(-4.0F, -24.0F, -2.0F, 8, 12, 2, 0.0F);
		this.Body3 = new ModelRenderer(this, 0, 32);
		this.Body3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body3.addBox(-8.0F, -24.0F, -2.0F, 4, 12, 2, 0.0F);
		this.Body1 = new ModelRenderer(this, 114, 0);
		this.Body1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body1.addBox(-4.0F, -12.0F, -2.0F, 4, 12, 2, 0.0F);
		this.Body2 = new ModelRenderer(this, 0, 16);
		this.Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body2.addBox(0.0F, -12.0F, -2.0F, 4, 12, 2, 0.0F);
		this.Body5 = new ModelRenderer(this, 42, 0);
		this.Body5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body5.addBox(-4.0F, -32.0F, -3.0F, 8, 8, 4, 0.0F);
		this.MainParent.addChild(this.BaseBrace);
		this.MainParent.addChild(this.Body4);
		this.MainParent.addChild(this.Body3);
		this.MainParent.addChild(this.Body1);
		this.MainParent.addChild(this.Body2);
		this.MainParent.addChild(this.Body5);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Base.render(f5);
		this.MainParent.render(f5);
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
