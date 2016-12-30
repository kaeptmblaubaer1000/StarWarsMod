package com.parzivail.pswm.dimension.dagobah;

import com.parzivail.pswm.bank.PBlocks;
import com.parzivail.util.worldgen.CompositeTerrain;
import com.parzivail.util.worldgen.ITerrainHeightmap;
import com.parzivail.util.worldgen.TerrainLayer;
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

/**
 * Created by colby on 12/22/2016.
 */
public class ChunkProviderDagobah implements IChunkGenerator
{
	private final World worldObj;
	private final int waterLevel;
	private MapGenBase caveGenerator = new MapGenCaves();
	private MapGenBase ravineGenerator = new MapGenRavine();
	private final ITerrainHeightmap terrain;

	public ChunkProviderDagobah(World worldIn, long seed)
	{
		caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(caveGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);
		ravineGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(ravineGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE);

		this.worldObj = worldIn;

		waterLevel = 4;
		terrain = new CompositeTerrain(new TerrainLayer(seed, TerrainLayer.Method.Add, 20, 0.4), new TerrainLayer(seed + 1, TerrainLayer.Method.Add, 200, 5), new TerrainLayer(seed + 2, TerrainLayer.Method.Multiply, 20, 3), new TerrainLayer(seed + 3, TerrainLayer.Method.Add, 5, 5), new TerrainLayer(seed + 4, TerrainLayer.Method.Multiply, 20, 0.4), new TerrainLayer(seed + 5, TerrainLayer.Method.Add, 30, 5));
	}

	public void setBlocksInChunk(int cx, int cz, ChunkPrimer primer)
	{
		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				int baseHeight = 60;
				double height = terrain.getHeightAt((cx * 16 + x), (cz * 16 + z));
				primer.setBlockState(x, 0, z, Blocks.BEDROCK.getDefaultState());
				int finalHeight = baseHeight + (int)height;
				for (int y = 1; y <= finalHeight; y++)
				{
					double grassThreshold = baseHeight + waterLevel + 1 + (height / 60);
					double mudThreshold = baseHeight + waterLevel - 5;

					if (y >= grassThreshold)
						primer.setBlockState(x, y, z, Blocks.GRASS.getDefaultState());
					else if (y >= mudThreshold && y < grassThreshold)
						primer.setBlockState(x, y, z, PBlocks.dagobahMud.getDefaultState());
					else
						primer.setBlockState(x, y, z, Blocks.DIRT.getDefaultState());
				}
				for (int y = finalHeight + 1; y <= baseHeight + waterLevel; y++) // water level
				{
					primer.setBlockState(x, y, z, Blocks.WATER.getDefaultState());
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