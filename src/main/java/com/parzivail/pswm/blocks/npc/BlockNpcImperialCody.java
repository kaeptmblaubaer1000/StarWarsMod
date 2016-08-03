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
public class BlockNpcImperialCody extends BlockNpcBase
{
	public BlockNpcImperialCody()
	{
		super("imperialMainCody", Resources.armors[3], Resources.allegianceImperialFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.imperial0.canBeGivenQuest(player))
			return QuestBank.imperial0;
		else if (QuestBank.imperial1.canBeGivenQuest(player))
			return QuestBank.imperial1;
		else if (QuestBank.imperial2.canBeGivenQuest(player))
			return QuestBank.imperial2;
		else if (QuestBank.imperial3_1.canBeGivenQuest(player))
			return QuestBank.imperial3_1;
		else if (QuestBank.imperial3_2.canBeGivenQuest(player))
			return QuestBank.imperial3_2;
		else if (QuestBank.imperial4_1.canBeGivenQuest(player))
			return QuestBank.imperial4_1;
		else
			return QuestBank.questNotAvailable;
	}
}
