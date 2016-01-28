package com.parzivail.pswm.dimension.dagobah;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.gen.WorldGenDagobahSwamp;

public class BiomeGenDagobah extends BiomeGenPSWM
{
	public BiomeGenDagobah(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Dagobah");

		this.enableRain = true;
		this.enableSnow = false;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.1f;

		this.waterColorMultiplier = 0x000000;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.grassPerChunk = 16;
		this.theBiomeDecorator.treesPerChunk = 4;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = 3;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			WorldGenDagobahSwamp worldgenabstracttree = new WorldGenDagobahSwamp();
			worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);
			worldgenabstracttree.generate(par1World, par2Random, k, i1, l, 7, 25);
		}

		for (int j = 0; j < this.theBiomeDecorator.grassPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			WorldGenerator worldgenerator = this.getRandomWorldGenForGrass(par2Random);
			worldgenerator.generate(par1World, par2Random, k, i1, l);
		}
	}

	@Override
	public void genTerrainBlocks(World world, Random random, Block[] blocks, byte[] bytes, int a, int b, double c)
	{
		double d1 = plantNoise.func_151601_a(a * 0.25D, b * 0.25D);

		if (d1 > 0.0D)
		{
			int k = a & 15;
			int l = b & 15;
			int i1 = blocks.length / 256;

			for (int j1 = 255; j1 >= 0; --j1)
			{
				int k1 = (l * 16 + k) * i1 + j1;

				if (blocks[k1] == null || blocks[k1].getMaterial() != Material.air)
				{
					if (j1 <= 75 && blocks[k1] != Blocks.water)
					{
						blocks[k1] = Blocks.water;

						if (d1 < 0.12D)
							blocks[k1 + 1] = Blocks.waterlily;
					}

					break;
				}
			}
		}

		this.genBiomeTerrain(world, random, blocks, bytes, a, b, c);
	}

	@Override
	public int getSkyColorByTemp(float n)
	{
		return 0x303030;
	}
}