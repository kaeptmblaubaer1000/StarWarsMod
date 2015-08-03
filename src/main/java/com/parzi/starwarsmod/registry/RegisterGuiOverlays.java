package com.parzi.starwarsmod.registry;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.gui.GuiCreditsOverlay;

public class RegisterGuiOverlays
{
	public static void registerAll()
	{
		if (StarWarsMod.enableCreditsOverlay)
		{
			MinecraftForge.EVENT_BUS.register(new GuiCreditsOverlay(Minecraft.getMinecraft()));
		}
	}
}
