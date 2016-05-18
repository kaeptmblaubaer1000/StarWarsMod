package com.parzivail.pswm.blocks;

import com.parzivail.pswm.tileentities.TileEntitySensorEntity;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSensorEntity extends BlockSensor
{
	private Class<? extends Entity> entityClass;
	private int rX;
	private int rY;
	private int rZ;

	public BlockSensorEntity(Class<? extends Entity> entityClass, int rX, int rY, int rZ)
	{
		super(entityClass.getSimpleName());
		this.entityClass = entityClass;
		this.rX = rX;
		this.rY = rY;
		this.rZ = rZ;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntitySensorEntity(entityClass, rX, rY, rZ);
	}
}
