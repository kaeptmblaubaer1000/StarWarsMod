package com.parzivail.util.entity.trade;

import java.util.List;
import java.util.Random;

public class TradeUtils
{
	/**
	 * Fluctuates a price by a random amount based on a given constraint, adhering to ItemStack size constraints
	 *
	 * @param rand   The random to use
	 * @param price  The original price
	 * @param amount The amount to fluctuate
	 * @return The fluctuated price
	 */
	public static int fluxPrice(Random rand, int price, int amount)
	{
		int x = rand.nextInt(price + amount - (price - amount) + 1) + price - amount;
		if (x > 64)
			x = 64;
		else if (x < 1)
			x = 1;
		return x;
	}

	/**
	 * Gets a trade item from a list of weighted trade items
	 *
	 * @param items The items to pull from
	 * @param rand  The random to use
	 * @return One trade item
	 */
	public static WeightedTradeItem getWeightedItemFromList(List<WeightedTradeItem> items, Random rand)
	{
		int length = items.toArray().length;
		double totalWeight = 0.0D;
		for (int i = 0; i < length; i++)
			totalWeight += items.get(i).weight;
		int randomIndex = -1;
		double random = rand.nextDouble() * totalWeight;
		for (int i = 0; i < length; i++)
		{
			random -= items.get(i).weight;
			if (random <= 0.0D)
			{
				randomIndex = i;
				break;
			}
		}
		return items.get(randomIndex);
	}
}