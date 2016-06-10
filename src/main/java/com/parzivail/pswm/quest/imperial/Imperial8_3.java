package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial8_3 extends Quest
{
	public Imperial8_3()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Now that you have your armor it's time to give you a quick briefing on our ships and how to fly them.";
		this.tree.response1 = "Next";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "There are 4 ships available for you to use in the Imperial Navy: The TIE/LN, the TIE Interceptor, the TIE Bomber, and the TIE Advanced X1. All ships have the same controls and cockpits so as to make the flying experience easier on the pilot.";
		this.tree.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "All have the same max speed and maneuverability except for the Interceptor which is slightly faster than the rest. All are equipped with lasers, but the Bomber is also equipped with bombs, obviously.";
		this.tree.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.npcHeader = "They are easy to fly, but landing is a bit different than you'd expect. You must come in almost parallel to the ground, much like the large civilian transports, and not brake until you are basically on the ground.";
		this.tree.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.npcHeader = "If you'd like to hone your skills outside of combat, the Quartermaster has a Hyperdrive which will take you to neutral empty space.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1 = "Next";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "This concludes the briefing Trooper, welcome to the Imperial Navy, I'd suggest taking out a ship and getting a feel for it. You can return to me when you're ready for your first mission.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Daala";
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
		return "The Imperial Navy";
	}
}
