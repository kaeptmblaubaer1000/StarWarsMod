package com.parzivail.pswm.quest.jedi;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Jedi1_1 extends Quest
{
	Jedi1_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Hmm, weary you look traveler, eat Gimer Seeds you must to regain lost strength.";
		this.tree.response1 = "What is this place?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "My home this is, the swamp planet Dagobah. Came here many moons ago.";
		this.tree.response1DT.response1 = "What are you doing here?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Living quietly, yes. Must live in isolation, Empire searches for me they do.";
		this.tree.response1DT.response2 = "Why would you want to live on a swamp planet?";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "My choice you think it. I can assure you, it is not.";
		this.tree.response1DT.response3 = "Why did you come here?";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "Forced to, Jedi have no longer a place in the galaxy.";
		this.tree.response2 = "I don't have time to fool with small unintelligent life.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Size matters not. Look at me. Judge me by my size, do you? Hmm? Hmm. And well you should not. For my ally is the Force, and a powerful ally it is.";
		this.tree.response2DT.response1 = "The Force?";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response2DT.response1DT.npcHeader = "Yes traveler, hear me right, you have.";
		this.tree.response2DT.response2 = "Great another crazy Outer Rim quack.";
		this.tree.response2DT.response2DT = new DialogTree();
		this.tree.response2DT.response2DT.npcHeader = "Mock The Force you must not, for through you it's power also flows.";
		this.tree.response2DT.response3 = "Do you mean The Force? Like the power wielded by the Jedi?";
		this.tree.response2DT.response3DT = new DialogTree();
		this.tree.response2DT.response3DT.npcHeader = "Hmm, heard of The Jedi you have? Few left there are who know of their power.";
		this.tree.response3 = "Are you who I think you are?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "I think not, remnant I am, of tyranny of Galactic Empire.";
		this.tree.response3DT.response1 = "What do you mean remnant?";
		this.tree.response3DT.response1DT = new DialogTree();
		this.tree.response3DT.response1DT.npcHeader = "Displaced I am, condemned by the Empire I have been.";
		this.tree.response3DT.response2 = "Perhaps for good reason.";
		this.tree.response3DT.response2DT = new DialogTree();
		this.tree.response3DT.response2DT.npcHeader = "No good reason does The Empire have, much fear and anger do they possess.";
		this.tree.response3DT.response3 = "Are you from before the time of The Empire?";
		this.tree.response3DT.response3DT = new DialogTree();
		this.tree.response3DT.response3DT.npcHeader = "Hmm, from long ago I am, watched the rise of the Empire I did.";
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
