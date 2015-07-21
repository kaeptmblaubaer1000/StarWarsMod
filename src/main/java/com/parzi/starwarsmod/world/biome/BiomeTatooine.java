package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.world.gen.WorldGenMV;
import com.parzi.starwarsmod.world.gen.WorldGenSuperTatooineHomestead;
import com.parzi.starwarsmod.world.gen.WorldGenTatooineHomestead;

public class BiomeTatooine extends BiomeGenBase
{
	private BiomeDecoratorTatooine biomeDecorator;

	public BiomeTatooine(int par1)
	{
		super(par1);
		this.heightVariation = 0F;

		this.enableRain = false;
		this.enableSnow = false;

		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(MobJawa.class, 75, 1, 5));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(MobTusken.class, 35, 2, 3));

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

		this.setBiomeName("Tatooine");

		this.topBlock = StarWarsMod.tatooineSand;
		this.fillerBlock = StarWarsMod.tatooineSand;

		this.biomeDecorator = new BiomeDecoratorTatooine();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		this.biomeDecorator.decorateChunk(par1World, par2Random, this, par3, par4);

		if (par2Random.nextInt(400) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenSuperTatooineHomestead worldGenSuperHomestead = new WorldGenSuperTatooineHomestead();
			worldGenSuperHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}

		if (par2Random.nextInt(30) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenMV worldGenMV = new WorldGenMV();
			worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
		}

		if (par2Random.nextInt(300) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenTatooineHomestead worldGenHomestead = new WorldGenTatooineHomestead();
			worldGenHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}
}
