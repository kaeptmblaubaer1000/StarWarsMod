package com.parzivail.pswm.jedirobes;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.rendering.force.ModelJediCloak;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.world.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorJediRobes extends ItemArmor
{
	public static String SIDE_NONE = "none";

	public static String SIDE_JEDI = "jedi";
	public static String SIDE_SITH = "sith";

	@SideOnly(Side.CLIENT)
	public static ModelJediCloak model;

	public static float getLevelMult(int level)
	{
		return (float)(10 + level);
	}

	public static float getLevelMult(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			return getLevelMult(stack.stackTagCompound.getInteger(Resources.nbtLevel) / 10);
		return 0;
	}

	public static ItemStack addLevels(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			stack.stackTagCompound.setInteger(Resources.nbtLevel, stack.stackTagCompound.getInteger(Resources.nbtLevel) + levels);
		return stack;
	}

	public static int getLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtLevel))
			return stack.stackTagCompound.getInteger(Resources.nbtLevel);
		return 0;
	}

	public static ItemStack addPoints(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtRemainingPts))
			stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, stack.stackTagCompound.getInteger(Resources.nbtRemainingPts) + levels);
		return stack;
	}

	public static int getPoints(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtRemainingPts))
			return stack.stackTagCompound.getInteger(Resources.nbtRemainingPts);
		return 0;
	}

	public static String getActive(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return "";
		return getActive(stack);
	}

	public static String getActive(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtActive))
			return stack.stackTagCompound.getString(Resources.nbtActive);
		return "";
	}

	public static String getSide(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return "";
		return getSide(stack);
	}

	public static String getSide(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtSide))
			return stack.stackTagCompound.getString(Resources.nbtSide);
		return "";
	}

	public static boolean getIsRunning(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return false;
		return getIsRunning(stack);
	}

	public static boolean getIsRunning(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtIsRunning))
			return stack.stackTagCompound.getBoolean(Resources.nbtIsRunning);
		return false;
	}

	public static int getHealth(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return 0;
		return getHealth(stack);
	}

	public static int getHealth(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtActiveHealth))
			return stack.stackTagCompound.getInteger(Resources.nbtActiveHealth);
		return 0;
	}

	public static void setHealth(EntityPlayer player, int health)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setHealth(stack, health);
	}

	public static void setHealth(ItemStack stack, int health)
	{
		stack.stackTagCompound.setInteger(Resources.nbtActiveHealth, health);
	}

	public static int getActiveLevel(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
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

	public static void setActiveLevel(EntityPlayer player, int level)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setActiveLevel(stack, level);
	}

	public static void setActiveLevel(ItemStack stack, int level)
	{
		stack.stackTagCompound.setInteger(Resources.nbtActiveLevel, level);
	}

	public static int getLevelOf(EntityPlayer player, String power)
	{
		ItemStack stack = getRobes(player);
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

	public static int getEntityTarget(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
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

	public static int getMaxXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtMaxXp))
			return stack.stackTagCompound.getInteger(Resources.nbtMaxXp);
		return 0;
	}

	public static ItemStack getRobes(EntityPlayer player)
	{
		if (player == null)
			return null;
		if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == StarWarsMod.jediRobes)
			return player.inventory.armorItemInSlot(2);
		return null;
	}

	public static boolean getUsingDuration(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return false;
		return getUsingDuration(stack);
	}

	public static boolean getUsingDuration(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtIsUsingDuration))
			return stack.stackTagCompound.getBoolean(Resources.nbtIsUsingDuration);
		return false;
	}

	public static int getXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey(Resources.nbtXp))
			return stack.stackTagCompound.getInteger(Resources.nbtXp);
		return 0;
	}

	public static int getXP(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return 0;
		return getXP(stack);
	}

	public static void setEntityTarget(EntityPlayer player, int target)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setLightningTarget(stack, target);
	}

	public static void setLightningTarget(ItemStack stack, int target)
	{
		stack.stackTagCompound.setInteger(Resources.nbtEntityTarget, target);
	}

	public static void setActive(ItemStack stack, String activeName)
	{
		stack.stackTagCompound.setString(Resources.nbtActive, activeName);
	}

	public static void setActive(EntityPlayer player, String active)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setActive(stack, active);
	}

	public static void setRunning(ItemStack stack, boolean running)
	{
		stack.stackTagCompound.setBoolean(Resources.nbtIsRunning, running);
	}

	public static void setRunning(EntityPlayer player, boolean running)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setRunning(stack, running);
	}

	public static void setDuration(ItemStack stack, boolean duration)
	{
		stack.stackTagCompound.setBoolean(Resources.nbtIsUsingDuration, duration);
	}

	public static void setDuration(EntityPlayer player, boolean duration)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setDuration(stack, duration);
	}

	public static ItemStack setMaxXP(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtMaxXp, levels);
		return stack;
	}

	public static ItemStack setXP(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger(Resources.nbtXp, levels);
		return stack;
	}

	String name = "newJediRobes";

	public ArmorJediRobes()
	{
		super(StarWarsMod.jediRobesMat, 1, 1);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Level " + String.valueOf((int)Math.floor(getLevel(stack) / ArmorJediRobes.getLevelMult(player.inventory.armorItemInSlot(2)))));
	}

	public void createTags(ItemStack stack, EntityPlayer owner)
	{
		stack.stackTagCompound.setString(Resources.nbtMaster, owner.getCommandSenderName());
		stack.stackTagCompound.setString(Resources.nbtEntityTarget, "");
		stack.stackTagCompound.setInteger(Resources.nbtLevel, 0);
		stack.stackTagCompound.setInteger(Resources.nbtXp, 0);
		stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, 0);
		stack.stackTagCompound.setInteger(Resources.nbtMaxXp, 100);
		stack.stackTagCompound.setString(Resources.nbtSide, SIDE_JEDI);
		stack.stackTagCompound.setTag(Resources.nbtPowers, new NBTTagCompound());
		for (String p : ForceUtils.powers.keySet())
			((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).setInteger(p, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot)
	{
		if (model == null)
			model = new ModelJediCloak();
		return model;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.jediRobes)
			return Resources.MODID + ":" + "textures/force/cloak.png";
		return "";
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		this.setupRobe(stack, player);

		// if (player == null || player.getDataWatcher() == null)
		// return;

		// if (world.isRemote)
		// {
		// if (ForceUtils.activePower != null &&
		// ForceUtils.activePower.name.equals("defend"))
		// {
		// ForceUtils.isRunning =
		// ((PowerDefend)ForceUtils.activePower).isRunning;
		// ForceUtils.health = ((PowerDefend)ForceUtils.activePower).health;
		// }

		// player.getDataWatcher().updateObject(Resources.activeDatawatcherId,
		// ForceUtils.activePower == null ? "" : ForceUtils.activePower.name);
		// ArmorJediRobes.setActive(player, ForceUtils.activePower == null ? ""
		// : ForceUtils.activePower.name);

		// player.getDataWatcher().updateObject(Resources.durationDatawatcherId,
		// ForceUtils.isUsingDuration ? 1 : 0);
		// ArmorJediRobes.setDuration(player, ForceUtils.isUsingDuration);

			// player.getDataWatcher().updateObject(Resources.runningDatawatcherId,
			// ForceUtils.isRunning ? 1 : 0);
			// ArmorJediRobes.setRunning(player, ForceUtils.isRunning);

		// player.getDataWatcher().updateObject(Resources.activeLevelDatawatcherId,
		// ForceUtils.activePower == null ? 0 :
		// ForceUtils.activePower.currentLevel);
		// ArmorJediRobes.setActiveLevel(player, ForceUtils.activePower == null
		// ? 0 : ForceUtils.activePower.currentLevel);

			// player.getDataWatcher().updateObject(Resources.activeHealthDatawatcherId,
			// ForceUtils.health);
			// ArmorJediRobes.setHealth(player, ForceUtils.health);
		// }
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		this.setupRobe(stack, player);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		this.setupRobe(stack, player);
	}

	public void setupRobe(ItemStack stack, Entity player)
	{
		if (ItemUtils.initNBT(stack) && player instanceof EntityPlayer)
			this.createTags(stack, (EntityPlayer)player);
	}
}