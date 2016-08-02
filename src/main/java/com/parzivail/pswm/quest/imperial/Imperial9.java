package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial9 extends Quest
{
	public Imperial9()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "I assume you're ready for your first mission in the Imperial Navy, Trooper?";
		this.tree.response1 = "Of course Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "You better be Trooper, this is an elite unit. Your mission is to destroy any Rebel outposts in the surrounding area. It'll be a solo mission and you'll be taking a TIE Bomber. Once you've destroyed the bases and we deem your performance becoming of an Imperial Pilot, we'll give you access to the rest of the ships in the fleet. Am I understood Trooper?";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "I'm always ready to take the fight to the Rebels.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "If you weren't I don't know how you'd have made it this far Trooper. Your mission is to destroy any Rebel outposts in the surrounding area. It'll be a solo mission and you'll be taking a TIE Bomber. Once you've destroyed the bases and we deem your performance becoming of an Imperial Pilot, we'll give you access to the rest of the ships in the fleet. Now get in the skies Trooper.";
		this.tree.response2DT.response1 = "This'll be fun.";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "Yes Sir! What's the mission?";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Your mission is to destroy any Rebel outposts in the surrounding area. It'll be a solo mission and you'll be taking a TIE Bomber. Once you've destroyed the bases and we deem your performance becoming of an Imperial Pilot, we'll give you access to the rest of the ships in the fleet. Be sure not to crash or get shot down Trooper.";
		this.tree.response3DT.response1 = "You can count on me Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Daala";
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
		return isQuestDone(player, this);
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
	public String getID()
	{
		return "Bombing Run";
	}
}
