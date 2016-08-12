package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.StarWarsItems.silverImperialCredit;
import static com.parzivail.pswm.StarWarsItems.wampaHorn;
import static com.parzivail.pswm.StarWarsMod.network;
import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.rebel4;
import static com.parzivail.util.world.ItemUtils.hasItems;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel5 extends Quest
{
	public Rebel5()
	{
		DialogTree allresp = new DialogTree();
		allresp.npcHeader = "Your first real assignment is to take out some of the Imperial Probe Droids that are constantly patrolling the planet.  Since you’ve done so well, feel free to take a T-47 Snowspeeder.  It’ll be faster, and its blasters will hit those Probe Droids hard.  Stop by the Quartermaster for some Rebel Pilot Armor too.  I want at least 5 of those droids.";
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
		return !isQuestDone(player, this) && rebel4.isQuestComplete(player) && hasItems(player, new ItemStack(wampaHorn, 1));
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
		player.playSound(Resources.MODID + ":" + "quest.complete", 1, 1);
		network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(silverImperialCredit, 5), true));
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
		return "It’s no Beggar’s Canyon";
	}
}
