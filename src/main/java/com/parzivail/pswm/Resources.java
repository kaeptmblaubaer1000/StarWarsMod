package com.parzivail.pswm;

import com.parzivail.pswm.dimension.PlanetInformation;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;

public class Resources
{
	public static HashMap<Integer, ResourceLocation> planetTextures = new HashMap<>();
	public static ArrayList<PlanetInformation> planetInformation = new ArrayList<>();

	public static final int[] allowedStarColors = { 0xE7FD3700, 0xFFFE3C00, 0xFFFE4200, 0xFFFE4600, 0xFFFE4C00, 0xFFFE5000, 0xFFFE5300, 0xFFFE5600, 0xFFFE5A00, 0xFFFE5D00, 0xFFFE6000, 0xFFFE6200, 0xFFFE6600, 0xFFFE6900, 0xFFFE6C00, 0xFFFE6E00, 0xFFFE7000, 0xFFFE7300, 0xFFFE7500, 0xFFFE7700, 0xFFFE7900, 0xFFFE7B00, 0xFFFE7D00, 0xFFFE7E00, 0xFFFE8000, 0xFFFE820F, 0xFFFE8415, 0xFFFE861C, 0xFFFE8922, 0xFFFE8B28, 0xFFFE8D2C, 0xFFFE8F2E, 0xFFFE9132, 0xFFFE9336, 0xFFFE9538, 0xFFFE973C, 0xFFFE993F, 0xFFFE9A42, 0xFFFE9C44, 0xFFFE9E48, 0xFFFEA04A, 0xFFFEA14D, 0xFFFEA350, 0xFFFEA552, 0xFFFEA655, 0xFFFEA858, 0xFFFEA95B, 0xFFFEAB5E, 0xFFFEAC60, 0xFFFEAD62, 0xFFFEAF65, 0xFFFEB067, 0xFFFEB26A, 0xFFFEB36D, 0xFFFEB56F, 0xFFFEB672, 0xFFFEB774, 0xFFFEB977, 0xFFFEBA79, 0xFFFEBC7C, 0xFFFEBD7E, 0xFFFEBE80, 0xFFFEBF82, 0xFFFEC084, 0xFFFEC287, 0xFFFEC389, 0xFFFEC48B, 0xFFFEC58D, 0xFFFEC790, 0xFFFEC892, 0xFFFEC994, 0xFFFECA96, 0xFFFECB99, 0xFFFECC9B, 0xFFFECD9D, 0xFFFECE9F, 0xFFFECFA1, 0xFFFED0A3, 0xFFFED1A5, 0xFFFED2A7, 0xFFFED3A9, 0xFFFED4AB, 0xFFFED5AD, 0xFFFED6AF, 0xFFFED7B2, 0xFFFED8B4, 0xFFFED8B6, 0xFFFED9B8, 0xFFFEDBBA, 0xFFFEDCBB, 0xFFFEDDBD, 0xFFFEDEBF, 0xFFFEDFC1, 0xFFFEE0C3, 0xFFFEE1C5, 0xFFFEE2C6, 0xFFFEE3C8, 0xFFFEE3CA, 0xFFFEE4CC, 0xFFFEE5CE, 0xFFFEE6D0, 0xFFFEE7D2, 0xFFFEE7D3, 0xFFFEE8D5, 0xFFFEE9D7, 0xFFFEEAD9, 0xFFFEEBDC, 0xFFFDECDE, 0xFFFDECDF, 0xFFFCECE0, 0xFFFCECE1, 0xFFFBECE2, 0xFFFAECE3, 0xFFFAECE4, 0xFFF9ECE5, 0xFFF9ECE6, 0xFFF8ECE7, 0xFFF7EDE8, 0xFFF7EDE9, 0xFFF6EDEA, 0xFFF5EDEB, 0xFFF5EDEC, 0xFFF4EDED, 0xFFF4EDEE, 0xFFF4EDEF, 0xFFF3EDEF, 0xFFF3EDF0, 0xFFF2EEF1, 0xFFF2EEF2, 0xFFF1EEF3, 0xFFF1EEF4, 0xFFF0EEF5, 0xFFEFEEF6, 0xFFEFEEF7, 0xFFEEEEF8, 0xFFEDEFF9, 0xFFEDEFFA, 0xFFECEFFB, 0xFFECEFFC, 0xFFEBEEFD, 0xFFEAEDFD, 0xFFE8EDFD, 0xFFE7ECFD, 0xFFE6EBFF, 0xFFE5EBFF, 0xFFE4EAFF, 0xFFE3EAFF, 0xFFE2E9FF, 0xFFE1E8FF, 0xFFE0E8FF, 0xFFDFE7FF, 0xFFDEE7FF, 0xFFDDE6FF, 0xFFDCE6FF, 0xFFDBE5FF, 0xFFD9E4FF, 0xFFD8E4FF, 0xFFD7E3FF, 0xFFD6E3FF, 0xFFD5E2FF, 0xFFD4E2FF, 0xFFD3E1FF, 0xFFD2E1FF, 0xFFD1E0FF, 0xFFD0E0FF, 0xFFCFDFFF, 0xFFCEDEFF, 0xFFCDDDFF, 0xFFCCDCFF, 0xFFCBDCFF, 0xFFCADBFF, 0xFFC9DBFF, 0xFFC8D9FF, 0xFFC7D9FF, 0xFFC7D8FF, 0xFFC6D8FF, 0xFFC5D7FF, 0xFFC4D7FF, 0xFFC3D7FF, 0xFFC2D6FF, 0xFFC1D5FF, 0xFFC0D4FF, 0xFFBFD4FF, 0xFFBED3FF, 0xFFBDD2FF, 0xFFBCD2FF, 0xFFBBD2FF, 0xFFBAD1FF, 0xFFB9D0FF, 0xFFB8CFFF, 0xFFB7CFFF, 0xFFB6CEFF, 0xFFB5CDFF, 0xFFB4CCFF, 0xFFB3CCFF, 0xFFB2CBFF, 0xFFB1CBFF, 0xFFB0CAFF, 0xFFAFCAFF, 0xFFAECAFF, 0xFFADC9FF, 0xFFACC8FF, 0xFFABC7FF, 0xFFAAC7FF, 0xFFA9C7FF, 0xFFA8C6FF, 0xFFA8C5FF, 0xFFA7C5FF, 0xFFA6C4FF, 0xFFA5C3FF, 0xFFA4C3FF, 0xFFA3C2FF, 0xFFA2C1FF, 0xFFA1C1FF, 0xFFA0C1FF, 0xFF9FC0FF, 0xFF9FBFFF, 0xFF9EBFFF, 0xFF9DBFFF, 0xFF9CBEFF, 0xFF9BBDFF, 0xFF9ABCFE, 0xFF99BBFE, 0xFF98BBFE, 0xFF97BAFE, 0xFF96B9FE, 0xFF95B9FE, 0xFF94B8FE, 0xFF93B7FE, 0xFF92B7FE, 0xFF91B7FE, 0xFF91B6FE, 0xFF90B5FE, 0xFF8FB5FE, 0xFF8EB5FE, 0xFF8EB4FE, 0xFF8DB4FE, 0xFF8DB3FE, 0xFF8CB3FE, 0xFF8BB3FE, 0xFF8BB2FE, 0xFF8AB1FE, 0xFF89B1FE, 0xFF88B0FE, 0xFF87AFFE, 0xE786AFFD };

	public static class ConfigOptions
	{
		public static int biomeTatooineId;
		public static int biomeHothId;
		public static int biomeKashyyykId;
		public static int biomeYavin4Id;
		public static int biomeEndorId;
		public static int biomeDagobahId;
		public static int biomeIlumId;
		public static int biomeMustafarId;
		public static int dimTatooineId;
		public static int dimHothId;
		public static int dimKashyyykId;
		public static int dimYavin4Id;
		public static int dimDagobahId;
		public static int dimMustafarId;
		public static int dimEndorId;
		public static int dimIlumId;
		public static int dimAlderaanId = 100;
		public static int dimBespinId = 101;
		public static int dimCoruscantId = 102;
		public static int dimDathomirId = 103;
		public static int dimGeonosisId = 104;
		public static int dimRylothId = 105;
		public static int dimKaminoId = 106;
		public static int dimKesselId = 107;
		public static int dimMandaloreId = 108;
		public static int dimMonCalamariId = 109;
		public static int dimNabooId = 110;
		public static int dimSullustId = 111;
		public static int dimUtapauId = 112;
		public static int dimJakkuId = 113;
		public static int dimTakodanaId = 114;
		public static int dimDQarId = 115;
		public static int dimAhchToId = 116;
		public static int dimDeathStarId = 117;
		public static boolean enableCreditsOverlay;
		public static boolean enableLightsaberStrobe;
		public static boolean enableBlasterFire;
		public static boolean enableBuckets;
		public static boolean enableLightsaber;
		public static boolean enableGlobalLeaderboard;
		public static boolean enableLightsaberHum;
		public static boolean beshOverride;
		public static boolean enableTabOriginal = true;
		public static boolean enableTabSequel = true;
		public static int lightsaberDamage;
		public static boolean enableFlyCommand;
		public static boolean enableDimCommand;
		public static boolean enableBetaFeatures;
	}

	// Core
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "1.3.0";
	public static String ONLINE_VERSION = "";

	public static boolean IS_DEV_ENVIRONVENT = false;

	public static boolean IS_SEQUEL_RELEASE = true;

	public static final String[] checkCompatList = {}; // mod IDs
	public static final String remoteVersionLink = "https://raw.githubusercontent.com/Parzivail-Modding-Team/ParziStarWarsMod/master/VERSION.md";
	public static final String robesLeaderboardAddLink = "http://parzivail.com/mods/tswm/addLeaderboard.php";

	private static int guiCounter = 0;
	public static final int GUI_MV = guiCounter++;
	public static final int GUI_ROBES = guiCounter++;
	public static final int GUI_JEDI_SITH = guiCounter++;
	public static final int GUI_HOLOTABLE = guiCounter++;
	public static final int GUI_QUESTNPC = guiCounter++;
	public static final int GUI_QUEST = guiCounter++;
	public static final int GUI_LSFORGE = guiCounter++;
	public static final int GUI_SCANNER = guiCounter++;
	public static final int GUI_HYPERDRIVE = guiCounter++;

	// TIE Overlays
	public static final ResourceLocation tieOverlay = new ResourceLocation(Resources.MODID, "textures/gui/tie/tie.png");
	public static final ResourceLocation tieBackOverlay = new ResourceLocation(Resources.MODID, "textures/gui/tie/tieBack.png");
	public static final ResourceLocation tiePitch = new ResourceLocation(Resources.MODID, "textures/gui/tie/tiePitch.png");

	// X-Wing Overlays
	public static final ResourceLocation xwingOverlay = new ResourceLocation(Resources.MODID, "textures/gui/xwing/xwing.png");
	public static final ResourceLocation xwingOverlayBack1 = new ResourceLocation(Resources.MODID, "textures/gui/xwing/xwingBack1.png");
	public static final ResourceLocation xwingOverlayBack2 = new ResourceLocation(Resources.MODID, "textures/gui/xwing/xwingBack2.png");

	// A-Wing Overlays
	public static final ResourceLocation awingOverlay = new ResourceLocation(Resources.MODID, "textures/gui/awing/awing.png");
	public static final ResourceLocation awingBack = new ResourceLocation(Resources.MODID, "textures/gui/awing/awingBack.png");
	public static final ResourceLocation awingBack2 = new ResourceLocation(Resources.MODID, "textures/gui/awing/awingBack2.png");
	public static final ResourceLocation awingPitch1 = new ResourceLocation(Resources.MODID, "textures/gui/awing/pitch1.png");
	public static final ResourceLocation awingPitch2 = new ResourceLocation(Resources.MODID, "textures/gui/awing/pitch2.png");

	public static final ResourceLocation snowspeederOverlay = new ResourceLocation(Resources.MODID, "textures/gui/snowspeeder/snowspeeder.png");

	public static final ResourceLocation skyhopperOverlay = new ResourceLocation(Resources.MODID, "textures/gui/skyhopper/skyhopper.png");

	public static final ResourceLocation atstOverlay = new ResourceLocation(Resources.MODID, "textures/gui/atst/atst.png");

	public static final ResourceLocation ywingOverlay = new ResourceLocation(Resources.MODID, "textures/gui/ywing/ywing.png");

	// Planet Textures
	public static final ResourceLocation earthTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/earth.png");
	public static final ResourceLocation endorTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/endor.png");
	public static final ResourceLocation hothTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/hoth.png");
	public static final ResourceLocation kashyyykTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/kashyyyk.png");
	public static final ResourceLocation yavinTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/yavin.png");
	public static final ResourceLocation tatooineTexture = new ResourceLocation(Resources.MODID, "textures/gui/planets/tatooine.png");

	// Force Textures
	public static final ResourceLocation capeTexture = new ResourceLocation(Resources.MODID, "textures/force/cloak.png");

	// Misc
	public static final char[] randomCharArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!?$".toCharArray();

	// NBT Keys
	public static final String nbtLevel = "level";
	public static final String nbtActive = "active";
	public static final String nbtIsRunning = "isRunning";
	public static final String nbtActiveHealth = "activeHealth";
	public static final String nbtActiveLevel = "activeLevel";
	public static final String nbtIsUsingDuration = "isDuration";

	public static final String nbtMaster = "master";
	public static final String nbtEntityTarget = "target";
	public static final String nbtXp = "xp";
	public static final String nbtMaxXp = "maxxp";
	public static final String nbtSide = "side";
	public static final String nbtPowers = "powers";
	public static final String nbtRemainingPts = "points";

	public static final String nbtQuests = "quests";
	public static final String nbtOwner = "owner";

	public static final String nbtShotsLeft = "shotsLeft";
	public static final String nbtCooldown = "cooldown";
	public static final String nbtTicksSince = "ticksSince";

	public static final String speciesHuman = "Human";
	public static final String speciesBith = "Bith";

	public static final String allegianceNone = "None";
	public static final String allegianceJedi = "Jedi";
	public static final String allegianceSith = "Sith";
	public static final String allegianceNewRepublic = "New Republic";
	public static final String allegianceRebel = "Rebel Alliance";
	public static final String allegianceImperial = "Galactic Empire";

	public static final String skinDefault = "default";
}
