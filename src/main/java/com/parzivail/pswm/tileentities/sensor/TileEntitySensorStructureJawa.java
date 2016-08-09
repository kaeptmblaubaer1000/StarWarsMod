package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobJawa;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureJawa extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureJawa()
	{
		this.rX = 30;
		this.rY = 30;
		this.rZ = 30;
		this.entityMax = 5;
	}

	public EntityLiving getNewEntity()
	{
		return new MobJawa(this.worldObj);
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobJawa.class;
	}
}
