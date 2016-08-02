package com.parzivail.pswm.quest.imperial;

import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.StarWarsItems.hyperdriveEndor;
import static com.parzivail.pswm.StarWarsMod.network;
import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class ImperialRecruit extends Quest
{
	public ImperialRecruit()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "The empire is looking for soldiers to help restore peace and balance to The Galaxy.  If you believe you have what it takes, take this hyperdrive and go to the Forest Moon of Endor. There you will find our headquarters and will train to become a Stormtrooper.";
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
		network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(hyperdriveEndor, 1), true));
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
		return "The Empire Wants YOU!";
	}

	@Override
	public String getQuestgiverName()
	{
		return "Recruiter";
	}
}
