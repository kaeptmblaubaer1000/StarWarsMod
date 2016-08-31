package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.vehicles.VehicATST;

public class TileEntitySensorAtst extends TileEntitySensor
{
	private int rX;
	private int rY;
	private int rZ;

	public TileEntitySensorAtst()
	{
		this.rX = 60;
		this.rY = 20;
		this.rZ = 60;
	}

	@Override
	public boolean checkCondition()
	{
		return this.worldObj != null && !this.worldObj.getEntitiesWithinAABB(VehicATST.class, this.bb.expand(rX, rY, rZ)).isEmpty();
	}
}
