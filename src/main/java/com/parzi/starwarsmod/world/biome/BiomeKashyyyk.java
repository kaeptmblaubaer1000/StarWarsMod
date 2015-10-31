package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import com.parzi.starwarsmod.world.gen.WorldGenMegaKashyyykJungle;
import com.parzi.starwarsmod.world.gen.wookietree.WT_00;
import com.parzi.starwarsmod.world.gen.wookietree.WT_01;
import com.parzi.starwarsmod.world.gen.wookietree.WT_10;
import com.parzi.starwarsmod.world.gen.wookietree.WT_11;
import com.parzi.starwarsmod.world.gen.wookietree.WT_12;
import com.parzi.starwarsmod.world.gen.wookietree.WT_13;
import com.parzi.starwarsmod.world.gen.wookietree.WT_20;
import com.parzi.starwarsmod.world.gen.wookietree.WT_21;
import com.parzi.starwarsmod.world.gen.wookietree.WT_22;
import com.parzi.starwarsmod.world.gen.wookietree.WT_23;
import com.parzi.starwarsmod.world.gen.wookietree.WT_30;
import com.parzi.starwarsmod.world.gen.wookietree.WT_31;
import com.parzi.starwarsmod.world.gen.wookietree.WT_32;
import com.parzi.starwarsmod.world.gen.wookietree.WT_33;
import com.parzi.starwarsmod.world.gen.wookietree.WT_40;
import com.parzi.starwarsmod.world.gen.wookietree.WT_41;
import com.parzi.starwarsmod.world.gen.wookietree.WT_42;
import com.parzi.starwarsmod.world.gen.wookietree.WT_43;
import com.parzi.starwarsmod.world.gen.wookietree.WT_51;
import com.parzi.starwarsmod.world.gen.wookietree.WT_52;

public class BiomeKashyyyk extends BiomeGenBase
{
	int placeY;

	public BiomeKashyyyk(int par1)
	{
		super(par1);
		this.heightVariation = 0.8F;
		this.enableRain = true;
		this.enableSnow = false;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setBiomeName("Kashyyyk");
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.theBiomeDecorator.treesPerChunk = 2;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (chunkX == 0 && chunkZ == 0)
		{
			this.placeY = par1World.getHeightValue(chunkX, chunkZ);
			new WT_00().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 0 && chunkZ == 32)
		{
			new WT_01().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 32 && chunkZ == 0)
		{
			new WT_10().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 32 && chunkZ == 32)
		{
			new WT_11().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 32 && chunkZ == 64)
		{
			new WT_12().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 32 && chunkZ == 96)
		{
			new WT_13().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 64 && chunkZ == 0)
		{
			new WT_20().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 64 && chunkZ == 32)
		{
			new WT_21().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 64 && chunkZ == 64)
		{
			new WT_22().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 64 && chunkZ == 96)
		{
			new WT_23().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 96 && chunkZ == 0)
		{
			new WT_30().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 96 && chunkZ == 32)
		{
			new WT_31().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 96 && chunkZ == 64)
		{
			new WT_32().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 96 && chunkZ == 96)
		{
			new WT_33().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 128 && chunkZ == 0)
		{
			new WT_40().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 128 && chunkZ == 32)
		{
			new WT_41().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 128 && chunkZ == 64)
		{
			new WT_42().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 128 && chunkZ == 96)
		{
			new WT_43().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 160 && chunkZ == 32)
		{
			new WT_51().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		if (chunkX == 160 && chunkZ == 64)
		{
			new WT_52().generate(par1World, par2Random, chunkX, this.placeY, chunkZ);
			return;
		}
		super.decorate(par1World, par2Random, chunkX, chunkZ);
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenMegaKashyyykJungle(false, 10, 20, 3, 3);
	}

	@Override
	public int getBiomeFoliageColor(int p1, int p2, int p3)
	{
		return 22784;
	}

	@Override
	public int getBiomeGrassColor(int p1, int p2, int p3)
	{
		return 1674265;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeKashyyyk.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */