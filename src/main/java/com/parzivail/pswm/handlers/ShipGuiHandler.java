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
				GL11.glPushAttrib(GL11.GL_LIGHTING);
				GL11.glPushAttrib(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_TEXTURE_2D);

				// Center of screen
				GL11.glTranslated(event.resolution.getScaledWidth_double() / 2f, event.resolution.getScaledHeight_double() / 2f, 200);

				float pitch = ship.prevRotationPitch + MathHelper.wrapAngleTo180_float(ship.axes.getPitch() - ship.prevRotationPitch) * event.partialTicks;
				float roll = ship.prevRotationRoll + MathHelper.wrapAngleTo180_float(ship.axes.getRoll() - ship.prevRotationRoll) * event.partialTicks;

				// Reverse roll and pitch to find horizon
				GL11.glRotatef(roll, 0, 0, 1);
				GL11.glTranslated(0, -pitch * Math.PI + Math.sin(-pitch / 180f) * -15, 0);

				GLPalette.glColorI(GLPalette.ANALOG_GREEN);

				GFX.drawLine(0, 0, 4, 4);
				GFX.drawLine(4, 4, 20, 4);

				GFX.drawLine(0, 0, -4, 4);
				GFX.drawLine(-4, 4, -20, 4);

				GL11.glPopAttrib();
				GL11.glPopAttrib();
				GL11.glPopMatrix();
			}
		}
	}
}
