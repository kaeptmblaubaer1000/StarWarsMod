package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTusken;
import com.parzi.starwarsmod.world.gen.WorldGenMV;
import com.parzi.starwarsmod.world.gen.WorldGenMysteryShrine;
import com.parzi.starwarsmod.world.gen.WorldGenTatooineHomestead;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenerator;

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
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(MobJawa.class, 3, 1, 2));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(MobTusken.class, 1, 2, 3));

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

		if (par2Random.nextInt(30) == 0)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			WorldGenMV worldGenMV = new WorldGenMV();
			worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
		}

		if (par2Random.nextInt(200) == 0)
		{
			int k = par3 + 4;
			int l = par4 + 4;
			new WorldGenMysteryShrine().generate(StarWarsMod.dimTatooineId, par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
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