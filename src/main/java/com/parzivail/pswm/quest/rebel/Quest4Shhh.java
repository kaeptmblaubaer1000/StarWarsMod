package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.DialogTree.Response;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest4Shhh implements IQuest
{
	DialogTree tree;

	public Quest4Shhh()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to the temperate beach planet Hoth.  You can enjoy the pool, take a nice relaxing soak in a Bacta tank, and try your hardest not to get eaten by Wampas like the rest of us.";
		this.tree.response1 = new Response();
		this.tree.response1.text = "You do know this is an ice planet right sir?";
		this.tree.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.npcHeader = "Frankly I don't know how I could miss it, recruit";
		this.tree.response1.npcDialog.response1 = new Response();
		this.tree.response1.npcDialog.response1.text = "Sorry to ask sir, but what's my first assignment?";
		this.tree.response1.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response1.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response1.npcDialog.response2 = new Response();
		this.tree.response1.npcDialog.response2.text = "Well with those old eyes of yours I'm surprised you can see anything.  What's my first assignment anyway?";
		this.tree.response1.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response2.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response1.npcDialog.response3 = new Response();
		this.tree.response1.npcDialog.response3.text = "Just asking sir.  So what's my first assignment?";
		this.tree.response1.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response3.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response2 = new Response();
		this.tree.response2.text = "Finally, a superior officer with a sense of humor.";
		this.tree.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.npcHeader = "Well, the Alliance found it funny to station me here, so why not have some fun with it?";
		this.tree.response2.npcDialog.response1 = new Response();
		this.tree.response2.npcDialog.response1.text = "I guess that's one way to deal with the cold sir.  Could I get my first assignment though?";
		this.tree.response2.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response1.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response2.npcDialog.response2 = new Response();
		this.tree.response2.npcDialog.response2.text = "I'd probably do the same, so why did they send me here anyway?";
		this.tree.response2.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response2.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response2.npcDialog.response3 = new Response();
		this.tree.response2.npcDialog.response3.text = "I'm sure the troops love you here sir.  So what's my first assignment?";
		this.tree.response2.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response3.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response3 = new Response();
		this.tree.response3.text = "I see you're trying to make the best of the situation sir.";
		this.tree.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.npcHeader = "That's what we have to do here on Hoth.  It's a grueling station, but you'll learn a lot here recruit.";
		this.tree.response3.npcDialog.response1 = new Response();
		this.tree.response3.npcDialog.response1.text = "Hopefully about how to shoot properly sir, I don't think i'd be much in a battle right now.  What's my first assignment by the way?";
		this.tree.response3.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response1.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response3.npcDialog.response2 = new Response();
		this.tree.response3.npcDialog.response2.text = "Grueling or not i'm here for experience so what's my first assignment?";
		this.tree.response3.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response2.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		this.tree.response3.npcDialog.response3 = new Response();
		this.tree.response3.npcDialog.response3.text = "I'm ready for the challenge, sir.  What's my first assignment?";
		this.tree.response3.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response3.npcDialog.npcHeader = "First things first rookie, you need to show us what you're made of.  It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		// TODO: add remaining wampa dialog by hand
	}

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
		ItemQuestContainer.setQuestDone(player, this);
	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return tree;
	}

	@Override
	public String getID()
	{
		return "r4-shhh";
	}
}
