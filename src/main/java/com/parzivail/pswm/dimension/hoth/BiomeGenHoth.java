package com.parzivail.pswm.dimension.hoth;

import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.util.math.MathUtils;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenHoth extends BiomeGenPSWM
{
	private final int structureY;

	public BiomeGenHoth(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Hoth");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.temperature = 0;
		this.rainfall = 1;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.stone;

		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = -999;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		structureY = (int)MathUtils.map(this.rootHeight, -2, 2, 0, 128);
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (par2Random.nextInt(100) == 0)
		{
			int k = chunkX + 4;
			int l = chunkZ + 4;
			//gen hoth generator
		}

		//StructureBank.ilumTemple.genComposite(par1World, chunkX, 1, chunkZ);
	}
}