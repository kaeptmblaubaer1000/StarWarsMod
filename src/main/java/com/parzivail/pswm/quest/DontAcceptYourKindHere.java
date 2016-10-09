package com.parzivail.pswm.quest;

import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class DontAcceptYourKindHere extends Quest
{
	public DontAcceptYourKindHere()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "We don't accept your kind here. Scram.";
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
		//setQuestDone(entity, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "You're Unwelcome Here";
	}
}
