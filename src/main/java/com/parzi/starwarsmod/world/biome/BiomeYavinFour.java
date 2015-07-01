package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.parzi.starwarsmod.mobs.MobWookiee;

public class BiomeYavinFour extends BiomeGenBase
{
	public BiomeYavinFour(int par1)
	{
		super(par1);
		this.heightVariation = 0.25F;

		this.enableRain = true;
		this.enableSnow = false;

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

		this.setBiomeName("Yavin 4");

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.stone;

		this.theBiomeDecorator.treesPerChunk = 4;
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
