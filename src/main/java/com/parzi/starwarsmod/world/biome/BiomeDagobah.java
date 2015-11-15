package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTrees;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.gen.WorldGenMV;
import com.parzi.starwarsmod.world.gen.WorldGenSuperTatooineHomestead;
import com.parzi.starwarsmod.world.gen.WorldGenTatooineHomestead;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_00;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_01;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_02;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_03;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_04;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_05;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_06;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_07;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_08;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_10;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_11;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_12;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_13;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_14;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_15;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_16;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_17;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_18;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_20;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_21;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_22;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_23;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_24;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_25;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_26;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_27;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_28;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_30;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_31;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_32;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_33;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_34;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_35;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_36;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_37;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_38;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_40;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_41;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_42;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_43;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_44;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_45;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_46;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_47;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_48;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_50;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_51;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_52;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_53;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_54;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_55;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_56;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_57;
import com.parzi.starwarsmod.world.gen.moseisley.big.ME_58;

public class BiomeDagobah extends BiomeGenBase
{
	BiomeDecoratorDagobah decorator;

	public BiomeDagobah(int par1)
	{
		super(par1);

		decorator = new BiomeDecoratorDagobah();

		this.heightVariation = 0.1F;
		this.enableRain = true;
		this.enableSnow = false;
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.setBiomeName("Dagobah");
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.color = 0x00CC99;
		this.waterColorMultiplier = 10;

		decorator.treesPerChunk = 4;
	}

	@Override
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		decorator.decorateChunk(par1World, par2Random, this, chunkX, chunkZ);
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
	{
		return new WorldGenMegaJungle(false, 10, 20, 3, 3);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeTatooine.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */