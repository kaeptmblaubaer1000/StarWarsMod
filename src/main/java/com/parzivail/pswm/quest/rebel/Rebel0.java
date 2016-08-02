package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.rebelRecruit;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel0 extends Quest
{
	public Rebel0()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to the Rebel Alliance. We're a small group dedicated to taking back the galaxy from the Galactic Empire. If you want to join us, just find the Quartermaster and he'll give you some armor. You can find him in the main hangar, good luck kid.";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Rex";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && rebelRecruit.isQuestComplete(player);
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
		setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "Welcome to The Republic Alliance";
	}
}
