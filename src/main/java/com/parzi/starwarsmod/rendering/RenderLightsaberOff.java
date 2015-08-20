package com.parzi.starwarsmod.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.models.ModelLightsaberOff;

public class RenderLightsaberOff implements IItemRenderer
{
	private ModelLightsaberOff model;

	public RenderLightsaberOff()
	{
		model = new ModelLightsaberOff();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return type == ItemRenderType.EQUIPPED;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(StarWarsMod.MODID, "textures/models/lightsaberOff.png"));

		GL11.glScalef(0.25F, -0.25F, 0.25F);

		switch (type)
		{
			case INVENTORY:
				break;
			case EQUIPPED:
				GL11.glTranslatef(-2.4F, -9.4F, -5.4F);
				GL11.glRotatef(90, 1, 1, 0);
				break;
			case EQUIPPED_FIRST_PERSON:
				break;
			default:
				break;
		}
		model.render(null, 0, 0, 0, 0, 0, 0.625F);

		GL11.glPopMatrix();
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
}
