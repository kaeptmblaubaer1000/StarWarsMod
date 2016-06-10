package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial2 extends Quest
{
	Imperial2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Well it looks like you aren't completely incompetent Trooper, so I've got a mission for you. We've been having problems with some of the Shield Generator Bases.";
		this.tree.response1 = "Thank you Sir! What is my mission?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "We need you to find any Shield Generator Bases around this main base and hook their antennas back up. We need to be able to communicate with our fleet in space and without those antennas we simply can't. We need at least four of those antennas back up. Take a Hydrospanner in order to repair them, and a 74-Z Speeder Bike if you wish, the Quartermaster will give you all your equipment.";
		this.tree.response1DT.response1 = "You can count on me Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "Anything to get out of here and put my skills to use.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "You're in luck then Trooper. We need you to find any Shield Generator Bases around this main base and hook their antennas back up. We need to be able to communicate with our fleet in space and without those antennas we simply can't. We need at least four of those antennas back up. Take a Hydrospanner in order to repair them, and a 74-Z Speeder Bike if you wish, the Quartermaster will give you all your equipment.";
		this.tree.response2DT.response1 = "It'll be my pleasure Sergeant.";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "What is the mission Sergeant?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "We need you to find any Shield Generator Bases around this main base and hook their antennas back up. We need to be able to communicate with our fleet in space and without those antennas we simply can't. We need at least four of those antennas back up. Take a Hydrospanner in order to repair them, and a 74-Z Speeder Bike if you wish, the Quartermaster will give you all your equipment.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
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
		return "Maintenance Duty";
	}
}
