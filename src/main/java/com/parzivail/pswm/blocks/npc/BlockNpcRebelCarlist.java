package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Colby
 */
public class BlockNpcRebelCarlist extends BlockNpcBase
{
	public BlockNpcRebelCarlist()
	{
		super("rebelMainCarlist", Resources.armors[1], Resources.allegianceRebelFmt);
	}

	@Override
	public Quest getQuestForPlayer(EntityPlayer player)
	{
		if (ItemQuestContainer.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.rebel4.canBeGivenQuest(player))
			return QuestBank.rebel4;
		if (QuestBank.rebel5.canBeGivenQuest(player))
			return QuestBank.rebel5;
		if (QuestBank.rebel6.canBeGivenQuest(player))
			return QuestBank.rebel6;
		return QuestBank.questNotAvailable;
	}
}
