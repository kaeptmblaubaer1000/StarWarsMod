package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Colby
 */
public class BlockNpcRebelRex extends BlockNpcBase
{
	public BlockNpcRebelRex()
	{
		super("rebelMainRex", Resources.armors[0]);
	}

	@Override
	public Quest getQuestForPlayer(EntityPlayer player)
	{
		if (QuestBank.rebel0.canBeGivenQuest(player))
			return QuestBank.rebel0;
		if (QuestBank.rebel1.canBeGivenQuest(player))
			return QuestBank.rebel1;
		if (QuestBank.rebel2.canBeGivenQuest(player))
			return QuestBank.rebel2;
		if (QuestBank.rebel3.canBeGivenQuest(player))
			return QuestBank.rebel3;
		return QuestBank.questNotAvailable;
	}
}
