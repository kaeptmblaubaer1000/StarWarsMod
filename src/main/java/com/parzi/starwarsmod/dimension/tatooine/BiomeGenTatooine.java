package com.parzi.starwarsmod.dimension.tatooine;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.dimension.BiomeGenPSWM;
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

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenTatooine extends BiomeGenPSWM
{	
	private int mosY;

	public BiomeGenTatooine(int biomeId)
	{
		super(biomeId);
		
		this.setBiomeName("Tatooine");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.0f;
		
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
	public void decorate(World par1World, Random par2Random, int chunkX, int chunkZ)
	{
		if (chunkX == 0 && chunkZ == 0)
		{
			this.mosY = par1World.getHeightValue(chunkX, chunkZ);
			new ME_00().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		}
		else if (chunkX == 0 && chunkZ == 32)
			new ME_01().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 64)
			new ME_02().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 96)
			new ME_03().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 128)
			new ME_04().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 160)
			new ME_05().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 192)
			new ME_06().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 224)
			new ME_07().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 0 && chunkZ == 256)
			new ME_08().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 0)
			new ME_10().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 32)
			new ME_11().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 64)
			new ME_12().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 96)
			new ME_13().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 128)
			new ME_14().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 160)
			new ME_15().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 192)
			new ME_16().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 224)
			new ME_17().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 32 && chunkZ == 256)
			new ME_18().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 0)
			new ME_20().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 32)
			new ME_21().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 64)
			new ME_22().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 96)
			new ME_23().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 128)
			new ME_24().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 160)
			new ME_25().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 192)
			new ME_26().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 224)
			new ME_27().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 64 && chunkZ == 256)
			new ME_28().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 0)
			new ME_30().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 32)
			new ME_31().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 64)
			new ME_32().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 96)
			new ME_33().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 128)
			new ME_34().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 160)
			new ME_35().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 192)
			new ME_36().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 224)
			new ME_37().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 96 && chunkZ == 256)
			new ME_38().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 0)
			new ME_40().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 32)
			new ME_41().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 64)
			new ME_42().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 96)
			new ME_43().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 128)
			new ME_44().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 160)
			new ME_45().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 192)
			new ME_46().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 224)
			new ME_47().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 128 && chunkZ == 256)
			new ME_48().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 0)
			new ME_50().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 32)
			new ME_51().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 64)
			new ME_52().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 96)
			new ME_53().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 128)
			new ME_54().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 160)
			new ME_55().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 192)
			new ME_56().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 224)
			new ME_57().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		else if (chunkX == 160 && chunkZ == 256) new ME_58().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
		if (par2Random.nextInt(400) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenSuperTatooineHomestead worldGenSuperHomestead = new WorldGenSuperTatooineHomestead();
			worldGenSuperHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
		if (par2Random.nextInt(30) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenMV worldGenMV = new WorldGenMV();
			worldGenMV.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 2, l);
		}
		if (par2Random.nextInt(300) == 0)
		{
			int k = chunkX + par2Random.nextInt(16) + 8;
			int l = chunkZ + par2Random.nextInt(16) + 8;
			WorldGenTatooineHomestead worldGenHomestead = new WorldGenTatooineHomestead();
			worldGenHomestead.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
    }
}
