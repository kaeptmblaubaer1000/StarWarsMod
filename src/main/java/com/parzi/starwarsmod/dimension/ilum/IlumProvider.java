package com.parzi.starwarsmod.dimension.ilum;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawHothSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IlumProvider extends WorldProvider
{
	public static String dimName = "Ilum";

	@SideOnly(Side.CLIENT)
	private IRenderHandler skyRenderer;

	/**
	 * Returns a new chunk provider which generates chunks for this world
	 */
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new BiomeChunkProviderIlum(this.worldObj, this.getSeed(), false);
	}

	/**
	 * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
	 */
	@Override
	public String getDimensionName()
	{
		return dimName;
	}

	@Override
	public boolean canDoRainSnowIce(Chunk chunk)
	{
		return true;
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
		if (this.skyRenderer == null)
			this.skyRenderer = new DrawHothSky();
		return this.skyRenderer;
	}

	@Override
	public ChunkCoordinates getSpawnPoint()
	{
		return new ChunkCoordinates(0, this.worldObj.getHeightValue(0, 0), 0);
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	/**
	 * creates a new world chunk manager for WorldProvider
	 */
	@Override
	protected void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeIlum, 1F);
		// this.worldChunkMgr = new ChunkManagerTatooine(this.worldObj);
		this.dimensionId = StarWarsMod.dimIlumId;
	}

	@Override
	public boolean shouldMapSpin(String entity, double x, double y, double z)
	{
		return false;
	}
}
