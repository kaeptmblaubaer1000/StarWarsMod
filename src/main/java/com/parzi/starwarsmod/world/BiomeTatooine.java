package com.parzi.starwarsmod.world;

import java.util.Random;

import com.parzi.starwarsmod.mobs.MobJawa;
import com.parzi.starwarsmod.mobs.MobTusken;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeTatooine extends BiomeGenBase {

	public BiomeTatooine(int par1) {
		super(par1);
		this.heightVariation = 0.001F;

		this.spawnableMonsterList.clear();
		this.spawnableMonsterList.add(MobJawa.class);
		this.spawnableMonsterList.add(MobTusken.class);

		this.spawnableCreatureList.clear();

		this.setBiomeName("Tatooine");

		this.topBlock = Blocks.sand;
		this.fillerBlock = Blocks.sandstone;

		this.theBiomeDecorator = new TatooineBiomeDecorator();
	}

	@Override
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(30) == 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenMV worldGenMV = new WorldGenMV();
            worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
        }
    }
}
