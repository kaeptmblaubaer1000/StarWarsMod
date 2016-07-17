package com.parzivail.pswm.world;

import com.parzivail.util.schematic.Schematic;
import com.parzivail.util.ui.Lumberjack;

/**
 * @author Colby
 */
public class StructureBank
{
	public static Schematic yavinTemple;
	public static Schematic yodaTree;
	public static Schematic falcon;

	public static NbtPack mobsClientPack;
	public static NbtPack mobsBuildserverMap;

	public static void loadAll()
	{
		mobsClientPack = new NbtPack("mobs-map");
		mobsBuildserverMap = new NbtPack("buildserver-map");

		yavinTemple = new Schematic("yavintemple", mobsClientPack);
		yodaTree = new Schematic("mobs-yodatree", mobsClientPack);
		falcon = new Schematic("falcon", mobsBuildserverMap);

		Lumberjack.info("Structures, reporting for duty!");
	}
}
