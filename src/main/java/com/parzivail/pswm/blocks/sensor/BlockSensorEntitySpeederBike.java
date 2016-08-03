package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntitySpeederBike;
import com.parzivail.pswm.vehicles.VehicSpeederBike;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntitySpeederBike extends BlockSensor
{
	public BlockSensorEntitySpeederBike()
	{
		super(VehicSpeederBike.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntitySpeederBike();
	}
}
