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
 * Ezra'sHilt - Undefined Created using Tabula 4.1.1
 */
public class ModelDarksaberHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/darksaber_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/darksaber_B.png");

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
	public ModelRenderer Shape18;
	public ModelRenderer Shape19;
	public ModelRenderer Shape22;
	public ModelRenderer Shape23;
	public ModelRenderer Shape24;
	public ModelRenderer Shape25;
	public ModelRenderer Shape26;
	public ModelRenderer Shape27;
	public ModelRenderer Shape28;
	public ModelRenderer Shape16;
	public ModelRenderer Shape17;

	public ModelDarksaberHilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Shape27 = new ModelRenderer(this, 17, 0);
		this.Shape27.setRotationPoint(60.0F, 5.0F, 0.5F);
		this.Shape27.addBox(-1.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
		this.setRotateAngle(Shape27, 0.0F, -0.0F, 1.2566370964050293F);
		this.Shape8 = new ModelRenderer(this, 0, 7);
		this.Shape8.setRotationPoint(3.0F, 6.0F, 0.0F);
		this.Shape8.addBox(0.0F, -1.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(Shape8, 0.0F, -0.0F, 0.34906584024429316F);
		this.Shape12 = new ModelRenderer(this, 0, 32);
		this.Shape12.setRotationPoint(4.0F, 3.0F, 3.0F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 6, 4, 2, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 2);
		this.Shape11.setRotationPoint(3.0F, 6.0F, 3.0F);
		this.Shape11.addBox(0.0F, -1.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(Shape11, 0.0F, -0.0F, 0.34906584024429316F);
		this.Shape13 = new ModelRenderer(this, 32, 2);
		this.Shape13.setRotationPoint(6.0F, 3.0F, 2.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 4, 4, 1, 0.0F);
		this.Shape25 = new ModelRenderer(this, 0, 70);
		this.Shape25.setRotationPoint(23.0F, 0.5F, 0.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 34, 6, 5, 0.0F);
		this.Shape16 = new ModelRenderer(this, 67, 28);
		this.Shape16.setRotationPoint(18.0F, 0.0F, -0.5F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape5 = new ModelRenderer(this, 36, 36);
		this.Shape5.setRotationPoint(6.0F, 0.5F, 0.5F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape5, 0.0F, -0.0F, 0.36651915311813354F);
		this.Shape24 = new ModelRenderer(this, 47, 46);
		this.Shape24.setRotationPoint(22.0F, -2.5F, -1.0F);
		this.Shape24.addBox(-1.0F, 0.0F, 0.0F, 1, 13, 7, 0.0F);
		this.setRotateAngle(Shape24, 0.0F, -0.0F, -0.2094395160675048F);
		this.Shape19 = new ModelRenderer(this, 49, 29);
		this.Shape19.setRotationPoint(12.0F, 0.0F, -0.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 23);
		this.Shape1.setRotationPoint(4.0F, 3.0F, 0.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 6, 4, 2, 0.0F);
		this.Shape2 = new ModelRenderer(this, 9, 40);
		this.Shape2.setRotationPoint(3.0F, 6.0F, 0.0F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.Shape6 = new ModelRenderer(this, 28, 36);
		this.Shape6.setRotationPoint(6.0F, 0.5F, 3.5F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.setRotateAngle(Shape6, 0.0F, -0.0F, 0.36651915311813354F);
		this.Shape7 = new ModelRenderer(this, 27, 31);
		this.Shape7.setRotationPoint(6.0F, 0.5F, 1.5F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(Shape7, 0.0F, -0.0F, 0.36651915311813354F);
		this.Shape15 = new ModelRenderer(this, 49, 0);
		this.Shape15.setRotationPoint(8.0F, 0.0F, -0.5F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape3 = new ModelRenderer(this, 19, 31);
		this.Shape3.setRotationPoint(4.0F, 3.0F, 0.0F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(Shape3, 0.0F, -0.0F, 0.3141592741012573F);
		this.Shape22 = new ModelRenderer(this, 67, 0);
		this.Shape22.setRotationPoint(14.0F, 0.0F, -0.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape10 = new ModelRenderer(this, 0, 40);
		this.Shape10.setRotationPoint(3.0F, 6.0F, 3.0F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.Shape18 = new ModelRenderer(this, 49, 14);
		this.Shape18.setRotationPoint(10.0F, 0.0F, -0.5F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape4 = new ModelRenderer(this, 0, 58);
		this.Shape4.setRotationPoint(6.0F, 0.5F, 0.5F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 17, 3, 4, 0.0F);
		this.Shape26 = new ModelRenderer(this, 26, 11);
		this.Shape26.setRotationPoint(57.0F, 1.0F, 0.5F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.Shape28 = new ModelRenderer(this, 67, 14);
		this.Shape28.setRotationPoint(16.0F, 0.0F, -0.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
		this.Shape9 = new ModelRenderer(this, 19, 38);
		this.Shape9.setRotationPoint(4.0F, 3.0F, 3.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
		this.setRotateAngle(Shape9, 0.0F, -0.0F, 0.3141592741012573F);
		this.Shape14 = new ModelRenderer(this, 0, 46);
		this.Shape14.setRotationPoint(10.0F, 3.0F, 0.0F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 14, 4, 5, 0.0F);
		this.Shape23 = new ModelRenderer(this, 0, 12);
		this.Shape23.setRotationPoint(18.0F, -2.5F, -1.0F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 4, 1, 7, 0.0F);
		this.Shape17 = new ModelRenderer(this, 67, 42);
		this.Shape17.setRotationPoint(20.0F, 0.0F, -0.5F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 4, 6, 0.0F);
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
		this.Shape27.render(f5);
		this.Shape8.render(f5);
		this.Shape12.render(f5);
		this.Shape11.render(f5);
		this.Shape13.render(f5);
		this.Shape25.render(f5);
		this.Shape16.render(f5);
		this.Shape5.render(f5);
		this.Shape24.render(f5);
		this.Shape19.render(f5);
		this.Shape1.render(f5);
		this.Shape2.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
		this.Shape15.render(f5);
		this.Shape3.render(f5);
		this.Shape22.render(f5);
		this.Shape10.render(f5);
		this.Shape18.render(f5);
		this.Shape4.render(f5);
		this.Shape26.render(f5);
		this.Shape28.render(f5);
		this.Shape9.render(f5);
		this.Shape14.render(f5);
		this.Shape23.render(f5);
		this.Shape17.render(f5);
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		switch (type)
		{
			case ENTITY:
				GL11.glPushMatrix();
				GL11.glScalef(0.035f, 0.035f, 0.035f);
				GL11.glRotatef(-90, 0, 0, 1);
				GL11.glTranslatef(-30, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.045f, 0.045f, 0.045f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glRotatef(-90, 1, 0, 0);
				GL11.glTranslatef(0, -24, -1.5f);
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
				GL11.glRotatef(-90, 1, 0, 0);
				GL11.glTranslatef(0, -6, 12);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(-20, 0, 0, 1);
						GL11.glRotatef(70, 0, 1, 0);
						GL11.glRotatef(30, 1, 0, 0);
						GL11.glTranslatef(-4, 20, 15);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.0525f, 0.0525f, 0.0525f);
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
