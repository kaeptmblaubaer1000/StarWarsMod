package com.parzivail.pswm.dimension.hoth;

import com.parzivail.util.worldgen.CompositeTerrain;
import com.parzivail.util.worldgen.IHeightmap;
import com.parzivail.util.worldgen.TerrainLayer;
import com.parzivail.util.worldgen.TripositeTerrain;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
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
public class ChunkProviderHoth implements IChunkGenerator
{
	private final World worldObj;
	private final int waterLevel;
	private MapGenBase caveGenerator = new MapGenCaves();
	private MapGenBase ravineGenerator = new MapGenRavine();
	private final IHeightmap terrain;

	public ChunkProviderHoth(World worldIn, long seed)
	{
		caveGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(caveGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE);
		ravineGenerator = net.minecraftforge.event.terraingen.TerrainGen.getModdedMapGen(ravineGenerator, net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE);

		this.worldObj = worldIn;

		waterLevel = 4;
		CompositeTerrain hothFlatland = new CompositeTerrain(new TerrainLayer(seed, TerrainLayer.Method.Add, 20, 0.4), new TerrainLayer(seed + 1, TerrainLayer.Method.Add, 200, 5), new TerrainLayer(seed + 2, TerrainLayer.Method.Multiply, 20, 3), new TerrainLayer(seed + 3, TerrainLayer.Method.Add, 10, 5), new TerrainLayer(seed + 4, TerrainLayer.Method.Multiply, 40, 2), new TerrainLayer(seed + 5, TerrainLayer.Method.Add, 20, 5), new TerrainLayer(seed + 6, TerrainLayer.Method.Multiply, 10, 0.1), new TerrainLayer(seed + 7, TerrainLayer.Method.Add, 200, 20));

		CompositeTerrain hothHills = new CompositeTerrain(new TerrainLayer(seed, TerrainLayer.Method.Add, 20, 0.4), new TerrainLayer(seed + 1, TerrainLayer.Method.Add, 200, 5), new TerrainLayer(seed + 2, TerrainLayer.Method.Multiply, 20, 3), new TerrainLayer(seed + 3, TerrainLayer.Method.Add, 10, 5), new TerrainLayer(seed + 4, TerrainLayer.Method.Multiply, 40, 2), new TerrainLayer(seed + 5, TerrainLayer.Method.Add, 20, 5), new TerrainLayer(seed + 6, TerrainLayer.Method.Multiply, 10, 0.1), new TerrainLayer(seed + 7, TerrainLayer.Method.Add, 100, 25));

		CompositeTerrain hothHugeHills = new CompositeTerrain(new TerrainLayer(seed, TerrainLayer.Method.Add, 20, 0.4), new TerrainLayer(seed + 1, TerrainLayer.Method.Add, 200, 5), new TerrainLayer(seed + 2, TerrainLayer.Method.Multiply, 20, 3), new TerrainLayer(seed + 3, TerrainLayer.Method.Add, 10, 5), new TerrainLayer(seed + 4, TerrainLayer.Method.Multiply, 40, 2), new TerrainLayer(seed + 5, TerrainLayer.Method.Add, 50, 5), new TerrainLayer(seed + 6, TerrainLayer.Method.Add, 10, 0.2), new TerrainLayer(seed + 7, TerrainLayer.Method.Add, 150, 40));

		terrain = new TripositeTerrain(hothFlatland, hothHills, hothHugeHills, new TerrainLayer(seed, TerrainLayer.Method.Add, 800, 1));
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
				int finalHeight = MathHelper.clamp(baseHeight + (int)height, 0, 255);
				for (int y = 1; y <= finalHeight; y++)
				{
					double snowThreshold = height * 0.8;

					if (y >= snowThreshold)
						primer.setBlockState(x, y, z, Blocks.SNOW.getDefaultState());
					else
						primer.setBlockState(x, y, z, Blocks.STONE.getDefaultState());
				}
				if (finalHeight + 1 <= 255)
					primer.setBlockState(x, finalHeight + 1, z, Blocks.SNOW_LAYER.getDefaultState());
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