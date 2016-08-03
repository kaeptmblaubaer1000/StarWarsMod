package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityXWing;
import com.parzivail.pswm.vehicles.VehicXWing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityXWing extends BlockSensor
{
	public BlockSensorEntityXWing()
	{
		super(VehicXWing.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityXWing();
	}
}
