package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobImperialOfficer;
import com.parzivail.pswm.mobs.trooper.MobSandtrooper;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureImperialTatooine extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureImperialTatooine()
	{
		this.rX = 30;
		this.rY = 30;
		this.rZ = 30;
		this.entityMax = 5;
	}

	public MobTrooper getNewEntity()
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

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTrooper.class;
	}
}
