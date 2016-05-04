package com.parzivail.pswm.models.lightsabers;

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
import org.lwjgl.opengl.GL11;

/**
 * MalgusHilt - Undefined Created using Tabula 4.1.1
 */
public class ModelMalgusHilt extends ModelBase implements IHandlesRender
{
	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/malgus_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/malgus_B.png");

	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
	public ModelRenderer Shape6;
	public ModelRenderer Shape7;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape11;
	public ModelRenderer Shape12;
	public ModelRenderer Shape13;
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
	public ModelRenderer Shape37;
	public ModelRenderer Shape38;
	public ModelRenderer Shape39;
	public ModelRenderer Shape40;
	public ModelRenderer Shape41;
	public ModelRenderer Shape42;
	public ModelRenderer Shape43;
	public ModelRenderer Shape44;
	public ModelRenderer Shape45;
	public ModelRenderer Shape46;
	public ModelRenderer Shape47;
	public ModelRenderer Shape48;
	public ModelRenderer Shape49;
	public ModelRenderer Shape50;

	public ModelMalgusHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape42 = new ModelRenderer(this, 75, 25);
		this.Shape42.setRotationPoint(-13.0F, 8.0F, 2.5F);
		this.Shape42.addBox(0.0F, 0.0F, 0.0F, 9, 2, 1, 0.0F);
		this.Shape30 = new ModelRenderer(this, 56, 29);
		this.Shape30.setRotationPoint(85.0F, 2.0F, 1.5F);
		this.Shape30.addBox(-5.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape30, 0.0F, -0.8726646304130553F, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 102);
		this.Shape5.setRotationPoint(3.5F, -0.5F, -0.5F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
		this.Shape9 = new ModelRenderer(this, 0, 148);
		this.Shape9.setRotationPoint(11.5F, -0.5F, -0.5F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 14, 7, 7, 0.0F);
		this.Shape16 = new ModelRenderer(this, 47, 163);
		this.Shape16.setRotationPoint(28.0F, -1.0F, -1.0F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 1, 8, 8, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 69);
		this.Shape3.setRotationPoint(1.0F, -0.5F, -0.5F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape47 = new ModelRenderer(this, 15, 34);
		this.Shape47.setRotationPoint(-15.0F, -1.0F, 2.5F);
		this.Shape47.addBox(-2.0F, -1.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(this.Shape47, 0.0F, -0.0F, 1.326450228691101F);
		this.Shape17 = new ModelRenderer(this, 37, 183);
		this.Shape17.setRotationPoint(30.0F, -1.5F, -1.5F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 8, 9, 9, 0.0F);
		this.Shape21 = new ModelRenderer(this, 0, 235);
		this.Shape21.setRotationPoint(38.5F, 2.5F, -1.0F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 35, 1, 8, 0.0F);
		this.Shape18 = new ModelRenderer(this, 0, 206);
		this.Shape18.setRotationPoint(38.0F, 0.0F, 0.0F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 36, 6, 6, 0.0F);
		this.Shape43 = new ModelRenderer(this, 75, 39);
		this.Shape43.setRotationPoint(-9.0F, 10.0F, 2.5F);
		this.Shape43.addBox(0.0F, 0.0F, 0.0F, 5, 2, 1, 0.0F);
		this.Shape28 = new ModelRenderer(this, 21, 122);
		this.Shape28.setRotationPoint(31.0F, -3.5F, 1.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 6, 2, 3, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 132);
		this.Shape7.setRotationPoint(8.5F, 0.0F, 0.0F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 185);
		this.Shape11.setRotationPoint(20.0F, -1.0F, -1.0F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 5, 8, 8, 0.0F);
		this.Shape35 = new ModelRenderer(this, 73, 94);
		this.Shape35.setRotationPoint(-4.0F, -9.0F, 2.5F);
		this.Shape35.addBox(0.0F, 0.0F, 0.0F, 21, 7, 1, 0.0F);
		this.Shape41 = new ModelRenderer(this, 0, 0);
		this.Shape41.setRotationPoint(-6.0F, -7.0F, 2.5F);
		this.Shape41.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.Shape38 = new ModelRenderer(this, 0, 20);
		this.Shape38.setRotationPoint(-4.0F, 15.0F, 2.5F);
		this.Shape38.addBox(-13.0F, -2.0F, 0.0F, 13, 2, 1, 0.0F);
		this.setRotateAngle(this.Shape38, 0.0F, -0.0F, 0.4886921942234039F);
		this.Shape48 = new ModelRenderer(this, 35, 27);
		this.Shape48.setRotationPoint(-10.0F, -5.0F, 2.5F);
		this.Shape48.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.Shape25 = new ModelRenderer(this, 27, 59);
		this.Shape25.setRotationPoint(73.0F, -3.5F, 2.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 9, 13, 2, 0.0F);
		this.Shape31 = new ModelRenderer(this, 56, 44);
		this.Shape31.setRotationPoint(85.0F, 2.0F, 4.5F);
		this.Shape31.addBox(-5.0F, 0.0F, -2.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape31, 0.0F, 0.8726646304130553F, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 54);
		this.Shape1.setRotationPoint(0.0F, 0.5F, 0.5F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape24 = new ModelRenderer(this, 0, 31);
		this.Shape24.setRotationPoint(83.0F, 1.5F, 1.5F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
		this.Shape34 = new ModelRenderer(this, 48, 124);
		this.Shape34.setRotationPoint(17.0F, -3.0F, 2.5F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 9, 12, 1, 0.0F);
		this.Shape44 = new ModelRenderer(this, 0, 5);
		this.Shape44.setRotationPoint(-6.0F, 12.0F, 2.5F);
		this.Shape44.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.Shape29 = new ModelRenderer(this, 23, 78);
		this.Shape29.setRotationPoint(73.0F, 2.0F, -3.5F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 9, 2, 13, 0.0F);
		this.Shape22 = new ModelRenderer(this, 47, 144);
		this.Shape22.setRotationPoint(70.0F, -0.5F, -0.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
		this.Shape13 = new ModelRenderer(this, 85, 60);
		this.Shape13.setRotationPoint(18.5F, 2.5F, -2.5F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 2, 2, 11, 0.0F);
		this.Shape26 = new ModelRenderer(this, 56, 22);
		this.Shape26.setRotationPoint(85.0F, 1.5F, 2.0F);
		this.Shape26.addBox(-5.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape26, 0.0F, -0.0F, 0.8726646304130553F);
		this.Shape12 = new ModelRenderer(this, 94, 43);
		this.Shape12.setRotationPoint(18.0F, 2.0F, -1.5F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 3, 3, 9, 0.0F);
		this.Shape27 = new ModelRenderer(this, 56, 36);
		this.Shape27.setRotationPoint(85.0F, 4.5F, 2.0F);
		this.Shape27.addBox(-5.0F, -2.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape27, 0.0F, -0.0F, -0.8726646304130553F);
		this.Shape32 = new ModelRenderer(this, 0, 15);
		this.Shape32.setRotationPoint(-15.0F, -3.0F, 2.5F);
		this.Shape32.addBox(0.0F, 1.0F, 0.0F, 41, 1, 1, 0.0F);
		this.Shape50 = new ModelRenderer(this, 35, 23);
		this.Shape50.setRotationPoint(-10.0F, 10.0F, 2.5F);
		this.Shape50.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.Shape36 = new ModelRenderer(this, 73, 81);
		this.Shape36.setRotationPoint(-4.0F, 8.0F, 2.5F);
		this.Shape36.addBox(0.0F, 0.0F, 0.0F, 21, 7, 1, 0.0F);
		this.Shape37 = new ModelRenderer(this, 0, 25);
		this.Shape37.setRotationPoint(-4.0F, -9.0F, 2.5F);
		this.Shape37.addBox(-13.0F, 0.0F, 0.0F, 13, 2, 1, 0.0F);
		this.setRotateAngle(this.Shape37, 0.0F, -0.0F, -0.4886921942234039F);
		this.Shape15 = new ModelRenderer(this, 20, 132);
		this.Shape15.setRotationPoint(25.0F, 0.0F, 0.0F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 5, 6, 6, 0.0F);
		this.Shape45 = new ModelRenderer(this, 56, 56);
		this.Shape45.setRotationPoint(17.0F, -9.0F, 2.5F);
		this.Shape45.addBox(0.0F, 0.0F, 0.0F, 9, 5, 1, 0.0F);
		this.setRotateAngle(this.Shape45, 0.0F, -0.0F, 0.7853981852531433F);
		this.Shape19 = new ModelRenderer(this, 28, 98);
		this.Shape19.setRotationPoint(74.0F, -1.5F, -1.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 7, 9, 9, 0.0F);
		this.Shape23 = new ModelRenderer(this, 27, 43);
		this.Shape23.setRotationPoint(81.0F, 0.0F, 0.0F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 42);
		this.Shape2.setRotationPoint(-0.5F, 1.0F, 1.0F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
		this.Shape6 = new ModelRenderer(this, 0, 120);
		this.Shape6.setRotationPoint(7.5F, 1.0F, 2.0F);
		this.Shape6.addBox(0.0F, 0.0F, -1.0F, 4, 4, 4, 0.0F);
		this.Shape8 = new ModelRenderer(this, 0, 166);
		this.Shape8.setRotationPoint(12.0F, -1.0F, -1.0F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 7, 8, 8, 0.0F);
		this.Shape39 = new ModelRenderer(this, 75, 30);
		this.Shape39.setRotationPoint(-13.0F, -4.0F, 2.5F);
		this.Shape39.addBox(0.0F, 0.0F, 0.0F, 9, 2, 1, 0.0F);
		this.Shape49 = new ModelRenderer(this, 15, 38);
		this.Shape49.setRotationPoint(-15.0F, 7.0F, 2.5F);
		this.Shape49.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
		this.setRotateAngle(this.Shape49, 0.0F, -0.0F, 0.2617993950843811F);
		this.Shape33 = new ModelRenderer(this, 0, 10);
		this.Shape33.setRotationPoint(-15.0F, 7.0F, 2.5F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 41, 1, 1, 0.0F);
		this.Shape46 = new ModelRenderer(this, 56, 65);
		this.Shape46.setRotationPoint(17.0F, 15.0F, 2.5F);
		this.Shape46.addBox(0.0F, -5.0F, 0.0F, 9, 5, 1, 0.0F);
		this.setRotateAngle(this.Shape46, 0.0F, -0.0F, -0.7853981852531433F);
		this.Shape4 = new ModelRenderer(this, 0, 87);
		this.Shape4.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape20 = new ModelRenderer(this, 0, 222);
		this.Shape20.setRotationPoint(38.5F, -1.0F, 2.5F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 35, 8, 1, 0.0F);
		this.Shape40 = new ModelRenderer(this, 75, 45);
		this.Shape40.setRotationPoint(-8.0F, -6.0F, 2.5F);
		this.Shape40.addBox(0.0F, 0.0F, 0.0F, 5, 2, 1, 0.0F);
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
		this.Shape42.render(f5);
		this.Shape30.render(f5);
		this.Shape5.render(f5);
		this.Shape9.render(f5);
		this.Shape16.render(f5);
		this.Shape3.render(f5);
		this.Shape47.render(f5);
		this.Shape17.render(f5);
		this.Shape21.render(f5);
		this.Shape18.render(f5);
		this.Shape43.render(f5);
		this.Shape28.render(f5);
		this.Shape7.render(f5);
		this.Shape11.render(f5);
		this.Shape35.render(f5);
		this.Shape41.render(f5);
		this.Shape38.render(f5);
		this.Shape48.render(f5);
		this.Shape25.render(f5);
		this.Shape31.render(f5);
		this.Shape1.render(f5);
		this.Shape24.render(f5);
		this.Shape34.render(f5);
		this.Shape44.render(f5);
		this.Shape29.render(f5);
		this.Shape22.render(f5);
		this.Shape13.render(f5);
		this.Shape26.render(f5);
		this.Shape12.render(f5);
		this.Shape27.render(f5);
		this.Shape32.render(f5);
		this.Shape50.render(f5);
		this.Shape36.render(f5);
		this.Shape37.render(f5);
		this.Shape15.render(f5);
		this.Shape45.render(f5);
		this.Shape19.render(f5);
		this.Shape23.render(f5);
		this.Shape2.render(f5);
		this.Shape6.render(f5);
		this.Shape8.render(f5);
		this.Shape39.render(f5);
		this.Shape49.render(f5);
		this.Shape33.render(f5);
		this.Shape46.render(f5);
		this.Shape4.render(f5);
		this.Shape20.render(f5);
		this.Shape40.render(f5);
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.025f, 0.025f, 0.025f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(-45, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.035f, 0.035f, 0.035f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(5, -2, 30);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glTranslatef(-8, -20, 0);
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
				GL11.glRotatef(70, 1, 0, 0);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.032f, 0.032f, 0.032f);
				GL11.glTranslatef(-23, 4, 0);
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
