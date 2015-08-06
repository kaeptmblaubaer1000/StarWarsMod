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
import com.parzi.starwarsmod.world.gen.moseisley.MosEisleyLeft1;
import com.parzi.starwarsmod.world.gen.moseisley.MosEisleyLeft2;
import com.parzi.starwarsmod.world.gen.moseisley.MosEisleyLeft3;
import com.parzi.starwarsmod.world.gen.moseisley.MosEisleyLeft4;
import com.parzi.starwarsmod.world.gen.moseisley.MosEisleyLeft5;

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
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		this.biomeDecorator.decorateChunk(par1World, par2Random, this, chunkX, chunkZ);

		if (chunkX == 0 && chunkZ == 0)
		{
			new MosEisleyLeft1().generate(par1World, par2Random, chunkX, par1World.getHeightValue(chunkX, chunkZ), chunkZ);
		}
		else if (chunkX == 0 && chunkZ == 16)
		{
			new MosEisleyLeft2().generate(par1World, par2Random, chunkX, par1World.getHeightValue(chunkX, chunkZ), chunkZ);
		}
		else if (chunkX == 0 && chunkZ == 32)
		{
			new MosEisleyLeft3().generate(par1World, par2Random, chunkX, par1World.getHeightValue(chunkX, chunkZ), chunkZ);
		}
		else if (chunkX == 0 && chunkZ == 48)
		{
			new MosEisleyLeft4().generate(par1World, par2Random, chunkX, par1World.getHeightValue(chunkX, chunkZ), chunkZ);
		}
		else if (chunkX == 0 && chunkZ == 64)
		{
			new MosEisleyLeft5().generate(par1World, par2Random, chunkX, par1World.getHeightValue(chunkX, chunkZ), chunkZ);
		}

		if (par2Random.nextInt(400) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenSuperTatooineHomestead worldGenSuperHomestead = new WorldGenSuperTatooineHomestead();
			worldGenSuperHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}

		if (par2Random.nextInt(30) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenMV worldGenMV = new WorldGenMV();
			worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
		}

		if (par2Random.nextInt(300) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenTatooineHomestead worldGenHomestead = new WorldGenTatooineHomestead();
			worldGenHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}
}
