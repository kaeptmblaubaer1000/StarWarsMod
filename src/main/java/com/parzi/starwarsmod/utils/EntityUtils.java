package com.parzi.starwarsmod.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import com.parzi.starwarsmod.StarWarsMod;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityUtils
{
	private static int mobId = 300;

	public static String getDroidSittingMessage(boolean isSitting)
	{
		return isSitting ? "Staying" : "Following";
	}

	public static int getLastUsedId()
	{
		return mobId;
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String entityName)
	{
		while (EntityList.getStringFromID(mobId) != null)
			mobId += 1;
		EntityRegistry.registerModEntity(entityClass, entityName, mobId, StarWarsMod.instance, 80, 3, true);
		EntityList.IDtoClassMapping.put(Integer.valueOf(mobId), entityClass);
	}

	public static void registerWithSpawnEgg(Class<? extends Entity> mobClass, String mobName, int bgColor, int fgColor)
	{
		while (EntityList.getStringFromID(mobId) != null)
			mobId += 1;
		EntityRegistry.registerModEntity(mobClass, mobName, mobId, StarWarsMod.instance, 80, 3, true);
		EntityList.IDtoClassMapping.put(Integer.valueOf(mobId), mobClass);
		EntityList.entityEggs.put(Integer.valueOf(mobId), new EntityList.EntityEggInfo(mobId, bgColor, fgColor));
	}
}