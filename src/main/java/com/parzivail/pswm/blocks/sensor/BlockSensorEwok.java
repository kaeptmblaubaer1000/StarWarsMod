package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureEwok;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEwok extends BlockSensor
{
	public BlockSensorEwok()
	{
		super("ewok");
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureEwok();
	}
}
