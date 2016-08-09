package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobHothRebel;
import com.parzivail.pswm.mobs.trooper.MobRebelTechnician;
import com.parzivail.pswm.mobs.trooper.MobRebelWorker;
import com.parzivail.pswm.mobs.trooper.MobTrooper;

public class TileEntitySensorStructureRebelHothGenerator extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelHothGenerator()
	{
		this.rX = 15;
		this.rY = 15;
		this.rZ = 15;
		this.entityMax = 10;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(3))
		{
			case 0:
				return new MobHothRebel(this.worldObj);
			case 1:
				return new MobRebelTechnician(this.worldObj);
			case 2:
				return new MobRebelWorker(this.worldObj);
			default:
				return null;
		}
	}
}
