package com.parzivail.pswm.dimension.dagobah;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.StructureBank;
import com.parzivail.pswm.world.gen.WorldGenDagobahSwamp;
import com.parzivail.util.math.MathUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class BiomeGenDagobah extends BiomeGenPSWM
{
	private int structureY;

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
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = 3;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.theBiomeDecorator.waterlilyPerChunk = 4;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		structureY = (int)MathUtils.map(this.rootHeight, -2, 2, 0, 128);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		StructureBank.getYodaHut().genComposite(par1World, chunkX, structureY, chunkZ, 0, 0);

		if (chunkX >= 0 && chunkX <= 64 && chunkZ >= 0 && chunkZ <= 64)
		{
			for (int x = chunkX; x < chunkX + 16; x++)
				for (int z = chunkZ; z < chunkZ + 16; z++)
					for (int y = this.structureY - 1; y > this.structureY - 3; y--)
						par1World.setBlock(x, y, z, Blocks.grass);

			for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
			{
				int k = chunkX + par2Random.nextInt(16) + 8;
				int l = chunkZ + par2Random.nextInt(16) + 8;
				int i1 = this.structureY;
				switch (StarWarsMod.rngGeneral.nextInt(2))
				{
					case 0:
						WorldGenDagobahSwamp worldgenabstracttree = new WorldGenDagobahSwamp();
						worldgenabstracttree.generate(par1World, par2Random, k, i1, l, 7, 25);
						break;
					case 1:
						WorldGenMegaJungle worldgenabstracttree2 = new WorldGenMegaJungle(true, 7, 25, 0, 0);
						worldgenabstracttree2.generate(par1World, par2Random, k, i1, l);
						break;
				}
			}
		}

		for (int j = 0; j < this.theBiomeDecorator.grassPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			while (par1World.getBlock(k, i1, l) != Blocks.grass)
			{
				i1--;
				if (i1 >= 20)
				{
					i1 = par1World.getHeightValue(k, l);
					break;
				}
			}
			WorldGenerator worldgenerator = null;
			switch (StarWarsMod.rngGeneral.nextInt(4))
			{
				case 0:
					worldgenerator = new WorldGenTallGrass(Blocks.tallgrass, 2);
					break;
				case 1:
					WorldGenDoublePlant p = new WorldGenDoublePlant();
					p.func_150548_a(2);
					worldgenerator = p;
					break;
				case 2:
					WorldGenDoublePlant p2 = new WorldGenDoublePlant();
					p2.func_150548_a(3);
					worldgenerator = p2;
					break;
				case 3:
					worldgenerator = new WorldGenTallGrass(Blocks.tallgrass, 1);
					break;
			}
			worldgenerator.generate(par1World, par2Random, k, i1, l);
		}

		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			while (par1World.getBlock(k, i1--, l) != Blocks.grass)
				if (i1 <= 20)
				{
					i1 = par1World.getHeightValue(k, l);
					break;
				}
			switch (StarWarsMod.rngGeneral.nextInt(2))
			{
				case 0:
					WorldGenDagobahSwamp worldgenabstracttree = new WorldGenDagobahSwamp();
					worldgenabstracttree.generate(par1World, par2Random, k, i1, l, 7, 25);
					break;
				case 1:
					WorldGenMegaJungle worldgenabstracttree2 = new WorldGenMegaJungle(true, 7, 25, 0, 0);
					worldgenabstracttree2.generate(par1World, par2Random, k, i1, l);
					break;
			}
		}

		for (int j = 0; j < this.theBiomeDecorator.waterlilyPerChunk; j++)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			int i1 = par1World.getHeightValue(k, l);
			new WorldGenWaterlily().generate(par1World, par2Random, k, i1, l);
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
		return super.getSkyColorByTemp(n);
	}
}