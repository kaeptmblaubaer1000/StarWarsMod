package com.parzivail.pswm.dimension.tatooine;

import com.parzivail.util.common.OpenSimplexNoise;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.storage.WorldInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by colby on 12/22/2016.
 */
public class BiomeProviderTatooine extends BiomeProvider
{
	public static final List<Biome> allowedBiomes = Arrays.asList(Biomes.DESERT, Biomes.DESERT_HILLS);
	private List<Biome> biomesToSpawnIn;
	private OpenSimplexNoise biomeNoise;

	public BiomeProviderTatooine(WorldInfo info)
	{
		super(info);
		this.biomesToSpawnIn = new ArrayList<>();
		this.biomesToSpawnIn.addAll(allowedBiomes);
		this.biomeNoise = new OpenSimplexNoise(info.getSeed());
	}

	@Override
	public List<Biome> getBiomesToSpawnIn()
	{
		return this.biomesToSpawnIn;
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

		for (int _y = 0; _y < height; _y++)
		{
			for (int _x = 0; _x < width; _x++)
			{
				biomes[_y * height + _x] = getBiomeAtXY(x + _x, y + _y);
			}
		}
		return biomes;
	}

	public Biome getBiomeAtXY(float x, float y)
	{
		double v = biomeNoise.eval(x, y);
		return v > 0.5 ? Biomes.DESERT_HILLS : Biomes.DESERT;
	}

	/**
	 * checks given Chunk's Biomes against List of allowed ones
	 */
	@Override
	public boolean areBiomesViable(int x, int z, int radius, List<Biome> allowed)
	{
		//		IntCache.resetIntCache();
		//		int i = x - radius >> 2;
		//		int j = z - radius >> 2;
		//		int k = x + radius >> 2;
		//		int l = z + radius >> 2;
		//		int i1 = k - i + 1;
		//		int j1 = l - j + 1;
		//		int[] aint = this.genBiomes.getInts(i, j, i1, j1);
		//
		//		try
		//		{
		//			for (int k1 = 0; k1 < i1 * j1; ++k1)
		//			{
		//				Biome biome = Biome.getBiome(aint[k1]);
		//
		//				if (!allowed.contains(biome))
		//				{
		//					return false;
		//				}
		//			}
		//
		//			return true;
		//		}
		//		catch (Throwable throwable)
		//		{
		//			CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Invalid Biome id");
		//			CrashReportCategory crashreportcategory = crashreport.makeCategory("Layer");
		//			crashreportcategory.addCrashSection("Layer", this.genBiomes.toString());
		//			crashreportcategory.addCrashSection("x", Integer.valueOf(x));
		//			crashreportcategory.addCrashSection("z", Integer.valueOf(z));
		//			crashreportcategory.addCrashSection("radius", Integer.valueOf(radius));
		//			crashreportcategory.addCrashSection("allowed", allowed);
		//			throw new ReportedException(crashreport);
		//		}
		return true;
	}

	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random)
	{
		//		IntCache.resetIntCache();
		//		int i = x - range >> 2;
		//		int j = z - range >> 2;
		//		int k = x + range >> 2;
		//		int l = z + range >> 2;
		//		int i1 = k - i + 1;
		//		int j1 = l - j + 1;
		//		int[] aint = this.genBiomes.getInts(i, j, i1, j1);
		//		BlockPos blockpos = null;
		//		int k1 = 0;
		//
		//		for (int l1 = 0; l1 < i1 * j1; ++l1)
		//		{
		//			int i2 = i + l1 % i1 << 2;
		//			int j2 = j + l1 / i1 << 2;
		//			Biome biome = Biome.getBiome(aint[l1]);
		//
		//			if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0))
		//			{
		//				blockpos = new BlockPos(i2, 0, j2);
		//				++k1;
		//			}
		//		}
		//
		//		return blockpos;
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