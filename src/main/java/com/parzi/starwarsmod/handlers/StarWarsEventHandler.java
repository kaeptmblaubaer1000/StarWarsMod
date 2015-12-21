package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.font.FontManager;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.network.CreateBlasterBolt;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.rendering.helper.PGui;
import com.parzi.starwarsmod.rendering.helper.PSWMEntityRenderer;
import com.parzi.starwarsmod.rendering.helper.VehicleLineDraw;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.utils.GlPalette;
import com.parzi.starwarsmod.utils.MathUtils;
import com.parzi.starwarsmod.utils.Text;
import com.parzi.starwarsmod.utils.TextUtils;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;
import com.parzi.starwarsmod.vehicles.VehicleLandBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

public class StarWarsEventHandler
{
	private static final ResourceLocation tieOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/tie/tie.png");

	private static final ResourceLocation xwingOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing/xwing.png");
	private static final ResourceLocation xwingOverlayPitch = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing/pitchGagueConsole.png");
	private static final ResourceLocation xwingOverlayBack1 = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing/xwingBack1.png");
	private static final ResourceLocation xwingOverlayBack2 = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing/xwingBack2.png");
	private static final ResourceLocation xwingOverlayBlip = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing/xwingBlip.png");

	private static final ResourceLocation awingOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing/awing.png");
	private static final ResourceLocation awingBack = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing/awingBack.png");
	private static final ResourceLocation awingBack2 = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing/awingBack2.png");
	private static final ResourceLocation awingPitch1 = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing/pitch1.png");
	private static final ResourceLocation awingPitch2 = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing/pitch2.png");

	public static Minecraft mc = Minecraft.getMinecraft();

	public static float blipMax = 15;
	public static float blipFrame = blipMax;
	public static boolean isFiring = false;

	public static String lookString = "";
	public static int lookStringPos = 0;
	public static long lookStringNextTime = 0;

	String randomChar1 = "C";
	String randomChar2 = "L";
	String randomChar3 = "D";
	public static char[] randomCharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!?$".toCharArray();
	public static long randomCharNextTime = 0;

	Entity lastTarget = null;

	private void drawMiniMap(Entity center, int min, int max, int pxSize)
	{
		for (int x = min; x < max; x++)
			for (int y = min; y < max; y++)
			{

				int bX = (int)(center.posX + x);
				int bZ = (int)(center.posZ + y);
				int bY = center.worldObj.getHeightValue(bX, bZ);

				/*
				 * double disx = mc.thePlayer.posX - bX; double disz =
				 * mc.thePlayer.posZ - bZ;
				 *
				 * if ((disx - 0.5) * (disx - 0.5) + (disz - 0.5) * (disz - 0.5)
				 * > (max) * (max)) { continue; }
				 */

				PGui.drawRect(x * pxSize - min * pxSize, y * pxSize - min * pxSize, x * pxSize + pxSize - min * pxSize, y * pxSize + pxSize - min * pxSize, Math.min(255, bY), Math.min(255, bY), Math.min(255, bY), 255);
			}
	}

	@SubscribeEvent
	public void onBlockBroken(BlockEvent.BreakEvent breakEvent)
	{
		if (breakEvent.getPlayer().inventory.armorInventory[2] != null && (breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && Arrays.asList(ArmorJediRobes.earthMatter).contains(breakEvent.block) && breakEvent.world.rand.nextInt(ArmorJediRobes.chanceElement / 10) == 0)
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", breakEvent.getPlayer().inventory.armorInventory[2].stackTagCompound.getInteger("earth") + 1, breakEvent.getPlayer().dimension, breakEvent.getPlayer().getCommandSenderName()));
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
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && mc.gameSettings.thirdPersonView == 0)
			fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onMobHit(AttackEntityEvent attackEntityEvent)
	{
		if (attackEntityEvent.entityPlayer.inventory.armorInventory[2] != null && (attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && attackEntityEvent.entity.worldObj.rand.nextInt(ArmorJediRobes.chanceElement / 50) == 0)
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("animals", attackEntityEvent.entityPlayer.inventory.armorInventory[2].stackTagCompound.getInteger("animals") + 1, attackEntityEvent.entityPlayer.dimension, attackEntityEvent.entityPlayer.getCommandSenderName()));
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
			if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike)
			{
				StarWarsMod.network.sendToServer(new CreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.SPEEDER));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicXWing || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicAWing)
			{
				StarWarsMod.network.sendToServer(new CreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.XWING));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
				isFiring = true;
				blipFrame = blipMax;
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIE || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new CreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.TIE));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (StarWarsMod.VERSION != StarWarsMod.ONLINE_VERSION && logInEvent.entity instanceof EntityPlayerSP)
			((EntityPlayerSP)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(StarWarsMod.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(StarWarsMod.VERSION, Text.COLOR_YELLOW)));

		if (logInEvent.entity instanceof EntityPlayer)
			if (logInEvent.world.provider.dimensionId == -100)
				logInEvent.setCanceled(true);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRender(RenderLivingEvent.Pre event)
	{
		if (mc.thePlayer != null && mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			if (StarWarsMod.renderHelper.isFirstPerson())
			{
				// ReflectionHelper.setPrivateValue(EntityRenderer.class,
				// mc.entityRenderer, 4, "thirdPersonDistance");
				((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(4);

				event.setCanceled(event.entity == mc.thePlayer.ridingEntity);
			}
			else
			{
				// ReflectionHelper.setPrivateValue(EntityRenderer.class,
				// mc.entityRenderer, 15, "thirdPersonDistance");
				((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(15);

				event.setCanceled(event.entity.ridingEntity instanceof VehicleAirBase);
			}
		}
		else
			// ReflectionHelper.setPrivateValue(EntityRenderer.class,
			// mc.entityRenderer, 4, "thirdPersonDistance");
			((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(4);
	}

	@SubscribeEvent
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		StarWarsMod.isOverlayOnscreen = false;
		ItemStack item = StarWarsMod.playerHelper.getHeldItem();
		if (StarWarsMod.renderHelper.isFirstPerson())
		{
			if (item != null && item.getItem() instanceof ItemBinoculars && ItemBinoculars.getEnabled(item))
			{
				StarWarsMod.isOverlayOnscreen = true;
				if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
				{
					ResourceLocation guiTexture;
					if (item.getItem() instanceof ItemBinocularsTatooine)
						guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
					else
						guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
					StarWarsMod.pgui.renderOverlay(guiTexture);
				}
			}
			if (mc.thePlayer.ridingEntity instanceof VehicleAirBase)
			{
				StarWarsMod.isOverlayOnscreen = true;
				if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR)
				{
					if (mc.thePlayer.ridingEntity instanceof VehicXWing)
					{
						VehicXWing xwing = (VehicXWing)mc.thePlayer.ridingEntity;

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

						float blipPercent = blipFrame / blipMax;

						if ((System.currentTimeMillis() / 1000) % 2 == 0)
							StarWarsMod.pgui.renderOverlay(xwingOverlayBack1);
						else
							StarWarsMod.pgui.renderOverlay(xwingOverlayBack2);

						for (Entity p : xwing.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof EntityPlayer)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(xwing.posX - p.posX) / 5F, radarCenterY + (int)(xwing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
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

						Entity e = EntityUtils.rayTrace(100, mc.thePlayer, new Entity[] { xwing });

						int color = GlPalette.ANALOG_GREEN;

						if (xwing.getTargetLock())
							color = GlPalette.ORANGE;

						if (e != null)
						{
							color = GlPalette.RED;
							StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawHollowCircle(centerX, centerY, blipFrame * 0.8f, 10, 2, color);
						}
						else
						{
							StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY - 8 * blipPercent, centerX - 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY - 8 * blipPercent, centerX + 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY + 8 * blipPercent, centerX + 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY + 8 * blipPercent, centerX - 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawHollowCircle(centerX, centerY, blipFrame, 10, 2, color);
						}

						StarWarsMod.pgui.renderOverlay(xwingOverlay);

						StarWarsMod.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, mc.thePlayer.rotationYaw, 2, GlPalette.ANALOG_GREEN);

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

						FontManager.aurebesh.drawString(s.substring(0, lookStringPos) + block, (int)textCenterX, (int)textCenterY, GlPalette.YELLOW, true);

						if (e != null)
						{
							GL11.glPushMatrix();

							float scale = event.resolution.getScaledWidth() * (14 / 216f);

							if (e instanceof VehicXWing)
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicAWing)
								VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);

							GL11.glPopMatrix();
						}
					}
					if (mc.thePlayer.ridingEntity instanceof VehicAWing)
					{
						VehicAWing awing = (VehicAWing)mc.thePlayer.ridingEntity;

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

						float blipPercent = blipFrame / blipMax;

						if ((System.currentTimeMillis() / 1000) % 2 == 0)
							StarWarsMod.pgui.renderOverlay(awingBack);
						else
							StarWarsMod.pgui.renderOverlay(awingBack2);

						for (Entity p : awing.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof EntityPlayer)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(awing.posX - p.posX) / 5F, radarCenterY + (int)(awing.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
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

						Entity e = EntityUtils.rayTrace(100, mc.thePlayer, new Entity[] { awing });

						int color = GlPalette.ANALOG_GREEN;
						
						if (awing.getTargetLock())
							color = GlPalette.ORANGE;

						if (e != null)
						{
							color = GlPalette.RED;
							StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 6 * blipPercent, centerY - 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent, centerY + 6 * blipPercent, centerX, centerY, 2, color);
							StarWarsMod.pgui.drawHollowCircle(centerX, centerY, blipFrame * 0.8f, 10, 2, color);
						}
						else
						{
							StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY - 8 * blipPercent, centerX - 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY - 8 * blipPercent, centerX + 2 * blipPercent, centerY - 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY + 8 * blipPercent, centerX + 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY + 8 * blipPercent, centerX - 2 * blipPercent, centerY + 2 * blipPercent, 2, color);
							StarWarsMod.pgui.drawHollowCircle(centerX, centerY, blipFrame, 10, 2, color);
						}

						if (randomCharNextTime <= System.currentTimeMillis())
						{
							MathUtils.shuffleArray(randomCharArray);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0)
								randomChar1 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0)
								randomChar2 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0)
								randomChar3 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							randomCharNextTime = System.currentTimeMillis() + 250;
						}

						GL11.glPushMatrix();
						GL11.glScalef(0.6f, 0.6f, 0.6f);
						FontManager.aurebesh.drawString(randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1/0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1/0.6f) - 9, GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1/0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1/0.6f), GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1/0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1/0.6f) + 9, GlPalette.YELLOW, true);
						GL11.glPopMatrix();

						StarWarsMod.pgui.renderOverlay(awingPitch1, 0, (int)(awing.rotationPitch / 15) + 8);
						StarWarsMod.pgui.renderOverlay(awingPitch2, 0, -Math.abs((int)(awing.rotationYaw / 180 * 8)) + 16);

						StarWarsMod.pgui.renderOverlay(awingOverlay);

						StarWarsMod.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, mc.thePlayer.rotationYaw, 2, GlPalette.ANALOG_GREEN);

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

							lastTarget = e;

							float scale = event.resolution.getScaledWidth() * (14 / 216f);

							if (e instanceof VehicleAirBase)
								((VehicleAirBase)e).setTargetLock(true);

							if (e instanceof VehicXWing)
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0012f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.00085f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.00085f * scale);
							else if (e instanceof VehicAWing)
								VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 1, GlPalette.ANALOG_GREEN, 0.0009f * scale);

							GL11.glPopMatrix();
						}
						else if (lastTarget != null)
						{
							if (lastTarget instanceof VehicleAirBase)
								((VehicleAirBase)lastTarget).setTargetLock(true);
							lastTarget = null;
						}
					}
					if (mc.thePlayer.ridingEntity instanceof VehicTIE || mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
						StarWarsMod.pgui.renderOverlay(tieOverlay);
				}
			}
		}
		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE))
			event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */