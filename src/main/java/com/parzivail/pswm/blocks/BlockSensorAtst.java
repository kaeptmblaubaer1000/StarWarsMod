package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tileentities.TileEntitySensorAtst;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorAtst extends BlockSensor
{
	public BlockSensorAtst()
	{
		super("QuestAtst");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorAtst(40, 40, 40);
	}
}
