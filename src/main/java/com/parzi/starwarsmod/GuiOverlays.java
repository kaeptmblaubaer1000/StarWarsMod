package com.parzi.starwarsmod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import com.parzi.starwarsmod.rendering.gui.GuiCreditsOverlay;

public class GuiOverlays
{
	public static void registerAll()
	{
		if (StarWarsMod.enableCreditsOverlay)
		{
			MinecraftForge.EVENT_BUS.register(new GuiCreditsOverlay(Minecraft.getMinecraft()));
		}
	}
}
