package com.parzi.starwarsmod.registry;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraftforge.common.util.EnumHelper;

public class MaterialRegister
{
	public static void registerAll()
	{
		StarWarsMod.gaffiMat = EnumHelper.addToolMaterial("gaffiMat", 3, 10240, 1f, 3f, 8);
		StarWarsMod.plasmaMat = EnumHelper.addToolMaterial("plasmaMat", 3, -1, 10f, (float)StarWarsMod.lightsaberDamage, 8);

		StarWarsMod.jediRobesMat = EnumHelper.addArmorMaterial("jediRobesMat", -1, new int[] { 0, 1, 0, 0 }, 0);
		StarWarsMod.endorArmorMat = EnumHelper.addArmorMaterial("endorArmorMat", 700, new int[] { 1, 3, 2, 1 }, 4);
		StarWarsMod.rebelPilotArmorMat = EnumHelper.addArmorMaterial("rebelPilotArmorMat", 500, new int[] { 1, 3, 2, 1 }, 4);
	}
}
