package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.parzi.starwarsmod.world.gen.WorldGenEndorBase;

public class BiomeEndorPlains extends BiomeGenBase
{
	public BiomeEndorPlains(int par1)
	{
		super(par1);
		heightVariation = 0.01F;

		enableRain = true;
		enableSnow = false;

		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableWaterCreatureList.clear();

		setBiomeName("Endor Plains");

		topBlock = Blocks.grass;
		fillerBlock = Blocks.dirt;

		theBiomeDecorator.treesPerChunk = 0;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(200) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenEndorBase worldGenBase = new WorldGenEndorBase();
			worldGenBase.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}

	@Override
	public int getBiomeFoliageColor(int p1, int p2, int p3)
	{
		return 0x287A28;
	}

	@Override
	public int getBiomeGrassColor(int p1, int p2, int p3)
	{
		return 0x246D24;
	}
}
