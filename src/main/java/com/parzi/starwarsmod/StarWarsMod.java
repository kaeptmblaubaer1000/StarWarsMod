package com.parzi.starwarsmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.EnumHelper;

import com.parzi.starwarsmod.armor.ArmorJediRobes;
import com.parzi.starwarsmod.blocks.BlockMV;
import com.parzi.starwarsmod.commands.CommandFlySpeed;
import com.parzi.starwarsmod.commands.CommandSWDim;
import com.parzi.starwarsmod.entities.EntityBlasterBolt;
import com.parzi.starwarsmod.items.ItemBanthaHorn;
import com.parzi.starwarsmod.items.ItemBlasterBolt;
import com.parzi.starwarsmod.items.ItemBlasterRifle;
import com.parzi.starwarsmod.items.ItemContainmentField;
import com.parzi.starwarsmod.items.ItemGaffiStick;
import com.parzi.starwarsmod.items.ItemHiltMetalAlloy;
import com.parzi.starwarsmod.items.ItemHiltMetalCompound;
import com.parzi.starwarsmod.items.ItemLightsaber;
import com.parzi.starwarsmod.items.ItemLightsaberCrystal;
import com.parzi.starwarsmod.items.ItemMusicDisc;
import com.parzi.starwarsmod.items.ItemPlasmaEmitter;
import com.parzi.starwarsmod.mobs.MobBantha;
import com.parzi.starwarsmod.mobs.MobDroidAstromech;
import com.parzi.starwarsmod.mobs.MobGNK;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTauntaun;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.network.JediRobesBuy;
import com.parzi.starwarsmod.network.JediRobesSetElementInArmorInv;
import com.parzi.starwarsmod.rendering.gui.JediGUI;
import com.parzi.starwarsmod.structures.WorldGenHut;
import com.parzi.starwarsmod.tileentities.TileEntityMV;
import com.parzi.starwarsmod.utils.EntityUtils;
import com.parzi.starwarsmod.vehicles.VehicSpeederBike;
import com.parzi.starwarsmod.world.BiomeTatooine;
import com.parzi.starwarsmod.world.WorldProviderTatooine;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = StarWarsMod.MODID, version = StarWarsMod.VERSION)
public class StarWarsMod
{
	/* Mod Details */
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "1.0";
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
	@Instance("jediRobesGUI")
	public static JediGUI jediRobesGui;

	/* Items */
	public static Item gaffiStick;
	public static Item lightsaber;
	public static Item blasterRifle;

	public static Item hiltMetelCompound;
	public static Item hiltMetelAlloy;
	public static Item plasmaEmitter;
	public static Item containmentField;
	public static Item lightsaberCrystal;
	public static Item blasterBolt;
	public static Item banthaHorn;

	public static Item jediRobes;

	public static Item recordTheme;
	public static Item recordThrone;

	public static BiomeGenBase biomeTatooine;
	public static int biomeTatooineId;

	/* Tile Entities */

	/* Blocks */
	public static Block blockMV;

	/* Tool Materials */
	public static ToolMaterial gaffiMat = EnumHelper.addToolMaterial("gaffiMat", 3, 10240, 10f, 4f, 8);
	public static ToolMaterial plasmaMat = EnumHelper.addToolMaterial("gaffiMat", 3, -1, 10f, 26f, 8);

	/* Armor Materials */
	public static ArmorMaterial jediRobesMat = EnumHelper.addArmorMaterial("jediRobesMat", -1, new int[] { 0, 1, 0, 0 }, 0);

	/* Events */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel("SaveJediRobes");
		network.registerMessage(JediRobesBuy.Handler.class, JediRobesBuy.class, 0, Side.SERVER);
		network.registerMessage(JediRobesSetElementInArmorInv.Handler.class, JediRobesSetElementInArmorInv.class, 1, Side.SERVER);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Begin StarWars Init...");

		/* Creative Tabs */
		StarWarsMod.StarWarsTab = new StarWarsTab();

		/* Items */
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

		StarWarsMod.banthaHorn = new ItemBanthaHorn();
		GameRegistry.registerItem(StarWarsMod.banthaHorn, "banthaHorn");

		StarWarsMod.jediRobes = new ArmorJediRobes(jediRobesMat, 1, 1);
		GameRegistry.registerItem(StarWarsMod.jediRobes, "jediRobes");

		StarWarsMod.recordTheme = new ItemMusicDisc("Theme");
		GameRegistry.registerItem(StarWarsMod.recordTheme, "recordTheme");

		StarWarsMod.recordThrone = new ItemMusicDisc("Throne");
		GameRegistry.registerItem(StarWarsMod.recordThrone, "recordThrone");

		biomeTatooineId = 6;// DimensionManager.getNextFreeDimId();
		biomeTatooine = new BiomeTatooine(biomeTatooineId);

		DimensionManager.registerProviderType(biomeTatooineId, WorldProviderTatooine.class, false);
		DimensionManager.registerDimension(biomeTatooineId, biomeTatooineId);

		/* Tile Entities */
		GameRegistry.registerTileEntity(TileEntityMV.class, "teMoistureVaporator");

		/* Blocks */
		blockMV = new BlockMV();
		GameRegistry.registerBlock(blockMV, "moistureVaporator");

		/* Recipes */
		// GameRegistry.addShapelessRecipe(new ItemStack(this.hiltMetelCompound,
		// 1), Items.redstone, Items.iron_ingot);

		GameRegistry.addSmelting(StarWarsMod.hiltMetelCompound, new ItemStack(StarWarsMod.hiltMetelAlloy, 1), 0.2f);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaberCrystal), " D ", "DED", " D ", 'D', Items.diamond, 'E', Items.emerald);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsMod.hiltMetelAlloy, 'N', Items.nether_star, 'R', Blocks.beacon, 'G', Blocks.stained_glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsMod.hiltMetelAlloy, 'I', Items.iron_ingot, 'E', Items.ender_eye);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', StarWarsMod.lightsaberCrystal, 'P', StarWarsMod.plasmaEmitter);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.blasterRifle), "IIO", " GW", "  W", 'I', Items.iron_ingot, 'O', Blocks.obsidian, 'G', Items.gold_ingot, 'W', Blocks.log);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', Blocks.wool);

		/* Mobs */
		EntityUtils.registerMob(this, MobWookiee.class, "wookiee", 80, 0x974F1A, 0x3C200A);
		EntityUtils.registerMob(this, MobTusken.class, "tusken", 80, 0xFFFDB3, 0x5E5E4A);
		EntityUtils.registerMob(this, MobJawa.class, "jawa", 80, 0xFF0000, 0x9B6C00);
		EntityUtils.registerMob(this, MobTauntaun.class, "tauntaun", 80, 0xFFFFFF, 0x4ADCE8);
		EntityUtils.registerMob(this, MobDroidAstromech.class, "droidAstromech", 80, 0xFFFFFF, 0x2D00FF);
		EntityUtils.registerMob(this, MobBantha.class, "bantha", 80, 0x8B4513, 0xFFDEAD);
		EntityUtils.registerMob(this, MobGNK.class, "gonk", 80, 0x6B6B6B, 0x000000);

		EntityUtils.registerMob(this, VehicSpeederBike.class, "speederBike", 80, 0x000000, 0x000000);

		/* Entities */
		EntityUtils.registerEntity(this, EntityBlasterBolt.class, "blasterBolt", 80);

		/* Worldgen */
		GameRegistry.registerWorldGenerator(new WorldGenHut(), 1);

		/* Spawns */
		EntityRegistry.addSpawn(MobWookiee.class, 8, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills);
		EntityRegistry.addSpawn(MobTusken.class, 10, 2, 20, EnumCreatureType.ambient, BiomeGenBase.desert, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(MobJawa.class, 6, 2, 20, EnumCreatureType.ambient, BiomeGenBase.desert, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(MobTauntaun.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.taiga, BiomeGenBase.coldBeach, BiomeGenBase.coldTaigaHills, BiomeGenBase.coldTaiga, BiomeGenBase.taigaHills);

		proxy.registerRendering();

		System.out.println("...End StarWars Init");
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandFlySpeed());
		event.registerServerCommand(new CommandSWDim());
	}
}
