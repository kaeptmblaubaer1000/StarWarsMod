package com.parzivail.pswm.gui;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.weapons.ItemBlasterRifle;
import com.parzivail.util.ui.GFX;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

public class GuiBlaster
{
	public static void onRenderGui(Pre event)
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.inventory.getCurrentItem() != null && (StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsItems.blasterRifle || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsItems.blasterPistol || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsItems.blasterHeavy || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsItems.sequelBlasterRifle || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsItems.sequelBlasterPistol))
		{
			ItemStack stack = StarWarsMod.mc.thePlayer.inventory.getCurrentItem();

			GFX.drawLoadingDonutWithoutSetup((float)(event.resolution.getScaledWidth_double() / 2), (float)(event.resolution.getScaledHeight_double() / 2), 8.6f, 1, 0.24f, 190, 0x22FFFFFF);

			float p = ItemBlasterRifle.getCooldown(stack) / 15f;
			int n = (int)(200 * (1 - p));

			GFX.drawLoadingDonutWithoutSetup((float)(event.resolution.getScaledWidth_double() / 2), (float)(event.resolution.getScaledHeight_double() / 2), 8, p, 0.1f, 180, GFX.getRGBA(n, n, 255, 80));
		}
	}
}
