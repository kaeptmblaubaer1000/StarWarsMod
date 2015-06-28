package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import com.parzi.starwarsmod.mobs.MobTauntaun;

public class BiomeHoth extends BiomeGenBase
{

	public BiomeHoth(int par1)
	{
		super(par1);
		this.heightVariation = 0.5F;

		this.enableRain = false;
		this.enableSnow = true;

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(MobTauntaun.class, 6, 1, 1));
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();

		this.setBiomeName("Hoth");

		this.topBlock = Blocks.snow;
		this.fillerBlock = Blocks.stone;

		this.temperature = 0.0F;
	}
}
