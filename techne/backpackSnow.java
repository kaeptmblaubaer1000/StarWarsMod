package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class backpackSnow extends ModelBase {
    public ModelRenderer field_78112_f;
    public ModelRenderer field_78124_i;
    public ModelRenderer field_78116_c;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_78113_g;
    public ModelRenderer field_78123_h;
    public ModelRenderer field_78121_j;
    public ModelRenderer BackpackParent;
    public ModelRenderer BackpackParent_1;
    public ModelRenderer BackpackParent_2;
    public ModelRenderer BackpackParent_3;
    public ModelRenderer BackpackParent_4;
    public ModelRenderer BackpackParent_5;
    public ModelRenderer BackpackParent_6;
    public ModelRenderer BackpackParent_7;
    public ModelRenderer BackpackParent_8;
    public ModelRenderer BackpackParent_9;

    public backpackSnow() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.BackpackParent_5 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_5.addBox(-3.0F, -3.0F, 3.0F, 3, 2, 2, 0.0F);
        this.BackpackParent_4 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_4.addBox(-3.0F, -3.0F, 3.0F, 1, 4, 2, 0.0F);
        this.BackpackParent_6 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_6.addBox(0.75F, -3.0F, 1.5F, 2, 5, 3, 0.0F);
        this.setRotateAngle(BackpackParent_6, 0.10471975511965977F, 0.0F, 0.0F);
        this.BackpackParent = new ModelRenderer(this, 0, 0);
        this.BackpackParent.setRotationPoint(0.0F, 6.4F, 0.0F);
        this.BackpackParent.addBox(-4.0F, 2.0F, 1.8F, 8, 2, 3, 0.0F);
        this.BackpackParent_2 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_2.addBox(-3.5F, -5.0F, 1.2F, 7, 8, 3, 0.0F);
        this.setRotateAngle(BackpackParent_2, 0.10471975511965977F, 0.0F, 0.0F);
        this.field_78113_g = new ModelRenderer(this, 40, 16);
        this.field_78113_g.mirror = true;
        this.field_78113_g.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.field_78113_g.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_78123_h = new ModelRenderer(this, 0, 16);
        this.field_78123_h.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
        this.field_78123_h.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_78112_f = new ModelRenderer(this, 40, 16);
        this.field_78112_f.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.field_78112_f.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.field_78121_j = new ModelRenderer(this, 24, 0);
        this.field_78121_j.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78121_j.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0.0F);
        this.BackpackParent_9 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_9.addBox(-2.0F, -2.5F, 4.3F, 1, 1, 1, 0.0F);
        this.BackpackParent_7 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_7.addBox(1.25F, -2.5F, 1.7F, 1, 2, 3, 0.0F);
        this.setRotateAngle(BackpackParent_7, 0.10471975511965977F, 0.0F, 0.0F);
        this.field_78115_e = new ModelRenderer(this, 16, 16);
        this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.field_78116_c = new ModelRenderer(this, 0, 0);
        this.field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_c.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.BackpackParent_3 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_3.addBox(-1.0F, -3.0F, 3.0F, 1, 4, 2, 0.0F);
        this.BackpackParent_1 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_1.addBox(-4.0F, -6.0F, 2.0F, 8, 2, 2, 0.0F);
        this.BackpackParent_8 = new ModelRenderer(this, 0, 0);
        this.BackpackParent_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.BackpackParent_8.addBox(1.25F, 0.2F, 1.7F, 1, 1, 3, 0.0F);
        this.setRotateAngle(BackpackParent_8, 0.10471975511965977F, 0.0F, 0.0F);
        this.field_78124_i = new ModelRenderer(this, 0, 16);
        this.field_78124_i.mirror = true;
        this.field_78124_i.setRotationPoint(1.899999976158142F, 12.0F, 0.0F);
        this.field_78124_i.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.BackpackParent.addChild(this.BackpackParent_5);
        this.BackpackParent.addChild(this.BackpackParent_4);
        this.BackpackParent.addChild(this.BackpackParent_6);
        this.BackpackParent.addChild(this.BackpackParent_2);
        this.BackpackParent.addChild(this.BackpackParent_9);
        this.BackpackParent.addChild(this.BackpackParent_7);
        this.BackpackParent.addChild(this.BackpackParent_3);
        this.BackpackParent.addChild(this.BackpackParent_1);
        this.BackpackParent.addChild(this.BackpackParent_8);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BackpackParent.render(f5);
        this.field_78113_g.render(f5);
        this.field_78123_h.render(f5);
        this.field_78112_f.render(f5);
        this.field_78121_j.render(f5);
        this.field_78115_e.render(f5);
        this.field_78116_c.render(f5);
        this.field_78124_i.render(f5);
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
