package com.parzi.starwarsmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import com.parzi.starwarsmod.achievement.StarWarsAchievements;
import com.parzi.starwarsmod.commands.CommandFlySpeed;
import com.parzi.starwarsmod.commands.CommandSWDim;
import com.parzi.starwarsmod.handlers.GuiHandler;
import com.parzi.starwarsmod.items.crafting.ItemLightsaberCrystal;
import com.parzi.starwarsmod.items.weapons.ItemBlasterHeavy;
import com.parzi.starwarsmod.items.weapons.ItemBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemEwokSpear;
import com.parzi.starwarsmod.items.weapons.ItemGaffiStick;
import com.parzi.starwarsmod.items.weapons.ItemGamorreanAx;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemWookieeBowcaster;
import com.parzi.starwarsmod.network.CreateBlasterBoltSpeeder;
import com.parzi.starwarsmod.network.JediRobesBuy;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.network.TeleportPlayerNetwork;
import com.parzi.starwarsmod.network.TogglePlayerLightsaber;
import com.parzi.starwarsmod.registry.BlockRegister;
import com.parzi.starwarsmod.registry.EntityRegister;
import com.parzi.starwarsmod.registry.ItemRegister;
import com.parzi.starwarsmod.registry.MaterialRegister;
import com.parzi.starwarsmod.registry.RecipeRegister;
import com.parzi.starwarsmod.registry.RegisterGuiOverlays;
import com.parzi.starwarsmod.registry.WorldRegister;
import com.parzi.starwarsmod.rendering.gui.GuiJediRobes;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = StarWarsMod.MODID, version = StarWarsMod.VERSION, useMetadata = true)
public class StarWarsMod
{
	/* Mod Details */
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "0.1.4.4";
	public static Configuration config;

	/* Beta Testing */
	public static boolean isBetaTesting = false;
	public static String betaTesterUsername = "Cly_Faker";

	public static Random rngChromium = new Random();
	public static Random rngTitanium = new Random();

	@Mod.Instance(StarWarsMod.MODID)
	public static StarWarsMod instance;

	/* Proxies */
	@SidedProxy(clientSide = "com.parzi.starwarsmod.StarWarsClientProxy", serverSide = "com.parzi.starwarsmod.StarWarsCommonProxy")
	public static StarWarsCommonProxy proxy;

	/* Networks */
	public static SimpleNetworkWrapper network;

	/* Creative Tabs */
	public static CreativeTabs StarWarsTab;

	/* GuIs */
	public static GuiJediRobes jediRobesGui;

	/* Items */
	public static ItemGaffiStick gaffiStick;
	public static ItemLightsaber lightsaber;
	public static ItemLightsaberOff lightsaberOff;
	public static ItemBlasterPistol blasterPistol;
	public static ItemBlasterRifle blasterRifle;
	public static ItemBlasterHeavy blasterHeavy;
	public static ItemEwokSpear ewokSpear;
	public static ItemWookieeBowcaster bowcaster;
	public static ItemGamorreanAx gamorreanAx;

	public static Item hiltMetelCompound;
	public static Item hiltMetelAlloy;
	public static Item plasmaEmitter;
	public static Item containmentField;
	public static ItemLightsaberCrystal lightsaberCrystal;
	public static Item blasterBolt;
	public static Item blasterRifleBolt;
	public static Item banthaHorn;
	public static Item droidCaller;
	public static Item imperialCredit;
	public static Item waterDroplet;
	public static Item banthaMilk;

	public static Item debugLootGen;

	public static ItemFood banthaChop;

	public static Item chromiumDust;
	public static Item titaniumDust;
	public static Item titaniumChromiumDust;
	public static Item titaniumChromiumIngot;

	public static Item hyperdriveMotivator;
	public static Item hyperdriveEngine;

	public static Item hyperdriveEarth;
	public static Item hyperdriveTatooine;
	public static Item hyperdriveHoth;
	public static Item hyperdriveKashyyyk;
	public static Item hyperdriveYavin4;
	public static Item hyperdriveEndor;

	public static Item spawnSpeederBike;
	public static Item spawnHothSpeederBike;
	public static Item spawnLandspeeder;
	public static Item spawnAstromech;
	public static Item spawnProtocol;
	public static Item spawnGonk;

	public static Item jediRobes;
	public static Item lightJediRobes;

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

	public static Item atatPilotHelmet;
	public static Item atatPilotChest;
	public static Item atatPilotLegs;
	public static Item atatPilotBoots;

	public static Item hothHelmet;
	public static Item hothChest;
	public static Item hothLegs;
	public static Item hothBoots;

	public static Item leiasBuns;

	public static BiomeGenBase biomeTatooine;
	public static BiomeGenBase biomeHoth;
	public static BiomeGenBase biomeKashyyyk;
	public static BiomeGenBase biomeYavin4;
	public static BiomeGenBase biomeEndor;
	public static BiomeGenBase biomeEndorPlains;
	public static int dimTatooineId;
	public static int dimHothId;
	public static int dimKashyyykId;
	public static int dimYavin4Id;
	public static int dimEndorId;
	public static int dimEndorPlainsId;

	/* Config */
	public static boolean enableFlyCommand;
	public static boolean enableDimCommand;

	public static boolean enableCreditsOverlay;

	public static boolean enableLightsaber;
	public static int lightsaberDamage;

	/* Blocks */
	public static Block blockMV;
	public static Block blockTable;
	public static Block chromiumOre;
	public static Block titaniumOre;
	public static Block titaniumChromiumBlock;
	public static Block blockEndorBaseWall;
	public static Block blockEndorBaseWallStairs;
	public static Block tatooineSand;
	public static Block tatooineSandstone;
	public static Block spaceLamp;

	/* Tool Materials */
	public static ToolMaterial gaffiMat;
	public static ToolMaterial ewokMat;
	public static ToolMaterial gamorreanMat;
	public static ToolMaterial plasmaMat;
	public static ToolMaterial plasmaMatOff;

	/* Armor Materials */
	public static ArmorMaterial jediRobesMat;
	public static ArmorMaterial endorArmorMat;
	public static ArmorMaterial rebelPilotArmorMat;
	public static ArmorMaterial stormtrooperArmorMat;
	public static ArmorMaterial snowtrooperArmorMat;
	public static ArmorMaterial scoutTrooperArmorMat;
	public static ArmorMaterial tiePilotArmorMat;
	public static ArmorMaterial atatPilotArmorMat;
	public static ArmorMaterial hothArmorMat;
	public static ArmorMaterial sandtrooperArmorMat;
	public static ArmorMaterial bobaArmorMat;

	public static ArmorMaterial leiaBunsArmorMat;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		Lumberjack.info("========== Begin Star Wars Mod init() ==========");

		Lumberjack.info("This is Parzi's Star Wars Mod v" + StarWarsMod.VERSION);

		StarWarsMod.instance = this;

		/* Creative Tabs */
		StarWarsMod.StarWarsTab = new StarWarsTab();

		/* GUIs */
		NetworkRegistry.INSTANCE.registerGuiHandler(StarWarsMod.instance, new GuiHandler());

		MaterialRegister.registerAll();

		ItemRegister.registerAll();

		BlockRegister.registerAll();

		try
		{

			WorldRegister.registerAll();
		}
		catch (Exception e)
		{
			Lumberjack.log(Level.FATAL, "World failed to report for duty! Cause: unable to register dimension provider. See trace below for details:");
			e.printStackTrace();
		}

		RecipeRegister.registerAll();

		EntityRegister.registerAll();

		StarWarsAchievements.registerAll();

		RegisterGuiOverlays.registerAll();

		proxy.registerRendering();

		Lumberjack.info("=========== End Star Wars Mod init() ===========");
	}

	/* Events */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(StarWarsMod.MODID);
		network.registerMessage(JediRobesBuy.Handler.class, JediRobesBuy.class, 0, Side.SERVER);
		network.registerMessage(JediRobesSetElementInArmorInv.Handler.class, JediRobesSetElementInArmorInv.class, 1, Side.SERVER);
		network.registerMessage(TeleportPlayerNetwork.Handler.class, TeleportPlayerNetwork.class, 2, Side.SERVER);
		network.registerMessage(CreateBlasterBoltSpeeder.Handler.class, CreateBlasterBoltSpeeder.class, 3, Side.SERVER);
		network.registerMessage(TogglePlayerLightsaber.Handler.class, TogglePlayerLightsaber.class, 4, Side.SERVER);

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		StarWarsMod.dimTatooineId = config.get("dimensions", "tatooineId", 156).getInt();
		StarWarsMod.dimHothId = config.get("dimensions", "hothId", 155).getInt();
		StarWarsMod.dimKashyyykId = config.get("dimensions", "kashyyykId", 154).getInt();
		StarWarsMod.dimYavin4Id = config.get("dimensions", "yavinFourId", 153).getInt();
		StarWarsMod.dimEndorId = config.get("dimensions", "endorId", 152).getInt();
		StarWarsMod.dimEndorPlainsId = config.get("dimensions", "endorPlainsId", 152).getInt();

		config.addCustomCategoryComment("unstable_commands", "It is NOT recommended you use these, they were only added for development purposes!");
		StarWarsMod.enableFlyCommand = config.get("unstable_commands", "flyspd", false).getBoolean();
		StarWarsMod.enableDimCommand = config.get("unstable_commands", "chgdim", false).getBoolean();

		StarWarsMod.enableCreditsOverlay = config.get("gui", "enableCreditsOverlay", true).getBoolean();

		StarWarsMod.enableLightsaber = config.get("items", "enableLightsaberRecipe", true).getBoolean();
		StarWarsMod.lightsaberDamage = config.get("items", "lightsaberDamage", 26).getInt();

		config.save();
		Lumberjack.info("Configuration loaded!");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		if (StarWarsMod.enableFlyCommand)
		{
			event.registerServerCommand(new CommandFlySpeed());
			Lumberjack.warn("Fly command enabled! This is INCOMPATIBLE with anything serverside.");
		}
		if (StarWarsMod.enableDimCommand)
		{
			event.registerServerCommand(new CommandSWDim());
			Lumberjack.warn("Dimensional Transport command enabled! This is INCOMPATIBLE with anything serverside.");
		}
	}
}
