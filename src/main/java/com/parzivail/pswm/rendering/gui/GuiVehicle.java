package com.parzivail.pswm.rendering.gui;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.font.FontManager;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.network.MessageShipTargetLock;
import com.parzivail.pswm.rendering.helper.VehicleLineDraw;
import com.parzivail.pswm.vehicles.*;
import com.parzivail.util.entity.EntityUtils;
import com.parzivail.util.math.MathUtils;
import com.parzivail.util.ui.GLPalette;
import com.parzivail.util.ui.TextUtils;
import com.parzivail.util.vehicle.VehicleAirBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class GuiVehicle
{
	public static float blipMax = 15;
	public static float blipFrame = blipMax;
	public static boolean isFiring = false;

	public static String lookString = "";
	public static int lookStringPos = 0;
	public static long lookStringNextTime = 0;

	public static long randomCharNextTime = 0;

	String randomChar1 = "C";
	String randomChar2 = "N";
	String randomChar3 = "D";
	String randomChar4 = "L";

	Entity lastTarget = null;

	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			GL11.glPushMatrix();
			VehicleAirBase vehicle = (VehicleAirBase)StarWarsMod.mc.thePlayer.ridingEntity;
			//GL11.glTranslatef(event.resolution.getScaledWidth() / 2f, event.resolution.getScaledHeight() / 2f, 0);
			float roll = MathUtils.lerp(vehicle.renderRollLast, -vehicle.tilt, event.partialTicks);
			GL11.glRotatef(roll, 0, 0, 1);

			StarWarsMod.isOverlayOnscreen = true;
			if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
			{
				if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
				{
					VehicXWing xwing = (VehicXWing)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					float radarCenterX = event.resolution.getScaledWidth() * (107 / 216F);
					float radarCenterY = event.resolution.getScaledHeight() * (119 / 144F);

					float textCenterX = event.resolution.getScaledWidth() * (79.5f / 216F);
					float textCenterY = event.resolution.getScaledHeight() * (137 / 144F);

					float entiCenterX = event.resolution.getScaledWidth() * (124 / 216F);
					float entiCenterY = event.resolution.getScaledHeight() * (107 / 144F);

					float entiCenterMaxX = event.resolution.getScaledWidth() * (138 / 216F);
					float entiCenterMaxY = event.resolution.getScaledHeight() * (131 / 144F);

					float scale = event.resolution.getScaledWidth() * (14 / 216f);

					if (System.currentTimeMillis() / 1000 % 2 == 0)
						ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlayBack1);
					else
						ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlayBack2);

					for (Entity p : xwing.nearby)
					{
						if (p instanceof VehicXWing || p instanceof VehicAWing)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, GLPalette.ANALOG_GREEN);
						if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
						if (p instanceof EntityPlayer)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
					}

					updateFiring();

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { xwing });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					if (xwing.getTargetLock())
						color = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlay);

					ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GLPalette.ANALOG_GREEN);

					String s = e == null ? "" : TextUtils.translateAurebesh(e.getCommandSenderName());

					String block = s != "" && lookStringPos < lookString.length() ? "\u2588" : "";

					if (lookString != s)
					{
						lookString = s;
						lookStringPos = 0;
					}
					else if (lookStringNextTime <= System.currentTimeMillis() && lookStringPos < lookString.length())
					{
						lookStringPos++;
						lookStringNextTime = System.currentTimeMillis() + 100;
					}

					ClientEventHandler.pgui.renderOverlay(ClientEventHandler.pgui.planetTextureFromDim(xwing.dimension), -4.215f * scale, -0.455f * scale);

					FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GLPalette.YELLOW, true);

					if (e != null)
					{
						GL11.glPushMatrix();

						if (e instanceof VehicXWing)
							VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0012f * scale);
						else if (e instanceof VehicTIE)
							VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0012f * scale);
						else if (e instanceof VehicTIEInterceptor)
							VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0012f * scale);
						else if (e instanceof VehicAWing)
							VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0012f * scale);

						GL11.glPopMatrix();
					}
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
				{
					VehicAWing awing = (VehicAWing)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					float radarCenterX = event.resolution.getScaledWidth() * (91.4f / 216F);
					float radarCenterY = event.resolution.getScaledHeight() * (124.5f / 144F);

					float textCenterX = event.resolution.getScaledWidth() * (75 / 216F);
					float textCenterY = event.resolution.getScaledHeight() * (140.7f / 144F);

					float entiCenterX = event.resolution.getScaledWidth() * (112 / 216F);
					float entiCenterY = event.resolution.getScaledHeight() * (129 / 144F);

					float entiCenterMaxX = event.resolution.getScaledWidth() * (126 / 216F);
					float entiCenterMaxY = event.resolution.getScaledHeight() * (139 / 144F);

					float arbiCenterX = event.resolution.getScaledWidth() * (128 / 216F);
					float arbiCenterY = event.resolution.getScaledHeight() * (128 / 144F);

					float arbiCenterMaxX = event.resolution.getScaledWidth() * (131 / 216F);
					float arbiCenterMaxY = event.resolution.getScaledHeight() * (138 / 144F);

					float scale = event.resolution.getScaledWidth() * (14 / 216f);

					if (System.currentTimeMillis() / 1000 % 2 == 0)
						ClientEventHandler.pgui.renderOverlay(Resources.awingBack);
					else
						ClientEventHandler.pgui.renderOverlay(Resources.awingBack2);

					for (Entity p : awing.nearby)
					{
						if (p instanceof VehicXWing || p instanceof VehicAWing)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, GLPalette.ANALOG_GREEN);
						if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
						if (p instanceof EntityPlayer)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
					}

					updateFiring();

					ClientEventHandler.pgui.renderOverlay(ClientEventHandler.pgui.planetTextureFromDim(awing.dimension), -1.07f * scale, -0.055f * scale);

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { awing });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					if (awing.getTargetLock())
						color = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					if (randomCharNextTime <= System.currentTimeMillis())
					{
						MathUtils.shuffleArray(Resources.randomCharArray);
						if (StarWarsMod.rngGeneral.nextInt(4) == 0)
							this.randomChar1 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						if (StarWarsMod.rngGeneral.nextInt(4) == 0)
							this.randomChar2 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						if (StarWarsMod.rngGeneral.nextInt(4) == 0)
							this.randomChar3 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						randomCharNextTime = System.currentTimeMillis() + 250;
					}

					GL11.glPushMatrix();
					GL11.glScalef(0.6f, 0.6f, 0.6f);
					FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) - 9, GLPalette.YELLOW, true);
					FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f), GLPalette.YELLOW, true);
					FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) + 9, GLPalette.YELLOW, true);
					GL11.glPopMatrix();

					ClientEventHandler.pgui.renderOverlay(Resources.awingPitch1, 0, (int)((1 - awing.move / awing.moveModifier) * 14));
					ClientEventHandler.pgui.renderOverlay(Resources.awingPitch2, 0, -Math.abs((int)(awing.rotationYaw / 180 * 8)) + 16);

					ClientEventHandler.pgui.renderOverlay(Resources.awingOverlay);

					ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GLPalette.ANALOG_GREEN);

					String s = e == null ? "" : TextUtils.translateAurebeshLong(e.getCommandSenderName());

					String block = s != "" && lookStringPos < lookString.length() ? "\u2588" : "";

					if (lookString != s)
					{
						lookString = s;
						lookStringPos = 0;
					}
					else if (lookStringNextTime <= System.currentTimeMillis() && lookStringPos < lookString.length())
					{
						lookStringPos++;
						lookStringNextTime = System.currentTimeMillis() + 100;
					}

					GL11.glPushMatrix();
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX * 2, (int)textCenterY * 2, GLPalette.YELLOW, true);
					GL11.glPopMatrix();

					if (e != null)
					{
						GL11.glPushMatrix();

						this.lastTarget = e;

						if (e instanceof VehicleAirBase)
							((VehicleAirBase)e).setTargetLock(true);

						if (e instanceof VehicXWing)
							VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0012f * scale);
						else if (e instanceof VehicTIE)
							VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.00085f * scale);
						else if (e instanceof VehicTIEInterceptor)
							VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.00085f * scale);
						else if (e instanceof VehicAWing)
							VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GLPalette.ANALOG_GREEN, 0.0009f * scale);

						GL11.glPopMatrix();
					}
					else if (this.lastTarget != null)
					{
						if (this.lastTarget instanceof VehicleAirBase)
							((VehicleAirBase)this.lastTarget).setTargetLock(true);
						this.lastTarget = null;
					}
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEAdvanced)
				{
					VehicleAirBase tie = (VehicleAirBase)StarWarsMod.mc.thePlayer.ridingEntity;

					float centerX = event.resolution.getScaledWidth() / 2f;
					float centerY = event.resolution.getScaledHeight() / 2f;

					float radarCenterX = event.resolution.getScaledWidth() * (107f / 216F);
					float radarCenterY = event.resolution.getScaledHeight() * (131f / 144F);

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					float entiCenterX = event.resolution.getScaledWidth() * (97 / 216F);
					float entiCenterY = event.resolution.getScaledHeight() * (102 / 144F);

					float entiCenterMaxX = event.resolution.getScaledWidth() * (118 / 216F);
					float entiCenterMaxY = event.resolution.getScaledHeight() * (117 / 144F);

					float arbiCenterX = event.resolution.getScaledWidth() * (85 / 216F);
					float arbiCenterY = event.resolution.getScaledHeight() * (102 / 144F);

					float arbiCenterMaxX = event.resolution.getScaledWidth() * (91 / 216F);
					float arbiCenterMaxY = event.resolution.getScaledHeight() * (126 / 144F);

					float healX = event.resolution.getScaledWidth() * (66 / 216F);
					float healMaxX = event.resolution.getScaledWidth() * (78.5f / 216F);

					float healY = event.resolution.getScaledHeight() * (111 / 144F);
					float heal2Y = event.resolution.getScaledHeight() * (116 / 144F);
					float heal3Y = event.resolution.getScaledHeight() * (121 / 144F);
					float heal4Y = event.resolution.getScaledHeight() * (126 / 144F);
					float heal5Y = event.resolution.getScaledHeight() * (131.5f / 144F);
					float healMaxY = event.resolution.getScaledHeight() * (4 / 144F);

					ClientEventHandler.pgui.renderOverlay(Resources.tieBackOverlay);

					ClientEventHandler.pgui.renderOverlay(Resources.tiePitch, 0, (int)((1 - tie.move / tie.moveModifier) * 37));

					for (Entity p : tie.nearby)
					{
						if (p instanceof VehicXWing || p instanceof VehicAWing)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
						if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, GLPalette.ANALOG_GREEN);
						if (p instanceof EntityPlayer)
							ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
					}

					updateFiring();

					ClientEventHandler.pgui.renderOverlay(ClientEventHandler.pgui.planetTextureFromDim(tie.dimension), 0, 0);

					if (tie.getHealth() >= 20)
						ClientEventHandler.pgui.drawRect((int)healX, (int)healY, (int)healMaxX, (int)healY + (int)healMaxY, GLPalette.GREEN_APPLE);
					if (tie.getHealth() >= 16)
						ClientEventHandler.pgui.drawRect((int)healX, (int)heal2Y, (int)healMaxX, (int)heal2Y + (int)healMaxY, GLPalette.YELLOW_GREEN);
					if (tie.getHealth() >= 8)
						ClientEventHandler.pgui.drawRect((int)healX, (int)heal3Y, (int)healMaxX, (int)heal3Y + (int)healMaxY, GLPalette.ORANGE);
					if (tie.getHealth() >= 4)
						ClientEventHandler.pgui.drawRect((int)healX, (int)heal4Y, (int)healMaxX, (int)heal4Y + (int)healMaxY, GLPalette.RED_ORANGE);
					if (tie.getHealth() >= 0)
						ClientEventHandler.pgui.drawRect((int)healX, (int)heal5Y, (int)healMaxX, (int)heal5Y + (int)healMaxY, GLPalette.RED);

					if (randomCharNextTime <= System.currentTimeMillis())
					{
						MathUtils.shuffleArray(Resources.randomCharArray);
						if (StarWarsMod.rngGeneral.nextInt(5) == 0)
							this.randomChar1 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						if (StarWarsMod.rngGeneral.nextInt(5) == 0)
							this.randomChar2 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						if (StarWarsMod.rngGeneral.nextInt(5) == 0)
							this.randomChar3 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						if (StarWarsMod.rngGeneral.nextInt(5) == 0)
							this.randomChar4 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
						randomCharNextTime = System.currentTimeMillis() + 250;
					}

					FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 12, GLPalette.ANALOG_RED, true);
					FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 4, GLPalette.ANALOG_RED, true);
					FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 4, GLPalette.ANALOG_RED, true);
					FontManager.aurebesh.drawString(this.randomChar4, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 12, GLPalette.ANALOG_RED, true);

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { tie });

					int color = GLPalette.ELECTRIC_BLUE;

					if (e != null)
						color = GLPalette.ANALOG_GREEN;

					if (tie.getTargetLock())
						color = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					/*
					 * if (tie.getTargetLock()) dist = GlPalette.ORANGE;
					 * 
					 * if (e instanceof VehicleAirBase && e.riddenByEntity
					 * instanceof EntityPlayer) {
					 * StarWarsMod.network.sendToServer(new
					 * PacketShipTargetLock(e.riddenByEntity.
					 * getCommandSenderName(), true,
					 * e.worldObj.provider.dimensionId)); this.lastTarget = e; }
					 * 
					 * if (e == null && this.lastTarget instanceof
					 * VehicleAirBase && this.lastTarget.riddenByEntity
					 * instanceof EntityPlayer) {
					 * StarWarsMod.network.sendToServer(new
					 * PacketShipTargetLock(this.lastTarget.riddenByEntity.
					 * getCommandSenderName(), false,
					 * this.lastTarget.worldObj.provider.dimensionId));
					 * this.lastTarget = e; }
					 * 
					 * if (e != null) { dist = GlPalette.ELECTRIC_LIME;
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX,
					 * centerY - 5, 3, 180, 2, dist);
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX - 5,
					 * centerY + 5, 3, 45, 2, dist);
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX + 5,
					 * centerY + 5, 3, 315, 2, dist);
					 * 
					 * ClientEventHandler.pgui.drawLine(centerX - 20, centerY -
					 * 20, centerX - 20, centerY - 10, 2, dist);
					 * ClientEventHandler.pgui.drawLine(centerX - 20, centerY -
					 * 20, centerX - 10, centerY - 20, 2, dist);
					 * 
					 * ClientEventHandler.pgui.drawLine(centerX + 20, centerY -
					 * 20, centerX + 20, centerY - 10, 2, dist);
					 * ClientEventHandler.pgui.drawLine(centerX + 20, centerY -
					 * 20, centerX + 10, centerY - 20, 2, dist);
					 * 
					 * ClientEventHandler.pgui.drawLine(centerX - 20, centerY +
					 * 20, centerX - 20, centerY + 10, 2, dist);
					 * ClientEventHandler.pgui.drawLine(centerX - 20, centerY +
					 * 20, centerX - 10, centerY + 20, 2, dist);
					 * 
					 * ClientEventHandler.pgui.drawLine(centerX + 20, centerY +
					 * 20, centerX + 20, centerY + 10, 2, dist);
					 * ClientEventHandler.pgui.drawLine(centerX + 20, centerY +
					 * 20, centerX + 10, centerY + 20, 2, dist); } else {
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX,
					 * centerY - 10, 3, 180, 2, dist);
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX - 10,
					 * centerY + 10, 3, 45, 2, dist);
					 * ClientEventHandler.pgui.drawHollowTriangle(centerX + 10,
					 * centerY + 10, 3, 315, 2, dist); }
					 */

					ClientEventHandler.pgui.renderOverlay(Resources.tieOverlay);

					ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GLPalette.ANALOG_GREEN);

					String s = e == null ? "" : TextUtils.translateAurebeshLong(e.getCommandSenderName());

					String block = s != "" && lookStringPos < lookString.length() ? "\u2588" : "";

					if (lookString != s)
					{
						lookString = s;
						lookStringPos = 0;
					}
					else if (lookStringNextTime <= System.currentTimeMillis() && lookStringPos < lookString.length())
					{
						lookStringPos++;
						lookStringNextTime = System.currentTimeMillis() + 50;
					}

					GL11.glPushMatrix();
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					FontManager.aurebesh.drawSplitString(s.substring(0, lookStringPos) + block, (int)(centerX + 22) * 2, (int)(centerY - 20) * 2, 100, color);
					GL11.glPopMatrix();

					if (e != null)
					{
						GL11.glPushMatrix();

						this.lastTarget = e;

						float scale = event.resolution.getScaledWidth() * (14 / 216f);

						if (e instanceof VehicleAirBase)
							((VehicleAirBase)e).setTargetLock(true);

						if (e instanceof VehicXWing)
							VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GLPalette.ANALOG_GREEN, 0.002f * scale);
						else if (e instanceof VehicTIE)
							VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GLPalette.ANALOG_GREEN, 0.002f * scale);
						else if (e instanceof VehicTIEInterceptor)
							VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GLPalette.ANALOG_GREEN, 0.002f * scale);
						else if (e instanceof VehicAWing)
							VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GLPalette.ANALOG_GREEN, 0.002f * scale);

						GL11.glPopMatrix();
					}
					else if (this.lastTarget != null)
					{
						if (this.lastTarget instanceof VehicleAirBase)
							((VehicleAirBase)this.lastTarget).setTargetLock(true);
						this.lastTarget = null;
					}
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSnowspeeder)
				{
					VehicSnowspeeder vehic = (VehicSnowspeeder)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					updateFiring();

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { vehic });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					if (vehic.getTargetLock())
						color = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					ClientEventHandler.pgui.renderOverlay(Resources.snowspeederOverlay);
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSkyhopper)
				{
					VehicSkyhopper vehic = (VehicSkyhopper)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					updateFiring();

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { vehic });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					if (vehic.getTargetLock())
						color = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					ClientEventHandler.pgui.renderOverlay(Resources.skyhopperOverlay);
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicATST)
				{
					VehicATST vehic = (VehicATST)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					updateFiring();

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { vehic });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					// if (vehic.getTargetLock())
					// dist = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					ClientEventHandler.pgui.renderOverlay(Resources.atstOverlay);
				}
				else if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicYWing)
				{
					VehicYWing vehic = (VehicYWing)StarWarsMod.mc.thePlayer.ridingEntity;

					event.resolution.getScaledWidth();
					event.resolution.getScaledHeight();

					updateFiring();

					Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { vehic });

					int color = GLPalette.ANALOG_GREEN;

					if (e != null)
						color = GLPalette.ANALOG_RED;

					// if (vehic.getTargetLock())
					// dist = GLPalette.ORANGE;

					if (e != null && this.lastTarget == null)
						new AnimationCrosshairClose(color).start();

					if (e == null && this.lastTarget != null)
						new AnimationCrosshairOpen(color).start();

					if (!ClientEventHandler.isCursorAnim)
						ClientEventHandler.pgui.drawFancyCursor(event, ClientEventHandler.cursorOpen ? 0 : 1, color);

					updateTargetLock(e);

					this.lastTarget = e;

					ClientEventHandler.pgui.renderOverlay(Resources.ywingOverlay);
				}
			}
			GL11.glTranslatef(-event.resolution.getScaledWidth() / 2f, -event.resolution.getScaledHeight() / 2f, 0);
			GL11.glPopMatrix();
		}

		if (StarWarsMod.mc.thePlayer.ridingEntity == null && this.lastTarget instanceof VehicleAirBase)
		{
			try
			{
				StarWarsMod.network.sendToServer(new MessageShipTargetLock((EntityPlayer)this.lastTarget.riddenByEntity, false));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			this.lastTarget = null;
		}
	}

	private void updateFiring()
	{
		if (isFiring)
		{
			blipFrame -= 0.25f;
			if (blipFrame <= 0)
			{
				blipFrame = blipMax;
				isFiring = false;
			}
		}
	}

	private void updateTargetLock(Entity e)
	{
		if (e instanceof VehicleAirBase && e.riddenByEntity instanceof EntityPlayer)
			StarWarsMod.network.sendToServer(new MessageShipTargetLock((EntityPlayer)e.riddenByEntity, true));

		if (e == null && this.lastTarget instanceof VehicleAirBase && this.lastTarget.riddenByEntity instanceof EntityPlayer)
			StarWarsMod.network.sendToServer(new MessageShipTargetLock((EntityPlayer)this.lastTarget.riddenByEntity, false));
	}
}
