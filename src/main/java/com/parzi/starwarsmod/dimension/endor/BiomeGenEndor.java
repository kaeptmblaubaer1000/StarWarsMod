package com.parzi.starwarsmod.dimension.endor;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.parzi.starwarsmod.dimension.BiomeGenPSWM;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree1;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree2;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree3;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree4;
import com.parzi.starwarsmod.world.gen.WorldGenHothGenerator;

public class BiomeGenEndor extends BiomeGenPSWM
{
	public BiomeGenEndor(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("The Forest Moon of Endor");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = 3;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (par2Random.nextInt(10) == 0)
		{
			int k = chunkX + 4;
			int l = chunkZ + 4;
			new WorldGenHothGenerator().generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);

			if (i1 < 70)
				return;

			switch (par2Random.nextInt(4))
			{
				case 0:
					new WorldGenEndorTree1().generate(par1World, par2Random, k, i1, l);
					break;
				case 1:
					new WorldGenEndorTree2().generate(par1World, par2Random, k, i1, l);
					break;
				case 2:
					new WorldGenEndorTree3().generate(par1World, par2Random, k, i1, l);
					break;
				case 3:
					new WorldGenEndorTree4().generate(par1World, par2Random, k, i1, l);
					break;
			}
		}
	}
}