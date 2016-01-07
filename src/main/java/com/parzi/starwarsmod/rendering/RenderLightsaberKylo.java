package com.parzi.starwarsmod.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.rendering.models.ModelLightsaberKylo;

public class RenderLightsaberKylo implements IItemRenderer
{
	private ModelLightsaberKylo model;

	public RenderLightsaberKylo()
	{
		this.model = new ModelLightsaberKylo();
	}

	@Override
	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	{
		return type == IItemRenderer.ItemRenderType.EQUIPPED;
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Resources.MODID, "textures/models/lightsaberKylo.png"));
		GL11.glScalef(0.25F, -0.25F, 0.25F);
		switch (type)
		{
			case INVENTORY:
				break;
			case EQUIPPED:
				GL11.glTranslatef(-2.4F, -9.4F, -5.4F);
				GL11.glRotatef(90.0F, 1.0F, 1.0F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				break;
			default:
				break;
		}
		this.model.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.625F);
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
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\RenderLightsaber.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */