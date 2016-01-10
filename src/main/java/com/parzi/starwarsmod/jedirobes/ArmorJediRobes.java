package com.parzi.starwarsmod.jedirobes;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.parzi.starwarsmod.Resources;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.powers.PowerDefend;
import com.parzi.starwarsmod.rendering.force.ModelJediCloak;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.util.world.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorJediRobes extends ItemArmor
{
	public static String SIDE_NONE = "none";

	public static String SIDE_JEDI = "jedi";
	public static String SIDE_SITH = "sith";

	@SideOnly(Side.CLIENT)
	public static ModelJediCloak model;

	public static ItemStack addLevels(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("level"))
			stack.stackTagCompound.setInteger("level", stack.stackTagCompound.getInteger("level") + levels);
		return stack;
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
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("active"))
			return stack.stackTagCompound.getString("active");
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
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("isRunning"))
			return stack.stackTagCompound.getBoolean("isRunning");
		return false;
	}

	public static int getHealth(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return 0;
		return getActiveLevel(stack);
	}

	public static int getHealth(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("activeHealth"))
			return stack.stackTagCompound.getInteger("activeHealth");
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
		stack.stackTagCompound.setInteger("activeHealth", health);
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
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("activeLevel"))
			return stack.stackTagCompound.getInteger("activeLevel");
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
		stack.stackTagCompound.setInteger("activeLevel", level);
	}

	public static int getLevel(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("level"))
			return stack.stackTagCompound.getInteger("level");
		return 0;
	}

	public static int getLevelOf(ItemStack stack, String power)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("powers"))
			return ((NBTTagCompound)stack.stackTagCompound.getTag("powers")).getInteger(power);
		return 0;
	}

	public static String getLightningTarget(EntityPlayer player)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return "";
		return getLightningTarget(stack);
	}

	public static String getLightningTarget(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("lightning"))
			return stack.stackTagCompound.getString("lightning");
		return "";
	}

	public static int getMaxXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("maxxp"))
			return stack.stackTagCompound.getInteger("maxxp");
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
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("isUsingDuration"))
			return stack.stackTagCompound.getBoolean("isUsingDuration");
		return false;
	}

	public static int getXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("xp"))
			return stack.stackTagCompound.getInteger("xp");
		return 0;
	}

	public static void setLightningTarget(EntityPlayer player, String target)
	{
		ItemStack stack = getRobes(player);
		if (stack == null)
			return;
		setLightningTarget(stack, target);
	}

	public static void setLightningTarget(ItemStack stack, String target)
	{
		stack.stackTagCompound.setString("lightning", target);
	}

	public static void setActive(ItemStack stack, String activeName)
	{
		stack.stackTagCompound.setString("active", activeName);
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
		stack.stackTagCompound.setBoolean("isRunning", running);
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
		stack.stackTagCompound.setBoolean("isDuration", duration);
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
			stack.stackTagCompound.setInteger("maxxp", levels);
		return stack;
	}

	public static ItemStack setXP(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger("xp", levels);
		return stack;
	}

	String name = "newJediRobes";

	public ArmorJediRobes()
	{
		super(StarWarsMod.jediRobesMat, 1, 1);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(com.parzi.starwarsmod.StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Level " + String.valueOf((int)Math.floor(getLevel(stack) / 10)));
	}

	public void createTags(ItemStack stack, EntityPlayer owner)
	{
		stack.stackTagCompound.setString("master", owner.getCommandSenderName());
		stack.stackTagCompound.setString("lightning", "");
		stack.stackTagCompound.setInteger("level", 0);
		stack.stackTagCompound.setInteger("xp", 0);
		stack.stackTagCompound.setInteger("maxxp", 100);
		stack.stackTagCompound.setString("side", SIDE_NONE);
		stack.stackTagCompound.setTag("powers", new NBTTagCompound());
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("jump", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("push", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("pull", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("ligntning", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("destruction", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("defend", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("deflect", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("naturalAwareness", 0);
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

		if (player == null || player.getDataWatcher() == null)
			return;

		if (world.isRemote)
		{
			if (ForceUtils.activePower != null && ForceUtils.activePower.name.equals("defend"))
			{
				ForceUtils.isRunning = ((PowerDefend)ForceUtils.activePower).isRunning;
				ForceUtils.health = ((PowerDefend)ForceUtils.activePower).health;
			}

			player.getDataWatcher().updateObject(Resources.activeDatawatcherId, ForceUtils.activePower == null ? "" : ForceUtils.activePower.name);
			ArmorJediRobes.setActive(player, ForceUtils.activePower == null ? "" : ForceUtils.activePower.name);

			player.getDataWatcher().updateObject(Resources.durationDatawatcherId, ForceUtils.isUsingDuration ? 1 : 0);
			ArmorJediRobes.setDuration(player, ForceUtils.isUsingDuration);

			// player.getDataWatcher().updateObject(Resources.runningDatawatcherId,
			// ForceUtils.isRunning ? 1 : 0);
			// ArmorJediRobes.setRunning(player, ForceUtils.isRunning);

			player.getDataWatcher().updateObject(Resources.activeLevelDatawatcherId, ForceUtils.activePower == null ? 0 : ForceUtils.activePower.currentLevel);
			ArmorJediRobes.setActiveLevel(player, ForceUtils.activePower == null ? 0 : ForceUtils.activePower.currentLevel);

			// player.getDataWatcher().updateObject(Resources.activeHealthDatawatcherId,
			// ForceUtils.health);
			// ArmorJediRobes.setHealth(player, ForceUtils.health);
		}
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