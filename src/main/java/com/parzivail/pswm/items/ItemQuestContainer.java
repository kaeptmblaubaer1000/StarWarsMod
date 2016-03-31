package com.parzivail.pswm.items;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.quest.NBTQuestTag;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemQuestContainer extends ItemFood
{
	public String name = "questContainer";

	public ItemQuestContainer()
	{
		super(3, 0.0F, false);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	public NBTQuestTag getQuests(ItemStack stack)
	{
		if (!stack.stackTagCompound.hasKey(Resources.nbtQuests))
			stack.stackTagCompound.setTag(Resources.nbtQuests, new NBTQuestTag());
		return (NBTQuestTag)stack.stackTagCompound.getTag(Resources.nbtQuests);
	}
}