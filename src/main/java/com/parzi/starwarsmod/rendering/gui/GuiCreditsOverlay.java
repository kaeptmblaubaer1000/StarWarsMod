package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiCreditsOverlay extends Gui
{
	private Minecraft mc;
	private RenderItem r;

	public GuiCreditsOverlay(Minecraft mc)
	{
		this.mc = mc;
		this.r = RenderItem.getInstance();
	}

	public int countCredits()
	{
		int credits = 0;
		for (ItemStack stack : this.mc.thePlayer.inventory.mainInventory)
			if (stack != null && stack.getItem() != null)
			{
				if (stack.getItem() == StarWarsMod.imperialCredit)
					credits += stack.stackSize;
				if (stack.getItem() == StarWarsMod.silverImperialCredit)
					credits += stack.stackSize * 9;
				if (stack.getItem() == StarWarsMod.goldImperialCredit)
					credits += stack.stackSize * 81;
			}
		return credits;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR || !StarWarsMod.enableCreditsOverlay)
			return;
		this.mc.fontRenderer.drawStringWithShadow("PSWM v" + StarWarsMod.VERSION, 5, 5, 16777215);
		StarWarsMod.pgui.renderItem(23, 12, new ItemStack(StarWarsMod.imperialCredit, this.countCredits()));
		net.minecraft.client.renderer.RenderHelper.enableGUIStandardItemLighting();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiCreditsOverlay.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */