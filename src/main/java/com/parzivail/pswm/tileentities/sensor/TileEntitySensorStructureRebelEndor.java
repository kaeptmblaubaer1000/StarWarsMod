package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobEndorRebel;
import com.parzivail.pswm.mobs.trooper.MobRebelTechnician;
import com.parzivail.pswm.mobs.trooper.MobRebelWorker;
import com.parzivail.pswm.mobs.trooper.MobTrooper;

public class TileEntitySensorStructureRebelEndor extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelEndor()
	{
		this.rX = 30;
		this.rY = 30;
		this.rZ = 30;
		this.entityMax = 10;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(3))
		{
			case 0:
				return new MobRebelWorker(this.worldObj);
			case 1:
				return new MobRebelTechnician(this.worldObj);
			case 2:
				return new MobEndorRebel(this.worldObj);
			default:
				return null;
		}
	}
}
