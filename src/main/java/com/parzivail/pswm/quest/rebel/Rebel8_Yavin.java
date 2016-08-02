package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel8_Yavin extends Quest
{
	public Rebel8_Yavin()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to Red Squadron kid, we've heard a lot about you. Even heard you might have flown a T47 back on Hoth.";
		this.tree.response1 = "All good I hope, i'm happy to be here.";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Of course soldier, you wouldn't be here if that wasn't the case. First things first you need your pilot armor. Go see the Quartermaster for it then report back here for your flight briefing.";
		this.tree.response2 = "Yeah I'm a pretty big deal.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "So am I kid, but I don't tell everyone about it. Now go see the Quartermaster for your Rebel Pilot Armor then report back to me for your flight briefing.";
		this.tree.response3 = "Hopefully nothing too bad sir..";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Of course not Shiny. Now go see the Quartermaster for your Rebel Pilot Armor then report back to me for your flight briefing.";
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
	public String getQuestgiverName()
	{
		return "Dreis";
	}

	@Override
	public String getID()
	{
		return "Red Squadron";
	}
}
