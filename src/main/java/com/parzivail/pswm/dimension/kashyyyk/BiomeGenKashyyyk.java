package com.parzivail.pswm.dimension.kashyyyk;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.gen.WorldGenMegaKashyyykJungle;
import com.parzivail.util.ui.LangUtils;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeGenKashyyyk extends BiomeGenPSWM
{
	public BiomeGenKashyyyk(int biomeId)
	{
		super(biomeId);

		this.setBiomeName(LangUtils.translate("kashyyyk"));

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
		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			WorldGenAbstractTree worldgenabstracttree = this.func_150567_a(par2Random);
			worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

			if (worldgenabstracttree.generate(par1World, par2Random, k, i1, l))
				worldgenabstracttree.func_150524_b(par1World, par2Random, k, i1, l);
		}

		for (int j = 0; j < this.theBiomeDecorator.grassPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par2Random.nextInt(par1World.getHeightValue(k, l) * 2);
			WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(par2Random);
			worldgenerator.generate(par1World, par2Random, k, i1, l);
		}
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenMegaKashyyykJungle(false, 10, 20, 3, 3);
	}
}