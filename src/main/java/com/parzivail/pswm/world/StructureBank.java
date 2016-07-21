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
	public static Schematic ilumTemple;

	public static NbtBlockMap mobsClientPack;
	public static NbtBlockMap mobsBuildserverMap;
	public static NbtBlockMap mobsBuildserver2Map;

	public static void loadAll()
	{
		mobsClientPack = new NbtBlockMap("mobs-client-map");
		mobsBuildserverMap = new NbtBlockMap("buildserver-map");
		mobsBuildserver2Map = new NbtBlockMap("buildserver3-map");

		yavinTemple = new Schematic("yavintemple", mobsClientPack);
		yodaTree = new Schematic("mobs-yodatree", mobsClientPack);
		falcon = new Schematic("falcon", mobsBuildserverMap);
		ilumTemple = new Schematic("ilumtemplenew", mobsBuildserver2Map);

		Lumberjack.info("Structures, reporting for duty!");
	}
}
