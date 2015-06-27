package com.parzi.starwarsmod;

import java.util.Arrays;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;

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
}
