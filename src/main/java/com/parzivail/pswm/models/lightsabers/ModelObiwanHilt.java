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
 * ObiwanHilt - Undefined Created using Tabula 4.1.1
 */
public class ModelObiwanHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/obiwan_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/obiwan_B.png");

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
	public ModelRenderer Shape14;
	public ModelRenderer Shape16;
	public ModelRenderer Shape18;
	public ModelRenderer Shape23;
	public ModelRenderer Shape25;
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
	public ModelRenderer Shape13;
	public ModelRenderer Shape24;
	public ModelRenderer Shape50;
	public ModelRenderer Shape17;
	public ModelRenderer Shape20;
	public ModelRenderer Shape21;
	public ModelRenderer Shape22;
	public ModelRenderer Shape51;
	public ModelRenderer Shape52;
	public ModelRenderer Shape53;
	public ModelRenderer Shape12;
	public ModelRenderer Shape26;
	public ModelRenderer Shape54;
	public ModelRenderer Shape10;
	public ModelRenderer Shape15;
	public ModelRenderer Shape19;
	public ModelRenderer Shape49;
	public ModelRenderer Shape55;
	public ModelRenderer Shape56;

	public ModelObiwanHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape44 = new ModelRenderer(this, 71, 114);
		this.Shape44.setRotationPoint(62.5F, -2.0F, 3.0F);
		this.Shape44.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
		this.Shape25 = new ModelRenderer(this, 21, 113);
		this.Shape25.setRotationPoint(23.0F, 0.0F, 0.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 3, 8, 8, 0.0F);
		this.Shape28 = new ModelRenderer(this, 0, 203);
		this.Shape28.setRotationPoint(31.0F, 2.0F, 1.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 15, 3, 5, 0.0F);
		this.Shape30 = new ModelRenderer(this, 61, 9);
		this.Shape30.setRotationPoint(28.0F, 0.5F, 0.5F);
		this.Shape30.addBox(-2.0F, 0.0F, 0.0F, 2, 5, 7, 0.0F);
		this.setRotateAngle(this.Shape30, 0.0F, -0.0F, -0.296705961227417F);
		this.Shape26 = new ModelRenderer(this, 72, 60);
		this.Shape26.setRotationPoint(17.5F, 0.5F, 0.5F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape32 = new ModelRenderer(this, 93, 74);
		this.Shape32.setRotationPoint(34.0F, 1.0F, 1.0F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape53 = new ModelRenderer(this, 49, 94);
		this.Shape53.setRotationPoint(26.0F, 0.5F, 0.5F);
		this.Shape53.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape27 = new ModelRenderer(this, 0, 189);
		this.Shape27.setRotationPoint(27.0F, 4.5F, 0.5F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 25, 3, 7, 0.0F);
		this.Shape47 = new ModelRenderer(this, 39, 8);
		this.Shape47.setRotationPoint(15.5F, -0.5F, 3.0F);
		this.Shape47.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.Shape21 = new ModelRenderer(this, 26, 56);
		this.Shape21.setRotationPoint(62.5F, -1.0F, 7.0F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.Shape20 = new ModelRenderer(this, 26, 63);
		this.Shape20.setRotationPoint(62.5F, 7.0F, -1.0F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.Shape15 = new ModelRenderer(this, 40, 47);
		this.Shape15.setRotationPoint(12.0F, 0.0F, 5.0F);
		this.Shape15.addBox(-5.0F, 0.0F, 0.0F, 5, 2, 3, 0.0F);
		this.setRotateAngle(this.Shape15, 0.0F, -0.0F, -0.8726646304130553F);
		this.Shape16 = new ModelRenderer(this, 40, 39);
		this.Shape16.setRotationPoint(12.0F, 0.0F, 0.0F);
		this.Shape16.addBox(-5.0F, 0.0F, 0.0F, 5, 2, 3, 0.0F);
		this.setRotateAngle(this.Shape16, 0.0F, -0.0F, -0.8726646304130553F);
		this.Shape55 = new ModelRenderer(this, 84, 15);
		this.Shape55.setRotationPoint(54.0F, 3.0F, 8.5F);
		this.Shape55.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Shape8 = new ModelRenderer(this, 0, 135);
		this.Shape8.setRotationPoint(7.0F, 0.5F, 0.5F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape24 = new ModelRenderer(this, 61, 43);
		this.Shape24.setRotationPoint(11.0F, 3.0F, -0.5F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F);
		this.Shape49 = new ModelRenderer(this, 28, 37);
		this.Shape49.setRotationPoint(13.0F, 0.0F, 3.0F);
		this.Shape49.addBox(0.0F, 0.0F, 0.0F, 1, 8, 2, 0.0F);
		this.Shape40 = new ModelRenderer(this, 49, 115);
		this.Shape40.setRotationPoint(58.0F, 0.5F, 0.5F);
		this.Shape40.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape11 = new ModelRenderer(this, 25, 76);
		this.Shape11.setRotationPoint(0.0F, 3.0F, 0.0F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 12, 2, 8, 0.0F);
		this.Shape33 = new ModelRenderer(this, 93, 88);
		this.Shape33.setRotationPoint(36.0F, 1.0F, 1.0F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 22);
		this.Shape2.setRotationPoint(-3.5F, 0.0F, 0.0F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 8, 8, 0.0F);
		this.Shape18 = new ModelRenderer(this, 40, 55);
		this.Shape18.setRotationPoint(12.0F, 8.0F, 0.0F);
		this.Shape18.addBox(-5.0F, -2.0F, 0.0F, 5, 2, 3, 0.0F);
		this.setRotateAngle(this.Shape18, 0.0F, -0.0F, 0.8726646304130553F);
		this.Shape50 = new ModelRenderer(this, 21, 92);
		this.Shape50.setRotationPoint(15.0F, 0.0F, 0.0F);
		this.Shape50.addBox(0.0F, 0.0F, 0.0F, 3, 8, 8, 0.0F);
		this.Shape45 = new ModelRenderer(this, 48, 152);
		this.Shape45.setRotationPoint(62.5F, 3.5F, -2.0F);
		this.Shape45.addBox(0.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
		this.Shape51 = new ModelRenderer(this, 61, 25);
		this.Shape51.setRotationPoint(50.0F, 0.5F, 0.5F);
		this.Shape51.addBox(0.0F, 0.0F, 0.0F, 2, 5, 7, 0.0F);
		this.setRotateAngle(this.Shape51, 0.0F, -0.0F, 0.296705961227417F);
		this.Shape37 = new ModelRenderer(this, 93, 130);
		this.Shape37.setRotationPoint(42.0F, 1.0F, 1.0F);
		this.Shape37.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape9 = new ModelRenderer(this, 0, 152);
		this.Shape9.setRotationPoint(8.5F, 0.5F, 0.5F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape14 = new ModelRenderer(this, 29, 22);
		this.Shape14.setRotationPoint(12.0F, 0.0F, 0.0F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 2, 8, 3, 0.0F);
		this.Shape42 = new ModelRenderer(this, 48, 133);
		this.Shape42.setRotationPoint(61.0F, 0.0F, 0.0F);
		this.Shape42.addBox(0.0F, 0.0F, 0.0F, 5, 8, 8, 0.0F);
		this.Shape39 = new ModelRenderer(this, 62, 169);
		this.Shape39.setRotationPoint(52.0F, 0.0F, 0.0F);
		this.Shape39.addBox(0.0F, 0.0F, 0.0F, 6, 8, 8, 0.0F);
		this.Shape41 = new ModelRenderer(this, 73, 97);
		this.Shape41.setRotationPoint(59.0F, 1.5F, 1.5F);
		this.Shape41.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.Shape4 = new ModelRenderer(this, 0, 83);
		this.Shape4.setRotationPoint(2.5F, 0.5F, 0.5F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape31 = new ModelRenderer(this, 93, 60);
		this.Shape31.setRotationPoint(32.0F, 1.0F, 1.0F);
		this.Shape31.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape36 = new ModelRenderer(this, 93, 116);
		this.Shape36.setRotationPoint(40.0F, 1.0F, 1.0F);
		this.Shape36.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape38 = new ModelRenderer(this, 21, 133);
		this.Shape38.setRotationPoint(46.0F, 1.0F, 1.0F);
		this.Shape38.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
		this.Shape34 = new ModelRenderer(this, 0, 215);
		this.Shape34.setRotationPoint(31.0F, 4.0F, 1.0F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 15, 2, 5, 0.0F);
		this.Shape46 = new ModelRenderer(this, 39, 1);
		this.Shape46.setRotationPoint(15.0F, -1.5F, 2.5F);
		this.Shape46.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.Shape35 = new ModelRenderer(this, 93, 102);
		this.Shape35.setRotationPoint(38.0F, 1.0F, 1.0F);
		this.Shape35.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape19 = new ModelRenderer(this, 40, 63);
		this.Shape19.setRotationPoint(12.0F, 8.0F, 8.0F);
		this.Shape19.addBox(-5.0F, -2.0F, -3.0F, 5, 2, 3, 0.0F);
		this.setRotateAngle(this.Shape19, 0.0F, -0.0F, 0.8726646304130553F);
		this.Shape22 = new ModelRenderer(this, 26, 69);
		this.Shape22.setRotationPoint(62.5F, 7.0F, 7.0F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.Shape5 = new ModelRenderer(this, 45, 204);
		this.Shape5.setRotationPoint(2.0F, 1.0F, 1.0F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 8, 6, 6, 0.0F);
		this.Shape56 = new ModelRenderer(this, 84, 21);
		this.Shape56.setRotationPoint(53.5F, 2.5F, 9.5F);
		this.Shape56.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.Shape13 = new ModelRenderer(this, 93, 144);
		this.Shape13.setRotationPoint(44.0F, 1.0F, 1.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape43 = new ModelRenderer(this, 29, 170);
		this.Shape43.setRotationPoint(60.5F, 0.5F, 0.5F);
		this.Shape43.addBox(0.0F, 0.0F, 0.0F, 7, 7, 7, 0.0F);
		this.Shape12 = new ModelRenderer(this, 92, 31);
		this.Shape12.setRotationPoint(18.0F, 1.0F, 1.0F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 5, 6, 6, 0.0F);
		this.Shape23 = new ModelRenderer(this, 0, 170);
		this.Shape23.setRotationPoint(10.0F, 0.5F, 0.5F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 5, 7, 7, 0.0F);
		this.Shape6 = new ModelRenderer(this, 0, 101);
		this.Shape6.setRotationPoint(4.0F, 0.5F, 0.5F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape17 = new ModelRenderer(this, 26, 50);
		this.Shape17.setRotationPoint(62.5F, -1.0F, -1.0F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.Shape54 = new ModelRenderer(this, 72, 78);
		this.Shape54.setRotationPoint(22.5F, 0.5F, 0.5F);
		this.Shape54.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 65);
		this.Shape3.setRotationPoint(0.0F, 0.5F, 0.5F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 118);
		this.Shape7.setRotationPoint(5.5F, 0.5F, 0.5F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape48 = new ModelRenderer(this, 84, 9);
		this.Shape48.setRotationPoint(53.5F, 2.5F, 8.0F);
		this.Shape48.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 43);
		this.Shape1.setRotationPoint(-2.5F, -0.5F, -0.5F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 9, 9, 0.0F);
		this.Shape52 = new ModelRenderer(this, 1, 5);
		this.Shape52.setRotationPoint(50.0F, 0.5F, 0.5F);
		this.Shape52.addBox(0.0F, 0.0F, 0.0F, 2, 4, 7, 0.0F);
		this.Shape10 = new ModelRenderer(this, 43, 22);
		this.Shape10.setRotationPoint(12.0F, 0.0F, 5.0F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 8, 3, 0.0F);
		this.Shape29 = new ModelRenderer(this, 21, 147);
		this.Shape29.setRotationPoint(27.0F, 1.0F, 1.0F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
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
		this.Shape44.render(f5);
		this.Shape25.render(f5);
		this.Shape28.render(f5);
		this.Shape30.render(f5);
		this.Shape26.render(f5);
		this.Shape32.render(f5);
		this.Shape53.render(f5);
		this.Shape27.render(f5);
		this.Shape47.render(f5);
		this.Shape21.render(f5);
		this.Shape20.render(f5);
		this.Shape15.render(f5);
		this.Shape16.render(f5);
		this.Shape55.render(f5);
		this.Shape8.render(f5);
		this.Shape24.render(f5);
		this.Shape49.render(f5);
		this.Shape40.render(f5);
		this.Shape11.render(f5);
		this.Shape33.render(f5);
		this.Shape2.render(f5);
		this.Shape18.render(f5);
		this.Shape50.render(f5);
		this.Shape45.render(f5);
		this.Shape51.render(f5);
		this.Shape37.render(f5);
		this.Shape9.render(f5);
		this.Shape14.render(f5);
		this.Shape42.render(f5);
		this.Shape39.render(f5);
		this.Shape41.render(f5);
		this.Shape4.render(f5);
		this.Shape31.render(f5);
		this.Shape36.render(f5);
		this.Shape38.render(f5);
		this.Shape34.render(f5);
		this.Shape46.render(f5);
		this.Shape35.render(f5);
		this.Shape19.render(f5);
		this.Shape22.render(f5);
		this.Shape5.render(f5);
		this.Shape56.render(f5);
		this.Shape13.render(f5);
		this.Shape43.render(f5);
		this.Shape12.render(f5);
		this.Shape23.render(f5);
		this.Shape6.render(f5);
		this.Shape17.render(f5);
		this.Shape54.render(f5);
		this.Shape3.render(f5);
		this.Shape7.render(f5);
		this.Shape48.render(f5);
		this.Shape1.render(f5);
		this.Shape52.render(f5);
		this.Shape10.render(f5);
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
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(-38, -2, -2);
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
				GL11.glTranslatef(8, -2, 25);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glTranslatef(-3, -16, 0);
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
				GL11.glScalef(0.042f, 0.042f, 0.042f);
				GL11.glTranslatef(-23, 2, 0);
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
