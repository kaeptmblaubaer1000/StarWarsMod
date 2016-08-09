package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.*;

public class TileEntitySensorStructureImperialHoth extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialHoth()
	{
		this.rX = 20;
		this.rY = 20;
		this.rZ = 20;
		this.entityMax = 15;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(4))
		{
			case 0:
				return new MobSnowtrooper(this.worldObj);
			case 1:
				return new MobAtstPilot(this.worldObj);
			case 2:
				return new MobAtatPilot(this.worldObj);
			case 3:
				return new MobImperialOfficer(this.worldObj);
			default:
				return null;
		}
	}
}
