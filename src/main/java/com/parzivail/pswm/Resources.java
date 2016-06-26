package com.parzivail.pswm;

import com.parzivail.pswm.dimension.PlanetInformation;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;

public class Resources
{
	public static HashMap<Integer, ResourceLocation> planetTextures = new HashMap<>();
	public static ArrayList<PlanetInformation> planetInformation = new ArrayList<>();

	public static final int[] PANEL_LIGHT_COLORS = { 0xF8E443, 0x0050A1, 0x4ACBFF, 0xD1A250, 0x42A904, 0xFB4B33 };

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
		public static int biomeSpaceId;
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
		public static int dimSpaceId = 118;
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
		public static boolean enableLightsaberLight;
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
	public static final int GUI_ANTENNA = guiCounter++;
	public static final int GUI_CRYSTALCOMPRESSOR = guiCounter++;

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

	public static final String nbtWield = "wield";

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

	public static final String allegianceNoneFmt = "none";
	public static final String allegianceJediFmt = "jedi";
	public static final String allegianceSithFmt = "sith";
	public static final String allegianceNewRepublicFmt = "newrepublic";
	public static final String allegianceRebelFmt = "rebelalliance";
	public static final String allegianceImperialFmt = "galacticempire";

	public static final String skinDefault = "default";

	public static final String[] armors = { "rebelPilot", "rebelHoth", "rebelEndor", "stormtrooper", "sandtrooper", "snowtrooper", "scoutTrooper", "tiePilot", "atatPilot" };
}
