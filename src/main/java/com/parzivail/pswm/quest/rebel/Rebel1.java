package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel1 extends Quest
{
	public Rebel1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Well look at this, a new recruit, nice and Shiny in his brand new armor.";
		this.tree.response1 = "Hi nice to meet you!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "It's not so nice to meet you, Shiny. I've already got enough new recruits to train...";
		this.tree.response1DT.response1 = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you'll never have to see me again.";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
		this.tree.response2 = "What's with the tough guy act, old man?";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "It's no act, I'm the toughest Rebel in this entire galaxy son, and I'm not here to babysit you.";
		this.tree.response2DT.response1 = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you'll never have to see me again.";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
		this.tree.response3 = "Hey man, I'm just here to blast some Stormtroopers.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Well isn't that nice, too bad you probably hold a blaster like a real sleemo.";
		this.tree.response3DT.response1 = "Look, I'm here to join the Rebel Alliance and restore the galaxy to its former peaceful state, if you don't want me just say so and you'll never have to see me again.";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Oh come on, I'm just playin with ya kid. We have to test the resolve of our new recruits to see if they really are Rebel material. You seem like you'll fit the bill perfectly. First things first though, we need to get you onto the range for some target practice and that means you'll need a blaster. Head back to the Quartermaster and pick up an A-280 Blaster Rifle. Then meet me back here and you'll head to the range to see if you really do have what it takes to blast some Imperial scum.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return false;
	}

	@Override
	public void begin(EntityPlayer player)
	{

	}

	@Override
	public boolean isQuestComplete(EntityPlayer player)
	{
		return false;
	}

	@Override
	public void end(EntityPlayer player)
	{

	}

	@Override
	public DialogTree getDialog(EntityPlayer player)
	{
		return null;
	}

	@Override
	public String getID()
	{
		return null;
	}
}
