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
public class BlockNpcImperialFurgan extends BlockNpcBase
{
	public BlockNpcImperialFurgan()
	{
		super("imperialMainFurgan", Resources.armors[4], Resources.allegianceImperialFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.imperial4_2.canBeGivenQuest(player))
			return QuestBank.imperial4_2;
		else if (QuestBank.imperial4_3.canBeGivenQuest(player))
			return QuestBank.imperial4_3;
		else if (QuestBank.imperial5.canBeGivenQuest(player))
			return QuestBank.imperial5;
		else if (QuestBank.imperial6_1.canBeGivenQuest(player))
			return QuestBank.imperial6_1;
		else
			return QuestBank.questNotAvailable;
	}
}
