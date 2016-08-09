package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureTusken;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorTusken extends BlockSensor
{
	public BlockSensorTusken()
	{
		super("tusken");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureTusken();
	}
}
