package com.parzi.starwarsmod.utils;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

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
		WorldServer s = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(dimId);
		Lumberjack.log("World registered: " + s.provider.getProviderForDimension(dimId).getDimensionName());
	}
	
	public static void unregisterDimension(int dimId)
	{
		DimensionManager.unregisterDimension(dimId);
	}
}