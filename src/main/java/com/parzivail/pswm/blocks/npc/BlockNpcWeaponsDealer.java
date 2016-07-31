package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * @author Colby
 */
public class BlockNpcWeaponsDealer extends BlockNpcBase
{
	public BlockNpcWeaponsDealer()
	{
		super("npcWeaponsDealer", null, Resources.allegianceWeaponDealerFmt);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if (world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_WEAPONS_DEALER, world, x, y, z);
		return true;
	}
}
