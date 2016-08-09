package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureTatooineCommoner;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorTatooineCommoner extends BlockSensor
{
	public BlockSensorTatooineCommoner()
	{
		super("tatooineCommoner");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureTatooineCommoner();
	}
}
