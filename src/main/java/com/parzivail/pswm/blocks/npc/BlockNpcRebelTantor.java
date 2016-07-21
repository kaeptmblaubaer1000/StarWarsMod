package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestContainer;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author Colby
 */
public class BlockNpcRebelTantor extends BlockNpcBase
{
	public BlockNpcRebelTantor()
	{
		super("rebelMainTantor", Resources.armors[2], Resources.allegianceRebelFmt);
	}

	@Override
	public Quest getQuestForPlayer(EntityPlayer player)
	{
		if (ItemQuestContainer.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.rebel6_PostEndor.canBeGivenQuest(player))
			return QuestBank.rebel6_PostEndor;
		if (QuestBank.rebel7.canBeGivenQuest(player))
			return QuestBank.rebel7;
		if (QuestBank.rebel8.canBeGivenQuest(player))
			return QuestBank.rebel8;
		if (QuestBank.rebel8_PostArmor.canBeGivenQuest(player))
			return QuestBank.rebel8_PostArmor;
		return QuestBank.questNotAvailable;
	}
}
