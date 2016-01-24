package com.parzivail.pswm.dimension.endor;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.gen.WorldGenBetterForest;
import com.parzivail.pswm.world.gen.WorldGenEndorBase;
import com.parzivail.pswm.world.gen.WorldGenEndorTree1;
import com.parzivail.pswm.world.gen.WorldGenEndorTree2;
import com.parzivail.pswm.world.gen.WorldGenEndorTree3;
import com.parzivail.pswm.world.gen.WorldGenEndorTree4;

public class BiomeGenEndor extends BiomeGenPSWM
{
	public BiomeGenEndor(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("The Forest Moon of Endor");

		this.enableRain = true;
		this.enableSnow = false;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.grassPerChunk = 8;
		this.theBiomeDecorator.treesPerChunk = 2;
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
		if (par2Random.nextInt(200) == 0)
		{
			int k = chunkX + 4;
			int l = chunkZ + 4;
			new WorldGenEndorBase().generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}

		for (int j = 0; j < this.theBiomeDecorator.grassPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par2Random.nextInt(par1World.getHeightValue(k, l) * 2);
			WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(par2Random);
			worldgenerator.generate(par1World, par2Random, k, i1, l);
		}

		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);

			switch (par2Random.nextInt(3))
			{
				case 0:
					new WorldGenBigTree(true).generate(par1World, par2Random, k, i1, l);
				case 1:
					new WorldGenBetterForest().generate(par1World, par2Random, k, i1, l, 10, 8, 0);
				case 2:
					new WorldGenShrub(2, 0).generate(par1World, par2Random, k, i1, l);
			}
		}

		int k = chunkX + par2Random.nextInt(16) + 8;
		int l = chunkZ + par2Random.nextInt(16) + 8;
		int i1 = par1World.getHeightValue(k, l);

		if (i1 < 30 || par2Random.nextInt(4) != 0)
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