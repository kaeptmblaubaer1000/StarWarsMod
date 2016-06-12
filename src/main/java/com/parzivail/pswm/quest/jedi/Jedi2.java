package com.parzivail.pswm.quest.jedi;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Jedi2 extends Quest
{
	public Jedi2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Time it is, to make your Lightsaber.";
		this.tree.response1 = "Lightsaber?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Hmm, yes. A powerful weapon it is, but even stronger in The Force you now are. Ilum Hyperdrive you will take, there you will find an Ancient Jedi Temple. All tools you need for your weapon there are. In the caves, find Kyber Crystals you will. Instructions to build your lightsaber, found in Holocron they are. Your choice it is what your Lightsaber looks like, fit you it will. After it is built, back to me you will come, show me your weapon you must.";
		this.tree.response1DT.response1 = "Thank you Master, I'll return as soon as it's built!";
		this.tree.response1DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Yoda";
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
		return tree;
	}

	@Override
	public String getID()
	{
		return "The Lightsaber";
	}
}