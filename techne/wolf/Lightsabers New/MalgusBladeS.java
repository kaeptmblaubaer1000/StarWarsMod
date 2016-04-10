package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * MalgusHilt - Undefined
 * Created using Tabula 4.1.1
 */
public class MalgusBladeS extends ModelBase {
    public ModelRenderer blade;

    public MalgusBladeS() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.blade = new ModelRenderer(this, 0, 0);
        this.blade.setRotationPoint(9.0F, 0.0F, 0.0F);
        this.blade.addBox(-108.0F, 1.5F, 1.5F, 100, 3, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.blade.render(f5);
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
