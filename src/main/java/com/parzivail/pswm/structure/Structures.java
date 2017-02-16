package com.parzivail.pswm.structure;

import com.parzivail.pswm.dimension.DimensionInfo;
import com.parzivail.util.schematic.ChunkSchematic;
import net.minecraft.world.chunk.ChunkPrimer;

/**
 * Created by Colby on 2/9/2017.
 */
public class Structures
{
	public static ChunkSchematic test;
	public static ChunkSchematic moseisley;

	public static void init()
	{
		// X Y Z format: smallest chunk X and Z, bottom Y to generate
		test = new ChunkSchematic("test");
		moseisley = new ChunkSchematic("moseisley");
	}

	public static boolean tryGenForDimension(int dimension, ChunkPrimer primer, int cx, int cz, int x, int y, int z)
	{
		boolean didGenerate = false;
		if (dimension == DimensionInfo.tatooineId)
		{
			didGenerate = didGenerate || Structures.test.tryGen(primer, cx, cz, x, y, z);
			didGenerate = didGenerate || Structures.moseisley.tryGen(primer, cx, cz, x, y, z);
		}
		return didGenerate;
	}
}
