package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureRebelMassassi;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorRebelMassassi extends BlockSensor
{
	public BlockSensorRebelMassassi()
	{
		super("rebelMassassi");
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureRebelMassassi();
	}
}
