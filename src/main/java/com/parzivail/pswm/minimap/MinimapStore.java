package com.parzivail.pswm.minimap;

import java.util.HashMap;

import net.minecraft.world.World;

public class MinimapStore
{
	private static HashMap<Integer, MinimapWorld> map;

	public static int getAt(World world, int x, int z)
	{
		if (map == null)
			map = new HashMap<Integer, MinimapWorld>();
		if (!map.containsKey(world.provider.dimensionId))
			map.put(world.provider.dimensionId, new MinimapWorld(world.provider.dimensionId));
		return map.get(world.provider.dimensionId).getAt(x, z);
	}
}
