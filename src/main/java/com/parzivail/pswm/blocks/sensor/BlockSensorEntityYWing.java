package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityYWing;
import com.parzivail.pswm.vehicles.VehicYWing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityYWing extends BlockSensor
{
	public BlockSensorEntityYWing()
	{
		super(VehicYWing.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityYWing();
	}
}
