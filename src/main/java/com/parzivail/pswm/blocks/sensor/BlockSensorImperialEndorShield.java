package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureImperialEndorShield;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorImperialEndorShield extends BlockSensor
{
	public BlockSensorImperialEndorShield()
	{
		super("rebelImperialShieldGen");
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureImperialEndorShield();
	}
}
