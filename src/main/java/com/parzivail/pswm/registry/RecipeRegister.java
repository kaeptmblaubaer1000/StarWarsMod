package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.Lumberjack;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeRegister
{
	public static void registerAll()
	{
		GameRegistry.addSmelting(StarWarsItems.hiltMetelCompound, new ItemStack(StarWarsItems.hiltMetelAlloy, 1), 0.2F);
		GameRegistry.addSmelting(StarWarsItems.titaniumChromiumDust, new ItemStack(StarWarsItems.titaniumChromiumIngot, 2), 0.2F);
		GameRegistry.addSmelting(StarWarsItems.banthaChop, new ItemStack(StarWarsItems.banthaChopCooked, 1), 0.2F);
		GameRegistry.addSmelting(StarWarsMod.blockCrystalOre, new ItemStack(StarWarsItems.lightsaberCrystal, 1), 0.2F);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsItems.hiltMetelAlloy, 'N', Items.quartz, 'R', Blocks.diamond_block, 'G', Blocks.glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsItems.titaniumChromiumIngot, 'I', Items.iron_ingot, 'E', Items.ender_eye);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.hiltMetelCompound, 1), "AIA", "IAI", "AIA", 'A', StarWarsItems.chromiumDust, 'I', StarWarsItems.titaniumDust);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.magneticStabilizingRing, 1), " I ", "I I", " I ", 'I', StarWarsItems.ingotExonium);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.energyModulationCircuit, 1), "QQQ", "QKQ", "RKR", 'Q', Items.quartz, 'K', StarWarsItems.ingotKelerium, 'R', Items.redstone);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.cyclingFieldEnergizer, 1), "XGX", "G G", "XGX", 'X', StarWarsItems.ingotExonium, 'G', Items.gold_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.diatiumPowerCell, 1), "DDD", "DPD", "DPD", 'D', StarWarsItems.ingotDiatium, 'P', StarWarsItems.powerpack);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.energyGate, 1), " K ", " Q ", " K ", 'K', StarWarsItems.ingotKelerium, 'Q', Items.quartz);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.powerVortexRing, 1), "TTT", "T T", "TTT", 'T', StarWarsItems.ingotThorolide);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.inertPowerInsulator, 1), "C C", "C C", "C C", 'C', StarWarsItems.chromiumDust);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.apexSeal, 1), " A ", "A A", " A ", 'A', StarWarsItems.airsealGel);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.airsealGel, 1), "HHH", "HWH", "HHH", 'H', StarWarsItems.ingotHelicite, 'W', Items.water_bucket);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.shadowtrooperHelmet, 1), "AAA", "ABA", "AAA", 'A', StarWarsItems.ingotCortosis, 'B', StarWarsItems.stormtrooperHelmet);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.shadowtrooperChest, 1), "AAA", "ABA", "AAA", 'A', StarWarsItems.ingotCortosis, 'B', StarWarsItems.stormtrooperChest);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.shadowtrooperLegs, 1), "AAA", "ABA", "AAA", 'A', StarWarsItems.ingotCortosis, 'B', StarWarsItems.stormtrooperLegs);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.shadowtrooperBoots, 1), "AAA", "ABA", "AAA", 'A', StarWarsItems.ingotCortosis, 'B', StarWarsItems.stormtrooperBoots);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', new ItemStack(Blocks.wool, 1, 12));
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.blockTitaniumChromiumBlock, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.hyperdriveMotivator, 1), "RBR", "RAR", "RBR", 'A', Blocks.quartz_block, 'B', StarWarsMod.blockTitaniumChromiumBlock, 'R', StarWarsItems.ingotRubindum);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.hyperdriveEngine, 1), " F ", " B ", " A ", 'F', StarWarsItems.containmentField, 'B', StarWarsItems.hyperdriveMotivator, 'A', StarWarsItems.titaniumChromiumIngot);

		if (ConfigOptions.enableBuckets)
			GameRegistry.addShapedRecipe(new ItemStack(Items.water_bucket, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.waterDroplet);
		else
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.flowing_water, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.waterDroplet);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.titaniumChromiumDust, 1), StarWarsItems.titaniumDust, StarWarsItems.chromiumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.titaniumChromiumIngot, 9), StarWarsMod.blockTitaniumChromiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.hyperdriveTatooine), StarWarsItems.hyperdriveEngine, Blocks.sand);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.bobaJetpackChest), StarWarsItems.bobaChest, StarWarsItems.bobaJetpack);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.questContainer), StarWarsItems.chromiumDust, Items.book);
		Lumberjack.info("Recipes, reporting for duty!");
	}
}
