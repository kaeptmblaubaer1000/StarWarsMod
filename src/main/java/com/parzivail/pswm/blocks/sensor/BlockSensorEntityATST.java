package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityATST;
import com.parzivail.pswm.vehicles.VehicATST;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityATST extends BlockSensor
{
	public BlockSensorEntityATST()
	{
		super(VehicATST.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityATST();
	}
}
