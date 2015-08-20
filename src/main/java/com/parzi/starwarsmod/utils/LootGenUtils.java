package com.parzi.starwarsmod.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

import com.parzi.starwarsmod.StarWarsMod;

public class LootGenUtils
{
	public static float baseRarity = 1F; // 0.00025

	public static void fillLootChest(int dimId, Random rand, TileEntityChest tile)
	{
		if (tile != null)
		{
			for (int i = 0; i < rand.nextInt(2) + 1; i++)
			{
				tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), getWeightedItemForDim(dimId, rand));
			}
			tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), new ItemStack(StarWarsMod.imperialCredit, ItemUtils.randomRange(1, 15)));
		}
	}

	public static List<WeightedLoot> getLootForDim(int dimId)
	{
		List<WeightedLoot> loot = new ArrayList<WeightedLoot>();

		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.imperialCredit, ItemUtils.randomRange(0, 5)), baseRarity));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.leiasBuns, ItemUtils.randomRange(0, 1)), baseRarity / 10F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordBinary, ItemUtils.randomRange(0, 1)), baseRarity / 10F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordTheme, ItemUtils.randomRange(0, 1)), baseRarity / 10F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordThrone, ItemUtils.randomRange(0, 1)), baseRarity / 10F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordImperial, ItemUtils.randomRange(0, 1)), baseRarity / 10F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsMod.recordCantina, ItemUtils.randomRange(0, 1)), baseRarity / 10F));

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

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotHelmet, 1, 0), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotChest, 1, 0), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotLegs, 1, 0), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.tiePilotBoots, 1, 0), baseRarity / 2F));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnSpeederBike, 1, 0), baseRarity / 2F));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterPistol.versions, "Scout")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 3F)); // DLT-19
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

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.spawnHothSpeederBike, 1, 0), baseRarity / 3F));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl21")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "T21")), baseRarity / 4F));
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
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 2F));
		}
		else if (dimId == StarWarsMod.dimTatooineId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.sandtrooperBoots, 1, 0), baseRarity));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaHelmet, 1, 0), baseRarity / 4F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaChest, 1, 0), baseRarity / 4F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaJetpack, 1, 0), baseRarity / 8F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaLegs, 1, 0), baseRarity / 4F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.bobaBoots, 1, 0), baseRarity / 4F));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl18")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "Dlt19")), baseRarity / 4F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterHeavy, 1, indexOf(StarWarsMod.blasterHeavy.versions, "T21")), baseRarity / 4F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "Esb")), baseRarity / 2F));
		}
		else if (dimId == StarWarsMod.dimYavin4Id)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.rebelPilotBoots, 1, 0), baseRarity));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "red")), baseRarity / 8F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "green")), baseRarity / 5.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.lightsaberCrystal, 1, indexOf(StarWarsMod.lightsaberCrystal.colors, "blue")), baseRarity / 5.5F));

			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dh17")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterRifle, 1, indexOf(StarWarsMod.blasterRifle.versions, "A280")), baseRarity / 2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsMod.blasterPistol, 1, indexOf(StarWarsMod.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
		}
		return loot;
	}

	public static ItemStack getWeightedItemForDim(int dimId, Random rand)
	{
		List<WeightedLoot> loot = LootGenUtils.getLootForDim(dimId);
		int length = loot.toArray().length;

		double totalWeight = 0.0d;
		for (int i = 0; i < length; i++)
		{
			totalWeight += loot.get(i).weight;
		}
		// Now choose a random item
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < length; i++)
		{
			random -= loot.get(i).weight;
			if (random <= 0.0d)
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

		double totalWeight = 0.0d;
		for (int i = 0; i < length; i++)
		{
			totalWeight += items.get(i).weight;
		}
		// Now choose a random item
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < length; i++)
		{
			random -= items.get(i).weight;
			if (random <= 0.0d)
			{
				randomIndex = i;
				break;
			}
		}
		return items.get(randomIndex).item;
	}

	private static int indexOf(String[] haystack, String needle)
	{
		return Arrays.asList(haystack).indexOf(needle);
	}
}
