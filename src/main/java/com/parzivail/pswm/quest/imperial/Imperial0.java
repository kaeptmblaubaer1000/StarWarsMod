package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial0 extends Quest
{
	public Imperial0()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Welcome to the Galactic Empire. We are here to restore order and justice to the galaxy and crush The Rebel Alliance in the process. Find the Quartermaster for your armor and then speak to the Sergeant in charge of new Troopers. He can be found in the main hangar.";
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
		return "Welcome to the Galactic Empire";
	}

	@Override
	public String getQuestgiverName()
	{
		return "";
	}
}
