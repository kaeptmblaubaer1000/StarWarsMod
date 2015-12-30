package com.parzi.starwarsmod.jedirobes;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.parzi.starwarsmod.StarWarsEnum;
import com.parzi.starwarsmod.StarWarsMod;
import com.parzi.starwarsmod.armor.ArmorBobaJetpack;
import com.parzi.starwarsmod.utils.ItemUtils;
import com.parzi.starwarsmod.utils.KeyboardUtils;
import com.parzi.starwarsmod.utils.Lumberjack;
import com.parzi.starwarsmod.utils.TextUtils;

public class ArmorJediRobes extends ItemArmor
{
	String name = "newJediRobes";

	private static String SIDE_NONE = "none";
	private static String SIDE_JEDI = "jedi";
	private static String SIDE_SITH = "sith";

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
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.isSneaking() && !world.isRemote)
			player.openGui(StarWarsMod.instance, StarWarsEnum.GUI_ROBES, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return stack;
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		setupRobe(stack, player);
	}

	public static ItemStack addLevels(ItemStack stack, int levels)
	{
		stack.stackTagCompound.setInteger("level", stack.stackTagCompound.getInteger("level") + levels);
		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int i, boolean b)
	{
		setupRobe(stack, player);
	}

	public int getLevel(ItemStack stack)
	{
		return stack.stackTagCompound.getInteger("level");
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
		stack.stackTagCompound.setString("side", SIDE_NONE);
	}
}