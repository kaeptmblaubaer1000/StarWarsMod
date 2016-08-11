package com.parzivail.pswm.dimension.endor;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.StructureBank;
import com.parzivail.pswm.world.gen.WorldGenBetterForest;
import com.parzivail.util.math.MathUtils;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGenEndor extends BiomeGenPSWM
{
	public int locY = 0;

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
		this.locY = (int)MathUtils.map(this.rootHeight, -2, 2, 0, 128);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{

		for (int j = 0; j < this.theBiomeDecorator.grassPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			if (par1World.getHeightValue(k, l) > 20)
			{
				int i1 = par2Random.nextInt(par1World.getHeightValue(k, l) * 2);
				WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(par2Random);
				worldgenerator.generate(par1World, par2Random, k, i1, l);
			}
		}

		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			if (par1World.getHeightValue(k, l) > 20)
			{
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
		}

		if (par2Random.nextInt(600) == 0)
		{
			StructureBank.getEndorShield().genFull(par1World, chunkX, par1World.getHeightValue(chunkX, chunkZ) - 5, chunkZ);
		}

		if (par2Random.nextInt(600) == 0)
		{
			StructureBank.getEwokVillage().genFull(par1World, chunkX, par1World.getHeightValue(chunkX, chunkZ) - 5, chunkZ);
		}

		StructureBank.getEndorBase().genComposite(par1World, chunkX, locY, chunkZ, 25, 0);
		StructureBank.getRebelEndor().genComposite(par1World, chunkX, locY, chunkZ, -25, 0);
	}
}