package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityTIEAdvanced;
import com.parzivail.pswm.vehicles.VehicTIEAdvanced;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityTIEAdvanced extends BlockSensor
{
	public BlockSensorEntityTIEAdvanced()
	{
		super(VehicTIEAdvanced.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityTIEAdvanced();
	}
}
