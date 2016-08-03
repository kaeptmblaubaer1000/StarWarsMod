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
public class BlockNpcImperialVeers extends BlockNpcBase
{
	public BlockNpcImperialVeers()
	{
		super("imperialMainVeers", Resources.armors[5], Resources.allegianceImperialFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.imperial6_2.canBeGivenQuest(player))
			return QuestBank.imperial6_2;
		else if (QuestBank.imperial6_3.canBeGivenQuest(player))
			return QuestBank.imperial6_3;
		else if (QuestBank.imperial7.canBeGivenQuest(player))
			return QuestBank.imperial7;
		else if (QuestBank.imperial8_1.canBeGivenQuest(player))
			return QuestBank.imperial8_1;
		else
			return QuestBank.questNotAvailable;
	}
}
