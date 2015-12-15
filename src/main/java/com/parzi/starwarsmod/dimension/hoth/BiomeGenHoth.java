package com.parzi.starwarsmod.dimension.hoth;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.LAPIS;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.REDSTONE;

import java.util.Random;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.world.gen.WorldGenHothGenerator;
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
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeGenHoth extends BiomeGenBase
{
	public BiomeGenHoth(int biomeId)
	{
		super(biomeId);

		this.setBiomeName("Hoth");

		this.rootHeight = 0.1f;
		this.heightVariation = 0.2f;

		this.spawnableCreatureList.clear();

		this.topBlock = Blocks.snow;
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
		if (par2Random.nextInt(10) == 0)
		{
			int k = chunkX + 4;
			int l = chunkZ + 4;
			new WorldGenHothGenerator().generate(par1World, par2Random, k, par1World.getHeightValue(k, l) - 3, l);
		}
	}
}