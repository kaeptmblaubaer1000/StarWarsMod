package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class backpackScout extends ModelBase {
    public ModelRenderer MainParent;
    public ModelRenderer shape9;
    public ModelRenderer shape9_1;

    public backpackScout() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.MainParent = new ModelRenderer(this, 0, 0);
        this.MainParent.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.MainParent.addBox(-1.0F, -4.5F, 1.7F, 2, 6, 2, 0.0F);
        this.shape9 = new ModelRenderer(this, 0, 0);
        this.shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9.addBox(-2.5F, -4.5F, 1.0F, 5, 5, 2, 0.0F);
        this.shape9_1 = new ModelRenderer(this, 0, 0);
        this.shape9_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape9_1.addBox(-2.5F, 2.5F, 1.5F, 5, 2, 2, 0.0F);
        this.MainParent.addChild(this.shape9);
        this.MainParent.addChild(this.shape9_1);
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
