package com.parzi.starwarsmod.world;

import java.util.Random;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderTatooine extends WorldProvider {

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(StarWarsMod.biomeTatooine, 0);
		this.dimensionId = StarWarsMod.biomeTatooineId;
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderGenerate(this.worldObj,
				this.worldObj.getSeed(), false);
	}

	public int getAverageGroundLevel() {
		return 30;
	}

	public String getDimensionName() {
		return "Tatooine";
	}

	public boolean canRespawnHere() {
		return false;
	}

	public boolean isSurfaceWorld() {
		return true;
	}

	public boolean canCoordinateBeSpawn(int par1, int par2) {
		return false;
	}

	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(50, 5, 0);
	}

}
