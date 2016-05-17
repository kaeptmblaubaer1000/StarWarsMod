package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.jedirobes.powers.Power;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.pswm.utils.ForceUtils.EntityCooldownEntry;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.ui.GLPZ;
import com.parzivail.util.ui.GLPalette;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;

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
				if (stack.getItem() == StarWarsItems.imperialCredit)
					credits += stack.stackSize;
				if (stack.getItem() == StarWarsItems.silverImperialCredit)
					credits += stack.stackSize * 9;
				if (stack.getItem() == StarWarsItems.goldImperialCredit)
					credits += stack.stackSize * 81;
			}
		return credits;
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR || !ConfigOptions.enableCreditsOverlay)
			return;

		RenderHelper.disableStandardItemLighting();

		this.mc.fontRenderer.drawStringWithShadow("PSWM v" + Resources.VERSION, 5, 5, 16777215);
		ClientEventHandler.pgui.renderItem(23, 12, new ItemStack(StarWarsItems.imperialCredit, this.countCredits()));

		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

		if (this.mc.thePlayer.inventory.armorItemInSlot(2) != null && this.mc.thePlayer.inventory.armorItemInSlot(2).getItem() == StarWarsItems.jediRobes)
		{

			ItemStack robes = this.mc.thePlayer.inventory.armorItemInSlot(2);
			int xp = ArmorJediRobes.getXP(robes);
			int maxxp = ArmorJediRobes.getMaxXP(robes);

			boolean isJedi = ArmorJediRobes.getSide(robes).equals(ArmorJediRobes.SIDE_JEDI);
			int guiColor = isJedi ? GLPalette.GREEN_APPLE : GLPalette.RED_ORANGE;

			RenderHelper.disableStandardItemLighting();
			ClientEventHandler.pgui.renderLightsaberBarOnscreen(2, r.getScaledHeight() - 10, (float)xp / (float)maxxp, isJedi);
			ClientEventHandler.pgui.renderOrderLogo(70, 6, isJedi);

			GL11.glPushMatrix();
			GLPZ.glScalef(0.5f);

			if (Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer)) != null)
				this.drawString(this.mc.fontRenderer, Power.getPowerFromName(ArmorJediRobes.getActive(StarWarsMod.mc.thePlayer)).getLocalizedName(), r.getScaledWidth() + 3, r.getScaledHeight() - 10, guiColor);

			int y = (r.getScaledHeight() - 25) * 2;

			Iterator<Power> coolingIt = ForceUtils.coolingPowers.iterator();
			while (coolingIt.hasNext())
			{
				Power cooling = coolingIt.next();
				ClientEventHandler.pgui.drawLoadingCircleWithoutSetup(15, y, 10, cooling.recharge / cooling.rechargeTime, guiColor);
				this.drawString(this.mc.fontRenderer, cooling.getLocalizedName() + ": " + (int)Math.ceil(cooling.recharge / 40f) + "s", 30, y - 3, GLPalette.WHITE);
				y -= 22;
			}

			for (EntityCooldownEntry entry : ForceUtils.entitiesWithEffects)
			{
				ClientEventHandler.pgui.drawLoadingCircleWithoutSetup(15, y, 10, entry.cooldownLeft / (float)entry.cooldown, GLPalette.ANALOG_BLUE);
				this.drawString(this.mc.fontRenderer, entry.entity.getCommandSenderName() + " (" + entry.effect + "): " + (int)Math.ceil(entry.cooldownLeft / 40f) + "s", 30, y - 3, GLPalette.WHITE);
				y -= 22;
			}

			this.drawCenteredString(this.mc.fontRenderer, "FORCE XP: " + this.format.format(xp) + "/" + this.format.format(maxxp), 145, (r.getScaledHeight() - 15) * 2, guiColor);
			GL11.glPopMatrix();
		}

		if (this.mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK && mc.gameSettings.showDebugInfo)
		{
			MovingObjectPosition mop = this.mc.objectMouseOver;
			if (this.mc.theWorld.getBlock(mop.blockX, mop.blockY, mop.blockZ) instanceof IDebugProvider)
			{
				Block block = this.mc.theWorld.getBlock(mop.blockX, mop.blockY, mop.blockZ);
				IDebugProvider debugProvider = (IDebugProvider)block;

				ArrayList<String> s = new ArrayList<>();
				s.add(block.getLocalizedName());

				debugProvider.getDebugText(s, this.mc.thePlayer, this.mc.theWorld, mop.blockX, mop.blockY, mop.blockZ);

				GL11.glPushMatrix();
				GLPZ.glScalef(0.5f);

				int y = 0;
				for (String line : s)
				{
					this.drawString(this.mc.fontRenderer, line, r.getScaledWidth() + 3, r.getScaledHeight() + 3 + (y * (this.mc.fontRenderer.FONT_HEIGHT + 2)), GLPalette.WHITE);
					y++;
				}

				GL11.glPopMatrix();
			}
		}
		else if (this.mc.objectMouseOver.typeOfHit == MovingObjectType.ENTITY && mc.gameSettings.showDebugInfo)
		{
			MovingObjectPosition mop = this.mc.objectMouseOver;
			if (mop.entityHit instanceof IDebugProvider)
			{
				IDebugProvider debugProvider = (IDebugProvider)mop.entityHit;

				ArrayList<String> s = new ArrayList<>();
				s.add(mop.entityHit.getCommandSenderName());

				debugProvider.getDebugText(s, this.mc.thePlayer, this.mc.theWorld, mop.blockX, mop.blockY, mop.blockZ);

				GL11.glPushMatrix();
				GLPZ.glScalef(0.5f);

				int y = 0;
				for (String line : s)
				{
					this.drawString(this.mc.fontRenderer, line, r.getScaledWidth() + 3, r.getScaledHeight() + 3 + (y * (this.mc.fontRenderer.FONT_HEIGHT + 2)), GLPalette.WHITE);
					y++;
				}

				GL11.glPopMatrix();
			}
		}

		RenderHelper.disableStandardItemLighting();
	}
}
