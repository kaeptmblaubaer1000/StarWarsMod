package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.mobs.MobWampa;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorMobWampa;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorMobWampa extends BlockSensor
{
	public BlockSensorMobWampa()
	{
		super(MobWampa.class.getSimpleName());
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorMobWampa();
	}
}
