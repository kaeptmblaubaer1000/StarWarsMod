package com.parzivail.pswm.models.lightsabers.blades;

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
 * luke1.tbl - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class ModelLuke1BladeShort extends ModelBase implements IHandlesRender
{

	ResourceLocation tA = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke1_A.png");
	ResourceLocation tB = new ResourceLocation(Resources.MODID, "textures/models/lightsabers/luke1_B.png");

	public ModelRenderer shape32;

	public ModelLuke1BladeShort()
	{
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.shape32 = new ModelRenderer(this, 0, 0);
		this.shape32.setRotationPoint(13.0F, 0.0F, 0.0F);
		this.shape32.addBox(-105.0F, 1.5F, 1.5F, 100, 3, 3, 0.0F);
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
		this.shape32.render(f5);
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
