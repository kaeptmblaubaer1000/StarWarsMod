package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureImperialHoth;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorImperialHoth extends BlockSensor
{
	public BlockSensorImperialHoth()
	{
		super("rebelImperialHoth");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureImperialHoth();
	}
}
