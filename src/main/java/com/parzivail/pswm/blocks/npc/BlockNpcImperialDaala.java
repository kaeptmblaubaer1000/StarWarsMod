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
public class BlockNpcImperialDaala extends BlockNpcBase
{
	public BlockNpcImperialDaala()
	{
		super("imperialMainVeers", Resources.armors[7], Resources.allegianceImperialFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.imperial8_2.canBeGivenQuest(player))
			return QuestBank.imperial8_2;
		else if (QuestBank.imperial8_3.canBeGivenQuest(player))
			return QuestBank.imperial8_3;
		else if (QuestBank.imperial9.canBeGivenQuest(player))
			return QuestBank.imperial9;
		else if (QuestBank.imperial10_1.canBeGivenQuest(player))
			return QuestBank.imperial10_1;
		else if (QuestBank.imperial10_2.canBeGivenQuest(player))
			return QuestBank.imperial10_2;
		else
			return QuestBank.questNotAvailable;
	}
}
