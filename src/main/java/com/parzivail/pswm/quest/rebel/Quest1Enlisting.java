package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.DialogTree.Response;
import com.parzivail.pswm.quest.IQuest;

import net.minecraft.entity.player.EntityPlayer;

public class Quest1Enlisting implements IQuest
{
	DialogTree tree;

	public Quest1Enlisting()
	{
		this.tree = new DialogTree();

		this.tree.npcHeader = "Well look at this, a new recruit, nice and shiny in his brand new armor.";
		this.tree.response1 = new Response();
		this.tree.response1.text = "Hi nice to meet you!  My name is {USERNAME}";
		this.tree.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.npcHeader = "It's not so nice to meet you, Shiny.  I've already got enough new recruits to train...";
		this.tree.response1.npcDialog.response1 = new Response();
		this.tree.response1.npcDialog.response1.text = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you’ll never have to see me again.";
		this.tree.response1.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response1.npcDialog.response1.npcDialog.npcHeader = "Oh come on, I'm just playin with ya, kid. We have to test the resolve of our new recruits to see if they are really Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice, and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and we'll head to the range to see if you really have what it takes to blast some Imperial scum.";
		this.tree.response2 = new Response();
		this.tree.response2.text = "What's with the tough guy act, old man?";
		this.tree.response2.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.npcHeader = "It’s no act, I'm the toughest Rebel in this entire galaxy, son, and I'm not here to babysit you.";
		this.tree.response2.npcDialog.response1 = new Response();
		this.tree.response2.npcDialog.response1.text = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you’ll never have to see me again.";
		this.tree.response2.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response2.npcDialog.response1.npcDialog.npcHeader = "Oh come on, I'm just playin with ya, kid. We have to test the resolve of our new recruits to see if they are really Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice, and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and we'll head to the range to see if you really have what it takes to blast some Imperial scum.";
		this.tree.response3 = new Response();
		this.tree.response3.text = "Hey man, I'm just here to blast some Stormtroopers.";
		this.tree.response3.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.npcHeader = "Well isn't that nice, too bad you hold that blaster like a real sleemo.";
		this.tree.response3.npcDialog.response1 = new Response();
		this.tree.response3.npcDialog.response1.text = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you’ll never have to see me again.";
		this.tree.response3.npcDialog.response1.npcDialog = new DialogTree();
		this.tree.response3.npcDialog.response1.npcDialog.npcHeader = "Oh come on, I'm just playin with ya, kid. We have to test the resolve of our new recruits to see if they are really Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice, and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and we'll head to the range to see if you really have what it takes to blast some Imperial scum.";
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
		return "r1-enlisting";
	}
}
