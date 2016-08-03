package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestStats;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.imperial9;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial10_1 extends Quest
{
	public Imperial10_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Nice work destroying those bases Trooper, it looks like you'll fit in just fine in the Imperial Navy. You can now take out any ships you'd like at any time. Be careful though, if we find out you keep crashing ships when you take them out, you'll start to have limited flight privileges.";
		this.tree.response1 = "Thank you Sir!";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "Quit thanking me and listen, we've got a new mission for you. The Rebels have been outgunning us in firefights with their T65 X-Wings, we need to get an up close and personal look at one of them so we can better prepare our fleet. We need you to find and infiltrate their secret temple base on Yavin 4 and steal the plans for a T65 X-Wing and bring them back here so the Research and Development team can have a good look at them.";
		this.tree.response1DT.response1 = "You can count on me Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "Joyrides? Sounds like my kind of thing Sir.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "Watch yourself Trooper, remember if we start to notice you're constantly crashing ships, we'll restrict your ship access. Now for your mission. The Rebels have been outgunning us in firefights with their T65 X-Wings, we need to get an up close and personal look at one of them so we can better prepare our fleet. We need you to find and infiltrate their secret temple base on Yavin 4 and steal the plans for a T65 X-Wing and bring them back here so the Research and Development team can have a good look at them.";
		this.tree.response2DT.response1 = "I'll show you why I'm in the Navy Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "I'll be sure to be careful Sir!";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "That'd be in your best interests Trooper. Now onto your mission. The Rebels have been outgunning us in firefights with their T65 X-Wings, we need to get an up close and personal look at one of them so we can better prepare our fleet. We need you to find and infiltrate their secret temple base on Yavin 4 and steal the plans for a T65 X-Wing and bring them back here so the Research and Development team can have a good look at them.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
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
		return !isQuestDone(player, this) && imperial9.isQuestComplete(player) && ItemQuestLog.getStat(player, QuestStats.BOMBS_DROPPED_EMPIRE) >= 20;
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
		return "A Real Mission";
	}
}
