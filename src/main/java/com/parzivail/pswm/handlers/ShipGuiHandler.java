package com.parzivail.pswm.handlers;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.driven.Pilotable;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.ui.GFX;
import com.parzivail.util.ui.GLPalette;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

/**
 * Created by colby on 10/17/2016.
 */
public class ShipGuiHandler
{
	private static Color RED = new Color(GLPalette.ANALOG_RED);
	private static Color YELLOW = new Color(GLPalette.ORANGE);
	private static Color GREEN = new Color(GLPalette.ACID_GREEN);

	public static void drawGui(boolean firstPerson, RenderGameOverlayEvent.Pre event)
	{
		if (!(EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer) instanceof Pilotable))
			return;

		Pilotable ship = (Pilotable)EntityUtils.getShipRiding(StarWarsMod.mc.thePlayer);

		// I'd like to point out that this
		// is impossible, but IntelliJ likes
		// to complain about 'this might be
		// null' warnings so, here. happy?
		if (ship == null)
			return;

		if (ClientEventHandler.renderHelper.getCameraMode() == 2)
			ClientEventHandler.renderHelper.setCameraMode(0);

		if (ClientEventHandler.renderHelper.isFirstPerson())
		{
			ship.data.cameraDistance = 1;
		}
		else
		{
			ship.data.cameraDistance = ship.data.cameraDistanceMax;
		}

		StarWarsMod.mc.renderViewEntity = ship != null ? ship.getCamera() : StarWarsMod.mc.thePlayer;

		// this-partial-tick ship stats
		float pitch = ship.prevRotationPitch + MathHelper.wrapAngleTo180_float(ship.axes.getPitch() - ship.prevRotationPitch) * event.partialTicks;
		float roll = ship.prevRotationRoll + MathHelper.wrapAngleTo180_float(ship.axes.getRoll() - ship.prevRotationRoll) * event.partialTicks;
		float yaw = ship.prevRotationYaw + MathHelper.wrapAngleTo180_float(ship.axes.getYaw() - ship.prevRotationYaw) * event.partialTicks;

		GFX.changeCameraRoll(-(ship.prevRotationRoll + MathHelper.wrapAngleTo180_float(ship.axes.getRoll() - ship.prevRotationRoll)));

		StarWarsMod.isOverlayOnscreen = true;

		if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
		{
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);

			GL11.glLineWidth(2);

			GLPalette.glColorI(GLPalette.ACID_GREEN);

			if (firstPerson)
			{
				/*
				 * Horizon Line
				 */
				GL11.glPushMatrix();

				// Center of screen
				GL11.glTranslated(event.resolution.getScaledWidth_double() / 2f, event.resolution.getScaledHeight_double() / 2f, 200);

				// Reverse roll and pitch to find horizon
				GL11.glRotatef(roll, 0, 0, 1);
				GL11.glTranslated(0, -pitch * 3.28f, 0);

				// Left indicator
				GFX.drawLine(0, 0, 4, 4);
				GFX.drawLine(4, 4, 20, 4);
				// Right indicator
				GFX.drawLine(0, 0, -4, 4);
				GFX.drawLine(-4, 4, -20, 4);

				GL11.glPopMatrix();
			}

			/*
			 * Compass
			 */
			GL11.glPushMatrix();

			float rad = 30;
			float radi = 28; // inner

			// Center of screen
			GL11.glTranslated(event.resolution.getScaledWidth_double() / 2f, event.resolution.getScaledHeight_double() - 10, 200);

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

			/*
			 * Altimeter
			 */
			GL11.glPushMatrix();

			// Center of screen
			GL11.glTranslated(event.resolution.getScaledWidth_double() - 20, event.resolution.getScaledHeight_double() / 2f, 200);

			GL11.glPushMatrix();
			float representMod = 5;
			float nearest = MathUtils.floorToNearest((float)ship.posY, representMod);
			float yDiff = (float)ship.posY - nearest;

			float numOffset = -(yDiff * representMod) / 2f;

			GFX.drawLine(0, -100, 0, 100);

			GFX.drawLine(-2, 0, -7, -5);
			GFX.drawLine(-2, 0, -7, 5);

			for (float i = -2; i < 2; i++)
			{
				GFX.drawLine(-6, 50 * i - numOffset, 0, 50 * i - numOffset);
			}
			GL11.glPopMatrix();

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			for (float i = -2; i < 2; i++)
			{
				GFX.drawText(StarWarsMod.mc.fontRenderer, String.valueOf(nearest - i * representMod), 2, 50 * i - numOffset - 1.6f, 0.5f, GLPalette.ACID_GREEN);
			}
			GFX.drawCenteredText(StarWarsMod.mc.fontRenderer, "Alti", 0, -105, 0.5f, GLPalette.ACID_GREEN);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			GL11.glPopMatrix();

			/*
			 * Ship Health Bar
			 */
			GL11.glPushMatrix();

			// Center of screen
			GL11.glTranslated(5, event.resolution.getScaledHeight_double() - 50, 200);

			GFX.rectangle(0, 8, 45, 10, false);
			GFX.rectangle(0, 33, 45, 10, false);

			float shipHealth = ship.data.shipHealth / ship.data.shipHealthMax;
			float shieldHealth = ship.data.shieldHealth / ship.data.shieldHealthMax;

			triPointLerp(shipHealth, RED, YELLOW, GREEN);
			GFX.rectangle(1, 9, 43 * shipHealth, 8, true);
			triPointLerp(shieldHealth, RED, YELLOW, GREEN);
			GFX.rectangle(1, 34, 43 * shieldHealth, 8, true);
			GLPalette.glColorI(GLPalette.ACID_GREEN);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GFX.drawText(StarWarsMod.mc.fontRenderer, "Fuselage Integrity", 0, 0, 0.5f, GLPalette.ACID_GREEN);
			GFX.drawText(StarWarsMod.mc.fontRenderer, String.format("%s%%", (int)(shipHealth * 100)), 47, 11, 0.5f, GLPalette.ACID_GREEN);
			GFX.drawText(StarWarsMod.mc.fontRenderer, "Shield Integrity", 0, 25, 0.5f, GLPalette.ACID_GREEN);
			GFX.drawText(StarWarsMod.mc.fontRenderer, String.format("%s%%", (int)(shieldHealth * 100)), 47, 36, 0.5f, GLPalette.ACID_GREEN);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();

			/*
			 * Ship Throttle Bar
			 */
			GL11.glPushMatrix();

			GL11.glTranslatef(5, 5, 0);

			GFX.rectangle(0, 8, 45, 10, false);

			float shipThrottle = ship.throttle / ship.data.maxThrottle;

			triPointLerp(shipThrottle, RED, GREEN, YELLOW);
			GFX.rectangle(1, 9, 43 * shipThrottle, 8, true);
			GLPalette.glColorI(GLPalette.ACID_GREEN);

			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GFX.drawText(StarWarsMod.mc.fontRenderer, "Throttle", 0, 0, 0.5f, GLPalette.ACID_GREEN);
			GFX.drawText(StarWarsMod.mc.fontRenderer, String.format("%s%%", (int)(shipThrottle * 100)), 47, 11, 0.5f, GLPalette.ACID_GREEN);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();


			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glPopMatrix();
		}
	}

	private static void triPointLerp(float energy, Color a, Color b, Color c)
	{
		if (energy < 0.5)
			lerp(b, a, energy * 2);
		else
			lerp(c, b, (energy - 0.5) * 2);
	}

	static private void lerp(Color x, Color y, double p)
	{
		double v = 1 - p;
		double r = x.getRed() * p + y.getRed() * v;
		double g = x.getGreen() * p + y.getGreen() * v;
		double b = x.getBlue() * p + y.getBlue() * v;
		GL11.glColor4d(r / 255f, g / 255f, b / 255f, 1f);
	}
}
