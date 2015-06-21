package com.parzi.starwarsmod.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;

public class RenderLightsaber implements IItemRenderer
{
	private IModelCustom model;

	public RenderLightsaber()
	{
		model = AdvancedModelLoader.loadModel(new ResourceLocation(StarWarsMod.MODID, "/models/items/lightsaber.obj"));
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();

		GL11.glScalef(-1F, -1F, 1F);

		switch (type)
		{
			case INVENTORY:
				GL11.glTranslatef(0, 0.12F, 0);
				break;
			case EQUIPPED:
				GL11.glTranslatef(-0.8F, -0.2F, 0.7F);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glTranslatef(0, -0.7F, 0.7F);
				break;
			default:
		}

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StarWarsMod.MODID, "textures/models/lightsaber.png"));
		model.renderAll();

		GL11.glPopMatrix();
	}
}
