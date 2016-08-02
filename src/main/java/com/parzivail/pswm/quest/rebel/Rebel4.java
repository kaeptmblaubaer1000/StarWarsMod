package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel4 extends Quest
{
	public Rebel4()
	{
		DialogTree allresp = new DialogTree();
		allresp.npcHeader = "First things first rookie, you need to show us what you're made of. It's tradition that all the new recruits have to defeat a Wampa and bring back a horn.";
		allresp.response1 = "Aren't Wampas dangerous, sir?! How am I supposed to beat one on my own?";
		allresp.response1DT = new DialogTree();
		allresp.response1DT.npcHeader = "Of course they're dangerous, that's the whole point. I'm sure you'll figure something out. You already have an A-280, and that's all you really need. Bring it back to me once you have it and you'll get your first real assignment.";
		allresp.response2 = "How about I bring back 2?";
		allresp.response2DT = new DialogTree();
		allresp.response2DT.npcHeader = "Doesn't matter to me, bring back a whole pile of them, but I only need 1. Now get out there, soldier!";
		allresp.response3 = "If it's what I have to do to prove myself to The Rebel Alliance, you can count on me sir.";
		allresp.response3DT = new DialogTree();
		allresp.response3DT.npcHeader = "Good to hear, soldier, we'll be waiting for you.";

		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to the temperate beach planet Hoth. You can enjoy the pool, take a nice relaxing soak in a Bacta tank, and try your hardest not to get eaten by Wampas like the rest of us.";
		this.tree.response1 = "You do know this is an ice planet right sir?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Frankly I don't know how I could miss it, recruit";
		this.tree.response1DT.response1 = "Sorry to ask sir, but what's my first assignment?";
		this.tree.response1DT.response1DT = allresp;
		this.tree.response1DT.response2 = "Well with those old eyes of yours I'm surprised you can see anything.";
		this.tree.response1DT.response2DT = allresp;
		this.tree.response1DT.response3 = "Just asking sir. So what's my first assignment?";
		this.tree.response1DT.response3DT = allresp;
		this.tree.response2 = "Finally, a superior officer with a sense of humor.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Well, the Alliance found it funny to station me here, so why not have some fun with it?";
		this.tree.response2DT.response1 = "I guess that's one way to deal with the cold sir. Could I get my first assignment though?";
		this.tree.response2DT.response1DT = allresp;
		this.tree.response2DT.response2 = "I'd probably do the same, so why did they send me here anyway?";
		this.tree.response2DT.response2DT = allresp;
		this.tree.response2DT.response3 = "I'm sure the troops love you here sir. So what's my first assignment?";
		this.tree.response2DT.response3DT = allresp;
		this.tree.response3 = "I see you're trying to make the best of the situation sir.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "That's what we have to do here on Hoth. It's a grueling station, but you'll learn a lot here recruit.";
		this.tree.response3DT.response1 = "Hopefully about how to shoot properly sir, I don't think i'd be much use in a firefight.";
		this.tree.response3DT.response1DT = allresp;
		this.tree.response3DT.response2 = "Grueling or not i'm here for experience so what's my first assignment?";
		this.tree.response3DT.response2DT = allresp;
		this.tree.response3DT.response3 = "I'm ready for the challenge, sir. What's my first assignment?";
		this.tree.response3DT.response3DT = allresp;
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
	public String getQuestgiverName()
	{
		return "Carlist";
	}

	@Override
	public String getID()
	{
		return "Shhh, I’m hunting Wampa";
	}
}
