package com.parzi.starwarsmod.utils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;

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
}
