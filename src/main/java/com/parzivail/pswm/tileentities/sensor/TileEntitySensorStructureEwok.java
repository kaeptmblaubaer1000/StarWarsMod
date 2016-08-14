package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobEwok;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureEwok extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureEwok()
	{
		this.rX = 50;
		this.rY = 3;
		this.rZ = 50;
		this.entityMax = 5;
	}

	public EntityLiving getNewEntity()
	{
		return new MobEwok(this.worldObj);
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobEwok.class;
	}
}
