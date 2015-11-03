package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSpeederBike extends ModelBase
{
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

	public ModelSpeederBike()
	{
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.BodyBase = new ModelRenderer(this, 0, 0);
		this.BodyBase.addBox(0.0F, 0.0F, 0.0F, 6, 1, 20);
		this.BodyBase.setRotationPoint(-3.0F, 16.0F, -8.0F);
		this.BodyBase.setTextureSize(64, 32);
		this.BodyBase.mirror = true;
		this.setRotation(this.BodyBase, 0.0F, 0.0F, 0.0F);
		this.Seat = new ModelRenderer(this, 0, 21);
		this.Seat.addBox(0.0F, 0.0F, 0.0F, 5, 2, 18);
		this.Seat.setRotationPoint(-2.5F, 14.0F, -7.0F);
		this.Seat.setTextureSize(64, 32);
		this.Seat.mirror = true;
		this.setRotation(this.Seat, 0.0F, 0.0F, 0.0F);
		this.SaddlebagL = new ModelRenderer(this, 0, 41);
		this.SaddlebagL.addBox(0.0F, 0.0F, 0.0F, 2, 5, 8);
		this.SaddlebagL.setRotationPoint(2.5F, 13.0F, 2.0F);
		this.SaddlebagL.setTextureSize(64, 32);
		this.SaddlebagL.mirror = true;
		this.setRotation(this.SaddlebagL, 0.0F, 0.0F, 0.0F);
		this.SaddlebagR = new ModelRenderer(this, 0, 54);
		this.SaddlebagR.addBox(0.0F, 0.0F, 0.0F, 2, 5, 8);
		this.SaddlebagR.setRotationPoint(-4.5F, 13.0F, 2.0F);
		this.SaddlebagR.setTextureSize(64, 32);
		this.SaddlebagR.mirror = true;
		this.setRotation(this.SaddlebagR, 0.0F, 0.0F, 0.0F);
		this.ShaftR = new ModelRenderer(this, 20, 41);
		this.ShaftR.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10);
		this.ShaftR.setRotationPoint(-1.5F, 14.5F, -17.0F);
		this.ShaftR.setTextureSize(64, 32);
		this.ShaftR.mirror = true;
		this.setRotation(this.ShaftR, 0.0F, 0.0F, 0.0F);
		this.ShaftL = new ModelRenderer(this, 20, 52);
		this.ShaftL.addBox(0.0F, 0.0F, 0.0F, 1, 1, 10);
		this.ShaftL.setRotationPoint(0.5F, 14.5F, -17.0F);
		this.ShaftL.setTextureSize(64, 32);
		this.ShaftL.mirror = true;
		this.setRotation(this.ShaftL, 0.0F, 0.0F, 0.0F);
		this.HandlebarBaseL = new ModelRenderer(this, 21, 63);
		this.HandlebarBaseL.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
		this.HandlebarBaseL.setRotationPoint(1.0F, 14.5F, -5.0F);
		this.HandlebarBaseL.setTextureSize(64, 32);
		this.HandlebarBaseL.mirror = true;
		this.setRotation(this.HandlebarBaseL, 0.0F, 0.0F, 0.0F);
		this.HandlebarBaseR = new ModelRenderer(this, 31, 63);
		this.HandlebarBaseR.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1);
		this.HandlebarBaseR.setRotationPoint(-4.0F, 14.5F, -5.0F);
		this.HandlebarBaseR.setTextureSize(64, 32);
		this.HandlebarBaseR.mirror = true;
		this.setRotation(this.HandlebarBaseR, 0.0F, 0.0F, 0.0F);
		this.HandlebarMidR = new ModelRenderer(this, 0, 68);
		this.HandlebarMidR.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.HandlebarMidR.setRotationPoint(-4.0F, 11.0F, -3.0F);
		this.HandlebarMidR.setTextureSize(64, 32);
		this.HandlebarMidR.mirror = true;
		this.setRotation(this.HandlebarMidR, -0.5235988F, 0.0F, 0.0F);
		this.HandlebarMidL = new ModelRenderer(this, 5, 68);
		this.HandlebarMidL.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
		this.HandlebarMidL.setRotationPoint(3.0F, 11.0F, -3.0F);
		this.HandlebarMidL.setTextureSize(64, 32);
		this.HandlebarMidL.mirror = true;
		this.setRotation(this.HandlebarMidL, -0.5235988F, 0.0F, 0.0F);
		this.HandlebarTopL = new ModelRenderer(this, 10, 68);
		this.HandlebarTopL.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.HandlebarTopL.setRotationPoint(1.0F, 11.85F, -3.5F);
		this.HandlebarTopL.setTextureSize(64, 32);
		this.HandlebarTopL.mirror = true;
		this.setRotation(this.HandlebarTopL, 1.047198F, 0.0F, 0.0F);
		this.HandlebarTopR = new ModelRenderer(this, 10, 71);
		this.HandlebarTopR.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
		this.HandlebarTopR.setRotationPoint(-3.0F, 11.85F, -3.5F);
		this.HandlebarTopR.setTextureSize(64, 32);
		this.HandlebarTopR.mirror = true;
		this.setRotation(this.HandlebarTopR, 1.047198F, 0.0F, 0.0F);
		this.FrontThingL = new ModelRenderer(this, 0, 74);
		this.FrontThingL.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5);
		this.FrontThingL.setRotationPoint(1.0F, 13.0F, -18.0F);
		this.FrontThingL.setTextureSize(64, 32);
		this.FrontThingL.mirror = true;
		this.setRotation(this.FrontThingL, 0.0F, 0.0F, 0.7853982F);
		this.FrontThingR = new ModelRenderer(this, 0, 81);
		this.FrontThingR.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5);
		this.FrontThingR.setRotationPoint(-4.0F, 15.9F, -18.0F);
		this.FrontThingR.setTextureSize(64, 32);
		this.FrontThingR.mirror = true;
		this.setRotation(this.FrontThingR, 0.0F, 0.0F, -0.7853982F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.BodyBase.render(f5);
		this.Seat.render(f5);
		this.SaddlebagL.render(f5);
		this.SaddlebagR.render(f5);
		this.ShaftR.render(f5);
		this.ShaftL.render(f5);
		this.HandlebarBaseL.render(f5);
		this.HandlebarBaseR.render(f5);
		this.HandlebarMidR.render(f5);
		this.HandlebarMidL.render(f5);
		this.HandlebarTopL.render(f5);
		this.HandlebarTopR.render(f5);
		this.FrontThingL.render(f5);
		this.FrontThingR.render(f5);
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
 * parzi\starwarsmod\rendering\models\ModelSpeederBike.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */