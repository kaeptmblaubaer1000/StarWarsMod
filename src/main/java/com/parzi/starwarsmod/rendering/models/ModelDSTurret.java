package com.parzi.starwarsmod.rendering.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDSTurret extends ModelBase
{
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
		this.textureWidth = 128;
		this.textureHeight = 128;
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.addBox(-7.0F, 0.0F, -13.0F, 14, 2, 24);
		this.Base.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Base.setTextureSize(128, 128);
		this.Base.mirror = true;
		this.setRotation(this.Base, 0.0F, 0.0F, 0.0F);
		this.UpperBase = new ModelRenderer(this, 0, 28);
		this.UpperBase.addBox(-4.0F, -9.0F, -4.0F, 8, 9, 8);
		this.UpperBase.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.UpperBase.setTextureSize(128, 128);
		this.UpperBase.mirror = true;
		this.setRotation(this.UpperBase, 0.0F, 0.0F, 0.0F);
		this.MainBody = new ModelRenderer(this, 0, 46);
		this.MainBody.addBox(-2.0F, -12.0F, -5.0F, 4, 4, 20);
		this.MainBody.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.MainBody.setTextureSize(128, 128);
		this.MainBody.mirror = true;
		this.setRotation(this.MainBody, 0.3490659F, 0.0F, 0.0F);
		this.SideThing = new ModelRenderer(this, 0, 71);
		this.SideThing.addBox(0.0F, -9.5F, -5.5F, 5, 4, 4);
		this.SideThing.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.SideThing.setTextureSize(128, 128);
		this.SideThing.mirror = true;
		this.setRotation(this.SideThing, 0.0F, 0.0F, 0.0F);
		this.MainBarrel = new ModelRenderer(this, 0, 80);
		this.MainBarrel.addBox(-0.5F, -11.5F, 15.0F, 1, 1, 10);
		this.MainBarrel.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.MainBarrel.setTextureSize(128, 128);
		this.MainBarrel.mirror = true;
		this.setRotation(this.MainBarrel, 0.3490659F, 0.0F, 0.0F);
		this.MainBarrelEnd = new ModelRenderer(this, 0, 92);
		this.MainBarrelEnd.addBox(-1.0F, -12.0F, 25.0F, 2, 2, 6);
		this.MainBarrelEnd.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.MainBarrelEnd.setTextureSize(128, 128);
		this.MainBarrelEnd.mirror = true;
		this.setRotation(this.MainBarrelEnd, 0.3490659F, 0.0F, 0.0F);
		this.SecondBarrel = new ModelRenderer(this, 0, 101);
		this.SecondBarrel.addBox(-0.5F, -9.5F, 11.0F, 1, 1, 10);
		this.SecondBarrel.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.SecondBarrel.setTextureSize(128, 128);
		this.SecondBarrel.mirror = true;
		this.setRotation(this.SecondBarrel, 0.3490659F, 0.0F, 0.0F);
		this.SightBase = new ModelRenderer(this, 0, 113);
		this.SightBase.addBox(-3.0F, -13.0F, 0.0F, 2, 2, 12);
		this.SightBase.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.SightBase.setTextureSize(128, 128);
		this.SightBase.mirror = true;
		this.setRotation(this.SightBase, 0.3490659F, 0.0F, 0.0F);
		this.BackThing = new ModelRenderer(this, 33, 28);
		this.BackThing.addBox(-1.0F, -11.0F, -8.0F, 2, 2, 10);
		this.BackThing.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.BackThing.setTextureSize(128, 128);
		this.BackThing.mirror = true;
		this.setRotation(this.BackThing, 0.3490659F, 0.0F, 0.0F);
		this.Sight = new ModelRenderer(this, 19, 71);
		this.Sight.addBox(-2.5F, -14.0F, 2.0F, 1, 1, 5);
		this.Sight.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Sight.setTextureSize(128, 128);
		this.Sight.mirror = true;
		this.setRotation(this.Sight, 0.3490659F, 0.0F, 0.0F);
		this.SideThingExtra = new ModelRenderer(this, 33, 41);
		this.SideThingExtra.addBox(4.0F, -8.5F, -4.5F, 2, 2, 2);
		this.SideThingExtra.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.SideThingExtra.setTextureSize(128, 128);
		this.SideThingExtra.mirror = true;
		this.setRotation(this.SideThingExtra, 0.0F, 0.0F, 0.0F);
		this.Chair_Back = new ModelRenderer(this, 58, 28);
		this.Chair_Back.addBox(-2.0F, -15.0F, -16.0F, 4, 6, 1);
		this.Chair_Back.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Chair_Back.setTextureSize(128, 128);
		this.Chair_Back.mirror = true;
		this.setRotation(this.Chair_Back, 0.3490659F, 0.0F, 0.0F);
		this.Crossbar = new ModelRenderer(this, 42, 41);
		this.Crossbar.addBox(-4.0F, -8.0F, -7.0F, 8, 1, 1);
		this.Crossbar.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.Crossbar.setTextureSize(128, 128);
		this.Crossbar.mirror = true;
		this.setRotation(this.Crossbar, 0.0F, 0.0F, 0.0F);
		this.ChairBottom = new ModelRenderer(this, 32, 71);
		this.ChairBottom.addBox(-2.0F, -10.0F, -16.0F, 4, 1, 4);
		this.ChairBottom.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ChairBottom.setTextureSize(128, 128);
		this.ChairBottom.mirror = true;
		this.setRotation(this.ChairBottom, 0.3490659F, 0.0F, 0.0F);
		this.ChairSupportRight = new ModelRenderer(this, 23, 78);
		this.ChairSupportRight.addBox(4.0F, -9.5F, -16.0F, 1, 1, 13);
		this.ChairSupportRight.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ChairSupportRight.setTextureSize(128, 128);
		this.ChairSupportRight.mirror = true;
		this.setRotation(this.ChairSupportRight, 0.3141593F, 0.122173F, 0.0F);
		this.ChairSupportLeft = new ModelRenderer(this, 23, 93);
		this.ChairSupportLeft.addBox(-5.0F, -9.5F, -16.0F, 1, 1, 13);
		this.ChairSupportLeft.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.ChairSupportLeft.setTextureSize(128, 128);
		this.ChairSupportLeft.mirror = true;
		this.setRotation(this.ChairSupportLeft, 0.3141593F, -0.122173F, 0.0F);
		this.ChairSupportLeft.mirror = false;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Base.render(f5);
		this.UpperBase.render(f5);
		this.MainBody.render(f5);
		this.SideThing.render(f5);
		this.MainBarrel.render(f5);
		this.MainBarrelEnd.render(f5);
		this.SecondBarrel.render(f5);
		this.SightBase.render(f5);
		this.BackThing.render(f5);
		this.Sight.render(f5);
		this.SideThingExtra.render(f5);
		this.Chair_Back.render(f5);
		this.Crossbar.render(f5);
		this.ChairBottom.render(f5);
		this.ChairSupportRight.render(f5);
		this.ChairSupportLeft.render(f5);
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
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\models\ModelDSTurret.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */