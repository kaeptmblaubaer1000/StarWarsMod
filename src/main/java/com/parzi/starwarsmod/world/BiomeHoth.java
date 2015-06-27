package com.parzi.starwarsmod.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.parzi.starwarsmod.mobs.MobTauntaun;

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
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(MobTauntaun.class, 6, 1, 1));
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

		this.setBiomeName("Hoth");

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.stone;
		
		this.temperature = 0.0F;

		this.theBiomeDecorator = new BiomeDecoratorHoth();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(30) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			//WorldGenMV worldGenMV = new WorldGenMV();
			//worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
		}
	}
}
