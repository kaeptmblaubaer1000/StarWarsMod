package com.parzi.starwarsmod.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawTatooineSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderTatooine extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeTatooine, 0);
		this.dimensionId = StarWarsMod.dimTatooineId;
	}

	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer()
	{
		return new DrawTatooineSky();
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

    public ChunkCoordinates getSpawnPoint()
    {
        return new ChunkCoordinates(0, this.worldObj.getHeightValue(0, 0), 0);
    }
}
