package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.mobs.MobDewback;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorMobDewback;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorMobDewback extends BlockSensor
{
	public BlockSensorMobDewback()
	{
		super(MobDewback.class.getSimpleName());
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorMobDewback();
	}
}
