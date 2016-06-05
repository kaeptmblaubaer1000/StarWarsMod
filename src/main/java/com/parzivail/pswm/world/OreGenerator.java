package com.parzivail.pswm.world;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.math.MathUtils;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class OreGenerator implements IWorldGenerator
{
	public static WorldGenMinable genKelerium = new WorldGenMinable(StarWarsMod.blockKeleriumOre, 8);
	public static WorldGenMinable genIonite = new WorldGenMinable(StarWarsMod.blockIoniteOre, 8);
	public static WorldGenMinable genRubindum = new WorldGenMinable(StarWarsMod.blockRubindumOre, 8);
	public static WorldGenMinable genChromium = new WorldGenMinable(StarWarsMod.blockChromiumOre, 8);
	public static WorldGenMinable genTitanium = new WorldGenMinable(StarWarsMod.blockTitaniumOre, 8);
	public static WorldGenMinable genDiatium = new WorldGenMinable(StarWarsMod.blockDiatiumOre, 0, 8, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genExonium = new WorldGenMinable(StarWarsMod.blockExoniumOre, 8);
	public static WorldGenMinable genHelecite = new WorldGenMinable(StarWarsMod.blockHeliciteOre, 8);
	public static WorldGenMinable genThoralide = new WorldGenMinable(StarWarsMod.blockThorolideOre, 8);

	public static WorldGenMinable genCrystalBlack = new WorldGenMinable(StarWarsMod.blockCrystalOre, 0, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalBlue = new WorldGenMinable(StarWarsMod.blockCrystalOre, 1, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalCyan = new WorldGenMinable(StarWarsMod.blockCrystalOre, 2, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalGray = new WorldGenMinable(StarWarsMod.blockCrystalOre, 3, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalGreen = new WorldGenMinable(StarWarsMod.blockCrystalOre, 4, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalPink = new WorldGenMinable(StarWarsMod.blockCrystalOre, 5, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalPurple = new WorldGenMinable(StarWarsMod.blockCrystalOre, 6, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalWhite = new WorldGenMinable(StarWarsMod.blockCrystalOre, 7, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalYellow = new WorldGenMinable(StarWarsMod.blockCrystalOre, 8, 3, StarWarsMod.blockIlumStone);
	public static WorldGenMinable genCrystalPrism = new WorldGenMinable(StarWarsMod.blockCrystalOre, 9, 3, StarWarsMod.blockIlumStone);

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		// iron: this.deposit(20, this.ironGen, 0, 64);

		// gold: this.deposit(2, this.goldGen, 0, 32);

		if (world.provider.dimensionId == 0)
		{
			deposit(world, chunkX, chunkZ, 2, genRubindum, 0, 32);
			deposit(world, chunkX, chunkZ, 20, genChromium, 0, 64);
			deposit(world, chunkX, chunkZ, 20, genTitanium, 0, 64);
		}
		else if (world.provider.dimensionId == Resources.ConfigOptions.dimYavin4Id)
		{
			deposit(world, chunkX, chunkZ, 20, genKelerium, 0, 64);
		}
		else if (world.provider.dimensionId == Resources.ConfigOptions.dimTatooineId)
		{
			deposit(world, chunkX, chunkZ, 20, genChromium, 0, 64);
			deposit(world, chunkX, chunkZ, 20, genTitanium, 0, 64);
		}
		else if (world.provider.dimensionId == Resources.ConfigOptions.dimIlumId)
		{
			deposit(world, chunkX, chunkZ, 2, genDiatium, 8, 40);

			deposit(world, chunkX, chunkZ, 1, genCrystalBlue, 8, 40);
			deposit(world, chunkX, chunkZ, 1, genCrystalGreen, 8, 40);

			if (MathUtils.oneIn(2))
			{
				deposit(world, chunkX, chunkZ, 1, genCrystalYellow, 8, 40);
				deposit(world, chunkX, chunkZ, 1, genCrystalCyan, 8, 40);
			}

			if (MathUtils.oneIn(4))
			{
				deposit(world, chunkX, chunkZ, 1, genCrystalBlack, 8, 40);
				deposit(world, chunkX, chunkZ, 1, genCrystalGray, 8, 40);
				deposit(world, chunkX, chunkZ, 1, genCrystalPink, 8, 40);
				deposit(world, chunkX, chunkZ, 1, genCrystalPurple, 8, 40);
				deposit(world, chunkX, chunkZ, 1, genCrystalWhite, 8, 40);
			}

			if (MathUtils.oneIn(8))
			{
				deposit(world, chunkX, chunkZ, 1, genCrystalPrism, 8, 40);
			}

		}
		else if (world.provider.dimensionId == Resources.ConfigOptions.dimHothId)
		{
			deposit(world, chunkX, chunkZ, 20, genExonium, 0, 64);
		}
		else if (world.provider.dimensionId == Resources.ConfigOptions.dimEndorId)
		{
			deposit(world, chunkX, chunkZ, 2, genHelecite, 0, 32);
			deposit(world, chunkX, chunkZ, 20, genThoralide, 0, 64);
		}
	}

	private void deposit(World world, int chunk_X, int chunk_Z, int depositsPerChunk, WorldGenerator oreGenerator, int yMin, int yMax)
	{
		for (int l = 0; l < depositsPerChunk; l++)
		{
			int i1 = chunk_X * 16 + StarWarsMod.rngGeneral.nextInt(16);
			int j1 = StarWarsMod.rngGeneral.nextInt(yMax - yMin) + yMin;
			int k1 = chunk_Z * 16 + StarWarsMod.rngGeneral.nextInt(16);
			oreGenerator.generate(world, StarWarsMod.rngGeneral, i1, j1, k1);
		}
	}
}
