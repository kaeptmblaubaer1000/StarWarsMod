package com.parzivail.pswm.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.ModelLightsaberKylo;
import com.parzivail.pswm.models.ModelLightsaberKyloBlade;

public class RenderLightsaberKylo implements IItemRenderer
{
	private ModelLightsaberKylo model;
	private ModelLightsaberKyloBlade modelBlade;

	public RenderLightsaberKylo()
	{
		this.model = new ModelLightsaberKylo();
		this.modelBlade = new ModelLightsaberKyloBlade();
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return true;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberKylo.png"));
		switch (type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslatef(-13, -6.5f, -3.5f);
				GL11.glRotatef(25, 0, 0, 1);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glRotatef(-40, 0, 1, 0);
				GL11.glRotatef(22, 0, 0, 1);
				if (((EntityClientPlayerMP)data[1]).isBlocking())
				{
					GL11.glRotatef(30, 0, 1, 0);
					GL11.glTranslatef(-4, 0, 8);
				}
				GL11.glTranslatef(5, -20, 0);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
				if (((EntityClientPlayerMP)data[1]).isBlocking())
				{
					GL11.glRotatef(-30, 0, 0, 1);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(2, 0, -12);
				}
				else
				{
					GL11.glRotatef(180, 1, 0, 0);
					GL11.glTranslatef(0, 0, -6);
				}
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.035F, -0.035F, 0.035F);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glTranslatef(-25, -2, -2);
				this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
		}

		if (item.getItem() == StarWarsMod.sequelLightsaberOff)
			return;

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberKyloBlade.png"));
		switch (type)
		{
			case INVENTORY:
				break;
			case EQUIPPED:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslated(StarWarsMod.rngGeneral.nextGaussian() / 20, StarWarsMod.rngGeneral.nextGaussian() / 10, StarWarsMod.rngGeneral.nextGaussian() / 20);
				GL11.glRotatef(-40, 0, 1, 0);
				GL11.glRotatef(22, 0, 0, 1);
				if (((EntityClientPlayerMP)data[1]).isBlocking())
				{
					GL11.glRotatef(30, 0, 1, 0);
					GL11.glTranslatef(-4, 0, 8);
				}
				GL11.glTranslatef(5, -20, 0);
				this.modelBlade.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslated(StarWarsMod.rngGeneral.nextGaussian() / 25, StarWarsMod.rngGeneral.nextGaussian() / 15, StarWarsMod.rngGeneral.nextGaussian() / 25);
				GL11.glTranslatef(8, -23, 9);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glRotatef(20, 1, 0, 0);
				if (((EntityClientPlayerMP)data[1]).isBlocking())
				{
					GL11.glRotatef(-30, 0, 0, 1);
					GL11.glRotatef(90, 1, 0, 0);
					GL11.glTranslatef(2, 0, -12);
				}
				else
				{
					GL11.glRotatef(180, 1, 0, 0);
					GL11.glTranslatef(0, 0, -6);
				}
				this.modelBlade.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.035F, -0.035F, 0.035F);
				GL11.glTranslated(StarWarsMod.rngGeneral.nextGaussian() / 20, StarWarsMod.rngGeneral.nextGaussian() / 10, StarWarsMod.rngGeneral.nextGaussian() / 20);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glTranslatef(-25, -2, -2);
				this.modelBlade.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
		}
		GL11.glPopMatrix();
	}

	@Override
	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	{
		return true;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderLightsaberOff.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */