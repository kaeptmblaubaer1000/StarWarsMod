package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityScootemaroundHoth;
import com.parzivail.pswm.vehicles.VehicScootemaroundHoth;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityScootemaroundHoth extends BlockSensor
{
	public BlockSensorEntityScootemaroundHoth()
	{
		super(VehicScootemaroundHoth.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityScootemaroundHoth();
	}
}
