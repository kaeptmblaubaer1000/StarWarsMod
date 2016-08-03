package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityHothSpeederBike;
import com.parzivail.pswm.vehicles.VehicHothSpeederBike;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityHothSpeederBike extends BlockSensor
{
	public BlockSensorEntityHothSpeederBike()
	{
		super(VehicHothSpeederBike.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityHothSpeederBike();
	}
}
