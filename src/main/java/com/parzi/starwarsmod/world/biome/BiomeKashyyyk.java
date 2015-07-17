package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobWookiee;
import com.parzi.starwarsmod.world.gen.WorldGenMV;
import com.parzi.starwarsmod.world.gen.WorldGenMegaKashyyykJungle;
import com.parzi.starwarsmod.world.gen.WorldGenMysteryShrine;
import com.parzi.starwarsmod.world.gen.WorldGenTatooineHomestead;

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
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(200) == 0)
		{
			int k = par3 + 4;
			int l = par4 + 4;
			new WorldGenMysteryShrine().generate(StarWarsMod.dimKashyyykId, par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenMegaKashyyykJungle(false, 10, 20, 3, 3);
	}

	@Override
	public int getBiomeFoliageColor(int p1, int p2, int p3) {
		return 0x005900;
	}

	@Override
	public int getBiomeGrassColor(int p1, int p2, int p3) {
		return 0x198C19;
	}
}