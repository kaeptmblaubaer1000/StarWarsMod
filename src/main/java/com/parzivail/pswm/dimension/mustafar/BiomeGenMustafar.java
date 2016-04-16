package com.parzivail.pswm.dimension.mustafar;

import java.util.Random;

import com.parzivail.pswm.dimension.BiomeGenPSWM;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BiomeGenMustafar extends BiomeGenPSWM
{
	public BiomeGenMustafar(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Mustafar");

		this.temperature = 1;
		this.rainfall = 1;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.01f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.obsidian;
		this.fillerBlock = Blocks.obsidian;

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
	}
}