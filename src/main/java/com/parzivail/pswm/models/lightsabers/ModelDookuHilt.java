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
 * Duku's Hilt - Undefined Created using Tabula 4.1.1
 */
public class ModelDookuHilt extends ModelBase implements IHandlesRender
{
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
	public ModelRenderer Shape1;
	public ModelRenderer Shape22;
	public ModelRenderer Shape23;
	public ModelRenderer Shape24;
	public ModelRenderer Shape25;
	public ModelRenderer Shape26;
	public ModelRenderer Shape27;
	public ModelRenderer Shape28;
	public ModelRenderer Shape29;

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/dooku_A.png");

	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/dooku_B.png");

	public ModelDookuHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape11 = new ModelRenderer(this, 48, 46);
		this.Shape11.setRotationPoint(-7.0F, 7.0F, 2.0F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 3, 5, 2, 0.0F);
		this.setRotateAngle(this.Shape11, 0.0F, -0.0F, 0.2094395160675048F);
		this.Shape5 = new ModelRenderer(this, 107, 42);
		this.Shape5.setRotationPoint(6.5F, -0.5F, -0.5F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape17 = new ModelRenderer(this, 0, 70);
		this.Shape17.setRotationPoint(27.0F, 0.0F, 0.0F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 4, 6, 6, 0.0F);
		this.Shape13 = new ModelRenderer(this, 0, 3);
		this.Shape13.setRotationPoint(-24.0F, 11.0F, 2.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 4, 3, 2, 0.0F);
		this.Shape16 = new ModelRenderer(this, 0, 25);
		this.Shape16.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 22, 6, 6, 0.0F);
		this.Shape10 = new ModelRenderer(this, 75, 73);
		this.Shape10.setRotationPoint(24.0F, -0.5F, -0.5F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape20 = new ModelRenderer(this, 60, 7);
		this.Shape20.setRotationPoint(38.0F, 4.5F, 0.5F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.setRotateAngle(this.Shape20, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape3 = new ModelRenderer(this, 107, 90);
		this.Shape3.setRotationPoint(-5.0F, 1.5F, -0.5F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.setRotateAngle(this.Shape3, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape22 = new ModelRenderer(this, 47, 96);
		this.Shape22.setRotationPoint(11.0F, -0.5F, -0.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 12, 2, 7, 0.0F);
		this.Shape28 = new ModelRenderer(this, 139, 25);
		this.Shape28.setRotationPoint(1.0F, 4.0F, -0.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 1, 3, 7, 0.0F);
		this.setRotateAngle(this.Shape28, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape14 = new ModelRenderer(this, 26, 3);
		this.Shape14.setRotationPoint(-7.0F, 1.0F, 2.0F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape14, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape6 = new ModelRenderer(this, 0, 94);
		this.Shape6.setRotationPoint(31.0F, 0.0F, 0.0F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 9, 6, 6, 0.0F);
		this.setRotateAngle(this.Shape6, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape12 = new ModelRenderer(this, 0, 160);
		this.Shape12.setRotationPoint(-20.0F, 14.0F, 2.0F);
		this.Shape12.addBox(0.0F, -2.0F, 0.0F, 15, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape12, 0.0F, -0.0F, -0.12217304855585097F);
		this.Shape24 = new ModelRenderer(this, 47, 112);
		this.Shape24.setRotationPoint(11.0F, 3.5F, -0.5F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 13, 3, 7, 0.0F);
		this.Shape25 = new ModelRenderer(this, 107, 6);
		this.Shape25.setRotationPoint(23.0F, 1.5F, -0.5F);
		this.Shape25.addBox(-2.0F, -1.0F, 0.0F, 2, 1, 7, 0.0F);
		this.setRotateAngle(this.Shape25, 0.0F, -0.0F, -0.4886921942234039F);
		this.Shape9 = new ModelRenderer(this, 68, 26);
		this.Shape9.setRotationPoint(30.5F, 5.5F, 2.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape9, 0.0F, -0.0F, 0.767944872379303F);
		this.Shape15 = new ModelRenderer(this, 81, 7);
		this.Shape15.setRotationPoint(26.0F, 0.5F, 0.5F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 45);
		this.Shape2.setRotationPoint(4.0F, 0.0F, 0.0F);
		this.Shape2.addBox(-14.0F, 0.0F, 0.0F, 14, 6, 6, 0.0F);
		this.setRotateAngle(this.Shape2, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape21 = new ModelRenderer(this, 38, 66);
		this.Shape21.setRotationPoint(32.5F, 0.30000001192092896F, -0.5F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 6, 7, 7, 0.0F);
		this.setRotateAngle(this.Shape21, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape18 = new ModelRenderer(this, 70, 56);
		this.Shape18.setRotationPoint(28.0F, 2.0F, -0.5F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 2, 7, 0.0F);
		this.Shape19 = new ModelRenderer(this, 70, 38);
		this.Shape19.setRotationPoint(39.0F, 10.0F, -1.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 2, 9, 0.0F);
		this.setRotateAngle(this.Shape19, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape8 = new ModelRenderer(this, 0, 116);
		this.Shape8.setRotationPoint(40.0F, 4.5F, -1.0F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
		this.setRotateAngle(this.Shape8, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape29 = new ModelRenderer(this, 139, 6);
		this.Shape29.setRotationPoint(-1.0F, 4.5F, -0.5F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 1, 3, 7, 0.0F);
		this.setRotateAngle(this.Shape29, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape23 = new ModelRenderer(this, 107, 21);
		this.Shape23.setRotationPoint(24.0F, 2.5F, -0.5F);
		this.Shape23.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 7, 0.0F);
		this.setRotateAngle(this.Shape23, 0.0F, -0.0F, -0.4886921942234039F);
		this.Shape1 = new ModelRenderer(this, 38, 15);
		this.Shape1.setRotationPoint(33.0F, 2.0F, -2.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(this.Shape1, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape7 = new ModelRenderer(this, 0, 14);
		this.Shape7.setRotationPoint(37.0F, 1.5F, 2.0F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 13, 4, 2, 0.0F);
		this.setRotateAngle(this.Shape7, 0.0F, -0.0F, 0.5061454772949219F);
		this.Shape27 = new ModelRenderer(this, 139, 44);
		this.Shape27.setRotationPoint(3.0F, 3.5F, -0.5F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 1, 3, 7, 0.0F);
		this.setRotateAngle(this.Shape27, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape26 = new ModelRenderer(this, 0, 141);
		this.Shape26.setRotationPoint(11.0F, 1.5F, -0.5F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 11, 1, 7, 0.0F);
		this.Shape4 = new ModelRenderer(this, 107, 64);
		this.Shape4.setRotationPoint(7.0F, -1.0F, -1.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 8, 8, 0.0F);
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
		this.Shape11.render(f5);
		this.Shape5.render(f5);
		this.Shape17.render(f5);
		this.Shape13.render(f5);
		this.Shape16.render(f5);
		this.Shape10.render(f5);
		this.Shape20.render(f5);
		this.Shape3.render(f5);
		this.Shape22.render(f5);
		this.Shape28.render(f5);
		this.Shape14.render(f5);
		this.Shape6.render(f5);
		this.Shape12.render(f5);
		this.Shape24.render(f5);
		this.Shape25.render(f5);
		this.Shape9.render(f5);
		this.Shape15.render(f5);
		this.Shape2.render(f5);
		this.Shape21.render(f5);
		this.Shape18.render(f5);
		this.Shape19.render(f5);
		this.Shape8.render(f5);
		this.Shape29.render(f5);
		this.Shape23.render(f5);
		this.Shape1.render(f5);
		this.Shape7.render(f5);
		this.Shape27.render(f5);
		this.Shape26.render(f5);
		this.Shape4.render(f5);
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
				GL11.glRotatef(-10, 0, 0, 1);
				GL11.glTranslatef(15, -10, -2);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glRotatef(-20, 0, 1, 0);
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
				GL11.glRotatef(50, 0, 0, 1);
				GL11.glTranslatef(0, 0, 18);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(70, 0, 0, 1);
						GL11.glRotatef(70, 1, 0, 0);
						GL11.glTranslatef(0, -5, 18);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.045f, 0.045f, 0.045f);
				GL11.glTranslatef(-7, 8, 0);
				GL11.glRotatef(160, 0, 0, 1);
				GL11.glRotatef(180, 0, 1, 0);
				GL11.glRotatef(0, 1, 0, 0);
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
