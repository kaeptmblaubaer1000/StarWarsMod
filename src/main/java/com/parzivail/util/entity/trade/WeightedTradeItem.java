package com.parzivail.util.entity.trade;

import net.minecraft.item.ItemStack;

public class WeightedTradeItem
{
	public ItemStack item;
	public ItemStack cost;
	public ItemStack cost2;
	public float weight;

	/**
	 * Defines a trade with specific weight
	 *
	 * @param cost   The cost of the trade
	 * @param item   The item to trade
	 * @param weight The weight of the trade
	 */
	public WeightedTradeItem(ItemStack cost, ItemStack item, float weight)
	{
		this.cost = cost;
		this.cost2 = null;
		this.item = item;
		this.weight = weight;
	}

	/**
	 * Defines a trade with specific weight
	 *
	 * @param cost   The cost of the trade
	 * @param cost2  The second cost of the trade
	 * @param item   The item to trade
	 * @param weight The weight of the trade
	 */
	public WeightedTradeItem(ItemStack cost, ItemStack cost2, ItemStack item, float weight)
	{
		this.cost = cost;
		this.cost2 = cost2;
		this.item = item;
		this.weight = weight;
	}
}