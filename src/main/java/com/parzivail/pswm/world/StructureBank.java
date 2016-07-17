package com.parzivail.pswm.world;

import com.parzivail.util.schematic.Schematic;

/**
 * @author Colby
 */
public class StructureBank
{
	public static Schematic yavinTemple;
	public static Schematic yodaTree;
	public static Schematic falcon;

	public static void loadAll()
	{
		yavinTemple = new Schematic("yavintemple", "mobs-map");
		yodaTree = new Schematic("mobs-yodatree", "mobs-map");
		falcon = new Schematic("falcon", "buildserver-map");
	}
}
