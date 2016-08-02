package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.network.MessageSetQuestLogNbt;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.tileentities.TileEntitySensorAtst;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;

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
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLog;

		if (QuestBank.rebel6_PostEndor.canBeGivenQuest(player))
			return QuestBank.rebel6_PostEndor;

		if (!ItemQuestLog.getHasBroughtAtst(ItemQuestLog.getQuestContainer(player)))
		{
			TileEntity t;
			if ((t = questGiver.getWorldObj().getTileEntity(questGiver.xCoord, questGiver.yCoord - 1, questGiver.zCoord)) instanceof TileEntitySensorAtst)
			{
				if (!((TileEntitySensorAtst)t).checkCondition())
					return QuestBank.questNotAvailable;
				else
				{
					ItemQuestLog.setHasBroughtAtst(ItemQuestLog.getQuestContainer(player), true);
					StarWarsMod.network.sendToServer(new MessageSetQuestLogNbt(player, ItemQuestLog.getQuestContainer(player).stackTagCompound));
				}
			}
			else
				return QuestBank.questNotAvailable;
		}

		if (QuestBank.rebel7.canBeGivenQuest(player))
			return QuestBank.rebel7;
		if (QuestBank.rebel8.canBeGivenQuest(player))
			return QuestBank.rebel8;
		if (QuestBank.rebel8_PostArmor.canBeGivenQuest(player))
			return QuestBank.rebel8_PostArmor;
		return QuestBank.questNotAvailable;
	}
}
