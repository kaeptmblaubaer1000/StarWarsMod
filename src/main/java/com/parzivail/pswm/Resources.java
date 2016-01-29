package com.parzivail.pswm;

import net.minecraft.util.ResourceLocation;

public class Resources
{
	public static class ConfigOptions
	{
		public static int biomeTatooineId;
		public static int biomeHothId;
		public static int biomeKashyyykId;
		public static int biomeYavin4Id;
		public static int biomeEndorId;
		public static int biomeEndorPlainsId;
		public static int biomeDagobahId;
		public static int biomeIlumId;
		public static int dimTatooineId;
		public static int dimHothId;
		public static int dimKashyyykId;
		public static int dimYavin4Id;
		public static int dimDagobahId;
		public static int dimEndorId;
		public static int dimEndorPlainsId;
		public static int dimIlumId;
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
	}

	// Core
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "1.2.5";
	public static final String DEV_VER = "dev7";
	public static String ONLINE_VERSION = "";

	public static boolean IS_DEV_ENVIRONVENT = false;

	public static boolean IS_SEQUEL_RELEASE = true;

	public static final String[] checkCompatList = { "sw_jbs", "The Star Wars Mod" };
	public static final String remoteVersionLink = "https://raw.githubusercontent.com/Parzivail-Modding-Team/ParziStarWarsMod/master/VERSION.md";
	public static final String robesLeaderboardAddLink = "http://parzivail.com/mods/tswm/addLeaderboard.php";

	public static int GUI_MV = 0;
	public static int GUI_ROBES = 1;
	public static int GUI_JEDI_SITH = 2;
	public static int GUI_HOLOTABLE = 3;

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

	public static final String nbtShotsLeft = "shotsLeft";
	public static final String nbtCooldown = "cooldown";
	public static final String nbtTicksSince = "ticksSince";
}
