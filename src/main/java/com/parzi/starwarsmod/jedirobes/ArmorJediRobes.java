package com.parzi.starwarsmod.jedirobes;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.jedirobes.powers.Power;
import com.parzi.starwarsmod.utils.ForceUtils;
import com.parzi.starwarsmod.utils.ItemUtils;

public class ArmorJediRobes extends ItemArmor
{
	String name = "newJediRobes";

	public static String SIDE_NONE = "none";
	public static String SIDE_JEDI = "jedi";
	public static String SIDE_SITH = "sith";

	public ArmorJediRobes()
	{
		super(StarWarsMod.jediRobesMat, 1, 1);
		this.setUnlocalizedName(StarWarsMod.MODID + "." + name);
		this.setTextureName(StarWarsMod.MODID + ":" + name);
		this.setCreativeTab(com.parzi.starwarsmod.StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.jediRobes)
			return StarWarsMod.MODID + ":" + "textures/models/jediRobesLayer1.png";
		return "";
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Level " + String.valueOf((int)Math.floor(getLevel(stack) / 10)));
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		setupRobe(stack, player);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		setupRobe(stack, player);
	}

	public static ItemStack addLevels(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("level"))
			stack.stackTagCompound.setInteger("level", stack.stackTagCompound.getInteger("level") + levels);
		return stack;
	}

	public static ItemStack setXP(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger("xp", levels);
		return stack;
	}

	public static ItemStack setMaxXP(ItemStack stack, int levels)
	{
		if (stack.stackTagCompound != null)
			stack.stackTagCompound.setInteger("maxxp", levels);
		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		setupRobe(stack, player);
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

	public static int getXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("xp"))
			return stack.stackTagCompound.getInteger("xp");
		return 0;
	}

	public static int getMaxXP(ItemStack stack)
	{
		if (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("maxxp"))
			return stack.stackTagCompound.getInteger("maxxp");
		return 0;
	}

	public void setupRobe(ItemStack stack, Entity player)
	{
		if (ItemUtils.initNBT(stack) && player instanceof EntityPlayer)
			createTags(stack, (EntityPlayer)player);
	}

	public void createTags(ItemStack stack, EntityPlayer owner)
	{
		stack.stackTagCompound.setString("master", owner.getCommandSenderName());
		stack.stackTagCompound.setInteger("level", 0);
		stack.stackTagCompound.setInteger("xp", 0);
		stack.stackTagCompound.setInteger("maxxp", 100);
		stack.stackTagCompound.setString("side", SIDE_NONE);
		stack.stackTagCompound.setTag("powers", new NBTTagCompound());
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("jump", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("push", 0);
		((NBTTagCompound)stack.stackTagCompound.getTag("powers")).setInteger("pull", 0);
	}
}