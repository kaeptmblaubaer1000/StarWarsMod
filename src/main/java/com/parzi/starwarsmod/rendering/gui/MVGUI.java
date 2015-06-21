package com.parzi.starwarsmod.rendering.gui;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.WorldUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

public class MVGUI extends GuiScreen
{

	private int w = 166;
	private int h = 191;
	private int x;
	private int y;
	private ResourceLocation backgroundimage = new ResourceLocation(StarWarsMod.MODID + ":" + "textures/gui/default.png");

	private int blockx;
	private int blockz;

	public MVGUI(int x, int z)
	{
		blockx = x;
		blockz = z;
	}

	@Override
	public void onGuiClosed()
	{
	}

	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartialTicks)
	{
		drawDefaultBackground();

		x = (this.width - w) / 2;
		y = (this.height - h) / 2;

		int py = y + 10;

		this.mc.getTextureManager().bindTexture(backgroundimage);
		drawTexturedModalRect(x, y, 0, 0, w, h);

		drawString(mc.fontRenderer, "Moisture Vaporator", x + 10, py, 0xFFFFFF);
		py += 10;
		drawString(mc.fontRenderer, "Current Biome: " + WorldUtils.getBiomeName(blockx, blockz), x + 10, py, 0xFFFFFF);
	}
}
