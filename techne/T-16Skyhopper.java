package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * T-16 Skyhopper - Weaston
 * Created using Tabula 4.1.1
 */
public class T-16Skyhopper extends ModelBase {
    public ModelRenderer MainParent;
    public ModelRenderer shape1actual;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer WingLParent;
    public ModelRenderer WingRParent;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape13;
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
    public ModelRenderer WingL1;
    public ModelRenderer WingL2;
    public ModelRenderer WingL3;
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;

    public T-16Skyhopper() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape3 = new ModelRenderer(this, 124, 0);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(-1.0F, -61.85F, -11.75F, 2, 53, 6, 0.0F);
        this.setRotateAngle(shape3, -0.20943951023931953F, 0.0F, 0.0F);
        this.shape25 = new ModelRenderer(this, 176, 160);
        this.shape25.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape25.addBox(-1.5F, 1.5F, -13.43F, 3, 3, 5, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_2.addBox(-0.99F, -1.35F, -2.0F, 2, 20, 5, 0.0F);
        this.shape17 = new ModelRenderer(this, 374, 80);
        this.shape17.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.shape17.addBox(-9.0F, -10.4F, -3.43F, 18, 3, 9, 0.0F);
        this.shape1actual = new ModelRenderer(this, 80, 0);
        this.shape1actual.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1actual.addBox(-1.0F, -72.0F, 1.5F, 2, 36, 6, 0.0F);
        this.WingL3 = new ModelRenderer(this, 306, 0);
        this.WingL3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingL3.addBox(-0.99F, -1.35F, -2.0F, 2, 20, 5, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-0.99F, -1.75F, -5.53F, 2, 43, 4, 0.0F);
        this.setRotateAngle(shape1, 0.16929693744344995F, 0.0F, 0.0F);
        this.shape15 = new ModelRenderer(this, 310, 80);
        this.shape15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape15.addBox(-0.6F, -18.7F, -3.4F, 2, 6, 10, 0.0F);
        this.setRotateAngle(shape15, 0.0F, 0.0F, 0.4886921905584123F);
        this.MainParent = new ModelRenderer(this, 0, 200);
        this.MainParent.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.MainParent.addBox(-1.5F, -36.0F, -7.4F, 3, 3, 16, 0.0F);
        this.shape6 = new ModelRenderer(this, 208, 0);
        this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape6.addBox(-1.0F, -11.4F, -11.43F, 2, 3, 19, 0.0F);
        this.shape11 = new ModelRenderer(this, 194, 80);
        this.shape11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape11.addBox(-8.6F, -24.4F, -3.4F, 2, 16, 10, 0.0F);
        this.setRotateAngle(shape11, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape10 = new ModelRenderer(this, 164, 80);
        this.shape10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape10.addBox(-10.6F, -25.4F, -3.4F, 2, 18, 10, 0.0F);
        this.setRotateAngle(shape10, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape20 = new ModelRenderer(this, 46, 160);
        this.shape20.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape20.addBox(4.5F, -15.4F, 4.57F, 3, 3, 4, 0.0F);
        this.WingL2 = new ModelRenderer(this, 290, 0);
        this.WingL2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingL2.addBox(-0.99F, -1.35F, 1.5F, 2, 43, 4, 0.0F);
        this.shape5 = new ModelRenderer(this, 176, 0);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-16.6F, -29.4F, -3.5F, 2, 26, 11, 0.0F);
        this.setRotateAngle(shape5, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape23 = new ModelRenderer(this, 104, 160);
        this.shape23.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.shape23.addBox(-4.0F, 0.6F, -2.43F, 8, 5, 7, 0.0F);
        this.shape21 = new ModelRenderer(this, 68, 160);
        this.shape21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape21.addBox(-7.5F, -15.4F, 4.57F, 3, 3, 4, 0.0F);
        this.shape12 = new ModelRenderer(this, 224, 80);
        this.shape12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape12.addBox(-6.6F, -22.4F, -3.4F, 2, 13, 10, 0.0F);
        this.setRotateAngle(shape12, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape24 = new ModelRenderer(this, 134, 160);
        this.shape24.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape24.addBox(-1.0F, 2.0F, -18.43F, 2, 2, 20, 0.0F);
        this.WingRParent = new ModelRenderer(this, 0, 80);
        this.WingRParent.setRotationPoint(-12.0F, -11.05F, 2.0F);
        this.WingRParent.addBox(-0.99F, -0.2F, 1.7F, 2, 42, 4, 0.0F);
        this.setRotateAngle(WingRParent, 0.0F, 0.0F, 1.0122909661567112F);
        this.shape7 = new ModelRenderer(this, 20, 80);
        this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape7.addBox(-12.0F, -11.9F, -3.43F, 24, 2, 11, 0.0F);
        this.shape22 = new ModelRenderer(this, 90, 160);
        this.shape22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape22.addBox(-1.0F, -11.4F, 0.57F, 2, 14, 2, 0.0F);
        this.shape2 = new ModelRenderer(this, 102, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-1.0F, -70.75F, -13.55F, 2, 62, 6, 0.0F);
        this.setRotateAngle(shape2, -0.20943951023931953F, 0.0F, 0.0F);
        this.shape16 = new ModelRenderer(this, 340, 80);
        this.shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape16.addBox(1.4F, -17.4F, -3.4F, 2, 4, 10, 0.0F);
        this.setRotateAngle(shape16, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape9 = new ModelRenderer(this, 132, 80);
        this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9.addBox(-12.6F, -26.4F, -3.4F, 2, 20, 10, 0.0F);
        this.setRotateAngle(shape9, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape18 = new ModelRenderer(this, 0, 160);
        this.shape18.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape18.addBox(-3.0F, -22.4F, 5.57F, 6, 6, 4, 0.0F);
        this.WingL1 = new ModelRenderer(this, 272, 0);
        this.WingL1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.WingL1.addBox(-0.99F, -1.75F, -5.53F, 2, 43, 4, 0.0F);
        this.setRotateAngle(WingL1, 0.16929693744344995F, 0.0F, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_1.addBox(-0.99F, -1.35F, 1.5F, 2, 43, 4, 0.0F);
        this.WingLParent = new ModelRenderer(this, 256, 0);
        this.WingLParent.setRotationPoint(12.2F, -10.5F, 2.0F);
        this.WingLParent.addBox(-0.99F, -0.4F, 1.7F, 2, 42, 4, 0.0F);
        this.setRotateAngle(WingLParent, 0.0F, 0.0F, -1.0122909661567112F);
        this.shape8 = new ModelRenderer(this, 100, 80);
        this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape8.addBox(-14.6F, -27.4F, -3.4F, 2, 22, 10, 0.0F);
        this.setRotateAngle(shape8, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape14 = new ModelRenderer(this, 282, 80);
        this.shape14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape14.addBox(-2.6F, -20.4F, -3.4F, 2, 9, 10, 0.0F);
        this.setRotateAngle(shape14, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape4 = new ModelRenderer(this, 144, 0);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(14.6F, -29.4F, -3.5F, 2, 26, 11, 0.0F);
        this.setRotateAngle(shape4, 0.0F, 0.0F, -0.4886921905584123F);
        this.shape13 = new ModelRenderer(this, 254, 80);
        this.shape13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape13.addBox(-4.6F, -21.4F, -3.4F, 2, 11, 10, 0.0F);
        this.setRotateAngle(shape13, 0.0F, 0.0F, 0.4886921905584123F);
        this.shape19 = new ModelRenderer(this, 26, 160);
        this.shape19.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape19.addBox(-1.5F, -27.4F, 4.57F, 3, 3, 4, 0.0F);
        this.MainParent.addChild(this.shape3);
        this.MainParent.addChild(this.shape25);
        this.WingRParent.addChild(this.shape1_2);
        this.MainParent.addChild(this.shape17);
        this.MainParent.addChild(this.shape1actual);
        this.WingLParent.addChild(this.WingL3);
        this.WingRParent.addChild(this.shape1);
        this.MainParent.addChild(this.shape15);
        this.MainParent.addChild(this.shape6);
        this.MainParent.addChild(this.shape11);
        this.MainParent.addChild(this.shape10);
        this.MainParent.addChild(this.shape20);
        this.WingLParent.addChild(this.WingL2);
        this.MainParent.addChild(this.shape5);
        this.MainParent.addChild(this.shape23);
        this.MainParent.addChild(this.shape21);
        this.MainParent.addChild(this.shape12);
        this.MainParent.addChild(this.shape24);
        this.MainParent.addChild(this.WingRParent);
        this.MainParent.addChild(this.shape7);
        this.MainParent.addChild(this.shape22);
        this.MainParent.addChild(this.shape2);
        this.MainParent.addChild(this.shape16);
        this.MainParent.addChild(this.shape9);
        this.MainParent.addChild(this.shape18);
        this.WingLParent.addChild(this.WingL1);
        this.WingRParent.addChild(this.shape1_1);
        this.MainParent.addChild(this.WingLParent);
        this.MainParent.addChild(this.shape8);
        this.MainParent.addChild(this.shape14);
        this.MainParent.addChild(this.shape4);
        this.MainParent.addChild(this.shape13);
        this.MainParent.addChild(this.shape19);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.MainParent.render(f5);
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
