package com.parzivail.pswm.quest.jedi;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Jedi1_2 extends Quest
{
	Jedi1_2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "";
		this.tree.response1 = "Who are you then, really?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "My name matters not, Jedi Master I am, leader of the Jedi Order I was... Sense something I do, The Force is strong in you.";
		this.tree.response1DT.response1 = "I'm Force-Sensitive??";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "Strong in you The Force is, one of the last in the galaxy you are, all others killed by Empire. Be trained in The Force you must.";
		this.tree.response1DT.response1DT.response1 = "How do I train? What do I have to do?";
		this.tree.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";
		this.tree.response1DT.response2 = "Sorry, I don't believe in magic, I live by my blaster.";
		this.tree.response1DT.response2DT = new DialogTree();
		this.tree.response1DT.response2DT.npcHeader = "Hmm, do not you think The Force helps you use your blaster? Be trained in it's ways you must.";
		this.tree.response1DT.response2DT.response1 = "How do I train? What do I have to do?";
		this.tree.response1DT.response2DT.response1DT = new DialogTree();
		this.tree.response1DT.response2DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";
		this.tree.response1DT.response3 = "What does that mean?";
		this.tree.response1DT.response3DT = new DialogTree();
		this.tree.response1DT.response3DT.npcHeader = "Means be trained in The Force you must, one of last Force-Sensitive in the galaxy, you are.";
		this.tree.response1DT.response3DT.response1 = "How do I train? What do I have to do?";
		this.tree.response1DT.response3DT.response1DT = new DialogTree();
		this.tree.response1DT.response3DT.response1DT.npcHeader = "Take this Holocron you must. Learn to use your powers more over time, you will. Holocron must stay on you at all times, lose your powers you will, if misplaced. Take also these robes, used by Jedi long ago, they were. Return here once you can use The Force to Grab your enemies, show you I will, how to create the weapon of a Jedi.";
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
		return "The Jedi Order";
	}
}
