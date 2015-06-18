package com.parzi.starwarsmod.world;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenMutated;

public class BiomeTatooine extends BiomeGenMutated {

	public BiomeTatooine(int par1) {
		super(par1, new BiomeGenDesert(par1));
		this.heightVariation = 0.001F;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.setBiomeName("Tatooine");
	}
}
