package com.parzi.starwarsmod.utils;

import java.util.List;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.util.MathUtils;
import com.parzi.util.entity.trade.WeightedLoot;

public class LootGenUtils
{
	public static float baseRarity = 1.0F;

	public static void fillLootChest(int dimId, Random rand, TileEntityChest tile)
	{
		if (tile != null)
		{
			for (int i = 0; i < rand.nextInt(2) + 1; i++)
				tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), getWeightedItemForDim(dimId, rand));
			tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), new ItemStack(StarWarsMod.imperialCredit, MathUtils.randomRange(1, 15)));
		}
	}

	public static List<WeightedLoot> getLootForDim(int dimId)
	{
		List<WeightedLoot> loot = new java.util.ArrayList();
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.imperialCredit, MathUtils.randomRange(1, 6)), baseRarity));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.leiasBuns, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordBinary, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordTheme, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordThrone, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordImperial, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		if (dimId == StarWarsMod.dimEndorId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.endorHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.endorChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.endorLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.endorBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.scoutTrooperHelmet, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.scoutTrooperChest, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.scoutTrooperLegs, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.scoutTrooperBoots, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotHelmet, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotChest, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotLegs, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotBoots, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnSpeederBike, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnMouse, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Scout")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 3.0F));
		}
		else if (dimId == StarWarsMod.dimHothId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.snowtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.snowtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.snowtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.snowtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.hothHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.hothChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.hothLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.hothBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnHothSpeederBike, 1, 0), baseRarity / 3.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnProtocol2, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnSurgical, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl21")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "T21")), baseRarity / 4.0F));
		}
		else if (dimId == StarWarsMod.dimKashyyykId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.stormtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 2.0F));
		}
		else if (dimId == StarWarsMod.dimTatooineId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaHelmet, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaChest, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaJetpack, 1, 0), baseRarity / 8.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaLegs, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaBoots, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl18")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "T21")), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Esb")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Rt97c")), baseRarity / 4.0F));
		}
		else if (dimId == StarWarsMod.dimYavin4Id)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "red")), baseRarity / 8.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "green")), baseRarity / 5.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "blue")), baseRarity / 5.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dh17")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
		}
		return loot;
	}

	public static ItemStack getWeightedItemForDim(int dimId, Random rand)
	{
		List<WeightedLoot> loot = getLootForDim(dimId);
		int length = loot.toArray().length;
		double totalWeight = 0.0D;
		for (int i = 0; i < length; i++)
			totalWeight += loot.get(i).weight;
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < length; i++)
		{
			random -= loot.get(i).weight;
			if (random <= 0.0D)
			{
				randomIndex = i;
				break;
			}
		}
		return loot.get(randomIndex).item;
	}

	public static ItemStack getWeightedItemFromList(List<WeightedLoot> items, Random rand)
	{
		int length = items.toArray().length;
		double totalWeight = 0.0D;
		for (int i = 0; i < length; i++)
			totalWeight += items.get(i).weight;
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < length; i++)
		{
			random -= items.get(i).weight;
			if (random <= 0.0D)
			{
				randomIndex = i;
				break;
			}
		}
		return items.get(randomIndex).item;
	}

	private static int indexOf(String[] haystack, String needle)
	{
		return java.util.Arrays.asList(haystack).indexOf(needle);
	}
}