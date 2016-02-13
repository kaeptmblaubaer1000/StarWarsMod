package com.parzivail.pswm.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.utils.CrystalColor;
import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegister
{
	public static void registerAll()
	{
		GameRegistry.addSmelting(StarWarsMod.hiltMetelCompound, new ItemStack(StarWarsMod.hiltMetelAlloy, 1), 0.2F);
		GameRegistry.addSmelting(StarWarsMod.titaniumChromiumDust, new ItemStack(StarWarsMod.titaniumChromiumIngot, 2), 0.2F);
		GameRegistry.addSmelting(StarWarsMod.banthaChop, new ItemStack(StarWarsMod.banthaChopCooked, 1), 0.2F);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsMod.hiltMetelAlloy, 'N', Items.quartz, 'R', Blocks.diamond_block, 'G', Blocks.glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsMod.titaniumChromiumIngot, 'I', Items.iron_ingot, 'E', Items.ender_eye);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.silverImperialCredit, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.imperialCredit);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.goldImperialCredit, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.silverImperialCredit);

		if (ConfigOptions.enableLightsaber)
		{
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaberOff, 1, CrystalColor.RED), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, CrystalColor.RED), 'P', StarWarsMod.plasmaEmitter);
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaberOff, 1, CrystalColor.GREEN), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, CrystalColor.GREEN), 'P', StarWarsMod.plasmaEmitter);
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaberOff, 1, CrystalColor.BLUE), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, CrystalColor.BLUE), 'P', StarWarsMod.plasmaEmitter);
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.sequelLightsaberOff, 1, 0), "HCH", "RER", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, CrystalColor.RED), 'P', StarWarsMod.plasmaEmitter, 'R', new ItemStack(Items.dye, 1, 1));
		}

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', new ItemStack(Blocks.wool, 1, 12));
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.blockTitaniumChromiumBlock, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveMotivator, 1), " B ", " A ", " B ", 'A', Blocks.quartz_block, 'B', StarWarsMod.blockTitaniumChromiumBlock);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveEngine, 1), " F ", " B ", " A ", 'F', StarWarsMod.containmentField, 'B', StarWarsMod.hyperdriveMotivator, 'A', StarWarsMod.titaniumChromiumIngot);

		if (ConfigOptions.enableBuckets)
			GameRegistry.addShapedRecipe(new ItemStack(Items.water_bucket, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.waterDroplet);
		else
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.flowing_water, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.waterDroplet);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.imperialCredit, 9), StarWarsMod.silverImperialCredit);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.silverImperialCredit, 9), StarWarsMod.goldImperialCredit);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumDust, 1), StarWarsMod.titaniumDust, StarWarsMod.chromiumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumIngot, 9), StarWarsMod.blockTitaniumChromiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.hyperdriveTatooine), StarWarsMod.hyperdriveEngine, Blocks.sand);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.bobaJetpackChest), StarWarsMod.bobaChest, StarWarsMod.bobaJetpack);
		Lumberjack.info("Recipes, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\RecipeRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */