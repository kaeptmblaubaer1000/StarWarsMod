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
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 14, 4, 30);
		Body.setRotationPoint(-7F, 13F, -15F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		LeftFinMain = new ModelRenderer(this, 0, 81);
		LeftFinMain.addBox(0F, 0F, 0F, 1, 3, 4);
		LeftFinMain.setRotationPoint(7F, 15F, 10F);
		LeftFinMain.setTextureSize(64, 32);
		LeftFinMain.mirror = true;
		setRotation(LeftFinMain, 0F, 0F, -1.570796F);
		LeftEngine = new ModelRenderer(this, 0, 107);
		LeftEngine.addBox(0F, 0F, 0F, 3, 3, 8);
		LeftEngine.setRotationPoint(9F, 13F, 8F);
		LeftEngine.setTextureSize(64, 32);
		LeftEngine.mirror = true;
		setRotation(LeftEngine, 0F, 0F, 0F);
		WindscreenFront = new ModelRenderer(this, 0, 119);
		WindscreenFront.addBox(0F, 0F, 0F, 9, 2, 1);
		WindscreenFront.setRotationPoint(-4.5F, 11F, -3F);
		WindscreenFront.setTextureSize(64, 32);
		WindscreenFront.mirror = true;
		setRotation(WindscreenFront, 0F, 0F, 0F);
		WindscreenR = new ModelRenderer(this, 0, 123);
		WindscreenR.addBox(0F, 0F, 0F, 7, 2, 1);
		WindscreenR.setRotationPoint(-5.5F, 11F, 4F);
		WindscreenR.setTextureSize(64, 32);
		WindscreenR.mirror = true;
		setRotation(WindscreenR, 0F, 1.570796F, 0F);
		WindscreenL = new ModelRenderer(this, 11, 35);
		WindscreenL.addBox(0F, 0F, 0F, 7, 2, 1);
		WindscreenL.setRotationPoint(4.5F, 11F, 4F);
		WindscreenL.setTextureSize(64, 32);
		WindscreenL.mirror = true;
		setRotation(WindscreenL, 0F, 1.570796F, 0F);
		BodyPanelR = new ModelRenderer(this, 28, 35);
		BodyPanelR.addBox(0F, 0F, 0F, 1, 2, 20);
		BodyPanelR.setRotationPoint(-8F, 14F, -15F);
		BodyPanelR.setTextureSize(64, 32);
		BodyPanelR.mirror = true;
		setRotation(BodyPanelR, 0F, 0F, 0F);
		BodyPanelL = new ModelRenderer(this, 28, 58);
		BodyPanelL.addBox(0F, 0F, 0F, 1, 2, 20);
		BodyPanelL.setRotationPoint(7F, 14F, -15F);
		BodyPanelL.setTextureSize(64, 32);
		BodyPanelL.mirror = true;
		setRotation(BodyPanelL, 0F, 0F, 0F);
		BodyPanelFront = new ModelRenderer(this, 23, 81);
		BodyPanelFront.addBox(0F, 0F, 0F, 16, 2, 1);
		BodyPanelFront.setRotationPoint(-8F, 14F, -16F);
		BodyPanelFront.setTextureSize(64, 32);
		BodyPanelFront.mirror = true;
		setRotation(BodyPanelFront, 0F, 0F, 0F);
		SeatL = new ModelRenderer(this, 7, 43);
		SeatL.addBox(0F, 0F, 0F, 3, 2, 1);
		SeatL.setRotationPoint(0.5F, 11F, 5F);
		SeatL.setTextureSize(64, 32);
		SeatL.mirror = true;
		setRotation(SeatL, 0F, 0F, 0F);
		SeatR = new ModelRenderer(this, 7, 47);
		SeatR.addBox(0F, 0F, 0F, 3, 2, 1);
		SeatR.setRotationPoint(-3.5F, 11F, 5F);
		SeatR.setTextureSize(64, 32);
		SeatR.mirror = true;
		setRotation(SeatR, 0F, 0F, 0F);
		TopFinMain = new ModelRenderer(this, 0, 35);
		TopFinMain.addBox(0F, 0F, 0F, 1, 3, 4);
		TopFinMain.setRotationPoint(0F, 10F, 10.5F);
		TopFinMain.setTextureSize(64, 32);
		TopFinMain.mirror = true;
		setRotation(TopFinMain, 0F, 0F, 0F);
		TopEngine = new ModelRenderer(this, 0, 51);
		TopEngine.addBox(0F, 0F, 0F, 3, 3, 8);
		TopEngine.setRotationPoint(-1F, 8F, 9F);
		TopEngine.setTextureSize(64, 32);
		TopEngine.mirror = true;
		setRotation(TopEngine, 0F, 0F, 0F);
		TopFinAngle = new ModelRenderer(this, 0, 63);
		TopFinAngle.addBox(0F, 0F, 0F, 1, 5, 2);
		TopFinAngle.setRotationPoint(0F, 10F, 11F);
		TopFinAngle.setTextureSize(64, 32);
		TopFinAngle.mirror = true;
		setRotation(TopFinAngle, -0.7853982F, 0F, 0F);
		LeftFinAngle = new ModelRenderer(this, 0, 43);
		LeftFinAngle.addBox(0F, 0F, 0F, 1, 5, 2);
		LeftFinAngle.setRotationPoint(10F, 14F, 10F);
		LeftFinAngle.setTextureSize(64, 32);
		LeftFinAngle.mirror = true;
		setRotation(LeftFinAngle, -0.7853982F, 0F, 1.570796F);
		RightFinMain = new ModelRenderer(this, 0, 91);
		RightFinMain.addBox(0F, 0F, 0F, 1, 3, 4);
		RightFinMain.setRotationPoint(-9F, 15F, 10F);
		RightFinMain.setTextureSize(64, 32);
		RightFinMain.mirror = true;
		setRotation(RightFinMain, 0F, 0F, -1.570796F);
		RightFinAngle = new ModelRenderer(this, 0, 72);
		RightFinAngle.addBox(0F, 0F, 0F, 1, 5, 2);
		RightFinAngle.setRotationPoint(-10F, 15F, 10F);
		RightFinAngle.setTextureSize(64, 32);
		RightFinAngle.mirror = true;
		setRotation(RightFinAngle, -0.7853982F, 0F, -1.570796F);
		RightEngine = new ModelRenderer(this, 14, 85);
		RightEngine.addBox(0F, 0F, 0F, 3, 3, 8);
		RightEngine.setRotationPoint(-12F, 13F, 8F);
		RightEngine.setTextureSize(64, 32);
		RightEngine.mirror = true;
		setRotation(RightEngine, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		LeftFinMain.render(f5);
		LeftEngine.render(f5);
		WindscreenFront.render(f5);
		WindscreenR.render(f5);
		WindscreenL.render(f5);
		BodyPanelR.render(f5);
		BodyPanelL.render(f5);
		BodyPanelFront.render(f5);
		SeatL.render(f5);
		SeatR.render(f5);
		TopFinMain.render(f5);
		TopEngine.render(f5);
		TopFinAngle.render(f5);
		LeftFinAngle.render(f5);
		RightFinMain.render(f5);
		RightFinAngle.render(f5);
		RightEngine.render(f5);
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
