package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ScootEmAround - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelScootEmAround extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape1_6;
    public ModelRenderer shape1_7;
    public ModelRenderer shape1_8;
    public ModelRenderer shape1_9;
    public ModelRenderer Light1;
    public ModelRenderer Light2;
    public ModelRenderer shape1_10;
    public ModelRenderer shape1_11;
    public ModelRenderer shape1_12;
    public ModelRenderer shape1_13;
    public ModelRenderer shape1_14;
    public ModelRenderer shape1_15;
    public ModelRenderer shape1_16;
    public ModelRenderer shape1_17;
    public ModelRenderer shape1_18;
    public ModelRenderer shape1_19;
    public ModelRenderer shape1_20;

    public ModelScootEmAround() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape1_8 = new ModelRenderer(this, 132, 0);
        this.shape1_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_8.addBox(5.5F, -8.5F, -29.2F, 3, 8, 2, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 75);
        this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_1.addBox(5.0F, -9.0F, -28.0F, 4, 13, 56, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 151);
        this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_2.addBox(-9.0F, -9.0F, -28.0F, 4, 13, 56, 0.0F);
        this.shape1_9 = new ModelRenderer(this, 158, 0);
        this.shape1_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_9.addBox(-8.5F, -8.5F, -29.2F, 3, 8, 2, 0.0F);
        this.shape1_19 = new ModelRenderer(this, 35, 0);
        this.shape1_19.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_19.addBox(-8.5F, -8.5F, 26.8F, 3, 8, 2, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.shape1.addBox(-5.0F, -1.5F, -29.5F, 10, 2, 55, 0.0F);
        this.shape1_10 = new ModelRenderer(this, 140, 70);
        this.shape1_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_10.addBox(6.0F, 3.7F, -27.0F, 5, 1, 54, 0.0F);
        this.shape1_12 = new ModelRenderer(this, 214, 0);
        this.shape1_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_12.addBox(-5.0F, -11.5F, -14.2F, 10, 5, 22, 0.0F);
        this.shape1_14 = new ModelRenderer(this, 0, 100);
        this.shape1_14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_14.addBox(-4.0F, -10.5F, 3.0F, 8, 4, 9, 0.0F);
        this.shape1_17 = new ModelRenderer(this, 0, 34);
        this.shape1_17.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_17.addBox(4.0F, -15.5F, -23.2F, 1, 1, 8, 0.0F);
        this.shape1_20 = new ModelRenderer(this, 0, 0);
        this.shape1_20.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_20.addBox(-4.5F, -6.5F, 26.8F, 9, 8, 2, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 0, 230);
        this.shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_3.addBox(9.0F, -1.0F, -28.0F, 3, 5, 56, 0.0F);
        this.shape1_11 = new ModelRenderer(this, 142, 154);
        this.shape1_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_11.addBox(-11.0F, 3.7F, -27.0F, 5, 1, 54, 0.0F);
        this.shape1_15 = new ModelRenderer(this, 0, 156);
        this.shape1_15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_15.addBox(-5.0F, -15.5F, -15.2F, 10, 16, 1, 0.0F);
        this.shape1_4 = new ModelRenderer(this, 0, 303);
        this.shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_4.addBox(4.85F, 5.9F, -28.0F, 2, 4, 56, 0.0F);
        this.setRotateAngle(shape1_4, 0.0F, 0.0F, -1.0471975511965976F);
        this.shape1_13 = new ModelRenderer(this, 0, 70);
        this.shape1_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_13.addBox(-5.0F, -7.5F, 7.8F, 10, 5, 16, 0.0F);
        this.shape1_7 = new ModelRenderer(this, 94, 0);
        this.shape1_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_7.addBox(-5.0F, -9.0F, 24.0F, 10, 13, 4, 0.0F);
        this.shape1_6 = new ModelRenderer(this, 142, 0);
        this.shape1_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_6.addBox(-6.85F, 5.9F, -28.0F, 2, 4, 56, 0.0F);
        this.setRotateAngle(shape1_6, 0.0F, 0.0F, 1.0471975511965976F);
        this.shape1_16 = new ModelRenderer(this, 0, 182);
        this.shape1_16.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_16.addBox(-5.0F, -15.5F, -23.2F, 1, 1, 8, 0.0F);
        this.Light1 = new ModelRenderer(this, 272, 0);
        this.Light1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Light1.addBox(8.5F, 0.8F, -28.5F, 2, 2, 57, 0.0F);
        this.shape1_18 = new ModelRenderer(this, 30, 33);
        this.shape1_18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_18.addBox(5.5F, -8.5F, 26.8F, 3, 8, 2, 0.0F);
        this.shape1_5 = new ModelRenderer(this, 0, 378);
        this.shape1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_5.addBox(-12.0F, -1.0F, -28.0F, 3, 5, 56, 0.0F);
        this.Light2 = new ModelRenderer(this, 272, 0);
        this.Light2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Light2.addBox(-10.5F, 0.8F, -28.5F, 2, 2, 57, 0.0F);
        this.shape1.addChild(this.shape1_8);
        this.shape1.addChild(this.shape1_1);
        this.shape1.addChild(this.shape1_2);
        this.shape1.addChild(this.shape1_9);
        this.shape1.addChild(this.shape1_19);
        this.shape1.addChild(this.shape1_10);
        this.shape1.addChild(this.shape1_12);
        this.shape1.addChild(this.shape1_14);
        this.shape1.addChild(this.shape1_17);
        this.shape1.addChild(this.shape1_20);
        this.shape1.addChild(this.shape1_3);
        this.shape1.addChild(this.shape1_11);
        this.shape1.addChild(this.shape1_15);
        this.shape1.addChild(this.shape1_4);
        this.shape1.addChild(this.shape1_13);
        this.shape1.addChild(this.shape1_7);
        this.shape1.addChild(this.shape1_6);
        this.shape1.addChild(this.shape1_16);
        this.shape1.addChild(this.Light1);
        this.shape1.addChild(this.shape1_18);
        this.shape1.addChild(this.shape1_5);
        this.shape1.addChild(this.Light2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
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
