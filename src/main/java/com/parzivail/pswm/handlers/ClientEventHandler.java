package com.parzivail.pswm.handlers;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemBinoculars;
import com.parzivail.pswm.items.ItemBinocularsHoth;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.jedirobes.powers.Power;
import com.parzivail.pswm.minimap.MinimapStore;
import com.parzivail.pswm.network.MessageCreateBlasterBolt;
import com.parzivail.pswm.rendering.force.ModelJediCloak;
import com.parzivail.pswm.rendering.force.RenderJediDefense;
import com.parzivail.pswm.rendering.force.RenderSithLightning;
import com.parzivail.pswm.rendering.gui.GuiBinocs;
import com.parzivail.pswm.rendering.gui.GuiBlaster;
import com.parzivail.pswm.rendering.gui.GuiVehicle;
import com.parzivail.pswm.rendering.helper.PGui;
import com.parzivail.pswm.sound.SoundManager;
import com.parzivail.pswm.utils.BlasterBoltType;
import com.parzivail.pswm.vehicles.VehicATST;
import com.parzivail.pswm.vehicles.VehicAWing;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicSkyhopper;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import com.parzivail.pswm.vehicles.VehicTIE;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicXWing;
import com.parzivail.util.AnimationManager;
import com.parzivail.util.entity.PlayerHelper;
import com.parzivail.util.ui.GuiManager;
import com.parzivail.util.ui.Lumberjack;
import com.parzivail.util.ui.RenderHelper;
import com.parzivail.util.ui.Text;
import com.parzivail.util.ui.TextUtils;
import com.parzivail.util.vehicle.VehicleAirBase;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;

public class ClientEventHandler
{
	public static Item lastItem = null;
	public static long lastTime = 0;

	public static EntityPlayer lightningFrom = null;
	public static EntityPlayer lastPlayerTarget = null;

	public static boolean cursorOpen = true;
	public static boolean isCursorAnim = false;

	public static MinimapStore worldStore;

	@SideOnly(Side.CLIENT)
	public static PGui pgui;
	@SideOnly(Side.CLIENT)
	public static PlayerHelper playerHelper;
	@SideOnly(Side.CLIENT)
	public static RenderHelper renderHelper;

	@SideOnly(Side.CLIENT)
	public static GuiBlaster guiBlaster;
	@SideOnly(Side.CLIENT)
	public static GuiVehicle guiVehicle;
	@SideOnly(Side.CLIENT)
	public static GuiBinocs guiBinocs;
	@SideOnly(Side.CLIENT)
	public static RenderJediDefense renderJediDefense;
	@SideOnly(Side.CLIENT)
	public static RenderSithLightning renderSithLightning;

	@SideOnly(Side.CLIENT)
	public static ModelJediCloak modelCloak;

	@SideOnly(Side.CLIENT)
	public static SoundManager soundManager;

	public ClientEventHandler()
	{
		worldStore = new MinimapStore();
	}

	@SideOnly(Side.CLIENT)
	public void init()
	{
		renderHelper = new RenderHelper(Minecraft.getMinecraft());
		playerHelper = new PlayerHelper(Minecraft.getMinecraft());
		pgui = new PGui(Minecraft.getMinecraft());
		soundManager = new SoundManager();
		soundManager.init();
		renderJediDefense = new RenderJediDefense();
		renderSithLightning = new RenderSithLightning();
		modelCloak = new ModelJediCloak();
		guiVehicle = new GuiVehicle();
		guiBinocs = new GuiBinocs();
		guiBlaster = new GuiBlaster();
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onDrawHand(RenderHandEvent renderHandEvent)
	{
		renderHandEvent.setCanceled(StarWarsMod.isOverlayOnscreen);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFogify(EntityViewRenderEvent.FogDensity fogDensity)
	{
		if (fogDensity.entity.dimension == ConfigOptions.dimDagobahId)
		{
			fogDensity.density = 0.075F;
			fogDensity.setCanceled(true);
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onFOVCheck(FOVUpdateEvent fovUpdateEvent)
	{
		ItemStack item = fovUpdateEvent.entity.inventory.getCurrentItem();
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && StarWarsMod.mc.gameSettings.thirdPersonView == 0)
			fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer entityPlayer = (EntityPlayer)event.entityLiving;

			// Lumberjack.log("damage player!");
			// Lumberjack.log("active: " +
			// ArmorJediRobes.getActive(entityPlayer));
			// Lumberjack.log("running? " +
			// (ArmorJediRobes.getIsRunning(entityPlayer) ? "yes" : "no"));
			// Lumberjack.log("using duration? " +
			// (ArmorJediRobes.getUsingDuration(entityPlayer) ? "yes" : "no"));

			if (ArmorJediRobes.getActive(entityPlayer).equals("defend") && ArmorJediRobes.getHealth(entityPlayer) > 0)
			{
				Power.getPowerFromName(ArmorJediRobes.getActive(entityPlayer));
				if (ArmorJediRobes.getHealth(entityPlayer) > event.ammount)
				{
					ArmorJediRobes.setHealth(entityPlayer, (int)(ArmorJediRobes.getHealth(entityPlayer) - event.ammount));
					// Lumberjack.log("Remaining: " +
					// ArmorJediRobes.getHealth(entityPlayer));
					// Lumberjack.log("Cancelling event!");
					event.setCanceled(true);
				}
				else
				{
					event.ammount -= ArmorJediRobes.getHealth(entityPlayer);
					ArmorJediRobes.setHealth(entityPlayer, 0);
					// Lumberjack.log("Depleted shield!");
				}
			}

			if (ArmorJediRobes.getActive(entityPlayer).equals("deflect") && ArmorJediRobes.getUsingDuration(entityPlayer))
				// Lumberjack.log("deflect running!");
				if (event.source.isProjectile())
					// Lumberjack.log("Cancelling event!");
					event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
			if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike)
			{
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(playerInteractEvent.entityPlayer, BlasterBoltType.SPEEDER));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "fx.shoot.bike", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicXWing || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicAWing || StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicSkyhopper || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicATST)
			{
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(playerInteractEvent.entityPlayer, BlasterBoltType.XWING));
				if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicATST)
				{
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "fx.shoot.bike", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
				}
				else
				{
					StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.xwing.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
				}
				GuiVehicle.isFiring = true;
				GuiVehicle.blipFrame = GuiVehicle.blipMax;
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIE || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new MessageCreateBlasterBolt(playerInteractEvent.entityPlayer, BlasterBoltType.TIE));
				StarWarsMod.mc.thePlayer.playSound(Resources.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (logInEvent.entity instanceof EntityPlayer)
		{
			if (!Resources.VERSION.equalsIgnoreCase(Resources.ONLINE_VERSION) && !StarWarsMod.hasShownNeedUpdate)
			{
				((EntityPlayer)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(Resources.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(Resources.VERSION, Text.COLOR_YELLOW)));
				StarWarsMod.hasShownNeedUpdate = true;
			}
			if (ConfigOptions.enableGlobalLeaderboard && !StarWarsMod.hasShownLeaderboardPart)
			{
				((EntityPlayer)logInEvent.entity).addChatMessage(new ChatComponentText("Thanks for participating in the global Jedi vs. Sith leaderboard! You can opt out at any time in the config."));
				StarWarsMod.hasShownLeaderboardPart = true;
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRender(RenderLivingEvent.Pre event)
	{
		if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			if (ClientEventHandler.renderHelper.isFirstPerson())
			{
				ClientEventHandler.pgui.changeCameraDist(this, 4);

				event.setCanceled(event.entity == StarWarsMod.mc.thePlayer.ridingEntity);
			}
			else
			{
				ClientEventHandler.pgui.changeCameraDist(this, 15);

				event.setCanceled(event.entity.ridingEntity instanceof VehicleAirBase);
			}
		}
		else if (StarWarsMod.mc.thePlayer != null && StarWarsMod.mc.thePlayer.ridingEntity instanceof VehicATST)
		{
			if (ClientEventHandler.renderHelper.isFirstPerson())
			{
				ClientEventHandler.pgui.changeCameraDist(this, 4);

				event.setCanceled(event.entity == StarWarsMod.mc.thePlayer.ridingEntity);
			}
			else
			{
				ClientEventHandler.pgui.changeCameraDist(this, 10);

				event.setCanceled(event.entity.ridingEntity instanceof VehicATST);
			}
		}
		else
			ClientEventHandler.pgui.changeCameraDist(this, 4);
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderGui(RenderGameOverlayEvent.Pre event)
	{
		StarWarsMod.isOverlayOnscreen = false;
		if (ClientEventHandler.renderHelper.isFirstPerson())
		{
			guiBinocs.onRenderGui(event);

			guiVehicle.onRenderGui(event);
		}

		guiBlaster.onRenderGui(event);

		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET || event.type == RenderGameOverlayEvent.ElementType.HOTBAR || event.type == RenderGameOverlayEvent.ElementType.HEALTH || event.type == RenderGameOverlayEvent.ElementType.HEALTHMOUNT || event.type == RenderGameOverlayEvent.ElementType.EXPERIENCE || event.type == RenderGameOverlayEvent.ElementType.FOOD || event.type == RenderGameOverlayEvent.ElementType.ARMOR || event.type == RenderGameOverlayEvent.ElementType.JUMPBAR))
			event.setCanceled(StarWarsMod.isOverlayOnscreen);

		GuiManager.render(event);

		AnimationManager.render(event);

	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderPlayerSpecial(RenderPlayerEvent.Specials.Post event)
	{
		ClientEventHandler.modelCloak.renderCloak(event);
	}

	@SubscribeEvent
	public void onXpPickup(PlayerPickupXpEvent event)
	{
		if (event.entityPlayer.inventory.armorItemInSlot(2) != null && event.entityPlayer.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
		{
			int currentLevels = ArmorJediRobes.getLevel(event.entityPlayer.inventory.armorItemInSlot(2));
			if (StarWarsMod.rngGeneral.nextInt(100) <= ArmorJediRobes.getPercentForLevel(currentLevels))
			{
				event.entityPlayer.inventory.armorInventory[2] = ArmorJediRobes.addLevels(event.entityPlayer.inventory.armorItemInSlot(2), 1);
				Lumberjack.log("XP accepted!");
			}
			else
				Lumberjack.log("XP rejected!");
			int newLevels = ArmorJediRobes.getLevel(event.entityPlayer.inventory.armorItemInSlot(2));
			Lumberjack.log(newLevels / ArmorJediRobes.POINTS_PER_LEVEL);
			if (Math.floor(newLevels / ArmorJediRobes.POINTS_PER_LEVEL) == Math.floor(currentLevels / ArmorJediRobes.POINTS_PER_LEVEL) + 1)
			{
				// level up!
				event.entityPlayer.playSound("random.levelup", 1, 1);
				ArmorJediRobes.addPoints(event.entityPlayer.inventory.armorItemInSlot(2), 1);
				ArmorJediRobes.setMaxXP(event.entityPlayer.inventory.armorItemInSlot(2), (int)(Math.floor(newLevels / ArmorJediRobes.POINTS_PER_LEVEL) * 100));
				event.entityPlayer.addChatMessage(new ChatComponentText("[Robes] Level Up! You gained an upgrade point."));
				event.entityPlayer.addChatMessage(new ChatComponentText(String.format("[Robes] You are now level %s and have %s upgrade points.", (int)Math.floor(ArmorJediRobes.getLevel(event.entityPlayer.inventory.armorItemInSlot(2)) / ArmorJediRobes.POINTS_PER_LEVEL), ArmorJediRobes.getPoints(event.entityPlayer.inventory.armorItemInSlot(2)))));
				if (Math.floor(newLevels / ArmorJediRobes.POINTS_PER_LEVEL) == 35)
				{
					event.entityPlayer.addChatMessage(new ChatComponentText(String.format("[Robes] %s", TextUtils.makeItalic(TextUtils.addEffect("You hear a dark whisper. Do you answer?", Text.COLOR_DARK_GRAY)))));
					event.entityPlayer.openGui(StarWarsMod.instance, Resources.GUI_JEDI_SITH, null, 0, 0, 0);
				}
			}
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderWorldLastEvent(RenderWorldLastEvent event)
	{
		ClientEventHandler.renderJediDefense.onWorldRender(event);

		ClientEventHandler.renderSithLightning.onWorldRender(event);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */