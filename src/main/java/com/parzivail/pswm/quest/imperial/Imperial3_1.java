package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Colby on 5/8/2016.
 */
public class Imperial3_1 extends Quest
{
	public Imperial3_1()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Your performance on your last mission was above satisfactory so we're moving you over to the Scout Trooper detachment. Go see the Quartermaster for your armor and your pistol then report back to me.";
		this.tree.response1 = "Yes Sir, thank you Sir!";
		this.tree.response1DT = new DialogTree();
	}

	@Override
	public String getQuestgiverName()
	{
		return "Cody";
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
		return "Recon Mission";
	}
}
