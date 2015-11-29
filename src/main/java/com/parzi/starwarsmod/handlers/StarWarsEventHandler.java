package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
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
import com.parzi.starwarsmod.utils.BlasterBoltType;
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
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StarWarsEventHandler
{
	private static final ResourceLocation xwingOverlay = new ResourceLocation(StarWarsMod.MODID, "textures/gui/xwing.png");

	public static Minecraft mc = Minecraft.getMinecraft();

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
	@SideOnly(Side.CLIENT)
	public void onRender(RenderLivingEvent.Pre event)
	{
		if (mc.thePlayer != null && mc.thePlayer.ridingEntity instanceof VehicleAirBase)
		{
			if (StarWarsMod.renderHelper.isFirstPerson())
			{
				ReflectionHelper.setPrivateValue(EntityRenderer.class, mc.entityRenderer, 4, "thirdPersonDistance");
				//((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(4);

				event.setCanceled(event.entity == mc.thePlayer.ridingEntity);
			}
			else
			{
				ReflectionHelper.setPrivateValue(EntityRenderer.class, mc.entityRenderer, 15, "thirdPersonDistance");
				//((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(15);

				event.setCanceled(event.entity.ridingEntity instanceof VehicleAirBase);
			}
		}
		else
		{
			ReflectionHelper.setPrivateValue(EntityRenderer.class, mc.entityRenderer, 4, "thirdPersonDistance");
			//((PSWMEntityRenderer)mc.entityRenderer).setThirdPersonDistance(4);
		}
	}

	@SubscribeEvent
	public void onFOVCheck(FOVUpdateEvent fovUpdateEvent)
	{
		ItemStack item = fovUpdateEvent.entity.inventory.getCurrentItem();
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && mc.gameSettings.thirdPersonView == 0) fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}

	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (StarWarsMod.VERSION != StarWarsMod.ONLINE_VERSION && logInEvent.entity instanceof EntityPlayerSP) ((EntityPlayerSP)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod available: " + TextUtils.addEffect(StarWarsMod.ONLINE_VERSION, Text.COLOR_YELLOW) + "! Current: " + TextUtils.addEffect(StarWarsMod.VERSION, Text.COLOR_YELLOW)));

		if (logInEvent.entity instanceof EntityPlayer)
		{
			if (logInEvent.world.provider.dimensionId == -100) logInEvent.setCanceled(true);
		}
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
			}
			else if (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIE || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicTIEInterceptor)
			{
				StarWarsMod.network.sendToServer(new CreateBlasterBolt(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId, BlasterBoltType.TIE));
				mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "vehicle.tie.fire", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
			}
		}
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
				StarWarsMod.isOverlayOnscreen = ItemBinoculars.getEnabled(item);
				ResourceLocation guiTexture;
				if (item.getItem() instanceof ItemBinocularsTatooine)
					guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
				else
					guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
				StarWarsMod.pgui.renderOverlay(guiTexture);
			}
			if (mc.thePlayer.ridingEntity instanceof VehicXWing)
				StarWarsMod.pgui.renderOverlay(xwingOverlay);
		}
		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET)) event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */