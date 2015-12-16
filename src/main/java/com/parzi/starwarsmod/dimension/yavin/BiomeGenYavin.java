package com.parzi.starwarsmod.dimension.yavin;

import java.util.Random;

import com.parzi.starwarsmod.dimension.BiomeGenPSWM;
import com.parzi.starwarsmod.world.gen.WorldGenHothGenerator;
import com.parzi.starwarsmod.world.gen.WorldGenMegaKashyyykJungle;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenShrub;

public class BiomeGenYavin extends BiomeGenPSWM
{
	public BiomeGenYavin(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Yavin Four");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.spawnableCreatureList.clear();

		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;

		this.theBiomeDecorator.treesPerChunk = 5;
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
            WorldGenAbstractTree worldgenabstracttree = getTreeAt(par2Random, k, i1, l);
            worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);

            if (worldgenabstracttree.generate(par1World, par2Random, k, i1, l))
            {
                worldgenabstracttree.func_150524_b(par1World, par2Random, k, i1, l);
            }
        }
	}
	
	@Override
    public WorldGenAbstractTree getTreeAt(Random p_150567_1_, int x, int y, int z)
    {
    	if (y > 80) return new WorldGenMegaJungle(true, 10, 5, 3, 3);
        switch (p_150567_1_.nextInt(3))
        {
        	case 0:
        		return new WorldGenBigTree(true);
        	case 1:
        		return new WorldGenForest(true, true);
        	case 2:
        		return new WorldGenShrub(2, 0);
        }
        return null;
    }
}