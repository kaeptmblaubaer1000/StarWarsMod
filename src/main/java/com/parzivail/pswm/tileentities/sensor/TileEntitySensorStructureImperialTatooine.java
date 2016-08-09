package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobImperialOfficer;
import com.parzivail.pswm.mobs.trooper.MobSandtrooper;
import com.parzivail.pswm.mobs.trooper.MobTrooper;

public class TileEntitySensorStructureImperialTatooine extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialTatooine()
	{
		this.rX = 20;
		this.rY = 20;
		this.rZ = 20;
		this.entityMax = 12;
	}

	public MobTrooper getNewTrooper()
	{
		switch (this.worldObj.rand.nextInt(2))
		{
			case 0:
				return new MobSandtrooper(this.worldObj);
			case 1:
				return new MobImperialOfficer(this.worldObj);
			default:
				return null;
		}
	}
}
