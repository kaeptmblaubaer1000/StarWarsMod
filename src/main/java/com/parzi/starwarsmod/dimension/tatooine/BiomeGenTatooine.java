package com.parzi.starwarsmod.dimension.tatooine;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenTatooine extends BiomeGenBase
{	
	public BiomeGenTatooine(int biomeId)
	{
		super(biomeId);
		
		this.setBiomeName("Tatooine");
		
        this.spawnableCreatureList.clear();
        
        this.topBlock = StarWarsMod.blockTatooineSand;
        this.fillerBlock = Blocks.stone;
        
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = -999;
        this.theBiomeDecorator.reedsPerChunk = -999;
        this.theBiomeDecorator.cactiPerChunk = -999;
        
        this.spawnableCreatureList.clear();
    }

	@Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        if (random.nextInt(1000) == 0)
        {
        	// stuff
        }
    }
}
