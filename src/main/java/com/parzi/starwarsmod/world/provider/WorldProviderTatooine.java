package com.parzi.starwarsmod.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;

public class WorldProviderTatooine extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeTatooine, 0);
		this.dimensionId = StarWarsMod.dimTatooineId;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderGenerateTatooine(this.worldObj, this.worldObj.getSeed(), false);
	}

	public int getAverageGroundLevel()
	{
		return 40;
	}

	public boolean canRainSnowIce(Chunk chunk)
	{
		return false;
	}

	public String getDimensionName()
	{
		return "Tatooine";
	}

	public boolean canRespawnHere()
	{
		return false;
	}

	public boolean isSurfaceWorld()
	{
		return true;
	}

	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}

	public ChunkCoordinates getEntrancePortalLocation()
	{
		return null;
	}

}
