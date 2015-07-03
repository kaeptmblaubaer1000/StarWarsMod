package com.parzi.starwarsmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import com.parzi.starwarsmod.commands.CommandFlySpeed;
import com.parzi.starwarsmod.commands.CommandSWDim;
import com.parzi.starwarsmod.network.JediRobesBuy;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.network.TeleportPlayerNetwork;
import com.parzi.starwarsmod.registry.BlockRegister;
import com.parzi.starwarsmod.registry.EntityRegister;
import com.parzi.starwarsmod.registry.ItemRegister;
import com.parzi.starwarsmod.registry.MaterialRegister;
import com.parzi.starwarsmod.registry.RecipeRegister;
import com.parzi.starwarsmod.registry.WorldRegister;
import com.parzi.starwarsmod.rendering.gui.JediGUI;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = StarWarsMod.MODID, version = StarWarsMod.VERSION)
public class StarWarsMod
{
	/* Mod Details */
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "1.0";
	public static Configuration config;

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

	/* GUIs */
	public static JediGUI jediRobesGui;

	/* Items */
	public static Item gaffiStick;
	public static Item lightsaber;
	public static Item blasterPistol;
	public static Item blasterRifle;
	public static Item blasterRifleHeavy;
	public static Item ewokSpear;

	public static Item hiltMetelCompound;
	public static Item hiltMetelAlloy;
	public static Item plasmaEmitter;
	public static Item containmentField;
	public static Item lightsaberCrystal;
	public static Item blasterBolt;
	public static Item blasterRifleBolt;
	public static Item banthaHorn;

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
	public static Item spawnLandspeeder;

	public static Item jediRobes;
	public static Item endorHelmet;
	public static Item endorChest;
	public static Item endorLegs;
	public static Item endorBoots;
	public static Item rebelPilotHelmet;
	public static Item rebelPilotChest;
	public static Item rebelPilotLegs;
	public static Item rebelPilotBoots;

	public static Item recordTheme;
	public static Item recordThrone;

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
	public static int biomeEndorPlainsId;

	/* Config */
	public static boolean enableFlyCommand;
	public static boolean enableDimCommand;

	public static boolean enableLightsaber;
	public static int lightsaberDamage;

	/* Blocks */
	public static Block blockMV;
	public static Block chromiumOre;
	public static Block titaniumOre;
	public static Block titaniumChromiumBlock;
	public static Block endorBaseWall;

	/* Tool Materials */
	public static ToolMaterial gaffiMat;
	public static ToolMaterial plasmaMat;

	/* Armor Materials */
	public static ArmorMaterial jediRobesMat;
	public static ArmorMaterial endorArmorMat;
	public static ArmorMaterial rebelPilotArmorMat;

	/* Events */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(StarWarsMod.MODID);
		network.registerMessage(JediRobesBuy.Handler.class, JediRobesBuy.class, 0, Side.SERVER);
		network.registerMessage(JediRobesSetElementInArmorInv.Handler.class, JediRobesSetElementInArmorInv.class, 1, Side.SERVER);
		network.registerMessage(TeleportPlayerNetwork.Handler.class, TeleportPlayerNetwork.class, 2, Side.SERVER);

		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		this.dimTatooineId = config.get("dimensions", "tatooineId", 156).getInt();
		this.dimHothId = config.get("dimensions", "hothId", 155).getInt();
		this.dimKashyyykId = config.get("dimensions", "kashyyykId", 154).getInt();
		this.dimYavin4Id = config.get("dimensions", "yavinFourId", 153).getInt();
		this.dimEndorId = config.get("dimensions", "endorId", 152).getInt();
		this.biomeEndorPlainsId = config.get("dimensions", "endorPlainsId", 152).getInt();

		this.enableFlyCommand = config.get("commands", "flyspd", false).getBoolean();
		this.enableDimCommand = config.get("commands", "chgdim", false).getBoolean();

		this.enableLightsaber = config.get("items", "enableLightsaberRecipe", true).getBoolean();
		this.lightsaberDamage = config.get("items", "lightsaberDamage", 26).getInt();

		config.save();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Begin StarWars Init...");

		this.instance = this;

		/* Creative Tabs */
		StarWarsMod.StarWarsTab = new StarWarsTab();

		MaterialRegister.registerAll();

		ItemRegister.registerAll();

		WorldRegister.registerAll();

		BlockRegister.registerAll();

		RecipeRegister.registerAll();

		EntityRegister.registerAll();

		proxy.registerRendering();

		System.out.println("...End StarWars Init");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		if (this.enableFlyCommand) event.registerServerCommand(new CommandFlySpeed());
		if (this.enableDimCommand) event.registerServerCommand(new CommandSWDim());
	}
}
