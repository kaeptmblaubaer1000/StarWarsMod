package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class backpackStorm extends ModelBase {
    public ModelRenderer MainParent;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;
    public ModelRenderer shape9_2;
    public ModelRenderer shape9_3;
    public ModelRenderer shape9_4;
    public ModelRenderer shape9_5;
    public ModelRenderer shape9_6;

    public backpackStorm() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape9_3 = new ModelRenderer(this, 0, 0);
        this.shape9_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_3.addBox(-3.0F, -4.0F, 0.9F, 6, 4, 2, 0.0F);
        this.shape9_2 = new ModelRenderer(this, 0, 0);
        this.shape9_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_2.addBox(-3.0F, -0.5F, 1.3F, 6, 1, 2, 0.0F);
        this.shape9_4 = new ModelRenderer(this, 0, 0);
        this.shape9_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_4.addBox(-1.8F, -3.0F, 1.3F, 1, 2, 2, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 0, 0);
        this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_1.addBox(-3.0F, -4.5F, 1.3F, 6, 1, 2, 0.0F);
        this.MainParent = new ModelRenderer(this, 0, 0);
        this.MainParent.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.MainParent.addBox(-3.0F, -4.5F, 1.3F, 1, 5, 2, 0.0F);
        this.shape9_5 = new ModelRenderer(this, 0, 0);
        this.shape9_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_5.addBox(-0.3F, -3.0F, 1.3F, 2, 2, 2, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9.addBox(2.0F, -4.5F, 1.3F, 1, 5, 2, 0.0F);
        this.shape9_6 = new ModelRenderer(this, 0, 0);
        this.shape9_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_6.addBox(-2.5F, 2.5F, 1.3F, 5, 2, 2, 0.0F);
        this.MainParent.addChild(this.shape9_3);
        this.MainParent.addChild(this.shape9_2);
        this.MainParent.addChild(this.shape9_4);
        this.MainParent.addChild(this.shape9_1);
        this.MainParent.addChild(this.shape9_5);
        this.MainParent.addChild(this.shape9);
        this.MainParent.addChild(this.shape9_6);
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
