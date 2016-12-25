package com.parzivail.pswm.dimension.tatooine;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.storage.WorldInfo;
import scala.actors.threadpool.Arrays;

import java.util.List;
import java.util.Random;

/**
 * Created by colby on 12/22/2016.
 */
public class BiomeProviderTatooine extends BiomeProvider
{
	public BiomeProviderTatooine(WorldInfo info)
	{
		super(info);
	}

	@Override
	public List<Biome> getBiomesToSpawnIn()
	{
		return null;
	}

	/**
	 * Returns an array of biomes for the location input.
	 */
	@Override
	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int y, int width, int height)
	{
		if (biomes == null || biomes.length < width * height)
		{
			biomes = new Biome[width * height];
		}
		Arrays.fill(biomes, Biomes.DESERT);
		return biomes;
	}

	/**
	 * checks given Chunk's Biomes against List of allowed ones
	 */
	@Override
	public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed)
	{
		return true;
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
	{
		return null;
	}

	/**
	 * Calls the WorldChunkManager's biomeCache.cleanupCache()
	 */
	@Override
	public void cleanupCache()
	{
	}
}