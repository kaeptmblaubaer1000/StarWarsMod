package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.DialogTree.Response;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest3TicketToTheGalaxy implements IQuest
{
	DialogTree tree;

	public Quest3TicketToTheGalaxy()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Good to see you again Shiny, are you ready for your first assignment?";
		this.tree.response1 = new Response();
		this.tree.response1.text = "Of course sir, where are we headed?";
		this.tree.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.npcHeader = "We aren't going anywhere.  You, however, are shipping off to Hoth.";
		this.tree.response1.npcDialog.response1 = new Response();
		this.tree.response1.npcDialog.response1.text = "But isn't it cold there sir? I don't want to get frostbite!";
		this.tree.response1.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response1.npcDialog.npcHeader = "You'll be fine Shiny, here's the Hoth Hyperdrive for your ship.  Make sure to stop by the Quartermaster to get some Hoth Armor before you go.";
		this.tree.response1.npcDialog.response2 = new Response();
		this.tree.response1.npcDialog.response2.text = "It's gotta be better than here that's for sure.";
		this.tree.response1.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response2.npcDialog.npcHeader = "I don't know how you could justify that, but whatever makes you feel tough Shiny.  Make sure to stop by the Quartermaster for your Hoth Hyperdrive.";
		this.tree.response1.npcDialog.response3 = new Response();
		this.tree.response1.npcDialog.response3.text = "Anywhere the Rebels need support, you can count on me sir.";
		this.tree.response1.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response3.npcDialog.npcHeader = "Glad to hear it soldier, Make sure to stop by the Quartermaster for your Hoth Hyperdrive, and good luck.";
		this.tree.response2 = new Response();
		this.tree.response2.text = "I'm ready to be anywhere besides in front of you gramps.";
		this.tree.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.npcHeader = "I couldn't agree more Shiny.";
		this.tree.response2.npcDialog.response1 = new Response();
		this.tree.response2.npcDialog.response1.text = "Sir this armor doesn't even have any Shiny plating on it...";
		this.tree.response2.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response1.npcDialog.npcHeader = "It's a nickname kid, because you haven't seen any action yet.  In any case, make sure to stop by the Quartermaster for your Hoth Hyperdrive.  Good luck kid.";
		this.tree.response2.npcDialog.response2 = new Response();
		this.tree.response2.npcDialog.response2.text = "You're going to want to stop calling me Shiny.";
		this.tree.response2.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response2.npcDialog.npcHeader = "And you'll want to stop calling me gramps.  Here's a Hoth Hyperdrive for your ship.  Make sure to stop by the Quartermaster for a Hoth Hyperdrive, and try to stay warm, we don't want you freezing to death out there.";
		this.tree.response2.npcDialog.response3 = new Response();
		this.tree.response2.npcDialog.response3.text = "Good because I'm ready to support the Rebels and gain some experience sir!";
		this.tree.response2.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response3.npcDialog.npcHeader = "Always a great thing to hear soldier.  Make sure to stop by the Quartermaster and get a Hoth Hyperdrive on your way out.";
		this.tree.response3 = new Response();
		this.tree.response3.text = "I'm ready to blast some Imperial scum if that's what you mean.";
		this.tree.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.npcHeader = "Whoa Shiny, easy with the blaster.  You're not blasting any Troopers yet.";
		this.tree.response3.npcDialog.response1 = new Response();
		this.tree.response3.npcDialog.response1.text = "I don't like the sound of blasting OR getting blasted at sir...";
		this.tree.response3.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response1.npcDialog.npcHeader = "Then maybe you should consider flying Skyhoppers on Tatooine for a living.  In any case, stop by the Quartermaster and get a Hoth Hyperdrive and report to your new post soldier.  And make sure you're ready to use that blaster of yours.";
		this.tree.response3.npcDialog.response2 = new Response();
		this.tree.response3.npcDialog.response2.text = "Probably because you're still here talking my ear off sir.";
		this.tree.response3.npcDialog.response2.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response2.npcDialog.npcHeader = "Maybe that's because I'm trying to train you Shiny.  Just hurry up and go to the Quartermaster to get your Hoth Hyperdrive.  Try not to land in any asteroid fields for a pit stops, you never know, it might be a giant space worm.";
		this.tree.response3.npcDialog.response3 = new Response();
		this.tree.response3.npcDialog.response3.text = "Bantha poodoo! Well then what's the assignment sir?";
		this.tree.response3.npcDialog.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response3.npcDialog.npcHeader = "Couldn't tell you Shiny, it's just part of your next phase of training.  Make sure you stop by the Quartermaster for a Hoth Hyperdrive.  Enjoy your stay and oh, don't get eaten by a Wampa, kid.";
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
		return "r3-ticket";
	}
}
