package com.parzi.starwarsmod;

import com.parzi.starwarsmod.handlers.ClientEventHandler;
import com.parzi.starwarsmod.handlers.CommonEventHandler;
import com.parzi.starwarsmod.items.crafting.ItemLightsaberCrystal;
import com.parzi.starwarsmod.items.weapons.ItemBlasterHeavy;
import com.parzi.starwarsmod.items.weapons.ItemBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemEwokSpear;
import com.parzi.starwarsmod.items.weapons.ItemGaffiStick;
import com.parzi.starwarsmod.items.weapons.ItemGamorreanAx;
import com.parzi.starwarsmod.items.weapons.ItemLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemSequelBlasterPistol;
import com.parzi.starwarsmod.items.weapons.ItemSequelBlasterRifle;
import com.parzi.starwarsmod.items.weapons.ItemSequelLightsaber;
import com.parzi.starwarsmod.items.weapons.ItemSequelLightsaberOff;
import com.parzi.starwarsmod.items.weapons.ItemWookieeBowcaster;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;

public class Resources
{
	// Core
	public static final String MODID = "starwarsmod";
	public static final String VERSION = "1.2.5";
	public static final String DEV_VER = "dev6";
	public static String ONLINE_VERSION = "";
	public static boolean IS_DEV_ENVIRONVENT = false;
	
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
}
