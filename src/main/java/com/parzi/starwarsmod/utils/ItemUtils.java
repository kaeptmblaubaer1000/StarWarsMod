package com.parzi.starwarsmod.utils;

import net.minecraft.item.Item;

public class ItemUtils {
	public static int getNextAvailableId() {
		int nextId = 0;
		while (Item.getItemById(nextId) != null) {
			nextId++;
		}
		return nextId;
	}
}
