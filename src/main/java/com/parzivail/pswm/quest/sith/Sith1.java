package com.parzivail.pswm.quest.sith;

import com.parzivail.pswm.force.Cron;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.jedi3;
import static com.parzivail.util.ui.TextUtils.makeObfuscated;

/**
 * Created by Colby on 5/8/2016.
 */
public class Sith1 extends Quest
{
	public Sith1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "";
		this.tree.response1 = "Excuse me, I'm looking for someone. I felt a presence here, a dark presence, a powerful presence. I feel as though shadows call my name, whispering to me through The Force. Are you the one who has come to me in my dreams?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "If I am, what of it?";
		this.tree.response1DT.response1 = "I need to understand this darkness, I feel it's power, welling up inside me, slowly consuming my mind. Can you help me?";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.npcHeader = "This darkness of which you speak is known to those who can comprehend it as The Dark Side of the Force. If it is knowledge of The Dark Side that you seek, you must first prove yourself worthy.";
		this.tree.response1DT.response1DT.response1 = "What do I have to do?";
		this.tree.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.npcHeader = "Judging by the Lightsaber and the Jedi Artifact in your possession, you have ventured to the planet Ilum and entered it's Crystal Caves.";
		this.tree.response1DT.response1DT.response1DT.response1 = "Yes I have, but what does this have to do with me proving my worth?";
		this.tree.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.npcHeader = "Hold your tongue and listen. Deep in the heart of that temple, there lies a secret chamber. In it you will find a Sith Artifact. That Artifact holds secrets of The Dark Side of the Force. Return to Ilum and retrieve the Artifact. Once you have done so, bring it back here, to me.";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1 = "I will find the Sith Artifact. What may I call you?";
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT = new DialogTree();
		this.tree.response1DT.response1DT.response1DT.response1DT.response1DT.npcHeader = "My name will be revealed to you in time. Now go, let The Dark Side guide you to that which you seek.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && jedi3.isQuestComplete(player) && Cron.getSide(player).equals(Cron.SIDE_SITH);
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
		return "Creeping Darkness";
	}

	@Override
	public String getQuestgiverName()
	{
		return makeObfuscated("Zannah");
	}
}
