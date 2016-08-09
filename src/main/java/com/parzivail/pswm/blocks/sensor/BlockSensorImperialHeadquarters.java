package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureImperialHeadquarters;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorImperialHeadquarters extends BlockSensor
{
	public BlockSensorImperialHeadquarters()
	{
		super("imperialHeadquarters");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureImperialHeadquarters();
	}
}
