package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorEntityJakkuSpeeder;
import com.parzivail.pswm.vehicles.VehicJakkuSpeeder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntityJakkuSpeeder extends BlockSensor
{
	public BlockSensorEntityJakkuSpeeder()
	{
		super(VehicJakkuSpeeder.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntityJakkuSpeeder();
	}
}
