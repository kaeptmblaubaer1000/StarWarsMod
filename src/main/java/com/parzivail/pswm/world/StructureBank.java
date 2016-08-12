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
	private static Schematic ewokVillage;
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
	private static Schematic sandCrawler;
	private static Schematic tuskenVillage;
	private static Schematic wookieeVillage;
	private static Schematic yavinTempleRuin;
	private static Schematic yodaHut;

	private static NbtBlockMap mobsFinal;

	public static void loadBlockMaps()
	{
		mobsFinal = new NbtBlockMap("mobs-final-map");

		greatTemple = new Schematic("final/greattemplefinal", mobsFinal);
		hothEcho = new Schematic("final/hothecho", mobsFinal);
		ilumTemple = new Schematic("final/ilumtemplesmoothfinal", mobsFinal);
		wookieeVillage = new Schematic("final/wookieevillagefinal", mobsFinal);
		mosEisley = new Schematic("final/moseisleyfinal", mobsFinal);

		Lumberjack.info("Block Maps, reporting for duty!");
	}

	public static Schematic getGreatTemple()
	{
		return greatTemple;
	}

	public static Schematic getBaSingStation()
	{
		if (baSingStation == null)
			baSingStation = new Schematic("final/basingstationfinal", mobsFinal);
		return baSingStation;
	}

	public static Schematic getEndorBase()
	{
		if (endorBase == null)
			endorBase = new Schematic("final/endorimperialfinal", mobsFinal);
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

	public static Schematic getEwokVillage()
	{
		if (ewokVillage == null)
			ewokVillage = new Schematic("final/ewokvillagefinal", mobsFinal);
		return ewokVillage;
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
		return mosEisley;
	}

	public static Schematic getObiWanHut()
	{
		if (obiWanHut == null)
			obiWanHut = new Schematic("final/obiwanhutfinal", mobsFinal);
		return obiWanHut;
	}

	public static Schematic getRebelEndor()
	{
		if (rebelEndor == null)
			rebelEndor = new Schematic("final/rebelendor", mobsFinal);
		return rebelEndor;
	}

	public static Schematic getSandCrawler()
	{
		if (sandCrawler == null)
			sandCrawler = new Schematic("final/sandcrawlerfinal", mobsFinal);
		return sandCrawler;
	}

	public static Schematic getTuskenVillage()
	{
		if (tuskenVillage == null)
			tuskenVillage = new Schematic("final/tuskenvillage", mobsFinal);
		return tuskenVillage;
	}

	public static Schematic getWookieeVillage()
	{
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
			yodaHut = new Schematic("final/yodatreefinal", mobsFinal);
		return yodaHut;
	}
}
