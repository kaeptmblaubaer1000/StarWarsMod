package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobWookiee;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureWookiee extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureWookiee()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 10;
	}

	public EntityLiving getNewEntity()
	{
		return new MobWookiee(this.worldObj);
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobWookiee.class;
	}
}
