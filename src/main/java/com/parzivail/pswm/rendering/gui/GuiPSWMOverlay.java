package com.parzivail.pswm.rendering.gui;

import java.text.NumberFormat;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.jedirobes.powers.Power;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.pswm.utils.ForceUtils.EntityCooldownEntry;
import com.parzivail.util.ui.GlPalette;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiPSWMOverlay extends Gui
{
	private Minecraft mc;
	private RenderItem r;
	private NumberFormat format;

	public GuiPSWMOverlay(Minecraft mc)
	{
		this.mc = mc;
		this.r = RenderItem.getInstance();

		this.format = NumberFormat.getInstance();
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
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR || !Resources.enableCreditsOverlay)
			return;

		RenderHelper.disableStandardItemLighting();

		this.mc.fontRenderer.drawStringWithShadow("PSWM v" + Resources.VERSION, 5, 5, 16777215);
		ClientEventHandler.pgui.renderItem(23, 12, new ItemStack(StarWarsMod.imperialCredit, this.countCredits()));

		if (this.mc.thePlayer.inventory.armorItemInSlot(2) != null && this.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

			ItemStack robes = this.mc.thePlayer.inventory.armorItemInSlot(2);
			int xp = ArmorJediRobes.getXP(robes);
			int maxxp = ArmorJediRobes.getMaxXP(robes);

			boolean isJedi = ArmorJediRobes.getSide(robes).equals(ArmorJediRobes.SIDE_JEDI);
			int guiColor = isJedi ? GlPalette.GREEN_APPLE : GlPalette.RED_ORANGE;

			RenderHelper.disableStandardItemLighting();
			ClientEventHandler.pgui.renderLightsaberBarOnscreen(2, r.getScaledHeight() - 10, (float)xp / (float)maxxp, isJedi);
			ClientEventHandler.pgui.renderOrderLogo(65, 6, isJedi);

			GL11.glPushMatrix();
			GL11.glScalef(0.5f, 0.5f, 0.5f);

			if (Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer)) != null)
				this.drawString(this.mc.fontRenderer, Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer)).getLocalizedName(), r.getScaledWidth() + 3, r.getScaledHeight() - 10, guiColor);

			int y = (r.getScaledHeight() - 25) * 2;

			Iterator<Power> coolingIt = ForceUtils.coolingPowers.iterator();
			while (coolingIt.hasNext())
			{
				Power cooling = coolingIt.next();
				ClientEventHandler.pgui.drawLoadingCircleWithoutSetup(15, y, 10, cooling.recharge / cooling.rechargeTime, guiColor);
				this.drawString(this.mc.fontRenderer, cooling.getLocalizedName() + ": " + (int)Math.ceil(cooling.recharge / 40f) + "s", 30, y - 3, GlPalette.WHITE);
				y -= 22;
			}

			for (EntityCooldownEntry entry : ForceUtils.entitiesWithEffects)
			{
				ClientEventHandler.pgui.drawLoadingCircleWithoutSetup(15, y, 10, entry.cooldownLeft / (float)entry.cooldown, GlPalette.ANALOG_BLUE);
				this.drawString(this.mc.fontRenderer, entry.entity.getCommandSenderName() + " (" + entry.effect + "): " + (int)Math.ceil(entry.cooldownLeft / 40f) + "s", 30, y - 3, GlPalette.WHITE);
				y -= 22;
			}

			this.drawCenteredString(this.mc.fontRenderer, "FORCE XP: " + this.format.format(xp) + "/" + this.format.format(maxxp), 145, (r.getScaledHeight() - 15) * 2, guiColor);
			GL11.glPopMatrix();
		}

		RenderHelper.disableStandardItemLighting();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\rendering\gui\GuiCreditsOverlay.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */