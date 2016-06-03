package com.parzivail.util.world;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemUtils
{
	/**
	 * Initializes a stack's NBT tags, if needed.
	 *
	 * @param stack The stack to init
	 * @return Returns true if the stack didn't have an NBT tag, and one was
	 * created, false in any other case
	 */
	public static boolean initNBT(ItemStack stack)
	{
		if (stack == null)
			return false;
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			return true;
		}
		return false;
	}

	public static boolean is(ItemStack stack, Item item)
	{
		return stack != null && stack.getItem() == item;
	}

	public static boolean are(ItemStack[] stacks, Item item)
	{
		boolean flag = true;
		for (ItemStack stack : stacks)
			flag = flag && is(stack, item);
		return flag;
	}

	public static boolean deinc(ItemStack stack, int amount)
	{
		if (!canDeinc(stack, amount))
			return false;

		stack.stackSize -= amount;
		return true;
	}

	public static boolean canDeinc(ItemStack stack, int amount)
	{
		return !(stack == null || stack.stackSize < amount);
	}

	public static boolean inc(ItemStack stack, int amount)
	{
		if (!canInc(stack, amount))
			return false;

		stack.stackSize += amount;
		return true;
	}

	public static boolean canInc(ItemStack stack, int amount)
	{
		return !(stack == null || stack.stackSize + amount > 64);
	}
}
