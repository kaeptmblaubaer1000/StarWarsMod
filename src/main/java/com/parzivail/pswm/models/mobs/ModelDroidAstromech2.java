package com.parzivail.pswm.models.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDroidAstromech2 extends ModelBase
{
	ModelRenderer FootR;
	ModelRenderer FootL;
	ModelRenderer LegM;
	ModelRenderer FootM;
	ModelRenderer headBase;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer headMid;
	ModelRenderer headTop;

	public ModelDroidAstromech2()
	{
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.FootR = new ModelRenderer(this, 12, 38);
		this.FootR.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6);
		this.FootR.setRotationPoint(-7.0F, 23.0F, -2.5F);
		this.FootR.setTextureSize(64, 32);
		this.FootR.mirror = true;
		this.setRotation(this.FootR, 0.0F, 0.0F, 0.0F);
		this.FootL = new ModelRenderer(this, 12, 52);
		this.FootL.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6);
		this.FootL.setRotationPoint(3.0F, 23.0F, -2.5F);
		this.FootL.setTextureSize(64, 32);
		this.FootL.mirror = true;
		this.setRotation(this.FootL, 0.0F, 0.0F, 0.0F);
		this.LegM = new ModelRenderer(this, 32, 20);
		this.LegM.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
		this.LegM.setRotationPoint(-1.0F, 17.0F, -1.0F);
		this.LegM.setTextureSize(64, 32);
		this.LegM.mirror = true;
		this.setRotation(this.LegM, -0.8726646F, 0.0F, 0.0F);
		this.FootM = new ModelRenderer(this, 12, 45);
		this.FootM.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6);
		this.FootM.setRotationPoint(-2.0F, 23.0F, -9.0F);
		this.FootM.setTextureSize(64, 32);
		this.FootM.mirror = true;
		this.setRotation(this.FootM, 0.0F, 0.0F, 0.0F);
		this.headBase = new ModelRenderer(this, 0, 0);
		this.headBase.addBox(-4.0F, -8.0F, -4.0F, 8, 2, 8);
		this.headBase.setRotationPoint(0.0F, 13.0F, 0.0F);
		this.headBase.setTextureSize(64, 32);
		this.headBase.mirror = true;
		this.setRotation(this.headBase, -0.1570796F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 14, 8);
		this.body.setRotationPoint(0.0F, 7.0F, -1.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, -0.1570796F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 0, 38);
		this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 2, 16, 4);
		this.rightarm.setRotationPoint(-3.0F, 9.0F, 0.5F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
		this.leftarm = new ModelRenderer(this, 32, 0);
		this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 2, 16, 4);
		this.leftarm.setRotationPoint(5.0F, 9.0F, 0.5F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
		this.headMid = new ModelRenderer(this, 32, 30);
		this.headMid.addBox(0.0F, 0.0F, 0.0F, 7, 3, 7);
		this.headMid.setRotationPoint(-3.5F, 2.5F, -2.0F);
		this.headMid.setTextureSize(64, 32);
		this.headMid.mirror = true;
		this.setRotation(this.headMid, -0.1570796F, 0.0F, 0.0F);
		this.headTop = new ModelRenderer(this, 32, 41);
		this.headTop.addBox(0.0F, 0.0F, 0.0F, 6, 3, 6);
		this.headTop.setRotationPoint(-3.0F, 0.5F, -1.2F);
		this.headTop.setTextureSize(64, 32);
		this.headTop.mirror = true;
		this.setRotation(this.headTop, -0.1570796F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.headBase.render(f5);
		this.headMid.render(f5);
		this.headTop.render(f5);
		if (entity == null || entity.getEntityId() != 1337)
		{
			this.FootR.render(f5);
			this.FootL.render(f5);
			this.LegM.render(f5);
			this.FootM.render(f5);
			this.body.render(f5);
			this.rightarm.render(f5);
			this.leftarm.render(f5);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
