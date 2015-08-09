package com.parzi.starwarsmod.utils;

import net.minecraft.item.ItemStack;

public class WeightedTradeItem
{
	public ItemStack item;
	public ItemStack cost;
	public ItemStack cost2;
	public float weight;

	public WeightedTradeItem(ItemStack cost, ItemStack item, float weight)
	{
		this.cost = cost;
		cost2 = null;
		this.item = item;
		this.weight = weight;
	}

	public WeightedTradeItem(ItemStack cost, ItemStack cost2, ItemStack item, float weight)
	{
		this.cost = cost;
		this.cost2 = cost2;
		this.item = item;
		this.weight = weight;
	}
}
