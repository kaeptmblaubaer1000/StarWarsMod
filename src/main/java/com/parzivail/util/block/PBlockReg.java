package com.parzivail.util.block;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Colby on 6/22/2016.
 */
public class PBlockReg
{
	public static PBlock registerBlock(Class<? extends PBlock> blockClass)
	{
		try
		{
			PBlock b = blockClass.newInstance();
			GameRegistry.registerBlock(b, b.name);
			return b;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static PBlockContainer registerBlockContainer(Class<? extends PBlockContainer> blockClass)
	{
		try
		{
			PBlockContainer b = blockClass.newInstance();
			GameRegistry.registerBlock(b, b.name);
			return b;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static PBlockStairs registerBlockStairs(Class<? extends PBlockStairs> blockClass)
	{
		try
		{
			PBlockStairs b = blockClass.newInstance();
			GameRegistry.registerBlock(b, b.name);
			return b;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static PBlockSlab registerBlockSlab(Class<? extends PBlockSlab> blockClass)
	{
		try
		{
			PBlockSlab b = blockClass.newInstance();
			GameRegistry.registerBlock(b, b.name);
			return b;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static PBlockFence registerBlockFence(Class<? extends PBlockFence> blockClass)
	{
		try
		{
			PBlockFence b = blockClass.newInstance();
			GameRegistry.registerBlock(b, b.name);
			return b;
		}
		catch (InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
