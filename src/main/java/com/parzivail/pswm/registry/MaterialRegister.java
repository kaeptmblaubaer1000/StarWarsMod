package com.parzivail.pswm.registry;

import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.ui.Lumberjack;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialRegister
{
	public static void registerAll()
	{
		StarWarsMod.materialGaffi = EnumHelper.addToolMaterial("gaffiMat", 3, 10240, 1.0F, 8, 8);
		StarWarsMod.materialEwok = EnumHelper.addToolMaterial("gaffiMat", 3, 128, 1.0F, 1.0F, 2);
		StarWarsMod.materialGamorrean = EnumHelper.addToolMaterial("gamorreanMat", 3, 10240, 1.0F, 3.0F, 8);
		StarWarsMod.materialPlasma = EnumHelper.addToolMaterial("plasmaMat", 3, -1, 10.0F, ConfigOptions.lightsaberDamage, 8);
		StarWarsMod.materialPlasmaOff = EnumHelper.addToolMaterial("plasmaMatOff", 3, -1, 10.0F, 0.1F, 8);
		StarWarsMod.materialNoDamage = EnumHelper.addToolMaterial("noDamage", 3, -1, 10.0F, -4, 0);
		StarWarsMod.jediRobesMat = EnumHelper.addArmorMaterial("jediRobesMat", -1, new int[] { 0, 2, 0, 0 }, 0);
		StarWarsMod.endorArmorMat = EnumHelper.addArmorMaterial("endorArmorMat", 60, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.fleetArmorMat = EnumHelper.addArmorMaterial("endorArmorMat", 60, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.hothArmorMat = EnumHelper.addArmorMaterial("hothArmorMat", 60, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.rebelPilotArmorMat = EnumHelper.addArmorMaterial("rebelPilotArmorMat", 70, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.atatPilotArmorMat = EnumHelper.addArmorMaterial("atatPilotArmorMat", 70, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.stormtrooperArmorMat = EnumHelper.addArmorMaterial("stormtrooperArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.stormtrooperNewArmorMat = EnumHelper.addArmorMaterial("stormtrooperNewArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.scoutTrooperArmorMat = EnumHelper.addArmorMaterial("scoutTrooperArmorMat", 80, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.sandtrooperArmorMat = EnumHelper.addArmorMaterial("sandtroopertArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.snowtrooperArmorMat = EnumHelper.addArmorMaterial("snowtroopertArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.bobaArmorMat = EnumHelper.addArmorMaterial("bobaArmorMat", 100, new int[] { 1, 5, 4, 3 }, 4);
		StarWarsMod.tiePilotArmorMat = EnumHelper.addArmorMaterial("tiePilotArmorMat", 70, new int[] { 1, 3, 2, 1 }, 4);
		StarWarsMod.leiaBunsArmorMat = EnumHelper.addArmorMaterial("leiaBunsArmorMat", 0, new int[] { 0, 0, 0, 0 }, 0);
		Lumberjack.info("Materials, reporting for duty!");
	}
}
