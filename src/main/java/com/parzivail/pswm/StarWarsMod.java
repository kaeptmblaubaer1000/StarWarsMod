package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.commands.CommandJediRobes;
import com.parzivail.pswm.dimension.PlanetInformation;
import com.parzivail.pswm.exception.UserError;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.handlers.CommonEventHandler;
import com.parzivail.pswm.handlers.GuiHandler;
import com.parzivail.pswm.items.crafting.ItemLightsaberCrystal;
import com.parzivail.pswm.items.weapons.*;
import com.parzivail.pswm.network.*;
import com.parzivail.pswm.registry.*;
import com.parzivail.pswm.tabs.SequelStarWarsTab;
import com.parzivail.pswm.tabs.StarWarsTab;
import com.parzivail.pswm.tabs.StarWarsTabBlocks;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

@Mod(modid = Resources.MODID,
     version = Resources.VERSION,
     name = "Parzi's Star Wars Mod",
     acceptedMinecraftVersions = "[1.7.10]")
public class StarWarsMod
{
	public static boolean hasShownNeedUpdate = false;
	public static boolean hasShownLeaderboardPart = false;

	public static Configuration config;

	public static int packetId = 0;

	public static Random rngGeneral = new Random();
	public static Random rngChromium = new Random();
	public static Random rngTitanium = new Random();

	@Mod.Instance(Resources.MODID)
	public static StarWarsMod instance;

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;

	public static ClientEventHandler clientHandler;
	public static CommonEventHandler commonHandler;

	@SidedProxy(clientSide = "com.parzivail.pswm.StarWarsClientProxy",
	            serverSide = "com.parzivail.pswm.StarWarsCommonProxy")
	public static StarWarsCommonProxy proxy;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs StarWarsTab;
	public static CreativeTabs StarWarsTabBlocks;
	public static CreativeTabs SequelStarWarsTab;

	public static ItemGaffiStick gaffiStick;
	public static ItemOldLightsaber lightsaber;
	public static ItemLightsaber[] lightsaberNew = new ItemLightsaber[ItemLightsaber.hilts.length];
	public static ItemLightsaberOff lightsaberOff;
	public static ItemBlasterPistol blasterPistol;
	public static ItemBlasterRifle blasterRifle;
	public static ItemSequelBlasterRifle sequelBlasterRifle;
	public static ItemSequelBlasterPistol sequelBlasterPistol;
	public static ItemBlasterHeavy blasterHeavy;
	public static ItemEwokSpear ewokSpear;
	public static ItemWookieeBowcaster bowcaster;
	public static ItemGamorreanAx1 gamorreanAx1;
	public static ItemGamorreanAx2 gamorreanAx2;
	public static ItemGamorreanAx3 gamorreanAx3;
	public static ItemVibroLance vibroLance;
	public static ItemLightsaberCrystal lightsaberCrystal;

	public static Item customTest;

	public static Item hiltMetelCompound;
	public static Item hiltMetelAlloy;
	public static Item plasmaEmitter;
	public static Item containmentField;
	public static Item blasterXWingBolt;
	public static Item blasterTIEBolt;
	public static Item blasterBolt;
	public static Item blasterRifleBolt;
	public static Item banthaHorn;
	public static Item droidCaller;
	public static Item droidHacker;
	public static Item imperialCredit;
	public static Item silverImperialCredit;
	public static Item goldImperialCredit;
	public static Item waterDroplet;

	public static Item binoculars;
	public static Item binocularsHoth;

	public static Item debugLootGen;

	public static Item chromiumDust;
	public static Item titaniumDust;
	public static Item titaniumChromiumDust;
	public static Item titaniumChromiumIngot;

	public static Item ingotCortosis;
	public static Item ingotBene;
	public static Item ingotDolomite;
	public static Item ingotExonium;
	public static Item ingotHelicite;
	public static Item ingotIonite;
	public static Item ingotKelerium;
	public static Item ingotRubindum;

	public static Item hyperdriveMotivator;
	public static Item hyperdriveEngine;
	public static Item hyperdriveEarth;
	public static Item hyperdriveTatooine;
	public static Item hyperdriveHoth;
	public static Item hyperdriveKashyyyk;
	public static Item hyperdriveYavin4;
	public static Item hyperdriveEndor;
	public static Item hyperdriveIlum;
	public static Item hyperdriveDagobah;
	public static Item hyperdriveMustafar;

	public static Item spawnSpeederBike;
	public static Item spawnJakkuSpeeder;
	public static Item spawnHothSpeederBike;
	public static Item spawnLandspeeder;
	public static Item spawnTie;
	public static Item spawnTieAdvanced;
	public static Item spawnTieInterceptor;
	public static Item spawnAwing;
	public static Item spawnXwing;
	public static Item spawnSkyhopper;
	public static Item spawnAtst;
	public static Item spawnSnowspeeder;
	public static Item spawnDsTurret;
	public static Item spawnAstromech;
	public static Item spawnAstromechImperial;
	public static Item spawnAstromechImperial2;
	public static Item spawnAstromech2;
	public static Item spawnAstromechBb8;
	public static Item spawnProtocol;
	public static Item spawnProtocol2;
	public static Item spawnProbe;
	public static Item spawnMouse;
	public static Item spawnGonk;
	public static Item spawnSurgical;
	public static Item spawnTreadwell;
	public static Item binocularsNew;

	public static Item jediRobes;

	public static Item recordTheme;
	public static Item recordThrone;
	public static Item recordBinary;
	public static Item recordImperial;
	public static Item recordCantina;

	public static Item endorHelmet;
	public static Item endorChest;
	public static Item endorLegs;
	public static Item endorBoots;

	public static Item rebelPilotHelmet;
	public static Item rebelPilotChest;
	public static Item rebelPilotLegs;
	public static Item rebelPilotBoots;

	public static Item stormtrooperHelmet;
	public static Item stormtrooperChest;
	public static Item stormtrooperLegs;
	public static Item stormtrooperBoots;

	public static Item stormtrooperNewHelmet;
	public static Item stormtrooperNewChest;
	public static Item stormtrooperNewLegs;
	public static Item stormtrooperNewBoots;

	public static Item stormtrooperSilverNewHelmet;
	public static Item stormtrooperSilverNewChest;
	public static Item stormtrooperSilverNewLegs;
	public static Item stormtrooperSilverNewBoots;

	public static Item snowtrooperHelmet;
	public static Item snowtrooperChest;
	public static Item snowtrooperLegs;
	public static Item snowtrooperBoots;

	public static Item scoutTrooperHelmet;
	public static Item scoutTrooperChest;
	public static Item scoutTrooperLegs;
	public static Item scoutTrooperBoots;

	public static Item sandtrooperHelmet;
	public static Item sandtrooperChest;
	public static Item sandtrooperLegs;
	public static Item sandtrooperBoots;

	public static Item bobaHelmet;
	public static Item bobaChest;
	public static Item bobaJetpack;
	public static Item bobaJetpackChest;
	public static Item bobaLegs;
	public static Item bobaBoots;

	public static Item tiePilotHelmet;
	public static Item tiePilotChest;
	public static Item tiePilotLegs;
	public static Item tiePilotBoots;

	public static Item fleetHelmet;
	public static Item fleetChest;
	public static Item fleetLegs;
	public static Item fleetBoots;

	public static Item atatPilotHelmet;
	public static Item atatPilotChest;
	public static Item atatPilotLegs;
	public static Item atatPilotBoots;

	public static Item hothHelmet;
	public static Item hothChest;
	public static Item hothLegs;
	public static Item hothBoots;

	public static Item leiasBuns;

	public static Item questContainer;

	public static Item idScanner;
	public static Item hydrospanner;
	public static Item powerpack;

	public static Item slopeWizard;

	public static ItemFood banthaChop;
	public static ItemFood banthaChopCooked;
	public static ItemFood banthaMilk;
	public static ItemFood acidBeets;
	public static ItemFood banthaPlatter;
	public static ItemFood canron;
	public static ItemFood chasuka;
	public static ItemFood dewbackRibs;
	public static ItemFood gorrnar;

	public static BiomeGenBase biomeTatooine;
	public static BiomeGenBase biomeHoth;
	public static BiomeGenBase biomeKashyyyk;
	public static BiomeGenBase biomeYavin4;
	public static BiomeGenBase biomeEndor;
	public static BiomeGenBase biomeDagobah;
	public static BiomeGenBase biomeIlum;
	public static BiomeGenBase biomeMustafar;

	public static boolean isOverlayOnscreen = false;

	public static Block blockMV;
	public static Block blockAntenna;
	public static Block blockFieldEmitter;
	public static Block blockDeathStarDoor;
	public static Block blockHoloTable;
	public static Block blockTable;
	public static Block blockTable2;
	public static Block blockCrystalOre;
	public static Block blockChromiumOre;
	public static Block blockTitaniumOre;
	public static Block blockTitaniumChromiumBlock;
	public static Block blockDeathStarGlass;
	public static Block blockEndorBaseWall;
	public static Block blockEndorBaseWallStairs;
	public static Block blockMudStairs;
	public static Block blockDeathStarLight;
	public static Block blockDeathStarBlock;
	public static Block blockTatooineSand;
	public static Block blockTatooineSandstone;
	public static Block blockIlumStone;
	public static Block blockSpaceLamp;
	public static Block blockDagobahMud;
	public static Block blockHangingCauldron;
	public static Block blockHangingBucket;
	public static Block blockBasket;
	public static Block blockBactaTank;

	public static Block blockBeneOre;
	public static Block blockCortosisOre;
	public static Block blockDolomiteOre;
	public static Block blockExoniumOre;
	public static Block blockHeliciteOre;
	public static Block blockIoniteOre;
	public static Block blockKeleriumOre;
	public static Block blockRubindumOre;

	public static Block blockTempleStone;
	public static Block blockTempleStoneSlab;
	public static Block blockTempleStoneLit;
	public static Block blockTempleStoneSlabLit;

	public static Block blockTempleStoneMH;

	public static Block blockTempleStoneStairs;
	public static Block blockTempleStoneStairsBrick;
	public static Block blockTempleStoneStairsFancy;
	public static Block blockTempleStoneStairsSlabTop;
	public static Block blockTempleStoneStairsSlabTopDark;

	public static Block blockAncientJediStatue;
	public static Block blockStaticNpc;
	public static Block blockHyperdrive;

	public static Item.ToolMaterial materialGaffi;
	public static Item.ToolMaterial materialEwok;
	public static Item.ToolMaterial materialGamorrean;
	public static Item.ToolMaterial materialPlasma;
	public static Item.ToolMaterial materialPlasmaOff;
	public static Item.ToolMaterial materialNoDamage;

	public static ArmorMaterial jediRobesMat;
	public static ArmorMaterial endorArmorMat;
	public static ArmorMaterial fleetArmorMat;
	public static ArmorMaterial rebelPilotArmorMat;
	public static ArmorMaterial stormtrooperArmorMat;
	public static ArmorMaterial stormtrooperNewArmorMat;
	public static ArmorMaterial snowtrooperArmorMat;
	public static ArmorMaterial scoutTrooperArmorMat;
	public static ArmorMaterial tiePilotArmorMat;
	public static ArmorMaterial atatPilotArmorMat;
	public static ArmorMaterial hothArmorMat;
	public static ArmorMaterial sandtrooperArmorMat;
	public static ArmorMaterial bobaArmorMat;
	public static ArmorMaterial leiaBunsArmorMat;

	public static DamageSource blasterDamageSource;
	public static DamageSource saberDamageSource;

	public StarWarsMod()
	{
		Lumberjack.info("========== Begin Parzi's Star Wars Mod constructor ==========");
		this.checkJavaVersion();
		this.checkModVersion();
		Lumberjack.info("========== Begin Parzi's Star Wars Mod constructor ==========");
	}

	private void checkCompat()
	{
		boolean flag = false;
		ArrayList<String> m = new ArrayList<>();
		for (String mod : Resources.checkCompatList)
			if (Loader.isModLoaded(mod))
			{
				flag = true;
				m.add(mod);
			}
		if (flag)
		{
			Lumberjack.warn("WARNING! It is known that Parzi's Star Wars Mod may have game-breaking issues when played with the following mods:");
			Lumberjack.warn("-> " + String.join(", ", m));
			Lumberjack.warn("Please report any issues to our GitHub: https://github.com/Parzivail-Modding-Team/ParziStarWarsMod/issues");
		}
	}

	private void checkJavaVersion()
	{
		String versionString = System.getProperty("java.version");
		int pos = versionString.indexOf('.');
		pos = versionString.indexOf('.', pos + 1);
		double version = Double.parseDouble(versionString.substring(0, pos));
		if (version < 1.8)
		{
			Lumberjack.log("######################################PSWM ERROR####################################");
			Lumberjack.log("Parzi's Star Wars Mod requires Java 1.8 or above. You are currently using Java " + version);
			Lumberjack.log("Minecraft will now halt. Download and install Java 1.8.");
			Lumberjack.log("NOTE to MultiMC Users: make sure MultiMC is using the correct Java as default!");
			Lumberjack.log("####################################END PSWM ERROR##################################");
			FMLCommonHandler.instance().exitJava(0, false);
		}
		else
		{
			Lumberjack.log("Confirmed client using Java 1.8+");
		}
	}

	private void checkModVersion()
	{
		InputStream in = null;
		try
		{
			in = new URL(Resources.remoteVersionLink).openStream();
			Resources.ONLINE_VERSION = IOUtils.toString(in).replace("\n", "");
			if (!Resources.VERSION.equalsIgnoreCase(Resources.ONLINE_VERSION))
				Lumberjack.log("New version of Parzi's Star Wars Mod available: " + Resources.ONLINE_VERSION + "!");
		}
		catch (Exception e)
		{
			Lumberjack.warn("Couldn't check version!");
		}
		finally
		{
			if (in != null)
				IOUtils.closeQuietly(in);
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Lumberjack.info("========== Begin Parzi's Star Wars Mod init() ==========");

		Lumberjack.info("This is Parzi's Star Wars Mod v" + Resources.VERSION);

		instance = this;

		//test comment

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		StarWarsMod.commonHandler = new CommonEventHandler();
		StarWarsMod.clientHandler = new ClientEventHandler();

		FMLCommonHandler.instance().bus().register(StarWarsMod.commonHandler);
		MinecraftForge.EVENT_BUS.register(StarWarsMod.clientHandler);

		proxy.doSidedThings();

		EntityRegister.registerAll();

		MaterialRegister.registerAll();

		if (ConfigOptions.enableTabOriginal)
		{
			StarWarsTab = new StarWarsTab();
			StarWarsTabBlocks = new StarWarsTabBlocks();
		}
		else
		{
			StarWarsTab = CreativeTabs.tabAllSearch;
			StarWarsTabBlocks = CreativeTabs.tabAllSearch;
		}

		if (Resources.IS_SEQUEL_RELEASE)
		{
			Lumberjack.log("Sequel update! Suck it, JJ!");
			if (ConfigOptions.enableTabSequel)
				SequelStarWarsTab = new SequelStarWarsTab();
			else
				SequelStarWarsTab = CreativeTabs.tabAllSearch;
		}

		ItemRegister.registerAll();

		BlockRegister.registerAll();

		WorldRegister.registerAll();

		RecipeRegister.registerAll();

		StarWarsAchievements.registerAll();

		DamageSourceRegister.registerAll();

		proxy.registerRendering();

		Lumberjack.info("=========== End Parzi's Star Wars Mod init() ===========");
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws UserError
	{
		Lumberjack.info("========== Begin Parzi's Star Wars Mod preInit() ==========");

		this.checkCompat();

		setupNetworking();

		setupConfig(event);

		Lumberjack.info("=========== End Parzi's Star Wars Mod preInit() ===========");
	}

	private void setupConfig(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile(), Resources.VERSION);
		config.load();

		ConfigOptions.enableTabOriginal = config.get("core", "enableTabOriginal", true).getBoolean();
		ConfigOptions.enableTabSequel = config.get("core", "enableTabSequel", true).getBoolean();
		ConfigOptions.enableBetaFeatures = config.get("core", "enableBetaFeatures", false).getBoolean();
		ConfigOptions.beshOverride = config.get("core", "aurebeshInsteadOfEnglish", false).getBoolean();
		ConfigOptions.enableGlobalLeaderboard = config.get("core", "participateInGlobalLeaderboard", true).getBoolean();

		ConfigOptions.dimTatooineId = config.get("dimensions", "tatooine", 2).getInt();
		ConfigOptions.dimHothId = config.get("dimensions", "hoth", 3).getInt();
		ConfigOptions.dimKashyyykId = config.get("dimensions", "kashyyyk", 4).getInt();
		ConfigOptions.dimYavin4Id = config.get("dimensions", "yavin", 5).getInt();
		ConfigOptions.dimEndorId = config.get("dimensions", "endor", 6).getInt();
		ConfigOptions.dimIlumId = config.get("dimensions", "ilum", 7).getInt();
		ConfigOptions.dimDagobahId = config.get("dimensions", "dagobah", 8).getInt();
		ConfigOptions.dimMustafarId = config.get("dimensions", "mustafar", 9).getInt();

		ConfigOptions.biomeDagobahId = config.get("biomes", "dagobah", 195).getInt();
		ConfigOptions.biomeTatooineId = config.get("biomes", "tatooine", 196).getInt();
		ConfigOptions.biomeHothId = config.get("biomes", "hoth", 197).getInt();
		ConfigOptions.biomeKashyyykId = config.get("biomes", "kashyyyk", 198).getInt();
		ConfigOptions.biomeYavin4Id = config.get("biomes", "yavin", 199).getInt();
		ConfigOptions.biomeEndorId = config.get("biomes", "endor", 200).getInt();
		ConfigOptions.biomeIlumId = config.get("biomes", "ilum", 201).getInt();
		ConfigOptions.biomeMustafarId = config.get("biomes", "mustafar", 202).getInt();

		ConfigOptions.enableCreditsOverlay = config.get("gui", "enableGuiOverlay", true).getBoolean();

		ConfigOptions.lightsaberDamage = config.get("items", "lightsaberDamage", 26).getInt();
		ConfigOptions.enableLightsaber = config.get("items", "enableLightsaberRecipe", true).getBoolean();
		ConfigOptions.enableLightsaberHum = config.get("items", "enableLightsaberIdleSound", true).getBoolean();
		ConfigOptions.enableBlasterFire = config.get("items", "enableBlasterFire", true).getBoolean();
		ConfigOptions.enableLightsaberStrobe = config.get("items", "enableLightsaberAnimation", true).getBoolean();
		ConfigOptions.enableBuckets = config.get("items", "enableGettingThatDumbFreeBucketFromWaterDroplets", true).getBoolean();

		Resources.planetTextures.put(Resources.ConfigOptions.dimAlderaanId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetAlderaan.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimBespinId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetBespin.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimHothId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetHoth.png"));
		Resources.planetTextures.put(0, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEarth.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimCoruscantId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetCoruscant.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimDagobahId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDagobah.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimDathomirId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDathomir.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimEndorId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEndor.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimGeonosisId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetGeonosis.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimTatooineId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTatooine.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimRylothId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetRyloth.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimIlumId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetIlum.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimKaminoId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKamino.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimKashyyykId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKashyyyk.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimKesselId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKessel.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimMandaloreId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMandalore.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimMonCalamariId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMonCalamari.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimMustafarId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMustafar.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimNabooId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetNaboo.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimSullustId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetSullust.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimUtapauId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetUtapau.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimYavin4Id, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetYavin4.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimJakkuId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetJakku.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimTakodanaId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTakodana.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimDQarId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDQar.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimAhchToId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetAhchTo.png"));
		Resources.planetTextures.put(Resources.ConfigOptions.dimDeathStarId, new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDeathStar.png"));

		Resources.planetInformation = new ArrayList<>();

		PlanetInformation alderaan = new PlanetInformation();
		alderaan.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetAlderaan.png"));
		alderaan.setDimensionId(Resources.ConfigOptions.dimAlderaanId);
		alderaan.setName("Alderaan");
		alderaan.setPosition(7.1f, 5.1f);
		alderaan.setAffiliation(Resources.allegianceNone);
		alderaan.setDescription("");
		alderaan.setObfuscated(true);
		Resources.planetInformation.add(alderaan);

		PlanetInformation bespin = new PlanetInformation();
		bespin.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetBespin.png"));
		bespin.setDimensionId(Resources.ConfigOptions.dimBespinId);
		bespin.setName("Bespin");
		bespin.setPosition(4.9f, 13.3f);
		bespin.setAffiliation(Resources.allegianceNone);
		bespin.setDescription("");
		bespin.setObfuscated(true);
		Resources.planetInformation.add(bespin);

		PlanetInformation hoth = new PlanetInformation();
		hoth.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetHoth.png"));
		hoth.setDimensionId(Resources.ConfigOptions.dimHothId);
		hoth.setName("Hoth");
		hoth.setPosition(4.6f, 13.8f);
		hoth.setAffiliation(Resources.allegianceRebel);
		hoth.setDescription("Hoth was the sixth planet of the remote Hoth system. A desolate world covered with ice and snow, located in the Anoat sector, a rarely-traveled portion of the Outer Rim Territories. Home to a large Rebel base.");
		hoth.setSuns(1);
		hoth.setMoons(3);
		hoth.addNativeSpecies("Tauntaun");
		hoth.addNativeSpecies("Wampa");
		hoth.addTerrain("Ice Caves");
		hoth.addTerrain("Tundras");
		hoth.addTerrain("Frozen Plains");
		hoth.addResource("None");
		Resources.planetInformation.add(hoth);

		PlanetInformation earth = new PlanetInformation();
		earth.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEarth.png"));
		earth.setDimensionId(0);
		earth.setName("Earth");
		earth.setPosition(7.4f, 6.8f);
		earth.setAffiliation(Resources.allegianceNone);
		earth.setDescription("The birthplace of the Human Race and the original center of all galactic trade. Not much is known about this planet, and its place in Galactic history is still disputed.");
		earth.addTerrain("Urban");
		earth.addTerrain("Forests");
		earth.addTerrain("Plains");
		earth.addTerrain("Oceans");
		earth.addResource("Coal");
		earth.addResource("Iron");
		earth.addResource("Gold");
		earth.addResource("Diamond");
		earth.addResource("Redstone");
		earth.addResource("Lumber");
		earth.addResource("Water");
		earth.addNativeSpecies("Human");
		earth.setSuns(1);
		earth.setMoons(1);
		Resources.planetInformation.add(earth);

		PlanetInformation coruscant = new PlanetInformation();
		coruscant.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetCoruscant.png"));
		coruscant.setDimensionId(Resources.ConfigOptions.dimCoruscantId);
		coruscant.setName("Coruscant");
		coruscant.setPosition(6.1f, 4.9f);
		coruscant.setAffiliation(Resources.allegianceNone);
		coruscant.setDescription("");
		coruscant.setObfuscated(true);
		Resources.planetInformation.add(coruscant);

		PlanetInformation dagobah = new PlanetInformation();
		dagobah.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDagobah.png"));
		dagobah.setDimensionId(Resources.ConfigOptions.dimDagobahId);
		dagobah.setName("Dagobah");
		dagobah.setPosition(7.5f, 14.4f);
		dagobah.setAffiliation(Resources.allegianceJedi);
		dagobah.setDescription("Dagobah was a planet in the Dagobah system, and one of the purest places in the galaxy within the Force. A remote world of swamps and forests, it served as a refuge for Jedi Grand Master Yoda during his exile after the destruction of the Jedi Order.");
		dagobah.setMoons(1);
		dagobah.setSuns(1);
		dagobah.addNativeSpecies("Snakes");
		dagobah.addTerrain("Swamps");
		dagobah.addTerrain("Bogs");
		dagobah.addTerrain("Jungles");
		dagobah.addResource("None");
		Resources.planetInformation.add(dagobah);

		PlanetInformation dathomir = new PlanetInformation();
		dathomir.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDathomir.png"));
		dathomir.setDimensionId(Resources.ConfigOptions.dimDathomirId);
		dathomir.setName("Dathomir");
		dathomir.setPosition(9.25f, 1.35f);
		dathomir.setAffiliation(Resources.allegianceNone);
		dathomir.setDescription("");
		dathomir.setObfuscated(true);
		Resources.planetInformation.add(dathomir);

		PlanetInformation endor = new PlanetInformation();
		endor.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetEndor.png"));
		endor.setDimensionId(Resources.ConfigOptions.dimEndorId);
		endor.setName("Endor");
		endor.setPosition(2.58f, 11.6f);
		endor.setAffiliation(Resources.allegianceImperial);
		endor.setDescription("Endor (also known as the Forest Moon of Endor and the Sanctuary Moon) was a small forested moon orbiting the gas giant planet of Endor and was the farthest moon away from it. Home to the Headquarters of the Galactic Empire.");
		endor.setSuns(1);
		endor.setMoons(0);
		endor.addNativeSpecies("Ewok");
		endor.addTerrain("Forests");
		endor.addTerrain("Mountains");
		endor.addTerrain("Lakes");
		endor.addResource("None");
		Resources.planetInformation.add(endor);

		PlanetInformation geonosis = new PlanetInformation();
		geonosis.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetGeonosis.png"));
		geonosis.setDimensionId(Resources.ConfigOptions.dimGeonosisId);
		geonosis.setName("Geonosis");
		geonosis.setPosition(12.7f, 11.4f);
		geonosis.setAffiliation(Resources.allegianceNone);
		geonosis.setDescription("");
		geonosis.setObfuscated(true);
		Resources.planetInformation.add(geonosis);

		PlanetInformation tatooine = new PlanetInformation();
		tatooine.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTatooine.png"));
		tatooine.setDimensionId(Resources.ConfigOptions.dimTatooineId);
		tatooine.setName("Tatooine");
		tatooine.setPosition(12.35f, 11.75f);
		tatooine.setAffiliation(Resources.allegianceNone);
		tatooine.setDescription("Tatooine was a sparsely inhabited desert planet located in the galaxy's Outer Rim Territories. Part of a binary star system, the planet was oppressed by a scorching sun, resulting in a lack of necessary surface water.");
		tatooine.setSuns(2);
		tatooine.setMoons(3);
		tatooine.addNativeSpecies("Tusken Raider");
		tatooine.addNativeSpecies("Jawa");
		tatooine.addNativeSpecies("Gamorrean Guard");
		tatooine.addNativeSpecies("Human");
		tatooine.addNativeSpecies("Bith");
		tatooine.addNativeSpecies("Bantha");
		tatooine.addNativeSpecies("Dewback");
		tatooine.addTerrain("Deserts");
		tatooine.addTerrain("Canyons");
		tatooine.addTerrain("Rocky Bluffs");
		tatooine.addResource("Bene");
		Resources.planetInformation.add(tatooine);

		PlanetInformation ryloth = new PlanetInformation();
		ryloth.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetRyloth.png"));
		ryloth.setDimensionId(Resources.ConfigOptions.dimRylothId);
		ryloth.setName("Ryloth");
		ryloth.setPosition(12.75f, 12.7f);
		ryloth.setAffiliation(Resources.allegianceNone);
		ryloth.setDescription("");
		ryloth.setObfuscated(true);
		Resources.planetInformation.add(ryloth);

		PlanetInformation ilum = new PlanetInformation();
		ilum.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetIlum.png"));
		ilum.setDimensionId(Resources.ConfigOptions.dimIlumId);
		ilum.setName("Ilum");
		ilum.setPosition(1.9f, 2.4f);
		ilum.setAffiliation(Resources.allegianceJedi);
		ilum.setDescription("Ilum was an arctic planet located in the Unknown Regions. It was used by the Jedi Order for the Gathering, a rite of passage in which Jedi younglings must find and harvest kyber crystals for their lightsabers.");
		ilum.setSuns(1);
		ilum.setMoons(2);
		ilum.addNativeSpecies("None");
		ilum.addTerrain("Caverns");
		ilum.addTerrain("Crystal Caves");
		ilum.addTerrain("Icy Mountains");
		ilum.addResource("Kyber Crystal");
		Resources.planetInformation.add(ilum);

		PlanetInformation kamino = new PlanetInformation();
		kamino.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKamino.png"));
		kamino.setDimensionId(Resources.ConfigOptions.dimKaminoId);
		kamino.setName("Kamino");
		kamino.setPosition(13.75f, 10.3f);
		kamino.setAffiliation(Resources.allegianceNone);
		kamino.setDescription("");
		kamino.setObfuscated(true);
		Resources.planetInformation.add(kamino);

		PlanetInformation kashyyyk = new PlanetInformation();
		kashyyyk.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKashyyyk.png"));
		kashyyyk.setDimensionId(Resources.ConfigOptions.dimKashyyykId);
		kashyyyk.setName("Kashyyyk");
		kashyyyk.setPosition(10.75f, 4.7f);
		kashyyyk.setAffiliation(Resources.allegianceNone);
		kashyyyk.setDescription("Kashyyyk was a temperate jungle planet orbiting around a single star located in the Mytaranor sector of the Mid Rim, and had a complement of three moons. It was a member of the Galactic Republic and after the Clone Wars endured enslavement under the Galactic Empire.");
		kashyyyk.addNativeSpecies("Wookiee");
		kashyyyk.addTerrain("Forests");
		kashyyyk.addResource("None");
		kashyyyk.setSuns(1);
		kashyyyk.setMoons(3);
		Resources.planetInformation.add(kashyyyk);

		PlanetInformation kessel = new PlanetInformation();
		kessel.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetKessel.png"));
		kessel.setDimensionId(Resources.ConfigOptions.dimKesselId);
		kessel.setName("Kessel");
		kessel.setPosition(14.3f, 5.0f);
		kessel.setAffiliation(Resources.allegianceNone);
		kessel.setDescription("");
		Resources.planetInformation.add(kessel);

		PlanetInformation mandalore = new PlanetInformation();
		mandalore.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMandalore.png"));
		mandalore.setDimensionId(Resources.ConfigOptions.dimMandaloreId);
		mandalore.setName("Mandalore");
		mandalore.setPosition(9.7f, 2.3f);
		mandalore.setAffiliation(Resources.allegianceNone);
		mandalore.setDescription("");
		mandalore.setObfuscated(true);
		Resources.planetInformation.add(mandalore);

		PlanetInformation monCalamari = new PlanetInformation();
		monCalamari.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMonCalamari.png"));
		monCalamari.setDimensionId(Resources.ConfigOptions.dimMonCalamariId);
		monCalamari.setName("Mon Calamari");
		monCalamari.setInternalName("MonCalamari");
		monCalamari.setPosition(15.1f, 1.8f);
		monCalamari.setAffiliation(Resources.allegianceNone);
		monCalamari.setDescription("");
		monCalamari.setObfuscated(true);
		Resources.planetInformation.add(monCalamari);

		PlanetInformation mustafar = new PlanetInformation();
		mustafar.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetMustafar.png"));
		mustafar.setDimensionId(Resources.ConfigOptions.dimMustafarId);
		mustafar.setName("Mustafar");
		mustafar.setPosition(6.3f, 19.8f);
		mustafar.setAffiliation(Resources.allegianceNone);
		mustafar.setDescription("");
		mustafar.setObfuscated(true);
		Resources.planetInformation.add(mustafar);

		PlanetInformation naboo = new PlanetInformation();
		naboo.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetNaboo.png"));
		naboo.setDimensionId(Resources.ConfigOptions.dimNabooId);
		naboo.setName("Naboo");
		naboo.setPosition(9.4f, 12.1f);
		naboo.setAffiliation(Resources.allegianceNone);
		naboo.setDescription("");
		naboo.setObfuscated(true);
		Resources.planetInformation.add(naboo);

		PlanetInformation sullust = new PlanetInformation();
		sullust.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetSullust.png"));
		sullust.setDimensionId(Resources.ConfigOptions.dimSullustId);
		sullust.setName("Sullust");
		sullust.setPosition(7.75f, 12.5f);
		sullust.setAffiliation(Resources.allegianceNone);
		sullust.setDescription("");
		sullust.setObfuscated(true);
		Resources.planetInformation.add(sullust);

		PlanetInformation utapau = new PlanetInformation();
		utapau.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetUtapau.png"));
		utapau.setDimensionId(Resources.ConfigOptions.dimUtapauId);
		utapau.setName("Utapau");
		utapau.setPosition(8.5f, 14.75f);
		utapau.setAffiliation(Resources.allegianceNone);
		utapau.setDescription("");
		utapau.setObfuscated(true);
		Resources.planetInformation.add(utapau);

		PlanetInformation yavin4 = new PlanetInformation();
		yavin4.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetYavin4.png"));
		yavin4.setDimensionId(Resources.ConfigOptions.dimYavin4Id);
		yavin4.setName("Yavin 4");
		yavin4.setInternalName("Yavin4");
		yavin4.setPosition(10.6f, 1.0f);
		yavin4.setAffiliation(Resources.allegianceRebel);
		yavin4.setDescription("Yavin 4 was one of three habitable moons orbiting the gas giant Yavin. It was mainly covered in jungle and rainforest, and despite being remote and unheard of, it would play an important role in galactic events. Served as the main headquarters of the Rebel Alliance.");
		yavin4.setMoons(0);
		yavin4.setSuns(1);
		yavin4.addNativeSpecies("None");
		yavin4.addResource("None");
		yavin4.addTerrain("Jungles");
		yavin4.addTerrain("Rainforests");
		Resources.planetInformation.add(yavin4);

		PlanetInformation jakku = new PlanetInformation();
		jakku.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetJakku.png"));
		jakku.setDimensionId(Resources.ConfigOptions.dimJakkuId);
		jakku.setName("Jakku");
		jakku.setPosition(3.8f, 8.4f);
		jakku.setAffiliation(Resources.allegianceNone);
		jakku.setDescription("");
		jakku.setObfuscated(true);
		Resources.planetInformation.add(jakku);

		PlanetInformation takodana = new PlanetInformation();
		takodana.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetTakodana.png"));
		takodana.setDimensionId(Resources.ConfigOptions.dimTakodanaId);
		takodana.setName("Takodana");
		takodana.setPosition(4.8f, 10.7f);
		takodana.setAffiliation(Resources.allegianceNone);
		takodana.setDescription("");
		takodana.setObfuscated(true);
		Resources.planetInformation.add(takodana);

		PlanetInformation dQar = new PlanetInformation();
		dQar.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDQar.png"));
		dQar.setDimensionId(Resources.ConfigOptions.dimDQarId);
		dQar.setName("D'Qar");
		dQar.setInternalName("DQar");
		dQar.setPosition(9.3f, 13.1f);
		dQar.setAffiliation(Resources.allegianceNone);
		dQar.setDescription("");
		dQar.setObfuscated(true);
		Resources.planetInformation.add(dQar);

		PlanetInformation ahchTo = new PlanetInformation();
		ahchTo.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetAhchTo.png"));
		ahchTo.setDimensionId(Resources.ConfigOptions.dimAhchToId);
		ahchTo.setName("Ahch To");
		ahchTo.setInternalName("AhchTo");
		ahchTo.setPosition(16.8f, 8.6f);
		ahchTo.setAffiliation(Resources.allegianceNone);
		ahchTo.setDescription("");
		ahchTo.setObfuscated(true);
		Resources.planetInformation.add(ahchTo);

		PlanetInformation deathStar = new PlanetInformation();
		deathStar.setCubeTexture(new ResourceLocation(Resources.MODID + ":" + "textures/models/planets/planetDeathStar.png"));
		deathStar.setDimensionId(Resources.ConfigOptions.dimDeathStarId);
		deathStar.setName("Death Star");
		deathStar.setInternalName("DeathStar");
		deathStar.setPosition(11.2f, 1.4f);
		deathStar.setAffiliation(Resources.allegianceImperial);
		deathStar.setDescription("Under Construction");
		deathStar.setMoons(0);
		deathStar.setSuns(0);
		deathStar.addResource("None");
		deathStar.addTerrain("Barracks");
		deathStar.addTerrain("Detention Cells");
		deathStar.addTerrain("Hangars");
		deathStar.addNativeSpecies("Human");
		Resources.planetInformation.add(deathStar);

		config.save();

		Lumberjack.info("Configuration loaded!");
	}

	private void setupNetworking()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Resources.MODID + "." + "chan");

		this.registerMessage(MessageEntityGrab.class);
		this.registerMessage(MessageAddEffectTo.class);
		this.registerMessage(MessageHoloTableUpdate.class);
		this.registerMessage(MessageSetEntityTarget.class);
		this.registerMessage(MessageCreateDestructionBolt.class);
		this.registerMessage(MessageEntityAlterMotion.class);
		this.registerMessage(MessageHyperdrive.class);
		this.registerMessage(MessageEntityHurt.class);
		this.registerMessage(MessageTransmute.class);
		this.registerMessage(MessageEntityReverse.class);
		this.registerMessage(MessageRobesBooleanNBT.class);
		this.registerMessage(MessageRobesIntNBT.class);
		this.registerMessage(MessageRobesStringNBT.class);
		this.registerMessage(MessageSFoil.class);
		this.registerMessage(MessageRobesPowerNBT.class);
		this.registerMessage(MessageHeal.class);
		this.registerMessage(MessageDrainKnowledge.class);
		this.registerMessage(MessageShipTargetLock.class);
		this.registerMessage(MessageCreateBlasterBolt.class);
		this.registerMessage(MessageToggleLightsaber.class);
		this.registerMessage(MessageSetPlayerHolding.class);
		this.registerMessage(MessageEntityPosition.class);
		this.registerMessage(MessageDoWorldgen.class);
		this.registerMessage(MessageChangeStaticNpcLock.class);

		Lumberjack.log("Network registered " + String.valueOf(packetId) + " packets!");
	}

	@SuppressWarnings("unchecked")
	public void registerMessage(Class messageHandler)
	{
		network.registerMessage(messageHandler, messageHandler, packetId, Side.SERVER);
		Lumberjack.debug("Registered packet \"" + messageHandler + "\" as packet ID " + packetId);
		packetId += 1;
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandJediRobes());
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\StarWarsMod.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */