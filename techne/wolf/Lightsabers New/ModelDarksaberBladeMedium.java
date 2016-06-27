package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * NewProject - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelDarksaberBladeMedium extends ModelBase {
    public ModelRenderer shape1;

    public ModelDarksaberBladeMedium() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(17.0F, 0.0F, 0.0F);
        this.shape1.addBox(-128.0F, 1.0F, 1.1F, 120, 4, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GL11.glPushMatrix();
        GL11.glTranslatef(this.shape1.offsetX, this.shape1.offsetY, this.shape1.offsetZ);
        GL11.glTranslatef(this.shape1.rotationPointX * f5, this.shape1.rotationPointY * f5, this.shape1.rotationPointZ * f5);
        GL11.glScaled(1.2D, 1.2D, 1.2D);
        GL11.glTranslatef(-this.shape1.offsetX, -this.shape1.offsetY, -this.shape1.offsetZ);
        GL11.glTranslatef(-this.shape1.rotationPointX * f5, -this.shape1.rotationPointY * f5, -this.shape1.rotationPointZ * f5);
        this.shape1.render(f5);
        GL11.glPopMatrix();
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
