package com.parzivail.pswm.tileentities;

import com.parzivail.pswm.vehicles.VehicXWing;

public class TileEntitySensorXWing extends TileEntitySensor
{
	@Override
	boolean checkCondition()
	{
		boolean flag = this.worldObj != null && this.worldObj.getEntitiesWithinAABB(VehicXWing.class, this.bb.expand(0, 3, 0)).isEmpty();
		return flag;
	}

	@Override
	void runConditional()
	{
		if (!worldObj.isRemote)
		{
			VehicXWing newVehic = new VehicXWing(this.worldObj);
			newVehic.setPosition(this.xCoord + 0.5D, this.yCoord + 1, this.zCoord + 0.5D);
			this.worldObj.spawnEntityInWorld(newVehic);
		}
	}
}
