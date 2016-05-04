package com.parzivail.pswm.dimension.tatooine;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.dimension.BiomeGenPSWM;
import com.parzivail.pswm.world.gen.WorldGenMV;
import com.parzivail.pswm.world.gen.WorldGenSuperTatooineHomestead;
import com.parzivail.pswm.world.gen.WorldGenTatooineHomestead;
import com.parzivail.pswm.world.gen.moseisley.big.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

public class BiomeGenTatooine extends BiomeGenPSWM
{
	private int mosY;

	public BiomeGenTatooine(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Tatooine");

		this.enableRain = false;
		this.enableSnow = false;

		this.rootHeight = 0.1f;
		this.heightVariation = 0.0f;

		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.topBlock = StarWarsMod.blockTatooineSand;
		this.fillerBlock = Blocks.stone;

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
		else if (chunkX == 160 && chunkZ == 256)
			new ME_58().generate(par1World, par2Random, chunkX, this.mosY, chunkZ);
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
