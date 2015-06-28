package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorEndor;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.items.ItemBanthaHorn;
import com.parzi.starwarsmod.items.ItemBlasterBolt;
import com.parzi.starwarsmod.items.ItemMusicDisc;
import com.parzi.starwarsmod.items.crafting.ItemChromiumDust;
import com.parzi.starwarsmod.items.crafting.ItemContainmentField;
import com.parzi.starwarsmod.items.crafting.ItemHiltMetalAlloy;
import com.parzi.starwarsmod.items.crafting.ItemHiltMetalCompound;
import com.parzi.starwarsmod.items.crafting.ItemHyperdriveEngine;
import com.parzi.starwarsmod.items.crafting.ItemHyperdriveMotivator;
import com.parzi.starwarsmod.items.crafting.ItemLightsaberCrystal;
import com.parzi.starwarsmod.items.crafting.ItemPlasmaEmitter;
import com.parzi.starwarsmod.items.crafting.ItemTitaniumChromiumDust;
import com.parzi.starwarsmod.items.crafting.ItemTitaniumChromiumIngot;
import com.parzi.starwarsmod.items.crafting.ItemTitaniumDust;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveEarth;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveHoth;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveKashyyyk;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveTatooine;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveYavinFour;
import com.parzi.starwarsmod.items.weapons.ItemBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemEwokSpear;
import com.parzi.starwarsmod.items.weapons.ItemGaffiStick;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;
import com.parzi.starwarsmod.vehicles.ItemSpawnLandspeeder;
import com.parzi.starwarsmod.vehicles.ItemSpawnSpeederBike;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegister
{
	public static void registerAll()
	{
		StarWarsMod.gaffiStick = new ItemGaffiStick();
		GameRegistry.registerItem(StarWarsMod.gaffiStick, "gaffiStick");

		StarWarsMod.lightsaber = new ItemLightsaber();
		GameRegistry.registerItem(StarWarsMod.lightsaber, "lightsaber");

		StarWarsMod.blasterRifle = new ItemBlasterRifle();
		GameRegistry.registerItem(StarWarsMod.blasterRifle, "blasterRifle");

		StarWarsMod.hiltMetelCompound = new ItemHiltMetalCompound();
		GameRegistry.registerItem(StarWarsMod.hiltMetelCompound, "hiltMetalCompound");

		StarWarsMod.hiltMetelAlloy = new ItemHiltMetalAlloy();
		GameRegistry.registerItem(StarWarsMod.hiltMetelAlloy, "hiltMetalAlloy");

		StarWarsMod.plasmaEmitter = new ItemPlasmaEmitter();
		GameRegistry.registerItem(StarWarsMod.plasmaEmitter, "plasmaEmitter");

		StarWarsMod.containmentField = new ItemContainmentField();
		GameRegistry.registerItem(StarWarsMod.containmentField, "containmentField");

		StarWarsMod.lightsaberCrystal = new ItemLightsaberCrystal();
		GameRegistry.registerItem(StarWarsMod.lightsaberCrystal, "lightsaberCrystal");

		StarWarsMod.blasterBolt = new ItemBlasterBolt();
		GameRegistry.registerItem(StarWarsMod.blasterBolt, "blasterBolt");

		StarWarsMod.ewokSpear = new ItemEwokSpear();
		GameRegistry.registerItem(StarWarsMod.ewokSpear, "ewokSpear");

		StarWarsMod.banthaHorn = new ItemBanthaHorn();
		GameRegistry.registerItem(StarWarsMod.banthaHorn, "banthaHorn");

		StarWarsMod.jediRobes = new ArmorJediRobes(StarWarsMod.jediRobesMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.jediRobes, "jediRobes");

		StarWarsMod.endorHelmet = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.endorHelmet, "endorHelmet");

		StarWarsMod.endorChest = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.endorChest, "endorChest");

		StarWarsMod.endorLegs = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.endorLegs, "endorLegs");

		StarWarsMod.endorBoots = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.endorBoots, "endorBoots");

		StarWarsMod.recordTheme = new ItemMusicDisc("Theme");
		GameRegistry.registerItem(StarWarsMod.recordTheme, "recordTheme");

		StarWarsMod.recordThrone = new ItemMusicDisc("Throne");
		GameRegistry.registerItem(StarWarsMod.recordThrone, "recordThrone");

		StarWarsMod.chromiumDust = new ItemChromiumDust();
		GameRegistry.registerItem(StarWarsMod.chromiumDust, "chromiumDust");

		StarWarsMod.titaniumChromiumDust = new ItemTitaniumChromiumDust();
		GameRegistry.registerItem(StarWarsMod.titaniumChromiumDust, "titaniumChromiumDust");

		StarWarsMod.titaniumChromiumIngot = new ItemTitaniumChromiumIngot();
		GameRegistry.registerItem(StarWarsMod.titaniumChromiumIngot, "titaniumChromiumIngot");

		StarWarsMod.titaniumDust = new ItemTitaniumDust();
		GameRegistry.registerItem(StarWarsMod.titaniumDust, "titaniumDust");

		StarWarsMod.hyperdriveEngine = new ItemHyperdriveEngine();
		GameRegistry.registerItem(StarWarsMod.hyperdriveEngine, "hyperdriveEngine");

		StarWarsMod.hyperdriveMotivator = new ItemHyperdriveMotivator();
		GameRegistry.registerItem(StarWarsMod.hyperdriveMotivator, "hyperdriveMotivator");

		StarWarsMod.hyperdriveTatooine = new ItemHyperdriveTatooine();
		GameRegistry.registerItem(StarWarsMod.hyperdriveTatooine, "hyperdriveTatooine");

		StarWarsMod.hyperdriveEarth = new ItemHyperdriveEarth();
		GameRegistry.registerItem(StarWarsMod.hyperdriveEarth, "hyperdriveEarth");

		StarWarsMod.spawnSpeederBike = new ItemSpawnSpeederBike();
		GameRegistry.registerItem(StarWarsMod.spawnSpeederBike, "spawnSpeederBike");

		StarWarsMod.hyperdriveHoth = new ItemHyperdriveHoth();
		GameRegistry.registerItem(StarWarsMod.hyperdriveHoth, "hyperdriveHoth");

		StarWarsMod.hyperdriveKashyyyk = new ItemHyperdriveKashyyyk();
		GameRegistry.registerItem(StarWarsMod.hyperdriveKashyyyk, "hyperdriveKashyyyk");

		StarWarsMod.spawnLandspeeder = new ItemSpawnLandspeeder();
		GameRegistry.registerItem(StarWarsMod.spawnLandspeeder, "spawnLandspeeder");

		StarWarsMod.hyperdriveYavin4 = new ItemHyperdriveYavinFour();
		GameRegistry.registerItem(StarWarsMod.hyperdriveYavin4, "hyperdriveYavinFour");
	}
}
