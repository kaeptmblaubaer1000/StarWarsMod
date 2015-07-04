package com.parzi.starwarsmod.registry;

import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.OreGenerator;
import com.parzi.starwarsmod.world.biome.BiomeEndor;
import com.parzi.starwarsmod.world.biome.BiomeEndorPlains;
import com.parzi.starwarsmod.world.biome.BiomeHoth;
import com.parzi.starwarsmod.world.biome.BiomeKashyyyk;
import com.parzi.starwarsmod.world.biome.BiomeTatooine;
import com.parzi.starwarsmod.world.biome.BiomeYavinFour;
import com.parzi.starwarsmod.world.provider.WorldProviderEndor;
import com.parzi.starwarsmod.world.provider.WorldProviderHoth;
import com.parzi.starwarsmod.world.provider.WorldProviderKashyyyk;
import com.parzi.starwarsmod.world.provider.WorldProviderTatooine;
import com.parzi.starwarsmod.world.provider.WorldProviderYavinFour;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldRegister
{
	public static void registerAll()
	{
		StarWarsMod.biomeTatooine = new BiomeTatooine(StarWarsMod.dimTatooineId);

		StarWarsMod.biomeHoth = new BiomeHoth(StarWarsMod.dimHothId);

		StarWarsMod.biomeKashyyyk = new BiomeKashyyyk(StarWarsMod.dimKashyyykId);

		StarWarsMod.biomeYavin4 = new BiomeYavinFour(StarWarsMod.dimYavin4Id);

		StarWarsMod.biomeEndor = new BiomeEndor(StarWarsMod.dimEndorId);
		StarWarsMod.biomeEndorPlains = new BiomeEndorPlains(StarWarsMod.dimEndorPlainsId);

		DimensionManager.registerProviderType(StarWarsMod.dimTatooineId, WorldProviderTatooine.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimTatooineId, StarWarsMod.dimTatooineId);

		DimensionManager.registerProviderType(StarWarsMod.dimHothId, WorldProviderHoth.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimHothId, StarWarsMod.dimHothId);

		DimensionManager.registerProviderType(StarWarsMod.dimKashyyykId, WorldProviderKashyyyk.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimKashyyykId, StarWarsMod.dimKashyyykId);

		DimensionManager.registerProviderType(StarWarsMod.dimYavin4Id, WorldProviderYavinFour.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimYavin4Id, StarWarsMod.dimYavin4Id);

		DimensionManager.registerProviderType(StarWarsMod.dimEndorId, WorldProviderEndor.class, false);
		DimensionManager.registerDimension(StarWarsMod.dimEndorId, StarWarsMod.dimEndorId);

		BiomeManager.removeSpawnBiome(StarWarsMod.biomeEndor);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeEndorPlains);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeHoth);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeKashyyyk);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeTatooine);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeYavin4);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
	}
}
