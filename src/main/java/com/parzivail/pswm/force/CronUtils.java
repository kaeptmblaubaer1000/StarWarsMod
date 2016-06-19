package com.parzivail.pswm.force;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.force.powers.*;
import com.parzivail.pswm.utils.EntityCooldownEntry;
import com.parzivail.util.ui.Lumberjack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Colby on 6/10/2016. Utility class to help with Holocrons
 */
public class CronUtils
{
	public static final String SIDE_JEDI = "jedi";
	public static final String SIDE_SITH = "sith";
	public static final float POINTS_PER_LEVEL = 10;

	//public static PowerBase activePower = null;
	public static boolean isUsingDuration = false;
	public static int health = 0;
	public static float distanceToEntity = -1;
	public static ArrayList<PowerBase> coolingPowers = new ArrayList<>();
	public static ArrayList<EntityCooldownEntry> entitiesWithEffects = new ArrayList<>();
	public static HashMap<String, Class<? extends PowerBase>> powers = new HashMap<>();

	static
	{
		CronUtils.powers.put("jump", PowerJump.class);
		CronUtils.powers.put("push", PowerPush.class);
		CronUtils.powers.put("pull", PowerPull.class);
		CronUtils.powers.put("lightning", PowerLightning.class);
		CronUtils.powers.put("destruction", PowerDestruction.class);
		CronUtils.powers.put("defend", PowerDefend.class);
		CronUtils.powers.put("deflect", PowerDeflect.class);
		CronUtils.powers.put("naturalAwareness", PowerNaturalAwareness.class);
		CronUtils.powers.put("grab", PowerGrab.class);
		CronUtils.powers.put("disable", PowerDisable.class);
		CronUtils.powers.put("slow", PowerSlow.class);
		CronUtils.powers.put("healing", PowerHeal.class);
		CronUtils.powers.put("drainKnowledge", PowerDrainKnowledge.class);
		CronUtils.powers.put("saberThrow", PowerSaberThrow.class);
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

	public static int getLevel(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getLevel(stack);
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

	public static int getMaxLevelOf(EntityPlayer player, String power)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return 0;
		return getMaxLevelOf(stack, power);
	}

	public static int getMaxLevelOf(ItemStack stack, String power)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtPowers))
			return new PowerBase(power).deserialize((NBTTagCompound)((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).getTag(power)).maxLevel;
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
		if ((power = initNewPower(stack, type)) == null)
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

	public static PowerBase initNewPower(EntityPlayer player, String power)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return null;
		return initNewPower(stack, power);
	}

	public static NBTTagCompound getPowers(EntityPlayer player)
	{
		ItemStack stack = getHolocron(player);
		if (stack == null)
			return makeNewPowersNBT();
		return getPowers(stack);
	}

	public static NBTTagCompound makeNewPowersNBT()
	{
		NBTTagCompound compound = new NBTTagCompound();
		for (String powerName : CronUtils.powers.keySet())
			compound.setTag(powerName, CronUtils.initNewPower(powerName).serialize());
		return compound;
	}

	public static NBTTagCompound getPowers(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtPowers))
			return (NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers);
		return makeNewPowersNBT();
	}

	public static int getLevel(ItemStack stack)
	{
		if (stack == null)
			return 0;
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			return stack.stackTagCompound.getInteger(Resources.nbtLevel);
		return 0;
	}

	public static PowerBase initNewPower(ItemStack stack, String type)
	{
		if (stack == null || !stack.hasTagCompound() || !stack.stackTagCompound.hasKey(Resources.nbtWield) || powers.get(type) == null)
			return null;

		Class clazz = powers.get(type);
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

	public static PowerBase initNewPower(String type)
	{
		Class clazz = powers.get(type);
		try
		{
			return ((PowerBase)clazz.getConstructor(int.class).newInstance(0));
		}
		catch (Exception e)
		{
			Lumberjack.log("Couldn't init new power!");
			e.printStackTrace();
			return null;
		}
	}

	public static float getPercentForLevel(int level)
	{
		int i = 100 - level;
		i = i < 10 ? 10 : i;
		return i;
	}

	public static void addLeaderboardSide(String side)
	{
		InputStream in = null;
		try
		{
			in = new URL(Resources.robesLeaderboardAddLink + "?m=add&s=" + side).openStream();
			switch (IOUtils.toString(in))
			{
				case "OK":
					break;
				default:
					Lumberjack.log("Error contacting leaderboard server!");
					break;
			}
			IOUtils.closeQuietly(in);
		}
		catch (Exception e)
		{
			Lumberjack.warn("Couldn't add leaderboard stats!");
			e.printStackTrace();
		}
		finally
		{
			if (in != null)
				IOUtils.closeQuietly(in);
		}
	}

	public static String[] getBasicPowers()
	{
		return new String[] { "jump", "push", "pull", "defend", "disable", "deflect", "grab", "saberThrow" };
	}

	public static String[] getJediPowers()
	{
		return new String[] { "healing", "naturalAwareness" };
	}

	public static ArrayList<String> getPowersAvailableAtLevel(String side, int level)
	{
		ArrayList<String> r = new ArrayList<>();

		r.add("jump");
		r.add("push");

		if (level > 5)
			r.add("pull");
		if (level > 10)
			r.add("defend");
		if (level > 15)
			r.add("disable");
		if (level > 20)
			r.add("deflect");
		if (level > 25)
			r.add("grab");
		if (level > 30)
			r.add("saberThrow");

		if (side.equals(SIDE_JEDI))
		{
			if (level > 30)
				r.add("healing");
			if (level > 35)
				r.add("naturalAwareness");
		}
		else if (side.equals(SIDE_SITH))
		{
			if (level > 35)
				r.add("slow");
			if (level > 40)
				r.add("drainKnowledge");
			if (level > 45)
				r.add("lightning");
			if (level > 50)
				r.add("destruction");
		}

		return r;
	}

	public static String getTitle(String side, int level)
	{
		String s = side.equals(SIDE_JEDI) ? "Jedi " : "Sith ";
		if (side.equals(SIDE_JEDI))
		{
			if (level < 15)
				s += "Padawan";
			else if (level < 35)
				s += "Knight";
			else
				s += "Master";
		}
		else if (level < 45)
			s += "Acolyte";
		else if (level < 55)
			s += "Apprentice";
		else
			s += "Lord";
		return s;
	}

	public static boolean isCooling(String power)
	{
		for (PowerBase p : coolingPowers)
			if (p.name.equals(power))
				return true;
		return false;
	}
}
