package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityTIE;
import com.parzivail.pswm.vehicles.VehicTIE;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityTIE extends BlockSensor
{
	public BlockSensorEntityTIE()
	{
		super(VehicTIE.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityTIE();
	}
}
