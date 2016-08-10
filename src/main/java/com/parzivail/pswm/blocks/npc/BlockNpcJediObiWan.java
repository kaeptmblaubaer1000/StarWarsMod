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
public class BlockNpcJediObiWan extends BlockNpcBase
{
	public BlockNpcJediObiWan()
	{
		super("jediObiWan", Resources.armors[12], Resources.allegianceJediFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.jediObiWan.canBeGivenQuest(player))
			return QuestBank.jediObiWan;

		return QuestBank.questNotAvailable;
	}
}
