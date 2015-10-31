package com.parzi.starwarsmod.rendering.models.vehicles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLandspeeder extends ModelBase
{
	ModelRenderer Body;
	ModelRenderer LeftFinMain;
	ModelRenderer LeftEngine;
	ModelRenderer WindscreenFront;
	ModelRenderer WindscreenR;
	ModelRenderer WindscreenL;
	ModelRenderer BodyPanelR;
	ModelRenderer BodyPanelL;
	ModelRenderer BodyPanelFront;
	ModelRenderer SeatL;
	ModelRenderer SeatR;
	ModelRenderer TopFinMain;
	ModelRenderer TopEngine;
	ModelRenderer TopFinAngle;
	ModelRenderer LeftFinAngle;
	ModelRenderer RightFinMain;
	ModelRenderer RightFinAngle;
	ModelRenderer RightEngine;

	public ModelLandspeeder()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.addBox(0.0F, 0.0F, 0.0F, 14, 4, 30);
		this.Body.setRotationPoint(-7.0F, 13.0F, -15.0F);
		this.Body.setTextureSize(64, 32);
		this.Body.mirror = true;
		this.setRotation(this.Body, 0.0F, 0.0F, 0.0F);
		this.LeftFinMain = new ModelRenderer(this, 0, 81);
		this.LeftFinMain.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4);
		this.LeftFinMain.setRotationPoint(7.0F, 15.0F, 10.0F);
		this.LeftFinMain.setTextureSize(64, 32);
		this.LeftFinMain.mirror = true;
		this.setRotation(this.LeftFinMain, 0.0F, 0.0F, -1.570796F);
		this.LeftEngine = new ModelRenderer(this, 0, 107);
		this.LeftEngine.addBox(0.0F, 0.0F, 0.0F, 3, 3, 8);
		this.LeftEngine.setRotationPoint(9.0F, 13.0F, 8.0F);
		this.LeftEngine.setTextureSize(64, 32);
		this.LeftEngine.mirror = true;
		this.setRotation(this.LeftEngine, 0.0F, 0.0F, 0.0F);
		this.WindscreenFront = new ModelRenderer(this, 0, 119);
		this.WindscreenFront.addBox(0.0F, 0.0F, 0.0F, 9, 2, 1);
		this.WindscreenFront.setRotationPoint(-4.5F, 11.0F, -3.0F);
		this.WindscreenFront.setTextureSize(64, 32);
		this.WindscreenFront.mirror = true;
		this.setRotation(this.WindscreenFront, 0.0F, 0.0F, 0.0F);
		this.WindscreenR = new ModelRenderer(this, 0, 123);
		this.WindscreenR.addBox(0.0F, 0.0F, 0.0F, 7, 2, 1);
		this.WindscreenR.setRotationPoint(-5.5F, 11.0F, 4.0F);
		this.WindscreenR.setTextureSize(64, 32);
		this.WindscreenR.mirror = true;
		this.setRotation(this.WindscreenR, 0.0F, 1.570796F, 0.0F);
		this.WindscreenL = new ModelRenderer(this, 11, 35);
		this.WindscreenL.addBox(0.0F, 0.0F, 0.0F, 7, 2, 1);
		this.WindscreenL.setRotationPoint(4.5F, 11.0F, 4.0F);
		this.WindscreenL.setTextureSize(64, 32);
		this.WindscreenL.mirror = true;
		this.setRotation(this.WindscreenL, 0.0F, 1.570796F, 0.0F);
		this.BodyPanelR = new ModelRenderer(this, 28, 35);
		this.BodyPanelR.addBox(0.0F, 0.0F, 0.0F, 1, 2, 20);
		this.BodyPanelR.setRotationPoint(-8.0F, 14.0F, -15.0F);
		this.BodyPanelR.setTextureSize(64, 32);
		this.BodyPanelR.mirror = true;
		this.setRotation(this.BodyPanelR, 0.0F, 0.0F, 0.0F);
		this.BodyPanelL = new ModelRenderer(this, 28, 58);
		this.BodyPanelL.addBox(0.0F, 0.0F, 0.0F, 1, 2, 20);
		this.BodyPanelL.setRotationPoint(7.0F, 14.0F, -15.0F);
		this.BodyPanelL.setTextureSize(64, 32);
		this.BodyPanelL.mirror = true;
		this.setRotation(this.BodyPanelL, 0.0F, 0.0F, 0.0F);
		this.BodyPanelFront = new ModelRenderer(this, 23, 81);
		this.BodyPanelFront.addBox(0.0F, 0.0F, 0.0F, 16, 2, 1);
		this.BodyPanelFront.setRotationPoint(-8.0F, 14.0F, -16.0F);
		this.BodyPanelFront.setTextureSize(64, 32);
		this.BodyPanelFront.mirror = true;
		this.setRotation(this.BodyPanelFront, 0.0F, 0.0F, 0.0F);
		this.SeatL = new ModelRenderer(this, 7, 43);
		this.SeatL.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1);
		this.SeatL.setRotationPoint(0.5F, 11.0F, 5.0F);
		this.SeatL.setTextureSize(64, 32);
		this.SeatL.mirror = true;
		this.setRotation(this.SeatL, 0.0F, 0.0F, 0.0F);
		this.SeatR = new ModelRenderer(this, 7, 47);
		this.SeatR.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1);
		this.SeatR.setRotationPoint(-3.5F, 11.0F, 5.0F);
		this.SeatR.setTextureSize(64, 32);
		this.SeatR.mirror = true;
		this.setRotation(this.SeatR, 0.0F, 0.0F, 0.0F);
		this.TopFinMain = new ModelRenderer(this, 0, 35);
		this.TopFinMain.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4);
		this.TopFinMain.setRotationPoint(-0.5F, 10.0F, 10.5F);
		this.TopFinMain.setTextureSize(64, 32);
		this.TopFinMain.mirror = true;
		this.setRotation(this.TopFinMain, 0.0F, 0.0F, 0.0F);
		this.TopEngine = new ModelRenderer(this, 0, 51);
		this.TopEngine.addBox(0.0F, 0.0F, 0.0F, 3, 3, 8);
		this.TopEngine.setRotationPoint(-1.5F, 8.0F, 9.0F);
		this.TopEngine.setTextureSize(64, 32);
		this.TopEngine.mirror = true;
		this.setRotation(this.TopEngine, 0.0F, 0.0F, 0.0F);
		this.TopFinAngle = new ModelRenderer(this, 0, 63);
		this.TopFinAngle.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
		this.TopFinAngle.setRotationPoint(-0.5F, 10.0F, 11.0F);
		this.TopFinAngle.setTextureSize(64, 32);
		this.TopFinAngle.mirror = true;
		this.setRotation(this.TopFinAngle, -0.7853982F, 0.0F, 0.0F);
		this.LeftFinAngle = new ModelRenderer(this, 0, 43);
		this.LeftFinAngle.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
		this.LeftFinAngle.setRotationPoint(10.0F, 14.0F, 10.0F);
		this.LeftFinAngle.setTextureSize(64, 32);
		this.LeftFinAngle.mirror = true;
		this.setRotation(this.LeftFinAngle, -0.7853982F, 0.0F, 1.570796F);
		this.RightFinMain = new ModelRenderer(this, 0, 91);
		this.RightFinMain.addBox(0.0F, 0.0F, 0.0F, 1, 3, 4);
		this.RightFinMain.setRotationPoint(-9.0F, 15.0F, 10.0F);
		this.RightFinMain.setTextureSize(64, 32);
		this.RightFinMain.mirror = true;
		this.setRotation(this.RightFinMain, 0.0F, 0.0F, -1.570796F);
		this.RightFinAngle = new ModelRenderer(this, 0, 72);
		this.RightFinAngle.addBox(0.0F, 0.0F, 0.0F, 1, 5, 2);
		this.RightFinAngle.setRotationPoint(-10.0F, 15.0F, 10.0F);
		this.RightFinAngle.setTextureSize(64, 32);
		this.RightFinAngle.mirror = true;
		this.setRotation(this.RightFinAngle, -0.7853982F, 0.0F, -1.570796F);
		this.RightEngine = new ModelRenderer(this, 14, 85);
		this.RightEngine.addBox(0.0F, 0.0F, 0.0F, 3, 3, 8);
		this.RightEngine.setRotationPoint(-12.0F, 13.0F, 8.0F);
		this.RightEngine.setTextureSize(64, 32);
		this.RightEngine.mirror = true;
		this.setRotation(this.RightEngine, 0.0F, 0.0F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Body.render(f5);
		this.LeftFinMain.render(f5);
		this.LeftEngine.render(f5);
		this.WindscreenFront.render(f5);
		this.WindscreenR.render(f5);
		this.WindscreenL.render(f5);
		this.BodyPanelR.render(f5);
		this.BodyPanelL.render(f5);
		this.BodyPanelFront.render(f5);
		this.SeatL.render(f5);
		this.SeatR.render(f5);
		this.TopFinMain.render(f5);
		this.TopEngine.render(f5);
		this.TopFinAngle.render(f5);
		this.LeftFinAngle.render(f5);
		this.RightFinMain.render(f5);
		this.RightFinAngle.render(f5);
		this.RightEngine.render(f5);
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
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\rendering\models\vehicles\ModelLandspeeder.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */