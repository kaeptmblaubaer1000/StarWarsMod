package com.parzivail.pswm.quest;

import net.minecraft.nbt.NBTTagCompound;

public class NBTQuestTag
{
	private NBTTagCompound compound;

	public NBTQuestTag(NBTTagCompound compound)
	{
		this.compound = compound;
	}

	public boolean hasDoneQuest(String quest)
	{
		if (!this.compound.hasKey(quest))
			this.compound.setBoolean(quest, false);
		return this.compound.getBoolean(quest);
	}

	public NBTQuestTag setQuestDone(String quest)
	{
		this.compound.setBoolean(quest, true);
		return this;
	}

	public boolean isQuestDone(String quest)
	{
		return this.compound.getBoolean(quest);
	}

	public NBTTagCompound getCompound()
	{
		return compound;
	}
}
