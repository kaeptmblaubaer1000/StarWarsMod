package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * StarkillerHilt - Undefined
 * Created using Tabula 4.1.1
 */
public class StarkillerBladeL extends ModelBase {
    public ModelRenderer shape1;

    public StarkillerBladeL() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.shape1.addBox(-145.0F, 1.5F, 1.5F, 140, 3, 3, 0.0F);
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
