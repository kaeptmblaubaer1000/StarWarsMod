package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.items.ItemQuestLog;
import com.parzivail.pswm.quest.Quest;
import com.parzivail.pswm.quest.QuestBank;
import com.parzivail.pswm.tileentities.TileEntityStaticNpc;
import com.parzivail.pswm.tileentities.TileEntityStaticNpcYoda;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Colby
 */
public class BlockNpcJediYoda extends BlockNpcBase
{
	public BlockNpcJediYoda()
	{
		super("yoda", null, Resources.allegianceJediFmt);
		setBlockBounds(0.1f, 0, 0.1f, 0.9f, 1.4f, 0.9f);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(x + 0.1f, y, z + 0.1f, x + 0.9f, y + 1.4f, z + 0.9f);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		setBlockBounds(0.1f, 0, 0.1f, 0.9f, 1.4f, 0.9f);
	}

	@Override
	public Quest getQuestForPlayer(TileEntityStaticNpc questGiver, EntityPlayer player)
	{
		if (ItemQuestLog.getQuestContainer(player) == null)
			return QuestBank.noQuestLogYoda;

		if (QuestBank.jedi1.canBeGivenQuest(player))
			return QuestBank.jedi1;
		else if (QuestBank.jedi2.canBeGivenQuest(player))
			return QuestBank.jedi2;
		else if (QuestBank.jedi3.canBeGivenQuest(player))
			return QuestBank.jedi3;
		else
			return QuestBank.questNotAvailableYoda;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityStaticNpcYoda te = new TileEntityStaticNpcYoda();
		te.setId(this.id);
		te.setAff(this.aff);
		return te;
	}
}
