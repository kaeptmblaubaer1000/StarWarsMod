package com.parzi.starwarsmod.handlers;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.network.CreateBlasterBoltSpeeder;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.vehicles.VehicHothSpeederBike;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class StarWarsEventHandler
{
	@SubscribeEvent
	public void onBlockBroken(BreakEvent breakEvent)
	{
		if (breakEvent.getPlayer().inventory.armorInventory[2] != null && (breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && Arrays.asList(ArmorJediRobes.earthMatter).contains(breakEvent.block) && breakEvent.world.rand.nextInt(ArmorJediRobes.chanceElement / 10) == 0)
		{
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", breakEvent.getPlayer().inventory.armorInventory[2].stackTagCompound.getInteger("earth") + 1, breakEvent.getPlayer().dimension, breakEvent.getPlayer().getCommandSenderName()));
		}
	}

	@SubscribeEvent
	public void onLogIn(EntityJoinWorldEvent entityJoinWorldEvent) throws PlayerNotBetaTesterException
	{
		if (entityJoinWorldEvent.entity instanceof EntityPlayer && StarWarsMod.isBetaTesting)
		{
			EntityPlayer player = (EntityPlayer)entityJoinWorldEvent.entity;
			if (player.getCommandSenderName() != StarWarsMod.betaTesterUsername)
			{
				throw new PlayerNotBetaTesterException(player);
			}
			else
			{
				Lumberjack.info("Beta tester \"" + player.getCommandSenderName() + "\" logged in!");
			}
		}
	}

	@SubscribeEvent
	public void onMobHit(AttackEntityEvent attackEntityEvent)
	{
		if (attackEntityEvent.entityPlayer.inventory.armorInventory[2] != null && (attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes || attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorLightJediRobes) && attackEntityEvent.entity.worldObj.rand.nextInt(ArmorJediRobes.chanceElement / 50) == 0)
		{
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("animals", attackEntityEvent.entityPlayer.inventory.armorInventory[2].stackTagCompound.getInteger("animals") + 1, attackEntityEvent.entityPlayer.dimension, attackEntityEvent.entityPlayer.getCommandSenderName()));
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && (playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike || playerInteractEvent.entityPlayer.ridingEntity instanceof VehicHothSpeederBike) && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR && playerInteractEvent.entityPlayer.inventory.getCurrentItem() == null)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBoltSpeeder(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId));

			Minecraft.getMinecraft().thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
		}
	}
}
