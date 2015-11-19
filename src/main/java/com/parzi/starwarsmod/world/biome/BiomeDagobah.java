package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.gen.WorldGenDagobahJungle;

public class BiomeDagobah extends BiomeGenSwamp
{
	BiomeDecoratorDagobah decorator;

	public BiomeDagobah(int par1)
	{
		super(par1);

		decorator = new BiomeDecoratorDagobah();

		this.heightVariation = 0.1F;
		this.enableRain = true;
		this.enableSnow = false;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setBiomeName("Dagobah");
		this.topBlock = StarWarsMod.blockDagobahMud;
		this.fillerBlock = Blocks.dirt;
		this.color = 0x00CC99;
		this.waterColorMultiplier = 10;

		this.rainfall = 1.0F;
		this.temperature = 1.0F;

		decorator.treesPerChunk = 4;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		super.decorate(par1World, par2Random, chunkX, chunkZ);
		decorator.decorateChunk(par1World, par2Random, this, chunkX, chunkZ);
		if (par2Random.nextBoolean())
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			if (par1World.getBlock(k, par1World.getHeightValue(k, l) - 1, l) != Blocks.water)
				new WorldGenDagobahJungle(false, 10, 20, 3, 3).generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
		}
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenDagobahJungle(false, 10, 20, 3, 3);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeTatooine.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */