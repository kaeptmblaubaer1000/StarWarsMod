package com.parzivail.pswm.utils;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.util.entity.trade.WeightedLoot;
import com.parzivail.util.math.MathUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;

import java.util.List;
import java.util.Random;

public class LootGenUtils
{
	public static float baseRarity = 1.0F;

	public static void fillLootChest(int dimId, Random rand, TileEntityChest tile)
	{
		if (tile != null)
		{
			for (int i = 0; i < rand.nextInt(2) + 1; i++)
				tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), getWeightedItemForDim(dimId, rand));
			tile.setInventorySlotContents(rand.nextInt(tile.getSizeInventory()), new ItemStack(StarWarsItems.imperialCredit, MathUtils.randomRange(1, 15)));
		}
	}

	public static List<WeightedLoot> getLootForDim(int dimId)
	{
		List<WeightedLoot> loot = new java.util.ArrayList();
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.imperialCredit, MathUtils.randomRange(1, 6)), baseRarity));
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.leiasBuns, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.recordBinary, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.recordTheme, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.recordThrone, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		loot.add(new WeightedLoot(new ItemStack(StarWarsItems.recordImperial, MathUtils.randomRange(1, 1)), baseRarity / 10.0F));
		if (dimId == ConfigOptions.dimEndorId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.endorHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.endorChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.endorLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.endorBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.scoutTrooperHelmet, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.scoutTrooperChest, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.scoutTrooperLegs, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.scoutTrooperBoots, 1, 0), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotHelmet, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotChest, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotLegs, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotBoots, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.spawnSpeederBike, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.spawnMouse, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Scout")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "Dlt19")), baseRarity / 3.0F));
		}
		else if (dimId == ConfigOptions.dimHothId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.snowtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.snowtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.snowtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.snowtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.hothHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.hothChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.hothLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.hothBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.spawnHothSpeederBike, 1, 0), baseRarity / 3.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.spawnProtocol2, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.spawnSurgical, 1, 0), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl21")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "Dlt19")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "T21")), baseRarity / 4.0F));
		}
		else if (dimId == ConfigOptions.dimKashyyykId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.stormtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.tiePilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "Dlt19")), baseRarity / 2.0F));
		}
		else if (dimId == ConfigOptions.dimTatooineId)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.sandtrooperHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.sandtrooperChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.sandtrooperLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.sandtrooperBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.bobaHelmet, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.bobaChest, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.bobaJetpack, 1, 0), baseRarity / 8.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.bobaLegs, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.bobaBoots, 1, 0), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "Stormtrooper")), baseRarity / 1.2F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl18")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "Dlt19")), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "T21")), baseRarity / 4.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "Esb")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterHeavy, 1, indexOf(StarWarsItems.blasterHeavy.versions, "Rt97c")), baseRarity / 4.0F));
		}
		else if (dimId == ConfigOptions.dimYavin4Id)
		{
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotHelmet, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotChest, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotLegs, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.rebelPilotBoots, 1, 0), baseRarity));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.lightsaberCrystal, 1, indexOf(StarWarsItems.lightsaberCrystal.colors, "red")), baseRarity / 8.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.lightsaberCrystal, 1, indexOf(StarWarsItems.lightsaberCrystal.colors, "green")), baseRarity / 5.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.lightsaberCrystal, 1, indexOf(StarWarsItems.lightsaberCrystal.colors, "blue")), baseRarity / 5.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dh17")), baseRarity / 1.5F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterRifle, 1, indexOf(StarWarsItems.blasterRifle.versions, "A280")), baseRarity / 2.0F));
			loot.add(new WeightedLoot(new ItemStack(StarWarsItems.blasterPistol, 1, indexOf(StarWarsItems.blasterPistol.versions, "Dl44")), baseRarity / 1.5F));
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