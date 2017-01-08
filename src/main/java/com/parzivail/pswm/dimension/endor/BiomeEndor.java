package com.parzivail.pswm.dimension.endor;

import com.parzivail.pswm.worldgen.GeneratorEndorTree;
import com.parzivail.pswm.worldgen.GeneratorFallenLog;
import com.parzivail.util.Util;
import com.parzivail.util.math.HaltonSequence;
import com.parzivail.util.math.MathUtils;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeEndor extends Biome
{
	HaltonSequence haltonSequence = new HaltonSequence();
	public WorldGenerator tallgrassGen = new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);

	private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
	private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.DECAYABLE, false);

	GeneratorEndorTree endorTree = new GeneratorEndorTree(JUNGLE_LOG, JUNGLE_LEAF, 40, 50);
	GeneratorFallenLog fallenLog = new GeneratorFallenLog(JUNGLE_LOG);

	public BiomeEndor()
	{
		super(new BiomeProperties("Forest Moon of Endor").setBaseBiome("endor").setRainfall(0.5f).setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
		haltonSequence.reset();
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		haltonSequence.increment();
		int tk = (int)(haltonSequence.mCurrentPos.getX() * 16) + 8;
		int tl = (int)(haltonSequence.mCurrentPos.getZ() * 16) + 8;
		BlockPos tblockpos = worldIn.getHeight(pos.add(tk, 0, tl));
		endorTree.generate(worldIn, rand, tblockpos, MathUtils.oneIn(4));

		if (MathUtils.oneIn(5))
		{
			haltonSequence.increment();
			int k = (int)(haltonSequence.mCurrentPos.getX() * 16) + 8;
			int l = (int)(haltonSequence.mCurrentPos.getZ() * 16) + 8;
			BlockPos blockpos = pos.add(k, 255, l);
			haltonSequence.increment();
			int k1 = (int)(haltonSequence.mCurrentPos.getX() * 16) + 8;
			int l1 = (int)(haltonSequence.mCurrentPos.getZ() * 16) + 8;
			BlockPos blockpos1 = pos.add(k1, 255, l1);
			fallenLog.generate(worldIn, rand, blockpos, blockpos1);
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
