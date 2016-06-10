package com.parzivail.pswm.jedi;

import com.parzivail.pswm.Resources;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Colby on 5/21/2016.
 */
public class JediUtils
{
	public static final String SIDE_NONE = "none";
	public static final String SIDE_JEDI = "jedi";
	public static final String SIDE_SITH = "sith";
	public static final float POINTS_PER_LEVEL = 10;

	public static ItemStack addLevels(ItemStack stack, int levels)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			stack.stackTagCompound.setInteger(Resources.nbtLevel, stack.stackTagCompound.getInteger(Resources.nbtLevel) + levels);
		return stack;
	}

	public static ItemStack addPoints(ItemStack stack, int levels)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtRemainingPts))
			stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, stack.stackTagCompound.getInteger(Resources.nbtRemainingPts) + levels);
		return stack;
	}

	public static String getActive(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return "";
		return getActive(stack);
	}

	public static String getActive(ItemStack stack)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtActive))
			return stack.stackTagCompound.getString(Resources.nbtActive);
		return "";
	}

	public static int getActiveLevel(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getActiveLevel(stack);
	}

	public static int getActiveLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtActiveLevel))
			return stack.stackTagCompound.getInteger(Resources.nbtActiveLevel);
		return 0;
	}

	public static int getEntityTarget(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return -1;
		return getEntityTarget(stack);
	}

	public static int getEntityTarget(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtEntityTarget))
			return stack.stackTagCompound.getInteger(Resources.nbtEntityTarget);
		return -1;
	}

	public static int getHealth(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getHealth(stack);
	}

	public static int getHealth(ItemStack stack)
	{
		if (stack == null)
			return 0;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtActiveHealth))
			return stack.stackTagCompound.getInteger(Resources.nbtActiveHealth);
		return 0;
	}

	public static boolean getIsRunning(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		return stack != null && getIsRunning(stack);
	}

	public static boolean getIsRunning(ItemStack stack)
	{
		return stack != null && stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtIsRunning) && stack.stackTagCompound.getBoolean(Resources.nbtIsRunning);
	}

	public static int getLevel(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getLevel(stack);
	}

	public static int getLevel(ItemStack stack)
	{
		if (stack == null)
			return 0;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			return stack.stackTagCompound.getInteger(Resources.nbtLevel);
		return 0;
	}

	public static int getLevelOf(EntityPlayer player, String power)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getLevelOf(stack, power);
	}

	public static int getLevelOf(ItemStack stack, String power)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtPowers))
			return ((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).getInteger(power);
		return 0;
	}

	public static int getMaxXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtMaxXp))
			return stack.stackTagCompound.getInteger(Resources.nbtMaxXp);
		return 0;
	}

	public static float getPercentForLevel(int level)
	{
		int i = 100 - level;
		i = i < 10 ? 10 : i;
		return i;
	}

	public static float getPercentForLevel(ItemStack stack)
	{
		if (stack == null)
			return 0;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			return getPercentForLevel((int)(stack.stackTagCompound.getInteger(Resources.nbtLevel) / POINTS_PER_LEVEL));
		return 0;
	}

	public static int getPoints(ItemStack stack)
	{
		if (stack == null)
			return 0;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtRemainingPts))
			return stack.stackTagCompound.getInteger(Resources.nbtRemainingPts);
		return 0;
	}

	public static ItemStack getHolocron(EntityPlayer player)
	{
		if (player == null)
			return null;
		for (ItemStack i : player.inventory.mainInventory)
		{
			if (i == null)
				continue;
			if (i.getItem() instanceof ItemHolocronJedi)
				return i;
		}
		return null;
	}

	public static String getSide(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return "";
		return getSide(stack);
	}

	public static String getSide(ItemStack stack)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtSide))
			return stack.stackTagCompound.getString(Resources.nbtSide);
		return "";
	}

	public static boolean getUsingDuration(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		return stack != null && getUsingDuration(stack);
	}

	public static boolean getUsingDuration(ItemStack stack)
	{
		return stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtIsUsingDuration) && stack.stackTagCompound.getBoolean(Resources.nbtIsUsingDuration);
	}

	public static int getXP(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getXP(stack);
	}

	public static int getXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtXp))
			return stack.stackTagCompound.getInteger(Resources.nbtXp);
		return 0;
	}

	public static void setActive(EntityPlayer player, String active)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setActive(stack, active);
	}

	public static void setActive(ItemStack stack, String activeName)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setString(Resources.nbtActive, activeName);
	}

	public static void setActiveLevel(EntityPlayer player, int level)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setActiveLevel(stack, level);
	}

	public static void setActiveLevel(ItemStack stack, int level)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtActiveLevel, level);
	}

	public static void setDuration(EntityPlayer player, boolean duration)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setDuration(stack, duration);
	}

	public static void setDuration(ItemStack stack, boolean duration)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setBoolean(Resources.nbtIsUsingDuration, duration);
	}

	public static void setEntityTarget(EntityPlayer player, int target)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setLightningTarget(stack, target);
	}

	public static void setHealth(EntityPlayer player, int health)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setHealth(stack, health);
	}

	public static void setHealth(ItemStack stack, int health)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtActiveHealth, health);
	}

	public static void setLightningTarget(ItemStack stack, int target)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtEntityTarget, target);
	}

	public static ItemStack setMaxXP(ItemStack stack, int levels)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtMaxXp, levels);
		return stack;
	}

	public static void setPoints(EntityPlayer player, int points)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setPoints(stack, points);
	}

	public static void setPoints(ItemStack stack, int points)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, points);
	}

	public static void setRunning(EntityPlayer player, boolean running)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setRunning(stack, running);
	}

	public static void setRunning(ItemStack stack, boolean running)
	{
		if (stack == null)
			return;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setBoolean(Resources.nbtIsRunning, running);
	}

	public static ItemStack setXP(ItemStack stack, int levels)
	{
		if (stack == null)
			return null;
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger(Resources.nbtXp, levels);
		return stack;
	}

	public static void setXP(EntityPlayer player, int levels)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setXP(stack, levels);
	}
}
