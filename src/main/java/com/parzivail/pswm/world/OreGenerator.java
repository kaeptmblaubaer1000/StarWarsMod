package com.parzivail.pswm.world;

import java.util.Random;

import com.parzivail.pswm.StarWarsMod;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenerator implements IWorldGenerator
{
	public static WorldGenMinable chromium = new WorldGenMinable(StarWarsMod.blockChromiumOre, 4);
	public static WorldGenMinable titanium = new WorldGenMinable(StarWarsMod.blockTitaniumOre, 4);

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1:
				this.generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
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
			chromium.generate(world, StarWarsMod.rngChromium, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
			firstBlockXCoord = chunkX + StarWarsMod.rngTitanium.nextInt(16);
			firstBlockYCoord = StarWarsMod.rngTitanium.nextInt(64);
			firstBlockZCoord = chunkZ + StarWarsMod.rngTitanium.nextInt(16);
			titanium.generate(world, StarWarsMod.rngTitanium, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\OreGenerator.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */