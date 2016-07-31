package com.parzivail.pswm.blocks.npc;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityStaticNpcJawa;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @author Colby
 */
public class BlockNpcJawaQuartermaster extends BlockNpcBase
{
	public BlockNpcJawaQuartermaster()
	{
		super("jawaQuartermaster", null, Resources.allegianceJawaFmt);
		setBlockBounds(0, 0, 0, 1, 1.5f, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		TileEntityStaticNpcJawa te = new TileEntityStaticNpcJawa();
		te.setId(this.id);
		te.setAff(this.aff);
		return te;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		setBlockBounds(0, 0, 0, 1, 1.5f, 1);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float subX, float subY, float subZ)
	{
		if (world.isRemote)
			player.openGui(StarWarsMod.instance, Resources.GUI_JAWA, world, x, y, z);
		return true;
	}
}
