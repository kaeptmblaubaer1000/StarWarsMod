package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityTIEBomber;
import com.parzivail.pswm.vehicles.VehicTIEBomber;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityTIEBomber extends BlockSensor
{
	public BlockSensorEntityTIEBomber()
	{
		super(VehicTIEBomber.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityTIEBomber();
	}
}
