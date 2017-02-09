package com.parzivail.pswm.structure;

import com.parzivail.util.schematic.NbtBlockMap;

/**
 * Created by Colby on 2/9/2017.
 */
public class Structures
{
	public static NbtBlockMap mobsFinal;

	public static void init()
	{
		mobsFinal = new NbtBlockMap("mobs-final-map-1.11");
	}
}
