package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntitySkyhopper;
import com.parzivail.pswm.vehicles.VehicSkyhopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntitySkyhopper extends BlockSensor
{
	public BlockSensorEntitySkyhopper()
	{
		super(VehicSkyhopper.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntitySkyhopper();
	}
}
