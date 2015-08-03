package com.parzi.starwarsmod.world.biome;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.COAL;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;

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
	/** The world the BiomeDecorator is currently decorating */
	public World currentWorld;
	/** The Biome Decorator's random number generator. */
	public Random randomGenerator;
	/** The X-coordinate of the chunk currently being decorated */
	public int chunk_X;
	/** The Z-coordinate of the chunk currently being decorated */
	public int chunk_Z;
	/** The clay generator. */
	public WorldGenerator clayGen = new WorldGenClay(4);
	/** The sand generator. */
	public WorldGenerator sandGen;
	/** The gravel generator. */
	public WorldGenerator gravelAsSandGen;
	/** The dirt generator. */
	public WorldGenerator dirtGen;
	public WorldGenerator coalGen;
	public WorldGenerator ironGen;
	/** Field that holds gold WorldGenMinable */
	public WorldGenerator goldGen;
	/** Field that holds diamond WorldGenMinable */
	public WorldGenerator diamondGen;
	/**
	 * The number of sand patches to generate per chunk. Sand patches only
	 * generate when part of it is underwater.
	 */
	public int sandPerChunk;
	/**
	 * The number of sand patches to generate per chunk. Sand patches only
	 * generate when part of it is underwater. There appear to be two separate
	 * fields for this.
	 */
	public int sandPerChunk2;
	/**
	 * The number of clay patches to generate per chunk. Only generates when
	 * part of it is underwater.
	 */
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

	@Override
	public void decorateChunk(World p_150512_1_, Random p_150512_2_, BiomeGenBase p_150512_3_, int p_150512_4_, int p_150512_5_)
	{
		if (this.currentWorld != null)
		{
			throw new RuntimeException("Already decorating!!");
		}
		else
		{
			this.currentWorld = p_150512_1_;
			this.randomGenerator = p_150512_2_;
			this.chunk_X = p_150512_4_;
			this.chunk_Z = p_150512_5_;
			this.genDecorations(p_150512_3_);
			this.currentWorld = null;
			this.randomGenerator = null;
		}
	}

	@Override
	protected void genDecorations(BiomeGenBase p_150513_1_)
	{
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
		this.generateOres();
		int i;
		int j;
		int k; /*
				 * 
				 * boolean doGen = TerrainGen.decorate(currentWorld,
				 * randomGenerator, chunk_X, chunk_Z, SAND); for (i = 0; doGen
				 * && i < this.sandPerChunk2; ++i) { j = this.chunk_X +
				 * this.randomGenerator.nextInt(16) + 8; k = this.chunk_Z +
				 * this.randomGenerator.nextInt(16) + 8;
				 * this.sandGen.generate(this.currentWorld,
				 * this.randomGenerator, j,
				 * this.currentWorld.getTopSolidOrLiquidBlock(j, k), k); }
				 * 
				 * doGen = TerrainGen.decorate(currentWorld, randomGenerator,
				 * chunk_X, chunk_Z, CLAY); for (i = 0; doGen && i <
				 * this.clayPerChunk; ++i) { j = this.chunk_X +
				 * this.randomGenerator.nextInt(16) + 8; k = this.chunk_Z +
				 * this.randomGenerator.nextInt(16) + 8;
				 * this.clayGen.generate(this.currentWorld,
				 * this.randomGenerator, j,
				 * this.currentWorld.getTopSolidOrLiquidBlock(j, k), k); }
				 * 
				 * doGen = TerrainGen.decorate(currentWorld, randomGenerator,
				 * chunk_X, chunk_Z, SAND_PASS2); for (i = 0; doGen && i <
				 * this.sandPerChunk; ++i) { j = this.chunk_X +
				 * this.randomGenerator.nextInt(16) + 8; k = this.chunk_Z +
				 * this.randomGenerator.nextInt(16) + 8;
				 * this.gravelAsSandGen.generate(this.currentWorld,
				 * this.randomGenerator, j,
				 * this.currentWorld.getTopSolidOrLiquidBlock(j, k), k); }
				 */
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
	}

	/**
	 * Standard ore generation helper. Generates most ores.
	 */

	@Override
	protected void genStandardOre1(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_)
	{
		for (int l = 0; l < p_76795_1_; ++l)
		{
			int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
			int j1 = this.randomGenerator.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
			int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
			p_76795_2_.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
		}
	}

	/**
	 * Standard ore generation helper. Generates Lapis Lazuli.
	 */

	@Override
	protected void genStandardOre2(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_)
	{
		for (int l = 0; l < p_76793_1_; ++l)
		{
			int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
			int j1 = this.randomGenerator.nextInt(p_76793_4_) + this.randomGenerator.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
			int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
			p_76793_2_.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
		}
	}

	/**
	 * Generates ores in the current chunk
	 */

	@Override
	protected void generateOres()
	{
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, chunk_X, chunk_Z));
		if (TerrainGen.generateOre(currentWorld, randomGenerator, coalGen, chunk_X, chunk_Z, COAL)) this.genStandardOre1(20, this.coalGen, 0, 128);
		if (TerrainGen.generateOre(currentWorld, randomGenerator, ironGen, chunk_X, chunk_Z, IRON)) this.genStandardOre1(20, this.ironGen, 0, 64);
		if (TerrainGen.generateOre(currentWorld, randomGenerator, goldGen, chunk_X, chunk_Z, GOLD)) this.genStandardOre1(2, this.goldGen, 0, 32);
		if (TerrainGen.generateOre(currentWorld, randomGenerator, diamondGen, chunk_X, chunk_Z, DIAMOND)) this.genStandardOre1(1, this.diamondGen, 0, 16);
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, chunk_X, chunk_Z));
	}

	private int nextInt(int i)
	{
		if (i <= 1) return 0;
		return this.randomGenerator.nextInt(i);
	}
}