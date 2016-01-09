package com.parzi.starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelDSTurret - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelDSTurret extends ModelBase {
    public ModelRenderer Base;
    public ModelRenderer UpperBase;
    public ModelRenderer MainBody;
    public ModelRenderer SideThing;
    public ModelRenderer Sight;
    public ModelRenderer SightBase;
    public ModelRenderer MainBarrel;
    public ModelRenderer SecondBarrel;
    public ModelRenderer BackThing;
    public ModelRenderer Crossbar;
    public ModelRenderer ChairSupportLeft;
    public ModelRenderer ChairSupportRight;
    public ModelRenderer ChairBottom;
    public ModelRenderer Chair_Back;
    public ModelRenderer MainBarrelEnd;
    public ModelRenderer SideThingExtra;

    public ModelDSTurret() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.UpperBase = new ModelRenderer(this, 0, 28);
        this.UpperBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.UpperBase.addBox(-4.0F, -9.0F, -4.0F, 8, 9, 8, 0.0F);
        this.Crossbar = new ModelRenderer(this, 42, 41);
        this.Crossbar.setRotationPoint(0.0F, -2.0F, 3.0F);
        this.Crossbar.addBox(-4.0F, -8.0F, -7.0F, 8, 1, 1, 0.0F);
        this.Base = new ModelRenderer(this, 0, 0);
        this.Base.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.Base.addBox(-7.0F, 0.0F, -13.0F, 14, 2, 24, 0.0F);
        this.Sight = new ModelRenderer(this, 19, 71);
        this.Sight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Sight.addBox(-2.5F, -14.0F, 2.0F, 1, 1, 5, 0.0F);
        this.Chair_Back = new ModelRenderer(this, 58, 28);
        this.Chair_Back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chair_Back.addBox(-2.0F, -15.0F, -16.0F, 4, 6, 1, 0.0F);
        this.MainBarrel = new ModelRenderer(this, 0, 80);
        this.MainBarrel.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MainBarrel.addBox(-0.5F, -11.5F, 15.0F, 1, 1, 10, 0.0F);
        this.ChairSupportRight = new ModelRenderer(this, 23, 78);
        this.ChairSupportRight.setRotationPoint(-0.5F, -0.5F, 0.0F);
        this.ChairSupportRight.addBox(4.0F, -9.5F, -16.0F, 1, 1, 13, 0.0F);
        this.setRotateAngle(ChairSupportRight, 0.0F, 0.12217304763960307F, 0.0F);
        this.SecondBarrel = new ModelRenderer(this, 0, 101);
        this.SecondBarrel.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SecondBarrel.addBox(-0.5F, -9.5F, 11.0F, 1, 1, 10, 0.0F);
        this.SightBase = new ModelRenderer(this, 0, 113);
        this.SightBase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SightBase.addBox(-3.0F, -13.0F, 0.0F, 2, 2, 12, 0.0F);
        this.MainBody = new ModelRenderer(this, 0, 46);
        this.MainBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MainBody.addBox(-2.0F, -12.0F, -5.0F, 4, 4, 20, 0.0F);
        this.ChairSupportLeft = new ModelRenderer(this, 23, 93);
        this.ChairSupportLeft.setRotationPoint(0.5F, -0.5F, 0.0F);
        this.ChairSupportLeft.addBox(-5.0F, -9.5F, -16.0F, 1, 1, 13, 0.0F);
        this.setRotateAngle(ChairSupportLeft, 0.0F, -0.12217304763960307F, 0.0F);
        this.SideThing = new ModelRenderer(this, 0, 71);
        this.SideThing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SideThing.addBox(0.0F, -9.5F, -5.5F, 5, 4, 4, 0.0F);
        this.ChairBottom = new ModelRenderer(this, 32, 71);
        this.ChairBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ChairBottom.addBox(-2.0F, -10.0F, -16.0F, 4, 1, 4, 0.0F);
        this.BackThing = new ModelRenderer(this, 33, 28);
        this.BackThing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackThing.addBox(-1.0F, -11.0F, -8.0F, 2, 2, 10, 0.0F);
        this.MainBarrelEnd = new ModelRenderer(this, 0, 92);
        this.MainBarrelEnd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MainBarrelEnd.addBox(-1.0F, -12.0F, 25.0F, 2, 2, 6, 0.0F);
        this.SideThingExtra = new ModelRenderer(this, 33, 41);
        this.SideThingExtra.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SideThingExtra.addBox(4.0F, -8.5F, -4.5F, 2, 2, 2, 0.0F);
        this.Base.addChild(this.UpperBase);
        this.MainBody.addChild(this.Crossbar);
        this.MainBody.addChild(this.Sight);
        this.MainBody.addChild(this.Chair_Back);
        this.MainBody.addChild(this.MainBarrel);
        this.MainBody.addChild(this.ChairSupportRight);
        this.MainBody.addChild(this.SecondBarrel);
        this.MainBody.addChild(this.SightBase);
        this.UpperBase.addChild(this.MainBody);
        this.MainBody.addChild(this.ChairSupportLeft);
        this.UpperBase.addChild(this.SideThing);
        this.MainBody.addChild(this.ChairBottom);
        this.MainBody.addChild(this.BackThing);
        this.MainBarrel.addChild(this.MainBarrelEnd);
        this.SideThing.addChild(this.SideThingExtra);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Base.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
