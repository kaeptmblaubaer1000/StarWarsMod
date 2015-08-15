package com.parzi.starwarsmod.world.provider;

import java.util.Random;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawEndorSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderEndor extends WorldProvider
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
		IChunkProvider generator = new ChunkProviderGenerate(worldObj, worldObj.getSeed(), false);
		return generator;
	}

	@Override
	public int getAverageGroundLevel()
	{
		return 40;
	}

	@Override
	public BiomeGenBase getBiomeGenForCoords(int x, int z)
	{
		if (new Random().nextGaussian() > 0.3) { return StarWarsMod.biomeEndorPlains; }
		return StarWarsMod.biomeEndor;
	}

	@Override
	public String getDimensionName()
	{
		return "Endor";
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
		return new DrawEndorSky();
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}

	@Override
	public void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeEndor, 0);
		dimensionId = StarWarsMod.dimEndorId;
	}

}
