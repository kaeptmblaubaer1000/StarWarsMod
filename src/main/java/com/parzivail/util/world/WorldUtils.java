package com.parzivail.util.world;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.common.DimensionManager;

import com.parzivail.util.ui.Lumberjack;

import cpw.mods.fml.common.FMLCommonHandler;

public class WorldUtils
{
	public static String getBiomeName(int x, int z)
	{
		return Minecraft.getMinecraft().theWorld.getBiomeGenForCoords(x, z).biomeName;
	}

	public static Block getBlockAt(int x, int y, int z)
	{
		return Minecraft.getMinecraft().theWorld.getBlock(x, y, z);
	}

	public static void registerDimension(int dimId)
	{
		DimensionManager.registerDimension(dimId, dimId);
		FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("World registered for " + WorldProvider.getProviderForDimension(dimId).getDimensionName());
	}

	public static void registerDimension(int dimId, Class<? extends WorldProvider> class1)
	{
		DimensionManager.registerProviderType(dimId, class1, true);
		DimensionManager.registerDimension(dimId, dimId);
		// WorldServer s =
		// FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("Provider and World registered for " + dimId);
	}

	public static void removeSpawnBiome(BiomeGenBase biome)
	{
		if (WorldChunkManager.allowedBiomes.contains(biome))
			WorldChunkManager.allowedBiomes.remove(biome);
		if (WorldChunkManager.allowedBiomes.contains(biome))
			WorldChunkManager.allowedBiomes.remove(biome);
	}

	public static void unregisterDimension(int dimId)
	{
		DimensionManager.unregisterDimension(dimId);
		Lumberjack.log("Provider and World unregistered for " + dimId);
	}
}