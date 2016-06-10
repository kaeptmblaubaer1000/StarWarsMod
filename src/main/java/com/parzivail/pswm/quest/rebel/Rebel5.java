package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel5 extends Quest
{
	public Rebel5()
	{
		DialogTree allresp = new DialogTree();
		allresp.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet trying to find us. Since you did so well with the Wampa feel free to take a T-47 Airspeeder if you'd like. It'll make things a lot faster, and its blasters will hit those Imperial Probe Droids a lot harder. Stop by the Quartermaster and he'll give you some Rebel Pilot Armor and a ship. I want you to bring me back at least 5 of those droids. Good luck, soldier.";
		allresp.response1 = "But I've never flown one of those before, sir!";
		allresp.response1DT = new DialogTree();
		allresp.response1DT.npcHeader = "I'm sure you'll figure it out quick enough, kid.";
		allresp.response2 = "They won't even know what hit 'em.";
		allresp.response2DT = new DialogTree();
		allresp.response3 = "Thank you sir, I'll make you proud.";
		allresp.response3DT = new DialogTree();

		this.tree = new DialogTree();
		this.tree.npcHeader = "Wow, nice job! You didn't get eaten like we were expecting!";
		this.tree.response1 = "What do you mean \"like we were expecting\"?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "I mean we didn't expect a rookie like you to be able to do it, but you proved us wrong.";
		this.tree.response1DT.response1 = "Well now that that's done, what's my first assignment sir?";
		this.tree.response1DT.response1DT = allresp;
		this.tree.response1DT.response2 = "I'm not your errand boy, I'm a soldier. Now give me something worth my time.";
		this.tree.response1DT.response2DT = allresp;
		this.tree.response1DT.response3 = "Well i've learned a lot in my training so far, sir. So what's next?";
		this.tree.response1DT.response3DT = allresp;
		this.tree.response2 = "It wasn't even a challenge; I usually hunt Gundarks for fun.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Oh, is that so? Well I'll make sure I come to you for all my big-game hunting needs.";
		this.tree.response2DT.response1 = "I'm not THAT good sir, I just got lucky this time. Could I have a real assignment though?";
		this.tree.response2DT.response1DT = allresp;
		this.tree.response2DT.response2 = "Just gimme a real assignment already.";
		this.tree.response2DT.response2DT = allresp;
		this.tree.response2DT.response3 = "I'd be happy to help out sir. For now though I'd like a real assignment.";
		this.tree.response2DT.response3DT = allresp;
		this.tree.response3 = "Well I'm glad I didn't live up to your expectations, sir.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "As am I, it seems like we've got a real soldier on our hands.";
		this.tree.response3DT.response1 = "I'm still new to all of this soldiering but thank you for the kind words sir. How about a real assignment?";
		this.tree.response3DT.response1DT = allresp;
		this.tree.response3DT.response2 = "The realest soldier in the Outer Rim that's for sure. Now give me something that's actually worth my time.";
		this.tree.response3DT.response2DT = allresp;
		this.tree.response3DT.response3 = "Glad to help the Rebel Alliance sir, what can I do next?";
		this.tree.response3DT.response3DT = allresp;
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
