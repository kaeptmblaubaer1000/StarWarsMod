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
		GameRegistry.addSmelting(StarWarsMod.hiltMetelCompound, new ItemStack(StarWarsMod.hiltMetelAlloy, 1), 0.2F);
		GameRegistry.addSmelting(StarWarsMod.titaniumChromiumDust, new ItemStack(StarWarsMod.titaniumChromiumIngot, 2), 0.2F);
		GameRegistry.addSmelting(StarWarsMod.banthaChop, new ItemStack(StarWarsMod.banthaChopCooked, 1), 0.2F);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.plasmaEmitter, 1), new Object[] { "HGH", "HNH", "HRH", Character.valueOf('H'), StarWarsMod.hiltMetelAlloy, Character.valueOf('N'), Items.quartz, Character.valueOf('R'), Blocks.diamond_block, Character.valueOf('G'), Blocks.glass_pane });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.containmentField, 1), new Object[] { "AIA", "IEI", "AIA", Character.valueOf('A'), StarWarsMod.titaniumChromiumIngot, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('E'), Items.ender_eye });
		if (StarWarsMod.enableLightsaber) GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 0), new Object[] { "HCH", "HEH", "HPH", Character.valueOf('H'), StarWarsMod.hiltMetelAlloy, Character.valueOf('C'), StarWarsMod.containmentField, Character.valueOf('E'), new ItemStack(StarWarsMod.lightsaberCrystal, 1, 0), Character.valueOf('P'), StarWarsMod.plasmaEmitter });
		if (StarWarsMod.enableLightsaber) GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 1), new Object[] { "HCH", "HEH", "HPH", Character.valueOf('H'), StarWarsMod.hiltMetelAlloy, Character.valueOf('C'), StarWarsMod.containmentField, Character.valueOf('E'), new ItemStack(StarWarsMod.lightsaberCrystal, 1, 1), Character.valueOf('P'), StarWarsMod.plasmaEmitter });
		if (StarWarsMod.enableLightsaber) GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightsaber, 1, 2), new Object[] { "HCH", "HEH", "HPH", Character.valueOf('H'), StarWarsMod.hiltMetelAlloy, Character.valueOf('C'), StarWarsMod.containmentField, Character.valueOf('E'), new ItemStack(StarWarsMod.lightsaberCrystal, 1, 2), Character.valueOf('P'), StarWarsMod.plasmaEmitter });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.jediRobes, 1), new Object[] { "L L", "LWL", "LLL", Character.valueOf('L'), Items.leather, Character.valueOf('W'), new ItemStack(Blocks.wool, 1, 12) });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.lightJediRobes, 1), new Object[] { "L L", "LWL", "LLL", Character.valueOf('L'), Items.leather, Character.valueOf('W'), new ItemStack(Blocks.wool, 1, 8) });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.titaniumChromiumBlock, 1), new Object[] { "AAA", "AAA", "AAA", Character.valueOf('A'), StarWarsMod.titaniumChromiumIngot });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveMotivator, 1), new Object[] { " B ", " A ", " B ", Character.valueOf('A'), Blocks.quartz_block, Character.valueOf('B'), StarWarsMod.titaniumChromiumBlock });
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.hyperdriveEngine, 1), new Object[] { " F ", " B ", " A ", Character.valueOf('F'), StarWarsMod.containmentField, Character.valueOf('B'), StarWarsMod.hyperdriveMotivator, Character.valueOf('A'), StarWarsMod.titaniumChromiumIngot });
		if (StarWarsMod.enableBuckets)
			GameRegistry.addShapedRecipe(new ItemStack(Items.water_bucket, 1), new Object[] { "AAA", "AAA", "AAA", Character.valueOf('A'), StarWarsMod.waterDroplet });
		else
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.water, 1), new Object[] { "AAA", "AAA", "AAA", Character.valueOf('A'), StarWarsMod.waterDroplet });
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumDust, 1), new Object[] { StarWarsMod.titaniumDust, StarWarsMod.chromiumDust });
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.titaniumChromiumIngot, 9), new Object[] { StarWarsMod.titaniumChromiumBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.hyperdriveTatooine), new Object[] { StarWarsMod.hyperdriveEngine, Blocks.sand });
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsMod.bobaJetpackChest), new Object[] { StarWarsMod.bobaChest, StarWarsMod.bobaJetpack });
		Lumberjack.info("Recipes, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\RecipeRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */