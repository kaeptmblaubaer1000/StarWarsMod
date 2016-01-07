package com.parzi.starwarsmod.handlers;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.entities.EntityBlasterHeavyBolt;
import com.parzi.starwarsmod.entities.EntityBlasterPistolBolt;
import com.parzi.starwarsmod.entities.EntityBlasterProbeBolt;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.entities.EntitySpeederBlasterRifleBolt;
import com.parzi.starwarsmod.font.FontManager;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.jedirobes.ArmorJediRobes;
import com.parzi.starwarsmod.jedirobes.powers.PowerDefend;
import com.parzi.starwarsmod.jedirobes.powers.PowerLightning;
import com.parzi.starwarsmod.network.PacketCreateBlasterBolt;
import com.parzi.starwarsmod.network.PacketReverseEntity;
import com.parzi.starwarsmod.network.PacketShipTargetLock;
import com.parzi.starwarsmod.rendering.force.ModelJediCloak;
import com.parzi.starwarsmod.rendering.force.RenderJediDefense;
import com.parzi.starwarsmod.rendering.force.RenderSithLightning;
import com.parzi.starwarsmod.rendering.helper.PGui;
import com.parzi.starwarsmod.rendering.helper.PSWMEntityRenderer;
import com.parzi.starwarsmod.rendering.helper.VehicleLineDraw;
import com.parzi.starwarsmod.sound.PSoundBank;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.GlPalette;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.MathUtils;
import com.parzi.starwarsmod.utils.PlayerHelper;
import com.parzi.starwarsmod.utils.RenderHelper;
import com.parzi.starwarsmod.utils.Text;
import com.parzi.starwarsmod.utils.TextUtils;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

public class ClientEventHandler
{
	public static Item lastItem = null;
	public static long lastTime = 0;

	public static EntityPlayer lightningFrom = null;
	public static EntityPlayer lastLightning = null;

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

	RenderJediDefense renderJediDefense;
	RenderSithLightning renderSithLightning;
	ModelJediCloak modelCloak;
	
	public static PSoundBank soundBank;
	public static PGui pgui;
	public static PlayerHelper playerHelper;
	public static RenderHelper renderHelper;

	private void changeCameraDist(int dist)
	{
		if (StarWarsMod.mc.entityRenderer instanceof PSWMEntityRenderer)
			((PSWMEntityRenderer)StarWarsMod.mc.entityRenderer).setThirdPersonDistance(dist);
		else
		{
			try
			{
				ReflectionHelper.setPrivateValue(EntityRenderer.class, StarWarsMod.mc.entityRenderer, dist, "thirdPersonDistance");
				ReflectionHelper.setPrivateValue(EntityRenderer.class, StarWarsMod.mc.entityRenderer, dist, "thirdPersonDistanceTemp");
			}
			catch (Exception e)
			{
				Lumberjack.warn("Unable to change camera distance!");
				e.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	public void handleConstruction(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer) event.entity.getDataWatcher().addObject(StarWarsMod.lightningDatawatcherId, String.valueOf(""));
	}

	@SubscribeEvent
	public void onDrawHand(RenderHandEvent renderHandEvent)
	{
		renderHandEvent.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	@SubscribeEvent
	public void onFogify(EntityViewRenderEvent.FogDensity fogDensity)
	{
		if (fogDensity.entity.worldObj.provider.getDimensionName() == "Dagobah")
		{
			fogDensity.density = 0.075F;
			fogDensity.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onFOVCheck(FOVUpdateEvent fovUpdateEvent)
	{
		ItemStack item = fovUpdateEvent.entity.inventory.getCurrentItem();
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && StarWarsMod.mc.gameSettings.thirdPersonView == 0) fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null) if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike)
		{
			StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.SPEEDER));
			StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
		}
		else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicXWing || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicAWing)
		{
			StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.XWING));
			StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			isFiring = true;
			blipFrame = blipMax;
		}
		else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIE || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIEInterceptor)
		{
			StarWarsMod.network.sendToServer(new PacketCreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.TIE));
			StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
		}
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (logInEvent.entity instanceof EntityPlayer && !Resources.VERSION.equalsIgnoreCase(Resources.ONLINE_VERSION) && !StarWarsMod.hasShownNeedUpdate)
		{
			((EntityPlayer)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(Resources.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(Resources.VERSION, Text.COLOR_YELLOW)));
			StarWarsMod.hasShownNeedUpdate = true;
		}
	}

	@SubscribeEvent
	public void onRender(RenderLivingEvent.Pre event)
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			if (ClientEventHandler.renderHelper.isFirstPerson())
			{
				changeCameraDist(4);

				event.setCanceled(event.entity == StarWarsMod.mc.thePlayer.ridingEntity);
			}
			else
			{
				changeCameraDist(15);

				event.setCanceled(event.entity.ridingEntity instanceof VehicleAirBase);
			}
		}
		else
			changeCameraDist(4);
	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		StarWarsMod.isOverlayOnscreen = false;
		ItemStack item = ClientEventHandler.playerHelper.getHeldItemStack();
		if (ClientEventHandler.renderHelper.isFirstPerson())
		{
			if (item != null && item.getItem() instanceof ItemBinoculars && ItemBinoculars.getEnabled(item))
			{
				StarWarsMod.isOverlayOnscreen = true;
				if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
				{
					ResourceLocation guiTexture;
					if (item.getItem() instanceof ItemBinocularsTatooine)
						guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
					else
						guiTexture = new ResourceLocation(Resources.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
					ClientEventHandler.pgui.renderOverlay(guiTexture);

					if (item.getItem() instanceof ItemBinocularsTatooine)
					{
						event.resolution.getScaledWidth();
						event.resolution.getScaledHeight();

						float textCenterX = event.resolution.getScaledWidth() * (578f / 900F);
						float textCenterY = event.resolution.getScaledHeight() * (355 / 380F);

						Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[0]);

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
							lookStringNextTime = System.currentTimeMillis() + 50;
						}

						FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GlPalette.YELLOW, true);
					}
				}
			}
			if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase)
			{
				StarWarsMod.isOverlayOnscreen = true;
				if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
				{
					if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicXWing)
					{
						VehicXWing xwing = (VehicXWing)StarWarsMod.mc.thePlayer.ridingEntity;

						float centerX = event.resolution.getScaledWidth() / 2f;
						float centerY = event.resolution.getScaledHeight() / 2f;

						float radarCenterX = event.resolution.getScaledWidth() * (107 / 216F);
						float radarCenterY = event.resolution.getScaledHeight() * (119 / 144F);

						float textCenterX = event.resolution.getScaledWidth() * (79.5f / 216F);
						float textCenterY = event.resolution.getScaledHeight() * (137 / 144F);

						float entiCenterX = event.resolution.getScaledWidth() * (124 / 216F);
						float entiCenterY = event.resolution.getScaledHeight() * (107 / 144F);

						float entiCenterMaxX = event.resolution.getScaledWidth() * (138 / 216F);
						float entiCenterMaxY = event.resolution.getScaledHeight() * (131 / 144F);

						float scale = event.resolution.getScaledWidth() * (14 / 216f);

						float blipPercent = blipFrame / blipMax;

						if (System.currentTimeMillis() / 1000 % 2 == 0)
							ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlayBack1);
						else
							ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlayBack2);

						for (Entity p : xwing.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof EntityPlayer) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
						}

						if (isFiring)
						{
							blipFrame -= 0.25f;
							if (blipFrame <= 0)
							{
								blipFrame = blipMax;
								isFiring = false;
							}
						}

						Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { xwing });

						int color = GlPalette.ANALOG_GREEN;

						if (xwing.getTargetLock()) color = GlPalette.ORANGE;

						if (e instanceof VehicleAirBase && e.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(e.riddenByEntity.getCommandSenderName(), true, e.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e == null && this.lastTarget instanceof VehicleAirBase && this.lastTarget.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(this.lastTarget.riddenByEntity.getCommandSenderName(), false, this.lastTarget.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e != null)
						{
							color = GlPalette.RED;
							ClientEventHandler.pgui.drawLine(centerX - 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawHollowCircle(centerX, centerY, blipFrame * 0.8f, 10, 2, color);
						}
						else
						{
							ClientEventHandler.pgui.drawLine(centerX - 8 * blipPercent, centerY - 8 * blipPercent, centerX - 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 8 * blipPercent, centerY - 8 * blipPercent, centerX + 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 8 * blipPercent, centerY + 8 * blipPercent, centerX + 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 8 * blipPercent, centerY + 8 * blipPercent, centerX - 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawHollowCircle(centerX, centerY, blipFrame, 10, 2, color);
						}

						ClientEventHandler.pgui.renderOverlay(Resources.xwingOverlay);

						ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GlPalette.ANALOG_GREEN);

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

						ClientEventHandler.pgui.renderOverlay(this.pgui.planetTextureFromDim(xwing.dimension), -4.215f * scale, -0.455f * scale);

						FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GlPalette.YELLOW, true);

						if (e != null)
						{
							GL11.glPushMatrix();

							if (e instanceof VehicXWing)
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicAWing) VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);

							GL11.glPopMatrix();
						}
					}
					if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicAWing)
					{
						VehicAWing awing = (VehicAWing)StarWarsMod.mc.thePlayer.ridingEntity;

						float centerX = event.resolution.getScaledWidth() / 2f;
						float centerY = event.resolution.getScaledHeight() / 2f;

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

						float blipPercent = blipFrame / blipMax;

						if (System.currentTimeMillis() / 1000 % 2 == 0)
							ClientEventHandler.pgui.renderOverlay(Resources.awingBack);
						else
							ClientEventHandler.pgui.renderOverlay(Resources.awingBack2);

						for (Entity p : awing.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof EntityPlayer) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
						}

						if (isFiring)
						{
							blipFrame -= 0.25f;
							if (blipFrame <= 0)
							{
								blipFrame = blipMax;
								isFiring = false;
							}
						}

						ClientEventHandler.pgui.renderOverlay(this.pgui.planetTextureFromDim(awing.dimension), -1.07f * scale, -0.055f * scale);

						Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { awing });

						int color = GlPalette.ANALOG_GREEN;

						if (awing.getTargetLock()) color = GlPalette.ORANGE;

						if (e instanceof VehicleAirBase && e.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(e.riddenByEntity.getCommandSenderName(), true, e.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e == null && this.lastTarget instanceof VehicleAirBase && this.lastTarget.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(this.lastTarget.riddenByEntity.getCommandSenderName(), false, this.lastTarget.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e != null)
						{
							color = GlPalette.RED;
							ClientEventHandler.pgui.drawLine(centerX - 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							ClientEventHandler.pgui.drawHollowCircle(centerX, centerY, blipFrame * 0.8f, 10, 2, color);
						}
						else
						{
							ClientEventHandler.pgui.drawLine(centerX - 8 * blipPercent, centerY - 8 * blipPercent, centerX - 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 8 * blipPercent, centerY - 8 * blipPercent, centerX + 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 8 * blipPercent, centerY + 8 * blipPercent, centerX + 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 8 * blipPercent, centerY + 8 * blipPercent, centerX - 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							ClientEventHandler.pgui.drawHollowCircle(centerX, centerY, blipFrame, 10, 2, color);
						}

						if (randomCharNextTime <= System.currentTimeMillis())
						{
							MathUtils.shuffleArray(Resources.randomCharArray);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0) this.randomChar1 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0) this.randomChar2 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0) this.randomChar3 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							randomCharNextTime = System.currentTimeMillis() + 250;
						}

						GL11.glPushMatrix();
						GL11.glScalef(0.6f, 0.6f, 0.6f);
						FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) - 9, GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f), GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) + 9, GlPalette.YELLOW, true);
						GL11.glPopMatrix();

						ClientEventHandler.pgui.renderOverlay(Resources.awingPitch1, 0, (int)(awing.rotationPitch / 15) + 8);
						ClientEventHandler.pgui.renderOverlay(Resources.awingPitch2, 0, -Math.abs((int)(awing.rotationYaw / 180 * 8)) + 16);

						ClientEventHandler.pgui.renderOverlay(Resources.awingOverlay);

						ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GlPalette.ANALOG_GREEN);

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
						FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX * 2, (int)textCenterY * 2, GlPalette.YELLOW, true);
						GL11.glPopMatrix();

						if (e != null)
						{
							GL11.glPushMatrix();

							this.lastTarget = e;

							if (e instanceof VehicleAirBase) ((VehicleAirBase)e).setTargetLock(true);

							if (e instanceof VehicXWing)
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.00085f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.00085f * scale);
							else if (e instanceof VehicAWing) VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0009f * scale);

							GL11.glPopMatrix();
						}
						else if (this.lastTarget != null)
						{
							if (this.lastTarget instanceof VehicleAirBase) ((VehicleAirBase)this.lastTarget).setTargetLock(true);
							this.lastTarget = null;
						}
					}
					if (StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIE || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
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

						ClientEventHandler.pgui.renderOverlay(Resources.tiePitch, 0, (int)(tie.rotationPitch / 5) + 18);

						for (Entity p : tie.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof EntityPlayer) ClientEventHandler.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
						}

						if (isFiring)
						{
							blipFrame -= 0.25f;
							if (blipFrame <= 0)
							{
								blipFrame = blipMax;
								isFiring = false;
							}
						}

						ClientEventHandler.pgui.renderOverlay(this.pgui.planetTextureFromDim(tie.dimension), 0, 0);

						if (tie.getHealth() >= 20) ClientEventHandler.pgui.drawRect((int)healX, (int)healY, (int)healMaxX, (int)healY + (int)healMaxY, GlPalette.GREEN_APPLE);
						if (tie.getHealth() >= 16) ClientEventHandler.pgui.drawRect((int)healX, (int)heal2Y, (int)healMaxX, (int)heal2Y + (int)healMaxY, GlPalette.YELLOW_GREEN);
						if (tie.getHealth() >= 8) ClientEventHandler.pgui.drawRect((int)healX, (int)heal3Y, (int)healMaxX, (int)heal3Y + (int)healMaxY, GlPalette.ORANGE);
						if (tie.getHealth() >= 4) ClientEventHandler.pgui.drawRect((int)healX, (int)heal4Y, (int)healMaxX, (int)heal4Y + (int)healMaxY, GlPalette.RED_ORANGE);
						if (tie.getHealth() >= 0) ClientEventHandler.pgui.drawRect((int)healX, (int)heal5Y, (int)healMaxX, (int)heal5Y + (int)healMaxY, GlPalette.RED);

						if (randomCharNextTime <= System.currentTimeMillis())
						{
							MathUtils.shuffleArray(Resources.randomCharArray);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0) this.randomChar1 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0) this.randomChar2 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0) this.randomChar3 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0) this.randomChar4 = String.valueOf(Resources.randomCharArray[StarWarsMod.rngGeneral.nextInt(Resources.randomCharArray.length)]);
							randomCharNextTime = System.currentTimeMillis() + 250;
						}

						FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 12, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 4, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 4, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar4, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 12, GlPalette.ANALOG_RED, true);

						Entity e = EntityUtils.rayTrace(100, StarWarsMod.mc.thePlayer, new Entity[] { tie });

						int color = GlPalette.ELECTRIC_BLUE;

						if (tie.getTargetLock()) color = GlPalette.ORANGE;

						if (e instanceof VehicleAirBase && e.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(e.riddenByEntity.getCommandSenderName(), true, e.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e == null && this.lastTarget instanceof VehicleAirBase && this.lastTarget.riddenByEntity instanceof EntityPlayer)
						{
							StarWarsMod.network.sendToServer(new PacketShipTargetLock(this.lastTarget.riddenByEntity.getCommandSenderName(), false, this.lastTarget.worldObj.provider.dimensionId));
							this.lastTarget = e;
						}

						if (e != null)
						{
							color = GlPalette.ELECTRIC_LIME;
							ClientEventHandler.pgui.drawHollowTriangle(centerX, centerY - 5, 3, 180, 2, color);
							ClientEventHandler.pgui.drawHollowTriangle(centerX - 5, centerY + 5, 3, 45, 2, color);
							ClientEventHandler.pgui.drawHollowTriangle(centerX + 5, centerY + 5, 3, 315, 2, color);

							ClientEventHandler.pgui.drawLine(centerX - 20, centerY - 20, centerX - 20, centerY - 10, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 20, centerY - 20, centerX - 10, centerY - 20, 2, color);

							ClientEventHandler.pgui.drawLine(centerX + 20, centerY - 20, centerX + 20, centerY - 10, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 20, centerY - 20, centerX + 10, centerY - 20, 2, color);

							ClientEventHandler.pgui.drawLine(centerX - 20, centerY + 20, centerX - 20, centerY + 10, 2, color);
							ClientEventHandler.pgui.drawLine(centerX - 20, centerY + 20, centerX - 10, centerY + 20, 2, color);

							ClientEventHandler.pgui.drawLine(centerX + 20, centerY + 20, centerX + 20, centerY + 10, 2, color);
							ClientEventHandler.pgui.drawLine(centerX + 20, centerY + 20, centerX + 10, centerY + 20, 2, color);
						}
						else
						{
							ClientEventHandler.pgui.drawHollowTriangle(centerX, centerY - 10, 3, 180, 2, color);
							ClientEventHandler.pgui.drawHollowTriangle(centerX - 10, centerY + 10, 3, 45, 2, color);
							ClientEventHandler.pgui.drawHollowTriangle(centerX + 10, centerY + 10, 3, 315, 2, color);
						}

						ClientEventHandler.pgui.renderOverlay(Resources.tieOverlay);

						ClientEventHandler.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, StarWarsMod.mc.thePlayer.rotationYaw, 2, GlPalette.ANALOG_GREEN);

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

							if (e instanceof VehicleAirBase) ((VehicleAirBase)e).setTargetLock(true);

							if (e instanceof VehicXWing)
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicAWing) VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);

							GL11.glPopMatrix();
						}
						else if (this.lastTarget != null)
						{
							if (this.lastTarget instanceof VehicleAirBase) ((VehicleAirBase)this.lastTarget).setTargetLock(true);
							this.lastTarget = null;
						}
					}
				}
			}
		}
		if (StarWarsMod.mc.thePlayer.ridingEntity == null && this.lastTarget instanceof VehicleAirBase)
		{
			try
			{
				StarWarsMod.network.sendToServer(new PacketShipTargetLock(this.lastTarget.riddenByEntity.getCommandSenderName(), false, this.lastTarget.worldObj.provider.dimensionId));
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			this.lastTarget = null;
		}

		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.FOOD || event.type == RenderGameOverlayEvent.ElementType.ARMOR || event.type == RenderGameOverlayEvent.ElementType.JUMPBAR)) event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	@SubscribeEvent
	public void onXpPickup(PlayerPickupXpEvent event)
	{
		if (event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes) event.entityPlayer.inventory.armorInventory[2] = ArmorJediRobes.addLevels(event.entityPlayer.inventory.armorItemInSlot(2), 1);
	}

	@SubscribeEvent
	public void renderWorldLastEvent(RenderWorldLastEvent event)
	{
		if (ForceUtils.activePower != null && ForceUtils.activePower.name.equals("lightning") && ForceUtils.isUsingDuration)
		{
			PowerLightning power = (PowerLightning)ForceUtils.activePower;

			if (power.duration >= power.getDuration()) return;

			Entity e = EntityUtils.rayTrace(power.getRange(), StarWarsMod.mc.thePlayer, new Entity[0]);
			power.setTarget(e);

			if (e != null)
			{
				Random r = new Random(e.ticksExisted * 4);
				float posX2 = (float)e.posX;
				float posY2 = (float)e.posY + 2;
				float posZ2 = (float)e.posZ;
				for (int i = 0; i < 4; i++)
				{
					posX2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxX - e.posX) - (e.boundingBox.maxX - e.posX) / 2;
					posY2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxY - e.posY) - (e.boundingBox.maxY - e.posY) / 2;
					posZ2 += (r.nextFloat() - 0.5f) * (e.boundingBox.maxZ - e.posZ) - (e.boundingBox.maxZ - e.posZ) / 2;

					renderSithLightning.render(r, (float)StarWarsMod.mc.thePlayer.posX - 0.5f, (float)StarWarsMod.mc.thePlayer.posY - 1, (float)StarWarsMod.mc.thePlayer.posZ - 0.5f, posX2, posY2, posZ2, 8, 0.15f);
				}
			}
		}

		renderJediDefense.onWorldRender(event);

		renderSithLightning.onWorldRender(event);
	}

	@SubscribeEvent
	public void onRenderPlayerSpecial(RenderPlayerEvent.Specials.Post event)
	{
		boolean cape = event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes;

		float p_77029_2_ = event.partialRenderTick;

		if (cape)
		{
			GL11.glPushMatrix();
			GL11.glTranslatef(0.0F, 0.0F, 0.125F);
			double d3 = event.entityPlayer.field_71091_bM + (event.entityPlayer.field_71094_bP - event.entityPlayer.field_71091_bM) * (double)p_77029_2_ - (event.entityPlayer.prevPosX + (event.entityPlayer.posX - event.entityPlayer.prevPosX) * (double)p_77029_2_);
			double d4 = event.entityPlayer.field_71096_bN + (event.entityPlayer.field_71095_bQ - event.entityPlayer.field_71096_bN) * (double)p_77029_2_ - (event.entityPlayer.prevPosY + (event.entityPlayer.posY - event.entityPlayer.prevPosY) * (double)p_77029_2_);
			double d0 = event.entityPlayer.field_71097_bO + (event.entityPlayer.field_71085_bR - event.entityPlayer.field_71097_bO) * (double)p_77029_2_ - (event.entityPlayer.prevPosZ + (event.entityPlayer.posZ - event.entityPlayer.prevPosZ) * (double)p_77029_2_);
			float f4 = event.entityPlayer.prevRenderYawOffset + (event.entityPlayer.renderYawOffset - event.entityPlayer.prevRenderYawOffset) * p_77029_2_;
			double d1 = (double)MathHelper.sin(f4 * (float)Math.PI / 180.0F);
			double d2 = (double)(-MathHelper.cos(f4 * (float)Math.PI / 180.0F));
			float f5 = (float)d4 * 10.0F;

			if (f5 < -6.0F)
			{
				f5 = -6.0F;
			}

			if (f5 > 32.0F)
			{
				f5 = 32.0F;
			}

			float f6 = (float)(d3 * d1 + d0 * d2) * 100.0F;
			float f7 = (float)(d3 * d2 - d0 * d1) * 100.0F;

			if (f6 < 0.0F)
			{
				f6 = 0.0F;
			}

			float f8 = event.entityPlayer.prevCameraYaw + (event.entityPlayer.cameraYaw - event.entityPlayer.prevCameraYaw) * p_77029_2_;
			f5 += MathHelper.sin((event.entityPlayer.prevDistanceWalkedModified + (event.entityPlayer.distanceWalkedModified - event.entityPlayer.prevDistanceWalkedModified) * p_77029_2_) * 6.0F) * 32.0F * f8;

			if (event.entityPlayer.isSneaking())
			{
				f5 += 25.0F;
			}

			GL11.glRotatef(6.0F + f6 / 2.0F + f5, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(f7 / 2.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-f7 / 2.0F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(1, 1, 1);
			StarWarsMod.mc.getTextureManager().bindTexture(Resources.capeTexture);
			//rp.modelBipedMain.renderCloak(0.0625F);
			modelCloak.renderCape(0.0625F);
			GL11.glPopMatrix();
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		if (ForceUtils.activePower != null && event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entityLiving;

			if (ForceUtils.activePower.name.equals("defend") && ((PowerDefend)ForceUtils.activePower).isRunning)
			{
				PowerDefend power = (PowerDefend)ForceUtils.activePower;
				if (power.health > event.ammount)
				{
					power.health -= event.ammount;
					event.setCanceled(true);
				}
				else
				{
					event.ammount -= power.health;
					power.health = 0;
					power.isRunning = false;
					power.recharge = power.rechargeTime;
					ForceUtils.coolingPowers.add(power);
				}
			}

			if (ForceUtils.activePower.name.equals("deflect") && ForceUtils.isUsingDuration)
			{
				Entity entityObj = event.source.getEntity();
				if (entityObj instanceof EntityArrow || entityObj instanceof EntityBlasterRifleBolt || entityObj instanceof EntityBlasterHeavyBolt || entityObj instanceof EntityBlasterPistolBolt || entityObj instanceof EntityBlasterProbeBolt || entityObj instanceof EntitySpeederBlasterRifleBolt)
				{
					StarWarsMod.network.sendToServer(new PacketReverseEntity(entityObj.getEntityId(), entityObj.dimension));
					event.ammount = 0;
				}
			}
		}
	}

	public void init()
	{
		this.renderJediDefense = new RenderJediDefense();
		this.renderSithLightning = new RenderSithLightning();
		this.modelCloak = new ModelJediCloak();
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */