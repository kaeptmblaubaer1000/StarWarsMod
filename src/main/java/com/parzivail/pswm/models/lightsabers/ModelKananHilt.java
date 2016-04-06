package com.parzivail.pswm.models.lightsabers;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.IHandlesRender;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

/**
 * Kanan's Hilt - Undefined Created using Tabula 4.1.1
 */
public class ModelKananHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/kanan_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/kanan_B.png");

	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
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

	public ModelKananHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape10 = new ModelRenderer(this, 57, 81);
		this.Shape10.setRotationPoint(8.5F, 1.5F, 5.5F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 30, 1, 1, 0.0F);
		this.Shape6 = new ModelRenderer(this, 0, 101);
		this.Shape6.setRotationPoint(10.0F, 0.5F, 0.5F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 26, 5, 2, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 51);
		this.Shape2.setRotationPoint(2.0F, -0.5F, -0.5F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 6, 7, 7, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 112);
		this.Shape7.setRotationPoint(10.0F, 0.0F, 2.0F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 26, 6, 4, 0.0F);
		this.Shape8 = new ModelRenderer(this, 57, 89);
		this.Shape8.setRotationPoint(8.5F, -0.5F, 3.5F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 30, 7, 1, 0.0F);
		this.Shape26 = new ModelRenderer(this, 18, 0);
		this.Shape26.setRotationPoint(48.5F, 2.5F, 6.0F);
		this.Shape26.addBox(0.0F, 0.0F, -1.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(this.Shape26, 0.0F, 0.3141592741012573F, 0.0F);
		this.Shape28 = new ModelRenderer(this, 57, 69);
		this.Shape28.setRotationPoint(8.5F, 5.5F, 5.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 30, 1, 1, 0.0F);
		this.Shape30 = new ModelRenderer(this, 31, 53);
		this.Shape30.setRotationPoint(4.0F, -1.0F, 0.5F);
		this.Shape30.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.Shape20 = new ModelRenderer(this, 24, 44);
		this.Shape20.setRotationPoint(-9.0F, 5.0F, 0.0F);
		this.Shape20.addBox(-4.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(this.Shape20, 0.0F, 0.6632251143455505F, 0.0F);
		this.Shape22 = new ModelRenderer(this, 50, 3);
		this.Shape22.setRotationPoint(47.0F, 2.5F, 1.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.Shape9 = new ModelRenderer(this, 57, 73);
		this.Shape9.setRotationPoint(8.5F, -0.5F, 5.5F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 30, 1, 1, 0.0F);
		this.Shape3 = new ModelRenderer(this, 74, 2);
		this.Shape3.setRotationPoint(39.0F, -0.5F, -0.5F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
		this.Shape32 = new ModelRenderer(this, 73, 35);
		this.Shape32.setRotationPoint(39.5F, 2.5F, -1.5F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 3, 1, 9, 0.0F);
		this.Shape27 = new ModelRenderer(this, 57, 77);
		this.Shape27.setRotationPoint(8.5F, 3.5F, 5.5F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 30, 1, 1, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 38);
		this.Shape11.setRotationPoint(-2.0F, 0.5F, 0.5F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 4, 5, 5, 0.0F);
		this.Shape15 = new ModelRenderer(this, 0, 30);
		this.Shape15.setRotationPoint(-19.0F, 0.0F, 2.0F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 15, 1, 3, 0.0F);
		this.Shape31 = new ModelRenderer(this, 70, 48);
		this.Shape31.setRotationPoint(39.5F, -1.5F, 2.5F);
		this.Shape31.addBox(0.0F, 0.0F, 0.0F, 3, 9, 1, 0.0F);
		this.Shape23 = new ModelRenderer(this, 7, 2);
		this.Shape23.setRotationPoint(52.5F, 2.5F, 1.5F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.Shape34 = new ModelRenderer(this, 40, 85);
		this.Shape34.setRotationPoint(0.5F, 0.0F, 0.0F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 85);
		this.Shape5.setRotationPoint(36.0F, 0.0F, 0.0F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 10, 6, 6, 0.0F);
		this.Shape16 = new ModelRenderer(this, 0, 22);
		this.Shape16.setRotationPoint(-19.0F, 5.0F, 2.0F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 15, 1, 3, 0.0F);
		this.Shape19 = new ModelRenderer(this, 24, 38);
		this.Shape19.setRotationPoint(-9.0F, 0.0F, 0.0F);
		this.Shape19.addBox(-4.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(this.Shape19, 0.0F, 0.6632251143455505F, 0.0F);
		this.Shape21 = new ModelRenderer(this, 62, 24);
		this.Shape21.setRotationPoint(13.0F, 1.5F, -0.5F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 7, 3, 1, 0.0F);
		this.Shape25 = new ModelRenderer(this, 18, 4);
		this.Shape25.setRotationPoint(48.5F, 2.5F, 0.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
		this.setRotateAngle(this.Shape25, 0.0F, -0.3141592741012573F, 0.0F);
		this.Shape33 = new ModelRenderer(this, 29, 49);
		this.Shape33.setRotationPoint(-8.5F, 2.5F, -1.0F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.Shape17 = new ModelRenderer(this, 38, 10);
		this.Shape17.setRotationPoint(-14.0F, 1.0F, 1.0F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 10, 4, 4, 0.0F);
		this.Shape4 = new ModelRenderer(this, 84, 20);
		this.Shape4.setRotationPoint(46.0F, 0.5F, 0.5F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape14 = new ModelRenderer(this, 0, 10);
		this.Shape14.setRotationPoint(-19.0F, 0.0F, 5.0F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 15, 6, 1, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 69);
		this.Shape1.setRotationPoint(2.0F, 0.0F, 0.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 6, 0.0F);
		this.Shape13 = new ModelRenderer(this, 37, 66);
		this.Shape13.setRotationPoint(-3.0F, -0.5F, -0.5F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape18 = new ModelRenderer(this, 41, 22);
		this.Shape18.setRotationPoint(-9.0F, 0.0F, 0.0F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 5, 6, 4, 0.0F);
		this.Shape24 = new ModelRenderer(this, 33, 0);
		this.Shape24.setRotationPoint(47.5F, 2.5F, 0.0F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.Shape12 = new ModelRenderer(this, 44, 37);
		this.Shape12.setRotationPoint(-4.0F, -2.0F, -2.0F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 10, 10, 0.0F);
		this.Shape29 = new ModelRenderer(this, 58, 61);
		this.Shape29.setRotationPoint(4.0F, 2.0F, -2.5F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
	}

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Shape10.render(f5);
		this.Shape6.render(f5);
		this.Shape2.render(f5);
		this.Shape7.render(f5);
		this.Shape8.render(f5);
		this.Shape26.render(f5);
		this.Shape28.render(f5);
		this.Shape30.render(f5);
		this.Shape20.render(f5);
		this.Shape22.render(f5);
		this.Shape9.render(f5);
		this.Shape3.render(f5);
		this.Shape32.render(f5);
		this.Shape27.render(f5);
		this.Shape11.render(f5);
		this.Shape15.render(f5);
		this.Shape31.render(f5);
		this.Shape23.render(f5);
		this.Shape34.render(f5);
		this.Shape5.render(f5);
		this.Shape16.render(f5);
		this.Shape19.render(f5);
		this.Shape21.render(f5);
		this.Shape25.render(f5);
		this.Shape33.render(f5);
		this.Shape17.render(f5);
		this.Shape4.render(f5);
		this.Shape14.render(f5);
		this.Shape1.render(f5);
		this.Shape13.render(f5);
		this.Shape18.render(f5);
		this.Shape24.render(f5);
		this.Shape12.render(f5);
		this.Shape29.render(f5);
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.03f, 0.03f, 0.03f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(-30, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.05f, 0.05f, 0.05f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(13, -2, 18);
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
				GL11.glTranslatef(0, 25, 0);
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
				GL11.glTranslatef(-12, 0, 0);
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
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
}
