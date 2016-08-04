package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Colby
 */
public class BlockNpcRecruiterRebel extends BlockNpcBase
{
	public BlockNpcRecruiterRebel()
	{
		super("rebelRecruiter", null, Resources.allegianceRebelFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		//if (ItemQuestLog.getSide(player).equals(Resources.allegianceImperialFmt))
		//	return QuestBank.dontAcceptYou;

		if (QuestBank.rebelRecruit.canBeGivenQuest(player))
			return QuestBank.rebelRecruit;

		return QuestBank.questNotAvailable;
	}
}
