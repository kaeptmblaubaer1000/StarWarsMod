package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorTatooine extends BiomeDecorator
{
	public World currentWorld;
	public Random randomGenerator;
	public int chunk_X;
	public int chunk_Z;
	public WorldGenerator clayGen = new WorldGenClay(4);
	public WorldGenerator sandGen;
	public WorldGenerator gravelAsSandGen;
	public WorldGenerator dirtGen;
	public WorldGenerator coalGen;
	public WorldGenerator ironGen;
	public WorldGenerator goldGen;
	public WorldGenerator diamondGen;
	public int sandPerChunk;
	public int sandPerChunk2;
	public int clayPerChunk;

	public BiomeDecoratorTatooine()
	{
		this.sandGen = new WorldGenSand(Blocks.sand, 7);
		this.gravelAsSandGen = new WorldGenSand(Blocks.gravel, 6);
		this.coalGen = new WorldGenMinable(Blocks.coal_ore, 16);
		this.ironGen = new WorldGenMinable(Blocks.iron_ore, 8);
		this.goldGen = new WorldGenMinable(Blocks.gold_ore, 8);
		this.diamondGen = new WorldGenMinable(Blocks.diamond_ore, 7);
		this.sandPerChunk = 1;
		this.sandPerChunk2 = 3;
		this.clayPerChunk = 1;
	}

	public void func_150512_a(World p_150512_1_, Random p_150512_2_, BiomeGenBase p_150512_3_, int p_150512_4_, int p_150512_5_)
	{
		if (this.currentWorld != null) throw new RuntimeException("Already decorating!!");
		this.currentWorld = p_150512_1_;
		this.randomGenerator = p_150512_2_;
		this.chunk_X = p_150512_4_;
		this.chunk_Z = p_150512_5_;
		this.func_150513_a(p_150512_3_);
		this.currentWorld = null;
		this.randomGenerator = null;
	}

	protected void func_150513_a(BiomeGenBase p_150513_1_)
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
		this.generateOres();
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
	}

	@Override
	protected void generateOres()
	{
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.coalGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.COAL)) this.genStandardOre1(20, this.coalGen, 0, 128);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.ironGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.IRON)) this.genStandardOre1(20, this.ironGen, 0, 64);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.goldGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.GOLD)) this.genStandardOre1(2, this.goldGen, 0, 32);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.diamondGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.DIAMOND)) this.genStandardOre1(1, this.diamondGen, 0, 16);
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
	}

	@Override
	protected void genStandardOre1(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_)
	{
		for (int l = 0; l < p_76795_1_; l++)
		{
			int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
			int j1 = this.randomGenerator.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
			int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
			p_76795_2_.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
		}
	}

	@Override
	protected void genStandardOre2(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_)
	{
		for (int l = 0; l < p_76793_1_; l++)
		{
			int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
			int j1 = this.randomGenerator.nextInt(p_76793_4_) + this.randomGenerator.nextInt(p_76793_4_) + p_76793_3_ - p_76793_4_;
			int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
			p_76793_2_.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
		}
	}

	private int nextInt(int i)
	{
		if (i <= 1) return 0;
		return this.randomGenerator.nextInt(i);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\world\biome\BiomeDecoratorTatooine.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */