package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Revan 2 - Wolfie
 * Created using P-Tabula 4.1.1
 */
public class ModelBladeRevan2Long extends ModelBase {
    public ModelRenderer shape1;

    public ModelBladeRevan2Long() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(11.0F, 0.0F, 0.0F);
        this.shape1.addBox(-148.5F, 0.5F, 0.5F, 140, 4, 4, 0.0F);
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
