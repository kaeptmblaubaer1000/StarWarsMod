package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.powers.PowerBase;
import com.parzivail.pswm.utils.ForceUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Colby on 6/10/2016. Utility class to help with Holocrons
 */
public class CronUtils
{
	public static NBTTagCompound compilePowers()
	{
		NBTTagCompound compound = new NBTTagCompound();
		for (PowerBase p : ForceUtils.powers.values())
			compound.setTag(p.name, p.serialize());
		return compound;
	}

	public static ItemStack getHolocron(EntityPlayer player)
	{
		if (player == null)
			return null;
		for (ItemStack i : player.inventory.mainInventory)
		{
			if (i == null)
				continue;
			if (i.getItem() instanceof ItemHolocron)
				return i;
		}
		return null;
	}

	public static PowerBase getActive(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return null;
		return getActive(stack);
	}

	public static String getSide(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return null;
		return getSide(stack);
	}

	public static String getSide(ItemStack stack)
	{
		if (stack == null || !stack.hasTagCompound() || !stack.stackTagCompound.hasKey(Resources.nbtSide))
			return null;

		return stack.stackTagCompound.getString(Resources.nbtSide);
	}

	public static int getLevel(Object o)
	{
		return 10000000;
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
			return new PowerBase(power).deserialize((NBTTagCompound)((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).getTag(power)).currentLevel;
		return 0;
	}

	public static int getPoints(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getPoints(stack);
	}

	public static int getPoints(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtXp))
			return stack.stackTagCompound.getInteger(Resources.nbtRemainingPts);
		return 0;
	}

	public static void setActive(EntityPlayer player, PowerBase power)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		setActive(stack, power);
	}

	public static void clearActive(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return;
		clearActive(stack);
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

	public static int getMaxXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtMaxXp))
			return stack.stackTagCompound.getInteger(Resources.nbtMaxXp);
		return 0;
	}

	public static PowerBase getActive(ItemStack stack)
	{
		if (stack == null || !stack.hasTagCompound() || !stack.stackTagCompound.hasKey(Resources.nbtWield))
			return null;

		NBTTagCompound compound = ((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtWield));
		String type = compound.getString("name");

		PowerBase power;
		if ((power = getPower(stack, type)) == null)
			return null;

		return power.deserialize(compound);
	}

	public static void setActive(ItemStack stack, PowerBase power)
	{
		if (stack == null || !stack.hasTagCompound())
			return;

		stack.stackTagCompound.setTag(Resources.nbtWield, power.serialize());
	}

	public static void clearActive(ItemStack stack)
	{
		if (stack == null || !stack.hasTagCompound())
			return;

		stack.stackTagCompound.setTag(Resources.nbtWield, new NBTTagCompound());
	}

	public static PowerBase getPower(EntityPlayer player, String power)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return null;
		return getPower(stack, power);
	}

	public static PowerBase getPower(ItemStack stack, String type)
	{
		if (stack == null || !stack.hasTagCompound() || !stack.stackTagCompound.hasKey(Resources.nbtWield) || ForceUtils.powers.get(type) == null)
			return null;

		Class clazz = ForceUtils.powers.get(type).getClass();
		try
		{
			return ((PowerBase)clazz.getConstructor(int.class).newInstance(0)).deserialize((NBTTagCompound)((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).getTag(type));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
