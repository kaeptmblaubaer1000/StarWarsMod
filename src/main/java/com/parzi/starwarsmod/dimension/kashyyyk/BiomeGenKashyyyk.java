package com.parzi.starwarsmod.dimension.kashyyyk;

import java.util.Random;

import com.parzi.starwarsmod.dimension.BiomeGenPSWM;
import com.parzi.starwarsmod.world.gen.WorldGenHothGenerator;
import com.parzi.starwarsmod.world.gen.WorldGenMegaKashyyykJungle;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeGenKashyyyk extends BiomeGenPSWM
{
	public BiomeGenKashyyyk(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Kashyyyk");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.spawnableCreatureList.clear();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.treesPerChunk = 2;
		this.theBiomeDecorator.deadBushPerChunk = -999;
		this.theBiomeDecorator.reedsPerChunk = 3;
		this.theBiomeDecorator.cactiPerChunk = -999;

		this.spawnableCreatureList.clear();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (par2Random.nextInt(10) == 0)
		{
			int k = chunkX + 4;
			int l = chunkZ + 4;
			new WorldGenHothGenerator().generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
		for (int j = 0; j < this.theBiomeDecorator.treesPerChunk; j++)
        {
            int k = chunkX + par2Random.nextInt(16) + 8;
            int l = chunkZ + par2Random.nextInt(16) + 8;
            int i1 = par1World.getHeightValue(k, l);
            WorldGenAbstractTree worldgenabstracttree = func_150567_a(par2Random);
            worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

            if (worldgenabstracttree.generate(par1World, par2Random, k, i1, l))
            {
                worldgenabstracttree.func_150524_b(par1World, par2Random, k, i1, l);
            }
        }
	}
	
	@Override
    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return (WorldGenAbstractTree)new WorldGenMegaKashyyykJungle(false, 10, 20, 3, 3);
    }
}