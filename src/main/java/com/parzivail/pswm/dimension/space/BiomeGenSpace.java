package com.parzivail.pswm.dimension.space;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenSpace extends BiomeGenPSWM
{
	public BiomeGenSpace(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Space");

		this.enableRain = false;
		this.enableSnow = false;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.0f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = null;
		this.fillerBlock = null;

		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (chunkX == 0 && chunkZ == 0)
		{
			for (int i = 0; i < 16; i++)
				for (int j = 0; j < 16; j++)
					par1World.setBlock(i, 0, j, Blocks.stone);
		}
	}
}