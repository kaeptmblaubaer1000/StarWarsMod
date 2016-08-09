package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.*;

public class TileEntitySensorStructureRebelEcho extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelEcho()
	{
		this.rX = 20;
		this.rY = 20;
		this.rZ = 20;
		this.entityMax = 15;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(5))
		{
			case 0:
				return new MobRebelPilot(this.worldObj);
			case 1:
				return new MobRebelPilotA(this.worldObj);
			case 2:
				return new MobRebelPilotY(this.worldObj);
			case 3:
				return new MobRebelTechnician(this.worldObj);
			case 4:
				return new MobRebelWorker(this.worldObj);
			default:
				return null;
		}
	}
}
