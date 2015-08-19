package com.parzi.starwarsmod.registry;

import net.minecraftforge.common.util.EnumHelper;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.utils.Lumberjack;

public class MaterialRegister
{
	public static void registerAll()
	{
		StarWarsMod.gaffiMat = EnumHelper.addToolMaterial("gaffiMat", 3, 10240, 1f, 3f, 8);
		StarWarsMod.ewokMat = EnumHelper.addToolMaterial("gaffiMat", 3, 128, 1f, 1f, 2);
		StarWarsMod.gamorreanMat = EnumHelper.addToolMaterial("gamorreanMat", 3, 10240, 1f, 3f, 8);
		StarWarsMod.plasmaMat = EnumHelper.addToolMaterial("plasmaMat", 3, -1, 10f, StarWarsMod.lightsaberDamage, 8);
		StarWarsMod.plasmaMatOff = EnumHelper.addToolMaterial("plasmaMatOff", 3, -1, 10f, 0.1F, 8);

		StarWarsMod.jediRobesMat = EnumHelper.addArmorMaterial("jediRobesMat", -1, new int[] { 0, 2, 0, 0 }, 0);

		StarWarsMod.endorArmorMat = EnumHelper.addArmorMaterial("endorArmorMat", 60, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.hothArmorMat = EnumHelper.addArmorMaterial("hothArmorMat", 60, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.rebelPilotArmorMat = EnumHelper.addArmorMaterial("rebelPilotArmorMat", 70, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.atatPilotArmorMat = EnumHelper.addArmorMaterial("atatPilotArmorMat", 70, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.stormtrooperArmorMat = EnumHelper.addArmorMaterial("stormtrooperArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.scoutTrooperArmorMat = EnumHelper.addArmorMaterial("scoutTrooperArmorMat", 80, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.sandtrooperArmorMat = EnumHelper.addArmorMaterial("sandtroopertArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.snowtrooperArmorMat = EnumHelper.addArmorMaterial("snowtroopertArmorMat", 90, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.bobaArmorMat = EnumHelper.addArmorMaterial("bobaArmorMat", 100, new int[] { 1, 5, 4, 3 }, 4);
		StarWarsMod.tiePilotArmorMat = EnumHelper.addArmorMaterial("tiePilotArmorMat", 70, new int[] { 1, 3, 2, 1 }, 4);

		StarWarsMod.leiaBunsArmorMat = EnumHelper.addArmorMaterial("leiaBunsArmorMat", 0, new int[] { 0, 0, 0, 0 }, 0);

		Lumberjack.info("Materials, reporting for duty!");
	}
}
