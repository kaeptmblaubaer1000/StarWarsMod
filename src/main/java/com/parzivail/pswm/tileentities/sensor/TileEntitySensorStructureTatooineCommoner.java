package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.MobTatooineCommoner;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureTatooineCommoner extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureTatooineCommoner()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 5;
	}

	public EntityLiving getNewEntity()
	{
		return new MobTatooineCommoner(this.worldObj);
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClass()
	{
		return MobTatooineCommoner.class;
	}
}
