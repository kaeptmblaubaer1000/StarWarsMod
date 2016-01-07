package Jedi Robes Hooded;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Jedi Robes - Weaston
 * Created using Tabula 4.1.1
 */
public class Jedi Robes Hooded extends ModelBase {
    public ModelRenderer BodyMain;
    public ModelRenderer FootL;
    public ModelRenderer FootR;
    public ModelRenderer ArmR;
    public ModelRenderer ArmL;
    public ModelRenderer Cape;
    public ModelRenderer HoodBack;
    public ModelRenderer HoodTop;
    public ModelRenderer HoodL;
    public ModelRenderer HoodR;

    public Jedi Robes Hooded() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.ArmL = new ModelRenderer(this, 0, 83);
        this.ArmL.setRotationPoint(-4.5F, 2.0F, 0.0F);
        this.ArmL.addBox(-4.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
        this.HoodL = new ModelRenderer(this, 30, 38);
        this.HoodL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodL.addBox(-4.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
        this.ArmR = new ModelRenderer(this, 0, 62);
        this.ArmR.setRotationPoint(4.5F, 2.0F, 0.0F);
        this.ArmR.addBox(-0.5F, -2.0F, -2.5F, 5, 10, 5, 0.0F);
        this.HoodTop = new ModelRenderer(this, 30, 25);
        this.HoodTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodTop.addBox(-4.5F, -8.5F, -4.5F, 9, 1, 6, 0.0F);
        this.HoodR = new ModelRenderer(this, 30, 57);
        this.HoodR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodR.addBox(3.5F, -8.5F, -4.5F, 1, 9, 6, 0.0F);
        this.FootR = new ModelRenderer(this, 0, 44);
        this.FootR.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.FootR.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
        this.Cape = new ModelRenderer(this, 35, 0);
        this.Cape.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.Cape.addBox(-4.5F, 0.0F, 0.0F, 9, 20, 1, 0.0F);
        this.HoodBack = new ModelRenderer(this, 62, 0);
        this.HoodBack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodBack.addBox(-4.5F, -8.5F, 1.0F, 9, 11, 3, 0.0F);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyMain.addBox(-4.5F, 0.0F, -2.5F, 9, 17, 5, 0.0F);
        this.FootL = new ModelRenderer(this, 0, 26);
        this.FootL.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.FootL.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
        this.BodyMain.addChild(this.ArmL);
        this.BodyMain.addChild(this.HoodL);
        this.BodyMain.addChild(this.ArmR);
        this.BodyMain.addChild(this.HoodTop);
        this.BodyMain.addChild(this.HoodR);
        this.BodyMain.addChild(this.FootR);
        this.BodyMain.addChild(this.Cape);
        this.BodyMain.addChild(this.HoodBack);
        this.BodyMain.addChild(this.FootL);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BodyMain.render(f5);
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
