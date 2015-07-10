package com.parzi.starwarsmod;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.entities.EntityBlasterRifleBolt;
import com.parzi.starwarsmod.network.CreateBlasterBoltSpeeder;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;

import cpw.mods.fml.common.event.FMLMissingMappingsEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class StarWarsEventHandler
{
	@SubscribeEvent
	public void onBlockBroken(BreakEvent breakEvent)
	{
		if (breakEvent.getPlayer().inventory.armorInventory[2] != null && breakEvent.getPlayer().inventory.armorInventory[2].getItem() instanceof ArmorJediRobes && Arrays.asList(ArmorJediRobes.earthMatter).contains(breakEvent.block) && breakEvent.world.rand.nextInt(ArmorJediRobes.chanceElement / 10) == 0)
		{
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("earth", breakEvent.getPlayer().inventory.armorInventory[2].stackTagCompound.getInteger("earth") + 1));
		}
	}

	@SubscribeEvent
	public void onMobHit(AttackEntityEvent attackEntityEvent)
	{
		if (attackEntityEvent.entityPlayer.inventory.armorInventory[2] != null && attackEntityEvent.entityPlayer.inventory.armorInventory[2].getItem() instanceof ArmorJediRobes && attackEntityEvent.entity.worldObj.rand.nextInt(ArmorJediRobes.chanceElement / 50) == 0)
		{
			StarWarsMod.network.sendToServer(new JediRobesSetElementInArmorInv("animals", attackEntityEvent.entityPlayer.inventory.armorInventory[2].stackTagCompound.getInteger("animals") + 1));
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent playerInteractEvent)
	{
		if (playerInteractEvent.entityPlayer.ridingEntity != null && playerInteractEvent.entityPlayer.ridingEntity instanceof VehicSpeederBike && playerInteractEvent.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_AIR)
		{
			StarWarsMod.network.sendToServer(new CreateBlasterBoltSpeeder(playerInteractEvent.entityPlayer.getCommandSenderName(), playerInteractEvent.world.provider.dimensionId));

			Minecraft.getMinecraft().thePlayer.playSound(StarWarsMod.MODID + ":" + "item.blasterRifle.use", 1f, 1f + (float)MathHelper.getRandomDoubleInRange(playerInteractEvent.world.rand, -0.2D, 0.2D));
		}
	}
}
