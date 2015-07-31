package com.parzi.starwarsmod.rendering.gui;

import java.util.Collection;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.client.config.GuiUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiCreditsOverlay extends Gui
{
	private Minecraft mc;
	private IIcon creditIcon;

	public GuiCreditsOverlay(Minecraft mc)
	{
		this.mc = mc;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.HOTBAR) { return; }

		int xPos = 2;
		int yPos = 2;

		int xSize = 64;
		int ySize = 32;

		this.drawString(mc.fontRenderer, String.valueOf(countCredits()), 4, 4, 0xFFFFFF);
	}

	public int countCredits()
	{
		int credits = 0;
		for (ItemStack stack : mc.thePlayer.inventory.mainInventory)
		{
			if (stack != null && stack.getItem() != null && stack.getItem() == StarWarsMod.imperialCredit)
			{
				credits += stack.stackSize;
			}
		}
		return credits;
	}
}