package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorAddonBuns;
import com.parzi.starwarsmod.armor.ArmorBoba;
import com.parzi.starwarsmod.armor.ArmorBobaJetpack;
import com.parzi.starwarsmod.armor.ArmorEndor;
import com.parzi.starwarsmod.armor.ArmorHoth;
import com.parzi.starwarsmod.armor.ArmorHothPilot;
import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.armor.ArmorLightJediRobes;
import com.parzi.starwarsmod.armor.ArmorRebelFleet;
import com.parzi.starwarsmod.armor.ArmorRebelPilot;
import com.parzi.starwarsmod.armor.ArmorSandtrooper;
import com.parzi.starwarsmod.armor.ArmorScoutTrooper;
import com.parzi.starwarsmod.armor.ArmorSnowtrooper;
import com.parzi.starwarsmod.armor.ArmorStormtrooper;
import com.parzi.starwarsmod.armor.ArmorTiePilot;
import com.parzi.starwarsmod.items.ItemAcidBeets;
import com.parzi.starwarsmod.items.ItemBanthaChop;
import com.parzi.starwarsmod.items.ItemBanthaChopCooked;
import com.parzi.starwarsmod.items.ItemBanthaHorn;
import com.parzi.starwarsmod.items.ItemBanthaMilk;
import com.parzi.starwarsmod.items.ItemBanthaPlatter;
import com.parzi.starwarsmod.items.ItemBinocularsHoth;
import com.parzi.starwarsmod.items.ItemBinocularsTatooine;
import com.parzi.starwarsmod.items.ItemBlasterBolt;
import com.parzi.starwarsmod.items.ItemBlasterRifleBolt;
import com.parzi.starwarsmod.items.ItemCanron;
import com.parzi.starwarsmod.items.ItemChasuka;
import com.parzi.starwarsmod.items.ItemDebugLandspeederNPC;
import com.parzi.starwarsmod.items.ItemDebugLootGen;
import com.parzi.starwarsmod.items.ItemDewbackRibs;
import com.parzi.starwarsmod.items.ItemDroidCaller;
import com.parzi.starwarsmod.items.ItemDroidHacker;
import com.parzi.starwarsmod.items.ItemGorrnar;
import com.parzi.starwarsmod.items.ItemImperialCredit;
import com.parzi.starwarsmod.items.ItemMusicDisc;
import com.parzi.starwarsmod.items.ItemSpawnAstromech;
import com.parzi.starwarsmod.items.ItemSpawnAstromech2;
import com.parzi.starwarsmod.items.ItemSpawnGonk;
import com.parzi.starwarsmod.items.ItemSpawnMouse;
import com.parzi.starwarsmod.items.ItemSpawnProbe;
import com.parzi.starwarsmod.items.ItemSpawnProtocol;
import com.parzi.starwarsmod.items.ItemSpawnProtocol2;
import com.parzi.starwarsmod.items.ItemSpawnSurgical;
import com.parzi.starwarsmod.items.ItemSpawnTreadwell;
import com.parzi.starwarsmod.items.ItemWaterDroplet;
import com.parzi.starwarsmod.items.crafting.ItemBobaJetpack;
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
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveEndor;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveHoth;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveKashyyyk;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveTatooine;
import com.parzi.starwarsmod.items.hyperdrive.ItemHyperdriveYavinFour;
import com.parzi.starwarsmod.items.weapons.ItemBlasterHeavy;
import com.parzi.starwarsmod.items.weapons.ItemBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemEwokSpear;
import com.parzi.starwarsmod.items.weapons.ItemGaffiStick;
import com.parzi.starwarsmod.items.weapons.ItemGamorreanAx;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemWookieeBowcaster;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.vehicles.ItemSpawnHothSpeederBike;
import com.parzi.starwarsmod.vehicles.ItemSpawnLandspeeder;
import com.parzi.starwarsmod.vehicles.ItemSpawnSpeederBike;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegister
{
	public static void registerAll()
	{
		if (StarWarsMod.IS_DEV_ENVIRONVENT)
		{
			StarWarsMod.debugLootGen = new ItemDebugLootGen();
			GameRegistry.registerItem(StarWarsMod.debugLootGen, "debugLootGen");

			StarWarsMod.debugLandspeederNPC = new ItemDebugLandspeederNPC();
			GameRegistry.registerItem(StarWarsMod.debugLandspeederNPC, "debugLandspeederNPC");
		}

		StarWarsMod.gaffiStick = new ItemGaffiStick();
		GameRegistry.registerItem(StarWarsMod.gaffiStick, "gaffiStick");

		StarWarsMod.lightsaber = new ItemLightsaber();
		GameRegistry.registerItem(StarWarsMod.lightsaber, "lightsaber");

		StarWarsMod.binoculars = new ItemBinocularsTatooine();
		GameRegistry.registerItem(StarWarsMod.binoculars, "binoculars");

		StarWarsMod.binocularsHoth = new ItemBinocularsHoth();
		GameRegistry.registerItem(StarWarsMod.binocularsHoth, "binocularsHoth");

		StarWarsMod.lightsaberOff = new ItemLightsaberOff();
		GameRegistry.registerItem(StarWarsMod.lightsaberOff, "lightsaberOff");

		StarWarsMod.blasterPistol = new ItemBlasterPistol();
		GameRegistry.registerItem(StarWarsMod.blasterPistol, "blasterPistol");

		StarWarsMod.blasterHeavy = new ItemBlasterHeavy();
		GameRegistry.registerItem(StarWarsMod.blasterHeavy, "blasterHeavy");

		StarWarsMod.hiltMetelCompound = new ItemHiltMetalCompound();
		GameRegistry.registerItem(StarWarsMod.hiltMetelCompound, "hiltMetalCompound");

		StarWarsMod.hiltMetelAlloy = new ItemHiltMetalAlloy();
		GameRegistry.registerItem(StarWarsMod.hiltMetelAlloy, "hiltMetalAlloy");

		StarWarsMod.plasmaEmitter = new ItemPlasmaEmitter();
		GameRegistry.registerItem(StarWarsMod.plasmaEmitter, "plasmaEmitter");

		StarWarsMod.bowcaster = new ItemWookieeBowcaster();
		GameRegistry.registerItem(StarWarsMod.bowcaster, "bowcaster");

		StarWarsMod.containmentField = new ItemContainmentField();
		GameRegistry.registerItem(StarWarsMod.containmentField, "containmentField");

		StarWarsMod.lightsaberCrystal = new ItemLightsaberCrystal();
		GameRegistry.registerItem(StarWarsMod.lightsaberCrystal, "lightsaberCrystal");

		StarWarsMod.blasterBolt = new ItemBlasterBolt();
		GameRegistry.registerItem(StarWarsMod.blasterBolt, "blasterBolt");

		StarWarsMod.blasterRifleBolt = new ItemBlasterRifleBolt();
		GameRegistry.registerItem(StarWarsMod.blasterRifleBolt, "blasterRifleBolt");

		StarWarsMod.ewokSpear = new ItemEwokSpear();
		GameRegistry.registerItem(StarWarsMod.ewokSpear, "ewokSpear");

		StarWarsMod.gamorreanAx = new ItemGamorreanAx();
		GameRegistry.registerItem(StarWarsMod.gamorreanAx, "gamorreanAx");

		StarWarsMod.banthaHorn = new ItemBanthaHorn();
		GameRegistry.registerItem(StarWarsMod.banthaHorn, "banthaHorn");

		StarWarsMod.banthaMilk = new ItemBanthaMilk();
		GameRegistry.registerItem(StarWarsMod.banthaMilk, "banthaMilk");

		StarWarsMod.acidBeets = new ItemAcidBeets();
		GameRegistry.registerItem(StarWarsMod.acidBeets, "acidBeets");

		StarWarsMod.banthaPlatter = new ItemBanthaPlatter();
		GameRegistry.registerItem(StarWarsMod.banthaPlatter, "banthaPlatter");

		StarWarsMod.canron = new ItemCanron();
		GameRegistry.registerItem(StarWarsMod.canron, "canron");

		StarWarsMod.chasuka = new ItemChasuka();
		GameRegistry.registerItem(StarWarsMod.chasuka, "chasuka");

		StarWarsMod.dewbackRibs = new ItemDewbackRibs();
		GameRegistry.registerItem(StarWarsMod.dewbackRibs, "dewbackRibs");

		StarWarsMod.gorrnar = new ItemGorrnar();
		GameRegistry.registerItem(StarWarsMod.gorrnar, "gorrnar");

		StarWarsMod.jediRobes = new ArmorJediRobes(StarWarsMod.jediRobesMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.jediRobes, "jediRobes");

		StarWarsMod.lightJediRobes = new ArmorLightJediRobes(StarWarsMod.jediRobesMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.lightJediRobes, "lightJediRobes");

		StarWarsMod.endorHelmet = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.endorHelmet, "endorHelmet");

		StarWarsMod.endorChest = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.endorChest, "endorChest");

		StarWarsMod.endorLegs = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.endorLegs, "endorLegs");

		StarWarsMod.endorBoots = new ArmorEndor(StarWarsMod.endorArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.endorBoots, "endorBoots");

		StarWarsMod.hothHelmet = new ArmorHoth(StarWarsMod.hothArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.hothHelmet, "hothHelmet");

		StarWarsMod.hothChest = new ArmorHoth(StarWarsMod.hothArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.hothChest, "hothChest");

		StarWarsMod.hothLegs = new ArmorHoth(StarWarsMod.hothArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.hothLegs, "hothLegs");

		StarWarsMod.hothBoots = new ArmorHoth(StarWarsMod.hothArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.hothBoots, "hothBoots");

		StarWarsMod.scoutTrooperHelmet = new ArmorScoutTrooper(StarWarsMod.scoutTrooperArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.scoutTrooperHelmet, "scoutTrooperHelmet");

		StarWarsMod.scoutTrooperChest = new ArmorScoutTrooper(StarWarsMod.scoutTrooperArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.scoutTrooperChest, "scoutTrooperChest");

		StarWarsMod.scoutTrooperLegs = new ArmorScoutTrooper(StarWarsMod.scoutTrooperArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.scoutTrooperLegs, "scoutTrooperLegs");

		StarWarsMod.scoutTrooperBoots = new ArmorScoutTrooper(StarWarsMod.scoutTrooperArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.scoutTrooperBoots, "scoutTrooperBoots");

		StarWarsMod.sandtrooperHelmet = new ArmorSandtrooper(StarWarsMod.sandtrooperArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.sandtrooperHelmet, "sandtrooperHelmet");

		StarWarsMod.sandtrooperChest = new ArmorSandtrooper(StarWarsMod.sandtrooperArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.sandtrooperChest, "sandtrooperChest");

		StarWarsMod.sandtrooperLegs = new ArmorSandtrooper(StarWarsMod.sandtrooperArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.sandtrooperLegs, "sandtrooperLegs");

		StarWarsMod.sandtrooperBoots = new ArmorSandtrooper(StarWarsMod.sandtrooperArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.sandtrooperBoots, "sandtrooperBoots");

		StarWarsMod.snowtrooperHelmet = new ArmorSnowtrooper(StarWarsMod.snowtrooperArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.snowtrooperHelmet, "snowtrooperHelmet");

		StarWarsMod.snowtrooperChest = new ArmorSnowtrooper(StarWarsMod.snowtrooperArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.snowtrooperChest, "snowtrooperChest");

		StarWarsMod.snowtrooperLegs = new ArmorSnowtrooper(StarWarsMod.snowtrooperArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.snowtrooperLegs, "snowtrooperLegs");

		StarWarsMod.snowtrooperBoots = new ArmorSnowtrooper(StarWarsMod.snowtrooperArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.snowtrooperBoots, "snowtrooperBoots");

		StarWarsMod.bobaHelmet = new ArmorBoba(StarWarsMod.bobaArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.bobaHelmet, "bobaHelmet");

		StarWarsMod.bobaChest = new ArmorBoba(StarWarsMod.bobaArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.bobaChest, "bobaChest");

		StarWarsMod.bobaJetpackChest = new ArmorBobaJetpack(StarWarsMod.bobaArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.bobaJetpackChest, "bobaJetpackChest");

		StarWarsMod.bobaJetpack = new ItemBobaJetpack();
		GameRegistry.registerItem(StarWarsMod.bobaJetpack, "bobaJetpack");

		StarWarsMod.bobaLegs = new ArmorBoba(StarWarsMod.bobaArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.bobaLegs, "bobaLegs");

		StarWarsMod.bobaBoots = new ArmorBoba(StarWarsMod.bobaArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.bobaBoots, "bobaBoots");

		StarWarsMod.rebelPilotHelmet = new ArmorRebelPilot(StarWarsMod.rebelPilotArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.rebelPilotHelmet, "rebelPilotHelmet");

		StarWarsMod.rebelPilotChest = new ArmorRebelPilot(StarWarsMod.rebelPilotArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.rebelPilotChest, "rebelPilotChest");

		StarWarsMod.rebelPilotLegs = new ArmorRebelPilot(StarWarsMod.rebelPilotArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.rebelPilotLegs, "rebelPilotLegs");

		StarWarsMod.rebelPilotBoots = new ArmorRebelPilot(StarWarsMod.rebelPilotArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.rebelPilotBoots, "rebelPilotBoots");

		StarWarsMod.fleetHelmet = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.fleetHelmet, "fleetHelmet");

		StarWarsMod.fleetChest = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.fleetChest, "fleetChest");

		StarWarsMod.fleetLegs = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.fleetLegs, "fleetLegs");

		StarWarsMod.fleetBoots = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.fleetBoots, "fleetBoots");

		StarWarsMod.atatPilotHelmet = new ArmorHothPilot(StarWarsMod.atatPilotArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.atatPilotHelmet, "atatPilotHelmet");

		StarWarsMod.atatPilotChest = new ArmorHothPilot(StarWarsMod.atatPilotArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.atatPilotChest, "atatPilotChest");

		StarWarsMod.atatPilotLegs = new ArmorHothPilot(StarWarsMod.atatPilotArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.atatPilotLegs, "atatPilotLegs");

		StarWarsMod.atatPilotBoots = new ArmorHothPilot(StarWarsMod.atatPilotArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.atatPilotBoots, "atatPilotBoots");

		StarWarsMod.tiePilotHelmet = new ArmorTiePilot(StarWarsMod.tiePilotArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.tiePilotHelmet, "tiePilotHelmet");

		StarWarsMod.tiePilotChest = new ArmorTiePilot(StarWarsMod.tiePilotArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.tiePilotChest, "tiePilotChest");

		StarWarsMod.tiePilotLegs = new ArmorTiePilot(StarWarsMod.tiePilotArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.tiePilotLegs, "tiePilotLegs");

		StarWarsMod.tiePilotBoots = new ArmorTiePilot(StarWarsMod.tiePilotArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.tiePilotBoots, "tiePilotBoots");

		StarWarsMod.stormtrooperHelmet = new ArmorStormtrooper(StarWarsMod.stormtrooperArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.stormtrooperHelmet, "stormtrooperHelmet");

		StarWarsMod.stormtrooperChest = new ArmorStormtrooper(StarWarsMod.stormtrooperArmorMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.stormtrooperChest, "stormtrooperChest");

		StarWarsMod.stormtrooperLegs = new ArmorStormtrooper(StarWarsMod.stormtrooperArmorMat, 1, 2);
		GameRegistry.registerItem(StarWarsMod.stormtrooperLegs, "stormtrooperLegs");

		StarWarsMod.stormtrooperBoots = new ArmorStormtrooper(StarWarsMod.stormtrooperArmorMat, 1, 3);
		GameRegistry.registerItem(StarWarsMod.stormtrooperBoots, "stormtrooperBoots");

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

		StarWarsMod.spawnHothSpeederBike = new ItemSpawnHothSpeederBike();
		GameRegistry.registerItem(StarWarsMod.spawnHothSpeederBike, "spawnHothSpeederBike");

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

		StarWarsMod.hyperdriveEndor = new ItemHyperdriveEndor();
		GameRegistry.registerItem(StarWarsMod.hyperdriveEndor, "hyperdriveEndor");

		StarWarsMod.blasterRifle = new ItemBlasterRifle();
		GameRegistry.registerItem(StarWarsMod.blasterRifle, "blasterRifle");

		StarWarsMod.droidCaller = new ItemDroidCaller();
		GameRegistry.registerItem(StarWarsMod.droidCaller, "droidCaller");

		StarWarsMod.droidHacker = new ItemDroidHacker();
		GameRegistry.registerItem(StarWarsMod.droidHacker, "droidHacker");

		StarWarsMod.spawnAstromech = new ItemSpawnAstromech();
		GameRegistry.registerItem(StarWarsMod.spawnAstromech, "spawnAstromech");

		StarWarsMod.spawnAstromech2 = new ItemSpawnAstromech2();
		GameRegistry.registerItem(StarWarsMod.spawnAstromech2, "spawnAstromech2");

		StarWarsMod.spawnSurgical = new ItemSpawnSurgical();
		GameRegistry.registerItem(StarWarsMod.spawnSurgical, "spawnSurgical");

		StarWarsMod.spawnTreadwell = new ItemSpawnTreadwell();

		StarWarsMod.spawnProtocol = new ItemSpawnProtocol();
		GameRegistry.registerItem(StarWarsMod.spawnProtocol, "spawnProtocol");

		StarWarsMod.spawnProtocol2 = new ItemSpawnProtocol2();
		GameRegistry.registerItem(StarWarsMod.spawnProtocol2, "spawnProtocol2");

		StarWarsMod.spawnMouse = new ItemSpawnMouse();
		GameRegistry.registerItem(StarWarsMod.spawnMouse, "spawnMouse");

		StarWarsMod.spawnProbe = new ItemSpawnProbe();
		GameRegistry.registerItem(StarWarsMod.spawnProbe, "spawnProbe");

		StarWarsMod.spawnGonk = new ItemSpawnGonk();
		GameRegistry.registerItem(StarWarsMod.spawnGonk, "spawnGonk");

		StarWarsMod.imperialCredit = new ItemImperialCredit();
		GameRegistry.registerItem(StarWarsMod.imperialCredit, "imperialCredit");

		StarWarsMod.banthaChop = new ItemBanthaChop();
		GameRegistry.registerItem(StarWarsMod.banthaChop, "banthaChop");

		StarWarsMod.banthaChopCooked = new ItemBanthaChopCooked();
		GameRegistry.registerItem(StarWarsMod.banthaChopCooked, "banthaChopCooked");

		StarWarsMod.waterDroplet = new ItemWaterDroplet();
		GameRegistry.registerItem(StarWarsMod.waterDroplet, "waterDroplet");

		StarWarsMod.leiasBuns = new ArmorAddonBuns(StarWarsMod.leiaBunsArmorMat, 1, 0);
		GameRegistry.registerItem(StarWarsMod.leiasBuns, "leiasBuns");

		StarWarsMod.recordTheme = new ItemMusicDisc("Theme");
		GameRegistry.registerItem(StarWarsMod.recordTheme, "recordTheme");

		StarWarsMod.recordThrone = new ItemMusicDisc("Throne");
		GameRegistry.registerItem(StarWarsMod.recordThrone, "recordThrone");

		StarWarsMod.recordBinary = new ItemMusicDisc("Binary");
		GameRegistry.registerItem(StarWarsMod.recordBinary, "recordBinary");

		StarWarsMod.recordImperial = new ItemMusicDisc("Imperial");
		GameRegistry.registerItem(StarWarsMod.recordImperial, "recordImperial");

		StarWarsMod.recordCantina = new ItemMusicDisc("Cantina");
		GameRegistry.registerItem(StarWarsMod.recordCantina, "recordCantina");

		Lumberjack.info("Items, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\ItemRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */