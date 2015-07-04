package com.parzi.starwarsmod.registry;

import net.minecraftforge.common.util.EnumHelper;

import com.parzi.starwarsmod.StarWarsMod;

public class MaterialRegister
{
	public static void registerAll()
	{
		StarWarsMod.gaffiMat = EnumHelper.addToolMaterial("gaffiMat", 3, 10240, 1f, 3f, 8);
		StarWarsMod.plasmaMat = EnumHelper.addToolMaterial("plasmaMat", 3, -1, 10f, (float)StarWarsMod.lightsaberDamage, 8);

		StarWarsMod.jediRobesMat = EnumHelper.addArmorMaterial("jediRobesMat", -1, new int[] { 0, 2, 0, 0 }, 0);

		StarWarsMod.endorArmorMat = EnumHelper.addArmorMaterial("endorArmorMat", 700, new int[] { 1, 4, 3, 2 }, 4);
		StarWarsMod.rebelPilotArmorMat = EnumHelper.addArmorMaterial("rebelPilotArmorMat", 500, new int[] { 1, 3, 2, 1 }, 4);
		StarWarsMod.stormtrooperArmorMat = EnumHelper.addArmorMaterial("stormtroopertArmorMat", 900, new int[] { 1, 5, 4, 3 }, 4);
		StarWarsMod.tiePilotArmorMat = EnumHelper.addArmorMaterial("tiePilottArmorMat", 500, new int[] { 1, 3, 2, 1 }, 4);
	}
}
