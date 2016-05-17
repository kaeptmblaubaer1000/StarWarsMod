package com.parzivail.pswm.utils;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Colby on 5/8/2016.
 */
public class BlasterUtils
{
	public static int getCooldown(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtCooldown))
			return stack.stackTagCompound.getInteger(Resources.nbtCooldown);
		return 0;
	}

	public static int getShotsLeft(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtShotsLeft))
			return stack.stackTagCompound.getInteger(Resources.nbtShotsLeft);
		return 0;
	}

	public static int getTicksSinceLastShot(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtTicksSince))
			return stack.stackTagCompound.getInteger(Resources.nbtTicksSince);
		return 0;
	}

	public static void setCooldown(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtCooldown, i);
	}

	public static void setShotsLeft(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtShotsLeft, i);
	}

	public static void setTicksSinceLastShot(ItemStack stack, int i)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtTicksSince, i);
	}

	public static boolean refillShots(ItemStack stack, World world, Entity entity)
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer p = (EntityPlayer)entity;
			if (p.inventory.consumeInventoryItem(StarWarsItems.powerpack))
			{
				setShotsLeft(stack, 10);
				return true;
			}
		}
		return false;
	}
}
