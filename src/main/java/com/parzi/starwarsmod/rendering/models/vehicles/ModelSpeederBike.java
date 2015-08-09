package com.parzi.starwarsmod.rendering.models.vehicles;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpeederBike extends ModelBase
{
	// fields
	ModelRenderer BodyBase;
	ModelRenderer Seat;
	ModelRenderer SaddlebagL;
	ModelRenderer SaddlebagR;
	ModelRenderer ShaftR;
	ModelRenderer ShaftL;
	ModelRenderer HandlebarBaseL;
	ModelRenderer HandlebarBaseR;
	ModelRenderer HandlebarMidR;
	ModelRenderer HandlebarMidL;
	ModelRenderer HandlebarTopL;
	ModelRenderer HandlebarTopR;
	ModelRenderer FrontThingL;
	ModelRenderer FrontThingR;
	ModelRenderer FrontCrossbar;
	ModelRenderer FrontShaft;
	ModelRenderer LaserBase;
	ModelRenderer LaserBarrel;

	public ModelSpeederBike()
	{
		textureWidth = 128;
		textureHeight = 128;

		BodyBase = new ModelRenderer(this, 0, 0);
		BodyBase.addBox(0F, 0F, 0F, 6, 1, 19);
		BodyBase.setRotationPoint(-3F, 16F, -8F);
		BodyBase.setTextureSize(64, 32);
		BodyBase.mirror = true;
		setRotation(BodyBase, 0F, 0F, 0F);
		Seat = new ModelRenderer(this, 0, 21);
		Seat.addBox(0F, 0F, 0F, 5, 2, 18);
		Seat.setRotationPoint(-2.5F, 14F, -7F);
		Seat.setTextureSize(64, 32);
		Seat.mirror = true;
		setRotation(Seat, 0F, 0F, 0F);
		SaddlebagL = new ModelRenderer(this, 0, 41);
		SaddlebagL.addBox(0F, 0F, 0F, 2, 5, 8);
		SaddlebagL.setRotationPoint(2.5F, 13F, 1.8F);
		SaddlebagL.setTextureSize(64, 32);
		SaddlebagL.mirror = true;
		setRotation(SaddlebagL, 0F, 0F, 0F);
		SaddlebagR = new ModelRenderer(this, 0, 54);
		SaddlebagR.addBox(0F, 0F, 0F, 2, 5, 8);
		SaddlebagR.setRotationPoint(-4.5F, 13F, 1.8F);
		SaddlebagR.setTextureSize(64, 32);
		SaddlebagR.mirror = true;
		setRotation(SaddlebagR, 0F, 0F, 0F);
		ShaftR = new ModelRenderer(this, 20, 41);
		ShaftR.addBox(0F, 0F, 0F, 1, 1, 9);
		ShaftR.setRotationPoint(-1.5F, 14.5F, -16F);
		ShaftR.setTextureSize(64, 32);
		ShaftR.mirror = true;
		setRotation(ShaftR, 0F, 0F, 0F);
		ShaftL = new ModelRenderer(this, 20, 52);
		ShaftL.addBox(0F, 0F, 0F, 1, 1, 9);
		ShaftL.setRotationPoint(0.5F, 14.5F, -16F);
		ShaftL.setTextureSize(64, 32);
		ShaftL.mirror = true;
		setRotation(ShaftL, 0F, 0F, 0F);
		HandlebarBaseL = new ModelRenderer(this, 21, 63);
		HandlebarBaseL.addBox(0F, 0F, 0F, 3, 1, 1);
		HandlebarBaseL.setRotationPoint(1F, 14.5F, -5F);
		HandlebarBaseL.setTextureSize(64, 32);
		HandlebarBaseL.mirror = true;
		setRotation(HandlebarBaseL, 0F, 0F, 0F);
		HandlebarBaseR = new ModelRenderer(this, 31, 63);
		HandlebarBaseR.addBox(0F, 0F, 0F, 3, 1, 1);
		HandlebarBaseR.setRotationPoint(-4F, 14.5F, -5F);
		HandlebarBaseR.setTextureSize(64, 32);
		HandlebarBaseR.mirror = true;
		setRotation(HandlebarBaseR, 0F, 0F, 0F);
		HandlebarMidR = new ModelRenderer(this, 0, 68);
		HandlebarMidR.addBox(0F, 0F, 0F, 1, 4, 1);
		HandlebarMidR.setRotationPoint(-4F, 11F, -3F);
		HandlebarMidR.setTextureSize(64, 32);
		HandlebarMidR.mirror = true;
		setRotation(HandlebarMidR, -0.5235988F, 0F, 0F);
		HandlebarMidL = new ModelRenderer(this, 5, 68);
		HandlebarMidL.addBox(0F, 0F, 0F, 1, 4, 1);
		HandlebarMidL.setRotationPoint(3F, 11F, -3F);
		HandlebarMidL.setTextureSize(64, 32);
		HandlebarMidL.mirror = true;
		setRotation(HandlebarMidL, -0.5235988F, 0F, 0F);
		HandlebarTopL = new ModelRenderer(this, 10, 68);
		HandlebarTopL.addBox(0F, 0F, 0F, 2, 1, 1);
		HandlebarTopL.setRotationPoint(1F, 11.85F, -3.5F);
		HandlebarTopL.setTextureSize(64, 32);
		HandlebarTopL.mirror = true;
		setRotation(HandlebarTopL, 1.047198F, 0F, 0F);
		HandlebarTopR = new ModelRenderer(this, 10, 71);
		HandlebarTopR.addBox(0F, 0F, 0F, 2, 1, 1);
		HandlebarTopR.setRotationPoint(-3F, 11.85F, -3.5F);
		HandlebarTopR.setTextureSize(64, 32);
		HandlebarTopR.mirror = true;
		setRotation(HandlebarTopR, 1.047198F, 0F, 0F);
		FrontThingL = new ModelRenderer(this, 0, 74);
		FrontThingL.addBox(0F, 0F, 0F, 4, 1, 5);
		FrontThingL.setRotationPoint(1F, 13F, -18F);
		FrontThingL.setTextureSize(64, 32);
		FrontThingL.mirror = true;
		setRotation(FrontThingL, 0F, 0F, 0.7853982F);
		FrontThingR = new ModelRenderer(this, 0, 81);
		FrontThingR.addBox(0F, 0F, 0F, 4, 1, 5);
		FrontThingR.setRotationPoint(-4F, 15.9F, -18F);
		FrontThingR.setTextureSize(64, 32);
		FrontThingR.mirror = true;
		setRotation(FrontThingR, 0F, 0F, -0.7853982F);
		FrontCrossbar = new ModelRenderer(this, 22, 67);
		FrontCrossbar.addBox(0F, 0F, 0F, 5, 1, 1);
		FrontCrossbar.setRotationPoint(-2.5F, 14.5F, -16F);
		FrontCrossbar.setTextureSize(64, 32);
		FrontCrossbar.mirror = true;
		setRotation(FrontCrossbar, 0F, 0F, 0F);
		FrontShaft = new ModelRenderer(this, 20, 71);
		FrontShaft.addBox(0F, 0F, 0F, 1, 1, 2);
		FrontShaft.setRotationPoint(-0.5F, 14.5F, -18F);
		FrontShaft.setTextureSize(64, 32);
		FrontShaft.mirror = true;
		setRotation(FrontShaft, 0F, 0F, 0F);
		LaserBase = new ModelRenderer(this, 28, 71);
		LaserBase.addBox(0F, 0F, 0F, 1, 3, 1);
		LaserBase.setRotationPoint(-0.5F, 15.5F, -6.8F);
		LaserBase.setTextureSize(64, 32);
		LaserBase.mirror = true;
		setRotation(LaserBase, 0F, 0F, 0F);
		LaserBarrel = new ModelRenderer(this, 20, 77);
		LaserBarrel.addBox(0F, 0F, 0F, 1, 1, 4);
		LaserBarrel.setRotationPoint(-0.5F, 17.5F, -10.4F);
		LaserBarrel.setTextureSize(64, 32);
		LaserBarrel.mirror = true;
		setRotation(LaserBarrel, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BodyBase.render(f5);
		Seat.render(f5);
		SaddlebagL.render(f5);
		SaddlebagR.render(f5);
		ShaftR.render(f5);
		ShaftL.render(f5);
		HandlebarBaseL.render(f5);
		HandlebarBaseR.render(f5);
		HandlebarMidR.render(f5);
		HandlebarMidL.render(f5);
		HandlebarTopL.render(f5);
		HandlebarTopR.render(f5);
		FrontThingL.render(f5);
		FrontThingR.render(f5);
		FrontCrossbar.render(f5);
		FrontShaft.render(f5);
		LaserBase.render(f5);
		LaserBarrel.render(f5);
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
