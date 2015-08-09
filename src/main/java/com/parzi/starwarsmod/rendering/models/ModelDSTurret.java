package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDSTurret extends ModelBase
{
	// fields
	ModelRenderer Base;
	ModelRenderer UpperBase;
	ModelRenderer MainBody;
	ModelRenderer SideThing;
	ModelRenderer MainBarrel;
	ModelRenderer MainBarrelEnd;
	ModelRenderer SecondBarrel;
	ModelRenderer SightBase;
	ModelRenderer BackThing;
	ModelRenderer Sight;
	ModelRenderer SideThingExtra;
	ModelRenderer Chair_Back;
	ModelRenderer Crossbar;
	ModelRenderer ChairBottom;
	ModelRenderer ChairSupportRight;
	ModelRenderer ChairSupportLeft;

	public ModelDSTurret()
	{
		textureWidth = 128;
		textureHeight = 128;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(-7F, 0F, -13F, 14, 2, 24);
		Base.setRotationPoint(0F, 22F, 0F);
		Base.setTextureSize(128, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		UpperBase = new ModelRenderer(this, 0, 28);
		UpperBase.addBox(-4F, -9F, -4F, 8, 9, 8);
		UpperBase.setRotationPoint(0F, 22F, 0F);
		UpperBase.setTextureSize(128, 128);
		UpperBase.mirror = true;
		setRotation(UpperBase, 0F, 0F, 0F);
		MainBody = new ModelRenderer(this, 0, 46);
		MainBody.addBox(-2F, -12F, -5F, 4, 4, 20);
		MainBody.setRotationPoint(0F, 22F, 0F);
		MainBody.setTextureSize(128, 128);
		MainBody.mirror = true;
		setRotation(MainBody, 0.3490659F, 0F, 0F);
		SideThing = new ModelRenderer(this, 0, 71);
		SideThing.addBox(0F, -9.5F, -5.5F, 5, 4, 4);
		SideThing.setRotationPoint(0F, 22F, 0F);
		SideThing.setTextureSize(128, 128);
		SideThing.mirror = true;
		setRotation(SideThing, 0F, 0F, 0F);
		MainBarrel = new ModelRenderer(this, 0, 80);
		MainBarrel.addBox(-0.5F, -11.5F, 15F, 1, 1, 10);
		MainBarrel.setRotationPoint(0F, 22F, 0F);
		MainBarrel.setTextureSize(128, 128);
		MainBarrel.mirror = true;
		setRotation(MainBarrel, 0.3490659F, 0F, 0F);
		MainBarrelEnd = new ModelRenderer(this, 0, 92);
		MainBarrelEnd.addBox(-1F, -12F, 25F, 2, 2, 6);
		MainBarrelEnd.setRotationPoint(0F, 22F, 0F);
		MainBarrelEnd.setTextureSize(128, 128);
		MainBarrelEnd.mirror = true;
		setRotation(MainBarrelEnd, 0.3490659F, 0F, 0F);
		SecondBarrel = new ModelRenderer(this, 0, 101);
		SecondBarrel.addBox(-0.5F, -9.5F, 11F, 1, 1, 10);
		SecondBarrel.setRotationPoint(0F, 22F, 0F);
		SecondBarrel.setTextureSize(128, 128);
		SecondBarrel.mirror = true;
		setRotation(SecondBarrel, 0.3490659F, 0F, 0F);
		SightBase = new ModelRenderer(this, 0, 113);
		SightBase.addBox(-3F, -13F, 0F, 2, 2, 12);
		SightBase.setRotationPoint(0F, 22F, 0F);
		SightBase.setTextureSize(128, 128);
		SightBase.mirror = true;
		setRotation(SightBase, 0.3490659F, 0F, 0F);
		BackThing = new ModelRenderer(this, 33, 28);
		BackThing.addBox(-1F, -11F, -8F, 2, 2, 10);
		BackThing.setRotationPoint(0F, 22F, 0F);
		BackThing.setTextureSize(128, 128);
		BackThing.mirror = true;
		setRotation(BackThing, 0.3490659F, 0F, 0F);
		Sight = new ModelRenderer(this, 19, 71);
		Sight.addBox(-2.5F, -14F, 2F, 1, 1, 5);
		Sight.setRotationPoint(0F, 22F, 0F);
		Sight.setTextureSize(128, 128);
		Sight.mirror = true;
		setRotation(Sight, 0.3490659F, 0F, 0F);
		SideThingExtra = new ModelRenderer(this, 33, 41);
		SideThingExtra.addBox(4F, -8.5F, -4.5F, 2, 2, 2);
		SideThingExtra.setRotationPoint(0F, 22F, 0F);
		SideThingExtra.setTextureSize(128, 128);
		SideThingExtra.mirror = true;
		setRotation(SideThingExtra, 0F, 0F, 0F);
		Chair_Back = new ModelRenderer(this, 58, 28);
		Chair_Back.addBox(-2F, -15F, -16F, 4, 6, 1);
		Chair_Back.setRotationPoint(0F, 22F, 0F);
		Chair_Back.setTextureSize(128, 128);
		Chair_Back.mirror = true;
		setRotation(Chair_Back, 0.3490659F, 0F, 0F);
		Crossbar = new ModelRenderer(this, 42, 41);
		Crossbar.addBox(-4F, -8F, -7F, 8, 1, 1);
		Crossbar.setRotationPoint(0F, 22F, 0F);
		Crossbar.setTextureSize(128, 128);
		Crossbar.mirror = true;
		setRotation(Crossbar, 0F, 0F, 0F);
		ChairBottom = new ModelRenderer(this, 32, 71);
		ChairBottom.addBox(-2F, -10F, -16F, 4, 1, 4);
		ChairBottom.setRotationPoint(0F, 22F, 0F);
		ChairBottom.setTextureSize(128, 128);
		ChairBottom.mirror = true;
		setRotation(ChairBottom, 0.3490659F, 0F, 0F);
		ChairSupportRight = new ModelRenderer(this, 23, 78);
		ChairSupportRight.addBox(4F, -9.5F, -16F, 1, 1, 13);
		ChairSupportRight.setRotationPoint(0F, 22F, 0F);
		ChairSupportRight.setTextureSize(128, 128);
		ChairSupportRight.mirror = true;
		setRotation(ChairSupportRight, 0.3141593F, 0.122173F, 0F);
		ChairSupportLeft = new ModelRenderer(this, 23, 93);
		ChairSupportLeft.addBox(-5F, -9.5F, -16F, 1, 1, 13);
		ChairSupportLeft.setRotationPoint(0F, 22F, 0F);
		ChairSupportLeft.setTextureSize(128, 128);
		ChairSupportLeft.mirror = true;
		setRotation(ChairSupportLeft, 0.3141593F, -0.122173F, 0F);
		ChairSupportLeft.mirror = false;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base.render(f5);
		UpperBase.render(f5);
		MainBody.render(f5);
		SideThing.render(f5);
		MainBarrel.render(f5);
		MainBarrelEnd.render(f5);
		SecondBarrel.render(f5);
		SightBase.render(f5);
		BackThing.render(f5);
		Sight.render(f5);
		SideThingExtra.render(f5);
		Chair_Back.render(f5);
		Crossbar.render(f5);
		ChairBottom.render(f5);
		ChairSupportRight.render(f5);
		ChairSupportLeft.render(f5);
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
