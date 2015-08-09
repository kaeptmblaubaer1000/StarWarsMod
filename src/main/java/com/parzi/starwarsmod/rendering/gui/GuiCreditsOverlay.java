package com.parzi.starwarsmod.rendering.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiCreditsOverlay extends Gui
{
	private Minecraft mc;
	private IIcon creditIcon;
	private RenderItem r;

	public GuiCreditsOverlay(Minecraft mc)
	{
		this.mc = mc;
		r = RenderItem.getInstance();
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

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.HOTBAR) { return; }

		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		RenderHelper.enableGUIStandardItemLighting();

		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		drawString(mc.fontRenderer, String.valueOf(countCredits()), 17, 7, 0xFFFFFF);

		r.renderItemIntoGUI(mc.fontRenderer, mc.getTextureManager(), new ItemStack(StarWarsMod.imperialCredit), 2, 2, true);

		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		r.renderWithColor = true;

		GL11.glDisable(GL11.GL_BLEND);

		GL11.glPopMatrix();
	}
}