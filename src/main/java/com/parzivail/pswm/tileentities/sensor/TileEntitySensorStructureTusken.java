package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobTusken;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureTusken extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureTusken()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 5;
	}

	public EntityLiving getNewEntity()
	{
		return new MobTusken(this.worldObj);
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTusken.class;
	}
}
