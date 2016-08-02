package com.parzivail.pswm.quest.rebel;

import com.parzivail.pswm.StarWarsItems;
import com.parzivail.pswm.quest.DialogTree;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.util.world.ItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import static com.parzivail.pswm.items.ItemQuestLog.isQuestDone;
import static com.parzivail.pswm.items.ItemQuestLog.setQuestDone;
import static com.parzivail.pswm.quest.QuestBank.rebel1;

/**
 * Created by Colby on 5/8/2016.
 */
public class Rebel2 extends Quest
{
	public Rebel2()
	{
		this.tree = new DialogTree();
		this.tree.npcHeader = "Now that you've got your A-280, head on over to the range and blast some targets. Make sure to blast at least 10 targets so I can see what kind of shot you are.";
	}

	@Override
	public boolean canBeGivenQuest(EntityPlayer player)
	{
		return !isQuestDone(player, this) && rebel1.isQuestComplete(player) && ItemUtils.hasItems(player, new ItemStack(StarWarsItems.blasterRifle, 1, 0));
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
	public String getQuestgiverName()
	{
		return "Rex";
	}

	@Override
	public String getID()
	{
		return "Target Practice";
	}
}
