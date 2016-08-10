package com.parzivail.pswm.world;

import com.parzivail.util.schematic.Schematic;
import com.parzivail.util.ui.Lumberjack;

/**
 * @author Colby
 */
public class StructureBank
{
	public static Schematic yavinTemple;

	public static NbtBlockMap mobsFinal;

	public static void loadAll()
	{
		mobsFinal = new NbtBlockMap("mobs-final-map");

		yavinTemple = new Schematic("final/greattemplefinal", mobsFinal); // make lazy-load

		Lumberjack.info("Structures, reporting for duty!");
	}
}
