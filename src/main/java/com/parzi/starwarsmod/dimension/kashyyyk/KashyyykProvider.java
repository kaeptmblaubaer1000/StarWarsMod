package com.parzi.starwarsmod.dimension.kashyyyk;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawHothSky;
import com.parzi.starwarsmod.rendering.DrawKashyyykSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class KashyyykProvider extends WorldProvider
{
	public static String dimName = "Kashyyyk";

	@SideOnly(Side.CLIENT)
	private IRenderHandler skyRenderer;

	/**
	 * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
	 */
	@Override
	public String getDimensionName()
	{
		return dimName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer()
	{
		if (this.skyRenderer == null) this.skyRenderer = new DrawKashyyykSky();
		return this.skyRenderer;
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
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeKashyyyk, 0.2F);
		//this.worldChunkMgr = new ChunkManagerTatooine(this.worldObj);
		this.dimensionId = StarWarsMod.dimKashyyykId;
	}

	/**
	 * Returns a new chunk provider which generates chunks for this world
	 */
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new BiomeChunkProviderKashyyyk(this.worldObj, this.getSeed(), false);
	}

	@Override
	public ChunkCoordinates getEntrancePortalLocation()
	{
		return null;
	}

	@Override
	public ChunkCoordinates getSpawnPoint()
	{
		return new ChunkCoordinates(0, this.worldObj.getHeightValue(0, 0), 0);
	}

	@Override
	public boolean shouldMapSpin(String entity, double x, double y, double z)
	{
		return false;
	}
}
