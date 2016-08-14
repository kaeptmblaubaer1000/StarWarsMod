package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobJawa;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureJawa extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureJawa()
	{
		this.rX = 25;
		this.rY = 3;
		this.rZ = 25;
		this.entityMax = 8;
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
