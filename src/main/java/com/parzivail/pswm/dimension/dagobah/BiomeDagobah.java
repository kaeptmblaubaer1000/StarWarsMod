package com.parzivail.pswm.dimension.dagobah;

import com.parzivail.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeDagobah extends Biome
{
	public BiomeDagobah()
	{
		super(new BiomeProperties("Dagobah").setBaseBiome("dagobah").setRainfall(1).setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		//super.decorate(worldIn, rand, pos);
	}
}
