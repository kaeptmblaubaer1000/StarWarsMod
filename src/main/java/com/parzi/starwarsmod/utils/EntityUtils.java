package com.parzi.starwarsmod.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityUtils {
	private static int mobId = 300;

	public static void registerMob(Object mod,
			Class<? extends Entity> mobClass, String mobName,
			int trackingRange, int bgColor, int fgColor) {
		while (EntityList.getStringFromID(mobId) != null) {
			mobId++;
		}
		EntityRegistry.registerModEntity(mobClass, mobName, mobId, mod,
				trackingRange, 3, true);
		EntityList.IDtoClassMapping.put(mobId, mobClass);
		EntityList.entityEggs.put(mobId, new EntityEggInfo(mobId, bgColor,
				fgColor));
	}

	public static void registerEntity(Object mod,
			Class<? extends Entity> entityClass, String entityName,
			int trackingRange) {
		while (EntityList.getStringFromID(mobId) != null) {
			mobId++;
		}
		EntityRegistry.registerModEntity(entityClass, entityName, mobId, mod,
				trackingRange, 3, true);
		EntityList.IDtoClassMapping.put(mobId, entityClass);
	}

	public static int getLastUsedId() {
		return mobId;
	}
}
