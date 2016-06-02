package starwarsmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Snake - Weaston
 * Created using Tabula 4.1.1
 */
public class ModelSnake extends ModelBase
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

	public ModelSnake()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.shape1_2 = new ModelRenderer(this, 0, 28);
		this.shape1_2.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_2.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_4 = new ModelRenderer(this, 0, 69);
		this.shape1_4.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_4.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_7 = new ModelRenderer(this, 0, 130);
		this.shape1_7.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_7.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_8 = new ModelRenderer(this, 26, 0);
		this.shape1_8.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_8.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_3 = new ModelRenderer(this, 0, 49);
		this.shape1_3.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_3.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_5 = new ModelRenderer(this, 0, 86);
		this.shape1_5.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_5.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_1 = new ModelRenderer(this, 0, 16);
		this.shape1_1.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_1.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_6 = new ModelRenderer(this, 0, 107);
		this.shape1_6.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_6.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.shape1.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_9 = new ModelRenderer(this, 52, 0);
		this.shape1_9.setRotationPoint(0.0F, 0.0F, 3.0F);
		this.shape1_9.addBox(-1.0F, -1.0F, -1.5F, 2, 2, 3, 0.0F);
		this.shape1_1.addChild(this.shape1_2);
		this.shape1_3.addChild(this.shape1_4);
		this.shape1_6.addChild(this.shape1_7);
		this.shape1_7.addChild(this.shape1_8);
		this.shape1_2.addChild(this.shape1_3);
		this.shape1_4.addChild(this.shape1_5);
		this.shape1.addChild(this.shape1_1);
		this.shape1_5.addChild(this.shape1_6);
		this.shape1_8.addChild(this.shape1_9);
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
