package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
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
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.items.ItemBinoculars;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.network.CreateBlasterBoltSpeeder;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class StarWarsEventHandler
{
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
	public void onFOVCheck(FOVUpdateEvent fovUpdateEvent)
	{
		ItemStack item = fovUpdateEvent.entity.inventory.getCurrentItem();
		if (item != null && (item.getItem() instanceof ItemBinoculars || item.getItem() instanceof com.parzi.starwarsmod.items.ItemBinocularsHoth) && ItemBinoculars.getEnabled(item) && mc.gameSettings.thirdPersonView == 0) fovUpdateEvent.newfov = fovUpdateEvent.fov / ItemBinoculars.getZoom(item);
	}
	
	@SubscribeEvent
	public void onPlayerLogIn(EntityJoinWorldEvent logInEvent)
	{
		if (StarWarsMod.VERSION != StarWarsMod.ONLINE_VERSION && logInEvent.entity instanceof EntityPlayerSP)
			((EntityPlayerSP)logInEvent.entity).addChatMessage(new ChatComponentText("New version of Parzi's Star Wars Mod Available: " + StarWarsMod.ONLINE_VERSION + ". Current: " + StarWarsMod.VERSION));
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
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike) && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBoltSpeeder(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId));
			mc.thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
		}
	}

	@SubscribeEvent
	public void onRenderBar(RenderGameOverlayEvent event)
	{
		StarWarsMod.isOverlayOnscreen = false;
		ItemStack item = StarWarsMod.playerHelper.getHeldItem();
		if (item != null && StarWarsMod.renderHelper.isFirstPerson()) if (item.getItem() instanceof ItemBinoculars && ItemBinoculars.getEnabled(item))
		{
			StarWarsMod.isOverlayOnscreen = ItemBinoculars.getEnabled(item);
			ResourceLocation guiTexture;
			if (item.getItem() instanceof ItemBinocularsTatooine)
				guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_style/binoc_style_" + ItemBinoculars.getZoom(item) + ".png");
			else
				guiTexture = new ResourceLocation(StarWarsMod.MODID, "textures/gui/binoc_hoth/binoc_hoth_" + ItemBinoculars.getZoom(item) + ".png");
			StarWarsMod.pgui.renderOverlay(guiTexture);
		}
		if (event.isCancelable() && (event.type == RenderGameOverlayEvent.ElementType.CROSSHAIRS || event.type == RenderGameOverlayEvent.ElementType.CHAT || event.type == RenderGameOverlayEvent.ElementType.HELMET)) event.setCanceled(StarWarsMod.isOverlayOnscreen);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\StarWarsEventHandler.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */