package com.parzi.starwarsmod.world.provider;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawDagobahSky;
import com.parzi.starwarsmod.rendering.DrawTatooineSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderDagobah extends WorldProvider
{
	/**
	 * Creates the light to brightness table
	 */
	@Override
	protected void generateLightBrightnessTable()
	{
		float f = 0.0F;

		for (int i = 0; i <= 15; ++i)
		{
			float f1 = 1.0F - (float)i / 15.0F;
			this.lightBrightnessTable[i] = ((1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f) / 2;
		}
	}

	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}

	public boolean canRainSnowIce(Chunk chunk)
	{
		return true;
	}

	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderGenerateDagobah(this.worldObj, this.worldObj.getSeed(), false);
	}

	@Override
	public int getAverageGroundLevel()
	{
		return 40;
	}

	@Override
	public String getDimensionName()
	{
		return "Dagobah";
	}

	@Override
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer()
	{
		return new DrawDagobahSky();
	}

	/**
	 * Returns true if the given X,Z coordinate should show environmental fog.
	 */
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int p_76568_1_, int p_76568_2_)
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return Vec3.createVectorHelper(0, 0.39, 0.29);
	}

	@Override
	public ChunkCoordinates getSpawnPoint()
	{
		return new ChunkCoordinates(0, this.worldObj.getHeightValue(0, 0), 0);
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeDagobah, 0.0F);
		this.dimensionId = StarWarsMod.dimDagobahId;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\
 * parzi\starwarsmod\world\provider\WorldProviderTatooine.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */