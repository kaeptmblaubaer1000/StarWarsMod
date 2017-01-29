package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tile.TileEntityHothCeilingLight2;
import com.parzivail.util.basic.PBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/29/2017.
 */
public class BlockHothCeilingLight2 extends PBlock implements ITileEntityProvider
{
	public BlockHothCeilingLight2()
	{
		super("hothceilinglight2", Material.IRON);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityHothCeilingLight2();
	}
}
