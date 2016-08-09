package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.*;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureImperialHoth extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialHoth()
	{
		this.rX = 3;
		this.rY = 3;
		this.rZ = 3;
		this.entityMax = 5;
	}

	public MobTrooper getNewEntity()
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

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTrooper.class;
	}
}
