package com.parzi.starwarsmod.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegister
{
	public static void registerAll()
	{
		GameRegistry.addSmelting(StarWarsMod.hiltMetelCompound, new ItemStack(StarWarsMod.hiltMetelAlloy, 1), 0.2f);
		GameRegistry.addSmelting(StarWarsMod.titaniumChromiumDust, new ItemStack(StarWarsMod.titaniumChromiumIngot, 2), 0.2f);
		GameRegistry.addSmelting(StarWarsMod.banthaChop, new ItemStack(StarWarsMod.banthaChopCooked, 1), 0.2f);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsMod.hiltMetelAlloy, 'N', Items.quartz, 'R', Blocks.diamond_block, 'G', Blocks.glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsMod.titaniumChromiumIngot, 'I', Items.iron_ingot, 'E', Items.ender_eye);
		if (StarWarsMod.enableLightsaber)
		{
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 0), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, 0), 'P', StarWarsMod.plasmaEmitter);
		}
		if (StarWarsMod.enableLightsaber)
		{
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 1), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, 1), 'P', StarWarsMod.plasmaEmitter);
		}
		if (StarWarsMod.enableLightsaber)
		{
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 2), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', new ItemStack(StarWarsMod.lightsaberCrystal, 1, 2), 'P', StarWarsMod.plasmaEmitter);
		}
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', new ItemStack(Blocks.wool, 1, 12));
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightJediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', new ItemStack(Blocks.wool, 1, 8));
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.titaniumChromiumBlock, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveMotivator, 1), " B ", " A ", " B ", 'A', Blocks.quartz_block, 'B', StarWarsMod.titaniumChromiumBlock);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveEngine, 1), " F ", " B ", " A ", 'F', StarWarsMod.containmentField, 'B', StarWarsMod.hyperdriveMotivator, 'A', StarWarsMod.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(Items.water_bucket, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.waterDroplet);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumDust, 1), StarWarsMod.titaniumDust, StarWarsMod.chromiumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumIngot, 9), StarWarsMod.titaniumChromiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.hyperdriveTatooine), StarWarsMod.hyperdriveEngine, Blocks.sand);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.bobaJetpackChest), StarWarsMod.bobaChest, StarWarsMod.bobaJetpack);

		Lumberjack.info("Recipes, reporting for duty!");
	}
}
