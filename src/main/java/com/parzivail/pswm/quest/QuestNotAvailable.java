package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class QuestNotAvailable extends Quest
{
	public QuestNotAvailable()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Go and complete your assignment before returning here.";
	}

	@Override
	public String getQuestgiverName()
	{
		return "";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this);
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return isQuestDone(player, this);
	}

	@Override
	public void end(EntityPlayer player)
	{
		//setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "Quest Unavailable";
	}
}
