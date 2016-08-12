package com.parzivail.pswm.blocks.sensor;

import com.parzivail.pswm.blocks.BlockSensor;
import com.parzivail.pswm.tileentities.sensor.TileEntitySensorStructureRebelHothGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorRebelHothGenerator extends BlockSensor
{
	public BlockSensorRebelHothGenerator()
	{
		super("rebelHothGen");
		this.setCreativeTab(null);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorStructureRebelHothGenerator();
	}
}
