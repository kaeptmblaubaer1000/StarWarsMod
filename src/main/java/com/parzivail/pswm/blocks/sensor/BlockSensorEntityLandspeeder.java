package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityLandspeeder;
import com.parzivail.pswm.vehicles.VehicLandspeeder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityLandspeeder extends BlockSensor
{
	public BlockSensorEntityLandspeeder()
	{
		super(VehicLandspeeder.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityLandspeeder();
	}
}
