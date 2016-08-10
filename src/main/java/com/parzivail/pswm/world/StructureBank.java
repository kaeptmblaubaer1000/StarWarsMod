package com.parzivail.pswm.world;

import com.parzivail.util.schematic.Schematic;
import com.parzivail.util.ui.Lumberjack;

/**
 * @author Colby
 */
public class StructureBank
{
	private static Schematic baSingStation;
	private static Schematic endorBase;
	private static Schematic endorShield;
	private static Schematic escapePod;
	private static Schematic greatTemple;
	private static Schematic homesteadBig;
	private static Schematic homestead;
	private static Schematic hothEcho;
	private static Schematic hothGenerator;
	private static Schematic ilumTemple;
	private static Schematic imperialHoth;
	private static Schematic imperialTatooine;
	private static Schematic mosEisley;
	private static Schematic obiWanHut;
	private static Schematic rebelEndor;
	private static Schematic tuskenVillage;
	private static Schematic wookieeVillage;
	private static Schematic yavinTempleRuin;
	private static Schematic yodaHut;

	private static NbtBlockMap mobsFinal;

	public static void loadBlockMaps()
	{
		mobsFinal = new NbtBlockMap("mobs-final-map");

		Lumberjack.info("Block Maps, reporting for duty!");
	}

	public static Schematic getGreatTemple()
	{
		if (greatTemple == null)
			greatTemple = new Schematic("final/greattemplefinal", mobsFinal);
		return greatTemple;
	}

	public static Schematic getBaSingStation()
	{
		if (baSingStation == null)
			baSingStation = new Schematic("final/basingstation", mobsFinal);
		return baSingStation;
	}

	public static Schematic getEndorBase()
	{
		if (endorBase == null)
			endorBase = new Schematic("final/endorbasefinal", mobsFinal);
		return endorBase;
	}

	public static Schematic getEndorShield()
	{
		if (endorShield == null)
			endorShield = new Schematic("final/endorshield", mobsFinal);
		return endorShield;
	}

	public static Schematic getEscapePod()
	{
		if (escapePod == null)
			escapePod = new Schematic("final/escapepodfinal", mobsFinal);
		return escapePod;
	}

	public static Schematic getHomesteadBig()
	{
		if (homesteadBig == null)
			homesteadBig = new Schematic("final/homesteadbigfinal", mobsFinal);
		return homesteadBig;
	}

	public static Schematic getHomestead()
	{
		if (homestead == null)
			homestead = new Schematic("final/homesteadfinal", mobsFinal);
		return homestead;
	}

	public static Schematic getHothEcho()
	{
		if (hothEcho == null)
			hothEcho = new Schematic("final/hothecho", mobsFinal);
		return hothEcho;
	}

	public static Schematic getHothGenerator()
	{
		if (hothGenerator == null)
			hothGenerator = new Schematic("final/hothgenerator", mobsFinal);
		return hothGenerator;
	}

	public static Schematic getIlumTemple()
	{
		if (ilumTemple == null)
			ilumTemple = new Schematic("final/ilumtemplesmooth", mobsFinal);
		return ilumTemple;
	}

	public static Schematic getImperialHoth()
	{
		if (imperialHoth == null)
			imperialHoth = new Schematic("final/imperialhoth", mobsFinal);
		return imperialHoth;
	}

	public static Schematic getImperialTatooine()
	{
		if (imperialTatooine == null)
			imperialTatooine = new Schematic("final/imperialtatooine", mobsFinal);
		return imperialTatooine;
	}

	public static Schematic getMosEisley()
	{
		if (mosEisley == null)
			mosEisley = new Schematic("final/moseisleyfinal", mobsFinal);
		return mosEisley;
	}

	public static Schematic getObiWanHut()
	{
		if (obiWanHut == null)
			obiWanHut = new Schematic("final/obiwanhut", mobsFinal);
		return obiWanHut;
	}

	public static Schematic getRebelEndor()
	{
		if (rebelEndor == null)
			rebelEndor = new Schematic("final/rebelendor", mobsFinal);
		return rebelEndor;
	}

	public static Schematic getTuskenVillage()
	{
		if (tuskenVillage == null)
			tuskenVillage = new Schematic("final/tuskenvillage", mobsFinal);
		return tuskenVillage;
	}

	public static Schematic getWookieeVillage()
	{
		if (wookieeVillage == null)
			wookieeVillage = new Schematic("final/wookieevillage", mobsFinal);
		return wookieeVillage;
	}

	public static Schematic getYavinTempleRuin()
	{
		if (yavinTempleRuin == null)
			yavinTempleRuin = new Schematic("final/yavintempleruinfinal", mobsFinal);
		return yavinTempleRuin;
	}

	public static Schematic getYodaHut()
	{
		if (yodaHut == null)
			yodaHut = new Schematic("final/yodahutfinal", mobsFinal);
		return yodaHut;
	}
}
