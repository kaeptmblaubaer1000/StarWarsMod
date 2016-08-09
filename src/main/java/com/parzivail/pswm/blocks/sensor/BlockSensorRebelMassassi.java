package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorRebelMassassi;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorRebelMassassi extends BlockSensor
{
	public BlockSensorRebelMassassi()
	{
		super("rebelMassassi");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorRebelMassassi();
	}
}
