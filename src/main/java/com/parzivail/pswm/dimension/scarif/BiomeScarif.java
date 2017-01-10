package com.parzivail.pswm.dimension.scarif;

import com.parzivail.pswm.worldgen.GeneratorPalmTree;
import com.parzivail.util.Util;
import com.parzivail.util.math.HaltonSequence;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeScarif extends Biome
{
	HaltonSequence haltonSequence = new HaltonSequence();
	private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.DECAYABLE, false);
	GeneratorPalmTree palmTree = new GeneratorPalmTree(Blocks.LOG.getDefaultState(), JUNGLE_LEAF, 7, 12);

	public BiomeScarif()
	{
		super(new BiomeProperties("Scarif").setBaseBiome("scarif").setRainfall(1).setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
		haltonSequence.reset();
	}

	@Override
	public int getModdedBiomeFoliageColor(int original)
	{
		return getModdedBiomeGrassColor(original);
	}

	@Override
	public int getModdedBiomeGrassColor(int original)
	{
		return 0x00ff00;
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		for (int i = 0; i < 4; i++)
		{
			haltonSequence.increment();
			int k = (int)(haltonSequence.mCurrentPos.getX() * 16) + 8;
			int l = (int)(haltonSequence.mCurrentPos.getZ() * 16) + 8;
			BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));

			palmTree.generate(worldIn, rand, blockpos);
		}
	}
}
