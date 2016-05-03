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

public class ModelLuke1Hilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke1_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke1_B.png");

	ModelRenderer Shape1;

	ModelRenderer Shape2;

	ModelRenderer Shape3;

	ModelRenderer Shape4;

	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape18;
	ModelRenderer Shape19;
	ModelRenderer Shape20;
	ModelRenderer Shape21;
	ModelRenderer Shape22;
	ModelRenderer Shape23;
	ModelRenderer Shape24;
	ModelRenderer Shape25;
	ModelRenderer Shape26;
	ModelRenderer Shape27;
	ModelRenderer Shape28;
	ModelRenderer Shape29;
	ModelRenderer Shape30;
	ModelRenderer Shape31;

	public ModelLuke1Hilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.Shape1 = new ModelRenderer(this, 0, 113);
		this.Shape1.addBox(0F, 0F, 0F, 33, 6, 6);
		this.Shape1.setRotationPoint(11F, 0F, 0F);
		this.Shape1.setTextureSize(64, 32);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape2 = new ModelRenderer(this, 0, 94);
		this.Shape2.addBox(0F, 0F, 0F, 8, 7, 7);
		this.Shape2.setRotationPoint(22F, -0.5F, -0.5F);
		this.Shape2.setTextureSize(64, 32);
		this.Shape2.mirror = true;
		this.setRotation(this.Shape2, 0F, 0F, 0F);
		this.Shape3 = new ModelRenderer(this, 0, 28);
		this.Shape3.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape3.setRotationPoint(32F, -0.5F, -0.5F);
		this.Shape3.setTextureSize(64, 32);
		this.Shape3.mirror = true;
		this.setRotation(this.Shape3, 0F, 0F, 0F);
		this.Shape4 = new ModelRenderer(this, 0, 23);
		this.Shape4.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape4.setRotationPoint(32F, -1F, 1.5F);
		this.Shape4.setTextureSize(64, 32);
		this.Shape4.mirror = true;
		this.setRotation(this.Shape4, 0F, 0F, 0F);
		this.Shape5 = new ModelRenderer(this, 0, 18);
		this.Shape5.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape5.setRotationPoint(32F, -1F, 3.5F);
		this.Shape5.setTextureSize(64, 32);
		this.Shape5.mirror = true;
		this.setRotation(this.Shape5, 0F, 0F, 0F);
		this.Shape6 = new ModelRenderer(this, 0, 76);
		this.Shape6.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape6.setRotationPoint(32F, -0.5F, 5.5F);
		this.Shape6.setTextureSize(64, 32);
		this.Shape6.mirror = true;
		this.setRotation(this.Shape6, 0F, 0F, 0F);
		this.Shape7 = new ModelRenderer(this, 0, 61);
		this.Shape7.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape7.setRotationPoint(32F, 5.5F, 5.5F);
		this.Shape7.setTextureSize(64, 32);
		this.Shape7.mirror = true;
		this.setRotation(this.Shape7, 0F, 0F, 0F);
		this.Shape8 = new ModelRenderer(this, 0, 44);
		this.Shape8.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape8.setRotationPoint(32F, 5.5F, -0.5F);
		this.Shape8.setTextureSize(64, 32);
		this.Shape8.mirror = true;
		this.setRotation(this.Shape8, 0F, 0F, 0F);
		this.Shape9 = new ModelRenderer(this, 0, 38);
		this.Shape9.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape9.setRotationPoint(32F, 3.5F, -1F);
		this.Shape9.setTextureSize(64, 32);
		this.Shape9.mirror = true;
		this.setRotation(this.Shape9, 0F, 0F, 0F);
		this.Shape10 = new ModelRenderer(this, 0, 33);
		this.Shape10.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape10.setRotationPoint(32F, 1.5F, -1F);
		this.Shape10.setTextureSize(64, 32);
		this.Shape10.mirror = true;
		this.setRotation(this.Shape10, 0F, 0F, 0F);
		this.Shape11 = new ModelRenderer(this, 0, 71);
		this.Shape11.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape11.setRotationPoint(32F, 1.5F, 6F);
		this.Shape11.setTextureSize(64, 32);
		this.Shape11.mirror = true;
		this.setRotation(this.Shape11, 0F, 0F, 0F);
		this.Shape12 = new ModelRenderer(this, 0, 66);
		this.Shape12.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape12.setRotationPoint(32F, 3.5F, 6F);
		this.Shape12.setTextureSize(64, 32);
		this.Shape12.mirror = true;
		this.setRotation(this.Shape12, 0F, 0F, 0F);
		this.Shape13 = new ModelRenderer(this, 0, 49);
		this.Shape13.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape13.setRotationPoint(32F, 6F, 1.5F);
		this.Shape13.setTextureSize(64, 32);
		this.Shape13.mirror = true;
		this.setRotation(this.Shape13, 0F, 0F, 0F);
		this.Shape14 = new ModelRenderer(this, 0, 55);
		this.Shape14.addBox(0F, 0F, 0F, 11, 1, 1);
		this.Shape14.setRotationPoint(32F, 6F, 3.5F);
		this.Shape14.setTextureSize(64, 32);
		this.Shape14.mirror = true;
		this.setRotation(this.Shape14, 0F, 0F, 0F);
		this.Shape15 = new ModelRenderer(this, 12, 3);
		this.Shape15.addBox(0F, 0F, 0F, 1, 4, 4);
		this.Shape15.setRotationPoint(43.5F, 1F, 1F);
		this.Shape15.setTextureSize(64, 32);
		this.Shape15.mirror = true;
		this.setRotation(this.Shape15, 0F, 0F, 0F);
		this.Shape16 = new ModelRenderer(this, 30, 4);
		this.Shape16.addBox(0F, 0F, 0F, 1, 3, 3);
		this.Shape16.setRotationPoint(10F, 1.5F, 1.5F);
		this.Shape16.setTextureSize(64, 32);
		this.Shape16.mirror = true;
		this.setRotation(this.Shape16, 0F, 0F, 0F);
		this.Shape17 = new ModelRenderer(this, 43, 1);
		this.Shape17.addBox(0F, 0F, 0F, 1, 5, 5);
		this.Shape17.setRotationPoint(9F, 0.5F, 0.5F);
		this.Shape17.setTextureSize(64, 32);
		this.Shape17.mirror = true;
		this.setRotation(this.Shape17, 0F, 0F, 0F);
		this.Shape18 = new ModelRenderer(this, 59, 3);
		this.Shape18.addBox(0F, 0F, 0F, 2, 4, 4);
		this.Shape18.setRotationPoint(7F, 1F, 1F);
		this.Shape18.setTextureSize(64, 32);
		this.Shape18.mirror = true;
		this.setRotation(this.Shape18, 0F, 0F, 0F);
		this.Shape19 = new ModelRenderer(this, 76, 1);
		this.Shape19.addBox(0F, 0F, 0F, 1, 5, 5);
		this.Shape19.setRotationPoint(6F, 0.5F, 0.5F);
		this.Shape19.setTextureSize(64, 32);
		this.Shape19.mirror = true;
		this.setRotation(this.Shape19, 0F, 0F, 0F);
		this.Shape20 = new ModelRenderer(this, 70, 80);
		this.Shape20.addBox(0F, 0F, 0F, 2, 2, 2);
		this.Shape20.setRotationPoint(12F, -1F, 2F);
		this.Shape20.setTextureSize(64, 32);
		this.Shape20.mirror = true;
		this.setRotation(this.Shape20, 0F, 0F, 0F);
		this.Shape21 = new ModelRenderer(this, 33, 64);
		this.Shape21.addBox(0F, 0F, 0F, 6, 1, 6);
		this.Shape21.setRotationPoint(5F, 0F, 0F);
		this.Shape21.setTextureSize(64, 32);
		this.Shape21.mirror = true;
		this.setRotation(this.Shape21, 0F, 0F, 0F);
		this.Shape22 = new ModelRenderer(this, 29, 48);
		this.Shape22.addBox(0F, 0F, 0F, 6, 1, 1);
		this.Shape22.setRotationPoint(5F, 1F, 5F);
		this.Shape22.setTextureSize(64, 32);
		this.Shape22.mirror = true;
		this.setRotation(this.Shape22, 0F, 0F, 0F);
		this.Shape23 = new ModelRenderer(this, 29, 55);
		this.Shape23.addBox(0F, 0F, 0F, 6, 1, 1);
		this.Shape23.setRotationPoint(5F, 1F, 0F);
		this.Shape23.setTextureSize(64, 32);
		this.Shape23.mirror = true;
		this.setRotation(this.Shape23, 0F, 0F, 0F);
		this.Shape24 = new ModelRenderer(this, 30, 32);
		this.Shape24.addBox(0F, 0F, 0F, 3, 2, 1);
		this.Shape24.setRotationPoint(8F, 2F, 0F);
		this.Shape24.setTextureSize(64, 32);
		this.Shape24.mirror = true;
		this.setRotation(this.Shape24, 0F, 0F, 0F);
		this.Shape25 = new ModelRenderer(this, 30, 40);
		this.Shape25.addBox(0F, 0F, 0F, 3, 2, 1);
		this.Shape25.setRotationPoint(8F, 2F, 5F);
		this.Shape25.setTextureSize(64, 32);
		this.Shape25.mirror = true;
		this.setRotation(this.Shape25, 0F, 0F, 0F);
		this.Shape26 = new ModelRenderer(this, 47, 83);
		this.Shape26.addBox(0F, 0F, 0F, 3, 3, 1);
		this.Shape26.setRotationPoint(7F, -3F, 1.5F);
		this.Shape26.setTextureSize(64, 32);
		this.Shape26.mirror = true;
		this.setRotation(this.Shape26, 0F, 0F, 0F);
		this.Shape27 = new ModelRenderer(this, 35, 83);
		this.Shape27.addBox(0F, 0F, 0F, 3, 3, 1);
		this.Shape27.setRotationPoint(7F, -3F, 3.5F);
		this.Shape27.setTextureSize(64, 32);
		this.Shape27.mirror = true;
		this.setRotation(this.Shape27, 0F, 0F, 0F);
		this.Shape28 = new ModelRenderer(this, 42, 90);
		this.Shape28.addBox(0F, 0F, 0F, 3, 1, 1);
		this.Shape28.setRotationPoint(7F, -1F, 2.5F);
		this.Shape28.setTextureSize(64, 32);
		this.Shape28.mirror = true;
		this.setRotation(this.Shape28, 0F, 0F, 0F);
		this.Shape29 = new ModelRenderer(this, 72, 87);
		this.Shape29.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Shape29.setRotationPoint(12.5F, -1.5F, 2.5F);
		this.Shape29.setTextureSize(64, 32);
		this.Shape29.mirror = true;
		this.setRotation(this.Shape29, 0F, 0F, 0F);
		this.Shape30 = new ModelRenderer(this, 38, 103);
		this.Shape30.addBox(0F, 0F, 0F, 11, 1, 3);
		this.Shape30.setRotationPoint(10.5F, 5.5F, 1.5F);
		this.Shape30.setTextureSize(64, 32);
		this.Shape30.mirror = true;
		this.setRotation(this.Shape30, 0F, 0F, 0F);
		this.Shape31 = new ModelRenderer(this, 0, 85);
		this.Shape31.addBox(0F, 0F, 0F, 7, 3, 2);
		this.Shape31.setRotationPoint(22.5F, 2F, 6F);
		this.Shape31.setTextureSize(64, 32);
		this.Shape31.mirror = true;
		this.setRotation(this.Shape31, 0F, 0F, 0F);
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
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape4.render(f5);
		this.Shape5.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
		this.Shape8.render(f5);
		this.Shape9.render(f5);
		this.Shape10.render(f5);
		this.Shape11.render(f5);
		this.Shape12.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape15.render(f5);
		this.Shape16.render(f5);
		this.Shape17.render(f5);
		this.Shape18.render(f5);
		this.Shape19.render(f5);
		this.Shape20.render(f5);
		this.Shape21.render(f5);
		this.Shape22.render(f5);
		this.Shape23.render(f5);
		this.Shape24.render(f5);
		this.Shape25.render(f5);
		this.Shape26.render(f5);
		this.Shape27.render(f5);
		this.Shape28.render(f5);
		this.Shape29.render(f5);
		this.Shape30.render(f5);
		this.Shape31.render(f5);
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslatef(-13, -6.5f, -3.5f);
				GL11.glRotatef(25, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(2, 6.5f, 2f);
				this.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glRotatef(-40, 0, 1, 0);
				GL11.glRotatef(22, 0, 0, 1);
				if (data[1] instanceof EntityPlayer && ((EntityPlayer)data[1]).isBlocking())
				{
					GL11.glRotatef(30, 0, 1, 0);
					GL11.glTranslatef(-5, 0, 7.1f);
				}
				GL11.glTranslatef(0, -16.25f, 20);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(3, -20, 0);
				this.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslatef(8, -23, 9);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glRotatef(20, 1, 0, 0);
				if (data[1] instanceof EntityPlayer && ((EntityPlayer)data[1]).isBlocking())
				{
					GL11.glRotatef(-30, 0, 0, 1);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(2, 0, -10.8f);
					GL11.glRotatef(-20, 0, 0, 1);
					GL11.glTranslatef(-5, 0, -3);
				}
				else
				{
					GL11.glRotatef(180, 1, 0, 0);
					GL11.glTranslatef(-4, 0, -6);
				}
				GL11.glTranslatef(0, 3.85f, 0.1f);
				GL11.glRotatef(90, 1, 0, 0);
				this.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.035F, -0.035F, 0.035F);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(-25, -2, -2);
				this.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\models\ModelLightsaber.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */