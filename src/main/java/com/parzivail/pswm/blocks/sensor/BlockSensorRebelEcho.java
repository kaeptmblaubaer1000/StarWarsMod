package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureRebelEcho;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorRebelEcho extends BlockSensor
{
	public BlockSensorRebelEcho()
	{
		super("rebelEcho");
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureRebelEcho();
	}
}
