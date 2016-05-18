package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tileentities.TileEntitySensorXWing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorXWing extends BlockSensor
{
	public BlockSensorXWing()
	{
		super("xwing");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorXWing();
	}
}
