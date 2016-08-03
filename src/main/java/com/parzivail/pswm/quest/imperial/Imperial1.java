package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.armor.ArmorStormtrooper;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestUtils;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.imperial0;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial1 extends Quest
{
	public Imperial1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to the 501st, Trooper. It is our duty to destroy The Rebel Alliance. I see that you already have your armor, but how's your aim with a blaster?";
		this.tree.response1 = "As good as it gets sir.";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "It better be or you won't be a Stormtrooper for long. Go get a rifle from the Quartermaster and hit the target range. Blast at least 10 targets so I know you really are good enough for my army.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "Good enough to blast any Rebel scum that get in my way.";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "We aren't just here to shoot Rebels, Trooper. First things first, grab a rifle from the Quartermaster and hit the target range. Blast at least 10 targets to prove you deserve to be here.";
		this.tree.response2DT.response1 = "Sir Yes Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "Best in my class from Carida Academy.";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Is that so? Then go see the Quartermaster for a rifle and hit the target range. Blast at least 10 targets, and I expect to be \"wowed\" according to your previous achievement.";
		this.tree.response3DT.response1 = "Sir Yes Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && imperial0.isQuestComplete(player) && QuestUtils.hasOnArmor(player, ArmorStormtrooper.class);
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
		return "The 501st";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Cody";
	}
}
