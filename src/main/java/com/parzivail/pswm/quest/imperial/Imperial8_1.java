package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestContainer.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestContainer.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial8_1 extends Quest
{
	public Imperial8_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "";//"Good job retrieving the data Trooper, your work here is done. You're being transferred back to Endor to be in an Imperial Navy unit.";
		this.tree.response1 = "Thank you Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Stop by the Quartermaster for anything you need before you go. Good work Trooper.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "So I'm finally cleared to fly ships?";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "It appears that way Trooper. Stop by the Quartermaster for anything you need before you ship out.";
		this.tree.response2DT.response1 = "Sir Yes Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "I've always wanted to be a pilot for the Empire Sir!";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Good to hear Trooper. Make sure to stop by the Quartermaster for anything you need before you go.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Veers";
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
		return "The Imperial Navy";
	}
}
