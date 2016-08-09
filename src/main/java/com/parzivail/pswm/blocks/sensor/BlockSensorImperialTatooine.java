package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureImperialTatooine;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorImperialTatooine extends BlockSensor
{
	public BlockSensorImperialTatooine()
	{
		super("rebelImperialTatooine");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureImperialTatooine();
	}
}
