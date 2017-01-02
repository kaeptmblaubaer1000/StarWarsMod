package com.parzivail.pswm.dimension.dagobah;

import com.parzivail.util.Util;
import com.parzivail.util.math.HaltonSequence;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeDagobah extends Biome
{
	WorldGenTrees trees = new WorldGenTrees(true, 8, Blocks.LOG.getDefaultState(), Blocks.LEAVES.getDefaultState(), true);
	HaltonSequence haltonSequence = new HaltonSequence();

	public BiomeDagobah()
	{
		super(new BiomeProperties("Dagobah").setBaseBiome("dagobah").setRainfall(1).setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
		haltonSequence.reset();
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		for (int i = 0; i < 3; i++)
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
	}
}
