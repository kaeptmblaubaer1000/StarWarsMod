package com.parzivail.pswm.quest.jedi;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.MessageSetPlayerHolding;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;

/**
 * Created by Colby on 5/8/2016.
 */
public class JediObiWan extends Quest
{
	public JediObiWan()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "I've been waiting a long time for you.  You must go to the Dagobah system.  There is someone there who will help you fulfill your destiny.  You must make haste, the Empire has spies everywhere.";
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
		StarWarsMod.network.sendToServer(new MessageSetPlayerHolding(player, new ItemStack(StarWarsItems.hyperdriveDagobah, 1), true));
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
		return "Fulfill Your Destiny";
	}

	@Override
	public String getQuestgiverName()
	{
		return "";
	}
}
