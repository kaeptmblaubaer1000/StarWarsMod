package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.parzi.starwarsmod.world.gen.WorldGenHothGenerator;

public class BiomeHoth extends BiomeGenBase
{
	public BiomeHoth(int par1)
	{
		super(par1);
		this.heightVariation = 0.5F;
		this.enableRain = false;
		this.enableSnow = true;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setBiomeName("Hoth");
		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.stone;
		this.temperature = 0.0F;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		if (par2Random.nextInt(10) == 0)
		{
			int k = par3 + 4;
			int l = par4 + 4;
			new WorldGenHothGenerator().generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeHoth.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */