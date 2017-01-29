package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tile.TileEntityBactaTank;
import com.parzivail.util.basic.PBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/29/2017.
 */
public class BlockBactaTank extends PBlock implements ITileEntityProvider
{
	public BlockBactaTank()
	{
		super("bactatank", Material.IRON);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityBactaTank();
	}
}
