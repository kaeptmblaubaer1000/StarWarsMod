package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.gui.GuiPSWMOverlay;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class RegisterGuiOverlays
{
	public static void registerAll()
	{
		if (ConfigOptions.enableCreditsOverlay)
			MinecraftForge.EVENT_BUS.register(new GuiPSWMOverlay(Minecraft.getMinecraft()));
	}
}
