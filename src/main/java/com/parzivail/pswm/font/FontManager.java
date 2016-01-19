package com.parzivail.pswm.font;

import com.parzivail.pswm.Resources;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;

public class FontManager
{
	@SideOnly(Side.CLIENT)
	public static FontRenderer aurebesh;

	public static FontRenderer createFont(String file, boolean small)
	{
		FontRenderer renderer = new FontRenderer(Minecraft.getMinecraft().gameSettings, new ResourceLocation(Resources.MODID, file), Minecraft.getMinecraft().getTextureManager(), small);

		((IReloadableResourceManager)Minecraft.getMinecraft().getResourceManager()).registerReloadListener(renderer);

		return renderer;
	}

	public static void registerAll()
	{
		aurebesh = createFont("textures/font/aurebesh.png", false);
	}
}
