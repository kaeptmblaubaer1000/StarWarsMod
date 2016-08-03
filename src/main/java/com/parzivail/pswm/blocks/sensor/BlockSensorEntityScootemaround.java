package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityScootemaround;
import com.parzivail.pswm.vehicles.VehicScootemaround;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityScootemaround extends BlockSensor
{
	public BlockSensorEntityScootemaround()
	{
		super(VehicScootemaround.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityScootemaround();
	}
}
