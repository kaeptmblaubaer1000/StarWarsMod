package com.parzivail.pswm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * MB450 Macrobinoculars - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelBinocularsNew extends ModelBase
{
    public ModelRenderer shape1;
    public ModelRenderer shape4;
    public ModelRenderer shape4_1;
    public ModelRenderer shape4_2;
    public ModelRenderer shape4_3;
    public ModelRenderer shape4_4;
    public ModelRenderer shape4_5;
    public ModelRenderer shape4_6;
    public ModelRenderer shape4_7;
    public ModelRenderer shape4_8;
    public ModelRenderer shape4_9;
    public ModelRenderer shape4_10;
    public ModelRenderer shape4_11;
    public ModelRenderer shape4_12;
    public ModelRenderer shape4_13;
    public ModelRenderer shape4_14;
    public ModelRenderer shape4_15;
    public ModelRenderer shape4_16;
    public ModelRenderer shape4_17;
    public ModelRenderer shape4_18;
    public ModelRenderer shape4_19;
    public ModelRenderer shape4_20;
    public ModelRenderer shape4_21;
    public ModelRenderer shape4_22;
    public ModelRenderer shape4_23;
    public ModelRenderer shape4_24;
    public ModelRenderer shape4_25;
    public ModelRenderer shape4_26;
    public ModelRenderer shape4_27;
    public ModelRenderer shape4_28;
    public ModelRenderer shape4_29;
    public ModelRenderer shape4_30;
    public ModelRenderer shape4_31;
    public ModelRenderer shape4_32;
    public ModelRenderer shape4_33;
    public ModelRenderer shape4_34;

    public ModelBinocularsNew()
    {
	    this.textureWidth = 512;
	    this.textureHeight = 512;
	    this.shape4_26 = new ModelRenderer(this, 340, 0);
	    this.shape4_26.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_26.addBox(1.0F, 4.6F, -12.5F, 4, 4, 4, 0.0F);
	    this.shape4_27 = new ModelRenderer(this, 370, 0);
	    this.shape4_27.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_27.addBox(6.0F, 5.0F, -10.0F, 7, 10, 14, 0.0F);
	    this.shape4_9 = new ModelRenderer(this, 0, 252);
	    this.shape4_9.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_9.addBox(-17.0F, 5.5F, 1.5F, 10, 9, 2, 0.0F);
	    this.shape4_14 = new ModelRenderer(this, 0, 360);
	    this.shape4_14.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_14.addBox(-11.5F, 5.0F, -11.0F, 1, 10, 10, 0.0F);
	    this.shape4_5 = new ModelRenderer(this, 0, 148);
	    this.shape4_5.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_5.addBox(-14.0F, 4.0F, 6.0F, 2, 2, 3, 0.0F);
	    this.shape4 = new ModelRenderer(this, 0, 36);
	    this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4.addBox(-17.0F, 5.5F, 1.5F, 10, 2, 9, 0.0F);
	    this.shape4_34 = new ModelRenderer(this, 60, 134);
	    this.shape4_34.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_34.addBox(9.0F, 3.3F, -2.0F, 3, 3, 3, 0.0F);
	    this.shape4_24 = new ModelRenderer(this, 270, 0);
	    this.shape4_24.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_24.addBox(-5.5F, 10.1F, -13.3F, 11, 3, 4, 0.0F);
	    this.shape4_22 = new ModelRenderer(this, 190, 0);
	    this.shape4_22.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_22.addBox(-3.0F, 8.2F, 13.5F, 6, 6, 2, 0.0F);
	    this.shape4_1 = new ModelRenderer(this, 0, 57);
	    this.shape4_1.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_1.addBox(-17.0F, 5.5F, -10.5F, 10, 2, 9, 0.0F);
	    this.shape4_32 = new ModelRenderer(this, 60, 95);
	    this.shape4_32.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_32.addBox(11.5F, 7.0F, 2.0F, 7, 6, 2, 0.0F);
	    this.shape4_12 = new ModelRenderer(this, 0, 320);
	    this.shape4_12.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_12.addBox(-17.0F, 5.5F, -3.5F, 10, 9, 2, 0.0F);
	    this.shape4_33 = new ModelRenderer(this, 60, 115);
	    this.shape4_33.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_33.addBox(9.0F, 3.3F, -7.0F, 3, 3, 3, 0.0F);
	    this.shape4_10 = new ModelRenderer(this, 0, 274);
	    this.shape4_10.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_10.addBox(-17.0F, 5.5F, 8.5F, 10, 9, 2, 0.0F);
	    this.shape4_20 = new ModelRenderer(this, 123, 0);
	    this.shape4_20.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_20.addBox(-2.5F, 1.7F, 4.5F, 5, 4, 5, 0.0F);
	    this.shape4_31 = new ModelRenderer(this, 60, 76);
	    this.shape4_31.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_31.addBox(11.5F, 7.0F, -10.0F, 7, 6, 2, 0.0F);
	    this.shape1 = new ModelRenderer(this, 0, 0);
	    this.shape1.setRotationPoint(0.0F, 11.0F, 0.0F);
	    this.shape1.addBox(-4.0F, -4.0F, -6.0F, 8, 7, 12, 0.0F);
	    this.shape4_6 = new ModelRenderer(this, 0, 162);
	    this.shape4_6.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_6.addBox(-15.5F, 5.0F, -11.0F, 1, 10, 10, 0.0F);
	    this.shape4_4 = new ModelRenderer(this, 0, 132);
	    this.shape4_4.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_4.addBox(-14.0F, 4.0F, -6.0F, 2, 2, 3, 0.0F);
	    this.shape4_13 = new ModelRenderer(this, 0, 342);
	    this.shape4_13.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_13.addBox(-17.0F, 5.5F, -10.5F, 10, 9, 2, 0.0F);
	    this.shape4_8 = new ModelRenderer(this, 0, 228);
	    this.shape4_8.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_8.addBox(-17.0F, 12.5F, 1.5F, 10, 2, 9, 0.0F);
	    this.shape4_7 = new ModelRenderer(this, 0, 192);
	    this.shape4_7.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_7.addBox(-15.5F, 5.0F, 1.0F, 1, 10, 10, 0.0F);
	    this.shape4_25 = new ModelRenderer(this, 310, 0);
	    this.shape4_25.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_25.addBox(-5.0F, 4.6F, -12.5F, 4, 4, 4, 0.0F);
	    this.shape4_3 = new ModelRenderer(this, 0, 104);
	    this.shape4_3.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_3.addBox(-14.0F, 5.0F, 1.0F, 2, 10, 10, 0.0F);
	    this.shape4_17 = new ModelRenderer(this, 0, 450);
	    this.shape4_17.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_17.addBox(-10.0F, 5.0F, 1.0F, 1, 10, 10, 0.0F);
	    this.shape4_21 = new ModelRenderer(this, 153, 0);
	    this.shape4_21.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_21.addBox(-2.5F, 8.7F, 9.5F, 5, 5, 5, 0.0F);
	    this.shape4_18 = new ModelRenderer(this, 0, 480);
	    this.shape4_18.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_18.addBox(-7.0F, 2.3F, 3.7F, 14, 14, 9, 0.0F);
	    this.shape4_23 = new ModelRenderer(this, 220, 0);
	    this.shape4_23.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_23.addBox(-6.0F, 9.6F, -12.5F, 12, 4, 4, 0.0F);
	    this.shape4_29 = new ModelRenderer(this, 60, 26);
	    this.shape4_29.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_29.addBox(11.5F, 13.0F, -10.0F, 7, 2, 14, 0.0F);
	    this.shape4_2 = new ModelRenderer(this, 0, 76);
	    this.shape4_2.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_2.addBox(-14.0F, 5.0F, -11.0F, 2, 10, 10, 0.0F);
	    this.shape4_28 = new ModelRenderer(this, 430, 0);
	    this.shape4_28.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_28.addBox(7.0F, 4.0F, -11.0F, 6, 12, 16, 0.0F);
	    this.shape4_19 = new ModelRenderer(this, 56, 0);
	    this.shape4_19.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_19.addBox(-7.0F, 2.6F, -11.3F, 14, 1, 14, 0.0F);
	    this.shape4_16 = new ModelRenderer(this, 0, 420);
	    this.shape4_16.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_16.addBox(-11.5F, 5.0F, 1.0F, 1, 10, 10, 0.0F);
	    this.shape4_15 = new ModelRenderer(this, 0, 390);
	    this.shape4_15.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_15.addBox(-10.0F, 5.0F, -11.0F, 1, 10, 10, 0.0F);
	    this.shape4_11 = new ModelRenderer(this, 0, 296);
	    this.shape4_11.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_11.addBox(-17.0F, 12.5F, -10.5F, 10, 2, 9, 0.0F);
	    this.shape4_30 = new ModelRenderer(this, 60, 50);
	    this.shape4_30.setRotationPoint(0.0F, 0.0F, 0.0F);
	    this.shape4_30.addBox(13.0F, 5.0F, -10.0F, 8, 2, 14, 0.0F);
    }
	    @Override
	    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	    {
        this.shape4.addChild(this.shape4_26);
        this.shape4.addChild(this.shape4_27);
        this.shape4.addChild(this.shape4_9);
        this.shape4.addChild(this.shape4_14);
        this.shape4.addChild(this.shape4_5);
        this.shape4.addChild(this.shape4_34);
        this.shape4.addChild(this.shape4_24);
        this.shape4.addChild(this.shape4_22);
        this.shape4.addChild(this.shape4_1);
        this.shape4.addChild(this.shape4_32);
        this.shape4.addChild(this.shape4_12);
        this.shape4.addChild(this.shape4_33);
        this.shape4.addChild(this.shape4_10);
        this.shape4.addChild(this.shape4_20);
        this.shape4.addChild(this.shape4_31);
        this.shape4.addChild(this.shape4_6);
        this.shape4.addChild(this.shape4_4);
        this.shape4.addChild(this.shape4_13);
        this.shape4.addChild(this.shape4_8);
        this.shape4.addChild(this.shape4_7);
        this.shape4.addChild(this.shape4_25);
        this.shape4.addChild(this.shape4_3);
        this.shape4.addChild(this.shape4_17);
        this.shape4.addChild(this.shape4_21);
        this.shape4.addChild(this.shape4_18);
        this.shape4.addChild(this.shape4_23);
        this.shape4.addChild(this.shape4_29);
        this.shape4.addChild(this.shape4_2);
        this.shape4.addChild(this.shape4_28);
        this.shape4.addChild(this.shape4_19);
        this.shape4.addChild(this.shape4_16);
        this.shape4.addChild(this.shape4_15);
        this.shape4.addChild(this.shape4_11);
        this.shape4.addChild(this.shape4_30);
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
