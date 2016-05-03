package com.parzivail.util.world;

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
}
