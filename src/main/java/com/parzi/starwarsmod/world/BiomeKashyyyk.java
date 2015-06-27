package com.parzi.starwarsmod.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;

import com.parzi.starwarsmod.mobs.MobWookiee;

public class BiomeKashyyyk extends BiomeGenBase
{
	public BiomeKashyyyk(int par1)
	{
		super(par1);
		this.heightVariation = 0.8F;

		this.enableRain = true;
		this.enableSnow = false;

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(MobWookiee.class, 10, 1, 1));
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

		this.setBiomeName("Kashyyyk");

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.treesPerChunk = 6;
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenMegaJungle(false, 10, 20, 3, 3);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(8) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			//WorldGenKashyyykTree treeGen = new WorldGenKashyyykTree(false);
			//treeGen.generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
		}
	}
}
