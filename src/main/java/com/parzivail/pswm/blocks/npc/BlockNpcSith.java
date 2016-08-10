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
public class BlockNpcSith extends BlockNpcBase
{
	public BlockNpcSith()
	{
		super("sith", null, Resources.allegianceSithFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.sith1.canBeGivenQuest(player))
			return QuestBank.sith1;
		else if (QuestBank.sith2.canBeGivenQuest(player))
			return QuestBank.sith2;
		else if (QuestBank.sith3.canBeGivenQuest(player))
			return QuestBank.sith3;
		else if (QuestBank.sith3_PostSaber.canBeGivenQuest(player))
			return QuestBank.sith3_PostSaber;

		return QuestBank.questNotAvailable;
	}
}
