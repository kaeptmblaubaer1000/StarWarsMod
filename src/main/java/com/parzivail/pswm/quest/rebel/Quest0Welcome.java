package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest0Welcome implements IQuest
{
	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void end(EntityPlayer player)
	{
	}
}
