package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.parzi.starwarsmod.world.gen.WorldGenYavinTempleRuins;

public class BiomeYavinFour extends BiomeGenBase
{
	public BiomeYavinFour(int par1)
	{
		super(par1);
		heightVariation = 0.25F;

		enableRain = true;
		enableSnow = false;

		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableWaterCreatureList.clear();

		setBiomeName("Yavin 4");

		topBlock = Blocks.grass;
		fillerBlock = Blocks.stone;

		theBiomeDecorator.treesPerChunk = 4;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(2) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			new WorldGenYavinTempleRuins().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
		}
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		switch (p_150567_1_.nextInt(6))
		{
			case 0:
				return new WorldGenMegaJungle(false, 10, 20, 3, 3);
			case 1:
				return new WorldGenBigTree(false);
			case 2:
				return new WorldGenCanopyTree(false);
			case 3:
				return new WorldGenMegaPineTree(false, true);
			case 4:
				return new WorldGenSavannaTree(false);
			case 5:
				return new WorldGenTrees(false);
		}
		return new WorldGenTrees(false);
	}
}
