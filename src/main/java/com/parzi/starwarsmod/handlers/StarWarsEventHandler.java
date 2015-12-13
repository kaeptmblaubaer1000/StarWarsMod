package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.network.CreateBlasterBolt;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.rendering.helper.PSWMEntityRenderer;
import com.parzi.starwarsmod.utils.BlasterBoltType;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.Text;
import com.parzi.starwarsmod.utils.TextUtils;
import com.parzi.starwarsmod.vehicles.VehicAWing;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicTIE;
import com.parzi.starwarsmod.vehicles.VehicTIEInterceptor;
import com.parzi.starwarsmod.vehicles.VehicXWing;
import com.parzi.starwarsmod.vehicles.VehicleAirBase;
import com.parzi.starwarsmod.vehicles.VehicleBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarWarsEventHandler
{
	private static final ResourceLocation awingOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/awing.png");
	private static final ResourceLocation tieOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/tie.png");

	private static final ResourceLocation xwingOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing.png");
	private static final ResourceLocation xwingOverlayPitch = new ResourceLocation(StarWarsMod.MODID, "textures/gui/pitchGagueConsole.png");
	private static final ResourceLocation xwingOverlayBack = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwingBack.png");
	private static final ResourceLocation xwingOverlayBlip = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwingBlip.png");

	public static Minecraft mc = Minecraft.getMinecraft();

	public static int radarColor = StarWarsMod.pgui.getRGBA(0, 208, 12, 255);

	public static float blipMax = 15;
	public static float blipFrame = blipMax;
	public static boolean isFiring = false;

	@SubscribeEvent
	public void onBlockBroken(BlockEvent.BreakEvent breakEvent)
	{
		if (breakEvent.getPlayer().inventory.armorInventory[2] != null && (breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && Arrays.asList(ArmorJediRobes.earthMatter).contains(breakEvent.block) && breakEvent.world.rand.nextInt(ArmorJediRobes.chanceElement / 10) == 0) StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", breakEvent.getPlayer().inventory.armorInventory[2].stackTagCompound.getInteger("earth") + 1, breakEvent.getPlayer().dimension, breakEvent.getPlayer().getCommandSenderName()));
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
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && mc.gameSettings.thirdPersonView == 0) fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onMobHit(AttackEntityEvent attackEntityEvent)
	{
		if (attackEntityEvent.entityPlayer.inventory.armorInventory[2] != null && (attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && attackEntityEvent.entity.worldObj.rand.nextInt(ArmorJediRobes.chanceElement / 50) == 0) StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("animals", attackEntityEvent.entityPlayer.inventory.armorInventory[2].stackTagCompound.getInteger("animals") + 1, attackEntityEvent.entityPlayer.dimension, attackEntityEvent.entityPlayer.getCommandSenderName()));
	}

	@SubscribeEvent
	public void onMouseMoved(MouseEvent mouseEvent)
	{
		if (mc.thePlayer.ridingEntity instanceof VehicleBase)
		{
			int limit = 8;

			VehicleBase vehicle = (VehicleBase)mc.thePlayer.ridingEntity;

			int n = mouseEvent.dx;
			if (n > limit) n = limit;
			if (n < -limit) n = -limit;

			vehicle.mouseDxOverAFewTicks[vehicle.mouseDxOverAFewTicks.length - 1] = n;
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
		{
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
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (StarWarsMod.VERSION != StarWarsMod.ONLINE_VERSION && logInEvent.entity instanceof EntityPlayerSP) ((EntityPlayerSP)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(StarWarsMod.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(StarWarsMod.VERSION, Text.COLOR_YELLOW)));

		if (logInEvent.entity instanceof EntityPlayer) if (logInEvent.world.provider.dimensionId == -100) logInEvent.setCanceled(true);
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
	public void onRenderBar(RenderGameOverlayEvent event)
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
				if (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS)
				{
					if (mc.thePlayer.ridingEntity instanceof VehicXWing)
					{
						VehicXWing xwing = (VehicXWing)mc.thePlayer.ridingEntity;

						float centerX = event.resolution.getScaledWidth() / 2f;
						float centerY = event.resolution.getScaledHeight() / 2f;

						float radarCenterX = event.resolution.getScaledWidth() * (107 / 216F);
						float radarCenterY = event.resolution.getScaledHeight() * (119 / 144F);

						float blipPercent = (blipFrame / blipMax);

						StarWarsMod.pgui.renderOverlay(xwingOverlayBack);
						StarWarsMod.pgui.renderOverlay(xwingOverlayPitch, 0, (int)(mc.thePlayer.rotationPitch / -5F));
						for (Entity p : xwing.nearby)
						{
							if (p instanceof VehicXWing || p instanceof VehicAWing) StarWarsMod.pgui.drawHollowCircle(radarCenterX + ((int)(xwing.posX - p.posX) / 5F), radarCenterY + ((int)(xwing.posZ - p.posZ) / 5F), 1, 5, 2, radarColor);
							if (p instanceof VehicTIE || p instanceof VehicTIEInterceptor) StarWarsMod.pgui.drawHollowCircle(radarCenterX + ((int)(xwing.posX - p.posX) / 5F), radarCenterY + ((int)(xwing.posZ - p.posZ) / 5F), 1, 5, 2, 0xFFB7181F);
							if (p instanceof EntityPlayer) StarWarsMod.pgui.drawHollowCircle(radarCenterX + ((int)(xwing.posX - p.posX) / 5F), radarCenterY + ((int)(xwing.posZ - p.posZ) / 5F), 1, 5, 2, 0xFF564AFF);
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

						// StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent,
						// centerY - 6 * blipPercent, centerX + 6 * blipPercent,
						// centerY + 6 * blipPercent, 2, radarColor);
						// StarWarsMod.pgui.drawLine(centerX - 6 * blipPercent,
						// centerY + 6 * blipPercent, centerX + 6 * blipPercent,
						// centerY - 6 * blipPercent, 2, radarColor);

						//MovingObjectPosition p = mc.thePlayer.rayTrace(100, 1);

						//Lumberjack.log(mc.entityRenderer.getMouseOver(p_78473_1_););

						Entity e = EntityUtils.getMouseOver(20, xwing, null);
						Lumberjack.log(e == null ? "null" : e.getCommandSenderName());

						StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY - 8 * blipPercent, centerX - 2 * blipPercent, centerY - 2 * blipPercent, 2, radarColor);
						StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY - 8 * blipPercent, centerX + 2 * blipPercent, centerY - 2 * blipPercent, 2, radarColor);
						StarWarsMod.pgui.drawLine(centerX + 8 * blipPercent, centerY + 8 * blipPercent, centerX + 2 * blipPercent, centerY + 2 * blipPercent, 2, radarColor);
						StarWarsMod.pgui.drawLine(centerX - 8 * blipPercent, centerY + 8 * blipPercent, centerX - 2 * blipPercent, centerY + 2 * blipPercent, 2, radarColor);

						StarWarsMod.pgui.drawHollowCircle(centerX, centerY, blipFrame, 10, 2, radarColor);

						StarWarsMod.pgui.renderOverlay(xwingOverlay);

						StarWarsMod.pgui.drawHollowTriangle(radarCenterX, radarCenterY, 3, mc.thePlayer.rotationYaw, 2, radarColor);
					}
					if (mc.thePlayer.ridingEntity instanceof VehicAWing) StarWarsMod.pgui.renderOverlay(awingOverlay);
					if (mc.thePlayer.ridingEntity instanceof VehicTIE || mc.thePlayer.ridingEntity instanceof VehicTIEInterceptor) StarWarsMod.pgui.renderOverlay(tieOverlay);
				}
			}
		}
		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE)) event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	private void drawMiniMap(Entity center, int min, int max, int pxSize)
	{
		for (int x = min; x < max; x++)
		{
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

				StarWarsMod.pgui.drawRect((x * pxSize) - (min * pxSize), (y * pxSize) - (min * pxSize), ((x * pxSize) + pxSize) - (min * pxSize), ((y * pxSize) + pxSize) - (min * pxSize), Math.min(255, bY), Math.min(255, bY), Math.min(255, bY), 255);
			}
		}
	}

}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */