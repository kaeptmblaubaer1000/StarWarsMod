package com.parzi.starwarsmod.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeRegister
{
	public static void registerAll()
	{
		GameRegistry.addSmelting(StarWarsMod.hiltMetelCompound, new ItemStack(StarWarsMod.hiltMetelAlloy, 1), 0.2f);
		GameRegistry.addSmelting(StarWarsMod.titaniumChromiumIngot, new ItemStack(StarWarsMod.titaniumChromiumDust, 1), 0.2f);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaberCrystal), " D ", "DED", " D ", 'D', Items.diamond, 'E', Items.emerald);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsMod.hiltMetelAlloy, 'N', Items.nether_star, 'R', Blocks.beacon, 'G', Blocks.stained_glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsMod.titaniumChromiumIngot, 'I', Items.iron_ingot, 'E', Items.ender_eye);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber), "HCH", "HEH", "HPH", 'H', StarWarsMod.hiltMetelAlloy, 'C', StarWarsMod.containmentField, 'E', StarWarsMod.lightsaberCrystal, 'P', StarWarsMod.plasmaEmitter);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.blasterRifle), "IIO", " GW", "  W", 'I', Items.iron_ingot, 'O', Blocks.obsidian, 'G', Items.gold_ingot, 'W', Blocks.log);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', Blocks.wool);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.titaniumChromiumBlock, 1), "AAA", "AAA", "AAA", 'A', StarWarsMod.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveMotivator, 1), "BBB", "BAB", "BBB", 'A', Blocks.beacon, 'B', StarWarsMod.titaniumChromiumBlock);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveEngine, 1), " F ", " B ", " A ", 'F', StarWarsMod.containmentField, 'B', StarWarsMod.hyperdriveMotivator, 'A', StarWarsMod.titaniumChromiumIngot);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumDust, 1), StarWarsMod.titaniumDust, StarWarsMod.chromiumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumIngot, 9), StarWarsMod.titaniumChromiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.hyperdriveTatooine), StarWarsMod.hyperdriveEngine, Blocks.sand);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.hyperdriveEarth), StarWarsMod.hyperdriveEngine, Blocks.grass);
	}
}
