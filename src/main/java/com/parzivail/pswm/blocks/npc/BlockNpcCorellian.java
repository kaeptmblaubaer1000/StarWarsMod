package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Colby
 */
public class BlockNpcCorellian extends BlockNpcBase
{
	public BlockNpcCorellian()
	{
		super("npcCorellian", null, Resources.allegianceCorellianFmt);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if (world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_CORELLIAN, world, x, y, z);
		return true;
	}
}
