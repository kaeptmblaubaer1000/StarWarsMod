package Jedi Robes Hood Down;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Jedi Robes - Weaston
 * Created using Tabula 4.1.1
 */
public class Jedi Robes Hood Down extends ModelBase {
    public ModelRenderer BodyMain;
    public ModelRenderer FootL;
    public ModelRenderer FootR;
    public ModelRenderer ArmR;
    public ModelRenderer ArmL;
    public ModelRenderer HoodDown;

    public Jedi Robes Hood Down() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.ArmL = new ModelRenderer(this, 0, 83);
        this.ArmL.setRotationPoint(-4.5F, 2.0F, 0.0F);
        this.ArmL.addBox(-4.5F, -2.0F, -2.5F, 5, 11, 5, 0.0F);
        this.HoodDown = new ModelRenderer(this, 37, 0);
        this.HoodDown.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.HoodDown.addBox(-4.5F, 0.0F, -1.5F, 9, 8, 5, 0.0F);
        this.ArmR = new ModelRenderer(this, 0, 61);
        this.ArmR.setRotationPoint(4.5F, 2.0F, 0.0F);
        this.ArmR.addBox(-0.5F, -2.0F, -2.5F, 5, 11, 5, 0.0F);
        this.FootR = new ModelRenderer(this, 0, 42);
        this.FootR.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.FootR.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
        this.BodyMain = new ModelRenderer(this, 0, 0);
        this.BodyMain.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BodyMain.addBox(-4.5F, 0.0F, -2.5F, 9, 17, 5, 0.0F);
        this.FootL = new ModelRenderer(this, 0, 25);
        this.FootL.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.FootL.addBox(-2.5F, 5.0F, -2.5F, 5, 7, 5, 0.0F);
        this.BodyMain.addChild(this.ArmL);
        this.BodyMain.addChild(this.HoodDown);
        this.BodyMain.addChild(this.ArmR);
        this.BodyMain.addChild(this.FootR);
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
