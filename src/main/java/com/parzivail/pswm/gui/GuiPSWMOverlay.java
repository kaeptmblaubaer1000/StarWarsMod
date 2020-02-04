package com.parzivail.pswm.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.quest.QuestUtils;
import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.IDebugProvider;
import com.parzivail.util.block.TileEntityRotate;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.LangUtils;
import com.parzivail.util.ui.P3D;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.text.NumberFormat;
import java.util.ArrayList;

import static com.parzivail.util.ui.GFX.swIcons;

public class GuiPSWMOverlay extends Gui
{
	private Minecraft mc;
	private NumberFormat format;

	public GuiPSWMOverlay(Minecraft mc)
	{
		this.mc = mc;

		this.format = NumberFormat.getInstance();
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		if (event.type != RenderGameOverlayEvent.ElementType.HOTBAR || !ConfigOptions.enableCreditsOverlay)
			return;

		RenderHelper.disableStandardItemLighting();

		GFX.drawTextShadow(mc.fontRenderer, "PSWM v" + Resources.VERSION, 5, 5, 1, GLPalette.SW_YELLOW);
		GFX.drawTextShadow(mc.fontRenderer, String.valueOf(QuestUtils.getPlayerBronzeCredits(StarWarsMod.mc.thePlayer)), 17, 17, 1, GLPalette.SW_YELLOW);
		GFX.renderItem(2, 13, new ItemStack(StarWarsItems.imperialCredit, 0));

		ScaledResolution r = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

		GL11.glDisable(GL11.GL_LIGHTING);

		if (ItemQuestLog.getSide(StarWarsMod.mc.thePlayer).equals(Resources.allegianceRebelFmt))
		{
			GL11.glPushMatrix();
			GL11.glColor4f(1, 1, 1, 1);
			GL11.glTranslatef(6, 30, 10);
			StarWarsMod.mc.renderEngine.bindTexture(swIcons);
			GFX.drawTexture(0, 0, 33, 26, 16, 16);
			GL11.glColor4f(1, 1, 1, 1);
			GL11.glPopMatrix();
		}
		else if (ItemQuestLog.getSide(StarWarsMod.mc.thePlayer).equals(Resources.allegianceImperialFmt))
		{
			GL11.glPushMatrix();
			GL11.glColor4f(0, 0, 0, 1);
			GL11.glTranslatef(6, 30, 10);
			StarWarsMod.mc.renderEngine.bindTexture(swIcons);
			GFX.drawTexture(0, 0, 49, 26, 16, 16);
			GL11.glColor4f(1, 1, 1, 1);
			GL11.glPopMatrix();
		}

		if (Cron.getHolocron(StarWarsMod.mc.thePlayer) != null)
		{
			ItemStack robes = Cron.getHolocron(StarWarsMod.mc.thePlayer);
			int xp = Cron.getXP(robes);
			int maxxp = Cron.getMaxXP(robes);

			boolean isJedi = Cron.getSide(robes).equals(Cron.SIDE_JEDI);
			int guiColor = isJedi ? GLPalette.GREEN_APPLE : GLPalette.RED_ORANGE;

			RenderHelper.disableStandardItemLighting();
			GFX.renderLightsaberBarOnscreen(2, r.getScaledHeight() - 10, (float)xp / (float)maxxp, isJedi);
			GFX.renderOrderLogo(26, 30, isJedi);

			GL11.glPushMatrix();
			P3D.glScalef(0.5f);

			PowerBase active;
			if ((active = Cron.getActive(StarWarsMod.mc.thePlayer)) != null)
				this.drawString(this.mc.fontRenderer, active.getLocalizedName(), r.getScaledWidth() + 3, r.getScaledHeight() - 10, guiColor);

			int y = (r.getScaledHeight() - 25) * 2;

			for (PowerBase cooling : Cron.coolingPowers)
			{
				GFX.drawLoadingCircleWithoutSetup(15, y, 10, cooling.recharge / cooling.rechargeTime, guiColor);
				this.drawString(this.mc.fontRenderer, cooling.getLocalizedName() + ": " + (int)Math.ceil(cooling.recharge / 40f) + "s", 30, y - 3, GLPalette.WHITE);
				y -= 22;
			}

			for (EntityCooldownEntry entry : Cron.entitiesWithEffects)
			{
				GFX.drawLoadingCircleWithoutSetup(15, y, 10, entry.cooldownLeft / (float)entry.cooldown, GLPalette.ANALOG_BLUE);
				this.drawString(this.mc.fontRenderer, entry.entity.getCommandSenderName() + " (" + entry.effect + "): " + (int)Math.ceil(entry.cooldownLeft / 40f) + "s", 30, y - 3, GLPalette.WHITE);
				y -= 22;
			}

			this.drawCenteredString(this.mc.fontRenderer, LangUtils.translate("force.xp.0.1", this.format.format(xp), this.format.format(maxxp)), 145, (r.getScaledHeight() - 15) * 2, guiColor);
			GL11.glPopMatrix();
		}

		if (this.mc.objectMouseOver != null)
		{
			if (this.mc.objectMouseOver.typeOfHit == MovingObjectType.BLOCK && mc.gameSettings.showDebugInfo)
			{
				MovingObjectPosition mop = this.mc.objectMouseOver;
				Block block = this.mc.theWorld.getBlock(mop.blockX, mop.blockY, mop.blockZ);

				if (block != null)
				{

					ArrayList<String> s = new ArrayList<>();
					s.add(LangUtils.translate("block.s.id.s", block.getLocalizedName(), Item.getIdFromItem(Item.getItemFromBlock(block))));
					s.add(LangUtils.translate("meta.0", this.mc.theWorld.getBlockMetadata(mop.blockX, mop.blockY, mop.blockZ)));
					TileEntity tileEntity = this.mc.theWorld.getTileEntity(mop.blockX, mop.blockY, mop.blockZ);
					s.add(LangUtils.translate("tile.0", tileEntity == null ? LangUtils.translate("none") : tileEntity.getClass().getName()));

					boolean didChange = false;
					if (block instanceof IDebugProvider)
					{
						IDebugProvider debugProvider = (IDebugProvider)block;

						int ll = s.size();
						debugProvider.getDebugText(s, this.mc.thePlayer, this.mc.theWorld, mop.blockX, mop.blockY, mop.blockZ);
						didChange = ll < s.size();
					}

					if (tileEntity instanceof TileEntityRotate && !didChange)
					{
						s.add(LangUtils.translate("rotate.0", ((TileEntityRotate)tileEntity).getFacing()));
					}

					GL11.glPushMatrix();
					P3D.glScalef(0.5f);

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

				ArrayList<String> s = new ArrayList<>();
				s.add(LangUtils.translate("entity.s.eid.s", mop.entityHit.getCommandSenderName(), mop.entityHit.getEntityId()));
				s.add(LangUtils.translate("class.s", mop.entityHit.getClass().getName()));

				if (mop.entityHit instanceof IDebugProvider)
				{
					IDebugProvider debugProvider = (IDebugProvider)mop.entityHit;

					debugProvider.getDebugText(s, this.mc.thePlayer, this.mc.theWorld, mop.blockX, mop.blockY, mop.blockZ);
				}

				GL11.glPushMatrix();
				P3D.glScalef(0.5f);

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
