package com.parzi.starwarsmod.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawHothSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderHoth extends WorldProvider
{
	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}

	@Override
	public boolean canRespawnHere()
	{
		return true;
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderGenerateHothFixed(this.worldObj, this.worldObj.getSeed(), false);
	}

	@Override
	public int getAverageGroundLevel()
	{
		return 40;
	}

	@Override
	public String getDimensionName()
	{
		return "Hoth";
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
		return new DrawHothSky();
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeHoth, 0.0F);
		this.dimensionId = StarWarsMod.dimHothId;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\world\provider\WorldProviderHoth.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */