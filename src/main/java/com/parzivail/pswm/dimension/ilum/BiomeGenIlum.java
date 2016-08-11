package com.parzivail.pswm.dimension.ilum;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.StructureBank;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenIlum extends BiomeGenPSWM
{
	public BiomeGenIlum(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Ilum");

		this.temperature = 0;
		this.rainfall = 1;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.8f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = Blocks.snow;
		this.fillerBlock = StarWarsMod.blockIlumStone;

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
		StructureBank.getIlumTemple().genComposite(par1World, chunkX, 30, chunkZ, 0, 0);
	}
}