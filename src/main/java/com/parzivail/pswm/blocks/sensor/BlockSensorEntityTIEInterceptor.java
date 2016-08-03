package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityTIEInterceptor;
import com.parzivail.pswm.vehicles.VehicTIEInterceptor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityTIEInterceptor extends BlockSensor
{
	public BlockSensorEntityTIEInterceptor()
	{
		super(VehicTIEInterceptor.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityTIEInterceptor();
	}
}
