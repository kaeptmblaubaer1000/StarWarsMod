package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Compressor - Weaston
 * Created using Tabula 4.1.1
 */
public class BlockCrystalCompressor extends ModelBase
{
	public ModelRenderer shape1;
	public ModelRenderer shape1_1;
	public ModelRenderer shape1_2;
	public ModelRenderer shape1_3;
	public ModelRenderer shape1_4;
	public ModelRenderer shape1_5;
	public ModelRenderer shape1_6;
	public ModelRenderer shape1_7;
	public ModelRenderer shape1_8;
	public ModelRenderer shape1_9;
	public ModelRenderer shape1_10;
	public ModelRenderer shape1_11;
	public ModelRenderer shape1_12;
	public ModelRenderer shape1_13;
	public ModelRenderer shape1_14;
	public ModelRenderer shape1_15;
	public ModelRenderer shape1_16;
	public ModelRenderer shape1_17;

	public BlockCrystalCompressor()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1_11 = new ModelRenderer(this, 111, 0);
		this.shape1_11.setRotationPoint(-3.0F, -13.0F, 1.0F);
		this.shape1_11.addBox(-2.0F, -17.0F, 5.0F, 2, 16, 2, 0.0F);
		this.setRotateAngle(shape1_11, 0.24434609527920614F, -1.5707963267948966F, 0.0F);
		this.shape1_3 = new ModelRenderer(this, 0, 68);
		this.shape1_3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_3.addBox(-3.0F, -12.0F, -3.0F, 6, 10, 6, 0.0F);
		this.shape1_15 = new ModelRenderer(this, 0, 0);
		this.shape1_15.setRotationPoint(1.0F, 2.0F, -12.0F);
		this.shape1_15.addBox(-3.0F, -18.2F, 4.27F, 2, 7, 2, 0.0F);
		this.setRotateAngle(shape1_15, -1.0821041362364843F, 0.0F, 0.0F);
		this.shape1_5 = new ModelRenderer(this, 0, 122);
		this.shape1_5.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_5.addBox(-4.5F, -12.0F, -1.5F, 9, 10, 3, 0.0F);
		this.shape1_9 = new ModelRenderer(this, 0, 240);
		this.shape1_9.setRotationPoint(0.0F, -16.0F, 0.0F);
		this.shape1_9.addBox(-2.0F, -11.0F, -2.0F, 4, 4, 4, 0.0F);
		this.shape1_4 = new ModelRenderer(this, 0, 97);
		this.shape1_4.setRotationPoint(0.0F, -14.0F, 0.0F);
		this.shape1_4.addBox(-6.0F, -2.0F, -6.0F, 12, 2, 12, 0.0F);
		this.shape1_12 = new ModelRenderer(this, 133, 0);
		this.shape1_12.setRotationPoint(3.0F, -13.0F, -1.0F);
		this.shape1_12.addBox(-2.0F, -17.0F, 5.0F, 2, 16, 2, 0.0F);
		this.setRotateAngle(shape1_12, 0.24434609527920614F, 1.5707963267948966F, 0.0F);
		this.shape1_6 = new ModelRenderer(this, 0, 147);
		this.shape1_6.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_6.addBox(-1.5F, -12.0F, -4.5F, 3, 10, 9, 0.0F);
		this.shape1_2 = new ModelRenderer(this, 0, 46);
		this.shape1_2.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape1_2.addBox(-6.0F, -2.0F, -6.0F, 12, 4, 12, 0.0F);
		this.shape1_14 = new ModelRenderer(this, 92, 0);
		this.shape1_14.setRotationPoint(1.0F, 2.0F, -12.0F);
		this.shape1_14.addBox(-3.0F, -18.2F, 4.27F, 2, 7, 2, 0.0F);
		this.setRotateAngle(shape1_14, -1.0821041362364843F, 0.0F, 0.0F);
		this.shape1_10 = new ModelRenderer(this, 72, 0);
		this.shape1_10.setRotationPoint(1.0F, -13.0F, 3.0F);
		this.shape1_10.addBox(-2.0F, -17.0F, 5.0F, 2, 16, 2, 0.0F);
		this.setRotateAngle(shape1_10, 0.24434609527920614F, 0.0F, 0.0F);
		this.shape1_17 = new ModelRenderer(this, 0, 0);
		this.shape1_17.setRotationPoint(1.0F, 2.0F, -12.0F);
		this.shape1_17.addBox(-3.0F, -18.2F, 4.27F, 2, 7, 2, 0.0F);
		this.setRotateAngle(shape1_17, -1.0821041362364843F, 0.0F, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shape1.addBox(-8.0F, 0.0F, -8.0F, 16, 2, 16, 0.0F);
		this.shape1_7 = new ModelRenderer(this, 0, 178);
		this.shape1_7.setRotationPoint(0.0F, -16.0F, 0.0F);
		this.shape1_7.addBox(-8.0F, -3.0F, -8.0F, 16, 3, 16, 0.0F);
		this.setRotateAngle(shape1_7, 0.0F, 3.141592653589793F, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 24);
		this.shape1_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.shape1_1.addBox(-7.0F, 0.0F, -7.0F, 14, 2, 14, 0.0F);
		this.shape1_8 = new ModelRenderer(this, 0, 211);
		this.shape1_8.setRotationPoint(0.0F, -16.0F, 0.0F);
		this.shape1_8.addBox(-6.0F, -7.0F, -6.0F, 12, 4, 12, 0.0F);
		this.shape1_13 = new ModelRenderer(this, 150, 0);
		this.shape1_13.setRotationPoint(-1.0F, -13.0F, -3.0F);
		this.shape1_13.addBox(-2.0F, -17.0F, 5.0F, 2, 16, 2, 0.0F);
		this.setRotateAngle(shape1_13, 0.24434609527920614F, -3.141592653589793F, 0.0F);
		this.shape1_16 = new ModelRenderer(this, 0, 0);
		this.shape1_16.setRotationPoint(1.0F, 2.0F, -12.0F);
		this.shape1_16.addBox(-3.0F, -18.2F, 4.27F, 2, 7, 2, 0.0F);
		this.setRotateAngle(shape1_16, -1.0821041362364843F, 0.0F, 0.0F);
		this.shape1.addChild(this.shape1_11);
		this.shape1.addChild(this.shape1_3);
		this.shape1_11.addChild(this.shape1_15);
		this.shape1.addChild(this.shape1_5);
		this.shape1.addChild(this.shape1_9);
		this.shape1.addChild(this.shape1_4);
		this.shape1.addChild(this.shape1_12);
		this.shape1.addChild(this.shape1_6);
		this.shape1.addChild(this.shape1_2);
		this.shape1_10.addChild(this.shape1_14);
		this.shape1.addChild(this.shape1_10);
		this.shape1_13.addChild(this.shape1_17);
		this.shape1.addChild(this.shape1_7);
		this.shape1.addChild(this.shape1_1);
		this.shape1.addChild(this.shape1_8);
		this.shape1.addChild(this.shape1_13);
		this.shape1_12.addChild(this.shape1_16);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.shape1.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
