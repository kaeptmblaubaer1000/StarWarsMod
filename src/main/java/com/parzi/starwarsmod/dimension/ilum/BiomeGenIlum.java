package com.parzi.starwarsmod.dimension.ilum;

import java.util.Random;

import com.parzi.starwarsmod.dimension.BiomeGenPSWM;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BiomeGenIlum extends BiomeGenPSWM
{
	public BiomeGenIlum(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Ilum");

		this.setDisableRain();
		this.setEnableSnow();

		this.setTemperatureRainfall(0.3f, 1f);

		this.rootHeight = 0.1f;
		this.heightVariation = 0.8f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.stone;

		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		// if (par2Random.nextInt(100) == 0)
		// {
		// int k = chunkX + 4;
		// int l = chunkZ + 4;
		// new WorldGenHothGenerator().generate(par1World, par2Random, k,
		// par1World.getHeightValue(k, l) - 3, l);
		// }
	}
}