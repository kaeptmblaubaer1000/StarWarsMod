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

public class ModelCrossbarHilt extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/kylo_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/kylo_B.png");

	ModelRenderer Shape1;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape32;
	ModelRenderer Shape26;
	ModelRenderer Shape2;
	ModelRenderer Shape6;
	ModelRenderer Shape3;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape17;
	ModelRenderer Shape18;
	ModelRenderer Shape19;
	ModelRenderer Shape20;
	ModelRenderer Shape21;
	ModelRenderer Shape22;
	ModelRenderer Shape16;
	ModelRenderer Shape23;
	ModelRenderer Shape24;
	ModelRenderer Shape25;
	ModelRenderer Shape27;
	ModelRenderer Shape28;
	ModelRenderer Shape29;
	ModelRenderer Shape30;
	ModelRenderer Shape31;
	ModelRenderer Shape33;
	ModelRenderer Shape34;
	ModelRenderer Shape35;
	ModelRenderer Shape36;
	ModelRenderer Shape37;
	ModelRenderer Shape38;
	ModelRenderer Shape39;
	ModelRenderer Shape40;
	ModelRenderer Shape41;
	ModelRenderer Shape48;
	ModelRenderer Shape42;
	ModelRenderer Shape43;
	ModelRenderer Shape44;
	ModelRenderer Shape45;
	ModelRenderer Shape46;
	ModelRenderer Shape47;

	public ModelCrossbarHilt()
	{
		this.textureWidth = 256;
		this.textureHeight = 128;

		this.Shape1 = new ModelRenderer(this, 0, 113);
		this.Shape1.addBox(0F, 0F, 0F, 8, 6, 6);
		this.Shape1.setRotationPoint(31F, 0F, 0F);
		this.Shape1.setTextureSize(64, 32);
		this.Shape1.mirror = true;
		this.setRotation(this.Shape1, 0F, 0F, 0F);
		this.Shape4 = new ModelRenderer(this, 0, 23);
		this.Shape4.addBox(-11F, -1F, 0F, 11, 2, 1);
		this.Shape4.setRotationPoint(43F, 0F, 1F);
		this.Shape4.setTextureSize(64, 32);
		this.Shape4.mirror = true;
		this.setRotation(this.Shape4, 0F, 0F, -0.0349066F);
		this.Shape5 = new ModelRenderer(this, 0, 18);
		this.Shape5.addBox(-11F, -1F, 0F, 11, 2, 1);
		this.Shape5.setRotationPoint(43F, 0F, 4F);
		this.Shape5.setTextureSize(64, 32);
		this.Shape5.mirror = true;
		this.setRotation(this.Shape5, 0F, 0F, -0.0349066F);
		this.Shape9 = new ModelRenderer(this, 0, 38);
		this.Shape9.addBox(-11F, 0F, -1F, 11, 1, 2);
		this.Shape9.setRotationPoint(43F, 4F, 0F);
		this.Shape9.setTextureSize(64, 32);
		this.Shape9.mirror = true;
		this.setRotation(this.Shape9, 0F, 0.0349066F, 0F);
		this.Shape10 = new ModelRenderer(this, 0, 33);
		this.Shape10.addBox(-11F, 0F, -2F, 11, 1, 2);
		this.Shape10.setRotationPoint(43F, 1F, 1F);
		this.Shape10.setTextureSize(64, 32);
		this.Shape10.mirror = true;
		this.setRotation(this.Shape10, 0F, 0.0349066F, 0F);
		this.Shape11 = new ModelRenderer(this, 0, 71);
		this.Shape11.addBox(-11F, 0F, 0F, 11, 1, 2);
		this.Shape11.setRotationPoint(43F, 1F, 5F);
		this.Shape11.setTextureSize(64, 32);
		this.Shape11.mirror = true;
		this.setRotation(this.Shape11, 0F, -0.0349066F, 0F);
		this.Shape12 = new ModelRenderer(this, 0, 66);
		this.Shape12.addBox(-11F, 0F, 0F, 11, 1, 2);
		this.Shape12.setRotationPoint(43F, 4F, 5F);
		this.Shape12.setTextureSize(64, 32);
		this.Shape12.mirror = true;
		this.setRotation(this.Shape12, 0F, -0.0349066F, 0F);
		this.Shape13 = new ModelRenderer(this, 0, 49);
		this.Shape13.addBox(-11F, 0F, 0F, 11, 2, 1);
		this.Shape13.setRotationPoint(43F, 5F, 1F);
		this.Shape13.setTextureSize(64, 32);
		this.Shape13.mirror = true;
		this.setRotation(this.Shape13, 0F, 0F, 0.0349066F);
		this.Shape14 = new ModelRenderer(this, 0, 55);
		this.Shape14.addBox(-11F, 0F, 0F, 11, 2, 1);
		this.Shape14.setRotationPoint(43F, 5F, 4F);
		this.Shape14.setTextureSize(64, 32);
		this.Shape14.mirror = true;
		this.setRotation(this.Shape14, 0F, 0F, 0.0349066F);
		this.Shape15 = new ModelRenderer(this, 78, 112);
		this.Shape15.addBox(0F, 0F, 0F, 4, 5, 5);
		this.Shape15.setRotationPoint(38.5F, 0.5F, 0.5F);
		this.Shape15.setTextureSize(64, 32);
		this.Shape15.mirror = true;
		this.setRotation(this.Shape15, 0F, 0F, 0F);
		this.Shape32 = new ModelRenderer(this, 37, 112);
		this.Shape32.addBox(0F, 0F, 0F, 2, 7, 7);
		this.Shape32.setRotationPoint(42F, -0.5F, -0.5F);
		this.Shape32.setTextureSize(64, 32);
		this.Shape32.mirror = true;
		this.setRotation(this.Shape32, 0F, 0F, 0F);
		this.Shape26 = new ModelRenderer(this, 61, 112);
		this.Shape26.addBox(0F, 0F, 0F, 1, 5, 5);
		this.Shape26.setRotationPoint(44F, 0.5F, 0.5F);
		this.Shape26.setTextureSize(64, 32);
		this.Shape26.mirror = true;
		this.setRotation(this.Shape26, 0F, 0F, 0F);
		this.Shape2 = new ModelRenderer(this, 47, 97);
		this.Shape2.addBox(0F, 0F, 0F, 1, 5, 5);
		this.Shape2.setRotationPoint(30F, 0.5F, 0.5F);
		this.Shape2.setTextureSize(64, 32);
		this.Shape2.mirror = true;
		this.setRotation(this.Shape2, 0F, 0F, 0F);
		this.Shape6 = new ModelRenderer(this, 0, 96);
		this.Shape6.addBox(0F, 0F, 0F, 14, 6, 6);
		this.Shape6.setRotationPoint(16F, 0F, 0F);
		this.Shape6.setTextureSize(64, 32);
		this.Shape6.mirror = true;
		this.setRotation(this.Shape6, 0F, 0F, 0F);
		this.Shape3 = new ModelRenderer(this, 0, 82);
		this.Shape3.addBox(0F, 0F, 0F, 4, 1, 1);
		this.Shape3.setRotationPoint(16F, -0.5F, 2.5F);
		this.Shape3.setTextureSize(64, 32);
		this.Shape3.mirror = true;
		this.setRotation(this.Shape3, 0F, 0F, 0F);
		this.Shape7 = new ModelRenderer(this, 15, 88);
		this.Shape7.addBox(0F, 0F, 0F, 4, 1, 1);
		this.Shape7.setRotationPoint(16F, 2.5F, -0.5F);
		this.Shape7.setTextureSize(64, 32);
		this.Shape7.mirror = true;
		this.setRotation(this.Shape7, 0F, 0F, 0F);
		this.Shape8 = new ModelRenderer(this, 15, 82);
		this.Shape8.addBox(0F, 0F, 0F, 4, 1, 1);
		this.Shape8.setRotationPoint(16F, 5.5F, 2.5F);
		this.Shape8.setTextureSize(64, 32);
		this.Shape8.mirror = true;
		this.setRotation(this.Shape8, 0F, 0F, 0F);
		this.Shape17 = new ModelRenderer(this, 66, 97);
		this.Shape17.addBox(0F, 0F, 0F, 1, 5, 5);
		this.Shape17.setRotationPoint(15F, 0.5F, 0.5F);
		this.Shape17.setTextureSize(64, 32);
		this.Shape17.mirror = true;
		this.setRotation(this.Shape17, 0F, 0F, 0F);
		this.Shape18 = new ModelRenderer(this, 102, 108);
		this.Shape18.addBox(0F, 0F, 0F, 1, 7, 7);
		this.Shape18.setRotationPoint(27.5F, -0.5F, -0.5F);
		this.Shape18.setTextureSize(64, 32);
		this.Shape18.mirror = true;
		this.setRotation(this.Shape18, 0F, 0F, 0F);
		this.Shape19 = new ModelRenderer(this, 9, 11);
		this.Shape19.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape19.setRotationPoint(28.5F, 2.5F, -0.5F);
		this.Shape19.setTextureSize(64, 32);
		this.Shape19.mirror = true;
		this.setRotation(this.Shape19, 0F, 0F, 0F);
		this.Shape20 = new ModelRenderer(this, 0, 11);
		this.Shape20.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape20.setRotationPoint(28.5F, 5.5F, 2.5F);
		this.Shape20.setTextureSize(64, 32);
		this.Shape20.mirror = true;
		this.setRotation(this.Shape20, 0F, 0F, 0F);
		this.Shape21 = new ModelRenderer(this, 9, 6);
		this.Shape21.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape21.setRotationPoint(28.5F, 2.5F, 5.5F);
		this.Shape21.setTextureSize(64, 32);
		this.Shape21.mirror = true;
		this.setRotation(this.Shape21, 0F, 0F, 0F);
		this.Shape22 = new ModelRenderer(this, 0, 88);
		this.Shape22.addBox(0F, 0F, 0F, 4, 1, 1);
		this.Shape22.setRotationPoint(16F, 2.5F, 5.5F);
		this.Shape22.setTextureSize(64, 32);
		this.Shape22.mirror = true;
		this.setRotation(this.Shape22, 0F, 0F, 0F);
		this.Shape16 = new ModelRenderer(this, 32, 87);
		this.Shape16.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape16.setRotationPoint(20F, -0.5F, 2.5F);
		this.Shape16.setTextureSize(64, 32);
		this.Shape16.mirror = true;
		this.setRotation(this.Shape16, 0F, 0F, 0.8726646F);
		this.Shape23 = new ModelRenderer(this, 32, 82);
		this.Shape23.addBox(0F, 0F, -1F, 2, 1, 1);
		this.Shape23.setRotationPoint(20F, 2.5F, 6.5F);
		this.Shape23.setTextureSize(64, 32);
		this.Shape23.mirror = true;
		this.setRotation(this.Shape23, 0F, 0.8726646F, 0F);
		this.Shape24 = new ModelRenderer(this, 43, 82);
		this.Shape24.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape24.setRotationPoint(20F, 2.5F, -0.5F);
		this.Shape24.setTextureSize(64, 32);
		this.Shape24.mirror = true;
		this.setRotation(this.Shape24, 0F, -0.8726646F, 0F);
		this.Shape25 = new ModelRenderer(this, 43, 87);
		this.Shape25.addBox(0F, -1F, 0F, 2, 1, 1);
		this.Shape25.setRotationPoint(20F, 6.5F, 2.5F);
		this.Shape25.setTextureSize(64, 32);
		this.Shape25.mirror = true;
		this.setRotation(this.Shape25, 0F, 0F, -0.8726646F);
		this.Shape27 = new ModelRenderer(this, 108, 1);
		this.Shape27.addBox(0F, 0F, 0F, 4, 7, 7);
		this.Shape27.setRotationPoint(11F, -0.5F, -0.5F);
		this.Shape27.setTextureSize(64, 32);
		this.Shape27.mirror = true;
		this.setRotation(this.Shape27, 0F, 0F, 0F);
		this.Shape28 = new ModelRenderer(this, 33, 0);
		this.Shape28.addBox(0F, 0F, 0F, 3, 2, 4);
		this.Shape28.setRotationPoint(8F, 0.5F, 0.5F);
		this.Shape28.setTextureSize(64, 32);
		this.Shape28.mirror = true;
		this.setRotation(this.Shape28, 0F, 0F, 0F);
		this.Shape29 = new ModelRenderer(this, 56, 0);
		this.Shape29.addBox(0F, 0F, 0F, 3, 5, 7);
		this.Shape29.setRotationPoint(8F, 1.5F, -0.5F);
		this.Shape29.setTextureSize(64, 32);
		this.Shape29.mirror = true;
		this.setRotation(this.Shape29, 0F, 0F, 0F);
		this.Shape30 = new ModelRenderer(this, 1, 0);
		this.Shape30.addBox(0F, 0F, 0F, 3, 2, 2);
		this.Shape30.setRotationPoint(8F, -0.5F, 4.5F);
		this.Shape30.setTextureSize(64, 32);
		this.Shape30.mirror = true;
		this.setRotation(this.Shape30, 0F, 0F, 0F);
		this.Shape31 = new ModelRenderer(this, 84, 0);
		this.Shape31.addBox(0F, 0F, 0F, 2, 7, 7);
		this.Shape31.setRotationPoint(6F, -0.5F, -0.5F);
		this.Shape31.setTextureSize(64, 32);
		this.Shape31.mirror = true;
		this.setRotation(this.Shape31, 0F, 0F, 0F);
		this.Shape33 = new ModelRenderer(this, 0, 6);
		this.Shape33.addBox(0F, 0F, 0F, 2, 1, 1);
		this.Shape33.setRotationPoint(28.5F, -0.5F, 2.5F);
		this.Shape33.setTextureSize(64, 32);
		this.Shape33.mirror = true;
		this.setRotation(this.Shape33, 0F, 0F, 0F);
		this.Shape34 = new ModelRenderer(this, 100, 21);
		this.Shape34.addBox(0F, 0F, 0F, 2, 6, 6);
		this.Shape34.setRotationPoint(4F, 0F, 0F);
		this.Shape34.setTextureSize(64, 32);
		this.Shape34.mirror = true;
		this.setRotation(this.Shape34, 0F, 0F, 0F);
		this.Shape35 = new ModelRenderer(this, 35, 30);
		this.Shape35.addBox(0F, 0F, 0F, 4, 2, 2);
		this.Shape35.setRotationPoint(3F, -1F, 2F);
		this.Shape35.setTextureSize(64, 32);
		this.Shape35.mirror = true;
		this.setRotation(this.Shape35, 0F, 0F, 0F);
		this.Shape36 = new ModelRenderer(this, 35, 44);
		this.Shape36.addBox(0F, 0F, 0F, 3, 2, 1);
		this.Shape36.setRotationPoint(4F, 2F, 6F);
		this.Shape36.setTextureSize(64, 32);
		this.Shape36.mirror = true;
		this.setRotation(this.Shape36, 0F, 0F, 0F);
		this.Shape37 = new ModelRenderer(this, 35, 37);
		this.Shape37.addBox(0F, 0F, 0F, 3, 2, 1);
		this.Shape37.setRotationPoint(4F, 2F, -1F);
		this.Shape37.setTextureSize(64, 32);
		this.Shape37.mirror = true;
		this.setRotation(this.Shape37, 0F, 0F, 0F);
		this.Shape38 = new ModelRenderer(this, 35, 51);
		this.Shape38.addBox(0F, 0F, 0F, 4, 2, 2);
		this.Shape38.setRotationPoint(3F, 5F, 2F);
		this.Shape38.setTextureSize(64, 32);
		this.Shape38.mirror = true;
		this.setRotation(this.Shape38, 0F, 0F, 0F);
		this.Shape39 = new ModelRenderer(this, 73, 20);
		this.Shape39.addBox(0F, 0F, 0F, 4, 5, 5);
		this.Shape39.setRotationPoint(0F, 0.5F, 0.5F);
		this.Shape39.setTextureSize(64, 32);
		this.Shape39.mirror = true;
		this.setRotation(this.Shape39, 0F, 0F, 0F);
		this.Shape40 = new ModelRenderer(this, 70, 54);
		this.Shape40.addBox(0F, 0F, 0F, 3, 3, 5);
		this.Shape40.setRotationPoint(1F, 1.5F, -4F);
		this.Shape40.setTextureSize(64, 32);
		this.Shape40.mirror = true;
		this.setRotation(this.Shape40, 0F, 0F, 0F);
		this.Shape41 = new ModelRenderer(this, 70, 70);
		this.Shape41.addBox(0F, 0F, 0F, 2, 1, 6);
		this.Shape41.setRotationPoint(2.5F, 1F, -5F);
		this.Shape41.setTextureSize(64, 32);
		this.Shape41.mirror = true;
		this.setRotation(this.Shape41, 0F, 0F, 0F);
		this.Shape48 = new ModelRenderer(this, 51, 19);
		this.Shape48.addBox(0F, 0F, 0F, 3, 4, 4);
		this.Shape48.setRotationPoint(-3F, 1F, 1F);
		this.Shape48.setTextureSize(64, 32);
		this.Shape48.mirror = true;
		this.setRotation(this.Shape48, 0F, 0F, 0F);
		this.Shape42 = new ModelRenderer(this, 70, 41);
		this.Shape42.addBox(0F, 0F, 0F, 3, 3, 5);
		this.Shape42.setRotationPoint(1F, 1.5F, 5F);
		this.Shape42.setTextureSize(64, 32);
		this.Shape42.mirror = true;
		this.setRotation(this.Shape42, 0F, 0F, 0F);
		this.Shape43 = new ModelRenderer(this, 91, 70);
		this.Shape43.addBox(0F, 0F, 0F, 2, 1, 6);
		this.Shape43.setRotationPoint(2.5F, 1F, 5F);
		this.Shape43.setTextureSize(64, 32);
		this.Shape43.mirror = true;
		this.setRotation(this.Shape43, 0F, 0F, 0F);
		this.Shape44 = new ModelRenderer(this, 112, 70);
		this.Shape44.addBox(0F, 0F, 0F, 2, 1, 6);
		this.Shape44.setRotationPoint(2.5F, 4F, 5F);
		this.Shape44.setTextureSize(64, 32);
		this.Shape44.mirror = true;
		this.setRotation(this.Shape44, 0F, 0F, 0F);
		this.Shape45 = new ModelRenderer(this, 84, 82);
		this.Shape45.addBox(0F, 0F, 0F, 1, 2, 6);
		this.Shape45.setRotationPoint(3.5F, 2F, 5F);
		this.Shape45.setTextureSize(64, 32);
		this.Shape45.mirror = true;
		this.setRotation(this.Shape45, 0F, 0F, 0F);
		this.Shape46 = new ModelRenderer(this, 51, 70);
		this.Shape46.addBox(0F, 0F, 0F, 2, 1, 6);
		this.Shape46.setRotationPoint(2.5F, 4F, -5F);
		this.Shape46.setTextureSize(64, 32);
		this.Shape46.mirror = true;
		this.setRotation(this.Shape46, 0F, 0F, 0F);
		this.Shape47 = new ModelRenderer(this, 67, 81);
		this.Shape47.addBox(0F, 0F, 0F, 1, 2, 6);
		this.Shape47.setRotationPoint(3.5F, 2F, -5F);
		this.Shape47.setTextureSize(64, 32);
		this.Shape47.mirror = true;
		this.setRotation(this.Shape47, 0F, 0F, 0F);
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
		this.Shape4.render(f5);
		this.Shape5.render(f5);
		this.Shape9.render(f5);
		this.Shape10.render(f5);
		this.Shape11.render(f5);
		this.Shape12.render(f5);
		this.Shape13.render(f5);
		this.Shape14.render(f5);
		this.Shape15.render(f5);
		this.Shape32.render(f5);
		this.Shape26.render(f5);
		this.Shape2.render(f5);
		this.Shape6.render(f5);
		this.Shape3.render(f5);
		this.Shape7.render(f5);
		this.Shape8.render(f5);
		this.Shape17.render(f5);
		this.Shape18.render(f5);
		this.Shape19.render(f5);
		this.Shape20.render(f5);
		this.Shape21.render(f5);
		this.Shape22.render(f5);
		this.Shape16.render(f5);
		this.Shape23.render(f5);
		this.Shape24.render(f5);
		this.Shape25.render(f5);
		this.Shape27.render(f5);
		this.Shape28.render(f5);
		this.Shape29.render(f5);
		this.Shape30.render(f5);
		this.Shape31.render(f5);
		this.Shape33.render(f5);
		this.Shape34.render(f5);
		this.Shape35.render(f5);
		this.Shape36.render(f5);
		this.Shape37.render(f5);
		this.Shape38.render(f5);
		this.Shape39.render(f5);
		this.Shape40.render(f5);
		this.Shape41.render(f5);
		this.Shape48.render(f5);
		this.Shape42.render(f5);
		this.Shape43.render(f5);
		this.Shape44.render(f5);
		this.Shape45.render(f5);
		this.Shape46.render(f5);
		this.Shape47.render(f5);
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
					GL11.glTranslatef(-4, 0, 8);
				}
				GL11.glTranslatef(5, -20, 0);
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
					GL11.glTranslatef(2, 0, -16);
				}
				else
				{
					GL11.glRotatef(180, 1, 0, 0);
					GL11.glTranslatef(0, 0, -6);
				}
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
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

}
