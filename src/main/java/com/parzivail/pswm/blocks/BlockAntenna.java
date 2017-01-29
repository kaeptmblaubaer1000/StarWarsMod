package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tile.TileEntityAntenna;
import com.parzivail.util.basic.PBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by colby on 1/29/2017.
 */
public class BlockAntenna extends PBlock implements ITileEntityProvider
{
	public BlockAntenna()
	{
		super("antenna", Material.IRON);
	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityAntenna();
	}
}
