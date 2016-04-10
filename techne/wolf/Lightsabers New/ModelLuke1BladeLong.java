package com.parzivail.pswm.models.lightsabers.blades;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * luke1.tbl - TechneToTabulaImporter
 * Created using Tabula 4.1.1
 */
public class ModelLuke1BladeL extends ModelBase {
    public ModelRenderer shape32;

    public ModelLuke1BladeL() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.shape32 = new ModelRenderer(this, 0, 0);
        this.shape32.setRotationPoint(13.0F, 0.0F, 0.0F);
        this.shape32.addBox(-145.0F, 1.5F, 1.5F, 140, 3, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape32.render(f5);
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
