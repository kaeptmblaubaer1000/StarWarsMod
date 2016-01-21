package com.parzivail.pswm.rendering.gui;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.items.weapons.ItemBlasterRifle;
import com.parzivail.pswm.rendering.helper.PGui;

public class GuiBlaster
{
	public void onRenderGui(Pre event)
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.inventory.getCurrentItem() != null && (StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsMod.blasterRifle || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsMod.blasterPistol || StarWarsMod.mc.thePlayer.inventory.getCurrentItem().getItem() == StarWarsMod.blasterHeavy))
		{
			ItemStack stack = StarWarsMod.mc.thePlayer.inventory.getCurrentItem();

			ClientEventHandler.pgui.drawLoadingDonutWithoutSetup((float)(event.resolution.getScaledWidth_double() / 2), (float)(event.resolution.getScaledHeight_double() / 2), 9, 1, 0.3f, 0xFFFFFFFF);
			ClientEventHandler.pgui.drawFilledCircle((float)(event.resolution.getScaledWidth_double() / 2) - 7.7f, (float)(event.resolution.getScaledHeight_double() / 2), 1.38f, 0xFFFFFFFF);
			ClientEventHandler.pgui.drawFilledCircle((float)(event.resolution.getScaledWidth_double() / 2) + 7.7f, (float)(event.resolution.getScaledHeight_double() / 2), 1.38f, 0xFFFFFFFF);

			float p = ItemBlasterRifle.getCooldown(stack) / 15f;
			int n = (int)(200 * (1 - p));

			ClientEventHandler.pgui.drawLoadingDonutWithoutSetup((float)(event.resolution.getScaledWidth_double() / 2), (float)(event.resolution.getScaledHeight_double() / 2), 8, p, 0.1f, PGui.getRGBA(n, n, 255, 255));
		}
	}
}
