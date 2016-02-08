package com.parzivail.pswm.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.models.ModelLightsaberLuke1;
import com.parzivail.pswm.models.ModelLightsaberLuke1Blade;
import com.parzivail.pswm.models.ModelLightsaberLuke2;
import com.parzivail.pswm.models.ModelLightsaberLuke2Blade;
import com.parzivail.pswm.models.ModelLightsaberVader;
import com.parzivail.pswm.models.ModelLightsaberVaderBlade;

public class RenderLightsaber implements IItemRenderer
{
	private ModelLightsaberLuke1 modelLuke;
	private ModelLightsaberLuke2 modelLuke2;
	private ModelLightsaberVader modelVader;

	private ModelLightsaberLuke1Blade modelLukeBlade;
	private ModelLightsaberLuke2Blade modelLuke2Blade;
	private ModelLightsaberVaderBlade modelVaderBlade;

	public RenderLightsaber()
	{
		this.modelLuke = new ModelLightsaberLuke1();
		this.modelLuke2 = new ModelLightsaberLuke2();
		this.modelVader = new ModelLightsaberVader();

		this.modelLukeBlade = new ModelLightsaberLuke1Blade();
		this.modelLuke2Blade = new ModelLightsaberLuke2Blade();
		this.modelVaderBlade = new ModelLightsaberVaderBlade();
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
		ModelBase model = this.modelVader;
		if (item.getItemDamage() == 0)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberVader.png"));
		}
		else if (item.getItemDamage() == 1)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberLuke1.png"));
			model = this.modelLuke;
		}
		else if (item.getItemDamage() == 2)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberLuke2.png"));
			model = this.modelLuke2;
		}
		switch (type)
		{
			case INVENTORY:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.055F, -0.055F, 0.055F);
				GL11.glTranslatef(-13, -6.5f, -3.5f);
				GL11.glRotatef(25, 0, 0, 1);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
					GL11.glTranslatef(-5, 0, 8);
				}
				GL11.glTranslatef(3, -20, 0);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
					GL11.glTranslatef(-4, 0, -6);
				}
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
			default:
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glScalef(0.035F, -0.035F, 0.035F);
				GL11.glRotatef(90, 0, 0, 1);
				GL11.glTranslatef(-25, -2, -2);
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glPopMatrix();
				break;
		}

		if (item.getItem() == StarWarsMod.lightsaberOff)
			return;

		model = this.modelVaderBlade;
		if (item.getItemDamage() == 0)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberVaderBlade.png"));
		}
		else if (item.getItemDamage() == 1)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberLuke1Blade.png"));
			model = this.modelLukeBlade;
		}
		else if (item.getItemDamage() == 2)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberLuke2Blade.png"));
			model = this.modelLuke2Blade;
		}
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
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
					GL11.glTranslatef(-3, 0, -6);
				}
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
				model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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