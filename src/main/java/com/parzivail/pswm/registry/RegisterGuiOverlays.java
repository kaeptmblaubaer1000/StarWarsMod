package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.gui.GuiPSWMOverlay;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class RegisterGuiOverlays
{
	public static void registerAll()
	{
		if (Resources.enableCreditsOverlay)
			MinecraftForge.EVENT_BUS.register(new GuiPSWMOverlay(Minecraft.getMinecraft()));
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\RegisterGuiOverlays.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */