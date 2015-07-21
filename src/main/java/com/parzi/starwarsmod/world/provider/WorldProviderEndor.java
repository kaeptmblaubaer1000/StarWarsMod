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

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeEndor, 0);
		this.dimensionId = StarWarsMod.dimEndorId;
	}

	@SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
	    return new DrawEndorSky();
    }

	public IChunkProvider createChunkGenerator()
	{
		IChunkProvider generator = new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), false);
		return generator;
	}

	public BiomeGenBase getBiomeGenForCoords(int x, int z) {
		if (new Random().nextGaussian() > 0.3) return StarWarsMod.biomeEndorPlains;
		return StarWarsMod.biomeEndor;
	}

	public int getAverageGroundLevel()
	{
		return 40;
	}

	public String getDimensionName()
	{
		return "Endor";
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
