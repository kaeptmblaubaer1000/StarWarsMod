package com.parzivail.pswm.structure;

import com.parzivail.util.schematic.ChunkSchematic;

/**
 * Created by Colby on 2/9/2017.
 */
public class Structures
{
	public static ChunkSchematic test;

	public static void init()
	{
		// X Y Z format: smallest chunk X and Z, bottom Y to generate
		test = new ChunkSchematic("test", -4, 66, 2);
	}
}
