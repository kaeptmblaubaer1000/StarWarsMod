package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Jedi Robes - Weaston
 * Created using Tabula 4.1.1
 */
public class JediStatue extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer BodyMain;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape1_6;
    public ModelRenderer shape1_7;
    public ModelRenderer Cape;
    public ModelRenderer HoodBack;
    public ModelRenderer HoodTop;
    public ModelRenderer HoodL;
    public ModelRenderer HoodR;

    public JediStatue() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.HoodBack = new ModelRenderer(this, 62, 0);
        this.HoodBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodBack.addBox(-4.5F, -8.5F, 1.0F, 9, 11, 3, 0.0F);
        this.HoodTop = new ModelRenderer(this, 30, 25);
        this.HoodTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodTop.addBox(-4.5F, -8.5F, -4.5F, 9, 1, 6, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_1.addBox(-4.0F, 12.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Cape = new ModelRenderer(this, 35, 0);
        this.Cape.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.Cape.addBox(-4.5F, 0.0F, 0.0F, 9, 20, 1, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_2.addBox(0.0F, 12.0F, -2.0F, 4, 12, 4, 0.0F);
        this.HoodR = new ModelRenderer(this, 30, 57);
        this.HoodR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodR.addBox(3.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
        this.shape1_7 = new ModelRenderer(this, 0, 0);
        this.shape1_7.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.shape1_7.addBox(4.5F, 1.0F, -2.5F, 5, 9, 5, 0.0F);
        this.setRotateAngle(shape1_7, -0.9075712110370513F, 0.4886921905584123F, 0.0F);
        this.BodyMain = new ModelRenderer(this, 0, 77);
        this.BodyMain.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyMain.addBox(-4.5F, 0.0F, -2.5F, 9, 17, 5, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.shape1_4 = new ModelRenderer(this, 0, 0);
        this.shape1_4.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.shape1_4.addBox(5.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(shape1_4, -0.9075712110370513F, 0.4886921905584123F, 0.0F);
        this.shape1_5 = new ModelRenderer(this, 0, 0);
        this.shape1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1_5.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 0, 0);
        this.shape1_3.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.shape1_3.addBox(-9.0F, 1.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(shape1_3, -0.9075712110370513F, -0.4886921905584123F, 0.0F);
        this.HoodL = new ModelRenderer(this, 30, 38);
        this.HoodL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodL.addBox(-4.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
        this.shape1_6 = new ModelRenderer(this, 0, 0);
        this.shape1_6.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.shape1_6.addBox(-9.5F, 1.0F, -2.5F, 5, 9, 5, 0.0F);
        this.setRotateAngle(shape1_6, -0.9075712110370513F, -0.4886921905584123F, 0.0F);
        this.BodyMain.addChild(this.HoodBack);
        this.BodyMain.addChild(this.HoodTop);
        this.shape1.addChild(this.shape1_1);
        this.BodyMain.addChild(this.Cape);
        this.shape1.addChild(this.shape1_2);
        this.BodyMain.addChild(this.HoodR);
        this.shape1.addChild(this.shape1_7);
        this.shape1.addChild(this.shape1_4);
        this.shape1.addChild(this.shape1_5);
        this.shape1.addChild(this.shape1_3);
        this.BodyMain.addChild(this.HoodL);
        this.shape1.addChild(this.shape1_6);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BodyMain.render(f5);
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
