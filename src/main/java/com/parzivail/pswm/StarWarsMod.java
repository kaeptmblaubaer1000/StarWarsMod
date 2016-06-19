package com.parzivail.pswm;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.achievement.StarWarsAchievements;
import com.parzivail.pswm.blocks.npc.BlockNpcBase;
import com.parzivail.pswm.commands.CommandJediRobes;
import com.parzivail.pswm.exception.UserError;
import com.parzivail.pswm.handlers.ClientEventHandler;
import com.parzivail.pswm.handlers.CommonEventHandler;
import com.parzivail.pswm.handlers.GuiHandler;
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

	private static int packetId = 0;

	public static Random rngGeneral = new Random();

	@Mod.Instance(Resources.MODID)
	public static StarWarsMod instance;

	@SideOnly(Side.CLIENT)
	public static Minecraft mc;

	public static int shipSpecialWeaponCooldown = 0;

	static ClientEventHandler clientHandler;
	private static CommonEventHandler commonHandler;

	@SidedProxy(clientSide = "com.parzivail.pswm.StarWarsClientProxy",
	            serverSide = "com.parzivail.pswm.StarWarsCommonProxy")
	public static StarWarsCommonProxy proxy;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs StarWarsTab;
	public static CreativeTabs StarWarsTabBlocks;
	public static CreativeTabs SequelStarWarsTab;

	public static BiomeGenBase biomeTatooine;
	public static BiomeGenBase biomeHoth;
	public static BiomeGenBase biomeKashyyyk;
	public static BiomeGenBase biomeYavin4;
	public static BiomeGenBase biomeEndor;
	public static BiomeGenBase biomeDagobah;
	public static BiomeGenBase biomeIlum;
	public static BiomeGenBase biomeMustafar;
	public static BiomeGenBase biomeSpace;

	public static boolean isOverlayOnscreen = false;

	public static Block blockMV;
	public static Block blockLightsaberForge;
	public static Block blockCrystalCompressor;
	public static Block blockAntenna;
	public static Block blockFieldEmitter;
	public static Block blockDeathStarDoor;
	public static Block blockHoloTable;
	public static Block blockTable;
	public static Block blockTable2;
	public static Block blockFocusingCrystalOre;
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
	public static Block blockDeathStarLightStairs;
	public static Block blockDeathStarLightFence;
	public static Block blockTatooineSand;
	public static Block blockTatooineSandstone;
	public static Block blockIlumStone;
	public static Block blockSpaceLamp;
	public static Block blockDagobahMud;
	public static Block blockHangingCauldron;
	public static Block blockHangingBucket;
	public static Block blockBasket;
	public static Block blockBactaTank;

	public static Block blockMovingLightSource;

	public static Block blockSensorXWing;
	public static Block blockSensorYWing;
	public static Block blockSensorAWing;

	public static Block blockThorolideOre;
	public static Block blockCortosisOre;
	public static Block blockDiatiumOre;
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

	public static Block blockHothSandbag;

	public static Block blockAncientJediStatue;
	public static BlockNpcBase[] blockStaticNpc;
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

		ConfigOptions.dimSpaceId = config.get("dimensions", "space", 118).getInt();

		ConfigOptions.biomeDagobahId = config.get("biomes", "dagobah", 195).getInt();
		ConfigOptions.biomeTatooineId = config.get("biomes", "tatooine", 196).getInt();
		ConfigOptions.biomeHothId = config.get("biomes", "hoth", 197).getInt();
		ConfigOptions.biomeKashyyykId = config.get("biomes", "kashyyyk", 198).getInt();
		ConfigOptions.biomeYavin4Id = config.get("biomes", "yavin", 199).getInt();
		ConfigOptions.biomeEndorId = config.get("biomes", "endor", 200).getInt();
		ConfigOptions.biomeIlumId = config.get("biomes", "ilum", 201).getInt();
		ConfigOptions.biomeMustafarId = config.get("biomes", "mustafar", 202).getInt();
		ConfigOptions.biomeSpaceId = config.get("biomes", "space", 203).getInt();

		ConfigOptions.enableCreditsOverlay = config.get("gui", "enableGuiOverlay", true).getBoolean();

		ConfigOptions.lightsaberDamage = config.get("items", "lightsaberDamage", 26).getInt();
		ConfigOptions.enableLightsaber = config.get("items", "enableLightsaberRecipe", true).getBoolean();
		ConfigOptions.enableLightsaberHum = config.get("items", "enableLightsaberIdleSound", true).getBoolean();
		ConfigOptions.enableBlasterFire = config.get("items", "enableBlasterFire", true).getBoolean();
		ConfigOptions.enableLightsaberStrobe = config.get("items", "enableLightsaberAnimation", true).getBoolean();
		ConfigOptions.enableBuckets = config.get("items", "enableGettingThatDumbFreeBucketFromWaterDroplets", true).getBoolean();

		ConfigOptions.enableLightsaberLight = config.get("items", "enableLightsaberLighting", true).getBoolean();

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

		config.save();

		Lumberjack.info("Configuration loaded!");
	}

	private void setupNetworking()
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Resources.MODID + "." + "chan");

		this.registerMessage(MessageEntityGrab.class);
		this.registerMessage(MessageAddEffectTo.class);
		this.registerMessage(MessageHoloTableUpdate.class);
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
		this.registerMessage(MessageTransferHyperdrive.class);
		this.registerMessage(MessageSpawn.class);
		this.registerMessage(MessageThrowSaber.class);
		this.registerMessage(MessageHolocronRefreshPowers.class);
		this.registerMessage(MessageHolocronSetActive.class);
		this.registerMessage(MessagePlayerRemoveItems.class);

		Lumberjack.log("Network registered " + String.valueOf(packetId) + " packets!");
	}

	@SuppressWarnings("unchecked")
	private void registerMessage(Class messageHandler)
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
