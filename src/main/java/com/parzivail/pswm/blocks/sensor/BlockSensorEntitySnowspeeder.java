package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntitySnowspeeder;
import com.parzivail.pswm.vehicles.VehicSnowspeeder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntitySnowspeeder extends BlockSensor
{
	public BlockSensorEntitySnowspeeder()
	{
		super(VehicSnowspeeder.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntitySnowspeeder();
	}
}
