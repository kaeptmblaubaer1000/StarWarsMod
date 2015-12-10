package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.world.OreGenerator;
import com.parzi.starwarsmod.world.biome.BiomeDagobah;
import com.parzi.starwarsmod.world.biome.BiomeEndor;
import com.parzi.starwarsmod.world.biome.BiomeEndorPlains;
import com.parzi.starwarsmod.world.biome.BiomeHoth;
import com.parzi.starwarsmod.world.biome.BiomeKashyyyk;
import com.parzi.starwarsmod.world.biome.BiomeTatooine;
import com.parzi.starwarsmod.world.biome.BiomeYavinFour;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class WorldRegister
{
	public static void registerAll() throws Exception
	{
		StarWarsMod.biomeTatooine = new BiomeTatooine(StarWarsMod.dimTatooineId);
		StarWarsMod.biomeHoth = new BiomeHoth(StarWarsMod.dimHothId);
		StarWarsMod.biomeKashyyyk = new BiomeKashyyyk(StarWarsMod.dimKashyyykId);
		StarWarsMod.biomeYavin4 = new BiomeYavinFour(StarWarsMod.dimYavin4Id);
		StarWarsMod.biomeEndor = new BiomeEndor(StarWarsMod.dimEndorId);
		StarWarsMod.biomeEndorPlains = new BiomeEndorPlains(StarWarsMod.dimEndorPlainsId);
		StarWarsMod.biomeDagobah = new BiomeDagobah(StarWarsMod.dimDagobahId);

		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(StarWarsMod.biomeTatooine, 0));
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(StarWarsMod.biomeHoth, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(StarWarsMod.biomeKashyyyk, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(StarWarsMod.biomeYavin4, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(StarWarsMod.biomeEndor, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(StarWarsMod.biomeEndorPlains, 0));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(StarWarsMod.biomeDagobah, 0));

		BiomeManager.removeSpawnBiome(StarWarsMod.biomeEndor);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeEndorPlains);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeHoth);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeKashyyyk);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeTatooine);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeYavin4);
		BiomeManager.removeSpawnBiome(StarWarsMod.biomeDagobah);

		GameRegistry.registerWorldGenerator(new OreGenerator(), 10);
		Lumberjack.info("World, reporting for duty!");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\registry\WorldRegister.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */