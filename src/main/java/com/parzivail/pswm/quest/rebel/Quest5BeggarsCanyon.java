package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.DialogTree.Response;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest5BeggarsCanyon implements IQuest
{
	DialogTree tree;

	public Quest5BeggarsCanyon()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Wow, nice job! You didn't get eaten like we were expecting!";
		this.tree.response1 = new Response();
		this.tree.response1.text = "What do you mean \"like we were expecting\"?";
		this.tree.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.npcHeader = "I mean we didn't expect a rookie like you to be able to do it, but you proved us wrong.";
		this.tree.response1.npcDialog.response1 = new Response();
		this.tree.response1.npcDialog.response1.text = "Well now that that's done, what's my first assignment sir?";
		this.tree.response1.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response1.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response1.npcDialog.response2 = new Response();
		this.tree.response1.npcDialog.response2.text = "I'm not your errand boy, I'm a soldier.  Now give me something worth my time.";
		this.tree.response1.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response2.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response1.npcDialog.response3 = new Response();
		this.tree.response1.npcDialog.response3.text = "Well i've learned a lot in my training so far, sir.  So what's next?";
		this.tree.response1.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response3.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response2 = new Response();
		this.tree.response2.text = "It wasn't even a challenge; I usually hunt Gundarks for fun.";
		this.tree.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.npcHeader = "Oh, is that so? Well I'll make sure I come to you for all my big-game hunting needs.";
		this.tree.response2.npcDialog.response1 = new Response();
		this.tree.response2.npcDialog.response1.text = "I'm not THAT good sir, I just got lucky this time.  Could I have a real assignment though?";
		this.tree.response2.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response1.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response2.npcDialog.response2 = new Response();
		this.tree.response2.npcDialog.response2.text = "Just gimme a real assignment already.";
		this.tree.response2.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response2.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response2.npcDialog.response3 = new Response();
		this.tree.response2.npcDialog.response3.text = "I'd be happy to help out sir.  For now though I'd like a real assignment.";
		this.tree.response2.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response3.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response3 = new Response();
		this.tree.response3.text = "Well I'm glad I didn't live up to your expectations, sir.";
		this.tree.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.npcHeader = "As am I, it seems like we've got a real soldier on our hands.";
		this.tree.response3.npcDialog.response1 = new Response();
		this.tree.response3.npcDialog.response1.text = "I'm still new to all of this soldiering but thank you for the kind words sir.  How about a real assignment?";
		this.tree.response3.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response1.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response3.npcDialog.response2 = new Response();
		this.tree.response3.npcDialog.response2.text = "The realest soldier in the Outer Rim that's for sure.  Now give me something that's actually worth my time.";
		this.tree.response3.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response2.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		this.tree.response3.npcDialog.response3 = new Response();
		this.tree.response3.npcDialog.response3.text = "Glad to help the Rebel Alliance sir, what can I do next?";
		this.tree.response3.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response3.npcDialog.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us.  Since you did so well with the Wampa why don't you go ahead and take a T-47 Airspeeder too.  It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder.  Stop by the Quartermaster and he'll give you some Pilot Armor and a ship.  I want you to bring me back at least 5 of those droids.  Good luck, soldier.";
		// TODO: add remaining t47 flying dialog by hand
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
		return "r5-beggars";
	}
}
