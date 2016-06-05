package com.parzivail.pswm.models.lightsabers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.IHandlesRender;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * YodaHilt - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelYodaHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/yoda_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/yoda_B.png");

	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
	public ModelRenderer Shape3;
	public ModelRenderer Shape6;
	public ModelRenderer Shape7;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape10;
	public ModelRenderer Shape11;
	public ModelRenderer Shape12;
	public ModelRenderer Shape13;
	public ModelRenderer Shape14;
	public ModelRenderer Shape15;
	public ModelRenderer Shape16;
	public ModelRenderer Shape17;
	public ModelRenderer Shape18;
	public ModelRenderer Shape19;
	public ModelRenderer Shape20;
	public ModelRenderer Shape21;
	public ModelRenderer Shape22;
	public ModelRenderer Shape23;
	public ModelRenderer Shape24;
	public ModelRenderer Shape25;
	public ModelRenderer Shape26;
	public ModelRenderer Shape27;
	public ModelRenderer Shape28;
	public ModelRenderer Shape29;
	public ModelRenderer Shape30;
	public ModelRenderer Shape31;
	public ModelRenderer Shape32;
	public ModelRenderer Shape33;
	public ModelRenderer Shape34;
	public ModelRenderer Shape35;
	public ModelRenderer Shape36;

	public ModelYodaHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape31 = new ModelRenderer(this, 47, 5);
		this.Shape31.setRotationPoint(6.5F, -2.0F, 2.0F);
		this.Shape31.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 31);
		this.Shape3.setRotationPoint(0.5F, 0.0F, 0.0F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape15 = new ModelRenderer(this, 64, 69);
		this.Shape15.setRotationPoint(26.0F, 6.0F, 1.0F);
		this.Shape15.addBox(0.0F, -1.0F, -1.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape15, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape21 = new ModelRenderer(this, 21, 11);
		this.Shape21.setRotationPoint(-2.0F, 2.0F, -1.0F);
		this.Shape21.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape21, 0.0F, -0.0F, 0.7330383062362671F);
		this.Shape9 = new ModelRenderer(this, 64, 32);
		this.Shape9.setRotationPoint(26.0F, 4.0F, -1.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape9, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape19 = new ModelRenderer(this, 21, 24);
		this.Shape19.setRotationPoint(-6.0F, -1.0F, -1.0F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 6, 1, 7, 0.0F);
		this.Shape13 = new ModelRenderer(this, 64, 52);
		this.Shape13.setRotationPoint(26.0F, 1.0F, 6.0F);
		this.Shape13.addBox(0.0F, -1.0F, -1.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape13, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape25 = new ModelRenderer(this, 31, 0);
		this.Shape25.setRotationPoint(0.0F, -1.0F, 1.5F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(Shape25, 0.0F, -0.0F, 0.296705961227417F);
		this.Shape32 = new ModelRenderer(this, 0, 70);
		this.Shape32.setRotationPoint(13.0F, 6.0F, 1.0F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
		this.Shape14 = new ModelRenderer(this, 64, 58);
		this.Shape14.setRotationPoint(26.0F, 4.0F, 6.0F);
		this.Shape14.addBox(0.0F, 0.0F, -1.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape14, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape6 = new ModelRenderer(this, 19, 52);
		this.Shape6.setRotationPoint(12.5F, -1.0F, -1.0F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 12, 7, 7, 0.0F);
		this.Shape26 = new ModelRenderer(this, 32, 5);
		this.Shape26.setRotationPoint(1.5F, -0.30000001192092896F, 1.5F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
		this.Shape4 = new ModelRenderer(this, 0, 56);
		this.Shape4.setRotationPoint(3.5F, 0.0F, 0.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape7 = new ModelRenderer(this, 58, 3);
		this.Shape7.setRotationPoint(26.0F, 1.0F, -1.0F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 11, 3, 7, 0.0F);
		this.Shape20 = new ModelRenderer(this, 21, 17);
		this.Shape20.setRotationPoint(-4.0F, 0.0F, -1.0F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Shape22 = new ModelRenderer(this, 27, 11);
		this.Shape22.setRotationPoint(-4.0F, 2.0F, -1.0F);
		this.Shape22.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape22, 0.0F, -0.0F, -0.7330383062362671F);
		this.Shape17 = new ModelRenderer(this, 0, 0);
		this.Shape17.setRotationPoint(38.0F, 0.0F, 0.0F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.Shape30 = new ModelRenderer(this, 43, 37);
		this.Shape30.setRotationPoint(-4.5F, 0.0F, 5.0F);
		this.Shape30.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 87);
		this.Shape5.setRotationPoint(4.0F, -0.5F, -0.5F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 34, 6, 6, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 16);
		this.Shape1.setRotationPoint(0.0F, -0.5F, -0.5F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape16 = new ModelRenderer(this, 64, 63);
		this.Shape16.setRotationPoint(26.0F, 6.0F, 4.0F);
		this.Shape16.addBox(0.0F, -1.0F, 0.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape16, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape8 = new ModelRenderer(this, 64, 37);
		this.Shape8.setRotationPoint(26.0F, 1.0F, -1.0F);
		this.Shape8.addBox(0.0F, -1.0F, 0.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape8, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape11 = new ModelRenderer(this, 64, 42);
		this.Shape11.setRotationPoint(26.0F, -1.0F, 1.0F);
		this.Shape11.addBox(0.0F, 0.0F, -1.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape11, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape10 = new ModelRenderer(this, 62, 17);
		this.Shape10.setRotationPoint(26.0F, -1.0F, 1.0F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 11, 7, 3, 0.0F);
		this.Shape33 = new ModelRenderer(this, 0, 79);
		this.Shape33.setRotationPoint(15.5F, 5.5F, 1.0F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 45);
		this.Shape2.setRotationPoint(0.5F, 0.5F, 0.5F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.Shape23 = new ModelRenderer(this, 43, 43);
		this.Shape23.setRotationPoint(-4.5F, 0.0F, -1.0F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape29 = new ModelRenderer(this, 38, 11);
		this.Shape29.setRotationPoint(-4.0F, 2.0F, 5.0F);
		this.Shape29.addBox(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape29, 0.0F, -0.0F, -0.7330383062362671F);
		this.Shape34 = new ModelRenderer(this, 18, 70);
		this.Shape34.setRotationPoint(16.0F, 7.5F, 2.0F);
		this.Shape34.addBox(0.0F, -1.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape34, 0.0F, -0.0F, -0.05235987901687623F);
		this.Shape28 = new ModelRenderer(this, 44, 11);
		this.Shape28.setRotationPoint(-2.0F, 2.0F, 5.0F);
		this.Shape28.addBox(-1.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape28, 0.0F, -0.0F, 0.7330383062362671F);
		this.Shape27 = new ModelRenderer(this, 38, 17);
		this.Shape27.setRotationPoint(-4.0F, 0.0F, 5.0F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Shape18 = new ModelRenderer(this, 50, 28);
		this.Shape18.setRotationPoint(6.0F, -1.0F, 1.5F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.Shape12 = new ModelRenderer(this, 64, 47);
		this.Shape12.setRotationPoint(26.0F, -1.0F, 4.0F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
		this.setRotateAngle(Shape12, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape24 = new ModelRenderer(this, 50, 22);
		this.Shape24.setRotationPoint(4.0F, -1.0F, 2.0F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.Shape35 = new ModelRenderer(this, 23, 76);
		this.Shape35.setRotationPoint(39.5F, 0.5F, 0.5F);
		this.Shape35.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
		this.Shape36 = new ModelRenderer(this, 20, 36);
		this.Shape36.setRotationPoint(14.0F, 0.5F, -1.5F);
		this.Shape36.addBox(0.0F, 0.0F, 0.0F, 2, 4, 8, 0.0F);
	}

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Shape31.render(f5);
		this.Shape3.render(f5);
		this.Shape15.render(f5);
		this.Shape21.render(f5);
		this.Shape9.render(f5);
		this.Shape19.render(f5);
		this.Shape13.render(f5);
		this.Shape25.render(f5);
		this.Shape32.render(f5);
		this.Shape14.render(f5);
		this.Shape6.render(f5);
		this.Shape26.render(f5);
		this.Shape4.render(f5);
		this.Shape7.render(f5);
		this.Shape20.render(f5);
		this.Shape22.render(f5);
		this.Shape17.render(f5);
		this.Shape30.render(f5);
		this.Shape5.render(f5);
		this.Shape1.render(f5);
		this.Shape16.render(f5);
		this.Shape8.render(f5);
		this.Shape11.render(f5);
		this.Shape10.render(f5);
		this.Shape33.render(f5);
		this.Shape2.render(f5);
		this.Shape23.render(f5);
		this.Shape29.render(f5);
		this.Shape34.render(f5);
		this.Shape28.render(f5);
		this.Shape27.render(f5);
		this.Shape18.render(f5);
		this.Shape12.render(f5);
		this.Shape24.render(f5);
		this.Shape35.render(f5);
		this.Shape36.render(f5);
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.03f, 0.03f, 0.03f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(-36, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.04f, 0.04f, 0.04f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(9, -2, 22.8f);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glTranslatef(0, -8, -3);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glTranslatef(0, 23, 0);
				GL11.glRotatef(-130, 0, 1, 0);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(75, 0, 0, 1);
				GL11.glRotatef(85, 1, 0, 0);
				GL11.glTranslatef(0, 18, 0);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(-20, 0, 0, 1);
						GL11.glRotatef(70, 0, 1, 0);
						GL11.glRotatef(30, 1, 0, 0);
						GL11.glTranslatef(-4, 12, 15);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.045f, 0.045f, 0.045f);
				GL11.glTranslatef(-21.5f, 3, 0);
				GL11.glRotatef(160, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(90, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				break;
			default:
				break;
		}
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

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
