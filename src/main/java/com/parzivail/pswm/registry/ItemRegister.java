package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.armor.*;
import com.parzivail.pswm.items.*;
import com.parzivail.pswm.items.crafting.*;
import com.parzivail.pswm.items.crafting.ItemPlasmaEmitter;
import com.parzivail.pswm.items.hyperdrive.*;
import com.parzivail.pswm.items.ingot.*;
import com.parzivail.pswm.items.weapons.*;
import com.parzivail.pswm.items.weapons.ItemGaffiStick;
import com.parzivail.pswm.jedirobes.ArmorJediRobes;
import com.parzivail.pswm.vehicles.*;
import com.parzivail.pswm.weaponry.ItemSpawnDSTurret;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegister
{
	public static void registerAll()
	{
		if (Resources.IS_DEV_ENVIRONVENT)
		{
			StarWarsMod.debugLootGen = new ItemDebugLootGen();
			GameRegistry.registerItem(StarWarsMod.debugLootGen, "debugLootGen");

			StarWarsMod.customTest = new ItemCustomTest();
			GameRegistry.registerItem(StarWarsMod.customTest, "customItem");

			StarWarsMod.spawnDsTurret = new ItemSpawnDSTurret();
			GameRegistry.registerItem(StarWarsMod.spawnDsTurret, "spawnDsTurret");

			StarWarsMod.questContainer = new ItemQuestContainer();
			GameRegistry.registerItem(StarWarsMod.questContainer, "questContainer");

			StarWarsMod.slopeWizard = new ItemSlopeWizard();
			GameRegistry.registerItem(StarWarsMod.slopeWizard, "slopeWizard");

			StarWarsMod.spawnAtst = new ItemSpawnATST();
			GameRegistry.registerItem(StarWarsMod.spawnAtst, "spawnAtst");
		}

		if (Resources.IS_SEQUEL_RELEASE)
		{
			StarWarsMod.stormtrooperNewHelmet = new ArmorSequelStormtrooper(StarWarsMod.stormtrooperNewArmorMat, 1, 0);
			GameRegistry.registerItem(StarWarsMod.stormtrooperNewHelmet, "stormtrooperNewHelmet");

			StarWarsMod.stormtrooperNewChest = new ArmorSequelStormtrooper(StarWarsMod.stormtrooperNewArmorMat, 1, 1);
			GameRegistry.registerItem(StarWarsMod.stormtrooperNewChest, "stormtrooperNewChest");

			StarWarsMod.stormtrooperNewLegs = new ArmorSequelStormtrooper(StarWarsMod.stormtrooperNewArmorMat, 1, 2);
			GameRegistry.registerItem(StarWarsMod.stormtrooperNewLegs, "stormtrooperNewLegs");

			StarWarsMod.stormtrooperNewBoots = new ArmorSequelStormtrooper(StarWarsMod.stormtrooperNewArmorMat, 1, 3);
			GameRegistry.registerItem(StarWarsMod.stormtrooperNewBoots, "stormtrooperNewBoots");

			StarWarsMod.stormtrooperSilverNewHelmet = new ArmorSequelStormtrooperSilver(StarWarsMod.stormtrooperNewArmorMat, 1, 0);
			GameRegistry.registerItem(StarWarsMod.stormtrooperSilverNewHelmet, "stormtrooperSilverNewHelmet");

			StarWarsMod.stormtrooperSilverNewChest = new ArmorSequelStormtrooperSilver(StarWarsMod.stormtrooperNewArmorMat, 1, 1);
			GameRegistry.registerItem(StarWarsMod.stormtrooperSilverNewChest, "stormtrooperSilverNewChest");

			StarWarsMod.stormtrooperSilverNewLegs = new ArmorSequelStormtrooperSilver(StarWarsMod.stormtrooperNewArmorMat, 1, 2);
			GameRegistry.registerItem(StarWarsMod.stormtrooperSilverNewLegs, "stormtrooperSilverNewLegs");

			StarWarsMod.stormtrooperSilverNewBoots = new ArmorSequelStormtrooperSilver(StarWarsMod.stormtrooperNewArmorMat, 1, 3);
			GameRegistry.registerItem(StarWarsMod.stormtrooperSilverNewBoots, "stormtrooperSilverNewBoots");

			StarWarsMod.spawnJakkuSpeeder = new ItemSpawnJakkuSpeeder();
			GameRegistry.registerItem(StarWarsMod.spawnJakkuSpeeder, "spawnJakkuSpeeder");

			StarWarsMod.sequelBlasterRifle = new ItemSequelBlasterRifle();
			GameRegistry.registerItem(StarWarsMod.sequelBlasterRifle, "sequelBlasterRifle");

			StarWarsMod.sequelBlasterPistol = new ItemSequelBlasterPistol();
			GameRegistry.registerItem(StarWarsMod.sequelBlasterPistol, "sequelBlasterPistol");

			StarWarsMod.spawnAstromechBb8 = new ItemSpawnAstromechBb8();
			GameRegistry.registerItem(StarWarsMod.spawnAstromechBb8, "spawnAstromechBb8");
		}

		StarWarsMod.spawnTie = new ItemSpawnTIE();
		GameRegistry.registerItem(StarWarsMod.spawnTie, "spawnTIE");

		StarWarsMod.spawnTieAdvanced = new ItemSpawnTIEAdvanced();
		GameRegistry.registerItem(StarWarsMod.spawnTieAdvanced, "spawnTIEAdvanced");

		StarWarsMod.spawnTieInterceptor = new ItemSpawnTIEInterceptor();
		GameRegistry.registerItem(StarWarsMod.spawnTieInterceptor, "spawnTIEInterceptor");

		StarWarsMod.spawnXwing = new ItemSpawnXWing();
		GameRegistry.registerItem(StarWarsMod.spawnXwing, "spawnXWing");

		StarWarsMod.spawnSkyhopper = new ItemSpawnSkyhopper();
		GameRegistry.registerItem(StarWarsMod.spawnSkyhopper, "spawnSkyhopper");

		StarWarsMod.spawnSnowspeeder = new ItemSpawnSnowspeeder();
		GameRegistry.registerItem(StarWarsMod.spawnSnowspeeder, "spawnSnowspeeder");

		StarWarsMod.spawnAwing = new ItemSpawnAWing();
		GameRegistry.registerItem(StarWarsMod.spawnAwing, "spawnAWing");

		StarWarsMod.gaffiStick = new ItemGaffiStick();
		GameRegistry.registerItem(StarWarsMod.gaffiStick, "gaffiStick");

		// StarWarsMod.lightsaber = new ItemOldLightsaber();
		// GameRegistry.registerItem(StarWarsMod.lightsaber, "lightsaber");

		for (int i = 0; i < StarWarsMod.lightsaberNew.length; i++)
		{
			StarWarsMod.lightsaberNew[i] = new ItemLightsaber(i);
			GameRegistry.registerItem(StarWarsMod.lightsaberNew[i], "lightsaberNew" + String.valueOf(i));
		}

		// StarWarsMod.lightsaberOff = new ItemLightsaberOff();
		// GameRegistry.registerItem(StarWarsMod.lightsaberOff,
		// "lightsaberOff");

		StarWarsMod.binoculars = new ItemBinocularsTatooine();
		GameRegistry.registerItem(StarWarsMod.binoculars, "binoculars");

		StarWarsMod.idScanner = new ItemIDScanner();
		GameRegistry.registerItem(StarWarsMod.idScanner, "idScanner");

		StarWarsMod.hydrospanner = new ItemHydrospanner();
		GameRegistry.registerItem(StarWarsMod.hydrospanner, "hydrospanner");

		StarWarsMod.ingotBene = new ItemBeneIngot();
		GameRegistry.registerItem(StarWarsMod.ingotBene, "ingotBene");

		StarWarsMod.ingotCortosis = new ItemCortosisIngot();
		GameRegistry.registerItem(StarWarsMod.ingotCortosis, "ingotCortosis");

		StarWarsMod.ingotDolomite = new ItemDolomiteIngot();
		GameRegistry.registerItem(StarWarsMod.ingotDolomite, "ingotDolomite");

		StarWarsMod.ingotExonium = new ItemExoniumIngot();
		GameRegistry.registerItem(StarWarsMod.ingotExonium, "ingotExonium");

		StarWarsMod.ingotHelicite = new ItemHeliciteIngot();
		GameRegistry.registerItem(StarWarsMod.ingotHelicite, "ingotHelicite");

		StarWarsMod.ingotIonite = new ItemIoniteIngot();
		GameRegistry.registerItem(StarWarsMod.ingotIonite, "ingotIonite");

		StarWarsMod.ingotKelerium = new ItemKeleriumIngot();
		GameRegistry.registerItem(StarWarsMod.ingotKelerium, "ingotKelerium");

		StarWarsMod.ingotRubindum = new ItemRubindumIngot();
		GameRegistry.registerItem(StarWarsMod.ingotRubindum, "ingotRubindum");

		StarWarsMod.binocularsHoth = new ItemBinocularsHoth();
		GameRegistry.registerItem(StarWarsMod.binocularsHoth, "binocularsHoth");

		StarWarsMod.blasterPistol = new ItemBlasterPistol();
		GameRegistry.registerItem(StarWarsMod.blasterPistol, "blasterPistol");

		StarWarsMod.blasterRifle = new ItemBlasterRifle();
		GameRegistry.registerItem(StarWarsMod.blasterRifle, "blasterRifle");

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

		// StarWarsMod.blasterTIEBolt = new ItemBolt("blasterTIEBolt");
		// GameRegistry.registerItem(StarWarsMod.blasterTIEBolt,
		// "blasterTIEBolt");

		// StarWarsMod.blasterXWingBolt = new ItemBolt("blasterXWingBolt");
		// GameRegistry.registerItem(StarWarsMod.blasterXWingBolt,
		// "blasterXWingBolt");

		// StarWarsMod.blasterBolt = new ItemBolt("blasterBolt");
		// GameRegistry.registerItem(StarWarsMod.blasterBolt, "blasterBolt");

		// StarWarsMod.blasterRifleBolt = new ItemBolt("blasterRifleBolt");
		// GameRegistry.registerItem(StarWarsMod.blasterRifleBolt,
		// "blasterRifleBolt");

		StarWarsMod.ewokSpear = new ItemEwokSpear();
		GameRegistry.registerItem(StarWarsMod.ewokSpear, "ewokSpear");

		StarWarsMod.gamorreanAx1 = new ItemGamorreanAx1();
		GameRegistry.registerItem(StarWarsMod.gamorreanAx1, "gamorreanAx");

		StarWarsMod.vibroLance = new ItemVibroLance();
		GameRegistry.registerItem(StarWarsMod.vibroLance, "vibroLance");

		StarWarsMod.gamorreanAx3 = new ItemGamorreanAx3();
		GameRegistry.registerItem(StarWarsMod.gamorreanAx3, "gamorreanAx3");

		StarWarsMod.gamorreanAx2 = new ItemGamorreanAx2();
		GameRegistry.registerItem(StarWarsMod.gamorreanAx2, "gamorreanAx2");

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

		StarWarsMod.jediRobes = new ArmorJediRobes();
		GameRegistry.registerItem(StarWarsMod.jediRobes, "newJediRobes");

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

		//StarWarsMod.fleetHelmet = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 0);
		//GameRegistry.registerItem(StarWarsMod.fleetHelmet, "fleetHelmet");

		//StarWarsMod.fleetChest = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 1);
		//GameRegistry.registerItem(StarWarsMod.fleetChest, "fleetChest");

		//StarWarsMod.fleetLegs = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 2);
		//GameRegistry.registerItem(StarWarsMod.fleetLegs, "fleetLegs");

		//StarWarsMod.fleetBoots = new ArmorRebelFleet(StarWarsMod.fleetArmorMat, 1, 3);
		//GameRegistry.registerItem(StarWarsMod.fleetBoots, "fleetBoots");

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

		StarWarsMod.hyperdriveMustafar = new ItemHyperdriveMustafar();
		GameRegistry.registerItem(StarWarsMod.hyperdriveMustafar, "hyperdriveMustafar");

		StarWarsMod.hyperdriveIlum = new ItemHyperdriveIlum();
		GameRegistry.registerItem(StarWarsMod.hyperdriveIlum, "hyperdriveIlum");

		StarWarsMod.hyperdriveDagobah = new ItemHyperdriveDagobah();
		GameRegistry.registerItem(StarWarsMod.hyperdriveDagobah, "hyperdriveDagobah");

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

		StarWarsMod.droidCaller = new ItemDroidCaller();
		GameRegistry.registerItem(StarWarsMod.droidCaller, "droidCaller");

		StarWarsMod.droidHacker = new ItemDroidHacker();
		GameRegistry.registerItem(StarWarsMod.droidHacker, "droidHacker");

		StarWarsMod.spawnAstromech = new ItemSpawnAstromech();
		GameRegistry.registerItem(StarWarsMod.spawnAstromech, "spawnAstromech");

		StarWarsMod.spawnAstromechImperial = new ItemSpawnAstromechImperial();
		GameRegistry.registerItem(StarWarsMod.spawnAstromechImperial, "spawnAstromechImperial");

		StarWarsMod.spawnAstromechImperial2 = new ItemSpawnAstromechImperial2();
		GameRegistry.registerItem(StarWarsMod.spawnAstromechImperial2, "spawnAstromechImperial2");

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

		StarWarsMod.silverImperialCredit = new ItemSilverImperialCredit();
		GameRegistry.registerItem(StarWarsMod.silverImperialCredit, "silverImperialCredit");

		StarWarsMod.goldImperialCredit = new ItemGoldImperialCredit();
		GameRegistry.registerItem(StarWarsMod.goldImperialCredit, "goldImperialCredit");

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