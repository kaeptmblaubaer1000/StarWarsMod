package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityAWing;
import com.parzivail.pswm.vehicles.VehicAWing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityAWing extends BlockSensor
{
	public BlockSensorEntityAWing()
	{
		super(VehicAWing.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityAWing();
	}
}
