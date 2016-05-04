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

public class ModelLuke2Hilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke2_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke2_B.png");

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
	ModelRenderer Shape31;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape18;

	public ModelLuke2Hilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.Shape1 = new ModelRenderer(this, 31, 60);
		this.Shape1.addBox(0F, 0F, 0F, 1, 8, 8);
		this.Shape1.setRotationPoint(-1F, 0F, 0F);
		this.Shape1.setTextureSize(128, 128);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape2 = new ModelRenderer(this, 45, 86);
		this.Shape2.addBox(0F, 0F, 0F, 3, 6, 6);
		this.Shape2.setRotationPoint(0F, 1F, 1F);
		this.Shape2.setTextureSize(128, 128);
		this.Shape2.mirror = true;
		this.setRotation(this.Shape2, 0F, 0F, 0F);
		this.Shape3 = new ModelRenderer(this, 39, 108);
		this.Shape3.addBox(0F, 0F, 0F, 2, 2, 2);
		this.Shape3.setRotationPoint(5F, 3F, 3F);
		this.Shape3.setTextureSize(128, 128);
		this.Shape3.mirror = true;
		this.setRotation(this.Shape3, 0F, 0F, 0F);
		this.Shape4 = new ModelRenderer(this, 0, 104);
		this.Shape4.addBox(0F, 0F, 0F, 9, 4, 4);
		this.Shape4.setRotationPoint(13F, 2F, 2F);
		this.Shape4.setTextureSize(128, 128);
		this.Shape4.mirror = true;
		this.setRotation(this.Shape4, 0F, 0F, 0F);
		this.Shape5 = new ModelRenderer(this, 0, 85);
		this.Shape5.addBox(0F, 0F, 0F, 2, 8, 8);
		this.Shape5.setRotationPoint(41F, 0F, 0F);
		this.Shape5.setTextureSize(128, 128);
		this.Shape5.mirror = true;
		this.setRotation(this.Shape5, 0F, 0F, 0F);
		this.Shape6 = new ModelRenderer(this, 0, 70);
		this.Shape6.addBox(0F, 0F, 0F, 8, 4, 4);
		this.Shape6.setRotationPoint(23F, 2F, -1F);
		this.Shape6.setTextureSize(128, 128);
		this.Shape6.mirror = true;
		this.setRotation(this.Shape6, 0F, 0F, 0F);
		this.Shape7 = new ModelRenderer(this, 29, 89);
		this.Shape7.addBox(0F, 0F, 0F, 2, 4, 4);
		this.Shape7.setRotationPoint(3F, 2F, 2F);
		this.Shape7.setTextureSize(128, 128);
		this.Shape7.mirror = true;
		this.setRotation(this.Shape7, 0F, 0F, 0F);
		this.Shape8 = new ModelRenderer(this, 0, 114);
		this.Shape8.addBox(0F, 0F, 0F, 24, 6, 6);
		this.Shape8.setRotationPoint(22F, 1F, 1F);
		this.Shape8.setTextureSize(128, 128);
		this.Shape8.mirror = true;
		this.setRotation(this.Shape8, 0F, 0F, 0F);
		this.Shape9 = new ModelRenderer(this, 20, 45);
		this.Shape9.addBox(0F, 0F, 0F, 1, 4, 4);
		this.Shape9.setRotationPoint(-2F, 2F, 2F);
		this.Shape9.setTextureSize(128, 128);
		this.Shape9.mirror = true;
		this.setRotation(this.Shape9, 0F, 0F, 0F);
		this.Shape10 = new ModelRenderer(this, 63, 118);
		this.Shape10.addBox(0F, 0F, 0F, 4, 4, 4);
		this.Shape10.setRotationPoint(7F, 2F, 2F);
		this.Shape10.setTextureSize(128, 128);
		this.Shape10.mirror = true;
		this.setRotation(this.Shape10, 0F, 0F, 0F);
		this.Shape11 = new ModelRenderer(this, 16, 0);
		this.Shape11.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Shape11.setRotationPoint(9F, 1F, 1F);
		this.Shape11.setTextureSize(128, 128);
		this.Shape11.mirror = true;
		this.setRotation(this.Shape11, 0F, 0F, 0F);
		this.Shape31 = new ModelRenderer(this, 28, 108);
		this.Shape31.addBox(0F, 0F, 0F, 2, 2, 2);
		this.Shape31.setRotationPoint(11F, 3F, 3F);
		this.Shape31.setTextureSize(128, 128);
		this.Shape31.mirror = true;
		this.setRotation(this.Shape31, 0F, 0F, 0F);
		this.Shape12 = new ModelRenderer(this, 0, 56);
		this.Shape12.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Shape12.setRotationPoint(20F, 1F, 1F);
		this.Shape12.setTextureSize(128, 128);
		this.Shape12.mirror = true;
		this.setRotation(this.Shape12, 0F, 0F, 0F);
		this.Shape13 = new ModelRenderer(this, 0, 42);
		this.Shape13.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Shape13.setRotationPoint(18F, 1F, 1F);
		this.Shape13.setTextureSize(128, 128);
		this.Shape13.mirror = true;
		this.setRotation(this.Shape13, 0F, 0F, 0F);
		this.Shape14 = new ModelRenderer(this, 60, 0);
		this.Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Shape14.setRotationPoint(24F, 1.5F, -0.5F);
		this.Shape14.setTextureSize(128, 128);
		this.Shape14.mirror = true;
		this.setRotation(this.Shape14, 0F, 0F, 0F);
		this.Shape15 = new ModelRenderer(this, 73, 0);
		this.Shape15.addBox(0F, 0F, 0F, 1, 1, 1);
		this.Shape15.setRotationPoint(26F, 1.5F, -0.5F);
		this.Shape15.setTextureSize(128, 128);
		this.Shape15.mirror = true;
		this.setRotation(this.Shape15, 0F, 0F, 0F);
		this.Shape16 = new ModelRenderer(this, 36, 13);
		this.Shape16.addBox(0F, 0F, 0F, 3, 4, 1);
		this.Shape16.setRotationPoint(27.9F, 1.5F, -0.5F);
		this.Shape16.setTextureSize(128, 128);
		this.Shape16.mirror = true;
		this.setRotation(this.Shape16, 0F, 0F, 0F);
		this.Shape17 = new ModelRenderer(this, 0, 28);
		this.Shape17.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Shape17.setRotationPoint(16F, 1F, 1F);
		this.Shape17.setTextureSize(128, 128);
		this.Shape17.mirror = true;
		this.setRotation(this.Shape17, 0F, 0F, 0F);
		this.Shape18 = new ModelRenderer(this, 0, 0);
		this.Shape18.addBox(0F, 0F, 0F, 1, 6, 6);
		this.Shape18.setRotationPoint(14F, 1F, 1F);
		this.Shape18.setTextureSize(128, 128);
		this.Shape18.mirror = true;
		this.setRotation(this.Shape18, 0F, 0F, 0F);
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
		this.Shape31.render(f5);
		this.Shape12.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape15.render(f5);
		this.Shape16.render(f5);
		this.Shape17.render(f5);
		this.Shape18.render(f5);
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
					GL11.glTranslatef(0, 3, -5);
				}
				else
				{
					GL11.glRotatef(180, 1, 0, 0);
					GL11.glTranslatef(-4, 0, -6);
				}
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glTranslatef(-4, 0, -6);
				this.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.035F, -0.035F, 0.035F);
				GL11.glRotatef(90, 0, 0, 1);
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