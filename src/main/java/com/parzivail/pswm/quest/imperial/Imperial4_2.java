package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial4_2 extends Quest
{
	public Imperial4_2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to Tatooine, Trooper. Before I give you your mission, go by the Quartermaster and get some Sandtrooper Armor and any blasters you need.";
		this.tree.response1 = "Sir Yes Sir!";
		this.tree.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Furgan";
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
		return "Sandy Troopers";
	}
}
