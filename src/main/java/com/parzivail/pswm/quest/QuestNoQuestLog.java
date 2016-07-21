package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestContainer.isQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class QuestNoQuestLog extends Quest
{
	public QuestNoQuestLog()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "I don't have anything for you. Scram.";
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
		return true;
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
		return "No Quest Log";
	}
}
