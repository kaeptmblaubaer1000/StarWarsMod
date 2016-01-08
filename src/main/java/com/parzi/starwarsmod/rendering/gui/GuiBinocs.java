package com.parzi.starwarsmod.rendering.gui;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.font.FontManager;
import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.util.entity.EntityUtils;
import com.parzi.util.ui.GlPalette;
import com.parzi.util.ui.TextUtils;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class GuiBinocs
{
	public static String lookString = "";
	public static int lookStringPos = 0;
	public static long lookStringNextTime = 0;
	
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		ItemStack item = ClientEventHandler.playerHelper.getHeldItemStack();
		if (item != null && item.getItem() instanceof ItemBinoculars && ItemBinoculars.getEnabled(item))
		{
			StarWarsMod.isOverlayOnscreen = true;
			if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
			{
				ResourceLocation guiTexture;
				if (item.getItem() instanceof ItemBinocularsTatooine)
					guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
				else
					guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
				ClientEventHandler.pgui.renderOverlay(guiTexture);

				if (item.getItem() instanceof ItemBinocularsTatooine)
				{
					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					float textCenterX = event.resolution.getScaledWidth() * (578f / 900F);
					float textCenterY = event.resolution.getScaledHeight() * (355 / 380F);

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[0]);

					String s = e == null ? "" : TextUtils.translateAurebesh(e.getCommandSenderName());
					String block = s != "" && lookStringPos < lookString.length() ? "\u2588" : "";

					if (lookString != s)
					{
						lookString = s;
						lookStringPos = 0;
					}
					else if (lookStringNextTime <= System.currentTimeMillis() && lookStringPos < lookString.length())
					{
						lookStringPos++;
						lookStringNextTime = System.currentTimeMillis() + 50;
					}

					FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GlPalette.YELLOW, true);
				}
			}
		}
	}
}
