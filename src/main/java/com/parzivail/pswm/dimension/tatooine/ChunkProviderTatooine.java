package com.parzivail.pswm.dimension.tatooine;

import com.parzivail.util.common.OpenSimplexNoise;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

/**
 * Created by colby on 12/22/2016.
 */
public class ChunkProviderTatooine implements IChunkGenerator
{
	private final World worldObj;
	private MapGenBase caveGenerator = new MapGenCaves();
	private MapGenBase ravineGenerator = new MapGenRavine();
	private OpenSimplexNoise simplexNoise;
	private OpenSimplexNoise simplexNoiseMult;
	private OpenSimplexNoise simplexNoiseMult2;
	private Random rand;

	public ChunkProviderTatooine(World worldIn, long seed, boolean mapFeaturesEnabledIn)
	{
		{
			caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(caveGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);
			ravineGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(ravineGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE);
		}
		this.worldObj = worldIn;
		simplexNoise = new OpenSimplexNoise(seed);
		simplexNoiseMult = new OpenSimplexNoise(seed + 1L);
		simplexNoiseMult2 = new OpenSimplexNoise(seed + 2L);
		rand = new Random(seed);
	}

	public void setBlocksInChunk(int cx, int cz, ChunkPrimer primer)
	{
		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				double height = simplexNoise.eval((cx * 16 + x) / 200d, (cz * 16 + z) / 200d) + 0.5;
				double mult = simplexNoiseMult.eval((cx * 16 + x) / 600d, (cz * 16 + z) / 600d) + 0.5;
				double mult2 = simplexNoiseMult.eval((cx * 16 + x) / 50d, (cz * 16 + z) / 50d) + 0.5;
				height = 60 + height * 50 * mult * mult2;
				primer.setBlockState(x, 0, z, Blocks.BEDROCK.getDefaultState());
				int finalHeight = (int)height;
				for (int y = 1; y <= finalHeight; y++)
				{
					double sandThreshold = height * 0.9;
					double sandstoneThreshold = height * 0.6;

					if (y >= sandThreshold)
						primer.setBlockState(x, y, z, Blocks.SAND.getDefaultState());
					else if (y >= sandstoneThreshold && y < sandThreshold)
						primer.setBlockState(x, y, z, Blocks.SANDSTONE.getDefaultState());
					else
						primer.setBlockState(x, y, z, Blocks.STONE.getDefaultState());
				}
			}
		}
	}

	public Chunk provideChunk(int x, int z)
	{
		ChunkPrimer chunkprimer = new ChunkPrimer();
		this.setBlocksInChunk(x, z, chunkprimer);

		this.caveGenerator.generate(this.worldObj, x, z, chunkprimer);
		this.ravineGenerator.generate(this.worldObj, x, z, chunkprimer);

		Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
		chunk.generateSkylightMap();
		return chunk;
	}

	public void populate(int x, int z)
	{
		BlockFalling.fallInstantly = true;
		int i = x * 16;
		int j = z * 16;

		// this.mineshaftGenerator.generateStructure(this.worldObj, this.rand, chunkpos);
		// TODO: GEN STRUCTURES HERE

		BlockFalling.fallInstantly = false;
	}

	public boolean generateStructures(Chunk chunkIn, int x, int z)
	{
		return false;
	}

	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
	{
		return this.worldObj.getBiome(pos).getSpawnableList(creatureType);
	}

	@Nullable
	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position, boolean p_180513_4_)
	{
		return null;
	}

	public void recreateStructures(Chunk chunkIn, int x, int z)
	{
		// TODO: GENERATE STRUCTURES (AGAIN) HERE
		// maybe some sort of generate-everything method?
	}
}