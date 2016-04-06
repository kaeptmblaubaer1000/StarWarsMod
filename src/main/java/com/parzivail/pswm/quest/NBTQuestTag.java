package com.parzivail.pswm.quest;

import net.minecraft.nbt.NBTTagCompound;

public class NBTQuestTag extends NBTTagCompound
{
	public boolean hasDoneQuest(String quest)
	{
		if (!this.hasKey(quest))
			this.setBoolean(quest, false);
		return this.getBoolean(quest);
	}

	public void setQuestDone(String quest)
	{
		this.setBoolean(quest, true);
	}

	public boolean isQuestDone(String quest)
	{
		return this.getBoolean(quest);
	}
}
