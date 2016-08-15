package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.*;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureTatooineCommoner extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureTatooineCommoner()
	{
		this.rX = 30;
		this.rY = 3;
		this.rZ = 30;
		this.entityMax = 5;
		this.otherMax = 2;
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

	@Override
	public EntityLiving getNewEntityOther()
	{
		switch (this.worldObj.rand.nextInt(4))
		{
			case 0:
				return new MobDroidAstromech2(this.worldObj);
			case 1:
				return new MobDroidGNK(this.worldObj);
			case 2:
				return new MobDroidMouse(this.worldObj);
			default:
				return null;
		}
	}

	@Override
	public Class<? extends EntityLiving> getEntityNeedleClassOther()
	{
		return EntityDroidBase.class;
	}
}
