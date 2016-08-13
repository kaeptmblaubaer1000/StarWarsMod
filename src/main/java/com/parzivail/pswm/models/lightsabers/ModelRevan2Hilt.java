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
 * Revan 2 - Wolfie
 * Created using P-Tabula 4.1.1
 */
public class ModelRevan2Hilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/revan2_B.png");

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

	public ModelRevan2Hilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Shape22 = new ModelRenderer(this, 0, 226);
		this.Shape22.setRotationPoint(50.0F, 7.5F, 2.0F);
		this.Shape22.addBox(0.0F, -2.0F, 0.0F, 4, 2, 1, 0.0F);
		this.setRotateAngle(Shape22, 0.0F, -0.0F, -0.8203047513961791F);
		this.Shape32 = new ModelRenderer(this, 0, 41);
		this.Shape32.setRotationPoint(58.0F, -1.0F, -1.0F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 25);
		this.Shape2.setRotationPoint(2.0F, -1.0F, -1.0F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 7, 7, 0.0F);
		this.Shape10 = new ModelRenderer(this, 0, 105);
		this.Shape10.setRotationPoint(24.5F, -1.0F, -1.0F);
		this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape30 = new ModelRenderer(this, 146, 18);
		this.Shape30.setRotationPoint(47.0F, 2.0F, 7.5F);
		this.Shape30.addBox(-7.0F, 0.0F, -3.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(Shape30, 0.0F, -0.3141592741012573F, 0.0F);
		this.Shape49 = new ModelRenderer(this, 0, 189);
		this.Shape49.setRotationPoint(-6.0F, 2.0F, 5.5F);
		this.Shape49.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape49, 0.0F, -0.13962633907794952F, 0.0F);
		this.Shape24 = new ModelRenderer(this, 216, 0);
		this.Shape24.setRotationPoint(25.0F, 2.0F, -2.5F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(Shape24, 0.0F, -0.22689279913902283F, 0.0F);
		this.Shape46 = new ModelRenderer(this, 0, 185);
		this.Shape46.setRotationPoint(-6.0F, 5.5F, 2.0F);
		this.Shape46.addBox(0.0F, -1.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape46, 0.0F, -0.0F, 0.13962633907794952F);
		this.Shape18 = new ModelRenderer(this, 238, 6);
		this.Shape18.setRotationPoint(47.0F, -2.5F, 2.0F);
		this.Shape18.addBox(-7.0F, 0.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(Shape18, 0.0F, -0.0F, -0.3141592741012573F);
		this.Shape3 = new ModelRenderer(this, 0, 57);
		this.Shape3.setRotationPoint(6.0F, -1.0F, -1.0F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape15 = new ModelRenderer(this, 238, 0);
		this.Shape15.setRotationPoint(25.0F, -2.5F, 2.0F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(Shape15, 0.0F, -0.0F, 0.22689279913902285F);
		this.Shape8 = new ModelRenderer(this, 186, 0);
		this.Shape8.setRotationPoint(14.0F, 0.0F, 0.0F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 9, 5, 5, 0.0F);
		this.Shape14 = new ModelRenderer(this, 68, 12);
		this.Shape14.setRotationPoint(2.0F, -2.5F, 2.0F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 23, 10, 1, 0.0F);
		this.Shape45 = new ModelRenderer(this, 12, 215);
		this.Shape45.setRotationPoint(-1.0F, 5.5F, 2.0F);
		this.Shape45.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape25 = new ModelRenderer(this, 76, 0);
		this.Shape25.setRotationPoint(29.0F, 2.0F, -1.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 14, 1, 7, 0.0F);
		this.Shape16 = new ModelRenderer(this, 154, 0);
		this.Shape16.setRotationPoint(29.0F, -1.0F, 2.0F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 14, 7, 1, 0.0F);
		this.Shape1 = new ModelRenderer(this, 120, 0);
		this.Shape1.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 11, 5, 5, 0.0F);
		this.Shape37 = new ModelRenderer(this, 0, 177);
		this.Shape37.setRotationPoint(-6.0F, -0.5F, 2.0F);
		this.Shape37.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape37, 0.0F, -0.0F, -0.13962633907794952F);
		this.Shape41 = new ModelRenderer(this, 224, 12);
		this.Shape41.setRotationPoint(2.0F, 2.0F, -2.5F);
		this.Shape41.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(Shape41, 0.0F, 0.296705961227417F, 0.0F);
		this.Shape13 = new ModelRenderer(this, 0, 0);
		this.Shape13.setRotationPoint(26.0F, 0.0F, 0.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 32, 5, 5, 0.0F);
		this.Shape19 = new ModelRenderer(this, 0, 221);
		this.Shape19.setRotationPoint(50.0F, -2.5F, 2.0F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
		this.setRotateAngle(Shape19, 0.0F, -0.0F, 0.8203047513961791F);
		this.Shape6 = new ModelRenderer(this, 0, 163);
		this.Shape6.setRotationPoint(1.0F, -0.5F, -0.5F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape9 = new ModelRenderer(this, 0, 135);
		this.Shape9.setRotationPoint(23.0F, -0.5F, -0.5F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape33 = new ModelRenderer(this, 0, 149);
		this.Shape33.setRotationPoint(56.5F, -0.5F, -0.5F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape47 = new ModelRenderer(this, 224, 20);
		this.Shape47.setRotationPoint(2.0F, 2.0F, 7.5F);
		this.Shape47.addBox(-7.0F, 0.0F, -1.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(Shape47, 0.0F, -0.296705961227417F, 0.0F);
		this.Shape21 = new ModelRenderer(this, 188, 12);
		this.Shape21.setRotationPoint(47.0F, 7.5F, 2.0F);
		this.Shape21.addBox(-7.0F, -3.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(Shape21, 0.0F, -0.0F, 0.3141592741012573F);
		this.Shape35 = new ModelRenderer(this, 206, 12);
		this.Shape35.setRotationPoint(2.0F, -2.5F, 2.0F);
		this.Shape35.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(Shape35, 0.0F, -0.0F, -0.296705961227417F);
		this.Shape26 = new ModelRenderer(this, 118, 12);
		this.Shape26.setRotationPoint(47.0F, 2.0F, -2.5F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 3, 1, 10, 0.0F);
		this.Shape48 = new ModelRenderer(this, 12, 221);
		this.Shape48.setRotationPoint(-1.0F, 2.0F, 5.5F);
		this.Shape48.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape27 = new ModelRenderer(this, 216, 6);
		this.Shape27.setRotationPoint(47.0F, 2.0F, -2.5F);
		this.Shape27.addBox(-7.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(Shape27, 0.0F, 0.3141592741012573F, 0.0F);
		this.Shape44 = new ModelRenderer(this, 224, 16);
		this.Shape44.setRotationPoint(2.0F, 7.5F, 2.0F);
		this.Shape44.addBox(-7.0F, -1.0F, 0.0F, 7, 1, 1, 0.0F);
		this.setRotateAngle(Shape44, 0.0F, -0.0F, 0.296705961227417F);
		this.Shape4 = new ModelRenderer(this, 0, 73);
		this.Shape4.setRotationPoint(9.0F, -1.0F, -1.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape34 = new ModelRenderer(this, 188, 18);
		this.Shape34.setRotationPoint(-6.0F, -0.5F, 2.0F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.Shape12 = new ModelRenderer(this, 0, 215);
		this.Shape12.setRotationPoint(-3.0F, 1.5F, 1.5F);
		this.Shape12.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 207);
		this.Shape11.setRotationPoint(-0.5F, 1.0F, 1.0F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
		this.Shape23 = new ModelRenderer(this, 0, 12);
		this.Shape23.setRotationPoint(2.0F, 2.0F, -2.5F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 23, 1, 10, 0.0F);
		this.Shape40 = new ModelRenderer(this, 206, 20);
		this.Shape40.setRotationPoint(-6.0F, 2.0F, 4.5F);
		this.Shape40.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.Shape28 = new ModelRenderer(this, 242, 12);
		this.Shape28.setRotationPoint(50.0F, 2.0F, -2.5F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(Shape28, 0.0F, -0.8203047513961792F, 0.0F);
		this.Shape43 = new ModelRenderer(this, 0, 181);
		this.Shape43.setRotationPoint(-6.0F, 2.0F, -0.5F);
		this.Shape43.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape43, 0.0F, 0.13962633907794952F, 0.0F);
		this.Shape42 = new ModelRenderer(this, 12, 211);
		this.Shape42.setRotationPoint(-1.0F, 2.0F, -1.5F);
		this.Shape42.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape50 = new ModelRenderer(this, 0, 193);
		this.Shape50.setRotationPoint(60.5F, -0.5F, -0.5F);
		this.Shape50.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape17 = new ModelRenderer(this, 0, 231);
		this.Shape17.setRotationPoint(47.0F, -2.5F, 2.0F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 3, 10, 1, 0.0F);
		this.Shape29 = new ModelRenderer(this, 146, 12);
		this.Shape29.setRotationPoint(25.0F, 2.0F, 7.5F);
		this.Shape29.addBox(0.0F, 0.0F, -3.0F, 7, 1, 3, 0.0F);
		this.setRotateAngle(Shape29, 0.0F, 0.22689279913902283F, 0.0F);
		this.Shape39 = new ModelRenderer(this, 206, 16);
		this.Shape39.setRotationPoint(-6.0F, 2.0F, -0.5F);
		this.Shape39.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
		this.Shape20 = new ModelRenderer(this, 168, 16);
		this.Shape20.setRotationPoint(25.0F, 7.5F, 2.0F);
		this.Shape20.addBox(0.0F, -3.0F, 0.0F, 7, 3, 1, 0.0F);
		this.setRotateAngle(Shape20, 0.0F, -0.0F, -0.22689279913902285F);
		this.Shape36 = new ModelRenderer(this, 12, 207);
		this.Shape36.setRotationPoint(-1.0F, -1.5F, 2.0F);
		this.Shape36.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 121);
		this.Shape7.setRotationPoint(13.5F, -0.5F, -0.5F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 89);
		this.Shape5.setRotationPoint(12.0F, -1.0F, -1.0F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape38 = new ModelRenderer(this, 168, 12);
		this.Shape38.setRotationPoint(-6.0F, 4.5F, 2.0F);
		this.Shape38.addBox(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
		this.Shape31 = new ModelRenderer(this, 242, 17);
		this.Shape31.setRotationPoint(50.0F, 2.0F, 7.5F);
		this.Shape31.addBox(0.0F, 0.0F, -2.0F, 4, 1, 2, 0.0F);
		this.setRotateAngle(Shape31, 0.0F, 0.8203047513961792F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.Shape22.render(f5);
		this.Shape32.render(f5);
		this.Shape2.render(f5);
		this.Shape10.render(f5);
		this.Shape30.render(f5);
		this.Shape49.render(f5);
		this.Shape24.render(f5);
		this.Shape46.render(f5);
		this.Shape18.render(f5);
		this.Shape3.render(f5);
		this.Shape15.render(f5);
		this.Shape8.render(f5);
		this.Shape14.render(f5);
		this.Shape45.render(f5);
		this.Shape25.render(f5);
		this.Shape16.render(f5);
		this.Shape1.render(f5);
		this.Shape37.render(f5);
		this.Shape41.render(f5);
		this.Shape13.render(f5);
		this.Shape19.render(f5);
		this.Shape6.render(f5);
		this.Shape9.render(f5);
		this.Shape33.render(f5);
		this.Shape47.render(f5);
		this.Shape21.render(f5);
		this.Shape35.render(f5);
		this.Shape26.render(f5);
		this.Shape48.render(f5);
		this.Shape27.render(f5);
		this.Shape44.render(f5);
		this.Shape4.render(f5);
		this.Shape34.render(f5);
		this.Shape12.render(f5);
		this.Shape11.render(f5);
		this.Shape23.render(f5);
		this.Shape40.render(f5);
		this.Shape28.render(f5);
		this.Shape43.render(f5);
		this.Shape42.render(f5);
		this.Shape50.render(f5);
		this.Shape17.render(f5);
		this.Shape29.render(f5);
		this.Shape39.render(f5);
		this.Shape20.render(f5);
		this.Shape36.render(f5);
		this.Shape7.render(f5);
		this.Shape5.render(f5);
		this.Shape38.render(f5);
		this.Shape31.render(f5);
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
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
	public ResourceLocation getResourceLocation(boolean alt)
	{
		if (alt)
			return this.tB;
		return this.tA;
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

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
