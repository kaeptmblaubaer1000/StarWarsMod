package com.parzi.starwarsmod.world.biome;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenClay;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BiomeDecoratorEndor extends BiomeDecorator
{
	private static final String __OBFID = "CL_00000164";
	public World currentWorld;
	public Random randomGenerator;
	public int chunk_X;
	public int chunk_Z;
	public WorldGenerator clayGen = new WorldGenClay(4);
	public WorldGenerator sandGen;
	public WorldGenerator gravelAsSandGen;
	public WorldGenerator dirtGen;
	public WorldGenerator gravelGen;
	public WorldGenerator coalGen;
	public WorldGenerator ironGen;
	public WorldGenerator goldGen;
	public WorldGenerator redstoneGen;
	public WorldGenerator diamondGen;
	public WorldGenerator lapisGen;
	public WorldGenFlowers field_150514_p;
	public WorldGenerator mushroomBrownGen;
	public WorldGenerator mushroomRedGen;
	public WorldGenerator bigMushroomGen;
	public WorldGenerator reedGen;
	public WorldGenerator cactusGen;
	public WorldGenerator waterlilyGen;
	public int waterlilyPerChunk;
	public int treesPerChunk;
	public int flowersPerChunk;
	public int grassPerChunk;
	public int deadBushPerChunk;
	public int mushroomsPerChunk;
	public int reedsPerChunk;
	public int cactiPerChunk;
	public int sandPerChunk;
	public int sandPerChunk2;
	public int clayPerChunk;
	public int bigMushroomsPerChunk;
	public boolean generateLakes;

	public BiomeDecoratorEndor()
	{
		this.sandGen = new WorldGenSand(Blocks.sand, 7);
		this.gravelAsSandGen = new WorldGenSand(Blocks.gravel, 6);
		this.dirtGen = new WorldGenMinable(Blocks.dirt, 32);
		this.gravelGen = new WorldGenMinable(Blocks.gravel, 32);
		this.coalGen = new WorldGenMinable(Blocks.coal_ore, 16);
		this.ironGen = new WorldGenMinable(Blocks.iron_ore, 8);
		this.goldGen = new WorldGenMinable(Blocks.gold_ore, 8);
		this.redstoneGen = new WorldGenMinable(Blocks.redstone_ore, 7);
		this.diamondGen = new WorldGenMinable(Blocks.diamond_ore, 7);
		this.lapisGen = new WorldGenMinable(Blocks.lapis_ore, 6);
		this.field_150514_p = new WorldGenFlowers(Blocks.yellow_flower);
		this.mushroomBrownGen = new WorldGenFlowers(Blocks.brown_mushroom);
		this.mushroomRedGen = new WorldGenFlowers(Blocks.red_mushroom);
		this.bigMushroomGen = new WorldGenBigMushroom();
		this.reedGen = new WorldGenReed();
		this.cactusGen = new WorldGenCactus();
		this.waterlilyGen = new WorldGenWaterlily();
		this.flowersPerChunk = 2;
		this.grassPerChunk = 1;
		this.sandPerChunk = 1;
		this.sandPerChunk2 = 3;
		this.clayPerChunk = 1;
		this.generateLakes = true;
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
		boolean doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SAND);
		for (int i = 0; doGen && i < this.sandPerChunk2; i++)
		{
			int j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			this.sandGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CLAY);
		for (int i = 0; doGen && i < this.clayPerChunk; i++)
		{
			int j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			this.clayGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SAND_PASS2);
		for (int i = 0; doGen && i < this.sandPerChunk; i++)
		{
			int j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			this.gravelAsSandGen.generate(this.currentWorld, this.randomGenerator, j, this.currentWorld.getTopSolidOrLiquidBlock(j, k), k);
		}
		int i = this.treesPerChunk;
		if (this.randomGenerator.nextInt(10) == 0) i++;
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.TREE);
		for (int j = 0; doGen && j < i; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.currentWorld.getHeightValue(k, l);
			WorldGenAbstractTree worldgenabstracttree = p_150513_1_.func_150567_a(this.randomGenerator);
			worldgenabstracttree.setScale(1.0D, 1.0D, 1.0D);
			if (worldgenabstracttree.generate(this.currentWorld, this.randomGenerator, k, i1, l)) worldgenabstracttree.func_150524_b(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM);
		for (int j = 0; doGen && j < this.bigMushroomsPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			this.bigMushroomGen.generate(this.currentWorld, this.randomGenerator, k, this.currentWorld.getHeightValue(k, l), l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.FLOWERS);
		for (int j = 0; doGen && j < this.flowersPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) + 32);
			String s = p_150513_1_.func_150572_a(this.randomGenerator, k, i1, l);
			BlockFlower blockflower = BlockFlower.func_149857_e(s);
			if (blockflower.getMaterial() != Material.air)
			{
				this.field_150514_p.func_150550_a(blockflower, BlockFlower.func_149856_f(s));
				this.field_150514_p.generate(this.currentWorld, this.randomGenerator, k, i1, l);
			}
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.GRASS);
		for (int j = 0; doGen && j < this.grassPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
			WorldGenerator worldgenerator = p_150513_1_.getRandomWorldGenForGrass(this.randomGenerator);
			worldgenerator.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH);
		for (int j = 0; doGen && j < this.deadBushPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
			new WorldGenDeadBush(Blocks.deadbush).generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.LILYPAD);
		for (int j = 0; doGen && j < this.waterlilyPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			for (int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2); i1 > 0 && this.currentWorld.isAirBlock(k, i1 - 1, l); i1--)
			{
			}
			int i1 = this.currentWorld.getHeightValue(k, l);
			this.waterlilyGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.SHROOM);
		for (int j = 0; doGen && j < this.mushroomsPerChunk; j++)
		{
			if (this.randomGenerator.nextInt(4) == 0)
			{
				int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				int i1 = this.currentWorld.getHeightValue(k, l);
				this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
			}
			if (this.randomGenerator.nextInt(8) == 0)
			{
				int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
				this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
			}
		}
		if (doGen && this.randomGenerator.nextInt(4) == 0)
		{
			int j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int l = this.nextInt(this.currentWorld.getHeightValue(j, k) * 2);
			this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, j, l, k);
		}
		if (doGen && this.randomGenerator.nextInt(8) == 0)
		{
			int j = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int k = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int l = this.nextInt(this.currentWorld.getHeightValue(j, k) * 2);
			this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, j, l, k);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.REED);
		for (int j = 0; doGen && j < this.reedsPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
			this.reedGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		for (int j = 0; doGen && j < 10; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
			this.reedGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.CACTUS);
		for (int j = 0; doGen && j < this.cactiPerChunk; j++)
		{
			int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
			int l = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
			int i1 = this.nextInt(this.currentWorld.getHeightValue(k, l) * 2);
			this.cactusGen.generate(this.currentWorld, this.randomGenerator, k, i1, l);
		}
		doGen = TerrainGen.decorate(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z, DecorateBiomeEvent.Decorate.EventType.LAKE);
		if (doGen && this.generateLakes)
		{
			for (int j = 0; j < 50; j++)
			{
				int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				int l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8);
				int i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenLiquids(Blocks.flowing_water).generate(this.currentWorld, this.randomGenerator, k, l, i1);
			}
			for (int j = 0; j < 20; j++)
			{
				int k = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
				int l = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8);
				int i1 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
				new WorldGenLiquids(Blocks.flowing_lava).generate(this.currentWorld, this.randomGenerator, k, l, i1);
			}
		}
		MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
	}

	@Override
	protected void generateOres()
	{
		MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.dirtGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.DIRT)) this.genStandardOre1(20, this.dirtGen, 0, 256);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.gravelGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.GRAVEL)) this.genStandardOre1(10, this.gravelGen, 0, 256);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.coalGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.COAL)) this.genStandardOre1(20, this.coalGen, 0, 128);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.ironGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.IRON)) this.genStandardOre1(20, this.ironGen, 0, 64);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.goldGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.GOLD)) this.genStandardOre1(2, this.goldGen, 0, 32);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.redstoneGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.REDSTONE)) this.genStandardOre1(8, this.redstoneGen, 0, 16);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.diamondGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.DIAMOND)) this.genStandardOre1(1, this.diamondGen, 0, 16);
		if (TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.lapisGen, this.chunk_X, this.chunk_Z, OreGenEvent.GenerateMinable.EventType.LAPIS)) this.genStandardOre2(1, this.lapisGen, 16, 16);
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
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\biome\BiomeDecoratorEndor.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */