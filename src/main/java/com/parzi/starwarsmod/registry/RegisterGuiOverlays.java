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
			MinecraftForge.EVENT_BUS.register(new GuiCreditsOverlay(Minecraft.getMinecraft()));
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\RegisterGuiOverlays.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */