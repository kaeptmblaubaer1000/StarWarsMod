package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Colby
 */
public class BlockNpcRebelDreis extends BlockNpcBase
{
	public BlockNpcRebelDreis()
	{
		super("rebelMainDreis", Resources.armors[0], Resources.allegianceRebelFmt);
	}

	@Override
	public Quest getQuestForPlayer(EntityPlayer player)
	{
		if (ItemQuestContainer.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.rebel8_Yavin.canBeGivenQuest(player))
			return QuestBank.rebel8_Yavin;
		if (QuestBank.rebel9.canBeGivenQuest(player))
			return QuestBank.rebel9;
		if (QuestBank.rebel10.canBeGivenQuest(player))
			return QuestBank.rebel10;
		if (QuestBank.rebel10_Over.canBeGivenQuest(player))
			return QuestBank.rebel10_Over;
		return QuestBank.questNotAvailable;
	}
}
