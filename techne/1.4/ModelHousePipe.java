package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * House Pipe - Weaston
 * Created using P-Tabula 4.1.1
 */
public class ModelHousePipe extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;

    public ModelHousePipe() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape2 = new ModelRenderer(this, 0, 0);
        this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape2.addBox(-8.5F, -12.0F, -2.5F, 6, 4, 4, 0.0F);
        this.shape4 = new ModelRenderer(this, 30, 0);
        this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape4.addBox(-3.0F, 7.0F, -3.0F, 5, 1, 5, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 10);
        this.shape1.setRotationPoint(0.5F, 16.0F, 0.5F);
        this.shape1.addBox(-2.5F, -12.0F, -2.5F, 4, 20, 4, 0.0F);
        this.shape3 = new ModelRenderer(this, 0, 36);
        this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape3.addBox(-8.5F, -12.5F, -3.0F, 1, 5, 5, 0.0F);
        this.shape1.addChild(this.shape2);
        this.shape1.addChild(this.shape4);
        this.shape1.addChild(this.shape3);
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
