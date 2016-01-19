package com.parzivail.util.entity.trade;

import net.minecraft.item.ItemStack;

public class WeightedLoot
{
	public ItemStack item;
	public float weight;

	public WeightedLoot(ItemStack item, float weight)
	{
		this.item = item;
		this.weight = weight;
	}
}