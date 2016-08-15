package com.parzivail.pswm.quest.jedi;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.jediObiWan;

/**
 * Created by Colby on 5/8/2016.
 */
public class Jedi1 extends Quest
{
	private DialogTree all;

	public Jedi1()
	{
		this.all = new DialogTree();
		this.all.npcHeader = "";
		this.all.response1 = "Who are you then, really?";
		this.all.response1DT = new DialogTree();
		this.all.response1DT.npcHeader = "My name matters not, Jedi Master I am, leader of the Jedi Order I was... Sense something I do, The Force is strong in you.";
		this.all.response1DT.response1 = "I'm Force-Sensitive??";
		this.all.response1DT.response1DT = new DialogTree();
		this.all.response1DT.response1DT.npcHeader = "Strong in you The Force is, one of the last in the galaxy you are, all others killed by Empire. Be trained in The Force you must.";
		this.all.response1DT.response1DT.response1 = "How do I train? What do I have to do?";
		this.all.response1DT.response1DT.response1DT = new DialogTree();
		this.all.response1DT.response1DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";
		this.all.response1DT.response2 = "Sorry, I don't believe in magic, I live by my blaster.";
		this.all.response1DT.response2DT = new DialogTree();
		this.all.response1DT.response2DT.npcHeader = "Hmm, do not you think The Force helps you use your blaster? Be trained in it's ways you must.";
		this.all.response1DT.response2DT.response1 = "How do I train? What do I have to do?";
		this.all.response1DT.response2DT.response1DT = new DialogTree();
		this.all.response1DT.response2DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";
		this.all.response1DT.response3 = "What does that mean?";
		this.all.response1DT.response3DT = new DialogTree();
		this.all.response1DT.response3DT.npcHeader = "Means be trained in The Force you must, one of last Force-Sensitive in the galaxy, you are.";
		this.all.response1DT.response3DT.response1 = "How do I train? What do I have to do?";
		this.all.response1DT.response3DT.response1DT = new DialogTree();
		this.all.response1DT.response3DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";

		this.tree = new DialogTree();
		this.tree.npcHeader = "Hmm, weary you look traveler, eat Gimer Seeds you must to regain lost strength.";
		this.tree.response1 = "What is this place?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "My home this is, the swamp planet Dagobah. Came here many moons ago.";
		this.tree.response1DT.response1 = "What are you doing here?";
		this.tree.response1DT.response1DT = all;
		this.tree.response1DT.response1DT.npcHeader = "Living quietly, yes. Must live in isolation, Empire searches for me they do.";
		this.tree.response1DT.response2 = "Why would you want to live on a swamp planet?";
		this.tree.response1DT.response2DT = all;
		this.tree.response1DT.response2DT.npcHeader = "My choice you think it. I can assure you, it is not.";
		this.tree.response1DT.response3 = "Why did you come here?";
		this.tree.response1DT.response3DT = all;
		this.tree.response1DT.response3DT.npcHeader = "Forced to, Jedi have no longer a place in the galaxy.";
		this.tree.response2 = "I don't have time to fool with small unintelligent life.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Size matters not. Look at me. Judge me by my size, do you? Hmm? Hmm. And well you should not. For my ally is the Force, and a powerful ally it is.";
		this.tree.response2DT.response1 = "The Force?";
		this.tree.response2DT.response1DT = all;
		this.tree.response2DT.response1DT.npcHeader = "Yes traveler, hear me right, you have.";
		this.tree.response2DT.response2 = "Great another crazy Outer Rim quack.";
		this.tree.response2DT.response2DT = all;
		this.tree.response2DT.response2DT.npcHeader = "Mock The Force you must not, for through you it's power also flows.";
		this.tree.response2DT.response3 = "Do you mean The Force? Like the power wielded by the Jedi?";
		this.tree.response2DT.response3DT = all;
		this.tree.response2DT.response3DT.npcHeader = "Hmm, heard of The Jedi you have? Few left there are who know of their power.";
		this.tree.response3 = "Are you who I think you are?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "I think not, remnant I am, of tyranny of Galactic Empire.";
		this.tree.response3DT.response1 = "What do you mean remnant?";
		this.tree.response3DT.response1DT = all;
		this.tree.response3DT.response1DT.npcHeader = "Displaced I am, condemned by the Empire I have been.";
		this.tree.response3DT.response2 = "Perhaps for good reason.";
		this.tree.response3DT.response2DT = all;
		this.tree.response3DT.response2DT.npcHeader = "No good reason does The Empire have, much fear and anger do they possess.";
		this.tree.response3DT.response3 = "Are you from before the time of The Empire?";
		this.tree.response3DT.response3DT = all;
		this.tree.response3DT.response3DT.npcHeader = "Hmm, from long ago I am, watched the rise of the Empire I did.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		//Lumberjack.log(ItemQuestLog.getDimTravel(ItemQuestLog.getQuestContainer(player), Resources.ConfigOptions.dimDagobahId));
		return !isQuestDone(player, this) && jediObiWan.isQuestComplete(player) && ItemQuestLog.getDimTravel(ItemQuestLog.getQuestContainer(player), Resources.ConfigOptions.dimDagobahId) > 0;
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.holocron, 1), true));
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
		return "The Jedi Order";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Yoda";
	}
}
