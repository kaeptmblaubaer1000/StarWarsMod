package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * HolotableMass - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelHolotableMass extends ModelBase {
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
    public ModelRenderer shape1_10;
    public ModelRenderer shape1_11;
    public ModelRenderer shape1_12;
    public ModelRenderer shape1_13;
    public ModelRenderer shape1_14;

    public ModelHolotableMass() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape1_9 = new ModelRenderer(this, 174, 0);
        this.shape1_9.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_9.addBox(-5.0F, -4.0F, -20.0F, 10, 5, 6, 0.0F);
        this.shape1_13 = new ModelRenderer(this, 108, 80);
        this.shape1_13.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.shape1_13.addBox(-17.0F, -4.0F, -2.0F, 34, 10, 4, 0.0F);
        this.shape1_12 = new ModelRenderer(this, 118, 50);
        this.shape1_12.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_12.addBox(13.5F, -4.0F, -5.0F, 6, 5, 10, 0.0F);
        this.shape1_8 = new ModelRenderer(this, 104, 0);
        this.shape1_8.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_8.addBox(-12.5F, -3.0F, 13.0F, 25, 5, 6, 0.0F);
        this.shape1_7 = new ModelRenderer(this, 0, 300);
        this.shape1_7.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_7.addBox(-12.5F, -3.0F, -19.0F, 25, 5, 6, 0.0F);
        this.shape1_11 = new ModelRenderer(this, 140, 18);
        this.shape1_11.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_11.addBox(-19.5F, -4.0F, -5.0F, 6, 5, 10, 0.0F);
        this.shape1_10 = new ModelRenderer(this, 102, 16);
        this.shape1_10.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_10.addBox(-5.0F, -4.0F, 14.0F, 10, 5, 6, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 100);
        this.shape1_2.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_2.addBox(10.0F, -1.0F, -18.0F, 8, 3, 36, 0.0F);
        this.shape1_5 = new ModelRenderer(this, 0, 190);
        this.shape1_5.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_5.addBox(12.5F, -3.0F, -19.0F, 6, 5, 38, 0.0F);
        this.shape1_14 = new ModelRenderer(this, 198, 0);
        this.shape1_14.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.shape1_14.addBox(-2.0F, -4.0F, -17.0F, 4, 10, 34, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 16.5F, 0.0F);
        this.shape1.addBox(-16.0F, -2.5F, -16.0F, 32, 10, 32, 0.0F);
        this.shape1_6 = new ModelRenderer(this, 0, 242);
        this.shape1_6.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_6.addBox(-18.5F, -3.0F, -19.0F, 6, 5, 38, 0.0F);
        this.shape1_4 = new ModelRenderer(this, 0, 172);
        this.shape1_4.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_4.addBox(-10.0F, -1.0F, 10.0F, 20, 3, 8, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 52);
        this.shape1_1.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_1.addBox(-18.0F, -1.0F, -18.0F, 8, 3, 36, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 0, 150);
        this.shape1_3.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.shape1_3.addBox(-10.0F, -1.0F, -18.0F, 20, 3, 8, 0.0F);
        this.shape1.addChild(this.shape1_9);
        this.shape1.addChild(this.shape1_13);
        this.shape1.addChild(this.shape1_12);
        this.shape1.addChild(this.shape1_8);
        this.shape1.addChild(this.shape1_7);
        this.shape1.addChild(this.shape1_11);
        this.shape1.addChild(this.shape1_10);
        this.shape1.addChild(this.shape1_2);
        this.shape1.addChild(this.shape1_5);
        this.shape1.addChild(this.shape1_14);
        this.shape1.addChild(this.shape1_6);
        this.shape1.addChild(this.shape1_4);
        this.shape1.addChild(this.shape1_1);
        this.shape1.addChild(this.shape1_3);
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
