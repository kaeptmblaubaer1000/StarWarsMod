package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Training Remote - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelTrainingRemote extends ModelBase
{
	public ModelRenderer BodyMain;
	public ModelRenderer Body1;
	public ModelRenderer Body2;
	public ModelRenderer Body3;
	public ModelRenderer Body4;
	public ModelRenderer Body5;
	public ModelRenderer Body6;

	public ModelTrainingRemote()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.BodyMain = new ModelRenderer(this, 0, 0);
		this.BodyMain.setRotationPoint(0.0F, 8.0F, 0.0F);
		this.BodyMain.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
		this.Body6 = new ModelRenderer(this, 0, 214);
		this.Body6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body6.addBox(-3.0F, -10.0F, -3.0F, 6, 20, 6, 0.0F);
		this.Body3 = new ModelRenderer(this, 0, 120);
		this.Body3.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Body3.addBox(-9.0F, -8.0F, -7.0F, 18, 14, 14, 0.0F);
		this.Body4 = new ModelRenderer(this, 0, 157);
		this.Body4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body4.addBox(-3.0F, -3.0F, -10.0F, 6, 6, 20, 0.0F);
		this.Body2 = new ModelRenderer(this, 0, 79);
		this.Body2.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.Body2.addBox(-7.0F, -8.0F, -7.0F, 14, 18, 14, 0.0F);
		this.Body1 = new ModelRenderer(this, 0, 39);
		this.Body1.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Body1.addBox(-7.0F, -8.0F, -9.0F, 14, 14, 18, 0.0F);
		this.Body5 = new ModelRenderer(this, 0, 194);
		this.Body5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Body5.addBox(-10.0F, -3.0F, -3.0F, 20, 6, 6, 0.0F);
		this.BodyMain.addChild(this.Body6);
		this.BodyMain.addChild(this.Body3);
		this.BodyMain.addChild(this.Body4);
		this.BodyMain.addChild(this.Body2);
		this.BodyMain.addChild(this.Body1);
		this.BodyMain.addChild(this.Body5);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glTranslatef(0, -5, 0);
		this.BodyMain.render(f5);
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
