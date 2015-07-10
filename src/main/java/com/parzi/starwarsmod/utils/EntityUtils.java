package com.parzi.starwarsmod.utils;

import com.parzi.starwarsmod.StarWarsMod;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityUtils
{
	private static int mobId = 300;

	public static void registerWithSpawnEgg(Class<? extends Entity> mobClass, String mobName, int bgColor, int fgColor)
	{
		while (EntityList.getStringFromID(mobId) != null)
		{
			mobId++;
		}
		EntityRegistry.registerModEntity(mobClass, mobName, mobId, StarWarsMod.getInstance(), 80, 3, true);
		EntityList.IDtoClassMapping.put(mobId, mobClass);
		EntityList.entityEggs.put(mobId, new EntityEggInfo(mobId, bgColor, fgColor));
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String entityName)
	{
		while (EntityList.getStringFromID(mobId) != null)
		{
			mobId++;
		}
		EntityRegistry.registerModEntity(entityClass, entityName, mobId, StarWarsMod.getInstance(), 80, 3, true);
		EntityList.IDtoClassMapping.put(mobId, entityClass);
	}

	public static int getLastUsedId()
	{
		return mobId;
	}
}
