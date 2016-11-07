package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Arena Door - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelArenaDoor extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape13;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape14;
    public ModelRenderer shape15;
    public ModelRenderer shape16;
    public ModelRenderer shape17;
    public ModelRenderer shape18;
    public ModelRenderer shape19;
    public ModelRenderer shape20;
    public ModelRenderer shape21;
    public ModelRenderer shape22;
    public ModelRenderer shape23;
    public ModelRenderer shape24;
    public ModelRenderer shape25;
    public ModelRenderer shape26;
    public ModelRenderer shape27;

    public ModelArenaDoor() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape18 = new ModelRenderer(this, 202, 61);
        this.shape18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape18.addBox(-56.0F, -11.0F, -2.0F, 96, 4, 4, 0.0F);
        this.shape22 = new ModelRenderer(this, 202, 71);
        this.shape22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape22.addBox(-56.0F, -43.0F, -2.0F, 96, 4, 4, 0.0F);
        this.shape13 = new ModelRenderer(this, 0, 51);
        this.shape13.setRotationPoint(-32.0F, -16.0F, 0.0F);
        this.shape13.addBox(-56.0F, -73.6F, -2.0F, 96, 4, 4, 0.0F);
        this.setRotateAngle(shape13, 0.0F, 0.0F, 1.5707963267948966F);
        this.shape12 = new ModelRenderer(this, 232, 43);
        this.shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape12.addBox(-56.0F, -64.5F, -1.5F, 112, 3, 3, 0.0F);
        this.shape6 = new ModelRenderer(this, 0, 35);
        this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape6.addBox(-56.0F, -17.5F, -1.5F, 112, 3, 3, 0.0F);
        this.shape4 = new ModelRenderer(this, 232, 27);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(-56.0F, -1.5F, -1.5F, 112, 3, 3, 0.0F);
        this.shape16 = new ModelRenderer(this, 0, 61);
        this.shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape16.addBox(-56.0F, 5.0F, -2.0F, 96, 4, 4, 0.0F);
        this.shape10 = new ModelRenderer(this, 0, 43);
        this.shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape10.addBox(-56.0F, -49.0F, -1.5F, 112, 3, 3, 0.0F);
        this.shape15 = new ModelRenderer(this, 0, 91);
        this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape15.addBox(-56.0F, 13.5F, -1.5F, 96, 3, 3, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-56.0F, -72.0F, -2.0F, 112, 3, 4, 0.0F);
        this.shape14 = new ModelRenderer(this, 202, 51);
        this.shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape14.addBox(-56.0F, 21.0F, -2.0F, 96, 3, 4, 0.0F);
        this.shape7 = new ModelRenderer(this, 234, 9);
        this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape7.addBox(-56.0F, -25.5F, -2.0F, 112, 3, 4, 0.0F);
        this.shape27 = new ModelRenderer(this, 202, 81);
        this.shape27.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape27.addBox(-56.0F, -88.0F, -2.0F, 96, 3, 4, 0.0F);
        this.shape2 = new ModelRenderer(this, 0, 27);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-56.0F, 14.5F, -1.5F, 112, 3, 3, 0.0F);
        this.shape3 = new ModelRenderer(this, 234, 0);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(-56.0F, 6.5F, -2.0F, 112, 3, 4, 0.0F);
        this.shape11 = new ModelRenderer(this, 234, 18);
        this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape11.addBox(-56.0F, -56.8F, -2.0F, 112, 3, 4, 0.0F);
        this.shape21 = new ModelRenderer(this, 200, 99);
        this.shape21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape21.addBox(-56.0F, -34.5F, -1.5F, 96, 3, 3, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 9);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-56.0F, -9.5F, -2.0F, 112, 3, 4, 0.0F);
        this.shape26 = new ModelRenderer(this, 0, 115);
        this.shape26.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape26.addBox(-56.0F, -80.6F, -1.5F, 96, 3, 3, 0.0F);
        this.shape24 = new ModelRenderer(this, 0, 81);
        this.shape24.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape24.addBox(-56.0F, -58.5F, -2.0F, 96, 4, 4, 0.0F);
        this.shape23 = new ModelRenderer(this, 0, 107);
        this.shape23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape23.addBox(-56.0F, -50.5F, -1.5F, 96, 3, 3, 0.0F);
        this.shape20 = new ModelRenderer(this, 0, 71);
        this.shape20.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape20.addBox(-56.0F, -27.0F, -2.0F, 96, 4, 4, 0.0F);
        this.shape8 = new ModelRenderer(this, 232, 35);
        this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape8.addBox(-56.0F, -33.5F, -1.5F, 112, 3, 3, 0.0F);
        this.shape19 = new ModelRenderer(this, 0, 99);
        this.shape19.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape19.addBox(-56.0F, -18.5F, -1.5F, 96, 3, 3, 0.0F);
        this.shape25 = new ModelRenderer(this, 200, 107);
        this.shape25.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape25.addBox(-56.0F, -65.4F, -1.5F, 96, 3, 3, 0.0F);
        this.shape17 = new ModelRenderer(this, 200, 91);
        this.shape17.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape17.addBox(-56.0F, -2.5F, -1.5F, 96, 3, 3, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 18);
        this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9.addBox(-56.0F, -41.5F, -2.0F, 112, 3, 4, 0.0F);
        this.shape13.addChild(this.shape18);
        this.shape13.addChild(this.shape22);
        this.shape1.addChild(this.shape12);
        this.shape1.addChild(this.shape6);
        this.shape1.addChild(this.shape4);
        this.shape13.addChild(this.shape16);
        this.shape1.addChild(this.shape10);
        this.shape13.addChild(this.shape15);
        this.shape13.addChild(this.shape14);
        this.shape1.addChild(this.shape7);
        this.shape13.addChild(this.shape27);
        this.shape1.addChild(this.shape2);
        this.shape1.addChild(this.shape3);
        this.shape1.addChild(this.shape11);
        this.shape13.addChild(this.shape21);
        this.shape1.addChild(this.shape5);
        this.shape13.addChild(this.shape26);
        this.shape13.addChild(this.shape24);
        this.shape13.addChild(this.shape23);
        this.shape13.addChild(this.shape20);
        this.shape1.addChild(this.shape8);
        this.shape13.addChild(this.shape19);
        this.shape13.addChild(this.shape25);
        this.shape13.addChild(this.shape17);
        this.shape1.addChild(this.shape9);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape13.render(f5);
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
