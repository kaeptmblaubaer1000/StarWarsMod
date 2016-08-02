package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial7 extends Quest
{
	public Imperial7()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Taking those bases offline is going to give us a huge advantage over the Rebels, nice work Trooper. Now I need you to run a bit of maintenance on Viper Probe Droids out in the field.";
		this.tree.response1 = "Viper Probe Droids Sir?";
		this.tree.response1DT = new DialogTree();
		this.tree.response1DT.npcHeader = "They're scouting droids that scour the planet for Rebel holdouts. Take this datapad, and bring me back the data from at least three of them. Take a 74-Z if you must.";
		this.tree.response1DT.response1 = "Sir Yes Sir!";
		this.tree.response1DT.response1DT = new DialogTree();
		this.tree.response2 = "No AT-ST this time?";
		this.tree.response2DT = new DialogTree();
		this.tree.response2DT.npcHeader = "You can if you wish Troper but there is no need. Take this datapad and bring me back the data from at least 3 of our droids.";
		this.tree.response2DT.response1 = "Of course Sir!";
		this.tree.response2DT.response1DT = new DialogTree();
		this.tree.response3 = "Anything for the Empire Sir!";
		this.tree.response3DT = new DialogTree();
		this.tree.response3DT.npcHeader = "Excellent, Trooper. Take this datapad and collect the data from at least 3 of our droids in the field. Take a 74-Z if you so choose.";
		this.tree.response3DT.response1 = "You can count on me Sir!";
		this.tree.response3DT.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Veers";
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
		return true;
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
		return "Routine Maintenance";
	}
}
