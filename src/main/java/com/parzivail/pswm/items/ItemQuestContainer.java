package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.quest.IQuest;
import com.parzivail.pswm.quest.NBTQuestTag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

public class ItemQuestContainer extends Item
{
	public String name = "questContainer";

	public ItemQuestContainer()
	{
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	public static NBTQuestTag getQuests(ItemStack stack)
	{
		if (!stack.stackTagCompound.hasKey(Resources.nbtQuests))
			stack.stackTagCompound.setTag(Resources.nbtQuests, new NBTQuestTag());
		return (NBTQuestTag)stack.stackTagCompound.getTag(Resources.nbtQuests);
	}

	public static void setQuestDone(EntityPlayer player, IQuest quest)
	{
		ItemStack stack = getQuestContainer(player);
		if (stack == null)
			return;
		getQuests(stack).setQuestDone(quest.getID());
	}

	public static boolean isQuestDone(EntityPlayer player, IQuest quest)
	{
		ItemStack stack = getQuestContainer(player);
		if (stack == null)
			return false;
		return getQuests(stack).isQuestDone(quest.getID());
	}

	public static String getOwner(ItemStack stack)
	{
		if (!stack.stackTagCompound.hasKey(Resources.nbtOwner))
			return null;
		return stack.stackTagCompound.getString(Resources.nbtOwner);
	}

	public static ItemStack getQuestContainer(EntityPlayer player)
	{
		for (ItemStack i : player.inventory.mainInventory)
		{
			if (i == null)
				continue;
			if (i.getItem() instanceof ItemQuestContainer)
				return i;
		}
		return null;
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound nbttagcompound = stack.getTagCompound();
			String s = nbttagcompound.getString(Resources.nbtOwner);

			if (!StringUtils.isNullOrEmpty(s))
			{
				return s + "'s Quest Log";
			}
		}

		return super.getItemStackDisplayName(stack);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int a, boolean b)
	{
		if (!stack.hasTagCompound() && entity instanceof EntityPlayer)
		{
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setString(Resources.nbtOwner, entity.getCommandSenderName());
			getQuests(stack);
		}
	}
}