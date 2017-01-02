package com.parzivail.pswm.dimension.yavin;

import com.parzivail.util.Util;
import com.parzivail.util.math.HaltonSequence;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeYavin extends Biome
{
	WorldGenTrees trees = new WorldGenTrees(true, 7, Blocks.LOG.getDefaultState(), Blocks.LEAVES.getDefaultState(), false);
	HaltonSequence haltonSequence = new HaltonSequence();
	public WorldGenerator tallgrassGen = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);

	public BiomeYavin()
	{
		super(new BiomeProperties("Yavin 4").setBaseBiome("yavin").setRainfall(0.5f).setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
		haltonSequence.reset();
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		for (int i = 0; i < 4; i++)
		{
			haltonSequence.increment();
			int k = (int)(haltonSequence.mCurrentPos.getX() * 16);
			int l = (int)(haltonSequence.mCurrentPos.getZ() * 16);
			BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
			trees.setDecorationDefaults();

			if (trees.generate(worldIn, rand, blockpos))
			{
				trees.generateSaplings(worldIn, rand, blockpos);
			}
		}

		for (int i = 0; i < 8; i++)
		{
			int l7 = rand.nextInt(16) + 8;
			int k11 = rand.nextInt(16) + 8;
			int i15 = worldIn.getHeight(pos.add(l7, 0, k11)).getY() * 2;

			if (i15 > 0)
			{
				int j18 = rand.nextInt(i15);
				BlockPos blockpos4;
				BlockPos blockpos7;

				for (blockpos4 = pos.add(l7, j18, k11); blockpos4.getY() > 0; blockpos4 = blockpos7)
				{
					blockpos7 = blockpos4.down();

					if (!worldIn.isAirBlock(blockpos7))
					{
						break;
					}
				}

				this.tallgrassGen.generate(worldIn, rand, blockpos4);
			}
		}
	}
}
