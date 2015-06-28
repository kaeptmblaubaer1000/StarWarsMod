package com.parzi.starwarsmod.registry;

import net.minecraftforge.common.DimensionManager;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.OreGenerator;
import com.parzi.starwarsmod.world.biome.BiomeHoth;
import com.parzi.starwarsmod.world.biome.BiomeKashyyyk;
import com.parzi.starwarsmod.world.biome.BiomeTatooine;
import com.parzi.starwarsmod.world.biome.BiomeYavinFour;
import com.parzi.starwarsmod.world.provider.WorldProviderHoth;
import com.parzi.starwarsmod.world.provider.WorldProviderKashyyyk;
import com.parzi.starwarsmod.world.provider.WorldProviderTatooine;
import com.parzi.starwarsmod.world.provider.WorldProviderYavinFour;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister
{
	public static void registerAll()
	{
		StarWarsMod.dimTatooineId = 156;
		StarWarsMod.biomeTatooine = new BiomeTatooine(StarWarsMod.dimTatooineId);

		StarWarsMod.dimHothId = 155;
		StarWarsMod.biomeHoth = new BiomeHoth(StarWarsMod.dimHothId);

		StarWarsMod.dimKashyyykId = 154;
		StarWarsMod.biomeKashyyyk = new BiomeKashyyyk(StarWarsMod.dimKashyyykId);

		StarWarsMod.dimYavin4Id = 153;
		StarWarsMod.biomeYavin4 = new BiomeYavinFour(StarWarsMod.dimYavin4Id);

		DimensionManager.registerProviderType(StarWarsMod.dimTatooineId, WorldProviderTatooine.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimTatooineId, StarWarsMod.dimTatooineId);

		DimensionManager.registerProviderType(StarWarsMod.dimHothId, WorldProviderHoth.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimHothId, StarWarsMod.dimHothId);

		DimensionManager.registerProviderType(StarWarsMod.dimKashyyykId, WorldProviderKashyyyk.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimKashyyykId, StarWarsMod.dimKashyyykId);

		DimensionManager.registerProviderType(StarWarsMod.dimYavin4Id, WorldProviderYavinFour.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimYavin4Id, StarWarsMod.dimYavin4Id);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
	}
}
