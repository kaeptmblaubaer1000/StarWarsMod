package com.parzi.starwarsmod.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.client.IRenderHandler;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.rendering.DrawYavinFourSky;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderYavinFour extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeYavin4, 0);
		this.dimensionId = StarWarsMod.dimYavin4Id;
	}

	@SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
	    return new DrawYavinFourSky();
    }

	public IChunkProvider createChunkGenerator()
	{
		IChunkProvider generator = new ChunkProviderGenerate(this.worldObj, this.worldObj.getSeed(), false);
		return generator;
	}

	public int getAverageGroundLevel()
	{
		return 40;
	}

	public String getDimensionName()
	{
		return "Yavin 4";
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
