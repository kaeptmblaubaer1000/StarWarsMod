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
 * RevanHilt1 - Undefined Created using Tabula 4.1.1
 */
public class ModelRevanHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan_B.png");

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
	public ModelRenderer Shape34;
	public ModelRenderer Shape15;
	public ModelRenderer Shape33;

	public ModelRevanHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape27 = new ModelRenderer(this, 80, 110);
		this.Shape27.setRotationPoint(70.0F, 0.5F, 0.5F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
		this.Shape9 = new ModelRenderer(this, 31, 90);
		this.Shape9.setRotationPoint(13.5F, 0.0F, 0.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 8, 8, 0.0F);
		this.Shape13 = new ModelRenderer(this, 0, 144);
		this.Shape13.setRotationPoint(25.0F, 0.0F, 0.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 3, 8, 8, 0.0F);
		this.Shape4 = new ModelRenderer(this, 29, 33);
		this.Shape4.setRotationPoint(5.0F, 1.0F, 1.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 55);
		this.Shape2.setRotationPoint(-1.0F, 0.5F, 0.5F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 7, 7, 0.0F);
		this.Shape33 = new ModelRenderer(this, 79, 87);
		this.Shape33.setRotationPoint(56.0F, -1.5F, 2.5F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.Shape29 = new ModelRenderer(this, 78, 11);
		this.Shape29.setRotationPoint(70.5F, -1.0F, 3.0F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
		this.Shape16 = new ModelRenderer(this, 56, 92);
		this.Shape16.setRotationPoint(28.5F, 0.5F, 0.5F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 91);
		this.Shape3.setRotationPoint(3.5F, 1.5F, 1.5F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 8, 5, 5, 0.0F);
		this.Shape22 = new ModelRenderer(this, 78, 144);
		this.Shape22.setRotationPoint(65.0F, 0.5F, 0.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 32);
		this.Shape1.setRotationPoint(0.0F, -0.5F, -0.5F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 9, 9, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 74);
		this.Shape5.setRotationPoint(3.0F, 1.0F, 1.0F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape28 = new ModelRenderer(this, 79, 165);
		this.Shape28.setRotationPoint(69.0F, 1.0F, 1.0F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
		this.Shape11 = new ModelRenderer(this, 56, 34);
		this.Shape11.setRotationPoint(17.5F, 0.5F, 0.5F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape19 = new ModelRenderer(this, 31, 11);
		this.Shape19.setRotationPoint(40.0F, 0.5F, 0.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape17 = new ModelRenderer(this, 56, 110);
		this.Shape17.setRotationPoint(31.0F, 0.5F, 0.5F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape18 = new ModelRenderer(this, 28, 144);
		this.Shape18.setRotationPoint(33.5F, 0.5F, 0.5F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape10 = new ModelRenderer(this, 0, 127);
		this.Shape10.setRotationPoint(16.0F, 1.0F, 1.0F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 21, 6, 6, 0.0F);
		this.Shape25 = new ModelRenderer(this, 0, 165);
		this.Shape25.setRotationPoint(38.0F, 1.0F, 1.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 30, 6, 6, 0.0F);
		this.Shape6 = new ModelRenderer(this, 29, 50);
		this.Shape6.setRotationPoint(8.0F, 1.0F, 1.0F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 107);
		this.Shape7.setRotationPoint(11.0F, 0.5F, 0.5F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 6, 7, 7, 0.0F);
		this.Shape34 = new ModelRenderer(this, 79, 79);
		this.Shape34.setRotationPoint(56.0F, 0.0F, 2.5F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
		this.Shape21 = new ModelRenderer(this, 55, 11);
		this.Shape21.setRotationPoint(49.0F, 0.5F, 0.5F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape8 = new ModelRenderer(this, 28, 67);
		this.Shape8.setRotationPoint(13.0F, -0.5F, -0.5F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 9, 9, 0.0F);
		this.Shape20 = new ModelRenderer(this, 0, 12);
		this.Shape20.setRotationPoint(42.5F, 0.5F, 0.5F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 6, 7, 7, 0.0F);
		this.Shape14 = new ModelRenderer(this, 56, 73);
		this.Shape14.setRotationPoint(22.5F, 0.5F, 0.5F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape24 = new ModelRenderer(this, 32, 111);
		this.Shape24.setRotationPoint(37.0F, 1.5F, 1.5F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape30 = new ModelRenderer(this, 78, 29);
		this.Shape30.setRotationPoint(70.5F, 3.0F, -1.0F);
		this.Shape30.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
		this.Shape23 = new ModelRenderer(this, 54, 144);
		this.Shape23.setRotationPoint(62.5F, 0.5F, 0.5F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape26 = new ModelRenderer(this, 60, 130);
		this.Shape26.setRotationPoint(68.0F, 2.0F, 2.0F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 8, 4, 4, 0.0F);
		this.Shape15 = new ModelRenderer(this, 80, 71);
		this.Shape15.setRotationPoint(56.5F, -0.5F, 3.0F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
		this.Shape12 = new ModelRenderer(this, 56, 54);
		this.Shape12.setRotationPoint(20.0F, 0.5F, 0.5F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
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
		this.Shape27.render(f5);
		this.Shape9.render(f5);
		this.Shape13.render(f5);
		this.Shape4.render(f5);
		this.Shape2.render(f5);
		this.Shape33.render(f5);
		this.Shape29.render(f5);
		this.Shape16.render(f5);
		this.Shape3.render(f5);
		this.Shape22.render(f5);
		this.Shape1.render(f5);
		this.Shape5.render(f5);
		this.Shape28.render(f5);
		this.Shape11.render(f5);
		this.Shape19.render(f5);
		this.Shape17.render(f5);
		this.Shape18.render(f5);
		this.Shape10.render(f5);
		this.Shape25.render(f5);
		this.Shape6.render(f5);
		this.Shape7.render(f5);
		this.Shape34.render(f5);
		this.Shape21.render(f5);
		this.Shape8.render(f5);
		this.Shape20.render(f5);
		this.Shape14.render(f5);
		this.Shape24.render(f5);
		this.Shape30.render(f5);
		this.Shape23.render(f5);
		this.Shape26.render(f5);
		this.Shape15.render(f5);
		this.Shape12.render(f5);
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
				GL11.glTranslatef(-40, -2, -2);
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

					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.042f, 0.042f, 0.042f);
				GL11.glTranslatef(-25, 3, 0);
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
