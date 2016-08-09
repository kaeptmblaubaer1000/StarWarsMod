package com.parzivail.pswm.tileentities.sensor;

import com.parzivail.pswm.mobs.trooper.MobHothRebel;
import com.parzivail.pswm.mobs.trooper.MobRebelTechnician;
import com.parzivail.pswm.mobs.trooper.MobRebelWorker;
import com.parzivail.pswm.mobs.trooper.MobTrooper;
import net.minecraft.entity.EntityLiving;

public class TileEntitySensorStructureRebelHothGenerator extends TileEntitySensorPeoplePlace
{
	public TileEntitySensorStructureRebelHothGenerator()
	{
		this.rX = 30;
		this.rY = 30;
		this.rZ = 30;
		this.entityMax = 5;
	}

	public MobTrooper getNewEntity()
	{
		switch (this.worldObj.rand.nextInt(3))
		{
			case 0:
				return new MobHothRebel(this.worldObj);
			case 1:
				return new MobRebelTechnician(this.worldObj);
			case 2:
				return new MobRebelWorker(this.worldObj);
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
