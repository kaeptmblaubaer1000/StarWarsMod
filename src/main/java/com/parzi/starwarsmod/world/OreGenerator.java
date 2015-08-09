package com.parzi.starwarsmod.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				generateEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ)
	{
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		for (int k = 0; k < 10; k++)
		{
			int firstBlockXCoord = chunkX + StarWarsMod.rngChromium.nextInt(16);
			int firstBlockYCoord = StarWarsMod.rngChromium.nextInt(64);
			int firstBlockZCoord = chunkZ + StarWarsMod.rngChromium.nextInt(16);
			new WorldGenMinable(StarWarsMod.chromiumOre, 4).generate(world, StarWarsMod.rngChromium, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);

			firstBlockXCoord = chunkX + StarWarsMod.rngTitanium.nextInt(16);
			firstBlockYCoord = StarWarsMod.rngTitanium.nextInt(64);
			firstBlockZCoord = chunkZ + StarWarsMod.rngTitanium.nextInt(16);
			new WorldGenMinable(StarWarsMod.titaniumOre, 4).generate(world, StarWarsMod.rngTitanium, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
	}
}
