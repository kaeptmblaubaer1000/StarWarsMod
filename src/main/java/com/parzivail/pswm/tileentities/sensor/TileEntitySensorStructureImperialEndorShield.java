package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobImperialOfficer;
import com.parzivail.pswm.mobs.trooper.MobScouttrooper;
import com.parzivail.pswm.mobs.trooper.MobTrooper;

public class TileEntitySensorStructureImperialEndorShield extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialEndorShield()
	{
		this.rX = 10;
		this.rY = 10;
		this.rZ = 10;
		this.entityMax = 5;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(2))
		{
			case 0:
				return new MobScouttrooper(this.worldObj);
			case 1:
				return new MobImperialOfficer(this.worldObj);
			default:
				return null;
		}
	}
}
