package com.parzivail.pswm.blocks.hoth;

import com.parzivail.pswm.tile.hoth.TileEntityHothCrate2;
import com.parzivail.util.basic.PBlockTE;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/29/2017.
 */
public class BlockHothCrate2 extends PBlockTE
{
	public BlockHothCrate2()
	{
		super("hothcrate2", Material.IRON);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityHothCrate2();
	}
}
