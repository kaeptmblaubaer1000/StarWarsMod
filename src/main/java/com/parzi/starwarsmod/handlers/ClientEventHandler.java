package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
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
import net.minecraftforge.event.world.ChunkEvent;

import org.lwjgl.opengl.GL11;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.font.FontManager;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.minimap.MinimapStore;
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

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientEventHandler
{
	private static final ResourceLocation tieOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/tie/tie.png");
	private static final ResourceLocation tieBackOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/tie/tieBack.png");
	private static final ResourceLocation tiePitch = new ResourceLocation(StarWarsMod.MODID, "textures/gui/tie/tiePitch.png");

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

	private static final ResourceLocation earth = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/earth.png");
	private static final ResourceLocation endor = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/endor.png");
	private static final ResourceLocation hoth = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/hoth.png");
	private static final ResourceLocation kashyyyk = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/kashyyyk.png");
	private static final ResourceLocation yavin = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/yavin.png");
	private static final ResourceLocation tatooine = new ResourceLocation(StarWarsMod.MODID, "textures/gui/planets/tatooine.png");

	public static Minecraft mc = Minecraft.getMinecraft();

	public static float blipMax = 15;
	public static float blipFrame = blipMax;
	public static boolean isFiring = false;

	public static String lookString = "";
	public static int lookStringPos = 0;
	public static long lookStringNextTime = 0;

	public static char[] randomCharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!?$".toCharArray();
	public static long randomCharNextTime = 0;
	String randomChar1 = "C";
	String randomChar2 = "N";
	String randomChar3 = "D";
	String randomChar4 = "L";

	Entity lastTarget = null;

	private void drawMiniMap(Entity center, int min, int max, int size)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		for (int x = min; x < max; x++)
			for (int y = min; y < max; y++)
			{
				int bX = (int)(center.posX + x);
				int bZ = (int)(center.posZ + y);
				int color = MinimapStore.getAt(center.worldObj, bX, bZ);

				float f3 = (color >> 24 & 255) / 255.0F;
				float f = (color >> 16 & 255) / 255.0F;
				float f1 = (color >> 8 & 255) / 255.0F;
				float f2 = (color & 255) / 255.0F;
				GL11.glColor4f(f, f1, f2, f3);

				tessellator.startDrawingQuads();
				tessellator.addVertex((x - min) * size, (y - min) * size + size, 0.0D);
				tessellator.addVertex((x - min) * size + size, (y - min) * size + size, 0.0D);
				tessellator.addVertex((x - min) * size + size, (y - min) * size, 0.0D);
				tessellator.addVertex((x - min) * size, (y - min) * size, 0.0D);
				tessellator.draw();
			}
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		StarWarsMod.pgui.drawHollowTriangle((max - min) * size / 2, (max - min) * size / 2, 4, center.rotationYaw + 180, 2, GlPalette.BLACK);

		// to use:
		// GL11.glPushMatrix();
		// GL11.glColor4f(255, 255, 255, 255);
		// drawMiniMap(mc.thePlayer, -25, 25, 2);
		// GL11.glColor4f(255, 255, 255, 255);
		// GL11.glPopMatrix();
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
		if (!StarWarsMod.VERSION.equalsIgnoreCase(StarWarsMod.ONLINE_VERSION) && logInEvent.entity instanceof EntityPlayerSP)
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
		ItemStack item = StarWarsMod.playerHelper.getHeldItemStack();
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

					if (item.getItem() instanceof ItemBinocularsTatooine)
					{
						event.resolution.getScaledWidth();
						event.resolution.getScaledHeight();

						float textCenterX = event.resolution.getScaledWidth() * (578f / 900F);
						float textCenterY = event.resolution.getScaledHeight() * (355 / 380F);

						Entity e = EntityUtils.rayTrace(100, mc.thePlayer, new Entity[] {});

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

						float scale = event.resolution.getScaledWidth() * (14 / 216f);

						float blipPercent = blipFrame / blipMax;

						if (System.currentTimeMillis() / 1000 % 2 == 0)
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

						// if (xwing.getTargetLock())
						// color = GlPalette.ORANGE;

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

						StarWarsMod.pgui.renderOverlay(this.planetFromDim(xwing.dimension), -4.215f * scale, -0.455f * scale);

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

						float scale = event.resolution.getScaledWidth() * (14 / 216f);

						float blipPercent = blipFrame / blipMax;

						if (System.currentTimeMillis() / 1000 % 2 == 0)
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

						StarWarsMod.pgui.renderOverlay(this.planetFromDim(awing.dimension), -1.07f * scale, -0.055f * scale);

						Entity e = EntityUtils.rayTrace(100, mc.thePlayer, new Entity[] { awing });

						int color = GlPalette.ANALOG_GREEN;

						// if (awing.getTargetLock())
						// color = GlPalette.ORANGE;

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
								this.randomChar1 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0)
								this.randomChar2 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(4) == 0)
								this.randomChar3 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							randomCharNextTime = System.currentTimeMillis() + 250;
						}

						GL11.glPushMatrix();
						GL11.glScalef(0.6f, 0.6f, 0.6f);
						FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) - 9, GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f), GlPalette.YELLOW, true);
						FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f * 1 / 0.6f), (int)((arbiCenterY + arbiCenterMaxY) / 2f * 1 / 0.6f) + 9, GlPalette.YELLOW, true);
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

							this.lastTarget = e;

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
						else if (this.lastTarget != null)
						{
							if (this.lastTarget instanceof VehicleAirBase)
								((VehicleAirBase)this.lastTarget).setTargetLock(true);
							this.lastTarget = null;
						}
					}
					if (mc.thePlayer.ridingEntity instanceof VehicTIE || mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor)
					{
						VehicleAirBase tie = (VehicleAirBase)mc.thePlayer.ridingEntity;

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

						StarWarsMod.pgui.renderOverlay(tieBackOverlay);

						StarWarsMod.pgui.renderOverlay(tiePitch, 0, (int)(tie.rotationPitch / 5) + 18);

						for (Entity p : tie.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFFB7181F);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, GlPalette.ANALOG_GREEN);
							if (p instanceof EntityPlayer)
								StarWarsMod.pgui.drawHollowCircle(radarCenterX + (int)(tie.posX - p.posX) / 5F, radarCenterY + (int)(tie.posZ - p.posZ) / 5F, 1, 5, 2, 0xFF564AFF);
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

						StarWarsMod.pgui.renderOverlay(this.planetFromDim(tie.dimension), 0, 0);

						if (tie.getHealth() >= 20)
							PGui.drawRect((int)healX, (int)healY, (int)healMaxX, (int)healY + (int)healMaxY, GlPalette.GREEN_APPLE);
						if (tie.getHealth() >= 16)
							PGui.drawRect((int)healX, (int)heal2Y, (int)healMaxX, (int)heal2Y + (int)healMaxY, GlPalette.YELLOW_GREEN);
						if (tie.getHealth() >= 8)
							PGui.drawRect((int)healX, (int)heal3Y, (int)healMaxX, (int)heal3Y + (int)healMaxY, GlPalette.ORANGE);
						if (tie.getHealth() >= 4)
							PGui.drawRect((int)healX, (int)heal4Y, (int)healMaxX, (int)heal4Y + (int)healMaxY, GlPalette.RED_ORANGE);
						if (tie.getHealth() >= 0)
							PGui.drawRect((int)healX, (int)heal5Y, (int)healMaxX, (int)heal5Y + (int)healMaxY, GlPalette.RED);

						if (randomCharNextTime <= System.currentTimeMillis())
						{
							MathUtils.shuffleArray(randomCharArray);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0)
								this.randomChar1 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0)
								this.randomChar2 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0)
								this.randomChar3 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							if (StarWarsMod.rngGeneral.nextInt(5) == 0)
								this.randomChar4 = String.valueOf(randomCharArray[StarWarsMod.rngGeneral.nextInt(randomCharArray.length)]);
							randomCharNextTime = System.currentTimeMillis() + 250;
						}

						FontManager.aurebesh.drawString(this.randomChar1, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 12, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar2, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) - 4, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar3, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 4, GlPalette.ANALOG_RED, true);
						FontManager.aurebesh.drawString(this.randomChar4, (int)((arbiCenterX + arbiCenterMaxX) / 2f), (int)((arbiCenterY + arbiCenterMaxY) / 2f) + 12, GlPalette.ANALOG_RED, true);

						Entity e = EntityUtils.rayTrace(100, mc.thePlayer, new Entity[] { tie });

						int color = GlPalette.ELECTRIC_BLUE;

						// if (tie.getTargetLock())
						// color = GlPalette.ORANGE;

						if (e != null)
						{
							color = GlPalette.ELECTRIC_LIME;
							StarWarsMod.pgui.drawHollowTriangle(centerX, centerY - 5, 3, 180, 2, color);
							StarWarsMod.pgui.drawHollowTriangle(centerX - 5, centerY + 5, 3, 45, 2, color);
							StarWarsMod.pgui.drawHollowTriangle(centerX + 5, centerY + 5, 3, 315, 2, color);

							StarWarsMod.pgui.drawLine(centerX - 20, centerY - 20, centerX - 20, centerY - 10, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 20, centerY - 20, centerX - 10, centerY - 20, 2, color);

							StarWarsMod.pgui.drawLine(centerX + 20, centerY - 20, centerX + 20, centerY - 10, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 20, centerY - 20, centerX + 10, centerY - 20, 2, color);

							StarWarsMod.pgui.drawLine(centerX - 20, centerY + 20, centerX - 20, centerY + 10, 2, color);
							StarWarsMod.pgui.drawLine(centerX - 20, centerY + 20, centerX - 10, centerY + 20, 2, color);

							StarWarsMod.pgui.drawLine(centerX + 20, centerY + 20, centerX + 20, centerY + 10, 2, color);
							StarWarsMod.pgui.drawLine(centerX + 20, centerY + 20, centerX + 10, centerY + 20, 2, color);
						}
						else
						{
							StarWarsMod.pgui.drawHollowTriangle(centerX, centerY - 10, 3, 180, 2, color);
							StarWarsMod.pgui.drawHollowTriangle(centerX - 10, centerY + 10, 3, 45, 2, color);
							StarWarsMod.pgui.drawHollowTriangle(centerX + 10, centerY + 10, 3, 315, 2, color);
						}

						StarWarsMod.pgui.renderOverlay(tieOverlay);

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
								VehicleLineDraw.drawXWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicTIE)
								VehicleLineDraw.drawTie((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicTIEInterceptor)
								VehicleLineDraw.drawTieInterceptor((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);
							else if (e instanceof VehicAWing)
								VehicleLineDraw.drawAWing((entiCenterX + entiCenterMaxX) / 2f, (entiCenterY + entiCenterMaxY) / 2f, 2, GlPalette.ANALOG_GREEN, 0.002f * scale);

							GL11.glPopMatrix();
						}
						else if (this.lastTarget != null)
						{
							if (this.lastTarget instanceof VehicleAirBase)
								((VehicleAirBase)this.lastTarget).setTargetLock(true);
							this.lastTarget = null;
						}
					}
				}
			}
		}
		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.FOOD || event.type == RenderGameOverlayEvent.ElementType.ARMOR || event.type == RenderGameOverlayEvent.ElementType.JUMPBAR))
			event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	private ResourceLocation planetFromDim(int dim)
	{
		if (dim == StarWarsMod.dimEndorId)
			return endor;
		else if (dim == StarWarsMod.dimHothId)
			return hoth;
		else if (dim == StarWarsMod.dimKashyyykId)
			return kashyyyk;
		else if (dim == StarWarsMod.dimTatooineId)
			return tatooine;
		else if (dim == StarWarsMod.dimYavin4Id)
			return yavin;

		return earth;
	}

}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */