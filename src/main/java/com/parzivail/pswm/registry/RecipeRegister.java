package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.utils.CrystalColor;
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

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.plasmaEmitter, 1), "HGH", "HNH", "HRH", 'H', StarWarsItems.hiltMetelAlloy, 'N', Items.quartz, 'R', Blocks.diamond_block, 'G', Blocks.glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.containmentField, 1), "AIA", "IEI", "AIA", 'A', StarWarsItems.titaniumChromiumIngot, 'I', Items.iron_ingot, 'E', Items.ender_eye);

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.silverImperialCredit, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.imperialCredit);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.goldImperialCredit, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.silverImperialCredit);

		if (ConfigOptions.enableLightsaber)
		{
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.lightsaberOff, 1, CrystalColor.RED), "HCH", "HEH", "HPH", 'H', StarWarsItems.hiltMetelAlloy, 'C', StarWarsItems.containmentField, 'E', new ItemStack(StarWarsItems.lightsaberCrystal, 1, CrystalColor.RED), 'P', StarWarsItems.plasmaEmitter);
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.lightsaberOff, 1, CrystalColor.GREEN), "HCH", "HEH", "HPH", 'H', StarWarsItems.hiltMetelAlloy, 'C', StarWarsItems.containmentField, 'E', new ItemStack(StarWarsItems.lightsaberCrystal, 1, CrystalColor.GREEN), 'P', StarWarsItems.plasmaEmitter);
			GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.lightsaberOff, 1, CrystalColor.BLUE), "HCH", "HEH", "HPH", 'H', StarWarsItems.hiltMetelAlloy, 'C', StarWarsItems.containmentField, 'E', new ItemStack(StarWarsItems.lightsaberCrystal, 1, CrystalColor.BLUE), 'P', StarWarsItems.plasmaEmitter);
		}

		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.jediRobes, 1), "L L", "LWL", "LLL", 'L', Items.leather, 'W', new ItemStack(Blocks.wool, 1, 12));
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsMod.blockTitaniumChromiumBlock, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.titaniumChromiumIngot);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.hyperdriveMotivator, 1), " B ", " A ", " B ", 'A', Blocks.quartz_block, 'B', StarWarsMod.blockTitaniumChromiumBlock);
		GameRegistry.addShapedRecipe(new ItemStack(StarWarsItems.hyperdriveEngine, 1), " F ", " B ", " A ", 'F', StarWarsItems.containmentField, 'B', StarWarsItems.hyperdriveMotivator, 'A', StarWarsItems.titaniumChromiumIngot);

		if (ConfigOptions.enableBuckets)
			GameRegistry.addShapedRecipe(new ItemStack(Items.water_bucket, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.waterDroplet);
		else
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.flowing_water, 1), "AAA", "AAA", "AAA", 'A', StarWarsItems.waterDroplet);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.imperialCredit, 9), StarWarsItems.silverImperialCredit);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.silverImperialCredit, 9), StarWarsItems.goldImperialCredit);

		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.titaniumChromiumDust, 1), StarWarsItems.titaniumDust, StarWarsItems.chromiumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.titaniumChromiumIngot, 9), StarWarsMod.blockTitaniumChromiumBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.hyperdriveTatooine), StarWarsItems.hyperdriveEngine, Blocks.sand);
		GameRegistry.addShapelessRecipe(new ItemStack(StarWarsItems.bobaJetpackChest), StarWarsItems.bobaChest, StarWarsItems.bobaJetpack);
		Lumberjack.info("Recipes, reporting for duty!");
	}
}
