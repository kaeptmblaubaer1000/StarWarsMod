package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.vehicles.VehicATST;

public class TileEntitySensorAtst extends TileEntitySensor
{
	private int rX;
	private int rY;
	private int rZ;

	public TileEntitySensorAtst(int rX, int rY, int rZ)
	{
		this.rX = rX;
		this.rY = rY;
		this.rZ = rZ;
	}

	@Override
	public boolean checkCondition()
	{
		return this.worldObj != null && !this.worldObj.getEntitiesWithinAABB(VehicATST.class, this.bb.expand(rX, rY, rZ)).isEmpty();
	}
}
