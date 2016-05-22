package com.parzivail.pswm.jedi;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.utils.ForceUtils;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

import java.util.List;

public class ItemHolocronJedi extends Item
{
	public String name = "holocronJedi";

	public ItemHolocronJedi()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
		{
			String s = stack.getTagCompound().getString(Resources.nbtMaster);

			if (!StringUtils.isNullOrEmpty(s))
			{
				return s + "'s Holocron";
			}
		}

		return super.getItemStackDisplayName(stack);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
	{
		list.add("Level " + String.valueOf((int)Math.floor(JediUtils.getLevel(stack) / 10f)));
	}

	public void createTags(ItemStack stack, EntityPlayer owner)
	{
		stack.stackTagCompound.setString(Resources.nbtMaster, owner.getCommandSenderName());
		stack.stackTagCompound.setString(Resources.nbtEntityTarget, "");
		stack.stackTagCompound.setInteger(Resources.nbtLevel, 0);
		stack.stackTagCompound.setInteger(Resources.nbtXp, 0);
		stack.stackTagCompound.setInteger(Resources.nbtRemainingPts, 0);
		stack.stackTagCompound.setInteger(Resources.nbtMaxXp, 100);
		stack.stackTagCompound.setString(Resources.nbtSide, JediUtils.SIDE_JEDI);
		stack.stackTagCompound.setTag(Resources.nbtPowers, new NBTTagCompound());
		for (String p : ForceUtils.powers.keySet())
			((NBTTagCompound)stack.stackTagCompound.getTag(Resources.nbtPowers)).setInteger(p, 0);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int a, boolean b)
	{
		this.setupRobe(stack, entity);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		this.setupRobe(stack, player);
	}

	public void setupRobe(ItemStack stack, Entity player)
	{
		if (ItemUtils.initNBT(stack) && player instanceof EntityPlayer)
			this.createTags(stack, (EntityPlayer)player);
	}
}