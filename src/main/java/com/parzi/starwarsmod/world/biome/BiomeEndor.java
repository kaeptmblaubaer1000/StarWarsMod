package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.parzi.starwarsmod.world.gen.WorldGenEndorBase;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree1;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree2;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree3;
import com.parzi.starwarsmod.world.gen.WorldGenEndorTree4;

public class BiomeEndor extends BiomeGenBase
{
	public BiomeEndor(int par1)
	{
		super(par1, false);
		this.heightVariation = 0.2F;
		this.enableRain = true;
		this.enableSnow = false;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator = new BiomeDecoratorEndor();
		this.setBiomeName("Endor");
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.theBiomeDecorator.treesPerChunk = 2;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		if (par2Random.nextInt(200) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			new WorldGenEndorBase().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
		}
		int k = par3 + par2Random.nextInt(16) + 8;
		int l = par4 + par2Random.nextInt(16) + 8;
		switch (par2Random.nextInt(4))
		{
			case 0:
				new WorldGenEndorTree1().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
				break;
			case 1:
				new WorldGenEndorTree2().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
				break;
			case 2:
				new WorldGenEndorTree3().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
				break;
			case 3:
				new WorldGenEndorTree4().generate(par1World, par2Random, k, par1World.getHeightValue(k, l), l);
		}
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		switch (p_150567_1_.nextInt(5))
		{
			case 1:
				return new WorldGenBigTree(false);
			case 2:
				return new WorldGenCanopyTree(false);
			case 3:
				return new WorldGenSavannaTree(false);
			case 4:
				return new WorldGenTrees(false);
		}
		return new WorldGenTrees(false);
	}

	@Override
	public int getBiomeFoliageColor(int p1, int p2, int p3)
	{
		return 2652712;
	}

	@Override
	public int getBiomeGrassColor(int p1, int p2, int p3)
	{
		return 2387236;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeEndor.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */