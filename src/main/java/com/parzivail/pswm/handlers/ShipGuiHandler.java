package com.parzivail.pswm.handlers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

/**
 * Created by colby on 10/17/2016.
 */
public class ShipGuiHandler
{
	public static void drawGui(boolean firstPerson, RenderGameOverlayEvent.Pre event)
	{
		if (!(EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer) instanceof Pilotable))
			return;

		Pilotable ship = (Pilotable)EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer);

		if (firstPerson && ship != null)
		{
			StarWarsMod.isOverlayOnscreen = true;

			if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
			{
				GL11.glPushMatrix();
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_TEXTURE_2D);

				// Center of screen
				GL11.glTranslated(event.resolution.getScaledWidth_double() / 2f, event.resolution.getScaledHeight_double() / 2f, 200);

				float pitch = ship.prevRotationPitch + MathHelper.wrapAngleTo180_float(ship.axes.getPitch() - ship.prevRotationPitch) * event.partialTicks;
				float roll = ship.prevRotationRoll + MathHelper.wrapAngleTo180_float(ship.axes.getRoll() - ship.prevRotationRoll) * event.partialTicks;
				float yaw = ship.prevRotationYaw + MathHelper.wrapAngleTo180_float(ship.axes.getYaw() - ship.prevRotationYaw) * event.partialTicks;

				/*
				 * Horizon Line
				 */
				GL11.glPushMatrix();
				// Reverse roll and pitch to find horizon
				GL11.glRotatef(roll, 0, 0, 1);
				GL11.glTranslated(0, -pitch * 3 + Math.sin(-pitch / 180f) * -15, 0);

				GLPalette.glColorI(GLPalette.ANALOG_GREEN);

				// Left indicator
				GFX.drawLine(0, 0, 4, 4);
				GFX.drawLine(4, 4, 20, 4);
				// Right indicator
				GFX.drawLine(0, 0, -4, 4);
				GFX.drawLine(-4, 4, -20, 4);
				GL11.glPopMatrix();

				/*
				 * Compass
				 */
				GL11.glPushMatrix();

				float rad = 30;
				float radi = 28; // inner

				GL11.glTranslated(0, event.resolution.getScaledHeight_double() / 2f - 10, 0);

				GL11.glPushMatrix();
				GL11.glRotatef(-(yaw + 2.5f), 0, 0, 1);
				for (float i = (float)(-Math.PI); i < Math.PI; i += (2 * Math.PI) / 36f)
				{
					GL11.glBegin(GL11.GL_LINE_STRIP);
					float n = (float)(i - Math.PI / 2f);
					GL11.glVertex2d(MathHelper.cos(n) * rad, MathHelper.sin(n) * rad);
					GL11.glVertex2d(MathHelper.cos(n) * radi, MathHelper.sin(n) * radi);
					GL11.glEnd();
				}
				GL11.glPopMatrix();

				GL11.glEnable(GL11.GL_TEXTURE_2D);
				rad += 1;
				GFX.drawText(StarWarsMod.mc.fontRenderer, "S", MathHelper.cos((float)Math.toRadians(-yaw)) * rad, MathHelper.sin((float)Math.toRadians(-yaw)) * rad, 0.5f, -(yaw - 90), GLPalette.ACID_GREEN);
				GFX.drawText(StarWarsMod.mc.fontRenderer, "E", MathHelper.cos((float)Math.toRadians(-(yaw + 90))) * rad, MathHelper.sin((float)Math.toRadians(-(yaw + 90))) * rad, 0.5f, -(yaw), GLPalette.ACID_GREEN);
				GFX.drawText(StarWarsMod.mc.fontRenderer, "N", MathHelper.cos((float)Math.toRadians(-(yaw + 180))) * rad, MathHelper.sin((float)Math.toRadians(-(yaw + 180))) * rad, 0.5f, -(yaw + 90), GLPalette.ACID_GREEN);
				GFX.drawText(StarWarsMod.mc.fontRenderer, "W", MathHelper.cos((float)Math.toRadians(-(yaw - 90))) * rad, MathHelper.sin((float)Math.toRadians(-(yaw - 90))) * rad, 0.5f, -(yaw - 180), GLPalette.ACID_GREEN);
				GL11.glDisable(GL11.GL_TEXTURE_2D);

				GL11.glPopMatrix();

				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glPopMatrix();
			}
		}
	}
}
