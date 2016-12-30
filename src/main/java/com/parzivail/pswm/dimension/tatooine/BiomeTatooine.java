package com.parzivail.pswm.dimension.tatooine;

import com.parzivail.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Random;

/**
 * Created by colby on 12/30/2016.
 */
public class BiomeTatooine extends Biome
{
	public BiomeTatooine()
	{
		super(new BiomeProperties("Tatooine").setBaseBiome("tatooine").setRainDisabled().setTemperature(1));
		this.setRegistryName(Util.modcolon(this.getBiomeName().toLowerCase()));
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		//super.decorate(worldIn, rand, pos);
	}
}
