package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureJawa;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorJawa extends BlockSensor
{
	public BlockSensorJawa()
	{
		super("jawa");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureJawa();
	}
}
