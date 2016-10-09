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
public class BlockNpcRecruiterEmpire extends BlockNpcBase
{
	public BlockNpcRecruiterEmpire()
	{
		super("empireRecruiter", null, Resources.allegianceImperialFmt);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		//if (ItemQuestLog.getSide(entity).equals(Resources.allegianceRebelFmt))
		//	return QuestBank.dontAcceptYou;

		if (QuestBank.empireRecruit.canBeGivenQuest(player))
			return QuestBank.empireRecruit;
		return QuestBank.questNotAvailable;
	}
}
