package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureWookiee;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorWookiee extends BlockSensor
{
	public BlockSensorWookiee()
	{
		super("wookiee");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureWookiee();
	}
}
