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
 * MaceHilt - Undefined
 * Created using Tabula 4.1.1
 */
public class ModelMaceHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/mace_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/mace_B.png");

	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
	public ModelRenderer Shape6;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape11;
	public ModelRenderer Shape12;
	public ModelRenderer Shape13;
	public ModelRenderer Shape16;
	public ModelRenderer Shape17;
	public ModelRenderer Shape18;
	public ModelRenderer Shape14;
	public ModelRenderer Shape15;
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

	public ModelMaceHilt()
	{
		this.textureWidth = 512;
		this.textureHeight = 512;
		this.Shape24 = new ModelRenderer(this, 66, 27);
		this.Shape24.setRotationPoint(28.5F, -1.0F, 4.0F);
		this.Shape24.addBox(0.0F, 0.0F, 0.0F, 17, 7, 1, 0.0F);
		this.Shape31 = new ModelRenderer(this, 106, 90);
		this.Shape31.setRotationPoint(47.0F, -0.5F, -0.5F);
		this.Shape31.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape1 = new ModelRenderer(this, 0, 28);
		this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape46 = new ModelRenderer(this, 56, 117);
		this.Shape46.setRotationPoint(8.0F, 5.0F, -1.0F);
		this.Shape46.addBox(0.0F, 0.0F, 0.0F, 12, 1, 7, 0.0F);
		this.Shape42 = new ModelRenderer(this, 42, 67);
		this.Shape42.setRotationPoint(11.199999809265137F, 1.5F, -0.5F);
		this.Shape42.addBox(0.0F, -1.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape42, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape48 = new ModelRenderer(this, 20, 12);
		this.Shape48.setRotationPoint(45.5F, 6.5F, 2.0F);
		this.Shape48.addBox(0.0F, -1.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape48, 0.0F, -0.0F, -1.1170107126235962F);
		this.Shape12 = new ModelRenderer(this, 16, 33);
		this.Shape12.setRotationPoint(20.5F, 1.5F, -1.0F);
		this.Shape12.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
		this.setRotateAngle(Shape12, 0.0F, -0.0F, -0.5410520434379578F);
		this.Shape28 = new ModelRenderer(this, 46, 90);
		this.Shape28.setRotationPoint(28.5F, 2.0F, -1.5F);
		this.Shape28.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape28, 0.0F, 1.1170107126235962F, 0.0F);
		this.Shape13 = new ModelRenderer(this, 41, 25);
		this.Shape13.setRotationPoint(20.0F, -1.0F, -1.0F);
		this.Shape13.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape49 = new ModelRenderer(this, 29, 9);
		this.Shape49.setRotationPoint(45.5F, 2.0F, -1.5F);
		this.Shape49.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape49, 0.0F, -1.1170107126235962F, 0.0F);
		this.Shape39 = new ModelRenderer(this, 51, 3);
		this.Shape39.setRotationPoint(48.0F, 1.0F, 6.5F);
		this.Shape39.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.Shape30 = new ModelRenderer(this, 57, 87);
		this.Shape30.setRotationPoint(46.0F, 0.0F, 0.0F);
		this.Shape30.addBox(0.0F, 0.0F, 0.0F, 6, 5, 5, 0.0F);
		this.Shape23 = new ModelRenderer(this, 66, 16);
		this.Shape23.setRotationPoint(28.5F, -1.0F, 0.0F);
		this.Shape23.addBox(0.0F, 0.0F, 0.0F, 17, 7, 1, 0.0F);
		this.Shape33 = new ModelRenderer(this, 107, 76);
		this.Shape33.setRotationPoint(53.0F, 0.0F, 0.0F);
		this.Shape33.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape35 = new ModelRenderer(this, 2, 116);
		this.Shape35.setRotationPoint(51.5F, 0.5F, 0.5F);
		this.Shape35.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.Shape38 = new ModelRenderer(this, 42, 3);
		this.Shape38.setRotationPoint(48.5F, 1.5F, 5.5F);
		this.Shape38.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Shape8 = new ModelRenderer(this, 0, 127);
		this.Shape8.setRotationPoint(9.0F, 0.0F, 0.0F);
		this.Shape8.addBox(0.0F, 0.0F, 0.0F, 10, 3, 5, 0.0F);
		this.Shape5 = new ModelRenderer(this, 0, 70);
		this.Shape5.setRotationPoint(6.0F, -1.0F, -1.0F);
		this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 7, 7, 0.0F);
		this.Shape14 = new ModelRenderer(this, 88, 88);
		this.Shape14.setRotationPoint(24.5F, -0.5F, -0.5F);
		this.Shape14.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape27 = new ModelRenderer(this, 46, 86);
		this.Shape27.setRotationPoint(28.5F, 6.5F, 2.0F);
		this.Shape27.addBox(-2.0F, -1.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape27, 0.0F, -0.0F, 1.1170107126235962F);
		this.Shape6 = new ModelRenderer(this, 0, 88);
		this.Shape6.setRotationPoint(8.0F, 3.0F, -1.0F);
		this.Shape6.addBox(0.0F, 0.0F, 0.0F, 13, 2, 7, 0.0F);
		this.Shape20 = new ModelRenderer(this, 66, 38);
		this.Shape20.setRotationPoint(28.5F, 0.0F, -1.0F);
		this.Shape20.addBox(0.0F, 0.0F, 0.0F, 17, 1, 7, 0.0F);
		this.Shape16 = new ModelRenderer(this, 61, 73);
		this.Shape16.setRotationPoint(22.0F, 0.5F, 0.5F);
		this.Shape16.addBox(0.0F, 0.0F, 0.0F, 6, 4, 4, 0.0F);
		this.Shape40 = new ModelRenderer(this, 30, 48);
		this.Shape40.setRotationPoint(11.199999809265137F, 1.5F, -0.5F);
		this.Shape40.addBox(0.0F, 0.0F, 0.0F, 6, 2, 6, 0.0F);
		this.Shape2 = new ModelRenderer(this, 0, 17);
		this.Shape2.setRotationPoint(-0.5F, 0.5F, 0.5F);
		this.Shape2.addBox(0.0F, 0.0F, 0.0F, 3, 4, 4, 0.0F);
		this.Shape15 = new ModelRenderer(this, 88, 103);
		this.Shape15.setRotationPoint(26.0F, -0.5F, -0.5F);
		this.Shape15.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape3 = new ModelRenderer(this, 0, 41);
		this.Shape3.setRotationPoint(2.0F, 0.0F, 0.0F);
		this.Shape3.addBox(0.0F, 0.0F, 0.0F, 1, 5, 5, 0.0F);
		this.Shape22 = new ModelRenderer(this, 66, 49);
		this.Shape22.setRotationPoint(28.5F, 2.0F, -1.5F);
		this.Shape22.addBox(0.0F, 0.0F, 0.0F, 17, 1, 8, 0.0F);
		this.Shape29 = new ModelRenderer(this, 46, 94);
		this.Shape29.setRotationPoint(28.5F, 2.0F, 6.5F);
		this.Shape29.addBox(-2.0F, 0.0F, -1.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape29, 0.0F, -1.1170107126235962F, 0.0F);
		this.Shape34 = new ModelRenderer(this, 20, 116);
		this.Shape34.setRotationPoint(54.0F, 1.0F, 1.0F);
		this.Shape34.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
		this.Shape37 = new ModelRenderer(this, 31, 3);
		this.Shape37.setRotationPoint(48.0F, 1.0F, 5.0F);
		this.Shape37.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
		this.Shape9 = new ModelRenderer(this, 16, 20);
		this.Shape9.setRotationPoint(8.0F, 1.5F, -1.0F);
		this.Shape9.addBox(0.0F, 0.0F, 0.0F, 3, 2, 7, 0.0F);
		this.setRotateAngle(Shape9, 0.0F, -0.0F, 0.5410520434379578F);
		this.Shape45 = new ModelRenderer(this, 42, 79);
		this.Shape45.setRotationPoint(11.199999809265137F, 1.5F, 5.5F);
		this.Shape45.addBox(0.0F, -1.0F, -1.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape45, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape47 = new ModelRenderer(this, 20, 9);
		this.Shape47.setRotationPoint(45.5F, -1.5F, 2.0F);
		this.Shape47.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape47, 0.0F, -0.0F, 1.1170107126235962F);
		this.Shape11 = new ModelRenderer(this, 22, 73);
		this.Shape11.setRotationPoint(18.5F, -0.5F, -0.5F);
		this.Shape11.addBox(0.0F, 0.0F, 0.0F, 2, 4, 6, 0.0F);
		this.Shape18 = new ModelRenderer(this, 88, 73);
		this.Shape18.setRotationPoint(23.0F, -0.5F, -0.5F);
		this.Shape18.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape19 = new ModelRenderer(this, 0, 101);
		this.Shape19.setRotationPoint(27.5F, -0.5F, -0.5F);
		this.Shape19.addBox(0.0F, 0.0F, 0.0F, 19, 6, 6, 0.0F);
		this.Shape41 = new ModelRenderer(this, 34, 60);
		this.Shape41.setRotationPoint(11.199999809265137F, -0.5F, 1.5F);
		this.Shape41.addBox(0.0F, 0.0F, 0.0F, 6, 1, 2, 0.0F);
		this.Shape50 = new ModelRenderer(this, 29, 12);
		this.Shape50.setRotationPoint(45.5F, 2.0F, 6.5F);
		this.Shape50.addBox(0.0F, 0.0F, -1.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape50, 0.0F, 1.1170107126235962F, 0.0F);
		this.Shape21 = new ModelRenderer(this, 66, 60);
		this.Shape21.setRotationPoint(28.5F, 4.0F, -1.0F);
		this.Shape21.addBox(0.0F, 0.0F, 0.0F, 17, 1, 7, 0.0F);
		this.Shape4 = new ModelRenderer(this, 0, 54);
		this.Shape4.setRotationPoint(2.5F, -0.5F, -0.5F);
		this.Shape4.addBox(0.0F, 0.0F, 0.0F, 7, 6, 6, 0.0F);
		this.Shape25 = new ModelRenderer(this, 66, 4);
		this.Shape25.setRotationPoint(28.5F, -1.5F, 2.0F);
		this.Shape25.addBox(0.0F, 0.0F, 0.0F, 17, 8, 1, 0.0F);
		this.Shape17 = new ModelRenderer(this, 42, 9);
		this.Shape17.setRotationPoint(21.5F, -0.5F, -0.5F);
		this.Shape17.addBox(0.0F, 0.0F, 0.0F, 1, 6, 6, 0.0F);
		this.Shape43 = new ModelRenderer(this, 42, 71);
		this.Shape43.setRotationPoint(11.199999809265137F, -0.5F, 1.5F);
		this.Shape43.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape43, 0.8726646304130553F, -0.0F, 0.0F);
		this.Shape26 = new ModelRenderer(this, 52, 101);
		this.Shape26.setRotationPoint(28.5F, -1.5F, 2.0F);
		this.Shape26.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Shape26, 0.0F, -0.0F, -1.1170107126235962F);
		this.Shape44 = new ModelRenderer(this, 42, 75);
		this.Shape44.setRotationPoint(11.199999809265137F, -0.5F, 3.5F);
		this.Shape44.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.setRotateAngle(Shape44, -0.8726646304130553F, -0.0F, 0.0F);
		this.Shape32 = new ModelRenderer(this, 62, 100);
		this.Shape32.setRotationPoint(49.0F, -0.5F, -0.5F);
		this.Shape32.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
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
		this.Shape24.render(f5);
		this.Shape31.render(f5);
		this.Shape1.render(f5);
		this.Shape46.render(f5);
		this.Shape42.render(f5);
		this.Shape48.render(f5);
		this.Shape12.render(f5);
		this.Shape28.render(f5);
		this.Shape13.render(f5);
		this.Shape49.render(f5);
		this.Shape39.render(f5);
		this.Shape30.render(f5);
		this.Shape23.render(f5);
		this.Shape33.render(f5);
		this.Shape35.render(f5);
		this.Shape38.render(f5);
		this.Shape8.render(f5);
		this.Shape5.render(f5);
		this.Shape14.render(f5);
		this.Shape27.render(f5);
		this.Shape6.render(f5);
		this.Shape20.render(f5);
		this.Shape16.render(f5);
		this.Shape40.render(f5);
		this.Shape2.render(f5);
		this.Shape15.render(f5);
		this.Shape3.render(f5);
		this.Shape22.render(f5);
		this.Shape29.render(f5);
		this.Shape34.render(f5);
		this.Shape37.render(f5);
		this.Shape9.render(f5);
		this.Shape45.render(f5);
		this.Shape47.render(f5);
		this.Shape11.render(f5);
		this.Shape18.render(f5);
		this.Shape19.render(f5);
		this.Shape41.render(f5);
		this.Shape50.render(f5);
		this.Shape21.render(f5);
		this.Shape4.render(f5);
		this.Shape25.render(f5);
		this.Shape17.render(f5);
		this.Shape43.render(f5);
		this.Shape26.render(f5);
		this.Shape44.render(f5);
		this.Shape32.render(f5);
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
				GL11.glTranslatef(-36, -2, -2);
				this.render(null, 0, 0, 0, 0, 0, 0.625f);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glScalef(0.04f, 0.04f, 0.04f);
				GL11.glRotatef(180, 1, 0, 0);
				GL11.glRotatef(45, 0, 1, 0);
				GL11.glRotatef(20, 0, 0, 1);
				GL11.glRotatef(90, 1, 0, 0);
				GL11.glTranslatef(9, -2, 22.8f);
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
				GL11.glTranslatef(0, 23, 0);
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
