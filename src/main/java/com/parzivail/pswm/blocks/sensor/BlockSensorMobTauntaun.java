package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.mobs.MobTauntaun;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorMobTauntaun;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorMobTauntaun extends BlockSensor
{
	public BlockSensorMobTauntaun()
	{
		super(MobTauntaun.class.getSimpleName());
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorMobTauntaun();
	}
}
