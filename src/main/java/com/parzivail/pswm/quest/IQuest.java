package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

public interface IQuest
{
	public abstract boolean canBeGivenQuest(EntityPlayer player);

	public abstract void begin(EntityPlayer player);

	public abstract boolean isQuestComplete(EntityPlayer player);

	public abstract void end(EntityPlayer player);
}