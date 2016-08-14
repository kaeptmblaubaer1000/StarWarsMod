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
public class ModelPikeHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/pike_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/pike_B.png");

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
	public ModelRenderer Shape51;
	public ModelRenderer Shape52;
	public ModelRenderer Shape53;

	public ModelPikeHilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 256;
		this.Shape40 = new ModelRenderer(this, 55, 76);
		this.Shape40.setRotationPoint(21.0F, -0.5F, -0.5F);
		this.Shape40.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape8 = new ModelRenderer(this, 0, 164);
		this.Shape8.setRotationPoint(-1.0F, 0.5F, 0.5F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 7, 3, 3, 0.0F);
		this.Shape26 = new ModelRenderer(this, 21, 42);
		this.Shape26.setRotationPoint(36.5F, 0.0F, 0.0F);
		this.Shape26.addBox(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
		this.Shape47 = new ModelRenderer(this, 0, 4);
		this.Shape47.setRotationPoint(103.0F, -2.0F, 1.5F);
		this.Shape47.addBox(-8.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
		this.setRotateAngle(Shape47, 0.0F, -0.0F, -0.17453292012214658F);
		this.Shape25 = new ModelRenderer(this, 21, 32);
		this.Shape25.setRotationPoint(35.5F, 0.5F, 0.5F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 8, 3, 3, 0.0F);
		this.Shape46 = new ModelRenderer(this, 73, 94);
		this.Shape46.setRotationPoint(103.0F, 1.5F, -2.0F);
		this.Shape46.addBox(0.0F, 0.0F, 0.0F, 3, 1, 8, 0.0F);
		this.Shape16 = new ModelRenderer(this, 72, 10);
		this.Shape16.setRotationPoint(6.0F, 1.5F, -0.5F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5, 0.0F);
		this.Shape18 = new ModelRenderer(this, 0, 83);
		this.Shape18.setRotationPoint(7.0F, 1.5F, 4.5F);
		this.Shape18.addBox(-6.0F, 0.0F, -2.0F, 6, 1, 2, 0.0F);
		this.setRotateAngle(Shape18, 0.0F, 0.08726646006107329F, 0.0F);
		this.Shape9 = new ModelRenderer(this, 0, 190);
		this.Shape9.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.Shape44 = new ModelRenderer(this, 80, 27);
		this.Shape44.setRotationPoint(104.5F, 0.0F, 0.0F);
		this.Shape44.addBox(0.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 216);
		this.Shape2.setRotationPoint(-1.5F, -1.5F, -1.5F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 7, 7, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 234);
		this.Shape3.setRotationPoint(-2.0F, -2.0F, -2.0F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 8, 0.0F);
		this.Shape4 = new ModelRenderer(this, 0, 203);
		this.Shape4.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
		this.Shape28 = new ModelRenderer(this, 23, 116);
		this.Shape28.setRotationPoint(45.0F, -1.0F, -1.0F);
		this.Shape28.addBox(0.0F, 0.0F, 0.0F, 4, 6, 6, 0.0F);
		this.Shape7 = new ModelRenderer(this, 0, 126);
		this.Shape7.setRotationPoint(-0.5F, -2.5F, 1.5F);
		this.Shape7.addBox(0.0F, 0.0F, 0.0F, 5, 3, 1, 0.0F);
		this.setRotateAngle(Shape7, 0.0F, -0.0F, 0.6806784272193909F);
		this.Shape37 = new ModelRenderer(this, 62, 58);
		this.Shape37.setRotationPoint(96.0F, -0.5F, -0.5F);
		this.Shape37.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.Shape11 = new ModelRenderer(this, 0, 119);
		this.Shape11.setRotationPoint(-0.5F, 1.5F, -2.5F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F);
		this.setRotateAngle(Shape11, 0.0F, -0.6806784272193909F, 0.0F);
		this.Shape19 = new ModelRenderer(this, 0, 58);
		this.Shape19.setRotationPoint(8.0F, -0.5F, -0.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.Shape23 = new ModelRenderer(this, 19, 56);
		this.Shape23.setRotationPoint(16.5F, -1.0F, -1.0F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape35 = new ModelRenderer(this, 47, 33);
		this.Shape35.setRotationPoint(90.5F, 0.5F, 0.5F);
		this.Shape35.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
		this.Shape6 = new ModelRenderer(this, 10, 136);
		this.Shape6.setRotationPoint(-2.5F, 1.5F, -2.5F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 1, 9, 0.0F);
		this.Shape13 = new ModelRenderer(this, 0, 97);
		this.Shape13.setRotationPoint(7.0F, -0.5F, 1.5F);
		this.Shape13.addBox(-6.0F, 0.0F, 0.0F, 6, 2, 1, 0.0F);
		this.setRotateAngle(Shape13, 0.0F, -0.0F, 0.08726646006107329F);
		this.Shape14 = new ModelRenderer(this, 80, 19);
		this.Shape14.setRotationPoint(6.0F, -0.5F, 1.5F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
		this.Shape22 = new ModelRenderer(this, 0, 17);
		this.Shape22.setRotationPoint(15.0F, -1.5F, -1.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape42 = new ModelRenderer(this, 78, 41);
		this.Shape42.setRotationPoint(99.5F, -1.0F, -1.0F);
		this.Shape42.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape20 = new ModelRenderer(this, 0, 175);
		this.Shape20.setRotationPoint(0.5F, -0.5F, -0.5F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape29 = new ModelRenderer(this, 48, 116);
		this.Shape29.setRotationPoint(46.0F, -1.5F, -1.5F);
		this.Shape29.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape51 = new ModelRenderer(this, 45, 22);
		this.Shape51.setRotationPoint(89.0F, 1.5F, -1.0F);
		this.Shape51.addBox(0.0F, 0.0F, 0.0F, 9, 1, 6, 0.0F);
		this.Shape50 = new ModelRenderer(this, 0, 8);
		this.Shape50.setRotationPoint(103.0F, 1.5F, -2.0F);
		this.Shape50.addBox(-8.0F, 0.0F, 0.0F, 8, 1, 2, 0.0F);
		this.setRotateAngle(Shape50, 0.0F, 0.17453292012214658F, 0.0F);
		this.Shape17 = new ModelRenderer(this, 0, 90);
		this.Shape17.setRotationPoint(7.0F, 1.5F, -0.5F);
		this.Shape17.addBox(-6.0F, 0.0F, 0.0F, 6, 1, 2, 0.0F);
		this.setRotateAngle(Shape17, 0.0F, -0.08726646006107329F, 0.0F);
		this.Shape43 = new ModelRenderer(this, 73, 75);
		this.Shape43.setRotationPoint(103.0F, -1.5F, -1.5F);
		this.Shape43.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape48 = new ModelRenderer(this, 45, 11);
		this.Shape48.setRotationPoint(89.0F, -1.0F, 1.5F);
		this.Shape48.addBox(0.0F, 0.0F, 0.0F, 9, 6, 1, 0.0F);
		this.Shape31 = new ModelRenderer(this, 57, 136);
		this.Shape31.setRotationPoint(53.5F, -1.0F, -1.0F);
		this.Shape31.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape32 = new ModelRenderer(this, 36, 151);
		this.Shape32.setRotationPoint(57.0F, -1.5F, -1.5F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape33 = new ModelRenderer(this, 58, 151);
		this.Shape33.setRotationPoint(58.5F, -1.0F, -1.0F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape36 = new ModelRenderer(this, 46, 44);
		this.Shape36.setRotationPoint(94.0F, 0.0F, 0.0F);
		this.Shape36.addBox(0.0F, 0.0F, 0.0F, 9, 4, 4, 0.0F);
		this.Shape38 = new ModelRenderer(this, 21, 76);
		this.Shape38.setRotationPoint(18.0F, -0.5F, -0.5F);
		this.Shape38.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape53 = new ModelRenderer(this, 0, 0);
		this.Shape53.setRotationPoint(103.0F, 1.5F, 6.0F);
		this.Shape53.addBox(-8.0F, 0.0F, -2.0F, 8, 1, 2, 0.0F);
		this.setRotateAngle(Shape53, 0.0F, -0.17453292012214658F, 0.0F);
		this.Shape41 = new ModelRenderer(this, 38, 57);
		this.Shape41.setRotationPoint(22.5F, -0.5F, -0.5F);
		this.Shape41.addBox(0.0F, 0.0F, 0.0F, 4, 5, 5, 0.0F);
		this.Shape49 = new ModelRenderer(this, 23, 13);
		this.Shape49.setRotationPoint(88.0F, -1.0F, -1.0F);
		this.Shape49.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape12 = new ModelRenderer(this, 0, 104);
		this.Shape12.setRotationPoint(-0.5F, 1.5F, 6.5F);
		this.Shape12.addBox(0.0F, 0.0F, -3.0F, 5, 1, 3, 0.0F);
		this.setRotateAngle(Shape12, 0.0F, 0.6806784272193909F, 0.0F);
		this.Shape45 = new ModelRenderer(this, 82, 59);
		this.Shape45.setRotationPoint(103.0F, -2.0F, 1.5F);
		this.Shape45.addBox(0.0F, 0.0F, 0.0F, 3, 8, 1, 0.0F);
		this.Shape24 = new ModelRenderer(this, 22, 92);
		this.Shape24.setRotationPoint(17.0F, 0.0F, 0.0F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 19, 4, 4, 0.0F);
		this.Shape15 = new ModelRenderer(this, 0, 76);
		this.Shape15.setRotationPoint(7.0F, 4.5F, 1.5F);
		this.Shape15.addBox(-6.0F, -2.0F, 0.0F, 6, 2, 1, 0.0F);
		this.setRotateAngle(Shape15, 0.0F, -0.0F, -0.08726646006107329F);
		this.Shape52 = new ModelRenderer(this, 23, 2);
		this.Shape52.setRotationPoint(103.0F, 6.0F, 1.5F);
		this.Shape52.addBox(-8.0F, -2.0F, 0.0F, 8, 2, 1, 0.0F);
		this.setRotateAngle(Shape52, 0.0F, -0.0F, 0.17453292012214658F);
		this.Shape30 = new ModelRenderer(this, 37, 136);
		this.Shape30.setRotationPoint(50.0F, -0.5F, -0.5F);
		this.Shape30.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
		this.Shape39 = new ModelRenderer(this, 38, 76);
		this.Shape39.setRotationPoint(19.5F, -0.5F, -0.5F);
		this.Shape39.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape27 = new ModelRenderer(this, 22, 104);
		this.Shape27.setRotationPoint(43.0F, 0.0F, 0.0F);
		this.Shape27.addBox(0.0F, 0.0F, 0.0F, 14, 4, 4, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 136);
		this.Shape5.setRotationPoint(-2.5F, -2.5F, 1.5F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 9, 1, 0.0F);
		this.Shape21 = new ModelRenderer(this, 0, 38);
		this.Shape21.setRotationPoint(11.5F, -1.0F, -1.0F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
		this.Shape10 = new ModelRenderer(this, 0, 112);
		this.Shape10.setRotationPoint(-0.5F, 6.5F, 1.5F);
		this.Shape10.addBox(0.0F, -3.0F, 0.0F, 5, 3, 1, 0.0F);
		this.setRotateAngle(Shape10, 0.0F, -0.0F, -0.6806784272193909F);
		this.Shape34 = new ModelRenderer(this, 29, 170);
		this.Shape34.setRotationPoint(59.0F, 0.0F, 0.0F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 32, 4, 4, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 151);
		this.Shape1.setRotationPoint(6.0F, 0.0F, 0.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 11, 4, 4, 0.0F);
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
		this.Shape40.render(f5);
		this.Shape8.render(f5);
		this.Shape26.render(f5);
		this.Shape47.render(f5);
		this.Shape25.render(f5);
		this.Shape46.render(f5);
		this.Shape16.render(f5);
		this.Shape18.render(f5);
		this.Shape9.render(f5);
		this.Shape44.render(f5);
		this.Shape2.render(f5);
		this.Shape3.render(f5);
		this.Shape4.render(f5);
		this.Shape28.render(f5);
		this.Shape7.render(f5);
		this.Shape37.render(f5);
		this.Shape11.render(f5);
		this.Shape19.render(f5);
		this.Shape23.render(f5);
		this.Shape35.render(f5);
		this.Shape6.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape22.render(f5);
		this.Shape42.render(f5);
		this.Shape20.render(f5);
		this.Shape29.render(f5);
		this.Shape51.render(f5);
		this.Shape50.render(f5);
		this.Shape17.render(f5);
		this.Shape43.render(f5);
		this.Shape48.render(f5);
		this.Shape31.render(f5);
		this.Shape32.render(f5);
		this.Shape33.render(f5);
		this.Shape36.render(f5);
		this.Shape38.render(f5);
		this.Shape53.render(f5);
		this.Shape41.render(f5);
		this.Shape49.render(f5);
		this.Shape12.render(f5);
		this.Shape45.render(f5);
		this.Shape24.render(f5);
		this.Shape15.render(f5);
		this.Shape52.render(f5);
		this.Shape30.render(f5);
		this.Shape39.render(f5);
		this.Shape27.render(f5);
		this.Shape5.render(f5);
		this.Shape21.render(f5);
		this.Shape10.render(f5);
		this.Shape34.render(f5);
		this.Shape1.render(f5);
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
				GL11.glTranslatef(-60, -2, -2);
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
				GL11.glTranslatef(6, -2, 18);
				if (data[1] instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer)data[1];
					if (player.isBlocking())
					{
						GL11.glRotatef(40, 0, 0, 1);
						GL11.glTranslatef(-6, -8, 0);
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
						GL11.glTranslatef(-4, 20, 15);
					}
				}
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case INVENTORY:
				GL11.glScalef(0.028f, 0.028f, 0.028f);
				GL11.glTranslatef(-31, 9, 0);
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
