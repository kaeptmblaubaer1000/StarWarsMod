package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Melee Hook - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelMeleeHook extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;

    public ModelMeleeHook() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-12.0F, 16.0F, -9.0F);
        this.shape1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 1, 0.0F);
        this.shape3 = new ModelRenderer(this, 40, 0);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(23.0F, 1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.shape4 = new ModelRenderer(this, 76, 0);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(23.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F);
        this.shape2 = new ModelRenderer(this, 20, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(20.0F, -4.0F, 0.0F, 8, 8, 1, 0.0F);
        this.shape6 = new ModelRenderer(this, 86, 0);
        this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape6.addBox(-1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F);
        this.shape5 = new ModelRenderer(this, 58, 0);
        this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape5.addBox(-1.0F, 1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.shape1.addChild(this.shape3);
        this.shape1.addChild(this.shape4);
        this.shape1.addChild(this.shape2);
        this.shape1.addChild(this.shape6);
        this.shape1.addChild(this.shape5);
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
