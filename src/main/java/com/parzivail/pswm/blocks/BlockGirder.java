package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tile.TileEntityGirder;
import com.parzivail.util.basic.PBlockTE;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/29/2017.
 */
public class BlockGirder extends PBlockTE
{
	public BlockGirder()
	{
		super("girder", Material.IRON);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityGirder();
	}
}
