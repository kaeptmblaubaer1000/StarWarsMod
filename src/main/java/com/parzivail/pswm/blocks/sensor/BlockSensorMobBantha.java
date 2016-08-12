package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.mobs.MobBantha;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorMobBantha;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorMobBantha extends BlockSensor
{
	public BlockSensorMobBantha()
	{
		super(MobBantha.class.getSimpleName());
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorMobBantha();
	}
}
